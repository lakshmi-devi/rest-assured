package tests.e2e.integrationServices;

import java.util.ArrayList;
import java.util.HashMap;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.module.BaseDelivery;
import tests.e2e.module.Baseorder;
import tests.e2e.module.Shipping;
import tests.e2e.module.User;
import tests.e2e.services.BaseDeliveryDao;
import tests.e2e.services.UserDao;
import tests.e2e.staticKeys.Statickeys;

public class RequestingService {

	public static int onsiteDate = 0;
	static HashMap<String, Object> params = new HashMap<String, Object>();

	public static HashMap<String, Object> getcreateRequestingCardParams(String scriptType, int invocationCount)
			throws Exception {
		try {
			onsiteDate = Helper.setDataForDashboadScript(scriptType, invocationCount);
			
			params.clear();
			params.put(Statickeys.projectId, Helper.getDatastore(Statickeys.projectId));
			params.put(Statickeys.__t, Statickeys.Materials);
			params.put(Statickeys.stage, Statickeys.preparation);
			params.put(Statickeys._customStage, Statickeys.preparation);
			params.put(Statickeys.leastStage, Statickeys.ordering);
			params.put(Statickeys.orderBy, DataSourceHelper.activateDataSource ? DataSourceHelper.orderBy : Helper.getUtcTimeZone(onsiteDate));
			params.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(onsiteDate));
			params.put("_id", "");
			
		} catch (Exception e) {
			throw new Exception("Error while getting requestingOrderParams");
		}
		return params;
	}
}
