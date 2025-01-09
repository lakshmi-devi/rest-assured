package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import tests.e2e.integrationServices.CutOrderService;
import tests.e2e.module.Baseorder;

public class CutOrder {
	public int invocationCount = 0;
	static HashMap<String, Object> createCutParams = new HashMap<>();
	
	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createCutOrder(String scriptType) throws IOException {
		try {
	  createCutParams = CutOrderService.createCutOrderParams(scriptType, invocationCount);
	  Baseorder createCutOrderPayload = CutOrderService.getCutOrderPayload(scriptType, createCutParams);
	  Response cutOrderResponse = CutOrderService.getCutOrderResponce(createCutOrderPayload);
	  System.out.println(cutOrderResponse.getStatusCode());
}catch (Exception e) {
	System.err.println("Error while creating cut order creation " + e);
}
}
}