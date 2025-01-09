package tests.e2e.services;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.CompanyLocation;
import tests.e2e.module.LinkedProjectSetting;
import tests.e2e.staticKeys.Statickeys;

public class LinkedProjectSettingDao {

	public static LinkedProjectSetting getLinkedProjectDAO() throws Exception {
		try {
			LinkedProjectSetting link = new LinkedProjectSetting();
			link.setCompanyId((String) Helper.getDatastore(Statickeys.companyId));
			link.setCustomId(Helper.randomNameBuilder(Statickeys.projectid));
			link.setForgeSync(new HashMap<String, Object>());
			link.setPTEnabled(true);
			link.setPrivate(true);
			link.setProjectInventoryLocation(CompanyLocationDao.getLocationFromProjectInvenDAO());
			return link;
		} catch (Exception e) {
			throw new Exception("Error at getLinkedProjectDAO" + e);
		}

	}
}
