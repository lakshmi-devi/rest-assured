package tests.e2e.services;


import tests.e2e.module.source;

public class sourceDao {

	public static source getSourcesdDAO(String _id, String type, String stage) throws Exception {
		try {
			source source = new source();
			source.set_id(_id);
			source.setType(type);
			source.setStage(stage);
			return source;
		} catch (Exception e) {
			throw new Exception("Error at getSourcesdDAO" + e);
		}
	}
}
