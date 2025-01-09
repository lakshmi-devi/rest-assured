package tests.e2e.module;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Assembly {

	private Created created;
	private LastModified lastModified;
	private Archived archived;
	private boolean purchase;
	private ArrayList<Object> parentAssemblyLinkId;
	private String _id;
	private String desc;
	private String type;
	private int partOf;
	private String __t;
	private String customId;
	private String name;
	private Category category;
	private String catId;
	private SubCategory subCategory;
	private ArrayList<Part> parts;
	private ArrayList<Object> assemblies;
	private ArrayList<Object> customAttributes;
	private String company;
	private String allPartsId;
	private int __v;
	private String id;

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

	public ArrayList<Object> getParentAssemblyLinkId() {
		return parentAssemblyLinkId;
	}

	public void setParentAssemblyLinkId(ArrayList<Object> parentAssemblyLinkId) {
		this.parentAssemblyLinkId = parentAssemblyLinkId;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public ArrayList<Part> getParts() {
		return parts;
	}

	public void setParts(ArrayList<Part> parts) {
		this.parts = parts;
	}

	public ArrayList<Object> getAssemblies() {
		return assemblies;
	}

	public void setAssemblies(ArrayList<Object> assemblies) {
		this.assemblies = assemblies;
	}

	public ArrayList<Object> getCustomAttributes() {
		return customAttributes;
	}

	public void setCustomAttributes(ArrayList<Object> customAttributes) {
		this.customAttributes = customAttributes;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAllPartsId() {
		return allPartsId;
	}

	public void setAllPartsId(String allPartsId) {
		this.allPartsId = allPartsId;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
