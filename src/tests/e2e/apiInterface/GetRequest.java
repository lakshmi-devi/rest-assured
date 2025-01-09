package tests.e2e.apiInterface;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import tests.e2e.assertActions.StatusAssertion;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.staticKeys.Statickeys;

public class GetRequest {

	
	
	public static Response getRequest(String apiRoute, Map queryParam, String module) throws Exception {
		Response response = null;
		String startTime = Helper.getUtcTimeZone();
		try {
			String token = (String) Helper.getDatastore(Statickeys.token);
			
			RestAssured.baseURI = (String) DataStore.getInstance().getProperty(Statickeys.url);
			response = given().header("content-type", "application/json").header(Statickeys.authorization, token)
					.queryParams(queryParam).when().get(apiRoute);
			

		} catch (Exception e) {
			throw new Exception("Error while GET request" + e.getStackTrace());
		}finally {
			Helper.logRequestduration("GET", apiRoute, response, startTime, module);
			StatusAssertion.statusAssertion(response);
			System.out.println("");
		}
		return response;
	}
}
