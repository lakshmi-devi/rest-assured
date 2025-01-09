package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import groovyjarjarpicocli.CommandLine.Help;
import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.endPoints.ProductionManager;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.MoveOrdersService;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.services.LastModifiedDao;
import tests.e2e.staticKeys.Statickeys;

public class moveOrders {
	public int invocationCount = 0;
	static HashMap<String, Object> params = new HashMap<>();
	static HashMap<String, Object> apiParams = new HashMap<>();
	Helper helper = new Helper();

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void moveToPO(String scriptType) {
		try {
			params.clear();
			params = MoveOrdersService.getMoveToPOParams(scriptType, invocationCount);

			ArrayList<Baseorder> planningOrders = (ArrayList<Baseorder>) Helper.getDatastore(Statickeys.planningOrder);

			// GETTING RANDOM ORDER
			Baseorder prefabOrder = planningOrders.get(Helper.getRandomNumber(planningOrders.size()));

			System.out.println("Prefab order Name -> po :" + prefabOrder.getName());

			Baseorder baseOrderUpdatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.update,
					Statickeys.planning, prefabOrder, params);

			apiParams.clear();
			apiParams = MoveOrdersService.getQuearyParams();

			Response response = PostRequest.postRequest(Statickeys.moveToCoord, apiParams, baseOrderUpdatePayload,
					"move to po");

			if (response.statusCode() == 200) {
				System.out.println(prefabOrder.getName() + " : moved to PO stage");
				System.out.println("");// For indentation in console
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void moveToDetailing(String scriptType) {
		try {
			params.clear();
			params = MoveOrdersService.getMoveToDetailingParams();

			ArrayList<Baseorder> coordinationOrder = (ArrayList<Baseorder>) Helper
					.getDatastore(Statickeys.coordinationOrders);

			// GETTING RANDOM ORDER
			Baseorder coordOrder = coordinationOrder.get(Helper.getRandomNumber(coordinationOrder.size()));

			System.out.println("coordination order name -> " + coordOrder.getName());

			Baseorder baseOrderMovePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.moveToPm, null, coordOrder,
					params);

			apiParams.clear();
			apiParams = MoveOrdersService.getQuearyParams();

			Response response = PostRequest.postRequest(Statickeys.moveToPM, params, baseOrderMovePayload,
					"moveToDetailing");

			if (response.statusCode() == 200) {
				System.out.println(coordOrder.getName() + " : moved to detailing stage");
				System.out.println("");// For indentation in console
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void moveToManufacturing(String scriptType) {
		try {
			params.clear();
			params = MoveOrdersService.getmoveToManufacturing(scriptType, invocationCount);
			
			ArrayList<Baseorder> detailingOrder = (ArrayList<Baseorder>) Helper.getDatastore(Statickeys.detailingOrder);

			// GETTING RANDOM ORDER
			Baseorder detailOrder = detailingOrder.get(Helper.getRandomNumber(detailingOrder.size()));

			System.out.println("detailing order Name ->" + " " + detailOrder.getName());

			Baseorder baseOrderUpdatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.update,
					Statickeys.manufacturing, detailOrder, params);
			
			apiParams.clear();
			apiParams = MoveOrdersService.getQuearyParams();
			
			String Route = Statickeys.getMoveToManufRoutes(detailOrder.getId());

			Response UpdateResponse = PostRequest.postRequest(Route, apiParams, baseOrderUpdatePayload,
					"move to manufacturing");
			if(UpdateResponse.getStatusCode() == 200) {
				System.out.println(detailOrder.getName() + " : moved to Manufacturing stage");
				System.out.println("");// For indentation in console
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void moveToQA(String scriptType) {
		try {
			params.clear();
			params = MoveOrdersService.getmoveToQA(scriptType, invocationCount);

			ArrayList<Baseorder> manufacturingOrders = (ArrayList<Baseorder>) Helper
					.getDatastore(Statickeys.manufacturingOrder);

			// skipping linked BOM orders
			ArrayList<Baseorder> manufOrder = new ArrayList<Baseorder>();
			for (int i = 0; i < manufacturingOrders.size(); i++) {
				if (manufacturingOrders.get(i).getMaterials().size() == 0) {
					manufOrder.add(manufacturingOrders.get(i));
				}
			}

			// GETTING RANDOM ORDER
			Baseorder manufacturingOrder = manufOrder.get(Helper.getRandomNumber(manufOrder.size()));

			Helper helper = new Helper();
			System.out.println("Manufacturing Order Name ->" + " " + manufacturingOrder.getName());

			apiParams.clear();
			apiParams = MoveOrdersService.getQuearyParams();

			String Route = Statickeys.getQaMoveRoutes(manufacturingOrder.getId());

			int runCount = manufacturingOrder.getManager().getRuns().size();
			for (int runIndex = 0; runIndex < runCount; runIndex++) {
				manufacturingOrder.getManager().getRuns().get(runIndex).setModified(LastModifiedDao.lastModifiedDAO());
				manufacturingOrder.getManager().getRuns().get(runIndex).setCompleted(true);
				manufacturingOrder.getManager().getRuns().get(runIndex).setEditing(true);
				manufacturingOrder.getManager().getRuns().get(runIndex).setEditing(true);
				int runItemCount = manufacturingOrder.getManager().getRuns().get(runIndex).getRunItemsCount().size();
				for (int runItemsIndex = 0; runItemsIndex < runItemCount; runItemsIndex++) {
					manufacturingOrder.getManager().getRuns().get(runIndex).getRunItemsCount().get(runItemsIndex)
							.setRiCompleted(true);
				}
			}

			String PMUpdateRoute = Statickeys.getPMUpdateRoutes(manufacturingOrder.get_id());

			Baseorder baseOrderUpdatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.update, Statickeys.qa,
					manufacturingOrder, params);
			
			baseOrderUpdatePayload.getManager().setSimpleDates(baseOrderUpdatePayload.getSimpleDates());
			
			Response updateResponse = PostRequest.postRequest(PMUpdateRoute, apiParams, baseOrderUpdatePayload,
					"UpdatePM");

			Response moveToQAResponse = PostRequest.postRequest(Route, apiParams, baseOrderUpdatePayload, "move to QA");

			if (moveToQAResponse.getStatusCode() == 200) {
				System.out.println(manufacturingOrder.getName() + " : moved to QA stage");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
