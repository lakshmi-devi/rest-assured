package tests.e2e.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import tests.e2e.apiInterface.GetRequest;
import tests.e2e.helper.Helper;
import tests.e2e.integration.initiApis.GetCompanyVendors;
import tests.e2e.module.Catalogue;
import tests.e2e.module.Category;
import tests.e2e.module.SubCategory;
import tests.e2e.module.Vendor;
import tests.e2e.staticKeys.Statickeys;

public class CatalogueDao {

	public static ArrayList<String> getPartsForItem(int itemCount) throws Exception {
		ArrayList<String> partsList = null;
		try {
			partsList = new ArrayList<>();
			List<Object> parts = (List<Object>) Helper.getDatastore(Statickeys.parts);
			for (int i = 0; i < itemCount; i++) {
				Catalogue catalogueItems = (Catalogue) Helper.convertObjectToJavaObject(parts.get(i),
						Statickeys.catalogue);
				partsList.add(catalogueItems.getCatId());
			}
		} catch (Exception e) {
			throw new Exception("Error while getPartsForItem" + e);
		}
		return partsList;
	}

	public static ArrayList<String> getAssemblyForItem(int itemCount) throws Exception {
		try {
			ArrayList<String> assemblyList = new ArrayList<>();
			List<Object> assembly = (List<Object>) Helper.getDatastore(Statickeys.assembly);
			for (int i = 0; i < itemCount; i++) {
				Catalogue catalogueItems = (Catalogue) Helper.convertObjectToJavaObject(assembly.get(i),
						Statickeys.catalogue);
				assemblyList.add(catalogueItems.getCatId());
			}

			return assemblyList;
		} catch (Exception e) {
			throw new Exception("Error While getAssemblyForItem" + e);
		}
	}

	static ObjectMapper Mapper = new ObjectMapper();

	public static Catalogue getcatalogueDAO() throws Exception {
		try {
			SubCategory subCategoryItem = null;
			Catalogue cataloguePayload = new Catalogue();

			List<Category> categoriesList = (List<Category>) Helper.getDatastore(Statickeys.categories);
			int categoryIndex = new Random().nextInt(categoriesList.size());
			Category CategoryItem = (Category) Helper.convertObjectToJavaObject(categoriesList.get(categoryIndex),
					Statickeys.category);
			cataloguePayload.setCategory(CategoryItem);

			List<Object> subCategoriesList = getSubCategories(CategoryItem.get_id());

			int subCategoriesindex = new Random().nextInt(subCategoriesList.size());
			subCategoryItem = (SubCategory) Helper.convertObjectToJavaObject(categoriesList.get(subCategoriesindex),
					Statickeys.subCategories);
			cataloguePayload.setSubCategory(subCategoryItem);

			List<Object> vendorList = GetCompanyVendors.getVendorByCategoryAndSubCategory(CategoryItem.get_id(),
					subCategoryItem.get_id());

			ArrayList<Vendor> vendorArray = new ArrayList<>();

			for (int i = 0; i < vendorList.size(); i++) {
				Vendor vendorItem = (Vendor) Helper.convertObjectToJavaObject(vendorList.get(i), Statickeys.vendor);
				vendorArray.add(vendorItem);

			}
			cataloguePayload.setVendor(vendorArray);

			return cataloguePayload;
		} catch (Exception e) {
			throw new Exception("Error while getcatalogueDAO" + e);
		}
	}

	public static List<Object> getSubCategories(String categorieId) throws Exception {
		try {
			HashMap<String, Object> quries = new HashMap<String, Object>();
			quries.put(Statickeys.categoryId, categorieId);

			Helper helper = new Helper();
			Response response = GetRequest.getRequest(Statickeys.getSubCategories, quries, "getSubCategories");

			String str = response.asPrettyString();
			List<Object> subCategories = io.restassured.path.json.JsonPath.from(str).getList("");
			return subCategories;
		} catch (Exception e) {
			throw new Exception("error while getSubCategories" + e);
		}
	}
}
