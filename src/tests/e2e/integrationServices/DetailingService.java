package tests.e2e.integrationServices;

import java.util.HashMap;

import org.testng.annotations.Parameters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.endPoints.ProductionManager;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.staticKeys.Statickeys;

public class DetailingService {

	static Baseorder detalilingCreatePayload;
	public static int onsiteDateOffset = 0;
	static HashMap<String, Object> createDetailingParmas = new HashMap<>();
	static HashMap<String, Object> createDetailingParams = new HashMap<>();
	static Response createDetailingOrderResponse;
	static Baseorder detailingOrderJsonNode;

	static ObjectMapper detailingMapper = new ObjectMapper();

	@Parameters({ "scriptType" })

	public static Baseorder getDetailingPayload(String scriptType, HashMap<String, Object> createDetailingPayloadParmas) throws Exception {
		try {

			detalilingCreatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create, Statickeys.detailing, null,
					createDetailingPayloadParmas);

		} catch (Exception e) {
			throw new Exception("Error while getting Payload of detailing order");
		}

		return detalilingCreatePayload;
	}

	public static Response getDetailingResponce(Baseorder payload) throws Exception {

		try {
			createDetailingParams.put("projectId", Helper.getDatastore(Statickeys.projectId));

			createDetailingOrderResponse = PostRequest.postRequest(ProductionManager.createPO, createDetailingParams,
					detalilingCreatePayload, "createDetailing");

		} catch (Exception e) {
			throw new Exception("Error while getting response of detailing order");
		}
		return createDetailingOrderResponse;
	}

	public static Baseorder updateDetailingOrder(Response responce) throws Exception {
		try {
			if (createDetailingOrderResponse != null && createDetailingOrderResponse.getStatusCode() == 200) {
				detailingOrderJsonNode = (Baseorder) Helper.convertResponceToJavaObject(responce, Statickeys.baseorder);
			}
		} catch (Exception e) {
			throw new Exception("Error while update Detailing order");
		}

		return detailingOrderJsonNode;
	}
	
	public static HashMap<String, Object> createDetailParams(String scriptType, int invocationCount) throws Exception {
		createDetailingParmas.put(Statickeys.stage, Statickeys.detailing);
		createDetailingParmas.put(Statickeys._customStage, Statickeys.detailing);
		createDetailingParmas.put(Statickeys.leastStage, Statickeys.deliver);
		createDetailingParmas.put(Statickeys.__t, Statickeys.Prefab);
		onsiteDateOffset = Helper.setDataForDashboadScript(scriptType, invocationCount);
		createDetailingParmas.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate :Helper.getUtcTimeZone(onsiteDateOffset));
		createDetailingParmas.put(Statickeys.poDetailBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poDetailBy :Helper.getUtcTimeZone(onsiteDateOffset));
		return createDetailingParmas;
	}

}
