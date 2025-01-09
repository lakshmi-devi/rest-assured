package tests.e2e.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.staticKeys.Statickeys;

public class CategoriesDao {

	public static List<Object> getSubCategories(String categorieId) throws Exception {
		try {
			HashMap<String, Object> quries = new HashMap<String, Object>();
			quries.put(Statickeys.categoryId, categorieId);

			Response response = GetRequest.getRequest(Statickeys.getSubCategories, quries, "getSubCategories");

			String str = response.asPrettyString();
			List<Object> subCategories = io.restassured.path.json.JsonPath.from(str).getList("");
			return subCategories;
		} catch (Exception e) {
			throw new Exception("Error While getSubCategories" + e);
		}
	}
}
