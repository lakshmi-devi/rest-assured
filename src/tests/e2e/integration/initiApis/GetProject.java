package tests.e2e.integration.initiApis;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Project;
import tests.e2e.staticKeys.Statickeys;

import org.json.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.*;
import com.fasterxml.jackson.databind.json.*;

public class GetProject {
	@Parameters({ "user", "projectId" })
	@Test
	public void getProject(String user, String projectId) {
		try {

			String sourceProject = Helper.getProjectName(user, projectId);

			HashMap<String, Object> projectParams = new HashMap<String, Object>();
			projectParams.put(Statickeys.childProjects, true);
			projectParams.put(Statickeys.forMembersOnly, true);
			projectParams.put(Statickeys.parentProject, true);
			projectParams.put(Statickeys.populateData, true);
			projectParams.put(Statickeys.showArchived, false);
			projectParams.put(Statickeys.showTemplate, true);
			projectParams.put(Statickeys.companyId, Helper.getDatastore(Statickeys.companyId));
			projectParams.put(Statickeys.sort, "activity");

			Response projectResponse = GetRequest.getRequest(Statickeys.getProjectForUser, projectParams, "getProject");

			if (projectResponse != null & projectResponse.statusCode() == 200) {
				String projectStr = projectResponse.asPrettyString();
				List<Object> projects = io.restassured.path.json.JsonPath.from(projectStr).getList("");

				for (int i = 0; i < projects.size(); i++) {
					Project projectData = (Project) Helper.convertObjectToJavaObject(projects.get(i),
							Statickeys.project);
					if (projectData.getId().equals(sourceProject)) {
						Helper.setDatastore(Statickeys.projectId, projectData.getId());
						Helper.setDatastore(Statickeys.project, projectData);
						System.out.println(projectData.getName()+ " : Project Activated");
					}
					if (projectData.isISTemplateProject() == true) {
						Helper.setDatastore(Statickeys.templateProject, projectData);
					}
				}
			}
			
		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}
}
