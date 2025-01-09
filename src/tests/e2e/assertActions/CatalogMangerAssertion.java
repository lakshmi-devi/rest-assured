package tests.e2e.assertActions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import tests.e2e.dataStore.DataStore;
import tests.e2e.module.Assembly;

public class CatalogMangerAssertion {

	static ObjectMapper mapper = new ObjectMapper();

	public static void partsCountInAssembly(Response response) throws Exception {
		try {
			if (response != null) {
				String partsResponceString = response.asPrettyString();
				List<Object> assembly = io.restassured.path.json.JsonPath.from(partsResponceString).getList("data");

				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				String item = mapper.writeValueAsString(assembly.get(0));

				Assembly AssemblyItem = mapper.readValue(item, Assembly.class);
				assertNotEquals(AssemblyItem.getParts().size(), 0);
			}
		} catch (Exception e) {
			throw new Exception("Error While partsCountInAssembly assertion" + e);
		}
	}

	public static void partsQtyInAssembly(Response response) throws Exception {
		try {
			if (response != null) {
				String assemblyResponceString = response.asPrettyString();
				List<Object> assembly = io.restassured.path.json.JsonPath.from(assemblyResponceString).getList("data");
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				String item = mapper.writeValueAsString(assembly.get(0));
				Assembly AssemblyItem = mapper.readValue(item, Assembly.class);
				for (int i = 0; i < AssemblyItem.getParts().size(); i++) {
					assertNotEquals(AssemblyItem.getParts().get(i).getQuantity(), 0);
				}
			}
		} catch (Exception e) {
			throw new Exception("Error While partsQtyInAssembly assertion" + e);
		}
	}
}
