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
import tests.e2e.integrationServices.ManufacturingService;
import tests.e2e.integrationServices.shippingService;
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

public class ShippingOrderCreateFromPO {
	
	HashMap<String, Object> parmas = new HashMap<>();
	HashMap<String, Object> manufacturingPayloadParams = new HashMap<String, Object>();
	HashMap<String, Object> shippingNewParams = new HashMap<>();
	
	Baseorder manufacturingOrderCreateResponce = null;
	Baseorder manufacturingOrderUpdateResponce = null;
	Shipping shippingNewResponce = null;
	
	Helper helper = new Helper();
	public int invocationCount = 0;

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createManufacturing(String scriptType) {
		try {

			parmas = ManufacturingService.createManufParams(scriptType, invocationCount);

			Baseorder manufacturingCreatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create,
					Statickeys.manufacturing, null, parmas);

			manufacturingPayloadParams = ManufacturingService.getQuearyParams();

			// --------------------------- Create --------------------------------
			Response manufacturingResponse = PostRequest.postRequest(ProductionManager.createPO,
					manufacturingPayloadParams, manufacturingCreatePayload, "createManufacturing");

			manufacturingOrderCreateResponce = (Baseorder) Helper.convertResponceToJavaObject(manufacturingResponse, Statickeys.baseorder);

			// -------------------------- Update -------------------------------
			String PMUpdateRoute = ProductionManager.getPMUpdateRoutes(manufacturingOrderCreateResponce.get_id());
			int runCount = manufacturingOrderCreateResponce.getManager().getRuns().size();

			for (int runIndex = 0; runIndex < runCount; runIndex++) {
				manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex)
						.setModified(LastModifiedDao.lastModifiedDAO());
				manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex).setCompleted(true);
				manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex).setEditing(true);
				manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex).setEditing(true);

				int RuntemCount = manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex)
						.getRunItemsCount().size();

				for (int runItemIndex = 0; runItemIndex < RuntemCount; runItemIndex++) {

					manufacturingOrderCreateResponce.getManager().getRuns().get(runIndex).getRunItemsCount()
							.get(runItemIndex).setRiCompleted(true);
				}
			}

			Response updateResponse = PostRequest.postRequest(PMUpdateRoute, manufacturingPayloadParams,
					manufacturingOrderCreateResponce, "UpdatePM");

			manufacturingOrderUpdateResponce = (Baseorder) Helper.convertResponceToJavaObject(updateResponse, Statickeys.baseorder);

			String runId = manufacturingOrderUpdateResponce.getManager().getRuns().get(0).get_id();
			manufacturingOrderUpdateResponce.getItems().get(0).setRunId(runId);

			String orderId = manufacturingOrderUpdateResponce.get_id();
			manufacturingOrderUpdateResponce.getItems().get(0).setOrderId(orderId);

			String itemId = manufacturingOrderUpdateResponce.get_id();
			manufacturingOrderUpdateResponce.getItems().get(0).setItemId(itemId);

			/* ----------------------------New Shipping Label ------------------------ */

			shippingNewParams = shippingService.getNewShippingOrderParams(manufacturingOrderUpdateResponce);
			
			HashMap<String, Object> newShippingPayload = ShippingDao.getNewShippingPayload(shippingNewParams);
			
			Response newApiResponce = PostRequest.postRequest(Statickeys.shippingNew, new HashMap<String, Object>(),
					newShippingPayload, "Create New shipping lable");

			shippingNewResponce = (Shipping) Helper.convertResponceToJavaObject(newApiResponce, Statickeys.shipping);

			HashMap<String, Object> shippingAddParams = new HashMap<>();
			
			shippingAddParams = shippingService.getAddShippingOrderParams(shippingNewResponce);

			/* ----------------------------Add Shipping Label ------------------------ */
			
			HashMap<String, Object> addShippingPayload = ShippingDao.getAddShippingPayload(shippingAddParams);

			PostRequest.postRequest(Statickeys.shippingAdd, new HashMap<String, Object>(),
					addShippingPayload, "Create New shipping lable");

			System.out.println(" In-transit Shipping order created : " + manufacturingOrderUpdateResponce.getName());
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			invocationCount++;
		}
	}

}
