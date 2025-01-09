package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.endPoints.ProductionManager;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.CoordinationService;
import tests.e2e.integrationServices.DetailingService;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.staticKeys.Statickeys;

public class Detailing {

	public int invocationCount = 0;
	static HashMap<String, Object> createDetailingParmas = new HashMap<>();

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createDetailing(String scriptType) throws IOException {
		try {

			createDetailingParmas = DetailingService.createDetailParams(scriptType, invocationCount);
			Baseorder createPayload = DetailingService.getDetailingPayload(scriptType, createDetailingParmas);
			Response createResponse = DetailingService.getDetailingResponce(createPayload);
			DetailingService.updateDetailingOrder(createResponse);
			System.out.println("detailing Order : " + createPayload.getName());
		} catch (Exception e) {
			System.err.println("Error while creating a Detailing order" + e);
		} finally {
			if (scriptType.equals("dashboard")) {
			invocationCount++;
			}
		}
	}

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createDetailingFromtemplate(String scriptType) throws IOException {
		try {

			createDetailingParmas = DetailingService.createDetailParams(scriptType, invocationCount);
			createDetailingParmas.put(Statickeys.fromTemplate, true);
			
			Baseorder createPayload = DetailingService.getDetailingPayload(scriptType, createDetailingParmas);
			Response createResponse = DetailingService.getDetailingResponce(createPayload);
			DetailingService.updateDetailingOrder(createResponse);
			System.out.println("detailing Order created using template: " + createPayload.getName());
		} catch (Exception e) {
			System.err.println("Error while creating a Detailing order using template " + e);
		} 
	}


}
