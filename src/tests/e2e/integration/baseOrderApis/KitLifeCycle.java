package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.endPoints.ProductionManager;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.KitLifeCycleService;
import tests.e2e.module.Baseorder;
import tests.e2e.module.Items;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.services.LocationDao;
import tests.e2e.services.ManagerDao;
import tests.e2e.staticKeys.Statickeys;

public class KitLifeCycle implements Cloneable {

	static HashMap<String, Object> params = new HashMap<>();
	static HashMap<String, Object> quearyParams = new HashMap<String, Object>();
	static HashMap<String, Object> createBOMParams = new HashMap<String, Object>();
	static ArrayList<String> materialIds = new ArrayList<String>();

	public int invocationCount = 0;
	public static int onsiteDate = 0;
	Helper helper = new Helper();
	ObjectMapper mapper = new ObjectMapper();
	static Baseorder planningKitOrder = null;
	static Baseorder createBOMResponse = null;

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createKit(String scriptType) throws Exception {
		try {
			onsiteDate = Helper.setDataForDashboadScript(scriptType, invocationCount);

			// ---------------- create KIT order --------------------------
			params.clear();
			params = KitLifeCycleService.getKitCreateParams(scriptType, invocationCount);

			Baseorder baseOrderCreatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create,
					Statickeys.planning, null, params);

			quearyParams = KitLifeCycleService.getQuearyParams();

			Response planningKitResponse = PostRequest.postRequest(Statickeys.createPrefab, quearyParams,
					baseOrderCreatePayload, "createKit");

			planningKitOrder = (Baseorder) Helper.convertResponceToJavaObject(planningKitResponse,
					Statickeys.baseorder);

			System.out.println("Kit Order Created with name : " + planningKitOrder.getName());

			String Route = Statickeys.getPrefabUpdateRoutes(planningKitOrder.getId());

			// ---------------- Update KIT order --------------------------

			Baseorder baseOrderUpdatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.update,
					Statickeys.planning, planningKitOrder, params);

			Response UpdateResponse = PostRequest.postRequest(Route, quearyParams, baseOrderUpdatePayload, "updateKit");

			planningKitOrder = null;
			planningKitOrder = (Baseorder) Helper.convertResponceToJavaObject(UpdateResponse, Statickeys.baseorder);

			// --------------------- Move Kit order wrt Assemblies ------------------------
			ArrayList<Items> kitItemList = new ArrayList<>();
			ArrayList<Items> assemblyItemList = new ArrayList<>();

			for (int i = 0; i < planningKitOrder.getItems().size(); i++) {
				if (planningKitOrder.getItems().get(i).getPurpose().equals(Statickeys.kit)) {
					kitItemList.add(planningKitOrder.getItems().get(i));
				} else {
					assemblyItemList.add(planningKitOrder.getItems().get(i));
				}
			}

			Baseorder assemblyOrder = (Baseorder) planningKitOrder.clone();
			assemblyOrder.setItems(assemblyItemList);

			Baseorder kitOrder = (Baseorder) planningKitOrder.clone();
			kitOrder.setItems(kitItemList);

			Baseorder kitMoveResponse = moveKitOrdersToPO(kitOrder, quearyParams, params);
			Baseorder kitAssemblyResponse = moveKitOrdersToPO(assemblyOrder, quearyParams, params);

			// ------------------------ Create BOM -------------------------

			for (int i = 0; i < kitAssemblyResponse.getItems().size(); i++) {
				createBOMParams.put(Statickeys.cardId, kitAssemblyResponse.getItems().get(0).getPrefab().get_id());
				createBOMParams.put(Statickeys.itemId, kitAssemblyResponse.getItems().get(i).getId());
				createBOMParams.put(Statickeys.projectId, Helper.getDatastore(Statickeys.projectId));
				createBOMParams.put(Statickeys.bomManufactureBy, 2);
				createBOMResponse = createBOM(kitAssemblyResponse, createBOMParams);
				materialIds.add(createBOMResponse.get_id());
			}

			// --------------- Move BOM to sourcing -----------------------------
			addMaterial(materialIds, kitAssemblyResponse);

			for (int i = 0; i < materialIds.size(); i++) {
				pullToSourcing(materialIds.get(i));
			}

			// ------------- move Kit and Assembly orders to detailing
			// -----------------------
			Baseorder kit = updateParams(kitMoveResponse);
			Baseorder kitMoveDetailing = moveOrdersToDetailing(kit, quearyParams);

			Baseorder assembly = updateParams(kitAssemblyResponse);
			Baseorder assemblyMoveDetailing = moveOrdersToDetailing(assembly, quearyParams);

