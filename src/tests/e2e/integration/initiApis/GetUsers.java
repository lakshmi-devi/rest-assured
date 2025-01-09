package tests.e2e.integration.initiApis;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.staticKeys.Statickeys;

public class GetUsers {

	@Parameters({ "user" })
	@Test
	public void getUser() {
		try {
			String projectId = (String) Helper.getDatastore(Statickeys.projectId);

			HashMap<String, Object> userParams = new HashMap<String, Object>();
			userParams.put("project_id", projectId);
			userParams.put(Statickeys.limit, 1000);
			userParams.put(Statickeys.sort, "name");
			userParams.put(Statickeys.listActivatedUsers, true);

			Response userResponse = GetRequest.getRequest(Statickeys.getUser, userParams, "getUser");

			if (userResponse != null & userResponse.statusCode() == 200) {

				String userResponseStr = userResponse.asPrettyString();
				List<Object> users = io.restassured.path.json.JsonPath.from(userResponseStr).getList("items");

				Helper.setDatastore(Statickeys.ownerList, users);

				for (int i = 0; i < users.size(); i++) {
					// convert to String
					ObjectMapper userMapper = new ObjectMapper();
					String userJson = userMapper.writeValueAsString(users.get(i));

					if (userJson.contains(Helper.getDatastore(Statickeys.ownerName).toString())) {
						Helper.setDatastore(Statickeys.owner, users.get(i));
					}
				}
				System.out.println("Users Length: " + users.size());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
