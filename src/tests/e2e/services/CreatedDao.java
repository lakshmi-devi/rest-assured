package tests.e2e.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import tests.e2e.module.By;
import tests.e2e.module.Created;

public class CreatedDao {

	public static Created geCreatedObject() throws Exception {
		try {
			LocalDateTime now = LocalDateTime.now();
			Created created = new Created();

			By by = new By();
			by.setCompany(null);
			by.setUser(null);

			created.setBy(by);
			created.setAt(now.toString());

			return created;
		} catch (Exception e) {
			throw new Exception("Error at geCreatedObject" + e);
		}
	}
}
