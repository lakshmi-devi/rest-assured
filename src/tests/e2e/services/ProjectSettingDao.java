package tests.e2e.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.CompanyLocation;
import tests.e2e.module.ProjectSetting;
import tests.e2e.staticKeys.Statickeys;

public class ProjectSettingDao {

	public static ArrayList<ProjectSetting> getProjectSettingDAO() throws Exception {
		try {
			ArrayList<ProjectSetting> array = new ArrayList<>();
			ProjectSetting setting = new ProjectSetting();

			setting.setCompanyId((String) Helper.getDatastore(Statickeys.companyId));
			setting.setCustomId(Helper.randomNameBuilder(Statickeys.projectid));
			setting.setForgeSync(new HashMap<String, Object>());
			setting.setPTEnabled(true);
			setting.setPrivate(true);
			setting.setNotifications(1);
			setting.setProjectInventoryLocation(CompanyLocationDao.getLocationFromProjectInvenDAO());
			array.add(setting);

			return array;
		} catch (Exception e) {
			throw new Exception("Error While Generate randomNameBuilder" + e);
		}

	}
}
