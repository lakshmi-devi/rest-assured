package tests.e2e.integration.initiApis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
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

public class GetAssemblyCatalogue {

	@Test
	public void getAssemblyCategory() {
		try {
			ArrayList<String> assemblyIds = new ArrayList<String>();
			HashMap<String, Object> getCatalogueParams = new HashMap<String, Object>();
			getCatalogueParams.put(Statickeys.limit, 500);
			getCatalogueParams.put(Statickeys.type, "Assembly");

			Response getCatalogResponse = GetRequest.getRequest(Statickeys.getCatalogue, getCatalogueParams,
					"getAssemblyCategory");

			if (getCatalogResponse != null & getCatalogResponse.getStatusCode() == 200) {

				String getCatalogResponseStr = getCatalogResponse.asPrettyString();
				List<Object> catalogs = io.restassured.path.json.JsonPath.from(getCatalogResponseStr).getList("data");

				for (int i = 0; i < catalogs.size(); i++) {
					Catalogue catalogIIems = (Catalogue) Helper.convertObjectToJavaObject(catalogs.get(i),
							Statickeys.catalogue);
					assemblyIds.add(catalogIIems.getCatId());
				}
				Helper.setDatastore(Statickeys.assembly, catalogs);
				System.out.println("Assembly Length : " + catalogs.size());
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static ArrayList<String> getAssemblyForItem(int itemCount) throws Exception {

		ArrayList<String> assemblyList = new ArrayList<>();
		try {
			List<Object> assembly = (List<Object>) Helper.getDatastore(Statickeys.assembly);
			for (int i = 0; i < itemCount; i++) {
				Catalogue catalogueItems = (Catalogue) Helper.convertObjectToJavaObject(assembly.get(Helper.getRandomNumber(assembly.size())),
						Statickeys.catalogue);
				assemblyList.add(catalogueItems.getCatId());
			}
		} catch (Exception e) {
			throw new Exception("Error while getting assembly For Item");
		}
		return assemblyList;
	}

}
