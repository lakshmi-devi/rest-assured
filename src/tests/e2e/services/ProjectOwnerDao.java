package tests.e2e.services;

import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.ProjectOwner;
import tests.e2e.module.User;
import tests.e2e.staticKeys.Statickeys;

public class ProjectOwnerDao {

	public static ProjectOwner getProjectOwnerDAO() throws Exception {
		try {
			ProjectOwner owner = new ProjectOwner();
			
			Object users = Helper.getDatastore(Statickeys.owner);
			User username = (User) Helper.convertObjectToJavaObject(users, Statickeys.user);
			
			owner.setFirstName(username.getFirstName());
			owner.setLastName(username.getLastName());
			owner.setCompany(CompanyDao.getCompanyDAO());
			owner.setLevels(new ArrayList<Object>());
			owner.setZones(new ArrayList<Object>());
			owner.setEmail(username.getEmail());

			return owner;
		} catch (Exception e) {
			throw new Exception("Error at getProjectOwnerDAO" + e);
		}
	}
}
