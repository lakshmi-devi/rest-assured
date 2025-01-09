package tests.e2e.services;

import tests.e2e.module.StageMap;

public class StageMapDao {

	public static StageMap getStageMapDAO(int inTransitQty) throws Exception {
    	try {
		StageMap stage = new StageMap();
    	stage.setInTransit(inTransitQty);
		return stage;
    	} catch (Exception e) {
			throw new Exception("Error at getStageMapDAO" + e);
		}
    }
}
