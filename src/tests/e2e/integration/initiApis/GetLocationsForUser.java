package tests.e2e.integration.initiApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.LocationForUser;
import tests.e2e.staticKeys.Statickeys;

public class GetLocationsForUser {

	@Test
	public void getLocationsForUser() {
		try {
			ArrayList<String> location = new ArrayList<String>();
			String projectId = (String) Helper.getDatastore(Statickeys.projectId);
			String companyId = (String) Helper.getDatastore(Statickeys.companyId);

			HashMap<String, Object> locationForUserparams = new HashMap<String, Object>();
			locationForUserparams.put(Statickeys.arrayOfProjects, projectId);
			locationForUserparams.put(Statickeys.companyId, companyId);

			Response locationForUserResponse = GetRequest.getRequest(Statickeys.getLocation, locationForUserparams,
					"getLocationsForUser");

			if (locationForUserResponse != null & locationForUserResponse.statusCode() == 200) {

				String locationForUserStr = locationForUserResponse.asPrettyString();
				List<Object> locationsList = io.restassured.path.json.JsonPath.from(locationForUserStr).getList("");
				int index = Helper.getRandomNumber(locationsList.size());
				LocationForUser locationForUser = (LocationForUser) Helper
						.convertObjectToJavaObject(locationsList.get(index), Statickeys.locationsForUser);
				Helper.setDatastore(Statickeys.locationsForUser, locationForUser);
				System.out.println("Locations For User length: " + locationsList.size());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
