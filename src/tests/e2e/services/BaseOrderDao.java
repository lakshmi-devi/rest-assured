package tests.e2e.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import tests.e2e.integration.initiApis.GetAssemblyCatalogue;
import tests.e2e.integration.initiApis.GetPartsCatalogue;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.module.Archived;
import tests.e2e.module.BaseDelivery;
import tests.e2e.module.Baseorder;
import tests.e2e.module.Category;
import tests.e2e.module.Created;
import tests.e2e.module.CreatedFrom;
import tests.e2e.module.DefaultRunNew;
import tests.e2e.module.EffectiveOwner;
import tests.e2e.module.FTD;
import tests.e2e.module.Items;
import tests.e2e.module.LastModified;
import tests.e2e.module.LeadDates;
import tests.e2e.module.Manager;
import tests.e2e.module.Memos;
import tests.e2e.module.Owner;
import tests.e2e.module.Project;
import tests.e2e.module.Tag;
import tests.e2e.module.Vendor;
import tests.e2e.staticKeys.Statickeys;

public class BaseOrderDao {

	static String[] key = { Statickeys.archived, Statickeys.assignedTo, Statickeys.isDirty, Statickeys.kind,
			Statickeys.needsToAttachId, Statickeys.sources, Statickeys.value, Statickeys.stage, Statickeys.uuid };

	static HashMap<String, Object> payloadSimpleDates = new HashMap<>();
	static HashMap<String, Object> payloadSimpleFiles = new HashMap<>();
	static HashMap<String, Object> payloadSimpleMemos = new HashMap<>();
	static HashMap<String, Object> payloadSimpleTodos = new HashMap<>();
	static ArrayList<Object> payloadDates = new ArrayList<>();

	public static Baseorder setStagePayload(String stage, Baseorder payload) {
		payload.setStage(stage);
		payload.set_customStage(stage);
		return payload;
	}

