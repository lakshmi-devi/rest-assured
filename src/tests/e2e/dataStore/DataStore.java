package tests.e2e.dataStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import tests.e2e.module.Baseorder;
import tests.e2e.module.Category;
import tests.e2e.module.Company;
import tests.e2e.module.DefaultRunNew;
import tests.e2e.module.PermissionForUser;
import tests.e2e.module.Project;
import tests.e2e.module.ResolvedPermissionGroups;
import tests.e2e.module.LocationForUser;
import tests.e2e.module.CompanyLocation;
import tests.e2e.module.TemplateForms;
import tests.e2e.module.Vendor;
import tests.e2e.staticKeys.Statickeys;

public class DataStore {

	// A private variable with getter and setter methods
		private String url;
		private String token;
		private String companyId;
		private Project project;
		private String projectId;
		private String location;
		private String ownerName;
		private Object owner;
		private ArrayList<Object> ownerList;
		private Company company;
		private String companyName;
		private Object locationList;
		private DefaultRunNew defaultRun;
		private String log;
		private ArrayList<Object> assemblyIds;
		private ArrayList<Object> partsIds;
		private Vendor vendors;
		private Category categories;
		private LocationForUser locationsForUser;
		private ArrayList<Object> CompanyProjectAllLinkedUsers;
		private TemplateForms templateForms;
		private ArrayList<Baseorder> planningOrder;
		private Object CoordinationOrders;
		private PermissionForUser permission;
		private ArrayList<Baseorder> detailingOrder;
		private ArrayList<Baseorder> manufacturingOrder;
		private Project templateProject;
		private String productionTemplateOrderId;
		private String materialTemplateOrderId;
		private ResolvedPermissionGroups resolvedPermissionGroups;
		
		// Private instance of class
		private static DataStore dataStoreDAO = null;
	 
		// Private constructor to control object creation of class
		public DataStore() {
			
		}
	 
		// Return unidealized instance of class 
		public static DataStore getInstance() {
			if(dataStoreDAO == null) {
				dataStoreDAO = new DataStore();
			}
			return dataStoreDAO;
		}
	 
		public Object getProperty(String key) {
			if(key == Statickeys.token) return this.token;
			else if(key == Statickeys.log) return this.log;
			else if(key == Statickeys.url) return this.url;
			else if(key == Statickeys.companyId) return this.companyId;
			else if(key == Statickeys.project) return this.project;
			else if(key == Statickeys.projectId) return this.projectId;
			else if(key == Statickeys.location) return this.location;
			else if(key == Statickeys.ownerName) return this.ownerName;
			else if(key == Statickeys.owner) return this.owner;
			else if(key == Statickeys.ownerList) return this.ownerList;
			else if(key == Statickeys.company) return this.company;
			else if(key == Statickeys.companyName) return this.companyName;
			else if(key == Statickeys.locationList) return this.locationList;
			else if(key == Statickeys.defaultRun) return this.defaultRun;
			else if(key == Statickeys.assembly) return this.assemblyIds;
			else if(key == Statickeys.parts) return this.partsIds;
			else if(key == Statickeys.vendor) return this.vendors;
			else if(key == Statickeys.categories) return this.categories;
			else if(key == Statickeys.locationsForUser) return this.locationsForUser;
			else if(key == Statickeys.getCompanyProjectAllLinkedUsers) return this.CompanyProjectAllLinkedUsers;
			else if(key == Statickeys.TemplateForms) return this.templateForms;
			else if(key == Statickeys.planningOrder) return this.planningOrder;
			else if(key == Statickeys.permission) return this.permission;
			else if(key == Statickeys.detailingOrder) return this.detailingOrder;
			else if(key == Statickeys.manufacturingOrder) return this.manufacturingOrder;
			else if (key == Statickeys.coordinationOrders) return this.CoordinationOrders;
			else if(key == Statickeys.templateProject) return this.templateProject;
			else if(key==Statickeys.productionTemplateOrderId) return this.productionTemplateOrderId;
			else if(key==Statickeys.materialTemplateOrderId) return this.materialTemplateOrderId;
			else if(key==Statickeys.permissionGroup) return this.resolvedPermissionGroups;
			return key;
		}
	 
		@SuppressWarnings("unchecked")
		public void setProperty(String key, Object value) {
			if(key == Statickeys.token) this.token = (String) value;
			else if(key == Statickeys.log) this.log = (String) value;
			else if(key == Statickeys.url) this.url = (String) value;
			else if(key == Statickeys.companyId) this.companyId = (String) value;
			else if(key == Statickeys.project) this.project = (Project) value;
			else if(key == Statickeys.projectId) this.projectId = (String) value;
			else if(key == Statickeys.location) this.location = (String) value;
			else if(key == Statickeys.owner) this.owner =  value;
			else if(key == Statickeys.ownerList) this.ownerList = (ArrayList<Object>) value;
			else if(key == Statickeys.ownerName) this.ownerName = (String) value;
			else if(key == Statickeys.company) this.company = (Company) value;
			else if(key == Statickeys.companyName) this.companyName = (String) value;
			else if(key == Statickeys.locationList) this.locationList = value;
			else if(key == Statickeys.defaultRun) this.defaultRun = (DefaultRunNew) value;
			else if(key == Statickeys.assembly) this.assemblyIds = (ArrayList<Object>) value;
			else if(key == Statickeys.parts) this.partsIds = (ArrayList<Object>) value;
			else if(key == Statickeys.vendor) this.vendors =  (Vendor) value;
			else if(key == Statickeys.categories) this.categories = (Category) value;
			else if(key == Statickeys.locationsForUser) this.locationsForUser = (LocationForUser) value;
			else if(key == Statickeys.getCompanyProjectAllLinkedUsers) this.CompanyProjectAllLinkedUsers = (ArrayList<Object>) value;
			else if(key == Statickeys.TemplateForms) this.templateForms = (TemplateForms) value;
			else if(key == Statickeys.planningOrder) this.planningOrder = (ArrayList<Baseorder>) value;
			else if(key == Statickeys.coordinationOrders) this.CoordinationOrders = (Object) value;
			else if(key == Statickeys.permission) this.permission = (PermissionForUser) value;
			else if(key == Statickeys.detailingOrder) this.detailingOrder = (ArrayList<Baseorder>) value;
			else if(key == Statickeys.templateProject) this.templateProject = (Project) value;
			else if(key==Statickeys.productionTemplateOrderId) this.productionTemplateOrderId=(String) value;
			else if(key==Statickeys.materialTemplateOrderId) this.materialTemplateOrderId =(String) value;
			else if(key == Statickeys.manufacturingOrder) this.manufacturingOrder = (ArrayList<Baseorder>) value;
			else if(key == Statickeys.permissionGroup) this.resolvedPermissionGroups = (ResolvedPermissionGroups) value;
		}
}
