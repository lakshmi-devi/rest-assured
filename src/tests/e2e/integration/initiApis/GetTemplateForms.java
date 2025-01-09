package tests.e2e.integration.initiApis;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.TemplateForms;
import tests.e2e.staticKeys.Statickeys;

public class GetTemplateForms {

	@Test
	public void getFormsTemplate() {
		try {
			Response templateFormsresponse = GetRequest.getRequest(Statickeys.getTemplateForms,
					new HashMap<Object, Object>(), "getTemplateForms");

			if (templateFormsresponse != null & templateFormsresponse.statusCode() == 200) {
				String templateFormStr = templateFormsresponse.asPrettyString();
				List<Object> templateFormsList = io.restassured.path.json.JsonPath.from(templateFormStr)
						.getList("data");
				int index = Helper.getRandomNumber(templateFormsList.size());

				TemplateForms templateForms = (TemplateForms) Helper
						.convertObjectToJavaObject(templateFormsList.get(index), Statickeys.TemplateForms);
				Helper.setDatastore(Statickeys.TemplateForms, templateForms);

				System.out.println("Forms template Length :" + " " + templateFormsList.size());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