	public static Baseorder getCreateUpdatePayload(String requestType, String stage, Baseorder response,
			HashMap<String, Object> params) throws Exception {

		if (params != null && !params.containsKey(Statickeys.fromTemplate)) {
			params.put(Statickeys.fromTemplate, false);
		}
		/* Initialization local variables */

		String kitId = "Kit- " + Helper.getRandomNumber(2000) + Helper.getRandomNumber(2000);

		/* Get Order name */
		int randomNum = Helper.getRandomNumber((Helper.getPOOrderName().size()));
		String orderName = Helper.getPOOrderName().get(randomNum) + " - " + Helper.getUtcTimeZone();

		String leastStage = null;
		leastStage = params != null && params.containsKey(Statickeys.leastStage)
				? (String) params.get(Statickeys.leastStage)
				: null;

		String __t = params != null && params.containsKey(Statickeys.__t) && params.get(Statickeys.__t) != null
				? (String) params.get(Statickeys.__t)
				: null;
		String payloadStage = params != null && params.containsKey(Statickeys.stage)
				&& params.get(Statickeys.stage) != null ? (String) params.get(Statickeys.stage) : null;
		String customStage = params != null && params.containsKey(Statickeys._customStage)
				&& params.get(Statickeys._customStage) != null ? (String) params.get(Statickeys._customStage) : null;
		boolean fromTemplateOrder = params != null && params.containsKey(Statickeys.fromTemplate)
				&& params.get(Statickeys.fromTemplate) != null ? (boolean) params.get(Statickeys.fromTemplate) : null;

		/* Payload object */
		Baseorder payload = new Baseorder();

		if (params.containsKey(Statickeys.moveToPO) || (params.containsKey(Statickeys.moveToQA))) {
			payload.setUpdateAfterCreation(true);
		}

		/* Base Delivery Section */
		if (stage == Statickeys.planning || stage == Statickeys.coordination || stage == Statickeys.detailing
				|| stage == Statickeys.manufacturing || params.containsKey(Statickeys.moveToPO)
				|| !params.containsKey(Statickeys.moveToQA)) {
			payload.setBaseDelivery(new BaseDelivery());
		} else if (stage == Statickeys.requesting || stage == Statickeys.sourcing || stage == Statickeys.ordering) {
			BaseDelivery basedelivery = BaseDeliveryDao.getBaseDeliveryDAO();
			payload.setBaseDelivery(basedelivery);
		}

		/* Set name for create call only */
		if (requestType != Statickeys.update) {
			int randomNumber;
			if (stage != Statickeys.requesting && stage != Statickeys.ordering && stage != Statickeys.sourcing) {
				payload.setName(orderName);
			} else {
				randomNumber = Helper.getRandomNumber((Helper.getMMOrderName().size()));
				payload.setName(Helper.getMMOrderName().get(randomNumber) + " - " + Helper.getUtcTimeZone());
			}
			payload.setCreatedVia(Statickeys.automation);
//			payload.setUpdatedVia(Statickeys.automation);
		} else {
			payload.setName(response.getName());
		}

		/* STAGE SECTION */
		payload.setStage(payloadStage);
		payload.set_customStage(customStage);
		payload.setWeldInches((double) Helper.getRandomNumber(100));

		/* FTD Section */

		if (requestType == Statickeys.update) {
			payloadDates.clear();
			payloadSimpleDates.clear();
			payloadSimpleFiles.clear();
			payloadSimpleMemos.clear();
			payloadSimpleTodos.clear();
		}

		ArrayList source = new ArrayList();

		if (stage == Statickeys.planning && !params.containsKey(Statickeys.purpose)) {
			source.add(sourceDao.getSourcesdDAO(response != null ? response.get_id() : " ", "prefabs", "planning"));
		} else if (params.containsKey(Statickeys.purpose)) {
			source.add(sourceDao.getSourcesdDAO(response != null ? response.get_id() : "order", "prefabs", "planning"));
		} else if (stage == Statickeys.requesting) {
			source.add(sourceDao.getSourcesdDAO(response != null ? response.get_id() : "order", "material",
					"preparation"));
		} else if (stage == Statickeys.coordination) {
			source.add(sourceDao.getSourcesdDAO("", "order", "coordination"));
		} else if (stage == Statickeys.detailing) {
			source.add(sourceDao.getSourcesdDAO("", "order", "detailing"));
		} else if (stage == Statickeys.manufacturing
				|| (stage == Statickeys.manufacturing && params.containsKey(Statickeys.moveToManuf))) {
			source.add(sourceDao.getSourcesdDAO("", "order", "manufacturing"));
		} else if (stage == Statickeys.coordination && params.containsKey(Statickeys.moveToPO)) {
			source.add(sourceDao.getSourcesdDAO(response != null ? response.get_id() : " ", "order", "coordination"));
		} else if (stage == Statickeys.qa && params.containsKey(Statickeys.moveToQA)) {
			source.add(sourceDao.getSourcesdDAO(response != null ? response.get_id() : " ", "order", "coordination"));
		} else if (stage == Statickeys.sourcing) {
			source.add(
					sourceDao.getSourcesdDAO(response != null ? response.get_id() : "order", "sourcing", "sourcing"));
		} else if (stage == Statickeys.ordering) {
			source.add(sourceDao.getSourcesdDAO(response != null ? response.get_id() : "order", "sourcing", stage));
		}

		if ((stage == Statickeys.planning || stage == Statickeys.coordination)
				&& !params.containsKey(Statickeys.purpose)) {
			String coorValue = params.containsKey(Statickeys.coord) ? (String) params.get(Statickeys.coord)
					: Helper.getUtcTimeZone(0);
			String deliverValue = params.containsKey(Statickeys.deliver) ? (String) params.get(Statickeys.deliver)
					: Helper.getUtcTimeZone(0);

			Object[] dateValues = { getDateObjectValue(Statickeys.coord, Statickeys.planning, source, coorValue),
					getDateObjectValue(Statickeys.deliver, Statickeys.planning, source, deliverValue) };

			addDatesToFTD(dateValues);

		} else if (stage == Statickeys.coordination && params.containsKey(Statickeys.moveToPO)) {
			String coorValue = params.containsKey(Statickeys.coord) ? (String) params.get(Statickeys.coord)
					: Helper.getUtcTimeZone(0);
			String deliverValue = params.containsKey(Statickeys.deliver) ? (String) params.get(Statickeys.deliver)
					: Helper.getUtcTimeZone(0);

			Object[] dateValues = { getDateObjectValue(Statickeys.coord, Statickeys.coordination, source, coorValue),
					getDateObjectValue(Statickeys.deliver, Statickeys.coordination, source, deliverValue) };

			addDatesToFTD(dateValues);

		} else if (stage == Statickeys.detailing) {

			String deliverValue = params.containsKey(Statickeys.deliver) ? (String) params.get(Statickeys.deliver)
					: Helper.getUtcTimeZone(0);
			String poDetailiByvalue = params.containsKey(Statickeys.poDetailBy)
					? (String) params.get(Statickeys.poDetailBy)
					: Helper.getUtcTimeZone(0);
			Object[] dateValues = { getDateObjectValue(Statickeys.deliver, Statickeys.planning, source, deliverValue),
					getDateObjectValue(Statickeys.poDetailBy, Statickeys.detailing, source, poDetailiByvalue) };
			addDatesToFTD(dateValues);

		} else if (stage == Statickeys.manufacturing && params.containsKey(Statickeys.moveToManuf)) {

			String coorValue = params.containsKey(Statickeys.coord) ? (String) params.get(Statickeys.coord)
					: Helper.getUtcTimeZone(0);
			String deliverValue = params.containsKey(Statickeys.deliver) ? (String) params.get(Statickeys.deliver)
					: Helper.getUtcTimeZone(0);
			String coordAtValue = params.containsKey(Statickeys.coordedAt) ? (String) params.get(Statickeys.coordedAt)
					: Helper.getUtcTimeZone(0);
			String detailByValue = params.containsKey(Statickeys.detailBy) ? (String) params.get(Statickeys.detailBy)
					: Helper.getUtcTimeZone(0);
			String manufactureValue = params.containsKey(Statickeys.manufactureBy)
					? (String) params.get(Statickeys.manufactureBy)
					: Helper.getUtcTimeZone(0);
			String detailAtValue = params.containsKey(Statickeys.detailedAt)
					? (String) params.get(Statickeys.detailedAt)
					: Helper.getUtcTimeZone(0);

			Object[] dateValues = { getDateObjectValue(Statickeys.coord, Statickeys.coordination, source, coorValue),
					getDateObjectValue(Statickeys.deliver, Statickeys.coordination, source, deliverValue),
					getDateObjectValue(Statickeys.coordedAt, Statickeys.detailing, source, coordAtValue),
					getDateObjectValue(Statickeys.detailBy, Statickeys.detailing, source, detailByValue),
					getDateObjectValue(Statickeys.manufactureBy, Statickeys.detailing, source, manufactureValue),
					getDateObjectValue(Statickeys.detailedAt, Statickeys.manufacturing, source, detailAtValue), };

			addDatesToFTD(dateValues);
		} else if (stage == Statickeys.manufacturing && !params.containsKey(Statickeys.moveToManuf)) {

			String deliverValue = params.containsKey(Statickeys.deliver) ? (String) params.get(Statickeys.deliver)
					: Helper.getUtcTimeZone(0);
			String manufactureValue = params.containsKey(Statickeys.poManufactureBy)
					? (String) params.get(Statickeys.poManufactureBy)
					: Helper.getUtcTimeZone(0);
			Object[] dateValues = { getDateObjectValue(Statickeys.deliver, Statickeys.planning, source, deliverValue),
					getDateObjectValue(Statickeys.poManufactureBy, Statickeys.manufacturing, source,
							manufactureValue) };

			addDatesToFTD(dateValues);
		} else if (stage == Statickeys.qa && params.containsKey(Statickeys.moveToQA)) {

			String coorValue = params.containsKey(Statickeys.coord) ? (String) params.get(Statickeys.coord)
					: Helper.getUtcTimeZone(0);
			String deliverValue = params.containsKey(Statickeys.deliver) ? (String) params.get(Statickeys.deliver)
					: Helper.getUtcTimeZone(0);
			String poDetailByValue = params.containsKey(Statickeys.poDetailBy)
					? (String) params.get(Statickeys.poDetailBy)
					: Helper.getUtcTimeZone(0);
			String poManufactureByValue = params.containsKey(Statickeys.poManufactureBy)
					? (String) params.get(Statickeys.poManufactureBy)
					: Helper.getUtcTimeZone(0);
			String coordedAtValue = params.containsKey(Statickeys.coordedAt) ? (String) params.get(Statickeys.coordedAt)
					: Helper.getUtcTimeZone(0);
			String detailByValue = params.containsKey(Statickeys.detailBy) ? (String) params.get(Statickeys.detailBy)
					: Helper.getUtcTimeZone(0);
			String manufactureByValue = params.containsKey(Statickeys.manufactureBy)
					? (String) params.get(Statickeys.manufactureBy)
					: Helper.getUtcTimeZone(0);
			String detailedAtValue = params.containsKey(Statickeys.detailedAt)
					? (String) params.get(Statickeys.detailedAt)
					: Helper.getUtcTimeZone(0);
			String qaByValue = params.containsKey(Statickeys.qaBy) ? (String) params.get(Statickeys.qaBy)
					: Helper.getUtcTimeZone(0);
			String manufacturedAtValue = params.containsKey(Statickeys.manufacturedAt)
					? (String) params.get(Statickeys.manufacturedAt)
					: Helper.getUtcTimeZone(0);

			Object[] dateValues = { getDateObjectValue(Statickeys.coord, Statickeys.coordination, source, coorValue),
					getDateObjectValue(Statickeys.deliver, Statickeys.coordination, source, deliverValue),
					getDateObjectValue(Statickeys.poDetailBy, Statickeys.coordination, source, poDetailByValue),
					getDateObjectValue(Statickeys.poManufactureBy, Statickeys.coordination, source,
							poManufactureByValue),
					getDateObjectValue(Statickeys.coordedAt, Statickeys.coordination, source, coordedAtValue),
					getDateObjectValue(Statickeys.detailBy, Statickeys.coordination, source, detailByValue),
					getDateObjectValue(Statickeys.manufactureBy, Statickeys.coordination, source, manufactureByValue),
					getDateObjectValue(Statickeys.detailedAt, Statickeys.coordination, source, detailedAtValue),
					getDateObjectValue(Statickeys.qaBy, Statickeys.coordination, source, qaByValue), 
					getDateObjectValue(Statickeys.manufacturedAt, Statickeys.coordination, source, manufacturedAtValue), };

			addDatesToFTD(dateValues);

		} else if (params.containsKey(Statickeys.purpose)) {
			String coorValue = params.containsKey(Statickeys.coord) ? (String) params.get(Statickeys.coord)
					: Helper.getUtcTimeZone(0);
			String deliverValue = params.containsKey(Statickeys.deliver) ? (String) params.get(Statickeys.deliver)
					: Helper.getUtcTimeZone(0);
			String partsManufactureByValue = params.containsKey(Statickeys.partsManufactureBy)
					? (String) params.get(Statickeys.partsManufactureBy)
					: Helper.getUtcTimeZone(0);
			String poDetailByValue = params.containsKey(Statickeys.poDetailBy)
					? (String) params.get(Statickeys.poDetailBy)
					: Helper.getUtcTimeZone(0);
			String poManufactureByValue = params.containsKey(Statickeys.poManufactureBy)
					? (String) params.get(Statickeys.poManufactureBy)
					: Helper.getUtcTimeZone(0);
			String poQaByValue = params.containsKey(Statickeys.poQaBy) ? (String) params.get(Statickeys.poQaBy)
					: Helper.getUtcTimeZone(0);

			Object[] dateValues = { getDateObjectValue(Statickeys.coord, Statickeys.planning, source, coorValue),
					getDateObjectValue(Statickeys.deliver, Statickeys.planning, source, deliverValue),
					getDateObjectValue(Statickeys.partsManufactureBy, Statickeys.planning, source,
							partsManufactureByValue),
					getDateObjectValue(Statickeys.poDetailBy, Statickeys.planning, source, poDetailByValue),
					getDateObjectValue(Statickeys.poManufactureBy, Statickeys.planning, source, poManufactureByValue),
					getDateObjectValue(Statickeys.poQaBy, Statickeys.planning, source, poQaByValue), };

			addDatesToFTD(dateValues);

		} else if (stage == Statickeys.requesting || stage == Statickeys.sourcing || stage == Statickeys.ordering) {

			String deliverValue = params.containsKey(Statickeys.deliver) ? (String) params.get(Statickeys.deliver)
					: Helper.getUtcTimeZone(0);
			String orderByValue = params.containsKey(Statickeys.orderBy) ? (String) params.get(Statickeys.orderBy)
					: Helper.getUtcTimeZone(0);

			if (stage == Statickeys.sourcing) {
				Object[] dateValues = {
						getDateObjectValue(Statickeys.deliver, Statickeys.sourcing, source, deliverValue),
						getDateObjectValue(Statickeys.deliver, Statickeys.sourcing, source, orderByValue) };
				addDatesToFTD(dateValues);

			} else {
				Object[] dateValues = {
						getDateObjectValue(Statickeys.deliver, Statickeys.preparation, source, deliverValue),
						getDateObjectValue(Statickeys.deliver, Statickeys.preparation, source, orderByValue) };
				addDatesToFTD(dateValues);

			}

		}

//		payload.setDates(payloadDates);
		payload.setDates(payloadDates);
		payload.setSimpleDates(payloadSimpleDates);
		payload.setSimpleFiles(payloadSimpleFiles);
		payload.setSimpleMemos(payloadSimpleMemos);
		payload.setSimpleTodos(payloadSimpleTodos);

		/* General to all stage orders */
		payload.setPurpose(
				params.containsKey(Statickeys.purpose) ? (String) params.get(Statickeys.purpose) : Statickeys.general);
		payload.set_id(response.get_id());
		payload.setStatus(response.getStatus());
		payload.setProjectId(response.getProject().getId());
		payload.setCreatedFrom(CreatedFromDao.getCreatedFromDao(Statickeys.normal));
		payload.setCurrentNote(CurrentNoteDao.getCurrentNotesObject(""));
		if (params.containsKey(Statickeys.purpose)) {
			payload.setCustomId(response!= null && response.getCustomId() != null ? response.getCustomId() : kitId);
		} else {
			payload.setCustomId("");
		}
		payload.setDefaultRun(DefaultRunDaoNew.getDefaultRunDAO());
		payload.setEstHrs(0);
		payload.setExtraCost(0);
		payload.setFiles(new ArrayList<Object>());
		payload.setIdsMap(new ArrayList<String>());
		payload.setIsDefault(false);
		payload.setIsLocked(false);
		payload.setIsManager(false);
		payload.setTrackingEnabled(false);
		if (params.containsKey(Statickeys.moveToPO)) {
			payload.setOneOrderPerItem(true);
		}
		ArrayList<Items> itemsList = new ArrayList<>();
		if (response == null) {
			String purposeType = (String) params.get(Statickeys.purpose);
			String itemPurpose = purposeType == "kit" ? "assembly" : "general";
			ArrayList<HashMap<String, Object>> itemParmas = getItemParams(stage, requestType, response, itemPurpose);
			if (!params.containsKey(Statickeys.purpose) && (requestType == Statickeys.create)) {
				for (int i = 0; i < itemParmas.size(); i++) {
					HashMap<String, Object> itemParam = itemParmas.get(i);
					ItemsDao itemDao = new ItemsDao();
					Items item = itemDao.getItemDAO(itemParam);
					itemsList.add(item);
				}
			} else if (params.containsKey(Statickeys.purpose) && requestType == Statickeys.create) {
				ItemsDao itemDao1 = new ItemsDao();
				HashMap<String, Object> itemParams = new HashMap<>();
				itemParams.put(Statickeys.purpose, "kit");
				itemParams.put(Statickeys.name, orderName);
				Items i = itemDao1.getItemDAO(itemParams);
				itemsList.add(i);

				for (int k = 0; k < itemParmas.size(); k++) {
					try {
						HashMap<String, Object> itemParam = itemParmas.get(k);
						ItemsDao itemDao2 = new ItemsDao();
						Items item = itemDao2.getItemDAO(itemParam);
						itemsList.add(item);
					} catch (Exception e) {
						// TODO: handle exception
						System.err.println(e);
					}

				}
			}
		}
		if (itemsList.size() == 0 && !params.containsKey(Statickeys.moveToPO)
				&& !params.containsKey(Statickeys.moveToManuf) && !params.containsKey(Statickeys.moveToQA)) {
			payload.setItems(new ArrayList<Items>());
		} else if ((requestType == Statickeys.update && response.getItems() != null)
				|| (response != null && params.containsKey(Statickeys.moveToPO)
						|| (response != null && params.containsKey(Statickeys.moveToManuf))
						|| (response != null && params.containsKey(Statickeys.moveToQA)))) {
			payload.setItems((ArrayList<Items>) response.getItems());
		} else {
			payload.setItems(itemsList);
		}

		payload.setLeadDates(LeadDatesDao.getLeadDatesDAO());
		payload.setLeastStage(leastStage);
		if (stage == Statickeys.detailing || (stage == Statickeys.manufacturing)) {
			payload.setLocation(LocationDao.getBaseDeliveryLocationDAO());
		} else {
			payload.setLocation(null);
		}
		Manager manager;
		if (response != null && response.getManager() != null) {
			manager = response.getManager();
		} else {
			manager = ManagerDao.getManagerDao();
		}
		payload.setManager(manager);
		if (params.containsKey(Statickeys.moveToPO)) {
//			payload.setMemos(Memos.getMemos());
			ArrayList<Memos> memoList = new ArrayList<Memos>();
			memoList.add(MemosDao.getMemosDao(kitId, requestType, customStage));
			payload.setMemos(memoList);
		}

		else {
//			payload.setMemos(new ArrayList<FTD>());
			payload.setMemos(null);
		}

		payload.setMultiTrade(MultiTradeDao.getMultiTradeDAO(new ArrayList<FTD>(), false));

		payload.setOwner(OwnerDao.getOwnerDAO());
		Project proj = ProjectDao.getProjectDAO();
		payload.setProject(proj);
		payload.setStageUsed(Statickeys.all);
		payload.setTags(new ArrayList<Tag>());
		payload.setTemplateId("");
		payload.setTemplateName("");
		if (fromTemplateOrder) {
			String templateid = (String) DataStore.getInstance().getProperty(Statickeys.productionTemplateOrderId);
			payload.setTemplateOrder(templateid);
		}
		payload.setTodos(new ArrayList<FTD>());
		payload.setTotalCost(null);
		payload.set__t(__t);

		payload.set_excludedFields(new ArrayList<String>());

		if (stage == Statickeys.sourcing || stage == Statickeys.ordering) {
			payload.setNotFromRequisition(true);
			payload.setUpdatedVia(Statickeys.manual);
			payload.set_slimSave(true);
		}

		if (requestType == Statickeys.update && (stage == Statickeys.planning || stage == Statickeys.coordination
				|| stage == Statickeys.detailing || stage == Statickeys.manufacturing)) {

			payload.setArchived(ArchivedDao.getArchivedDAO(false));
			payload.setCreated(response.getCreated());
			payload.setEffectiveOwner(EffectiveOwnerDao.getEffectiveOwnerDAO());
			payload.setFromSchedule(false);
			payload.setHasReserved(false);
			payload.setId(response.getId());
			payload.setArchiveManager(new ArrayList<Object>());
			payload.setCatQtyMaps(new ArrayList<Object>());
//			payload.setKeywords(new ArrayList<Object>());

			if (params.containsKey(Statickeys.purpose)) {
				ArrayList<String> kitids = new ArrayList<String>();
				kitids.add(kitId);
				payload.setKitIds(response!= null && response.getKitIds().size() > 0 ? response.getKitIds() : kitids);
			} else {
				payload.setKitIds(new ArrayList<String>());
			}
			payload.setLastModified(LastModifiedDao.lastModifiedDAO());
//			payload.setLinkedCompanies(new ArrayList<Object>());
			payload.setLinkedCompanies(new ArrayList<Object>());
//			payload.setLinkedOrders(new ArrayList<Object>());
			payload.setLinkedOrders(new ArrayList<Object>());
//			payload.setNotes(new ArrayList<Object>());
			payload.setNotes(new ArrayList<Object>());
			payload.setNumberOfItems(response.getNumberOfItems());
			payload.setPoCreatedAt(null);
//			payload.setRevitGuids(new ArrayList<Object>());
			payload.setRevitGuids(new ArrayList<Object>());
			payload.setRunBaseTime(response.getRunBaseTime());
			payload.setSecondaryStatus(response.getSecondaryStatus());
			payload.setSearchText(response.getSearchText());
//			payload.setSource(new ArrayList<Object>());
			payload.setSource(new ArrayList<Object>());
			payload.setStageWeight(response.getStageWeight());
//			payload.setUpdatedVia(Statickeys.automation);
			payload.setVisibility(response.getVisibility());
			payload.set__v(response.get__v());
			payload.set_id(response.get_id());
			payload.setStatus(response.getStatus());

		}

		else if ((requestType == Statickeys.update || requestType == Statickeys.others)
				&& (stage == Statickeys.requesting || stage == Statickeys.sourcing || stage == Statickeys.ordering)) {

			payload.setArchived(ArchivedDao.getArchivedDAO(false));
			payload.setCreated(response.getCreated());
			BaseDelivery basedelivery = BaseDeliveryDao.getBaseDeliveryDAO();
			payload.setBaseDelivery(basedelivery);
			payload.setCreatedFrom(CreatedFromDao.getCreatedFromDao(Statickeys.normal));
			payload.setCurrentNote(CurrentNoteDao.getCurrentNotesObject(""));
			if (params.containsKey(Statickeys.purpose)) {
				payload.setCustomId(kitId);
			} else {
				payload.setCustomId("");
			}
			payload.setDefaultRun(DefaultRunDaoNew.getDefaultRunDAO());
			payload.setEffectiveOwner(EffectiveOwnerDao.getEffectiveOwnerDAO());
			payload.setFromSchedule(false);
			payload.setHasReserved(false);
			payload.setId(response.getId());
			payload.setKeywords(new ArrayList<Object>());
			if (params.containsKey(Statickeys.purpose)) {
				ArrayList<String> kitids = new ArrayList<String>();
				kitids.add(kitId);
				payload.setKitIds(kitids);
			} else {
				payload.setKitIds(new ArrayList<String>());
			}
			payload.setLastModified(LastModifiedDao.lastModifiedDAO());
			payload.setLeadDates(LeadDatesDao.getLeadDatesDAO());
			payload.setLinkedCompanies(new ArrayList<Object>());
			payload.setLinkedOrders(new ArrayList<Object>());
			payload.setNotes(new ArrayList<Object>());
			payload.setNumberOfItems(response.getNumberOfItems());
			payload.setPoCreatedAt(null);
			payload.setOwner(OwnerDao.getOwnerDAO());
			payload.setProject(ProjectDao.getProjectDAO());
			payload.setRevitGuids(new ArrayList<Object>());
			payload.setRunBaseTime(response.getRunBaseTime());
			payload.setSecondaryStatus(response.getSecondaryStatus());
			payload.setSearchText(response.getSearchText());
			payload.setSource(new ArrayList<Object>());
			payload.setStageWeight(response.getStageWeight());
			payload.setUpdatedVia(Statickeys.automation);
			payload.setVisibility(response.getVisibility());
			payload.setStageUsed(Statickeys.all);
//			payload.setTags(new ArrayList<String>());
			payload.setTags(new ArrayList<Tag>());
			payload.setTemplateId("");
			payload.setTemplateName("");
			payload.setTodos(new ArrayList<FTD>());
			payload.setTotalCost(null);
			payload.set__t(__t);
			payload.set__v(response.get__v());
			payload.set_id(response.get_id());
			payload.setStatus(response.getStatus());
		}
		if (requestType == Statickeys.others) {
			payload.setItems((ArrayList<Items>) response.getItems());
		}

		if (params.containsKey(Statickeys.moveToQA)) {
			payload.setQaBy(params.containsKey(Statickeys.qaBy) ? (String) params.get(Statickeys.qaBy)
					: Helper.getUtcTimeZone(0));
			payload.setLocation(LocationDao.getBaseDeliveryLocationDAO());
		}

		if (requestType == Statickeys.moveToPm) {
			payload.setCurrentNote(CurrentNoteDao.getCurrentNotesObject(""));
			payload.setDeliverDate(
					params.containsKey(Statickeys.deliverDate) ? (String) params.get(Statickeys.deliverDate)
							: Helper.getUtcTimeZone(0));
			payload.setLocation(LocationDao.getBaseDeliveryLocationDAO());
			payload.setManager(ManagerDao.getManagerDao());
			payload.setNotifyUsers(new ArrayList<Object>());
			payload.setOwner(OwnerDao.getOwnerDAO());
			payload.setPTrackEnabled(
					params.containsKey(Statickeys.pTrackEnabled) ? (boolean) params.get(Statickeys.pTrackEnabled)
							: true);
			payload.setPoDetailBy(params.containsKey(Statickeys.poDetailBy) ? (String) params.get(Statickeys.poDetailBy)
					: Helper.getUtcTimeZone(0));
			payload.setPoManufactureBy(
					params.containsKey(Statickeys.poManufactureBy) ? (String) params.get(Statickeys.poManufactureBy)
							: Helper.getUtcTimeZone(0));
			payload.setProject(ProjectDao.getProjectDAO());
			payload.set_id(response.get_id());
			payload.setPurpose(Statickeys.general);
			payload.setName(response.getName());
		}
		return payload;
	}

