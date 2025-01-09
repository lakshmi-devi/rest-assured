package tests.e2e.module;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Part {
	private int quantity;
	private String _id;
	private String catId;
	private String notes;
	private Created created;
	private LastModified lastModified;
	private Archived archived;
	private boolean purchase;
	private String desc;
	private String type;
	private int partOf;
	private String __t;
	private String customId;
	private String name;
	private String measureUnits;
	private Category category;
	private SubCategory subCategory;
	private ArrayList<Object> vendor;
	private ArrayList<Object> labour;
	private ArrayList<Object> costCode;
	private ArrayList<Object> parts;
	private ArrayList<Object> customAttributes;
	private ArrayList<NameIdPair> nameList;
	private String company;
	private int __v;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public boolean isPurchase() {
		return purchase;
	}

	public void setPurchase(boolean purchase) {
		this.purchase = purchase;
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

	public String getMeasureUnits() {
		return measureUnits;
	}

	public void setMeasureUnits(String measureUnits) {
		this.measureUnits = measureUnits;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public ArrayList<Object> getVendor() {
		return vendor;
	}

	public void setVendor(ArrayList<Object> vendor) {
		this.vendor = vendor;
	}

	public ArrayList<Object> getLabour() {
		return labour;
	}

	public void setLabour(ArrayList<Object> labour) {
		this.labour = labour;
	}

	public ArrayList<Object> getCostCode() {
		return costCode;
	}

	public void setCostCode(ArrayList<Object> costCode) {
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

}
