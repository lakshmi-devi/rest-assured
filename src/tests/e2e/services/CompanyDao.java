package tests.e2e.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Company;
import tests.e2e.staticKeys.Statickeys;

public class CompanyDao {

	public static Company getCompanyDAO() throws Exception {
		try {
			Company companyJsonNode = null;

			Object ownerValue = Helper.getDatastore(Statickeys.company);
			companyJsonNode = (Company) Helper.convertObjectToJavaObject(ownerValue, Statickeys.company);

			Company company = new Company();
			company.setName(companyJsonNode.getName());
			company.setId(companyJsonNode.getId());
			company.set_id(companyJsonNode.get_id());

			return company;
		} catch (Exception e) {
			throw new Exception("Error at getCompanyDAO" + e);
		}
	}
}
