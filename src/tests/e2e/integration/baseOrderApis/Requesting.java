package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.endPoints.MaterialManager;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.RequestingService;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.staticKeys.Statickeys;


public class Requesting {

		HashMap<String, Object> requestingOrderParams = new HashMap<String, Object>();
		Helper helper = new Helper();
		Baseorder requestingOrderNewJsonNode = null;
		public int invocationCount = 0;
		public int onsiteDate = 0;

		@Parameters({ "scriptType" })
		@Test(invocationCount = 1)
		public void createRequestingMaterial(String scriptType) {
			try {
				//-------------Create requesting order------------------------
				requestingOrderParams = RequestingService.getcreateRequestingCardParams(scriptType, invocationCount);

				Baseorder requestingCreatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create,
						Statickeys.requesting, null, requestingOrderParams);
				
				Response requestingCreateResponse = PostRequest.postRequest(MaterialManager.createMaterial, requestingOrderParams,
						requestingCreatePayload, "createMaterial");
				
				//-------------- Update Requesting order--------------------
				if (requestingCreateResponse != null && requestingCreateResponse.getStatusCode() == 200) {
					requestingOrderNewJsonNode = (Baseorder) Helper.convertResponceToJavaObject(requestingCreateResponse, Statickeys.baseorder);
					
					System.out.println("Requesting Order created : " + requestingOrderNewJsonNode.getName());

					Baseorder requestingOrderUpdatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.update,
							Statickeys.requesting, requestingOrderNewJsonNode, requestingOrderParams);
					
					PostRequest.postRequest(MaterialManager.updateMaterial, requestingOrderParams,
							requestingOrderUpdatePayload, "updateMaterial");
					invocationCount++;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e);
			}
		}
	}

