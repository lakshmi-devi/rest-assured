package tests.e2e.services;

import java.util.ArrayList;

import tests.e2e.module.Sort;

public class SortDao {

	public static ArrayList<Sort> getSortDAO() throws Exception {
		try {
			ArrayList<Sort> sortList = new ArrayList<Sort>();
			Sort sort = new Sort();
			sort.setDirection("asc");
			sort.setSortFields("name");
			sortList.add(sort);

			return sortList;
		} catch (Exception e) {
			throw new Exception("Error at getSortDAO" + e);
		}
	}
}
