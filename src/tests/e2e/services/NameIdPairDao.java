package tests.e2e.services;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.restassured.path.json.JsonPath;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.NameIdPair;
import tests.e2e.staticKeys.Statickeys;

public class NameIdPairDao {

	public static NameIdPair getRecipientNameIDPair() throws JsonProcessingException {

		ArrayList<Object> ownerList = (ArrayList<Object>) Helper.getDatastore(Statickeys.ownerList);
		Object recipient = ownerList.get(Helper.getRandomNumber(ownerList.size()));

		ObjectWriter ownerListPrettyString = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ownerListPrettyString.writeValueAsString(recipient);
		JsonPath js = new JsonPath(json);

		NameIdPair recipientNameIdPair = new NameIdPair();
		recipientNameIdPair.set_id(js.getString("id"));
		recipientNameIdPair.set_name(js.getString("name"));
		recipientNameIdPair.setId(js.getString("id"));
		recipientNameIdPair.setName(js.getString("name"));

		return recipientNameIdPair;
	}
}
