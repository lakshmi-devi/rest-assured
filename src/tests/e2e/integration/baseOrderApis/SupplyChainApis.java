package tests.e2e.integration.baseOrderApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.internal.mapping.JsonbMapper;
import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.assertActions.SupplyChainAssertion;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.integrationServices.SupplyChainApisServices;
import tests.e2e.module.Baseorder;
import tests.e2e.module.SupplyChain;
import tests.e2e.services.ExcludeFieldsDao;
import tests.e2e.services.OwnerDao;
import tests.e2e.services.SuppluChainApisDao;
import tests.e2e.staticKeys.Statickeys;

public class SupplyChainApis {

	HashMap<String, Object> params = new HashMap<String, Object>();
	SupplyChain listOfOrders = null;

	@Test
	public void getPlanningOrders() throws IOException {
		try {
			params.clear();
			params = SupplyChainApisServices.getPlanningOrdersParams();

			HashMap<String, Object> quearyParams = SuppluChainApisDao.getSupplyChainPayload(params);

			Response planningOrderResponse = GetRequest.getRequest(Statickeys.supplyChainAPI, quearyParams,
					"getPlanningOrders");

			if (planningOrderResponse != null && planningOrderResponse.getStatusCode() == 200) {

				SupplyChainAssertion.dataLengthAssertion(planningOrderResponse);

				listOfOrders = null;
				listOfOrders = (SupplyChain) Helper.convertResponceToJavaObject(planningOrderResponse,
						Statickeys.supplyChain);

				ArrayList<Baseorder> planningOrders = listOfOrders.getData();

				List<Baseorder> filteredPlanningOrders = planningOrders.stream()
						.filter((order -> order.getStage().equals("planning") && order.getItems().size()!= 0
								&& order.getKitIds().size() == 0))
						.collect(Collectors.toList()); 
				Helper.setDatastore(Statickeys.planningOrder, filteredPlanningOrders);
			}
			System.out.println("Supplychain --> getPlanningOrders : Success");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Test
	public void getCoordinationOrders() throws IOException {
		try {

			params.clear();
			params = SupplyChainApisServices.getCoordinationOrdersParams();

			HashMap<String, Object> quearyParams = SuppluChainApisDao.getSupplyChainPayload(params);

			Response getCoordinationResponse = GetRequest.getRequest(Statickeys.supplyChainAPI, quearyParams,
					"getCoordinationOrders");

			if (getCoordinationResponse != null && getCoordinationResponse.getStatusCode() == 200) {

				SupplyChainAssertion.dataLengthAssertion(getCoordinationResponse);

				listOfOrders = null;
				listOfOrders = (SupplyChain) Helper.convertResponceToJavaObject(getCoordinationResponse,
						Statickeys.supplyChain);

				ArrayList<Baseorder> coordOrders = listOfOrders.getData();
				List<Baseorder> filteredCoordOrders = coordOrders.stream()
						.filter((order -> order.getKitIds().size() == 0)).collect(Collectors.toList());
				Helper.setDatastore(Statickeys.coordinationOrders, filteredCoordOrders);
			}
			System.out.println("Supplychain --> getCoordinationOrders : Success");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

	@Test
	public void getRequestingOrders() throws IOException {
		try {

			params.clear();
			params = SupplyChainApisServices.getRequestingOrdersParams();

			HashMap<String, Object> quearyParams = SuppluChainApisDao.getSupplyChainPayload(params);
			Response getRequestingResponse = GetRequest.getRequest(Statickeys.supplyChainAPI, quearyParams,
					"getRequestingOrders");
			if (getRequestingResponse != null && getRequestingResponse.getStatusCode() == 200) {
				SupplyChainAssertion.dataLengthAssertion(getRequestingResponse);
			}
			System.out.println("Supplychain --> getRequestingOrders : Success");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

	@Test
	public void getSourcingOrders() throws IOException {
		try {

			params.clear();
			params = SupplyChainApisServices.getSourcingOrdersParams();
			HashMap<String, Object> quearyParams = SuppluChainApisDao.getSupplyChainPayload(params);

			Response getSourcingResponse = GetRequest.getRequest(Statickeys.supplyChainAPI, quearyParams,
					"getSourcingOrders");

			if (getSourcingResponse != null && getSourcingResponse.getStatusCode() == 200) {
				SupplyChainAssertion.dataLengthAssertion(getSourcingResponse);
			}
			System.out.println("Supplychain --> getSourcingOrders : Success");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Test
	public void getOrderingOrders() throws IOException {
		try {

			params.clear();
			params = SupplyChainApisServices.getOrderingOrdersParams();

			HashMap<String, Object> quearyParams = SuppluChainApisDao.getSupplyChainPayload(params);

			Response getOrderingResponse = GetRequest.getRequest(Statickeys.supplyChainAPI, quearyParams,
					"getOrderingOrders");

			if (getOrderingResponse != null && getOrderingResponse.getStatusCode() == 200) {
				SupplyChainAssertion.dataLengthAssertion(getOrderingResponse);
			}
			System.out.println("Supplychain --> getOrderingOrders : Success");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

	@Test
	public void getDetailingOrders() throws IOException {
		try {

			params.clear();
			params = SupplyChainApisServices.getDetailingOrdersParams();

			HashMap<String, Object> quearyParams = SuppluChainApisDao.getSupplyChainPayload(params);

			Response getDetailingResponse = GetRequest.getRequest(Statickeys.supplyChainAPI, quearyParams,
					"getDetailingOrders");

			if (getDetailingResponse != null && getDetailingResponse.getStatusCode() == 200) {

				SupplyChainAssertion.dataLengthAssertion(getDetailingResponse);

				listOfOrders = null;
				listOfOrders = (SupplyChain) Helper.convertResponceToJavaObject(getDetailingResponse,
						Statickeys.supplyChain);

				ArrayList<Baseorder> detailOrders = listOfOrders.getData();

				List<Baseorder> filteredDetailOrders = detailOrders.stream()
						.filter((order -> order.getKitIds().size() == 0)).collect(Collectors.toList());

				Helper.setDatastore(Statickeys.detailingOrder, filteredDetailOrders);
			}
			System.out.println("Supplychain --> getDetailingOrders : Success");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

	@Test
	public void getManufacturingOrders() throws IOException {
		try {

			params.clear();
			params = SupplyChainApisServices.getManufacturingOrdersParams();

			HashMap<String, Object> quearyParams = SuppluChainApisDao.getSupplyChainPayload(params);

			Response getManufacturingResponse = GetRequest.getRequest(Statickeys.supplyChainAPI, quearyParams,
					"getManufacturingOrders");

			if (getManufacturingResponse != null && getManufacturingResponse.getStatusCode() == 200) {

				SupplyChainAssertion.dataLengthAssertion(getManufacturingResponse);

				listOfOrders = null;
				listOfOrders = (SupplyChain) Helper.convertResponceToJavaObject(getManufacturingResponse,
						Statickeys.supplyChain);

				ArrayList<Baseorder> manufacturingOrders = listOfOrders.getData();
				List<Baseorder> filteredManufOrders = manufacturingOrders.stream()
						.filter((order -> order.getKitIds().size() == 0)).collect(Collectors.toList());
				Helper.setDatastore(Statickeys.manufacturingOrder, filteredManufOrders);
			}
			System.out.println("Supplychain --> getManufacturingOrders : Success");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Test
	public void getQaOrders() throws IOException {
		try {

			params.clear();
			params = SupplyChainApisServices.getQaOrdersParams();
			HashMap<String, Object> quearyParams = SuppluChainApisDao.getSupplyChainPayload(params);

			Response getQaResponse = GetRequest.getRequest(Statickeys.supplyChainAPI, quearyParams, "getQaOrders");

			if (getQaResponse != null && getQaResponse.getStatusCode() == 200) {
				SupplyChainAssertion.dataLengthAssertion(getQaResponse);
			}
			System.out.println("Supplychain --> getQaOrders : Success");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}

	@Test
	public void getShipping() throws IOException {
		try {

			params.clear();
			params = SupplyChainApisServices.getShippingParams();

			Response getShippingResponse = GetRequest.getRequest(Statickeys.shippingGet, params, "getShippingOrders");

			if (getShippingResponse != null && getShippingResponse.getStatusCode() == 200) {
				SupplyChainAssertion.dataLengthAssertion(getShippingResponse);
			}
			System.out.println("Supplychain --> getShippingOrders : Success");
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Test
	public void getTransferRequest() throws IOException {
		try {
			params.clear();
			params = SupplyChainApisServices.getTransferParams();

			Response getTransferRequestResponse = GetRequest.getRequest(Statickeys.getTransferRequest, params,
					"getTransferRequest");

			if (getTransferRequestResponse != null && getTransferRequestResponse.getStatusCode() == 200) {
				SupplyChainAssertion.dataLengthAssertion(getTransferRequestResponse);
			}
			System.out.println("supplychain ---> getTransferRequest : Success");
			System.out.println("");// For indentation in console
		} catch (Exception e) {
			System.err.println(e);
		}

	}
}
