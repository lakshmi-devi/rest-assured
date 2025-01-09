package tests.e2e.services;

import tests.e2e.module.Specification;

public class SpecificationDao {

	public static Specification SpecificationDao(String itemType, int itemValue) throws Exception {
		try {
			Specification specification = new Specification();
			specification.setItemType(itemType);
			specification.setValue(itemValue);
			specification.setComplete(false);
			return specification;
		} catch (Exception e) {
			throw new Exception("Error at SpecificationDao" + e);
		}

	}
}