			// ------------------ move orders to manufacturing -------------------------
			Response kitMoveManufacturing = moveOrdersToManufacturing(kitMoveDetailing, quearyParams);
			Response assemblyMoveManufacturing = moveOrdersToManufacturing(assemblyMoveDetailing, quearyParams);

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	// move kit orders to po
	private Baseorder moveKitOrdersToPO(Baseorder baseorder, HashMap<String, Object> quearyparams,
			HashMap<String, Object> parmas) throws Exception {
		Response MoveUpdateResponse = null;
		Baseorder moveResponceOrder = null;
		Baseorder order = null;
		try {
			Response MoveResponse = PostRequest.postRequest(Statickeys.moveToCoord, quearyparams, baseorder,
					"move KIT to PO");

			System.out.println(baseorder.getName() + " - Kit order move from Planning to PO with Item Name - "
					+ baseorder.getItems().get(0).getName());

			order = (Baseorder) Helper.convertResponceToJavaObject(MoveResponse, Statickeys.baseorder);

			String movetoPORoute = Statickeys.getMoveToPoUpdateID(order.getId());
			Baseorder moveUpdatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.update, Statickeys.planning,
					order, parmas);

			// Kitids
			ArrayList<String> kitIds = new ArrayList<>();
			kitIds.add(baseorder.getKitIds().get(0)); // as KitId array list is only one
			moveUpdatePayload.setKitIds(kitIds);
			moveUpdatePayload.setCustomId(baseorder.getCustomId());

			MoveUpdateResponse = PostRequest.postRequest(movetoPORoute, quearyparams, moveUpdatePayload, "moveKit");
			moveResponceOrder = (Baseorder) Helper.convertResponceToJavaObject(MoveUpdateResponse,
					Statickeys.baseorder);
		} catch (Exception e) {
			throw new Exception("Error while move Kit order" + e);
		}
		return moveResponceOrder;
	}

	private Baseorder createBOM(Baseorder kitAssemblyResponse, HashMap<String, Object> params) throws Exception {

		Baseorder addBomJsonNode = null;

		String createBOMRoute = Statickeys.getCreateBOMID(kitAssemblyResponse.getItems().get(0).getPrefab().get_id());

		Response createBOMResponse = GetRequest.getRequest(createBOMRoute, params, "create BOM");

		String createBOMResponseString = createBOMResponse.asPrettyString();

		List<Object> AllBom = io.restassured.path.json.JsonPath.from(createBOMResponseString).getList("");

		// It will be always 0 count
		addBomJsonNode = (Baseorder) Helper.convertObjectToJavaObject(AllBom.get(0), Statickeys.baseorder);
		
		return addBomJsonNode;
	}

	private Response addMaterial(ArrayList<String> materialIds, Baseorder kitAssemblyResponse) throws Exception {

		HashMap<String, Object> addMaterialsParams = new HashMap<String, Object>();
		addMaterialsParams = KitLifeCycleService.getQuearyParams();

		HashMap<String, Object> addBomUpdatePayload = new HashMap<String, Object>();
		addBomUpdatePayload.put(Statickeys.materialIds, materialIds);

		String addMaterialRoute = Statickeys.getAddMaterialCardID(kitAssemblyResponse.getId());

		Response AddMaterialResponse = PostRequest.postRequest(addMaterialRoute, addMaterialsParams,
				addBomUpdatePayload, "add materials");

		return AddMaterialResponse;
	}

	private Baseorder moveOrdersToDetailing(Baseorder baseorder, HashMap<String, Object> params) throws Exception {
		Response MoveResponse = PostRequest.postRequest(Statickeys.moveToPM, params, baseorder,
				"move orders to detailing");

		System.out.println(baseorder.getName() + " - Kit order move from PO to detailing with Item Name- "
				+ baseorder.getItems().get(0).getName());

		Baseorder MoveResponsenewJsonNode = (Baseorder) Helper.convertResponceToJavaObject(MoveResponse,
				Statickeys.baseorder);

		return MoveResponsenewJsonNode;
	}

	private Baseorder updateParams(Baseorder baseorder) throws Exception {

		baseorder.setPoDetailBy(Helper.getUtcTimeZone(onsiteDate));
		baseorder.setPoManufactureBy(Helper.getUtcTimeZone(onsiteDate));
		baseorder.setDeliverDate(Helper.getUtcTimeZone(onsiteDate));
		baseorder.setLocation(LocationDao.getBaseDeliveryLocationDAO());
		baseorder.setManager(ManagerDao.getManagerDao());
		baseorder.setPTrackEnabled(true);

		return baseorder;
	}

	private Response pullToSourcing(String carId) throws Exception {

		HashMap<String, Object> pullBomUpdatePayload = new HashMap<String, Object>();
		List<String> array = new ArrayList<String>();

		array.add(carId);
		pullBomUpdatePayload.put("cardIds", array);

		Response pullToSourcingResponse = PostRequest.postRequest(Statickeys.pullToSourcing,
				new HashMap<String, Object>(), pullBomUpdatePayload, "pull to sourcing");

		return pullToSourcingResponse;
	}

	private Response moveOrdersToManufacturing(Baseorder baseorder, HashMap<String, Object> params) throws Exception {
		
		String PMUpdateRoute = Statickeys.getMoveToManufRoutes(baseorder.getId());

		Response MoveResponse = PostRequest.postRequest(PMUpdateRoute, params, baseorder,
				"move orders to manufacturing");

		System.out.println(baseorder.getName() + " - Kit order move from detailing to manufacturing with Item Name- "
				+ baseorder.getItems().get(0).getName());

		return MoveResponse;
	}
}