package tests.e2e.services;

import java.util.ArrayList;
import java.util.HashMap;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.staticKeys.Statickeys;



public class ShippingDao {

		public static HashMap<String, Object> getNewShippingPayload(HashMap<String, Object> params) {
			
			HashMap<String, Object> payload = new HashMap<>();
			payload.put(Statickeys.contributedCards, params.containsKey(Statickeys.contributedCards) ? params.get(Statickeys.contributedCards) : new ArrayList<>());
			payload.put(Statickeys.externalEmails, params.containsKey(Statickeys.externalEmails) ? params.get(Statickeys.externalEmails) : new ArrayList<>());
			payload.put(Statickeys.isInternal, params.containsKey(Statickeys.isInternal) ? params.get(Statickeys.isInternal) : false);
			payload.put(Statickeys.items, params.containsKey(Statickeys.items) ? params.get(Statickeys.items) : new ArrayList<>());
			payload.put(Statickeys.name, params.containsKey(Statickeys.name) ? params.get(Statickeys.name) : "");
			payload.put(Statickeys.notifyUsers, params.containsKey(Statickeys.notifyUsers) ? params.get(Statickeys.notifyUsers) : new ArrayList<>());
			
			return payload;
		}

		public static HashMap<String, Object> getAddShippingPayload(HashMap<String, Object> params) throws Exception {
			
			HashMap<String, Object> payload = new HashMap<>();
			
			payload.put(Statickeys.currentLocation, params.containsKey(Statickeys.currentLocation) ? params.get(Statickeys.currentLocation) : "");
			payload.put(Statickeys.currentProject, DataStore.getInstance().getProperty(Statickeys.projectId));
			payload.put(Statickeys.deliverBy, params.containsKey(Statickeys.deliverBy) ? params.get(Statickeys.deliverBy) : Helper.getUtcTimeZone());
			payload.put(Statickeys.deliveryLocation, params.containsKey(Statickeys.deliveryLocation) ? params.get(Statickeys.deliveryLocation) : "");
			payload.put(Statickeys.deliveryProject, params.containsKey(Statickeys.deliveryProject) ? params.get(Statickeys.deliveryProject): DataStore.getInstance().getProperty(Statickeys.projectId));
			payload.put(Statickeys.deliveryStart, Helper.getUtcTimeZone());
			payload.put(Statickeys.files, params.containsKey(Statickeys.files) ? params.get(Statickeys.files) : new ArrayList<>());
			
			payload.put(Statickeys.name, params.containsKey(Statickeys.name) ? params.get(Statickeys.name) : "");
			payload.put(Statickeys.notifyUsers, params.containsKey(Statickeys.notifyUsers) ? params.get(Statickeys.notifyUsers) : new ArrayList<>());
			payload.put(Statickeys.owner, params.containsKey(Statickeys.owner) ? params.get(Statickeys.owner) : new HashMap<>());
			payload.put(Statickeys.projectId, params.containsKey(Statickeys.projectId) ? params.get(Statickeys.projectId): DataStore.getInstance().getProperty(Statickeys.projectId));
			
			payload.put(Statickeys.recipient, params.containsKey(Statickeys.recipient) ? params.get(Statickeys.recipient) : new HashMap<>());
			payload.put(Statickeys.shippingLabelId, params.containsKey(Statickeys.shippingLabelId) ? params.get(Statickeys.shippingLabelId) : "");
			payload.put(Statickeys.trackingId, params.containsKey(Statickeys.trackingId) ? params.get(Statickeys.trackingId) : "");
			payload.put(Statickeys.viewIndexes, params.containsKey(Statickeys.viewIndexes) ? params.get(Statickeys.viewIndexes) : new ArrayList<>());
			
			return payload;
		}
	}


