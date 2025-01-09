package tests.e2e.module;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class AllLocations {
	private ArrayList<Object> location_type;
	private ArrayList<Object> project;
	private boolean nestedLocation;
	private ArrayList<String> children;
	private int level;
	private String fullAddress;
	private boolean defaultInventoryLocation;
	private String _id;
	private String name;
	private String type;
	private Company company;
	private CompanyPair companyPair;
	private String id;

	public ArrayList<Object> getLocation_type() {
		return location_type;
	}

	public void setLocation_type(ArrayList<Object> location_type) {
		this.location_type = location_type;
	}

	public ArrayList<Object> getProject() {
		return project;
	}

	public void setProject(ArrayList<Object> project) {
		this.project = project;
	}

	public boolean isNestedLocation() {
		return nestedLocation;
	}

	public void setNestedLocation(boolean nestedLocation) {
		this.nestedLocation = nestedLocation;
	}

	public ArrayList<String> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<String> children) {
		this.children = children;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public boolean isDefaultInventoryLocation() {
		return defaultInventoryLocation;
	}

	public void setDefaultInventoryLocation(boolean defaultInventoryLocation) {
		this.defaultInventoryLocation = defaultInventoryLocation;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyPair getCompanyPair() {
		return companyPair;
	}

	public void setCompanyPair(CompanyPair companyPair) {
		this.companyPair = companyPair;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
