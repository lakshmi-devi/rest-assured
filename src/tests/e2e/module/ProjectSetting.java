package tests.e2e.module;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ProjectSetting {
	private String status;
	private boolean toNotify;
	private int notifications;
	private boolean isPrivate;
	private boolean isPTEnabled;
	private String companyId;
	private Object forgeSync;
	private String customId;
	private CompanyLocation projectInventoryLocation;
	private ForgeHook forgeHook;
	private boolean isNestedInventoryLocation;
	private boolean allowReceiveShipment;
	private boolean addDefaultRun;
	private boolean isCatIdRequired;
	private String editSettingTab;
	private String _id;
	private ArrayList<ProjectCompanyRun> projectCompanyRuns;
	private ArrayList<Object> defaultProjectCompanyRuns;
	private DefaultReceiver defaultReceiver;

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

	public void setForgeSync(Object ForgeSync) {
		this.forgeSync = ForgeSync;
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

	public ForgeHook getForgeHook() {
		return forgeHook;
	}

	public void setForgeHook(ForgeHook forgeHook) {
		this.forgeHook = forgeHook;
	}

	public boolean isNestedInventoryLocation() {
		return isNestedInventoryLocation;
	}

	public void setNestedInventoryLocation(boolean isNestedInventoryLocation) {
		this.isNestedInventoryLocation = isNestedInventoryLocation;
	}

	public boolean isAllowReceiveShipment() {
		return allowReceiveShipment;
	}

	public void setAllowReceiveShipment(boolean allowReceiveShipment) {
		this.allowReceiveShipment = allowReceiveShipment;
	}

	public boolean isAddDefaultRun() {
		return addDefaultRun;
	}

	public void setAddDefaultRun(boolean addDefaultRun) {
		this.addDefaultRun = addDefaultRun;
	}

	public boolean isCatIdRequired() {
		return isCatIdRequired;
	}

	public void setCatIdRequired(boolean isCatIdRequired) {
		this.isCatIdRequired = isCatIdRequired;
	}

	public String getEditSettingTab() {
		return editSettingTab;
	}

	public void setEditSettingTab(String editSettingTab) {
		this.editSettingTab = editSettingTab;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public ArrayList<ProjectCompanyRun> getProjectCompanyRuns() {
		return projectCompanyRuns;
	}

	public void setProjectCompanyRuns(ArrayList<ProjectCompanyRun> projectCompanyRuns) {
		this.projectCompanyRuns = projectCompanyRuns;
	}

	public ArrayList<Object> getDefaultProjectCompanyRuns() {
		return defaultProjectCompanyRuns;
	}

	public void setDefaultProjectCompanyRuns(ArrayList<Object> defaultProjectCompanyRuns) {
		this.defaultProjectCompanyRuns = defaultProjectCompanyRuns;
	}

	public DefaultReceiver getDefaultReceiver() {
		return defaultReceiver;
	}

	public void setDefaultReceiver(DefaultReceiver defaultReceiver) {
		this.defaultReceiver = defaultReceiver;
	}

}
