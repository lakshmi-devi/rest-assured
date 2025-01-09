package tests.e2e.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.LinkedProjectSetting;
import tests.e2e.module.Location;
import tests.e2e.module.Project;
import tests.e2e.module.ProjectOwner;
import tests.e2e.module.ProjectSetting;
import tests.e2e.module.User;
import tests.e2e.staticKeys.Statickeys;

public class ProjectDao {

	public static Project getProjectDAO() throws Exception {
		try {
			Project project = (Project) Helper.getDatastore(Statickeys.project);
			return project;
		} catch (Exception e) {
			throw new Exception("Error at getProjectDAO" + e);
		}
	}

	public static Project getProjectCreateupdatePayload() throws Exception {
		try {
			Project project = new Project();
			User newJsonNode = null;

			project.setLinkedProjectSetting(LinkedProjectSettingDao.getLinkedProjectDAO());
			project.setProjectOwner(ProjectOwnerDao.getProjectOwnerDAO());
			project.setProjectSettings(ProjectSettingDao.getProjectSettingDAO());
			project.setName(Helper.randomNameBuilder("projects"));
			project.setLocation(LocationDao.getProjectLocationDAO());

			Object ownerValue = Helper.getDatastore(Statickeys.owner);
			newJsonNode = (User) Helper.convertObjectToJavaObject(ownerValue, Statickeys.user);

			project.setContactEmail(newJsonNode.getEmail());
			project.setISTemplateProject(false);
			return project;
		} catch (Exception e) {
			throw new Exception("Error at getProjectCreateupdatePayload" + e);
		}
	}

	public static Project getTemplateProjectDAO() throws Exception {
		try {
			Project project = (Project) Helper.getDatastore(Statickeys.templateProject);
			return project;
		} catch (Exception e) {
			throw new Exception("Exception during getTemplate project from datastore in projectDao");
		}
	}

	public static Project ryvitProjectDAO() throws Exception {

		try {
			Project project = new Project();
			User ownerJsonNode = null;

			Object projectOwnerValue = Helper.getDatastore(Statickeys.owner);
			ownerJsonNode = (User) Helper.convertObjectToJavaObject(projectOwnerValue, Statickeys.user);
			;

			project.setContactEmail(ownerJsonNode.getEmail());
			project.setCustomId(Helper.randomNameBuilder("projectid"));
			project.setLocation(LocationDao.getProjectLocationDAO());
			project.setName(Helper.randomNameBuilder("projects"));

			return project;
		} catch (Exception e) {
			throw new Exception("Error while get ryvitProjectDAO" + e);
		}

	}
}
