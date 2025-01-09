package tests.e2e.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tests.e2e.helper.Helper;
import tests.e2e.module.Items;
import tests.e2e.module.Location;
import tests.e2e.module.MaterialItems;
import tests.e2e.module.Prefab;
import tests.e2e.module.Qa;
import tests.e2e.module.Serials;
import tests.e2e.module.StageMap;
import tests.e2e.module.Summary;
import tests.e2e.module.Vendor;
import tests.e2e.staticKeys.Statickeys;

public class ItemsDao {

	// @SuppressWarnings("unchecked")
	public Items getItemDAO(HashMap<String, Object> itemDetails) throws Exception {
		try {
			Items item = new Items();

			item.setCreated(CreatedDao.geCreatedObject());
			item.setCompany(CompanyDao.getCompanyDAO());
			item.setQa(QaDao.getQaDAO());
			item.setActual(ActualDao.getactualDAO(null));
			item.setPurchase(
					itemDetails.containsKey(Statickeys.purchase) ? (Boolean) itemDetails.get(Statickeys.purchase)
							: true);
			item.setSummary(SummaryDao.getSummaryDAO(0, 0, 0)); // for now hard coding values, later will make it
																// generic
			item.setSerials(SerialsDao.getSerialsDAO(0, 1, 0));
			item.setArchived(ArchivedDao.getArchivedDAO(false));
			item.setSimpleDates(
					itemDetails.containsKey("simpleDates") ? (Object) itemDetails.get("simpleDates") : new HashMap<>());
			item.setInstallLocs(itemDetails.containsKey(Statickeys.installLocs)
					? (List<String>) itemDetails.get(Statickeys.installLocs)
					: new ArrayList<String>());
			item.setCatId(itemDetails.containsKey(Statickeys.catId) ? (String) itemDetails.get(Statickeys.catId) : "");
			item.setHasBom(
					itemDetails.containsKey(Statickeys.hasBom) ? (boolean) itemDetails.get(Statickeys.hasBom) : false);
			item.setStatus(itemDetails.containsKey(Statickeys.status) ? (String) itemDetails.get(Statickeys.status)
					: "NotUsed");
			item.setPurpose(itemDetails.get(Statickeys.purpose) == "kit" ? (String) itemDetails.get(Statickeys.purpose)
					: "general");
			item.setStage((String) itemDetails.get(Statickeys.stage));
			item.setQuantity(
					itemDetails.containsKey(Statickeys.quantity) ? (int) itemDetails.get(Statickeys.quantity) : 1);
			item.setMinQuantity(
					itemDetails.containsKey(Statickeys.minQuantity) ? (int) itemDetails.get(Statickeys.minQuantity)
							: 0);
			item.setMaxQuantity(
					itemDetails.containsKey(Statickeys.maxQuantity) ? (int) itemDetails.get(Statickeys.maxQuantity)
							: 9999);
			item.setInventoryNotes(itemDetails.containsKey(Statickeys.inventoryNotes)
					? (String) itemDetails.get(Statickeys.inventoryNotes)
					: "");
			item.setActiveSupplier(itemDetails.containsKey(Statickeys.activeSupplier)
					? (String) itemDetails.get(Statickeys.activeSupplier)
					: "");
			item.setVendor(
					itemDetails.containsKey(Statickeys.vendor) ? (Vendor) itemDetails.get(Statickeys.vendor) : null);
			item.setVendors(
					itemDetails.containsKey(Statickeys.vendors) ? (Vendor) itemDetails.get(Statickeys.vendors) : null);
			item.set_accessor("items");
			item.set_place("item");
			item.setLeadTime(
					itemDetails.containsKey(Statickeys.leadTime) ? (int) itemDetails.get(Statickeys.leadTime) : 0);
			item.setMeasureUnits(
					itemDetails.containsKey(Statickeys.measureUnits) ? (String) itemDetails.get(Statickeys.measureUnits)
							: "");
			if (itemDetails.containsKey(Statickeys.measureUnits) && itemDetails.containsKey(Statickeys.measure)) {
				item.setMeasure((int) itemDetails.get(Statickeys.measure));
			}

			item.setRevitGuids(itemDetails.containsKey(Statickeys.revitGuids)
					? (List<String>) itemDetails.get(itemDetails.get(Statickeys.revitGuids))
					: new ArrayList<String>());
			item.setPf(itemDetails.containsKey(Statickeys.pf) ? (String) itemDetails.get(Statickeys.pf) : null);
			item.setStageMap(StageMapDao.getStageMapDAO(0));

			if (itemDetails.containsKey(Statickeys.catId)) {
				item.setFromMasterCatalog(true);
			} else {
				item.setFromMasterCatalog(false);
			}

			item.setUpdatedVia(
					itemDetails.containsKey(Statickeys.updatedVia) ? (String) itemDetails.get(Statickeys.updatedVia)
							: Statickeys.manual);
			item.set__t(itemDetails.containsKey(Statickeys.__t) ? (String) itemDetails.get(Statickeys._t) : "");
			item.set_id(itemDetails.containsKey(Statickeys._id) ? (String) itemDetails.get(Statickeys._id) : null);
			item.setName(itemDetails.containsKey(Statickeys.name) ? (String) itemDetails.get(Statickeys.name)
					: Helper.randomNameBuilder("item"));
			item.setUuid(Helper.getUuid());
			item.setProject(ProjectDao.getProjectDAO());
			item.setLevel(itemDetails.containsKey(Statickeys.level) ? (String) itemDetails.get(Statickeys.level) : "");
			item.setZone(itemDetails.containsKey(Statickeys.zone) ? (String) itemDetails.get(Statickeys.zone) : "");

			if (itemDetails.containsKey(Statickeys.catId)) {
				item.setCustomId((String) itemDetails.get(Statickeys.catId));
			} else if (itemDetails.containsKey(Statickeys.customId)) {
				item.setCustomId((String) itemDetails.get(Statickeys.catId));
			}

			item.setQtyLocations(itemDetails.containsKey(Statickeys.qtyLocations)
					? (List<String>) itemDetails.get(Statickeys.qtyLocations)
					: new ArrayList<String>());
			item.setMaterialItems(itemDetails.containsKey(Statickeys.materialItems)
					? (ArrayList<MaterialItems>) itemDetails.get(Statickeys.materialItems)
					: null);
			item.setBaseCardType(
					itemDetails.containsKey(Statickeys.baseCardType) ? (String) itemDetails.get(Statickeys.baseCardType)
							: null);
			item.setLocation(LocationDao.getLocationForItemDao());
			item.setCostCode(
					itemDetails.containsKey(Statickeys.costCode) ? (String) itemDetails.get(Statickeys.costCode) : "");
			item.set__v(itemDetails.containsKey(Statickeys.__v) ? (int) itemDetails.get(Statickeys.__v) : 0);

			Prefab prefab = new Prefab();
			if (itemDetails.containsKey(Statickeys.prefab)) {
				prefab.set_id((String) itemDetails.get(Statickeys.prefab));
			} else {
				item.setPrefab(prefab);
			}

			item.setId(itemDetails.containsKey(Statickeys.id) ? (String) itemDetails.get(Statickeys.id) : null);

			if (itemDetails.containsKey(Statickeys.id)) {
				item.setNew(false);
				item.setEditing(false);
			} else {
				item.setNew(true);
				item.setEditing(true);
			}

			return item;
		} catch (Exception e) {
			throw new Exception("Error at ItemDAO" + e);
		}

	}
}
