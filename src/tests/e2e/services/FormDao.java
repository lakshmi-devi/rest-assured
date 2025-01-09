package tests.e2e.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tests.e2e.module.Form;

public class FormDao {
	public static Form getFormDao() throws Exception {
		try {
			Form form = new Form();
			form.setForm(ProjectDao.getProjectCreateupdatePayload());

			return form;
		} catch (Exception e) {
			throw new Exception("Error While creating Project creation" + e);
		}
	}

	public static Form getRyvitFormDao() throws Exception {
		try {
			Form form = new Form();
			form.setForm(ProjectDao.ryvitProjectDAO());

			return form;
		} catch (Exception e) {
			throw new Exception("Error While creating Ryvit creation" + e);
		}
	}
}
