package tests.e2e.module;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserMe {

	private FailLoginAttempt failLoginAttempt;
	private boolean viewOnlyMember;
	private boolean hasSetPassword;
	private boolean activated;
	private boolean archived;
	private boolean isAdmin;
	private String openPreference;
	private String defaultLanding;
	private boolean rememberLastUsedProjects;
	private boolean needPasswordUpdate;
	private boolean isEmailPush;
	private String role;
	private int activeProjectsCount;
	private String _id;
	private String oneTimeKey;
	private String firstName;
	private String lastName;
	private String email;
	private String companyName;
	private int __v;
	private ResolvedPermissionGroups resolvedPermissionGroups;
	private String lastLoginAppVersion;
	private String fullName;
	private String name;
	private String nameWithCompany;
	private String id;

	public FailLoginAttempt getFailLoginAttempt() {
		return failLoginAttempt;
	}

	public void setFailLoginAttempt(FailLoginAttempt failLoginAttempt) {
		this.failLoginAttempt = failLoginAttempt;
	}

	public boolean isViewOnlyMember() {
		return viewOnlyMember;
	}

	public void setViewOnlyMember(boolean viewOnlyMember) {
		this.viewOnlyMember = viewOnlyMember;
	}

	public boolean isHasSetPassword() {
		return hasSetPassword;
	}

	public void setHasSetPassword(boolean hasSetPassword) {
		this.hasSetPassword = hasSetPassword;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean isArchived() {
		return archived;
	}

	public void setArchived(boolean archived) {
		this.archived = archived;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getOpenPreference() {
		return openPreference;
	}

	public void setOpenPreference(String openPreference) {
		this.openPreference = openPreference;
	}

	public String getDefaultLanding() {
		return defaultLanding;
	}

	public void setDefaultLanding(String defaultLanding) {
		this.defaultLanding = defaultLanding;
	}

	public boolean isRememberLastUsedProjects() {
		return rememberLastUsedProjects;
	}

	public void setRememberLastUsedProjects(boolean rememberLastUsedProjects) {
		this.rememberLastUsedProjects = rememberLastUsedProjects;
	}

	public boolean isNeedPasswordUpdate() {
		return needPasswordUpdate;
	}

	public void setNeedPasswordUpdate(boolean needPasswordUpdate) {
		this.needPasswordUpdate = needPasswordUpdate;
	}

	public boolean isEmailPush() {
		return isEmailPush;
	}

	public void setEmailPush(boolean isEmailPush) {
		this.isEmailPush = isEmailPush;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getActiveProjectsCount() {
		return activeProjectsCount;
	}

	public void setActiveProjectsCount(int activeProjectsCount) {
		this.activeProjectsCount = activeProjectsCount;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getOneTimeKey() {
		return oneTimeKey;
	}

	public void setOneTimeKey(String oneTimeKey) {
		this.oneTimeKey = oneTimeKey;
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

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public ResolvedPermissionGroups getResolvedPermissionGroups() {
		return resolvedPermissionGroups;
	}

	public void setResolvedPermissionGroups(ResolvedPermissionGroups resolvedPermissionGroups) {
		this.resolvedPermissionGroups = resolvedPermissionGroups;
	}

	public String getLastLoginAppVersion() {
		return lastLoginAppVersion;
	}

	public void setLastLoginAppVersion(String lastLoginAppVersion) {
		this.lastLoginAppVersion = lastLoginAppVersion;
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

}

