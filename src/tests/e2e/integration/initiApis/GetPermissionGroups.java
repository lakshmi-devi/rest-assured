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
import tests.e2e.module.PermissionForUser;
import tests.e2e.staticKeys.Statickeys;

public class GetPermissionGroups {

	@Test
	public void getPermission() {
		try {
			Response permissionResponse = GetRequest.getRequest(Statickeys.getPermissionGroups,
					new HashMap<String, String>(), "getPermissionGroups");
			if (permissionResponse != null & permissionResponse.statusCode() == 200) {
				String permissionStr = permissionResponse.asPrettyString();
				List<Object> permissions = io.restassured.path.json.JsonPath.from(permissionStr).getList("");
				
				PermissionForUser permissionForUser = (PermissionForUser) Helper.convertObjectToJavaObject(
						permissions.get(permissions.size() - 1), Statickeys.permissionforuser);
				Helper.setDatastore(Statickeys.permission, permissionForUser);
				
				System.out.println("Number of Permission For User : " + permissions.size());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}