package tests.e2e.integrationServices;

import java.util.HashMap;

import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.services.ProjectDao;
import tests.e2e.staticKeys.Statickeys;

public class KitLifeCycleService {
	static HashMap<String, Object> params = new HashMap<String, Object>();
	static HashMap<String, Object> quearyParams = new HashMap<String, Object>();
	public static int onsiteDate = 0;
	
	public static HashMap<String, Object> getKitCreateParams(String scriptType, int invocationCount) throws Exception {
		try {
		onsiteDate = Helper.setDataForDashboadScript(scriptType, invocationCount);
		
		params.clear();
		params.put(Statickeys.stage, Statickeys.planning);
		params.put(Statickeys._customStage, Statickeys.planning);
		params.put(Statickeys.leastStage, Statickeys.deliver);
		params.put(Statickeys.__t, Statickeys.prefab);
		params.put(Statickeys.coord, Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.poDetailBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poDetailBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.partsManufactureBy, DataSourceHelper.activateDataSource ? DataSourceHelper.partsManufactureBy :Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.poManufactureBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poManufactureBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.poQaBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poQaBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.purpose, Statickeys.kit);
		} catch (Exception e) {
			throw new Exception("Error while getting kit Create params", e);
		}
		return params;
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