	static ArrayList<HashMap<String, Object>> getItemParams(String stage, String requestType, Baseorder response,
			String purpose) throws Exception {
		ArrayList<HashMap<String, Object>> itemParms = new ArrayList<>();
		ArrayList<String> itemList = null;
		if (stage != Statickeys.planning && stage != Statickeys.coordination && stage != Statickeys.detailing
				&& stage != Statickeys.manufacturing) {
			itemList = GetPartsCatalogue.getPartsForItem(DataSourceHelper.itemCount);
		} else {
			itemList = GetAssemblyCatalogue.getAssemblyForItem(DataSourceHelper.itemCount);
		}

		for (int i = 0; i < DataSourceHelper.itemCount; i++) {
			HashMap<String, Object> map = new HashMap<>();
			map.put(Statickeys.catId, itemList.get(i));
			if (stage == Statickeys.ordering) {
				map.put(Statickeys.stage, Statickeys.preparation);
			} else {
				map.put(Statickeys.stage, stage);
			}
			map.put(Statickeys.weldInches, Helper.getRandomNumber(100));

			Vendor vendor = (Vendor) DataStore.getInstance().getProperty(Statickeys.vendor);
			map.put(Statickeys.activeSupplier, vendor.getName());
			map.put(Statickeys.vendor, vendor);
			map.put(Statickeys.vendors, vendor);

			Category category = (Category) DataStore.getInstance().getProperty(Statickeys.categories);
			map.put("category", category);

			map.put("simpleDates", payloadSimpleDates);
			map.put(Statickeys.purpose, purpose);

			if (stage == Statickeys.preparation || stage == Statickeys.ordering || stage == Statickeys.sourcing) {
				map.put(Statickeys.baseCardType, "Materials");
//				if(requestType == Statickeys.update) {
//					materialItems materialItems = new materialItems();
//					materialItems.setItemId(requestType);
//					materialItems.setQty(1);
//					materialItems.setRootId(Helper.getUuid());
//					map.put("requestType", "Materials");
//				}
			}
			itemParms.add(map);
		}
		return itemParms;
	}

