package tests.e2e.services;

import tests.e2e.module.Qa;

public class QaDao {

	public static Qa getQaDAO() throws Exception {
		try {
			Qa qa = new Qa();
			qa.setDone(false);
			qa.setIsRequired(false);
			qa.setOrderCreator(false);
			qa.setAssignedTo(null);
			return qa;
		} catch (Exception e) {
			throw new Exception("Error at getQaDAO" + e);
		}
	}
}
