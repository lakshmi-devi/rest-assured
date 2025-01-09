package tests.e2e.services;

import tests.e2e.module.BaseDelivery;
import tests.e2e.module.Location;
import tests.e2e.module.NameIdPair;
import tests.e2e.module.Vendor;

public class BaseDeliveryDao {
	public static BaseDelivery getBaseDeliveryDAO() throws Exception {
		try {
			BaseDelivery baseDeliver = new BaseDelivery();
			baseDeliver.setLocation(LocationDao.getBaseDeliveryLocationDAO());
			baseDeliver.setRecipient(NameIdPairDao.getRecipientNameIDPair());
			baseDeliver.setVendor(VendorDao.getVendorDao());

			return baseDeliver;

		} catch (Exception e) {
			throw new Exception("Error at getBaseDeliveryDAO" + e);
		}
	}
}
