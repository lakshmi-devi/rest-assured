package tests.e2e.integrationServices;

import java.util.ArrayList;
import java.util.HashMap;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.services.ProjectDao;
import tests.e2e.staticKeys.Statickeys;

public class MoveOrdersService {

	public static int onsiteDate = 0;
	
	
	static HashMap<String, Object> params = new HashMap<>();
	static HashMap<String, Object> quearyParams = new HashMap<String, Object>();
	
	public static HashMap<String, Object> getMoveToPOParams(String scriptType, int invocationCount) throws Exception {
		try {
		params.clear();
		onsiteDate = Helper.setDataForDashboadScript(scriptType, invocationCount);
		params.put(Statickeys.projectId, Helper.getDatastore(Statickeys.projectId));
		params.put(Statickeys.stage, Statickeys.coordination);
		params.put(Statickeys._customStage, "");
		params.put(Statickeys.leastStage, Statickeys.planning);
		params.put(Statickeys.__t, Statickeys.productionOrder);
		params.put(Statickeys.coord, DataSourceHelper.activateDataSource ? DataSourceHelper.coordinationDate : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.moveToPO, Statickeys.moveToCoordination);
		} catch (Exception e) {
			throw new Exception("Error while getting params for Move to PO order");
		}
		return params;
	}
	
	public static HashMap<String, Object> getMoveToDetailingParams() throws Exception {
		try {
		params.clear();
		params.put(Statickeys.deliverDate, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(0));
		params.put(Statickeys.notifyUsers, new ArrayList<>());
		params.put(Statickeys.pTrackEnabled, true);
		params.put(Statickeys.poDetailBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poDetailBy : Helper.getUtcTimeZone(0));
		params.put(Statickeys.poManufactureBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poManufactureBy : Helper.getUtcTimeZone(0));
		} catch (Exception e) {
			throw new Exception("Error while getting MoveToDetailingParams");
		}
		return params;
	}
	
	public static HashMap<String, Object> getmoveToManufacturing(String scriptType, int invocationCount) throws Exception {
		try {
		params.clear();
		onsiteDate = Helper.setDataForDashboadScript(scriptType, invocationCount);
		params.put(Statickeys.projectId, Helper.getDatastore(Statickeys.projectId));
		params.put(Statickeys.stage, Statickeys.manufacturing);
		params.put(Statickeys.__t, Statickeys.productionOrder);
		params.put(Statickeys.coord, DataSourceHelper.activateDataSource ? DataSourceHelper.coordinationDate : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.coordedAt, DataSourceHelper.activateDataSource ? DataSourceHelper.coordedAt : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.detailBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poDetailBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.manufactureBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poManufactureBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.detailedAt, DataSourceHelper.activateDataSource ? DataSourceHelper.detailedAt : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.moveToManuf, Statickeys.moveToManufacturing);

		} catch (Exception e) {
			throw new Exception("Error while getting params for Move to Manufacturing order");
		}
		return params;
	}

	public static HashMap<String, Object> getmoveToQA(String scriptType, int invocationCount) throws Exception {
		try {
		params.clear();
		onsiteDate = Helper.setDataForDashboadScript(scriptType, invocationCount);
		
		params.put(Statickeys.projectId, Helper.getDatastore(Statickeys.projectId));
		params.put(Statickeys.stage, Statickeys.qa);
		params.put(Statickeys.__t, Statickeys.productionOrder);
		params.put(Statickeys.coord, DataSourceHelper.activateDataSource ? DataSourceHelper.coordinationDate : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.deliver, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.poDetailBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poDetailBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.poManufactureBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poManufactureBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.coordedAt, DataSourceHelper.activateDataSource ? DataSourceHelper.coordedAt : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.detailBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poDetailBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.manufactureBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poManufactureBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.detailedAt, DataSourceHelper.activateDataSource ? DataSourceHelper.detailedAt : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.qaBy, DataSourceHelper.activateDataSource ? DataSourceHelper.poQaBy : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.manufacturedAt, DataSourceHelper.activateDataSource ? DataSourceHelper.manufacturedAt : Helper.getUtcTimeZone(onsiteDate));
		params.put(Statickeys.moveToQA, Statickeys.moveToQa);
		} catch (Exception e) {
			throw new Exception("Error while getting params for Move to Manufacturing order");
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
