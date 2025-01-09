package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.CoordinationService;
import tests.e2e.module.Baseorder;
import tests.e2e.staticKeys.Statickeys;

public class Coordination {

	public int invocationCount = 0;
	static HashMap<String, Object> createCoordinationParmas = new HashMap<>();
	
	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createCoordination(String scriptType) throws IOException {
		try {

			createCoordinationParmas = CoordinationService.createCordParams(scriptType, invocationCount);
            Baseorder createPayload = CoordinationService.getCoordinationPayload(scriptType, createCoordinationParmas);
			Response createResponse = CoordinationService.getCoordinationResponce(createPayload);
			CoordinationService.updateCoordinationOrder(createResponse);
			System.out.println("Coordination Order Name : " + createPayload.getName());
			
		} catch (Exception e) {
			System.err.println("Error while creating Coordination " + e);
		}
	}

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createCoordinationFromtemplate(String scriptType) throws IOException {
		try {

			createCoordinationParmas = CoordinationService.createCordParams(scriptType, invocationCount);
			createCoordinationParmas.put(Statickeys.fromTemplate, true);
			
			Baseorder createPayload = CoordinationService.getCoordinationPayload(scriptType, createCoordinationParmas);
			Response createResponse = CoordinationService.getCoordinationResponce(createPayload);
			CoordinationService.updateCoordinationOrder(createResponse);
			System.out.println("Coordination Order Name using template : " + createPayload.getName());
			
		} catch (Exception e) {
			System.err.println("Error while creating a coordination order using template " + e);
		} 
	}


}
