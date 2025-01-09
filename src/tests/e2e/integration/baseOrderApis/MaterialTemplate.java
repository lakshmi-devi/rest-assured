package tests.e2e.integration.baseOrderApis;

import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.TemplateServices;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.services.ProjectDao;
import tests.e2e.staticKeys.Statickeys;

public class MaterialTemplate {
	public int invocationCount = 0;
	HashMap<String, Object> templateParams = new HashMap<>();
	Helper helper = new Helper();
	HashMap<String, Object> quearyParams = new HashMap<String, Object>();

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createTemplate(String scriptType) throws Exception {
		try {
			Baseorder templateResponse = null;
			templateParams = TemplateServices.getTemplateParams(Statickeys.materialTemplate);
			quearyParams = TemplateServices.getQuearyParams();

			Baseorder baseOrderCreatePayload = BaseOrderDao.templateCreate(Statickeys.create,
					Statickeys.materialTemplates, null, templateParams);
			
			Response matTemplateResponse = PostRequest.postRequest(Statickeys.materialTemplate, quearyParams,
					baseOrderCreatePayload, "createMaterialTemplate");
			
			templateResponse = (Baseorder) Helper.convertResponceToJavaObject(matTemplateResponse, "Baseorder");
			
			System.out.println("Material order Template created :  " + templateResponse.getName());
			
			Helper.setDatastore(Statickeys.materialTemplateOrderId, templateResponse.get_id());

			// update
			Baseorder templateOrderUpdatePayload = BaseOrderDao.templateCreate(Statickeys.update,
					Statickeys.materialTemplates, templateResponse, templateParams);
			
			PostRequest.postRequest(Statickeys.materialUpdateTemplate, quearyParams,
					templateOrderUpdatePayload, "updateTemplate");

		} catch (Exception e) {
			System.err.println(e);
		} finally {
			invocationCount++;
		}
	}

}
