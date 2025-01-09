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

public class PostRequest {

	static String token = (String) DataStore.getInstance().getProperty(Statickeys.token);
	
	public static Response postRequest(String apiRoute, Map queryParam, Object body, String module) throws Exception {
		Response response = null;
		String startTime = Helper.getUtcTimeZone();
		try {
			RestAssured.baseURI = (String) Helper.getDatastore(Statickeys.url);
			response = given().header("content-type", "application/json")
					.header(Statickeys.authorization, token).header("User-Agent", "From API Automation Script").queryParams(queryParam).body(body).when()
					.post(apiRoute);
		} catch (Exception e) {
			throw new Exception("error while POST request" + e.getStackTrace());
		}finally {
			System.out.println("");
			Helper.logRequestduration("POST", apiRoute, response, startTime, module);
			StatusAssertion.statusAssertion(response);
		} 

		return response;
	}
}
