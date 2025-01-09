package tests.e2e.integration.initiApis;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.DefaultRunNew;
import tests.e2e.staticKeys.Statickeys;

public class GetCompanyRunsNew {

	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void getCompanyRuns() throws IOException {

		try {
			HashMap<String, Object> companyRunsParams = new HashMap<String, Object>();
			companyRunsParams.put("type", Statickeys.companyRuns);

			Response companyRunsResponse = GetRequest.getRequest(Statickeys.getCompanyRuns, companyRunsParams,
					"getCompanyRuns");

			if (companyRunsResponse != null && companyRunsResponse.statusCode() == 200) {
				String companyRunsResponseStr = companyRunsResponse.asPrettyString();
				List<Object> companyRuns = io.restassured.path.json.JsonPath.from(companyRunsResponseStr).getList("");

				String companyRun = mapper.writeValueAsString(companyRuns.get(0));
				JsonPath companyRunJs = new JsonPath(companyRun);

				DefaultRunNew defaultRun = new DefaultRunNew();
				defaultRun.set_id(companyRunJs.getString("_id"));
				defaultRun.setName(companyRunJs.getString("name"));

				Helper.setDatastore(Statickeys.defaultRun, defaultRun);
				System.out.println("Total Company Runs : " + companyRuns.size());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
