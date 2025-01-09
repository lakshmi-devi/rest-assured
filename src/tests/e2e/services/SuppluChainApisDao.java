package tests.e2e.services;

import java.util.ArrayList;
import java.util.HashMap;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.staticKeys.Statickeys;

public class SuppluChainApisDao {

	public static HashMap<String, Object> getSupplyChainPayload(HashMap<String, Object> supplyChainApiParams)
			throws Exception {

		HashMap<String, Object> map = new HashMap<>();
		try {
			map.put(Statickeys.limit, (int) supplyChainApiParams.get(Statickeys.limit));
			map.put(Statickeys.page, (int) supplyChainApiParams.get(Statickeys.page));

			map.put(Statickeys.sorts, "{\"sortField\":\"name\",\"direction\":\"asc\"}");
			map.put(Statickeys.module, (ArrayList<String>) supplyChainApiParams.get(Statickeys.module));
			map.put(Statickeys.completedOrders, (String) supplyChainApiParams.get(Statickeys.completedOrders));
			map.put(Statickeys.ExcludeFields, ExcludeFieldsDao.getExcludeFieldsDAO());

			if (supplyChainApiParams.get(Statickeys.screen) != null) {
				map.put("screen", (String) supplyChainApiParams.get(Statickeys.screen));
			}

			Boolean filterBoolValue = supplyChainApiParams.get(Statickeys.filterNoItemOrders) != null
					? (Boolean) supplyChainApiParams.get(Statickeys.filterNoItemOrders)
					: false;
			map.put(Statickeys.filterNoItemOrders, filterBoolValue);

			Boolean fromPMBoolValue = supplyChainApiParams.get(Statickeys.fromPM) != null
					? (Boolean) supplyChainApiParams.get(Statickeys.fromPM)
					: false;
			map.put(Statickeys.fromPM, fromPMBoolValue);

			Boolean isManagerBoolValue = supplyChainApiParams.get(Statickeys.isManager) != null
					? (Boolean) supplyChainApiParams.get(Statickeys.isManager)
					: false;
			map.put(Statickeys.isManager, isManagerBoolValue);

			if (supplyChainApiParams.get(Statickeys.owner) != null) {
				map.put(Statickeys.owner, OwnerDao.getOwnerDAO());
			}

			String projectID = (String) Helper.getDatastore(Statickeys.projectId);
			ArrayList<String> projectIds = new ArrayList<String>();
			projectIds.add(projectID);
			map.put("projectId", projectID);

			Boolean showAllCompanyOrdersBoolValue = supplyChainApiParams.get(Statickeys.showAllCompanyOrders) != null
					? (Boolean) supplyChainApiParams.get(Statickeys.showAllCompanyOrders)
					: false;
			map.put(Statickeys.showAllCompanyOrders, showAllCompanyOrdersBoolValue);

			Boolean showDuplicatesBoolValue = supplyChainApiParams.get(Statickeys.showDuplicates) != null
					? (Boolean) supplyChainApiParams.get(Statickeys.showDuplicates)
					: false;
			map.put(Statickeys.showDuplicates, showDuplicatesBoolValue);

			if (supplyChainApiParams.get(Statickeys.stages) != null) {
				map.put(Statickeys.stages, supplyChainApiParams.get(Statickeys.stages));
			}
			if (supplyChainApiParams.get(Statickeys.status) != null) {
				map.put(Statickeys.statusArray, (ArrayList<String>) supplyChainApiParams.get(Statickeys.status));
			}

		} catch (Exception e) {
			throw new Exception("Error while getting getSupplyChainPayload");
		}
		return map;
	}
}
