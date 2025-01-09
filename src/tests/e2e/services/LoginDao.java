package tests.e2e.services;

import tests.e2e.module.Login;

public class LoginDao {

	public static Login getLoginDetails(String param, String email, String password) throws Exception {
		Login loginDetails = new Login();
		if (param.contains("John Newquist")) {
			loginDetails.setEmail("dashboard@manufacton.com");
			loginDetails.setPassword("Bru!ns202!");
		} else if (param.contains("catherine")) {
			loginDetails.setEmail("catherine@manufacton.comp");
			loginDetails.setPassword("Bru!ns202!");
		} else if (param.contains("Tarun Kumar")) {
			if (email == "" && password == "") {
				loginDetails.setEmail("tarun@at.comp");
				loginDetails.setPassword("12345678");
			} else {
				System.err.println("Please change or remove 'user' paramer value in TestNG file");
			}
		} else if (param.contains("michelle")) {
			loginDetails.setEmail("michelle@manufacton.comp");
			loginDetails.setPassword("Bru!ns202!");
		} else if (param.contains("louis")) {
			loginDetails.setEmail("louis@manufacton.comp");
			loginDetails.setPassword("Bru!ns202!");
		} else if (param.contains("jennifer")) {
			loginDetails.setEmail("jennifer@manufacton.comp");
			loginDetails.setPassword("Bru!ns202!");
		} else if (param.contains("vincent")) {
			loginDetails.setEmail("vincent@manufacton.comp");
			loginDetails.setPassword("Bru!ns202!");
		} else if (param.contains("patrick")) {
			loginDetails.setEmail("patrick@manufacton.comp");
			loginDetails.setPassword("Bru!ns202!");
		} else if (param.contains("douglas")) {
			loginDetails.setEmail("douglas@manufacton.comp");
			loginDetails.setPassword("Bru!ns202!");
		} else if (param.contains("lakshmi")) {
			loginDetails.setEmail("lakshmi@manufacton.comp");
			loginDetails.setPassword("12345678");
		} else if (param.contains("local")) {
			loginDetails.setEmail("dashboard@manufacton.com");
			loginDetails.setPassword("12345678");
		} else {
			if (email != null && password != null) {
				loginDetails.setEmail(email);
				loginDetails.setPassword(password);
			} else {
				throw new Exception("Please enter Email and password in TestNG file");
			}
		}
		return loginDetails;
	}
}
