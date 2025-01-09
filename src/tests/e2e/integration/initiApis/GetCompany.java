package tests.e2e.integration.initiApis;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Company;
import tests.e2e.staticKeys.Statickeys;

public class GetCompany {

	@Test
	public void getCompany() throws IOException {
		try {
			String projectId = (String) Helper.getDatastore(Statickeys.projectId);
			String companeyId = (String) Helper.getDatastore(Statickeys.companyId);

			HashMap<String, Object> companyParams = new HashMap<String, Object>();
			companyParams.put(Statickeys.id, companeyId);

			Response companyResponse = GetRequest.getRequest(Statickeys.getCompany, companyParams, "getCompany");

			if (companyResponse != null & companyResponse.statusCode() == 200) {
				Company company = (Company) Helper.convertResponceToJavaObject(companyResponse, Statickeys.company);
				Helper.setDatastore(Statickeys.company, company);
				System.out.println("Company based on projectID and CompanyID : " + company.getName());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