	static Object[] getDateObjectValue(String kind, String stage, ArrayList source, String date) throws Exception {

		Object[] value = new Object[] { ArchivedDao.getArchivedDAO(false), new HashMap<String, Object>(), true, kind,
				true, source, date, stage, Helper.getUuid() };

		return value;
	}

	static void addDatesToFTD(Object[] dateValues) throws Exception {
		for (Object dateSimples : dateValues) {
			payloadDates.add(FTDDao.getFTdMap(key, (Object[]) dateSimples));
			payloadSimpleDates.put(((Object[]) dateSimples)[3].toString(),
					FTDDao.getFTdMap(key, (Object[]) dateSimples));
		}
	}

	public static HashMap<String, Object> getShippingCreatePayload(Baseorder response) throws Exception {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("baseDelivery", BaseDeliveryDao.getBaseDeliveryDAO());
		map.put("currentNote", response.getCurrentNote());
		map.put("dates", response.getDates());

		ArrayList<String> itemIds = new ArrayList();
//		List<Items> itemsList = response.getItems();
//		for (Items items : itemsList) {
//			itemIds.add(items.getId());
//		}

		itemIds.add(response.getRunItemsCount().get(0).get_id());
		map.put("items", itemIds);
		map.put("name", response.getName());
		map.put("notes", response.getNotes());
		map.put("owner", response.getOwner());
		map.put("project", response.getProject());
		map.put("projectId", DataStore.getInstance().getProperty(Statickeys.projectId));
		map.put("stage", Statickeys.ordering);
		map.put("_id", response.get_id());

		return map;
	}

