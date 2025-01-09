package tests.e2e.services;

import tests.e2e.module.Prefab;

public class PrefabDao {

	public static Prefab getPrefaDAO(String _id) throws Exception {
		try {
			Prefab prefab = new Prefab();
			prefab.set_id(_id);
			return prefab;
		} catch (Exception e) {
			throw new Exception("Error at getPrefaDAO" + e);
		}
	}
}
