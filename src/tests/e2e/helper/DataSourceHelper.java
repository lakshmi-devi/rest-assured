package tests.e2e.helper;

import java.util.HashMap;

import tests.e2e.dataStore.DataStore;
import tests.e2e.staticKeys.Statickeys;

public class DataSourceHelper {
	
	public static int itemCount = 1;
	public static int invocationCount = 2;
	
	public static int orderCount = 1;
	public static int partsCountToAssembly = 20;

	// Private instance of class
	private static DataSourceHelper dataSourceDAO = null;

	/* Activate Data source for date inputs */
	public static boolean activateDataSource = false;

	/* input Data */

	public static String coordinationDate = null;
	public static String onsiteDate = null; // deliverBy and deliverDate All same
	public static String poDetailBy = null; // detailBy all same
	public static String poManufactureBy = null; // manufactureBy all same
	public static String poQaBy = null; // qaBy all same
	public static String partsManufactureBy = null;
	public static String coordedAt = null;
	public static String detailedAt = null;
	public static String manufacturedAt = null;
	public static String orderBy = null;

	public static DataSourceHelper getInstance() {
		if (dataSourceDAO == null) {
			dataSourceDAO = new DataSourceHelper();
		}
		return dataSourceDAO;
	}

	public void setProerty() throws Exception {
		try {
			coordinationDate = Helper.getUtcTimeZone(0);
			coordedAt = Helper.getUtcTimeZone(0);

			poDetailBy = Helper.getUtcTimeZone(1);
			detailedAt = Helper.getUtcTimeZone(1);

			poManufactureBy = Helper.getUtcTimeZone(2);
			partsManufactureBy = Helper.getUtcTimeZone(2);
			manufacturedAt = Helper.getUtcTimeZone(2);

			poQaBy = Helper.getUtcTimeZone(3);

			orderBy = Helper.getUtcTimeZone(4);

			onsiteDate = Helper.getUtcTimeZone(5);

		} catch (Exception e) {
			throw new Exception("Error while setting data input in Data source Helper");
		}
	}
}
