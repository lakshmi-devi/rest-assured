package tests.e2e.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.DefaultRunNew;
import tests.e2e.staticKeys.Statickeys;

public class DefaultRunDaoNew {

	public static DefaultRunNew getDefaultRunDAO() throws Exception {

		try {
			DefaultRunNew defaultRun = new DefaultRunNew();

			Object defRunObject = Helper.getDatastore(Statickeys.defaultRun);
			DefaultRunNew defRunValue = (DefaultRunNew) Helper.convertObjectToJavaObject(defRunObject,
					Statickeys.defaultRunNew);
			defaultRun.set_id(defRunValue.get_id());
			defaultRun.setName(defRunValue.getName());
			return defaultRun;
		} catch (Exception e) {
			throw new Exception("Error at getDefaultRunDAO" + e);
		}
	}
}
