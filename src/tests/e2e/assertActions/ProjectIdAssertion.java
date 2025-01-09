package tests.e2e.assertActions;

import static org.testng.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProjectIdAssertion {
	public static void validateProjectId(String projectID) throws Exception {
		try {
			String projectIdFormat = "^[a-zA-Z0-9-]+$";

			Pattern projectIdPattern = Pattern.compile(projectIdFormat, Pattern.CASE_INSENSITIVE);
			Matcher matcher = projectIdPattern.matcher(projectID);
			boolean match = matcher.find();
			assertEquals(true, match);
		} catch (Exception e) {
			throw new Exception("Error While Project Id Assertion" + e);
		}

	}

}
