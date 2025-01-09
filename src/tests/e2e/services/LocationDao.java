package tests.e2e.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Location;
import tests.e2e.module.LocationForUser;
import tests.e2e.staticKeys.Statickeys;

public class LocationDao {

	public static Location getLocationForItemDao() throws Exception {
		try {
			Location location = new Location();
			LocationForUser locations = (LocationForUser) Helper.getDatastore(Statickeys.locationsForUser);
			location.set_id(locations.get_id());
			location.setName(locations.getName());
			location.setId(locations.getId());
			return location;
		} catch (Exception e) {
			throw new Exception("Error at getLocationForItem" + e);
		}
	}

	public static Location getBaseDeliveryLocationDAO() throws Exception {
		try {
			Location location = new Location();
			LocationForUser locations = (LocationForUser) Helper.getDatastore(Statickeys.locationsForUser);
			location.set_id(locations.get_id());
			location.setName(locations.getName());
			location.setId(locations.getId());
			location.set_name(locations.get_name());
			location.setType(locations.getType());
			location.setCompany(CompanyDao.getCompanyDAO());
			location.setProject(locations.getProject());

			return location;
		} catch (Exception e) {
			throw new Exception("Error at getBaseDeliveryLocationDAO" + e);
		}

	}

	public static Location getProjectLocationDAO() throws Exception {
		try {
			Location location = new Location();

			Object locations = (Object) Helper.getDatastore(Statickeys.locationsForUser);
			
			LocationForUser locationForUserObject = (LocationForUser) Helper.convertObjectToJavaObject(locations, Statickeys.locationsForUser);
			location.setName(locationForUserObject.getName());
			location.setStreet(locationForUserObject.getStreet());
			location.setState(locationForUserObject.getState());
			location.setZipcode(locationForUserObject.getZip());
			location.setCity(locationForUserObject.getCity());

			return location;
		} catch (Exception e) {
			throw new Exception("Error at getProjectLocationDAO" + e);
		}
	}
}
