package tests.e2e.integration.initiApis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Vendor;
import tests.e2e.staticKeys.Statickeys;

public class GetCompanyVendors {

	@Test
	public void getCompanyVendor() throws IOException {
		try {

			ArrayList<Vendor> vendors = new ArrayList();
			HashMap<String, Object> companyVendorParams = new HashMap<String, Object>();
			
			companyVendorParams.put(Statickeys.sort, "{\"sortField\":\"name\",\"direction\":\"asc\"}");
			companyVendorParams.put(Statickeys.type, "Parts");
			companyVendorParams.put(Statickeys.limit, 2000);
			companyVendorParams.put(Statickeys.page, 1);

			Response companyVendorResponse = GetRequest.getRequest(Statickeys.getCompanyVendors, companyVendorParams,
					"getCompanyVendor");

			String companyVendorStr = companyVendorResponse.asPrettyString();
			List<Object> VendorList = io.restassured.path.json.JsonPath.from(companyVendorStr).getList("data");
			int index = Helper.getRandomNumber(VendorList.size());
			Vendor vendor = (Vendor) Helper.convertObjectToJavaObject(VendorList.get(index), Statickeys.vendor);

			vendors.add(vendor);

			Helper.setDatastore(Statickeys.vendor, vendor);
			System.out.println("Company Vendors Length : " + VendorList.size());
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public static List<Object> getVendorByCategoryAndSubCategory(String categoryId, String subCategoryId) throws Exception {
		List<Object> vendors = null;
		try {
			HashMap<String, Object> vendorByCategoryParams = new HashMap<String, Object>();
			vendorByCategoryParams.put(Statickeys.sort, "{\"sortField\":\"name\",\"direction\":\"asc\"}");
			vendorByCategoryParams.put(Statickeys.categoryId, categoryId);
			vendorByCategoryParams.put(Statickeys.subCategoryId, subCategoryId);
			vendorByCategoryParams.put(Statickeys.type, "Parts");
			vendorByCategoryParams.put(Statickeys.limit, 2000);
			vendorByCategoryParams.put(Statickeys.page, 1);

			Response vendorByCategoryResponse = GetRequest.getRequest(Statickeys.getCompanyVendors,
					vendorByCategoryParams, "getVendorByCategoryAndSubCategory");
			
			if (vendorByCategoryResponse != null & vendorByCategoryResponse.statusCode() == 200) {
				String vendorByCategoryStr = vendorByCategoryResponse.asPrettyString();
				vendors = io.restassured.path.json.JsonPath.from(vendorByCategoryStr).getList("data");
			}

		} catch (Exception e) {
			throw new Exception("Error while getting VendorByCategoryAndSubCategory", e);
		}
		return vendors;
	}

}
