package tests.e2e.services;

import tests.e2e.module.Serials;

public class SerialsDao {

	public static Serials getSerialsDAO(int returned, int available, int unavailbaled) throws Exception {
		try {
			Serials serials = new Serials();
			serials.setReturned(returned);
			serials.setAvailable(available);
			serials.setUnavailable(unavailbaled);

			return serials;
		} catch (Exception e) {
			throw new Exception("Error at getSerialsDAO" + e);
		}
	}
}
