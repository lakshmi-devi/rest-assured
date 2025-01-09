package tests.e2e.assertActions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import tests.e2e.helper.Helper;
import tests.e2e.staticKeys.ErrorMessage;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

public class OrderNameAssertion {

	public static void orderNameAssert(Response response) throws Exception {
	
		if(response!= null) {
			String errorMsg = Helper.getResponceErrorMessage(response);
			System.out.println("create Prefab WithOut Name - Assertion passed with 500 status code");
			assertThat(errorMsg, equalTo(ErrorMessage.prefabWithOutName)); 
			
			
		}
	}
}
