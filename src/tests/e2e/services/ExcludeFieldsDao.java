package tests.e2e.services;

import tests.e2e.module.ExcludeFields;

public class ExcludeFieldsDao {

	public static ExcludeFields getExcludeFieldsDAO() throws Exception {
		try {
			return new ExcludeFields();
		} catch (Exception e) {
			throw new Exception("Error at getExcludeFieldsDAO" + e);
		}

	}
}
