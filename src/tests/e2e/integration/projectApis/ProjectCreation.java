package tests.e2e.integration.projectApis;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.Test;
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

public class ProjectCreation {

	@Test
	public void createProject() {
		try {

			Form baseOrderCreatePayload = FormDao.getFormDao();

			Response response = PostRequest.postRequest(Statickeys.createProject, new HashMap<String, Object>(),
					baseOrderCreatePayload, "createProject");

			Project projectData = (Project) Helper.convertResponceToJavaObject(response, Statickeys.project);

			System.out.println("Project Created with name" + " : " + projectData.getName());
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}