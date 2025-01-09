package tests.e2e.services;

import tests.e2e.module.Summary;

public class SummaryDao {

	public static Summary getSummaryDAO(int instoragrQty, int inTransitQTy, int inventoryQty) throws Exception {
		try {
			Summary summary = new Summary();
			summary.setInStorage(instoragrQty);
			summary.setInTransit(inTransitQTy);
			summary.setInventory(inventoryQty);
			return summary;
		} catch (Exception e) {
			throw new Exception("Error at getSummaryDAO" + e);
		}
	}
}
