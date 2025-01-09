package tests.e2e.module;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class User {
	private boolean activated;
	private String _id;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
	private String company;
	private ArrayList<MultiCompany> multiCompanies;
	private ArrayList<PermissionSetting> permissionSettings;
	private String fullName;
	private String name;
	private String nameWithCompany;
	private String id;
	private String role;
	private boolean isAdmin;
	private String projectId;
	private String memberRole;

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public ArrayList<MultiCompany> getMultiCompanies() {
		return multiCompanies;
	}

	public void setMultiCompanies(ArrayList<MultiCompany> multiCompanies) {
		this.multiCompanies = multiCompanies;
	}

	public ArrayList<PermissionSetting> getPermissionSettings() {
		return permissionSettings;
	}

	public void setPermissionSettings(ArrayList<PermissionSetting> permissionSettings) {
		this.permissionSettings = permissionSettings;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameWithCompany() {
		return nameWithCompany;
	}

	public void setNameWithCompany(String nameWithCompany) {
		this.nameWithCompany = nameWithCompany;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

}
