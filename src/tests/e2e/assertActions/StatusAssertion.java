package tests.e2e.assertActions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import io.restassured.response.Response;

public class StatusAssertion {

	public static void statusAssertion(Response response) throws Exception {
		try {
			if (response != null) {
				int statusCode = response.getStatusCode();
				if (statusCode == 500) {
					System.err.println("500" + response.body().asPrettyString());
				} else if (statusCode == 400) {
					System.err.println(
							"400: The server did not understand the request --> " + response.body().asPrettyString());
				} else if (statusCode == 401) {
					System.err.println("401: The requested page needs a username and a password -->"
							+ response.body().asPrettyString());
				} else if (statusCode == 404) {
					System.err.println(
							"404: server can not find the requested page -->" + response.body().asPrettyString());
				} else if (statusCode == 403) {
					System.err.println(
							"403: Access is forbidden to the requested page -->" + response.body().asPrettyString());
				} else if (statusCode == 304) {
					System.err.println("304: The URL has not been modified since the specified date -->"
							+ response.body().asPrettyString());
				} else if (statusCode == 502) {
					System.err.println(
							"502: The request was not completed. The server received an invalid response from the upstream server --> "
									+ response.body().asPrettyString());
				} else if (statusCode == 504) {
					System.err.println("504: The gateway has timed out -->" + response.body().asPrettyString());
				} else if (statusCode != 200) {
					System.err.println(statusCode + response.body().asPrettyString());
				}
				if (!AssertionValidator.isNegativeAssertion) {
					assertEquals(statusCode, 200);
				}
			} else {
				throw new Exception("Response returned null");
			}
		} catch (Exception e) {
			throw new Exception("Error While statusAssertion" + e);
		} finally {
			AssertionValidator.isNegativeAssertion = false;
		}
	}
}
