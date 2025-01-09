package tests.e2e.integrationServices;

import java.util.ArrayList;
import java.util.HashMap;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.staticKeys.Statickeys;

public class SupplyChainApisServices {

	static HashMap<String, Object> params = new HashMap<String, Object>();

	public static HashMap<String, Object> getPlanningOrdersParams() {

		params.clear();
		params.put(Statickeys.limit, 50);
		params.put(Statickeys.page, 2);
		params.put(Statickeys.screen, "planning");
		ArrayList<String> moduleList = new ArrayList<>();
		moduleList.add("Prefabs");
		params.put(Statickeys.module, moduleList);

		return params;
	}

	public static HashMap<String, Object> getCoordinationOrdersParams() {

		params.clear();
		params.put(Statickeys.limit, 50);
		params.put(Statickeys.page, 2);
		params.put(Statickeys.screen, "coordination");
		params.put(Statickeys.sorts, "{\"sortField\":\"name\",\"direction\":\"asc\"}");
		ArrayList<String> moduleList = new ArrayList<>();
		moduleList.add("ProductionOrder");
		params.put(Statickeys.module, moduleList);
		params.put(Statickeys.stages, "coordination");
		params.put(Statickeys.isManager, false);
		ArrayList<String> statusList = new ArrayList<>();
		statusList.add("not-started");
		statusList.add("in-progress");
		statusList.add("pause");
		statusList.add("complete");
		params.put(Statickeys.status, statusList);
		params.put(Statickeys.search, "");

		return params;
	}

	public static HashMap<String, Object> getRequestingOrdersParams() {

		params.clear();
		params.put(Statickeys.limit, 50);
		params.put(Statickeys.page, 2);

		ArrayList<String> moduleList = new ArrayList<>();
		moduleList.add("Materials");
		params.put(Statickeys.module, moduleList);

		ArrayList<String> stageList = new ArrayList<>();
		stageList.add("preparation");
		stageList.add("sourcing");
		stageList.add("ordering");
		stageList.add("complete");
		stageList.add("delivery");
		stageList.add("in-transit");
		stageList.add("mixed");
		stageList.add("rejected");
		stageList.add("released-to-inventory");
		stageList.add("in-transit");
		stageList.add("not-started");
		stageList.add("mixed-shipping");
		stageList.add("fulfilled");
		stageList.add("released-to-inventory");
		stageList.add("in-storage");
		stageList.add("consumed");

		params.put(Statickeys.stages, stageList);

		return params;
	}
	
	public static HashMap<String, Object> getSourcingOrdersParams() {

		params.clear();
		params.put(Statickeys.limit, 50);
		params.put(Statickeys.page, 2);

		ArrayList<String> moduleList = new ArrayList<>();
		moduleList.add("Sourcing");
		params.put(Statickeys.module, moduleList);
		params.put(Statickeys.stages, "sourcing");

		return params;
	}
	
	public static HashMap<String, Object> getOrderingOrdersParams() {

		params.clear();
		params.put(Statickeys.limit, 50);
		params.put(Statickeys.page, 2);

		ArrayList<String> moduleList = new ArrayList<>();
		moduleList.add("Sourcing");
		params.put(Statickeys.module, moduleList);
		
		ArrayList<String> stageList = new ArrayList<>();
		stageList.add("ordering");
		stageList.add("delivery");
		stageList.add("not-started");
		stageList.add("in-transit");
		stageList.add("mixed-shipping");
		params.put(Statickeys.stages, stageList);

		return params;
	}
	
	public static HashMap<String, Object> getDetailingOrdersParams() {

		params.clear();
		params.put(Statickeys.limit, 50);
		params.put(Statickeys.page, 2);
		params.put(Statickeys.screen, "manager");

		ArrayList<String> moduleList = new ArrayList<>();
		moduleList.add("ProductionOrder");
		params.put(Statickeys.module, moduleList);

		params.put(Statickeys.stages, "detailing");
		params.put(Statickeys.fromPM, true);

		return params;
	}
	
	public static HashMap<String, Object> getManufacturingOrdersParams() {

		params.clear();
		params.put(Statickeys.limit, 50);
		params.put(Statickeys.page, 2);
		params.put(Statickeys.screen, "manager");

		ArrayList<String> moduleList = new ArrayList<>();
		moduleList.add("ProductionOrder");
		params.put(Statickeys.module, moduleList);

		params.put(Statickeys.stages, "manufacturing");
		params.put(Statickeys.fromPM, true);

		return params;
	}
	
	public static HashMap<String, Object> getQaOrdersParams() {

		params.clear();
		params.put(Statickeys.limit, 50);
		params.put(Statickeys.page, 2);
		params.put(Statickeys.screen, "manager");

		ArrayList<String> moduleList = new ArrayList<>();
		moduleList.add("ProductionOrder");
		params.put(Statickeys.module, moduleList);

		params.put(Statickeys.stages, "qa");
		params.put(Statickeys.fromPM, true);

		return params;
	}
	
	public static HashMap<String, Object> getShippingParams() {

		params.clear();
		params.put(Statickeys.limit, 50);
		params.put(Statickeys.page, 2);
		params.put(Statickeys.shipType1, "m");
		params.put(Statickeys.shipType2, "s-m");
		params.put(Statickeys.showAllCompanyOrders, false);
		params.put(Statickeys.showEmpty, false);
		params.put(Statickeys.showInternalOrders, false);
		params.put(Statickeys.search, "");
		params.put(Statickeys.sorts, "{\"sortField\":\"name\",\"direction\":\"asc\"}");
		params.put(Statickeys.showInvOrders, false);
		
		String projectID = (String) Helper.getDatastore(Statickeys.projectId);
		ArrayList<String> projectIds = new ArrayList<String>();
		projectIds.add(projectID);
		params.put("projectId", projectID);

		return params;
	}
	
	public static HashMap<String, Object> getTransferParams() {

		params.clear();
		params.put(Statickeys.search, "");
		params.put(Statickeys.notStartedStatus, "not-started");
		params.put(Statickeys.inProgressStatus, "in-progress");
		params.put(Statickeys.completeStatus, "complete");
		params.put(Statickeys.limit, 25);
		params.put(Statickeys.page, 1);
		params.put(Statickeys.sorts, "{\"sortField\":\"taskId\",\"direction\":\"asc\"}");

		return params;
	}
}
