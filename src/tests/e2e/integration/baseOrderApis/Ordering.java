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
import tests.e2e.endPoints.ShippingEndPoint;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.OrderingService;
import tests.e2e.integrationServices.shippingService;
import tests.e2e.module.BaseDelivery;
import tests.e2e.module.Baseorder;
import tests.e2e.module.ResponseWithTotal;
import tests.e2e.module.Shipping;
import tests.e2e.module.User;
import tests.e2e.services.BaseDeliveryDao;
import tests.e2e.services.BaseOrderDao;
import tests.e2e.services.ShippingDao;
import tests.e2e.services.UserDao;
import tests.e2e.staticKeys.Statickeys;

public class Ordering {

	public int invocationCount = 0;
	HashMap<String, Object> requestingOrderParams = new HashMap<String, Object>();
	HashMap<String, Object> card = new HashMap<String, Object>();
	HashMap<String, Object> shippingOrderParams = new HashMap<String, Object>();
	HashMap<String, Object> shippingParams = new HashMap<>();
	Shipping shippingNewJsonNode = null;
	Baseorder requestingOrderNewJsonNode = null;
	Baseorder requestingOrderUpdateNewJsonNode = null;
	ResponseWithTotal sourcingOrderNewJsonNode = null;
	Baseorder orderingNewJsonNode = null;
	Helper helper = new Helper();
	
	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void createOrderingCard(String scriptType) {
		try {
			
			// ------------------Create Souring order--------------------
			requestingOrderParams = OrderingService.getcreateOrderingCardParams(scriptType, invocationCount);

			Baseorder requestingCreatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.create,
					Statickeys.ordering, null, requestingOrderParams);
			Response requestingCreateResponse = PostRequest.postRequest(MaterialManager.createMaterial,
					requestingOrderParams, requestingCreatePayload, "createSouringCard");

			if (requestingCreateResponse != null && requestingCreateResponse.getStatusCode() == 200) {
				requestingOrderNewJsonNode = (Baseorder) Helper.convertResponceToJavaObject(requestingCreateResponse,
						Statickeys.baseorder);

				Baseorder requestingOrderUpdatePayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.update,
						Statickeys.sourcing, requestingOrderNewJsonNode, requestingOrderParams);

				Response requestingUpdateResponse = PostRequest.postRequest(MaterialManager.updateMaterial,
						requestingOrderParams, requestingOrderUpdatePayload, "updateMaterial");

				// --------------------Pull to souring --------------------
				if (requestingUpdateResponse != null && requestingUpdateResponse.getStatusCode() == 200) {

					requestingOrderUpdateNewJsonNode = (Baseorder) Helper
							.convertResponceToJavaObject(requestingUpdateResponse, Statickeys.baseorder);

					Baseorder pullToSourcingPayload = BaseOrderDao.getCreateUpdatePayload(Statickeys.others,
							Statickeys.ordering, requestingOrderUpdateNewJsonNode, requestingOrderParams);

					card.put("card", pullToSourcingPayload);

					List<String> cardIdArray = new ArrayList<String>();
					cardIdArray.add(requestingOrderNewJsonNode.get_id());
					card.put("cardIds", cardIdArray);

					Response pullToSourcingResponse = PostRequest.postRequest(MaterialManager.pullToSourcing,
							requestingOrderParams, card, "pullToSourcing");

					// --------------------Move to ordering--------------------
					if (pullToSourcingResponse != null && pullToSourcingResponse.getStatusCode() == 200) {

						String sourcingOrderToString = pullToSourcingResponse.asPrettyString();

						sourcingOrderNewJsonNode = (ResponseWithTotal) Helper
								.convertResponceToJavaObject(pullToSourcingResponse, Statickeys.responseDao);

						HashMap<String, Object> moveToNextPayload = BaseOrderDao
								.getShippingCreatePayload(sourcingOrderNewJsonNode.getOrders().get(0));

						Response moveToNextStageResponce = PostRequest.postRequest(MaterialManager.moveToOrdering,
								new HashMap<String, Object>(), moveToNextPayload, "Move to ordering stage");

						// --------------------Create new shipping label--------------------
						if (moveToNextStageResponce != null && moveToNextStageResponce.getStatusCode() == 200) {

							orderingNewJsonNode = (Baseorder) Helper
									.convertResponceToJavaObject(moveToNextStageResponce, Statickeys.baseorder);

							/* Shipping API */

							shippingOrderParams = shippingService.getNewShippingOrderParams(orderingNewJsonNode);
							HashMap<String, Object> newShippingPayload = ShippingDao
									.getNewShippingPayload(shippingOrderParams);

							Response shippingResponce = PostRequest.postRequest(ShippingEndPoint.shippingNew,
									new HashMap<String, Object>(), newShippingPayload, "Create New shipping lable");

							// --------------------Add shipping label--------------------
							if (shippingResponce != null && shippingResponce.getStatusCode() == 200) {

								shippingNewJsonNode = (Shipping) Helper.convertResponceToJavaObject(shippingResponce,
										Statickeys.shipping);

								shippingParams = shippingService.getAddShippingOrderParams(shippingNewJsonNode);

								HashMap<String, Object> addShippingPayload = ShippingDao
										.getAddShippingPayload(shippingParams);

								Response addShippingResponce = PostRequest.postRequest(ShippingEndPoint.shippingAdd,
										new HashMap<String, Object>(), addShippingPayload,
										"Create in-transit shipping lable");
							}
						}
					}
				}
			}
			System.out.println(
					"Ordering order created and its in shipping order name : " + shippingNewJsonNode.getName());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

}
