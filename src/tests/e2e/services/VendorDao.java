package tests.e2e.services;

import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Vendor;
import tests.e2e.staticKeys.Statickeys;

public class VendorDao {

	public static Vendor getVendorDao() throws Exception {
		try {
			Vendor vendor = (Vendor) Helper.getDatastore(Statickeys.vendor);
			vendor.set_name(vendor.getName());
			vendor.setId(vendor.get_id());
			return vendor;
		} catch (Exception e) {
			throw new Exception("Error at getVendorDao" + e);
		}
	}
}
