package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.assertActions.AssertionValidator;
import tests.e2e.assertActions.OrderNameAssertion;
import tests.e2e.dataStore.DataStore;
import tests.e2e.endPoints.PrefabPlanner;
import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.PrefabPlannerService;
import tests.e2e.module.Baseorder;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.staticKeys.Statickeys;

public class ProjectPlanner {

	public int invocationCount = 0;
	public int onsiteDate = 0;

	/* test methods */
	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createPrefab(String scriptType) {
		try {
			onsiteDate = Helper.setDataForDashboadScript(scriptType, invocationCount);
			Baseorder payload = PrefabPlannerService.getBaseOrderPayload(scriptType, onsiteDate);
			Response response = PrefabPlannerService.getResponce(payload);
			PrefabPlannerService.updateBaseOrder(response);
			System.out.println("Prefab Order created :" + payload.getName());

		} catch (Exception e) {
			System.err.println(e);
		} 
	}

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createPrefabWithOutName(String scriptType) {
		try {
			AssertionValidator.isNegativeAssertion = true;
			Baseorder payload = PrefabPlannerService.getBaseOrderPayload(scriptType, 0);
			payload.setName("");
			Response response = PrefabPlannerService.getResponce(payload);
			OrderNameAssertion.orderNameAssert(response);

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
