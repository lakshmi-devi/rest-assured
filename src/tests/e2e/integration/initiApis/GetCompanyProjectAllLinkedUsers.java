package tests.e2e.integration.initiApis;

import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.staticKeys.Statickeys;

public class GetCompanyProjectAllLinkedUsers {

	@Test
	public void getCompanyProjectLinkedUsers() {
		try {
			String projectId = (String) Helper.getDatastore(Statickeys.projectId);
			String companyId = (String) Helper.getDatastore(Statickeys.companyId);

			HashMap<String, Object> companyProjectUsers = new HashMap<String, Object>();
			companyProjectUsers.put(Statickeys.arrayOfProjects, projectId);
			companyProjectUsers.put(Statickeys.arrayOfCompanyIds, companyId);
			companyProjectUsers.put(Statickeys.ignorecompany, true);

			Response companyProjectUserResponse = GetRequest.getRequest(Statickeys.getCompanyProjectAllLinkedUsersRoute,
					companyProjectUsers, "getCompanyProjectAllLinkedUsers");
			
			if (companyProjectUserResponse != null & companyProjectUserResponse.statusCode() == 200) {
				String companyProjectUserResponseStr = companyProjectUserResponse.asPrettyString();
				List<Object> AllLinkedusers = io.restassured.path.json.JsonPath.from(companyProjectUserResponseStr)
						.getList("");
				Helper.setDatastore(Statickeys.getCompanyProjectAllLinkedUsers, AllLinkedusers);
				System.out.println("All project Linked users length : " + AllLinkedusers.size());
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}