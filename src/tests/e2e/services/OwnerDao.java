package tests.e2e.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tests.e2e.module.Company;
import tests.e2e.module.Owner;
import tests.e2e.module.User;

public class OwnerDao {
	public static Owner getOwnerDAO() throws Exception {
		try {
			Owner own = new Owner();
			own.setUser(UserDao.getUserDAO());
			own.setCompany(CompanyDao.getCompanyDAO());
			return own;
		} catch (Exception e) {
			throw new Exception("Error at getOwnerDAO" + e);
		}
	}
}
