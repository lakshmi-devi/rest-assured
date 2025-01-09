package tests.e2e.services;

import java.util.HashMap;

public class FTDDao {

	public static HashMap<String, Object> getFTdMap(String key[], Object values[]) throws Exception {
		try {
			HashMap<String, Object> datatype = new HashMap<String, Object>();
			for (int i = 0; i < key.length; i++) {
				datatype.put(key[i], values[i]);
			}
			return datatype;
		} catch (Exception e) {
			throw new Exception("Error at FTDDao" + e);
		}
	}
}
