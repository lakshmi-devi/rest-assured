package tests.e2e.module;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/*
 * ObjectMapper om = new ObjectMapper(); Root root = om.readValue(myJsonString,
 * Root.class);
 */

class Api {
	public String _id;
	public String name;
	public String description;
	public Params params;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class CreatedCompany {
	public String status;
	public String _id;
	public String name;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class DefaultReceiver {
	public String _id;
	public String _name;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class ForgeHook {
	public Info info;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class ForgeSync {
	public String urn;
	public String path;
	public String itemId;
	public String folderId;
	public String projectId;
	public String updatedAt;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class Headers {
	@JsonProperty("cache-control")
	public String cacheControl;
	public String date;
	public String expires;
	public String location;
	public String pragma;
	@JsonProperty("strict-transport-security")
	public String strictTransportSecurity;
	@JsonProperty("x-content-type-options")
	public String xContentTypeOptions;
	@JsonProperty("x-frame-options")
	public String xFrameOptions;
	@JsonProperty("x-xss-protection")
	public String xXssProtection;
	@JsonProperty("content-length")
	public String contentLength;
	public String connection;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class Info {
	public Headers headers;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class NameList {
	public String _id;
	public String name;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class NewOwner {
	public String _id;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class OrderRoute {
	public String _id;
	public String module;
	public String purpose;
	public String stage;
	public NewOwner newOwner;
	public ArrayList<Object> notify;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class Params {
	public int company_id;
	public int project_id;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class ProjectCompanyRun {
	public String type;
	public String _id;
	public String name;
	public String copiedFrom;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class ProjectInventoryLocation {
	public String _id;
	public String _name;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class ProjectLocation {
	public String _id;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class ProjectUser {
	public boolean isAdmin;
	public String memberRole;
	public String _id;
	public User user;
	public String title;
}

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
	private Location location;
	private PurchaseOrderNumber purchaseOrderNumber;
	private ArrayList<Object> levels;
	private ArrayList<Object> zones;
	private String status = "Active";
	private ArrayList<Object> projectLocations;
	private ArrayList<Object> projectCompanies;
	private boolean generatePon;
	private boolean isMaster;
	private ArrayList<Object> childProjects;
	private boolean isGI;
	private boolean isCommonStockProject;
	private boolean autoAddGI;
	private ArrayList<Object> attachedGIs;
	private String _id;
	private ArrayList<Object> projectUsers;
	private ArrayList<OrderRoute> orderRoute;
	private ArrayList<ProjectSetting> projectSettings;
	private ArrayList<Api> apis;
	private ArrayList<Object> mappedBindCol;
	private ArrayList<Object> bindings;
	private ArrayList<NameList> nameList;
	private String name;
	private String contactEmail;
	private Object createdCompany;
	private Object createdUser;
	private String modifiedUser;
	private String createdAt;
	private String updatedAt;
	private int __v;
	
	//For Revit API
	private String customId;
	
	
	
	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	@JsonProperty("isTemplateProject")
	private boolean isISTemplateProject;
	
	private ArrayList<Object> purchaseOrderHistory;
	private String id;
	private ArrayList<Specification> specification;
	private LinkedProjectSetting linkedProjectSetting;

	private ProjectOwner projectOwner;

	
	public boolean isISTemplateProject() {
		return isISTemplateProject;
	}

	public void setISTemplateProject(boolean isISTemplateProject) {
		this.isISTemplateProject = isISTemplateProject;
	}

	public LinkedProjectSetting getLinkedProjectSetting() {
		return linkedProjectSetting;
	}

	public void setLinkedProjectSetting(LinkedProjectSetting linkedProjectSetting) {
		this.linkedProjectSetting = linkedProjectSetting;
	}

	public ProjectOwner getProjectOwner() {
		return projectOwner;
	}

	public void setProjectOwner(ProjectOwner projectOwner) {
		this.projectOwner = projectOwner;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public PurchaseOrderNumber getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(PurchaseOrderNumber purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}

	public ArrayList<Object> getLevels() {
		return levels;
	}

	public void setLevels(ArrayList<Object> levels) {
		this.levels = levels;
	}

	public ArrayList<Object> getZones() {
		return zones;
	}

	public void setZones(ArrayList<Object> zones) {
		this.zones = zones;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<Object> getProjectLocations() {
		return projectLocations;
	}

	public void setProjectLocations(ArrayList<Object> projectLocations) {
		this.projectLocations = projectLocations;
	}

	public ArrayList<Object> getProjectCompanies() {
		return projectCompanies;
	}

	public void setProjectCompanies(ArrayList<Object> projectCompanies) {
		this.projectCompanies = projectCompanies;
	}

	public boolean isGeneratePon() {
		return generatePon;
	}

	public void setGeneratePon(boolean generatePon) {
		this.generatePon = generatePon;
	}

	public boolean isMaster() {
		return isMaster;
	}

	public void setMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}

	public ArrayList<Object> getChildProjects() {
		return childProjects;
	}

	public void setChildProjects(ArrayList<Object> childProjects) {
		this.childProjects = childProjects;
	}

	public boolean isGI() {
		return isGI;
	}

	public void setGI(boolean isGI) {
		this.isGI = isGI;
	}

	public boolean isCommonStockProject() {
		return isCommonStockProject;
	}

	public void setCommonStockProject(boolean isCommonStockProject) {
		this.isCommonStockProject = isCommonStockProject;
	}

	public boolean isAutoAddGI() {
		return autoAddGI;
	}

	public void setAutoAddGI(boolean autoAddGI) {
		this.autoAddGI = autoAddGI;
	}

	public ArrayList<Object> getAttachedGIs() {
		return attachedGIs;
	}

	public void setAttachedGIs(ArrayList<Object> attachedGIs) {
		this.attachedGIs = attachedGIs;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public ArrayList<Object> getProjectUsers() {
		return projectUsers;
	}

	public void setProjectUsers(ArrayList<Object> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public ArrayList<OrderRoute> getOrderRoute() {
		return orderRoute;
	}

	public void setOrderRoute(ArrayList<OrderRoute> orderRoute) {
		this.orderRoute = orderRoute;
	}

	public ArrayList<ProjectSetting> getProjectSettings() {
		return projectSettings;
	}

	public void setProjectSettings(ArrayList<ProjectSetting> projectSettings) {
		this.projectSettings = projectSettings;
	}

	public ArrayList<Api> getApis() {
		return apis;
	}

	public void setApis(ArrayList<Api> apis) {
		this.apis = apis;
	}

	public ArrayList<Object> getMappedBindCol() {
		return mappedBindCol;
	}

	public void setMappedBindCol(ArrayList<Object> mappedBindCol) {
		this.mappedBindCol = mappedBindCol;
	}

	public ArrayList<Object> getBindings() {
		return bindings;
	}

	public void setBindings(ArrayList<Object> bindings) {
		this.bindings = bindings;
	}

	public ArrayList<NameList> getNameList() {
		return nameList;
	}

	public void setNameList(ArrayList<NameList> nameList) {
		this.nameList = nameList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	

	public Object getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(Object createdUser) {
		this.createdUser = createdUser;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public ArrayList<Object> getPurchaseOrderHistory() {
		return purchaseOrderHistory;
	}

	public void setPurchaseOrderHistory(ArrayList<Object> purchaseOrderHistory) {
		this.purchaseOrderHistory = purchaseOrderHistory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Specification> getSpecification() {
		return specification;
	}

	public void setSpecification(ArrayList<Specification> specification) {
		this.specification = specification;
	}

	public Object getCreatedCompany() {
		return createdCompany;
	}

	public void setCreatedCompany(Object createdCompany) {
		this.createdCompany = createdCompany;
	}

}
