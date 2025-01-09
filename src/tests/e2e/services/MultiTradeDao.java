package tests.e2e.services;

import java.util.ArrayList;

import tests.e2e.module.FTD;
import tests.e2e.module.MultiTrade;

public class MultiTradeDao {

	public static MultiTrade getMultiTradeDAO(ArrayList<FTD> arrayList, boolean value) throws Exception {
		try {
			MultiTrade multiTrade = new MultiTrade();
			multiTrade.setCompanies(arrayList);
			multiTrade.setValue(value);
			return multiTrade;
		} catch (Exception e) {
			throw new Exception("Error at getMultiTradeDAO" + e);
		}
	}
}
