package tests.e2e.integration.initiApis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Catalogue;
import tests.e2e.staticKeys.Statickeys;

public class GetPartsCatalogue {

	@Test
	public void getPartsCatalogue() {
		try {

			HashMap<String, Object> partsParams = new HashMap<String, Object>();
			partsParams.put(Statickeys.limit, 5000);
			partsParams.put(Statickeys.type, "Parts");

			Response partsResponse = GetRequest.getRequest(Statickeys.getCatalogue, partsParams, "getPartsCatalogue");
			if (partsResponse != null & partsResponse.statusCode() == 200) {
				String partsResponseStr = partsResponse.asPrettyString();
				List<Object> partsCatalogue = io.restassured.path.json.JsonPath.from(partsResponseStr).getList("data");
				Helper.setDatastore(Statickeys.parts, partsCatalogue);
				System.out.println("Parts Length: " + partsCatalogue.size());
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static ArrayList<String> getPartsForItem(int itemCount) throws JsonProcessingException {
		ArrayList<String> partsList = null;
		try {
			partsList = new ArrayList<>();
			List<Object> parts = (List<Object>) Helper.getDatastore(Statickeys.parts);
			for (int i = 0; i < itemCount; i++) {
				Catalogue catalogueItems = (Catalogue) Helper.convertObjectToJavaObject(parts.get(Helper.getRandomNumber(parts.size())),
						Statickeys.catalogue);
				partsList.add(catalogueItems.getCatId());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return partsList;
	}
}
