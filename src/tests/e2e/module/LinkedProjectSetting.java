package tests.e2e.module;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class LinkedProjectSetting {
	@JsonInclude(Include.NON_NULL)
	@JsonIgnoreProperties(ignoreUnknown = true)	
	
	    private String status;
	    private boolean toNotify;
	    private int notifications;
	    private boolean isPrivate;
	    private boolean isPTEnabled;
	    private String companyId;
	    private Object forgeSync;
	    private String customId;
	    private CompanyLocation projectInventoryLocation;
	    
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public boolean isToNotify() {
			return toNotify;
		}
		public void setToNotify(boolean toNotify) {
			this.toNotify = toNotify;
		}
		public int getNotifications() {
			return notifications;
		}
		public void setNotifications(int notifications) {
			this.notifications = notifications;
		}
		public boolean isPrivate() {
			return isPrivate;
		}
		public void setPrivate(boolean isPrivate) {
			this.isPrivate = isPrivate;
		}
		public boolean isPTEnabled() {
			return isPTEnabled;
		}
		public void setPTEnabled(boolean isPTEnabled) {
			this.isPTEnabled = isPTEnabled;
		}
		public String getCompanyId() {
			return companyId;
		}
		public void setCompanyId(String companyId) {
			this.companyId = companyId;
		}
		public Object getForgeSync() {
			return forgeSync;
		}
		public void setForgeSync(Object forgeSync) {
			this.forgeSync = forgeSync;
		}
		public String getCustomId() {
			return customId;
		}
		public void setCustomId(String customId) {
			this.customId = customId;
		}
		public CompanyLocation getProjectInventoryLocation() {
			return projectInventoryLocation;
		}
		public void setProjectInventoryLocation(CompanyLocation projectInventoryLocation) {
			this.projectInventoryLocation = projectInventoryLocation;
		}

		
}
