package tests.e2e.integrationServices;

import java.util.HashMap;

import org.testng.annotations.Parameters;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.endPoints.ProductionManager;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.staticKeys.Statickeys;

public class CoordinationService {
	static Baseorder coordinationOrderCreatePayload;
	static HashMap<String, Object> createCoordApiparams = new HashMap<String, Object>();
    static Response coordinationResponse;
	static Baseorder baseOrderJsonNode;
	static ObjectMapper coordinationMapper = new ObjectMapper();
	static HashMap<String, Object> createCoordinationParmas = new HashMap<>();
	public static int onsiteDateOffset = 0;
	
	@Parameters({ "scriptType" })

	public static Baseorder getCoordinationPayload(String scriptType, HashMap<String, Object> createCoordinationParmas)
			throws Exception {
		try {

			coordinationOrderCreatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create,
					Statickeys.coordination, null, createCoordinationParmas);

		} catch (Exception e) {
			throw new Exception("Error while getting Payload of coordination Response order");
		}

		return coordinationOrderCreatePayload;
	}

	public static Response getCoordinationResponce(Baseorder payload) throws Exception {

		try {
			createCoordApiparams.put("projectId", Helper.getDatastore(Statickeys.projectId));

			coordinationResponse = PostRequest.postRequest(ProductionManager.createPO, createCoordApiparams,
					coordinationOrderCreatePayload, "createPO");

		} catch (Exception e) {
			throw new Exception("Error while getting response of coordination order");
		}
		return coordinationResponse;
	}

	public static Baseorder updateCoordinationOrder(Response responce) throws Exception {
		try {
			if (coordinationResponse != null && coordinationResponse.getStatusCode() == 200) {
				String coordResponceString = coordinationResponse.asPrettyString();
				JsonNode coordNode = coordinationMapper.readTree(coordResponceString);
				baseOrderJsonNode = coordinationMapper.treeToValue(coordNode, Baseorder.class);
			}
		} catch (Exception e) {
			throw new Exception("Error while updating a Coordination order");
		}

		return baseOrderJsonNode;
	}

	public static HashMap<String, Object> createCordParams(String scriptType, int invocationCount) throws Exception {
		createCoordinationParmas.put(Statickeys.stage, Statickeys.coordination);
		createCoordinationParmas.put(Statickeys._customStage, Statickeys.coordination);
		createCoordinationParmas.put(Statickeys.leastStage, Statickeys.deliver);
		createCoordinationParmas.put(Statickeys.__t, Statickeys.Prefab);
	onsiteDateOffset = Helper.setDataForDashboadScript(scriptType, invocationCount);
		createCoordinationParmas.put(Statickeys.coord, DataSourceHelper.activateDataSource ? DataSourceHelper.coordinationDate : Helper.getUtcTimeZone(onsiteDateOffset));
		createCoordinationParmas.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(onsiteDateOffset));
	    return createCoordinationParmas;
	}
}
