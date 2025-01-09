package tests.e2e.integration.baseOrderApis;

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

public class ProductionTemplate {

	public int invocationCount = 0;
	Baseorder templateResponse = null;
	Helper helper = new Helper();
	HashMap<String, Object> templateParams = new HashMap<>();
	HashMap<String, Object> quearyParams = new HashMap<String, Object>();

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createTemplate(String scriptType) throws Exception {
		try {
			templateParams = TemplateServices.getTemplateParams(Statickeys.prodTemplates);

			Baseorder baseOrderCreatePayload = BaseOrderDao.templateCreate(Statickeys.create, Statickeys.prodTemplates,
					null, templateParams);

			quearyParams = TemplateServices.getQuearyParams();

			Response prodTemplateResponse = PostRequest.postRequest(Statickeys.productionTemplate, quearyParams,
					baseOrderCreatePayload, "createProdTemplate");

			templateResponse = (Baseorder) Helper.convertResponceToJavaObject(prodTemplateResponse,
					Statickeys.baseorder);
			
			System.out.println("Production order Template created :  " + templateResponse.getName());

			Helper.setDatastore(Statickeys.productionTemplateOrderId, templateResponse.get_id());

			// update
			Baseorder templateOrderUpdatePayload = BaseOrderDao.templateCreate(Statickeys.update,
					Statickeys.prodTemplates, templateResponse, templateParams);
			
			PostRequest.postRequest(Statickeys.productionUpdate, quearyParams,
					templateOrderUpdatePayload, "updateTemplate");
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			invocationCount++;
		}
	}

}
