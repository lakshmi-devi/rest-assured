package tests.e2e.services;

import tests.e2e.module.Actual;

public class ActualDao {

	public static Actual getactualDAO(String actualQty) throws Exception {
		Actual actual = null;
		try {
			actual = new Actual();
			actual.setQuantity(actualQty);
		} catch (Exception e) {
			throw new Exception("Error while getting Actual DAO");
		}
		return actual;

	}
}
