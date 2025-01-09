package tests.e2e.integrationServices;

import java.util.HashMap;

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
import tests.e2e.services.LastModifiedDao;
import tests.e2e.services.ProjectDao;
import tests.e2e.staticKeys.Statickeys;

public class ManufacturingService {
	static Baseorder ManufacturingOrderCreatePayload;
	public static int onsiteDateOffset = 0;
	static HashMap<String, Object> createManufParmas = new HashMap<>();
	static HashMap<String, Object> createManufApiparams = new HashMap<String, Object>();
	static HashMap<String, Object> quearyParams = new HashMap<String, Object>();
	static Response ManufacturingResponse;
	static Baseorder manufacturingOrderCreateResponce;
	static Baseorder manufacturingOrderUpdateResponce;
	static ObjectMapper manufacturingMapper = new ObjectMapper();

	public static Baseorder getManufacturingPayload(String scriptType,
			HashMap<String, Object> createManufacturingParmas) throws Exception {
		try {

			ManufacturingOrderCreatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create,
					Statickeys.manufacturing, null, createManufacturingParmas);

		} catch (Exception e) {
			throw new Exception("Error while getting Payload of manufacturing order");
		}

		return ManufacturingOrderCreatePayload;
	}

	public static Response getManufacturingResponce(Baseorder payload) throws Exception {

		try {
			createManufApiparams.put("projectId", Helper.getDatastore(Statickeys.projectId));

			ManufacturingResponse = PostRequest.postRequest(ProductionManager.createPO, createManufApiparams,
					ManufacturingOrderCreatePayload, "createPO");

		} catch (Exception e) {
			throw new Exception("Error while getting response of Manufacturing order");
		}
		return ManufacturingResponse;
	}

	public static Baseorder updateManufacturingOrder(Response responce) throws Exception {
		try {
			if (ManufacturingResponse != null && ManufacturingResponse.getStatusCode() == 200) {
				manufacturingOrderCreateResponce = (Baseorder) Helper.convertResponceToJavaObject(responce, Statickeys.baseorder);
				String PMUpdateRoute = ProductionManager.getPMUpdateRoutes(manufacturingOrderCreateResponce.get_id());
				int runCount = manufacturingOrderCreateResponce.getManager().getRuns().size();

				for (int runIndex = 0; runIndex < runCount; runIndex++) {
					manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex)
							.setModified(LastModifiedDao.lastModifiedDAO());
					manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex).setCompleted(true);
					manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex).setEditing(true);
					manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex).setEditing(true);

					int RuntemCount = manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex)
							.getRunItemsCount().size();

					for (int runItemIndex = 0; runItemIndex < RuntemCount; runItemIndex++) {

						manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex).getRunItemsCount()
								.get(runItemIndex).setRiCompleted(true);
					}
				}

				Response updateResponse = PostRequest.postRequest(PMUpdateRoute, createManufApiparams,
						manufacturingOrderCreateResponce, "UpdatePM");

				manufacturingOrderUpdateResponce = (Baseorder) Helper.convertResponceToJavaObject(updateResponse, Statickeys.baseorder);

			}
		} catch (Exception e) {
			throw new Exception("Error while updating a Manufacturing order");
		}

		return manufacturingOrderUpdateResponce;
	}
	
	public static HashMap<String, Object> createManufParams(String scriptType, int invocationCount) throws Exception {
		createManufParmas.put(Statickeys.stage, Statickeys.manufacturing);
		createManufParmas.put(Statickeys._customStage, Statickeys.manufacturing);
		createManufParmas.put(Statickeys.leastStage, Statickeys.deliver);
		createManufParmas.put(Statickeys.__t, Statickeys.Prefab);
		
		onsiteDateOffset = Helper.setDataForDashboadScript(scriptType, invocationCount);
		createManufParmas.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(onsiteDateOffset));
		
		createManufParmas.put(Statickeys.poManufactureBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poManufactureBy : Helper.getUtcTimeZone(onsiteDateOffset));
		return createManufParmas;
	}
	
	public static HashMap<String, Object> getQuearyParams() throws Exception {
		try {
			quearyParams.put("projectId", ProjectDao.getProjectDAO().get_id());
		} catch (Exception e) {
			throw new Exception("Error while getting template queary params");
		}
		return quearyParams;
	}

}
