package tests.e2e.integrationServices;

import java.util.HashMap;

import tests.e2e.services.ProjectDao;
import tests.e2e.staticKeys.Statickeys;

public class TemplateServices {

	public static HashMap<String, Object> templateParams = new HashMap<>();
	public static HashMap<String, Object> quearyParams = new HashMap<String, Object>();

	public static HashMap<String, Object> getTemplateParams(String module) throws Exception {
		try {
			if (module == Statickeys.materialTemplate) {
				templateParams.put(Statickeys.stage, Statickeys.materialTemplates);
				templateParams.put(Statickeys._customStage, Statickeys.matTemplates);
				templateParams.put(Statickeys.leastStage, Statickeys.delivery);
				templateParams.put(Statickeys.__t, Statickeys.MatTemplates);
			} else if (module == Statickeys.prodTemplates) {
				templateParams.put(Statickeys.stage, Statickeys.prodTemplates);
				templateParams.put(Statickeys._customStage, Statickeys.prodTemplates);
				templateParams.put(Statickeys.leastStage, Statickeys.delivery);
				templateParams.put(Statickeys.__t, Statickeys.ProdTemplates);
			}
		} catch (Exception e) {
			throw new Exception("Error while getting temolate params");
		}
		return templateParams;
	}

	public static HashMap<String, Object> getQuearyParams() throws Exception {
		try {
			quearyParams.put("projectId", ProjectDao.getTemplateProjectDAO().get_id());
		} catch (Exception e) {
			throw new Exception("Error while getting template queary params");
		}
		return quearyParams;
	}

}
