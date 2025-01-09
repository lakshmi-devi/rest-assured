package tests.e2e.services;

import tests.e2e.module.EffectiveOwner;
import tests.e2e.module.User;

public class EffectiveOwnerDao {

	public static EffectiveOwner getEffectiveOwnerDAO() throws Exception {

		try {
			EffectiveOwner effectiveOwner = new EffectiveOwner();
			effectiveOwner.setCompany(CompanyDao.getCompanyDAO());
			effectiveOwner.setUser(UserDao.getUserDAO());
			return effectiveOwner;
		} catch (Exception e) {
			throw new Exception("Error at getEffectiveOwnerDAO" + e);
		}

	}
}
