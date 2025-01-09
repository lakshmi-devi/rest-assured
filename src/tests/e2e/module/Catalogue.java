package tests.e2e.module;
//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1

//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Catalogue {
	private String _id;
	private Created created;
	private LastModified lastModified;
	private Archived archived;
	private String desc;
	private String type;
	private int partOf;
	private String __t;
	private String customId;
	private String name;
	private String catId;
	private Category category;
	private SubCategory subCategory;
	private String measureUnits;
	private ArrayList<Vendor> vendor;
	private ArrayList<Labour> labour;
	private ArrayList<CostCode> costCode;
	private ArrayList<Object> parts;
	private ArrayList<Object> customAttributes;
	private ArrayList<NameIdPair> nameList;
	private String company;
	private int __v;
	private boolean purchase;
	private String activeSupplier;
	private ArrayList<Object> parentAssemblyLinkId;
	private ArrayList<Object> assemblies;
	private String allPartsId;
	private Boolean isEditing;
	private Boolean newRow;
	private int quantity;
	private ArrayList<Object> categoryId;
	private int limit;
	private int page;
	private String search;
	private String showItems = "show-active-catalogs";
	private ArrayList<Sort> sort;
	private Object subCategoryId;
	
	public Boolean getIsEditing() {
		return isEditing;
	}

	public void setIsEditing(Boolean isEditing) {
		this.isEditing = isEditing;
	}

	public Boolean getNewRow() {
		return newRow;
	}

	public void setNewRow(Boolean newRow) {
		this.newRow = newRow;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ArrayList<Object> getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(ArrayList<Object> categoryId) {
		this.categoryId = categoryId;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getShowItems() {
		return showItems;
	}

	public void setShowItems(String showItems) {
		this.showItems = showItems;
	}

	public ArrayList<Sort> getSort() {
		return sort;
	}

	public void setSort(ArrayList<Sort> sort) {
		this.sort = sort;
	}

	public Object getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Object subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Created getCreated() {
		return created;
	}

	public void setCreated(Created created) {
		this.created = created;
	}

	public LastModified getLastModified() {
		return lastModified;
	}

	public void setLastModified(LastModified lastModified) {
		this.lastModified = lastModified;
	}

	public Archived getArchived() {
		return archived;
	}

	public void setArchived(Archived archived) {
		this.archived = archived;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPartOf() {
		return partOf;
	}

	public void setPartOf(int partOf) {
		this.partOf = partOf;
	}

	public String get__t() {
		return __t;
	}

	public void set__t(String __t) {
		this.__t = __t;
	}

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category categoryItem) {
		this.category = categoryItem;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public String getMeasureUnits() {
		return measureUnits;
	}

	public void setMeasureUnits(String measureUnits) {
		this.measureUnits = measureUnits;
	}

	public ArrayList<Vendor> getVendor() {
		return vendor;
	}

	public void setVendor(ArrayList<Vendor> vendor) {
		this.vendor = vendor;
	}

	public ArrayList<Labour> getLabour() {
		return labour;
	}

	public void setLabour(ArrayList<Labour> labour) {
		this.labour = labour;
	}

	public ArrayList<CostCode> getCostCode() {
		return costCode;
	}

	public void setCostCode(ArrayList<CostCode> costCode) {
		this.costCode = costCode;
	}

	public ArrayList<Object> getParts() {
		return parts;
	}

	public void setParts(ArrayList<Object> parts) {
		this.parts = parts;
	}

	public ArrayList<Object> getCustomAttributes() {
		return customAttributes;
	}

	public void setCustomAttributes(ArrayList<Object> customAttributes) {
		this.customAttributes = customAttributes;
	}

	public ArrayList<NameIdPair> getNameList() {
		return nameList;
	}

	public void setNameList(ArrayList<NameIdPair> nameList) {
		this.nameList = nameList;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public boolean isPurchase() {
		return purchase;
	}

	public void setPurchase(boolean purchase) {
		this.purchase = purchase;
	}

	public String getActiveSupplier() {
		return activeSupplier;
	}

	public void setActiveSupplier(String activeSupplier) {
		this.activeSupplier = activeSupplier;
	}

	public ArrayList<Object> getParentAssemblyLinkId() {
		return parentAssemblyLinkId;
	}

	public void setParentAssemblyLinkId(ArrayList<Object> parentAssemblyLinkId) {
		this.parentAssemblyLinkId = parentAssemblyLinkId;
	}

	public ArrayList<Object> getAssemblies() {
		return assemblies;
	}

	public void setAssemblies(ArrayList<Object> assemblies) {
		this.assemblies = assemblies;
	}

	public String getAllPartsId() {
		return allPartsId;
	}

	public void setAllPartsId(String allPartsId) {
		this.allPartsId = allPartsId;
	}

}
