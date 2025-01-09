package tests.e2e.module;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Member {

	private String autoAdd;
	private boolean disableAutoAdd;
	private ArrayList<Object> secondaryRoles;
	private String _statusForCompany = "Active";
	private String name;
	private String email;
	private String role;
	private ArrayList<String> permissionGroups;
	private String mobile;
	private String app;
	private String status;
	private String action;
	private boolean isEditing;
	private boolean newRow;
	private String fullName;
	private String firstName;
	private String lastName;

	public String getAutoAdd() {
		return autoAdd;
	}

	public void setAutoAdd(String autoAdd) {
		this.autoAdd = autoAdd;
	}

	public boolean isDisableAutoAdd() {
		return disableAutoAdd;
	}

	public void setDisableAutoAdd(boolean disableAutoAdd) {
		this.disableAutoAdd = disableAutoAdd;
	}

	public ArrayList<Object> getSecondaryRoles() {
		return secondaryRoles;
	}

	public void setSecondaryRoles(ArrayList<Object> secondaryRoles) {
		this.secondaryRoles = secondaryRoles;
	}

	public String get_statusForCompany() {
		return _statusForCompany;
	}

	public void set_statusForCompany(String _statusForCompany) {
		this._statusForCompany = _statusForCompany;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getPermissionGroups() {
		return permissionGroups;
	}

	public void setPermissionGroups(ArrayList<String> permissionGroups) {
		this.permissionGroups = permissionGroups;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean isEditing() {
		return isEditing;
	}

	public void setEditing(boolean isEditing) {
		this.isEditing = isEditing;
	}

	public boolean isNewRow() {
		return newRow;
	}

	public void setNewRow(boolean newRow) {
		this.newRow = newRow;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

}
