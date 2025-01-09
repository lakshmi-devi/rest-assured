package tests.e2e.assertActions;

import io.restassured.response.Response;
import static org.testng.Assert.assertEquals;
import java.util.List;
import java.util.regex.*;
import com.fasterxml.jackson.core.JsonProcessingException;

public class EmailValidationAssertions {

	public static void ValidateEmail(String emailId) throws Exception {
		try {
			String mailformat = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
			Pattern emailpat = Pattern.compile(mailformat, Pattern.CASE_INSENSITIVE);

			Matcher matcher = emailpat.matcher(emailId);
			boolean match = matcher.find();
			assertEquals(true, match);

		} catch (Exception e) {
			throw new Exception("Error While Email Validation Assertions" + e);
		}
	}
}
