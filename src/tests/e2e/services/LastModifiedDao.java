package tests.e2e.services;

import com.fasterxml.jackson.core.JsonProcessingException;

import tests.e2e.helper.Helper;
import tests.e2e.module.By;
import tests.e2e.module.Company;
import tests.e2e.module.LastModified;
import tests.e2e.module.User;

public class LastModifiedDao {

	public static LastModified lastModifiedDAO() throws Exception {
		try {
			LastModified lastModified = new LastModified();

			By by = new By();
			by.setCompany(CompanyDao.getCompanyDAO());
			by.setUser(UserDao.getUserDAO());

			lastModified.setBy(by);
			lastModified.setAt(Helper.getUtcTimeZone());

			return lastModified;
		} catch (Exception e) {
			throw new Exception("Error While Generate randomNameBuilder" + e);
		}
	}
}
