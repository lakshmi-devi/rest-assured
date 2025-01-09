package tests.e2e.module;

import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class CompanyLocation {
	private ArrayList<String> location_type;
	private boolean archived;
	private ArrayList<String> project;
	private boolean nestedLocation;
	private ArrayList<Object> allParents;
	private ArrayList<Object> children;
	private boolean isLeaf;
	private int level;
	private String fullAddress;
	private boolean defaultInventoryLocation;
	private String _id;
	private String name;
	private String owner;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String company;
	private String type;
	private String createdBy;
	private String modifiedBy;
	private Date createdAt;
	private Date updatedAt;
	private int __v;
	private NameIdPair companyPair;
	private String id;
	public Object parent;

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public ArrayList<String> getLocation_type() {
		return location_type;
	}

	public void setLocation_type(ArrayList<String> location_type) {
		this.location_type = location_type;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public ArrayList<String> getProject() {
		return project;
	}

	public void setProject(ArrayList<String> project) {
		this.project = project;
	}

	public boolean isNestedLocation() {
		return nestedLocation;
	}

	public void setNestedLocation(boolean nestedLocation) {
		this.nestedLocation = nestedLocation;
	}

	public ArrayList<Object> getAllParents() {
		return allParents;
	}

	public void setAllParents(ArrayList<Object> allParents) {
		this.allParents = allParents;
	}

	public ArrayList<Object> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Object> children) {
		this.children = children;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public NameIdPair getCompanyPair() {
		return companyPair;
	}

	public void setCompanyPair(NameIdPair companyPair) {
		this.companyPair = companyPair;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
