package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.endPoints.ProductionManager;
import tests.e2e.endPoints.ShippingEndPoint;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.CoordinationService;
import tests.e2e.integrationServices.ManufacturingService;
import tests.e2e.module.BaseDelivery;
import tests.e2e.module.Baseorder;
import tests.e2e.module.Shipping;
import tests.e2e.module.User;
import tests.e2e.services.BaseDeliveryDao;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.services.LastModifiedDao;
import tests.e2e.services.ShippingDao;
import tests.e2e.services.UserDao;
import tests.e2e.staticKeys.Statickeys;

public class Manufacturing {
	public int invocationCount = 0;
	static HashMap<String, Object> createManufParmas = new HashMap<>();

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createManufacturing(String scriptType) {
		try {
			createManufParmas = ManufacturingService.createManufParams(scriptType, invocationCount);
			Baseorder createPayload = ManufacturingService.getManufacturingPayload(scriptType, createManufParmas);
			Response CreateResponse = ManufacturingService.getManufacturingResponce(createPayload);
			ManufacturingService.updateManufacturingOrder(CreateResponse);
			System.out.println("Manufacturing order created : " + createPayload.getName());
		} catch (Exception e) {
			System.err.println("Error while creating a Manufacturinng order " + e);
		} finally {
			invocationCount++;
		}
	}

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createManufacturingFromtemplate(String scriptType) throws IOException {
		try {

			createManufParmas = ManufacturingService.createManufParams(scriptType, invocationCount);
			createManufParmas.put(Statickeys.fromTemplate, true);
			
			Baseorder createPayload = ManufacturingService.getManufacturingPayload(scriptType, createManufParmas);
			Response CreateResponse = ManufacturingService.getManufacturingResponce(createPayload);
			ManufacturingService.updateManufacturingOrder(CreateResponse);
			System.out.println("Manufacturing order created using Template: " + createPayload.getName());
		} catch (Exception e) {
			System.err.println("Error while creating a Manufacturinng order using template " + e);
		} finally {
			invocationCount++;
		}
	}

}
