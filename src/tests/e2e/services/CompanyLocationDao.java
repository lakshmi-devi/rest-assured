package tests.e2e.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Company;
import tests.e2e.module.CompanyLocation;
import tests.e2e.staticKeys.Statickeys;

public class CompanyLocationDao {

	public static CompanyLocation getLocationFromProjectInvenDAO() throws Exception {
		try {
			Company comp = (Company) Helper.getDatastore(Statickeys.company);

			return comp.getCompanyLocations().get(0);
		} catch (Exception e) {
			throw new Exception("Error at getLocationFromProjectInvenDAO" + e);
		}
	}
}
