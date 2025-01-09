package tests.e2e.services;

import tests.e2e.module.CreatedFrom;

public class CreatedFromDao {

	public static CreatedFrom getCreatedFromDao(String type) throws Exception {
		try {
			CreatedFrom createdFrom = new CreatedFrom();
			createdFrom.setDeviceId("");
			createdFrom.setType(type);
			return createdFrom;
		} catch (Exception e) {
			throw new Exception("Error at CreatedFrom" + e);
		}
	}
}
