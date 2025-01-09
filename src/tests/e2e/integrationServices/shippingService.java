package tests.e2e.integrationServices;

import java.util.ArrayList;
import java.util.HashMap;

import tests.e2e.helper.DataSourceHelper;
import tests.e2e.helper.Helper;
import tests.e2e.module.BaseDelivery;
import tests.e2e.module.Baseorder;
import tests.e2e.module.Shipping;
import tests.e2e.module.User;
import tests.e2e.services.BaseDeliveryDao;
import tests.e2e.services.UserDao;
import tests.e2e.staticKeys.Statickeys;

public class shippingService {

	public static int onsiteDate = 0;
	static String onSite;
	static HashMap<String, Object> params = new HashMap<String, Object>();
	static HashMap<String, Object> newApiParams = new HashMap<>();
	static ArrayList<HashMap<String, Object>> item = new ArrayList<>();
	
	public static HashMap<String, Object> getNewShippingOrderParams(Baseorder baseorder) throws Exception {
		try {
			params.clear();
			for (int i = 0; i < baseorder.getItems().size(); i++) {
				params.put(Statickeys.activeSupplier, "");
				params.put(Statickeys.customId, "");
				params.put(Statickeys.installLocs, new ArrayList<String>());
				params.put(Statickeys.itemId, baseorder.getItems().get(i).get_id());
				params.put(Statickeys.name, baseorder.getItems().get(i).getName());
				params.put(Statickeys.notes, "");
				params.put(Statickeys.orderId, baseorder.get_id());
				params.put(Statickeys.quantity, baseorder.getItems().get(i).getQuantity());
				params.put(Statickeys.runId, baseorder.getManager().getRuns().get(i).get_id());

				item.add(params);
			}
			newApiParams.put(Statickeys.items, item);
			newApiParams.put(Statickeys.name, baseorder.getName());

			ArrayList<User> receipientUser = new ArrayList<>();
			receipientUser.add(UserDao.getUserDAO());
			newApiParams.put(Statickeys.notifyUsers, receipientUser);
		} catch (Exception e) {
			throw new Exception("Error while getting New Shiiping params in ordering stage", e);
		}
		return newApiParams;

	}

	public static HashMap<String, Object> getAddShippingOrderParams(Shipping shippingOrder) throws Exception {
		try {
			params.clear();

			BaseDelivery baseDelivery = BaseDeliveryDao.getBaseDeliveryDAO();
			params.put(Statickeys.currentLocation, baseDelivery.getLocation().getId());
			params.put(Statickeys.deliverBy, DataSourceHelper.activateDataSource ? DataSourceHelper.onsiteDate : onSite);
			params.put(Statickeys.deliveryLocation, baseDelivery.getLocation().getId());

			ArrayList<User> user = new ArrayList<User>();
			user.add(UserDao.getUserDAO());
			params.put(Statickeys.notifyUsers, user);

			params.put(Statickeys.name, shippingOrder.getName());

			params.put(Statickeys.owner, UserDao.getUserDAO());

			HashMap<String, String> itemIndex = new HashMap<String, String>();
			for (int i = 0; i < shippingOrder.getItems().size(); i++) {
				itemIndex.put("name", shippingOrder.getItems().get(i).getName());
				itemIndex.put("_id", shippingOrder.get_id());
			}

			ArrayList<HashMap<String, String>> itemsindex = new ArrayList<HashMap<String, String>>();
			itemsindex.add(itemIndex);

			params.put(Statickeys.viewIndexes, itemsindex);
			params.put(Statickeys.projectId, Helper.getDatastore(Statickeys.projectId));
			params.put(Statickeys.recipient, UserDao.getUserDAO());
			params.put(Statickeys.shippingLabelId, shippingOrder.getId());
			params.put(Statickeys.vendor, baseDelivery.getVendor());
			
		} catch (Exception e) {
			throw new Exception("Error while getting Add Shiiping params in ordering stage", e);
		}
		return params;

	}
}
