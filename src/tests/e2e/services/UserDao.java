package tests.e2e.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.User;
import tests.e2e.staticKeys.Statickeys;

public class UserDao {

	public static User getUserDAO() throws Exception {
		try {
			User ownerJsonNode = null;
			User user = new User();

			Object ownerValue = Helper.getDatastore(Statickeys.owner);
			ownerJsonNode = (User) Helper.convertObjectToJavaObject(ownerValue, Statickeys.user);

			user.set_id(ownerJsonNode.get_id());
			user.setName(ownerJsonNode.getName());
			user.setId(ownerJsonNode.getId());
			user.setActivated(ownerJsonNode.isActivated());
			user.setAdmin(ownerJsonNode.isAdmin());
			user.setCompany(ownerJsonNode.getCompany());
			user.setCompanyName(ownerJsonNode.getCompanyName());
			user.setEmail(ownerJsonNode.getEmail());
			user.setFirstName(ownerJsonNode.getFirstName());
			user.setFullName(ownerJsonNode.getFullName());
			user.setLastName(ownerJsonNode.getLastName());
			user.setMemberRole(ownerJsonNode.getMemberRole());
			user.setMultiCompanies(ownerJsonNode.getMultiCompanies());
			user.setNameWithCompany(ownerJsonNode.getNameWithCompany());
			user.setPermissionSettings(ownerJsonNode.getPermissionSettings());
			user.setProjectId(ownerJsonNode.getProjectId());
			user.setRole(ownerJsonNode.getRole());

			return user;
		} catch (Exception e) {
			throw new Exception("Error at getUserDAO" + e);
		}
	}
}
