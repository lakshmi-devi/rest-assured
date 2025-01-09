package tests.e2e.services;

import tests.e2e.module.Archived;

public class ArchivedDao {

	public static Archived getArchivedDAO(boolean value) throws Exception {
		try {
			Archived ar = new Archived();
			ar.setValue(value);
			return ar;
		} catch (Exception e) {
			throw new Exception("Error at getArchivedDAO" + e);
		}
	}
}
