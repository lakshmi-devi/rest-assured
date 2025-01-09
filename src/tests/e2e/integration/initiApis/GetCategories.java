package tests.e2e.integration.initiApis;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Category;
import tests.e2e.staticKeys.Statickeys;;

public class GetCategories {

	@Test
	public void getCategories() {
		try {
			HashMap<String, Object> catogoriesParams = new HashMap<String, Object>();
			catogoriesParams.put(Statickeys.limit, 2000);

			Response catogoriesResponse = GetRequest.getRequest(Statickeys.getCategories, catogoriesParams,
					"getCategories");

			if (catogoriesResponse != null & catogoriesResponse.statusCode() == 200) {
				String catogoriesResponseStr = catogoriesResponse.asPrettyString();

				List<Object> categoriesList = io.restassured.path.json.JsonPath.from(catogoriesResponseStr)
						.getList("data");
				Category category = (Category) Helper.convertObjectToJavaObject(
						categoriesList.get(Helper.getRandomNumber(categoriesList.size())), Statickeys.category);
				Helper.setDatastore(Statickeys.categories, category);
				System.out.println("Total categories Length : " + categoriesList.size());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
