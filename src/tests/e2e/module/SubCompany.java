package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class SubCompany {
	private String role;
	private String status;
	private String company_name;
	private String contact;
	private String invitedUser;
	private String invitingUser;
	private String company_id;
	private String _id;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getInvitedUser() {
		return invitedUser;
	}

	public void setInvitedUser(String invitedUser) {
		this.invitedUser = invitedUser;
	}

	public String getInvitingUser() {
		return invitingUser;
	}

	public void setInvitingUser(String invitingUser) {
		this.invitingUser = invitingUser;
	}

	public String getCompany_id() {
		return company_id;
	}

	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}
