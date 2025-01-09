package tests.e2e.integration.initiApis;

import tests.e2e.assertActions.LoginAssertion;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.module.Login;
import tests.e2e.module.Me;
import tests.e2e.services.LoginDao;
import tests.e2e.staticKeys.Statickeys;
import groovyjarjarpicocli.CommandLine.Parameters;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginInit {

	static String token = "";

	@org.testng.annotations.Parameters({ "user", "instance" , "email", "pwd"})
	@Test
	public void login(String user, String instance, String email, String password) {
		try {
			
			/*Set Data source*/
			System.out.println("The thread ID for login method is "+ Thread.currentThread().getId());
			DataSourceHelper.getInstance().setProerty();
			
			Helper.setDatastore(Statickeys.log, "");

			Login loginPayload = LoginDao.getLoginDetails(user, email, password);

			RestAssured.baseURI = Helper.getbaseUrl(instance);

			Response loginResponse = given().header("content-type", "application/json")
					.header("User-Agent", "Automation").body(loginPayload).when().post(Statickeys.login);

			Me meDetails =  (Me) Helper.convertResponceToJavaObject(loginResponse, Statickeys.login );
			
			
			//store Resolved Permission Group
			
			Helper.setDatastore(Statickeys.permissionGroup, meDetails.getUser().getResolvedPermissionGroups());
			
			// Store token
			String loginResponce = loginResponse.then().extract().response().asString();

			if (loginResponce != null) {

				JsonPath loginResponceJsonPath = new JsonPath(loginResponce);

				Helper.setDatastore(Statickeys.url, Helper.getbaseUrl(instance));
				Helper.setDatastore(Statickeys.token, loginResponceJsonPath.get(Statickeys.token));
				Helper.setDatastore(Statickeys.companyId, loginResponceJsonPath.getString("user.company._id"));
				Helper.setDatastore(Statickeys.ownerName, loginResponceJsonPath.getString("user.fullName"));
				Helper.setDatastore(Statickeys.companyName, loginResponceJsonPath.getString("user.companyName"));

				System.out.println("Login Sucess with token : " + loginResponceJsonPath.get(Statickeys.token));

				LoginAssertion.loginAssertion(loginResponse);
			}
		} catch (Exception e) {
			System.err.println("Error while Login");
			
		}

	}
	
	@Test
	public void dummy() {
		System.out.println("The thread ID for dummy is "+ Thread.currentThread().getId());
		System.out.println("testing here");
		
	}

}