	public static Baseorder templateCreate(String requestType, String stage, Baseorder response,
			HashMap<String, Object> templateParams) throws Exception {
		try {
			Baseorder templatePayload = new Baseorder();
			int randomNumber = Helper.getRandomNumber((Helper.getPOOrderName().size()));
			String OrderName = Helper.getPOOrderName().get(randomNumber) + " - " + Helper.getUtcTimeZone();

			String leastStage = response != null && response.getLeastStage() != null ? response.getLeastStage()
					: (String) templateParams.get(Statickeys.leastStage);
			String __t = (response != null && response.get__t() != null) ? response.get__t()
					: (String) templateParams.get(Statickeys.__t);
			String payloadStage = response != null && response.getStage() != null ? response.getStage()
					: (String) templateParams.get(Statickeys.stage);
			String customStage = response != null && response.get_customStage() != null ? response.get_customStage()
					: (String) templateParams.get(Statickeys._customStage);

			if (requestType == Statickeys.create) {
				templatePayload.setName(OrderName);
				templatePayload.setTemplateId(Helper.randomNameBuilder("templateId"));
				templatePayload.setTemplateName(OrderName);
				templatePayload.setBaseDelivery(
						response != null && response.getBaseDelivery() != null ? response.getBaseDelivery()
								: new BaseDelivery());
				templatePayload.setCreatedFrom(
						response != null && response.getCreatedFrom() != null ? response.getCreatedFrom()
								: (CreatedFrom) CreatedFromDao.getCreatedFromDao(Statickeys.normal));
				templatePayload.setCurrentNote(
						response != null && response.getCurrentNote() != null ? response.getCurrentNote()
								: CurrentNoteDao.getCurrentNotesObject(""));
				templatePayload
						.setCustomId(response != null && response.getCustomId() != null ? response.getCustomId() : "");
				templatePayload.setDates(
						response != null && response.getDates() != null ? response.getDates() : new ArrayList<>());
				templatePayload.setEstHrs(response != null && response.getEstHrs() != 1 ? response.getEstHrs() : 0);
				templatePayload
						.setExtraCost(response != null && response.getExtraCost() != 1 ? response.getExtraCost() : 0);
				templatePayload.setFiles(
						response != null && response.getFiles() != null ? response.getFiles() : new ArrayList<>());
				templatePayload.setIdsMap(
						response != null && response.getIdsMap() != null ? response.getIdsMap() : new ArrayList<>());
				templatePayload
						.setIsDefault(response != null && response.isDefault() != true ? response.isDefault() : false);
				templatePayload
						.setEditing(response != null && response.isEditing() != true ? response.isEditing() : true);
				templatePayload
						.setIsLocked(response != null && response.isDefault() != true ? response.isDefault() : false);

				if (stage == Statickeys.materialTemplates) {
					ArrayList<Items> itemsList = new ArrayList<>();
					ArrayList<HashMap<String, Object>> itemParmas = getItemParams(Statickeys.materialTemplates,
							Statickeys.create, response, "general");
					for (int i = 0; i < itemParmas.size(); i++) {
						HashMap<String, Object> itemParam = itemParmas.get(i);
						ItemsDao itemDao = new ItemsDao();
						Items item = itemDao.getItemDAO(itemParam);
						itemsList.add(item);
						templatePayload
								.setItems(response != null && response.getItems() != null ? itemsList : itemsList);

					}
				}

//				templatePayload.setItems(
//						response != null && response.getItems() != null ? response.getItems() : new ArrayList<>());
				templatePayload
						.setLeadDates(response != null && response.getLeadDates() != null ? response.getLeadDates()
								: (LeadDates) LeadDatesDao.getLeadDatesDAO());
				templatePayload.setLeastStage(leastStage);
				templatePayload.setManager((response != null && response.getManager() != null) ? response.getManager()
						: (Manager) ManagerDao.getManagerRuns());
				templatePayload.setMemos(
						response != null && response.getMemos() != null ? response.getMemos() : new ArrayList<>());
				templatePayload
						.setMultiTrade(response != null && response.getMultiTrade() != null ? response.getMultiTrade()
								: MultiTradeDao.getMultiTradeDAO(new ArrayList<FTD>(), false));
				templatePayload.setOrderCreator(
						response != null && response.isOrderCreator() != true ? response.isOrderCreator() : false);
				templatePayload.setProject(response != null && response.getProject() != null ? response.getProject()
						: (Project) ProjectDao.getTemplateProjectDAO());
				templatePayload.setOwner(response != null && response.getOwner() != null ? response.getOwner()
						: (Owner) OwnerDao.getOwnerDAO());
				templatePayload.setPurpose(
						response != null && response.getPurpose() != null ? response.getPurpose() : Statickeys.general);
				templatePayload.setSimpleDates(
						response != null && response.getSimpleDates() != null ? response.getSimpleDates()
								: (new HashMap<String, Object>()));
				templatePayload.setSimpleFiles(
						response != null && response.getSimpleFiles() != null ? response.getSimpleFiles()
								: new ArrayList<>());
				templatePayload.setSimpleMemos(
						response != null && response.getSimpleMemos() != null ? response.getSimpleMemos()
								: new ArrayList<>());
				templatePayload.setSimpleTodos(
						response != null && response.getSimpleTodos() != null ? response.getSimpleTodos()
								: new ArrayList<>());
				templatePayload.setStage(payloadStage);
				templatePayload.setStageUsed(
						response != null && response.getStageUsed() != null ? response.getStageUsed() : Statickeys.all);
				templatePayload.setTags(
						response != null && response.getTags() != null ? response.getTags() : new ArrayList<>());
				templatePayload.setTodos(
						response != null && response.getTodos() != null ? response.getTodos() : new ArrayList<>());
				templatePayload.setTotalCost(
						response != null && response.getTotalCost() != null ? response.getTotalCost() : null);
				templatePayload.set__t(__t);
				templatePayload.set_customStage(customStage);
				templatePayload.set_excludedFields(
						response != null && response.get_excludedFields() != null ? response.get_excludedFields()
								: new ArrayList<>());
				templatePayload.set_slimSave(
						response != null && response.is_slimSave() != true ? response.is_slimSave() : true);
				templatePayload.setNotes(response != null && response.getNotes() != null ? response.getNotes() : null);
				templatePayload.setNumberOfItems(
						response != null && response.getNumberOfItems() != 1 ? response.getNumberOfItems() : 0);

			}
			if (requestType == Statickeys.update) {
				templatePayload.setBaseDelivery(
						response != null && response.getBaseDelivery() != null ? response.getBaseDelivery()
								: new BaseDelivery());
				templatePayload.setArchived(response != null && response.getArchived() != null ? response.getArchived()
						: (Archived) ArchivedDao.getArchivedDAO(false));
				templatePayload.setCreated(response != null && response.getCreated() != null ? response.getCreated()
						: (Created) CreatedDao.geCreatedObject());
				templatePayload.setCreatedFrom(
						response != null && response.getCreatedFrom() != null ? response.getCreatedFrom()
								: (CreatedFrom) CreatedFromDao.getCreatedFromDao(Statickeys.normal));
				templatePayload.setCurrentNote(
						response != null && response.getCurrentNote() != null ? response.getCurrentNote()
								: CurrentNoteDao.getCurrentNotesObject(""));
				templatePayload
						.setCreatedVia(response != null && response.getCreatedVia() != null ? response.getCreatedVia()
								: (String) Statickeys.manual);
				templatePayload
						.setCustomId(response != null && response.getCustomId() != null ? response.getCustomId() : "");
				templatePayload.setDates(
						response != null && response.getDates() != null ? response.getDates() : new ArrayList<>());
				templatePayload.setEffectiveOwner(
						response != null && response.getEffectiveOwner() != null ? response.getEffectiveOwner()
								: (EffectiveOwner) EffectiveOwnerDao.getEffectiveOwnerDAO());
				templatePayload.setEstHrs(response != null && response.getEstHrs() != 1 ? response.getEstHrs() : 0);
				templatePayload
						.setExtraCost(response != null && response.getExtraCost() != 1 ? response.getExtraCost() : 0);
				templatePayload.setFiles(
						response != null && response.getFiles() != null ? response.getFiles() : new ArrayList<>());
				templatePayload.setHasReserved(
						response != null && response.isHasReserved() != true ? response.isHasReserved() : false);
				templatePayload.setFromSchedule(
						response != null && response.isFromSchedule() != true ? response.isFromSchedule() : false);
				templatePayload.setId(response != null && response.getId() != null ? response.getId() : null);
				templatePayload.setIdsMap(
						response != null && response.getIdsMap() != null ? response.getIdsMap() : new ArrayList<>());
				templatePayload
						.setIsDefault(response != null && response.isDefault() != true ? response.isDefault() : false);
				templatePayload
						.setEditing(response != null && response.isEditing() != false ? response.isEditing() : true);
				templatePayload
						.setIsLocked(response != null && response.isDefault() != true ? response.isDefault() : false);

				if (stage == Statickeys.prodTemplates) {
					ItemsDao itemDao1 = new ItemsDao();
					HashMap<String, Object> itemParams = new HashMap<>();
					ArrayList<Items> itemsList = new ArrayList<>();
					itemParams.put(Statickeys.purpose, "general");
					for (int j = 0; j < DataSourceHelper.itemCount; j++) {
						itemParams.put(Statickeys.name, response.getTemplateName() + "-" + j);
						Items i = itemDao1.getItemDAO(itemParams);
						itemsList.add(i);
						templatePayload.setItems(itemsList);
					}
				}
				templatePayload.setKeywords(
						response != null && response.getKeywords() != null ? response.getKeywords() : null);
				templatePayload
						.setKitIds(response != null && response.getKitIds() != null ? response.getKitIds() : null);
				templatePayload.setLastModified(
						response != null && response.getLastModified() != null ? response.getLastModified() : null);
				templatePayload
						.setLeadDates(response != null && response.getLeadDates() != null ? response.getLeadDates()
								: (LeadDates) LeadDatesDao.getLeadDatesDAO());
				templatePayload.setLeastStage(leastStage);
				templatePayload.setLinkedCompanies(
						response != null && response.getLinkedCompanies() != null ? response.getLinkedCompanies()
								: null);
				templatePayload.setLinkedOrders(
						response != null && response.getLinkedOrders() != null ? response.getLinkedOrders() : null);
				templatePayload.setManager((response != null && response.getManager() != null) ? response.getManager()
						: (Manager) ManagerDao.getManagerRuns());
				templatePayload.setMemos(
						response != null && response.getMemos() != null ? response.getMemos() : new ArrayList<>());
				templatePayload
						.setMultiTrade(response != null && response.getMultiTrade() != null ? response.getMultiTrade()
								: MultiTradeDao.getMultiTradeDAO(new ArrayList<FTD>(), false));
				templatePayload.setName(response != null && response.getName() != null ? response.getName() : null);
				templatePayload.setOrderCreator(
						response != null && response.isOrderCreator() != true ? response.isOrderCreator() : false);
				templatePayload.setOwner(response != null && response.getOwner() != null ? response.getOwner()
						: (Owner) OwnerDao.getOwnerDAO());
				templatePayload.setPoCreatedAt(
						response != null && response.getPoCreatedAt() != null ? response.getPoCreatedAt() : null);
				templatePayload.setProject(response != null && response.getProject() != null ? response.getProject()
						: (Project) ProjectDao.getTemplateProjectDAO());
				templatePayload
						.setPurchase(response != null && response.isPurchase() != false ? response.isPurchase() : true);
				templatePayload.setPurpose(
						response != null && response.getPurpose() != null ? response.getPurpose() : Statickeys.general);
				templatePayload.setRevitGuids(
						response != null && response.getRevitGuids() != null ? response.getRevitGuids() : null);
				templatePayload.setRunBaseTime(
						response != null && response.getRunBaseTime() != null ? response.getRunBaseTime() : null);
				templatePayload.setSearchText(
						response != null && response.getSearchText() != null ? response.getSearchText() : null);
				templatePayload.setSecondaryStatus(
						response != null && response.getSecondaryStatus() != null ? response.getSecondaryStatus()
								: null);
				templatePayload.setSimpleDates(
						response != null && response.getSimpleDates() != null ? response.getSimpleDates()
								: (new HashMap<String, Object>()));
				templatePayload.setSimpleFiles(
						response != null && response.getSimpleFiles() != null ? response.getSimpleFiles()
								: new ArrayList<>());
				templatePayload.setSimpleMemos(
						response != null && response.getSimpleMemos() != null ? response.getSimpleMemos()
								: new ArrayList<>());
				templatePayload.setSimpleTodos(
						response != null && response.getSimpleTodos() != null ? response.getSimpleTodos()
								: new ArrayList<>());
				templatePayload.setSpecification(
						response != null && response.getSpecification() != null ? response.getSpecification()
								: SpecificationDao.SpecificationDao(null, 0));
				templatePayload.setStage(payloadStage);
				templatePayload.setStageUsed(
						response != null && response.getStageUsed() != null ? response.getStageUsed() : Statickeys.all);
				templatePayload
						.setStatus(response != null && response.getStatus() != null ? response.getStatus() : null);
				templatePayload.setStageWeight(
						response != null && response.getStageWeight() != 0 ? response.getStageWeight() : 0);
				templatePayload.setTags(
						response != null && response.getTags() != null ? response.getTags() : new ArrayList<>());
				templatePayload.setTemplateId(
						response != null && response.getTemplateId() != null ? response.getTemplateId() : null);
				templatePayload.setTemplateName(
						response != null && response.getTemplateName() != null ? response.getTemplateName() : null);
				templatePayload.setTodos(
						response != null && response.getTodos() != null ? response.getTodos() : new ArrayList<>());
				templatePayload.setTotalCost(
						response != null && response.getTotalCost() != null ? response.getTotalCost() : null);
				templatePayload
						.setUpdatedVia(response != null && response.getUpdatedVia() != null ? response.getUpdatedVia()
								: Statickeys.manual);
				templatePayload.setVisibility(
						response != null && response.getVisibility() != null ? response.getVisibility() : null);
				templatePayload.set__t(__t);
				templatePayload.set__v(response != null && response.get__v() != 0 ? response.get__v() : 0);
				templatePayload.set_customStage(customStage);
				templatePayload.set_excludedFields(
						response != null && response.get_excludedFields() != null ? response.get_excludedFields()
								: new ArrayList<>());
				templatePayload.set_id(response != null && response.get_id() != null ? response.get_id() : null);
				templatePayload.set_slimSave(
						response != null && response.is_slimSave() != true ? response.is_slimSave() : true);

				if (requestType == Statickeys.update || requestType == Statickeys.create) {
					if (stage == Statickeys.prodTemplates) {
						templatePayload.setIsManager(true);
					} else {
						templatePayload.setIsManager(false);
					}
				}
			}
			return templatePayload;
		} catch (Exception e) {
			throw new Exception("Error while getting template DAO");
		}

	}

	public static Baseorder getBaseorderByID(String orderId) throws Exception {
		try {
			HashMap<String, String> params = new HashMap<>();
			params.put(Statickeys.projectId, (String) Helper.getDatastore(Statickeys.projectId));

			String route = Statickeys.getBaseorderByID(orderId);

			Response baseOrder = GetRequest.getRequest(route, params, "getBaseORder");
			Baseorder order = (Baseorder) Helper.convertResponceToJavaObject(baseOrder, Statickeys.baseorder);

			return order;
		} catch (Exception e) {
			throw new Exception("Error while getBaseorderByID");
		}
	}
}
