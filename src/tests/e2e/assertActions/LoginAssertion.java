package tests.e2e.assertActions;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class LoginAssertion {

	public static void loginAssertion(Response responce) throws Exception {
		try {
			if (responce != null) {
				// Source:
				// http://hamcrest.org/JavaHamcrest/javadoc/1.3/org/hamcrest/Matchers.html
				responce.then().body("result", equalTo("success"));
			}
		} catch (Exception e) {
			throw new Exception("Error While Login Assertion" + e);
		}
	}
}
