package tests.e2e.module;

import java.util.ArrayList;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Vendor {
	private String _id;
	private String _name;
	private String name;
	private String id;
	private boolean isDefault;
	private boolean isPreferred;
	private boolean isImported;
	private int leadTime;
	private String code;
	private String desc;
	private Created created;
	private LastModified lastModified;
	private Archived archived;
	private String company;
	private ArrayList<NameIdPair> nameList;
	private ArrayList<Category> category;
	private ArrayList<SubCategory> subCategory;
	private ArrayList<Address> address;
	private int __v;
	private boolean isTemporary;
	private String uniqueKey;

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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public ArrayList<NameIdPair> getNameList() {
		return nameList;
	}

	public void setNameList(ArrayList<NameIdPair> nameList) {
		this.nameList = nameList;
	}

	public ArrayList<Category> getCategory() {
		return category;
	}

	public void setCategory(ArrayList<Category> category) {
		this.category = category;
	}

	public ArrayList<SubCategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(ArrayList<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}

	public ArrayList<Address> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public boolean isTemporary() {
		return isTemporary;
	}

	public void setTemporary(boolean isTemporary) {
		this.isTemporary = isTemporary;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isPreferred() {
		return isPreferred;
	}

	public void setPreferred(boolean isPreferred) {
		this.isPreferred = isPreferred;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_id() {
		return this._id;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_name() {
		return this._name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

}
