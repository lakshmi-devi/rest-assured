package tests.e2e.integration.initiApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.AllLocations;
import tests.e2e.staticKeys.Statickeys;

public class GetAllLocationsForUser {

	@Test
	public void getAllLocation() throws IOException {

		try {
			String projectId = (String) Helper.getDatastore(Statickeys.projectId);

			HashMap<String, ArrayList<String>> projectsArray = new HashMap<String, ArrayList<String>>();

			ArrayList<String> projectIds = new ArrayList<>();
			projectIds.add(projectId);
			projectsArray.put(Statickeys.projectId, projectIds);

			Response response = PostRequest.postRequest(Statickeys.getAllLocations, new HashMap<Object, Object>(),
					projectsArray, "getAllLocations");

			if (response != null & response.statusCode() == 200) {
				String getAllLocationsStr = response.asPrettyString();
				List<Object> AllLocation = io.restassured.path.json.JsonPath.from(getAllLocationsStr).getList("");

//				for (int i = 0; i < AllLocation.size(); i++) {
//					try {
//						AllLocations userlocation = (AllLocations) Helper.convertObjectToJavaObject(AllLocation.get(i),
//								Statickeys.allLocations);
//					} catch (Exception e) {
//						System.out.println(e);
//					}
//				}
				Helper.setDatastore(Statickeys.AllLocations, AllLocation);
				System.out.println("Number of locations : " + AllLocation.size());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
