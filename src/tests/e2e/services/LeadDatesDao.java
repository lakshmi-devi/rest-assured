package tests.e2e.services;

import tests.e2e.module.LeadDates;

public class LeadDatesDao {

	public static LeadDates getLeadDatesDAO() throws Exception {
		try {
			return new LeadDates();
		} catch (Exception e) {
			throw new Exception("Error at getLeadDatesDAO" + e);
		}
	}
}
