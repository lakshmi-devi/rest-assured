package tests.e2e.assertActions;

import static org.testng.Assert.assertTrue;

import java.util.List;

import io.restassured.response.Response;

public class SupplyChainAssertion {

	public static void dataLengthAssertion(Response response) throws Exception {
		try {
			if (response != null) {
				String responceString = response.asPrettyString();
				List<Object> Orders = io.restassured.path.json.JsonPath.from(responceString).getList("data");
				assertTrue(Orders.size() > 0);
			}
		} catch (Exception e) {
			throw new Exception("Error While SupplyChain Assertion" + e);
		}
	}
}
