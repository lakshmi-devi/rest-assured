package tests.e2e.assertActions;

import static org.testng.Assert.assertEquals;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CatidValidations {
	public static void validateCatId(String catId) throws Exception {
		try {
			String catIdFormat = "^([-._]+|[A-Za-z0-9]+|[-._]+){4,24}$";

			Pattern catIdPattern = Pattern.compile(catIdFormat, Pattern.CASE_INSENSITIVE);
			Matcher matcher = catIdPattern.matcher(catId);
			boolean match = matcher.find();
			assertEquals(true, match);

		} catch (Exception e) {
			throw new Exception("Error While CatidValidations Assertion" + e);
		}

	}

}
