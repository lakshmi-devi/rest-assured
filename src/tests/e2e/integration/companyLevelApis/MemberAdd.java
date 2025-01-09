package tests.e2e.integration.companyLevelApis;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import tests.e2e.apiInterface.PostRequest;
import tests.e2e.helper.Helper;
import tests.e2e.module.Member;
import tests.e2e.services.MemberDao;
import tests.e2e.staticKeys.Statickeys;

public class MemberAdd {
	public int invocationCount = 1;

	@Parameters({ "scriptType" })
	@Test(invocationCount = 1)
	public void addNewMember(String scriptType) throws IOException {
		Member memberValue = null;
		try {
			Member addMember = MemberDao.memberAdd();

			Response response = PostRequest.postRequest(Statickeys.createMember, new HashMap<>(), addMember,
					"createMember");

			memberValue = (Member) Helper.convertResponceToJavaObject(response, Statickeys.member);

			System.out.println("Added New Member with emailID : " + memberValue.getEmail());

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			invocationCount++;
		}
	}
}
