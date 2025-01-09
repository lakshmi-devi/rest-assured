package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.endPoints.MaterialManager;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.SourcingService;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.staticKeys.Statickeys;

public class Sourcing {

	HashMap<String, Object> requestingOrderParams = new HashMap<String, Object>();
	HashMap<String, Object> card = new HashMap<String, Object>();
	Baseorder requestingOrderUpdateNewJsonNode = null;
	Helper helper = new Helper();
	public int invocationCount = 0;
	public int onsiteDate = 0;

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createSourcingCard(String scriptType) {
		try {
			Baseorder requestingOrderNewJsonNode = null;

			onsiteDate = Helper.setDataForDashboadScript(scriptType, invocationCount);

			requestingOrderParams = SourcingService.getcreateSourcingCardParams(scriptType, invocationCount);

			Baseorder requestingCreatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create,
					Statickeys.sourcing, null, requestingOrderParams);

			Response requestingCreateResponse = PostRequest.postRequest(MaterialManager.createMaterial,
					requestingOrderParams, requestingCreatePayload, "createRequestingCard");

			if (requestingCreateResponse != null && requestingCreateResponse.getStatusCode() == 200) {

				requestingOrderNewJsonNode = (Baseorder) Helper.convertResponceToJavaObject(requestingCreateResponse,
						Statickeys.baseorder);

				Baseorder requestingOrderUpdatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.update,
						Statickeys.sourcing, requestingOrderNewJsonNode, requestingOrderParams);

				Response requestingUpdateResponse = PostRequest.postRequest(MaterialManager.updateMaterial,
						requestingOrderParams, requestingOrderUpdatePayload, "updateMaterial");

				if (requestingUpdateResponse != null && requestingUpdateResponse.getStatusCode() == 200) {

					requestingOrderUpdateNewJsonNode = (Baseorder) Helper
							.convertResponceToJavaObject(requestingUpdateResponse, Statickeys.baseorder);

					List<String> array = new ArrayList<String>();

					card.put("card", requestingOrderUpdateNewJsonNode);
					array.add(requestingOrderNewJsonNode.get_id());
					card.put("cardIds", array);

					PostRequest.postRequest(MaterialManager.pullToSourcing, requestingOrderParams, card,
							"pullToSourcing");
				}
			}

			System.out.println("Sorcing order created : " + requestingOrderNewJsonNode.getName());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}

	}

}
