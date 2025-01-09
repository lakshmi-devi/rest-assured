package tests.e2e.integration.ryvitApis;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.helper.Helper;
import tests.e2e.module.Form;
import tests.e2e.module.Project;
import tests.e2e.services.FormDao;
import tests.e2e.services.ProjectDao;
import tests.e2e.staticKeys.Statickeys;

public class RyvitCreateProject {

	@Test
	public void createProject() {
		try {

			HashMap<String, Object> project = new HashMap<>();

			Form createRyvitProjectPayload = FormDao.getRyvitFormDao();
			
			Response createProjectResponse = PostRequest.postRequest(Statickeys.createRyvitProject, project,
					createRyvitProjectPayload, "CreateRyvitProject");

			Project ryvitProjectData = (Project) Helper.convertResponceToJavaObject(createProjectResponse, Statickeys.project);
			
			System.out.println("Ryvit project Created with name : " + ryvitProjectData.getName());
		
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
