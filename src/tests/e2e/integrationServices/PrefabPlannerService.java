package tests.e2e.integrationServices;

import java.util.HashMap;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.endPoints.PrefabPlanner;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.staticKeys.Statickeys;

public class PrefabPlannerService {

	static Baseorder baseOrderCreatePayload;
	static Response response;
	static HashMap<String, Object> apiParams = new HashMap<String, Object>();
	static HashMap<String, Object> parmas = new HashMap<>();

	/* Supporting functions */

	public static Baseorder getBaseOrderPayload(String scriptType, int onsiteIndex) throws Exception {
		try {
			parmas.put(Statickeys.stage, Statickeys.planning);
			parmas.put(Statickeys._customStage, Statickeys.planning);
			parmas.put(Statickeys.leastStage, Statickeys.deliver);
			parmas.put(Statickeys.__t, Statickeys.prefab);
		    parmas.put(Statickeys.coord, DataSourceHelper.activateDataSource ? DataSourceHelper.coordinationDate : Helper.getUtcTimeZone(onsiteIndex));
			parmas.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(onsiteIndex));

			baseOrderCreatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create, Statickeys.planning, null,
					parmas);

		} catch (Exception e) {
			throw new Exception("Error while getting Payload of prefab order");
		}

		return baseOrderCreatePayload;
	}

	public static Response getResponce(Baseorder payload) throws Exception {

		try {
			apiParams.put("projectId", DataStore.getInstance().getProperty(Statickeys.projectId));

			response = PostRequest.postRequest(PrefabPlanner.createPrefab, apiParams, baseOrderCreatePayload,
					"createPrefab");

		} catch (Exception e) {
			throw new Exception("Error while getting responce of prefab order");
		}
		return response;
	}

	public static Response updateBaseOrder(Response responce) throws Exception {
		try {

			Baseorder order = (Baseorder) Helper.convertResponceToJavaObject(responce, Statickeys.baseorder);

			String Route = PrefabPlanner.getPrefabUpdateRoutes(order.getId());
			
			Baseorder baseOrderUpdatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.update,
					Statickeys.planning, order, parmas);
			
			Response UpdateResponse = PostRequest.postRequest(Route, apiParams, baseOrderUpdatePayload, "updatePrefab");
			
			return UpdateResponse;
		} catch (Exception e) {
			throw new Exception("Error while update prefab order");
		}
	}
}
