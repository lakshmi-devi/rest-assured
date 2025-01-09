package tests.e2e.integrationServices;

import java.util.HashMap;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.endPoints.ProductionManager;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.staticKeys.Statickeys;

public class CutOrderService {
	public static int onsiteDateOffset = 0;
	static Baseorder createCutOrderPayload;
	static HashMap<String,Object> createCutOrderParams = new HashMap<String,Object>();
	static Response CutOrderResponse;
	static HashMap<String, Object> createCutOrderApiParams = new HashMap<>();
	

	public static Baseorder getCutOrderPayload(String scriptType, HashMap<String, Object> createCutOrderParmas) throws Exception{
		
			try {

				createCutOrderPayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create,
						Statickeys.detailing, null, createCutOrderParams);

			} catch (Exception e) {
				throw new Exception("Error while getting Payload of coordination Response order");
			}

			return createCutOrderPayload;	
		}
	
	public static Response getCutOrderResponce(Baseorder payload) throws Exception {

		try {
			createCutOrderApiParams.put("projectId", Helper.getDatastore(Statickeys.projectId));

			CutOrderResponse = PostRequest.postRequest(ProductionManager.createPO, createCutOrderApiParams,
					createCutOrderPayload, "createCutOrder");

		} catch (Exception e) {
			throw new Exception("Error while getting response of Cut order");
		}
		return CutOrderResponse;
	}
	
	public static HashMap<String,Object> createCutOrderParams(String scriptType,int invocationCount) throws Exception{
		
		createCutOrderParams.put(Statickeys.stage, Statickeys.detailing);
		createCutOrderParams.put(Statickeys._customStage, Statickeys.detailing);
		createCutOrderParams.put(Statickeys.leastStage, Statickeys.delivery);
		createCutOrderParams.put(Statickeys.__t, Statickeys.Prefab);
		onsiteDateOffset = Helper.setDataForDashboadScript(scriptType, invocationCount);
		createCutOrderParams.put(Statickeys.coord, DataSourceHelper.activateDataSource ? DataSourceHelper.coordinationDate : Helper.getUtcTimeZone(onsiteDateOffset));
		createCutOrderParams.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(onsiteDateOffset));
		return createCutOrderParams;	
	}
	
	}
