package tests.e2e.module;

import java.util.ArrayList;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import tests.e2e.dataStore.DataStore;
import tests.e2e.staticKeys.Statickeys;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
	
	private String _id;
	private String name;
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String company;
	private String companyName;
	private boolean activated;
	private PasswordSetting passwordSetting;
	private PurchaseOrderNumber purchaseOrderNumber;
	private String license;
	private boolean viewAllOrders;
	private String status;
	private boolean archived;
	private ArrayList<CompanyLocation> companyLocations;
    private boolean internalTest;
    private String countryCode;
    private ArrayList<Object> subscriptions;
    private ArrayList<Object> powerBiEmails;
    private boolean generatePon;
    private String role;
    private String owner;
    private String billingName;
    private String billingEmail;
    private ColorScheme colorScheme;
    private ArrayList<SubCompany> subCompanies;
    private ArrayList<NameIdPair> companyRuns;
    private String createdAt;
    private String updatedAt;
    private String companyCode;
    private int __v;
    private ArrayList<Object> defaultCompanyRuns;
    private Addr1 addr1;
    private ArrayList<NameIdPair> measureUnits;
    private String website;
    private String commonStockProject;
    private ArrayList<Object> purchaseOrderHistory;
    private ArrayList<NameIdPair> qaqcIssueTypes;
    
    

    public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
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



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getCompanyName() {
		return companyName;
	}



	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}



	public boolean isActivated() {
		return activated;
	}



	public void setActivated(boolean activated) {
		this.activated = activated;
	}



	public PasswordSetting getPasswordSetting() {
		return passwordSetting;
	}



	public void setPasswordSetting(PasswordSetting passwordSetting) {
		this.passwordSetting = passwordSetting;
	}



	public PurchaseOrderNumber getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}



	public void setPurchaseOrderNumber(PurchaseOrderNumber purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}



	public String getLicense() {
		return license;
	}



	public void setLicense(String license) {
		this.license = license;
	}



	public boolean isViewAllOrders() {
		return viewAllOrders;
	}



	public void setViewAllOrders(boolean viewAllOrders) {
		this.viewAllOrders = viewAllOrders;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public boolean isArchived() {
		return archived;
	}



	public void setArchived(boolean archived) {
		this.archived = archived;
	}



	public ArrayList<CompanyLocation> getCompanyLocations() {
		return companyLocations;
	}



	public void setCompanyLocations(ArrayList<CompanyLocation> companyLocations) {
		this.companyLocations = companyLocations;
	}



	public boolean isInternalTest() {
		return internalTest;
	}



	public void setInternalTest(boolean internalTest) {
		this.internalTest = internalTest;
	}



	public String getCountryCode() {
		return countryCode;
	}



	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



	public ArrayList<Object> getSubscriptions() {
		return subscriptions;
	}



	public void setSubscriptions(ArrayList<Object> subscriptions) {
		this.subscriptions = subscriptions;
	}



	public ArrayList<Object> getPowerBiEmails() {
		return powerBiEmails;
	}



	public void setPowerBiEmails(ArrayList<Object> powerBiEmails) {
		this.powerBiEmails = powerBiEmails;
	}



	public boolean isGeneratePon() {
		return generatePon;
	}



	public void setGeneratePon(boolean generatePon) {
		this.generatePon = generatePon;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getOwner() {
		return owner;
	}



	public void setOwner(String owner) {
		this.owner = owner;
	}



	public String getBillingName() {
		return billingName;
	}



	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}



	public String getBillingEmail() {
		return billingEmail;
	}



	public void setBillingEmail(String billingEmail) {
		this.billingEmail = billingEmail;
	}



	public ColorScheme getColorScheme() {
		return colorScheme;
	}



	public void setColorScheme(ColorScheme colorScheme) {
		this.colorScheme = colorScheme;
	}



	public ArrayList<SubCompany> getSubCompanies() {
		return subCompanies;
	}



	public void setSubCompanies(ArrayList<SubCompany> subCompanies) {
		this.subCompanies = subCompanies;
	}



	public ArrayList<NameIdPair> getCompanyRuns() {
		return companyRuns;
	}



	public void setCompanyRuns(ArrayList<NameIdPair> companyRuns) {
		this.companyRuns = companyRuns;
	}



	public String getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}



	public String getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}



	public String getCompanyCode() {
		return companyCode;
	}



	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}



	public int get__v() {
		return __v;
	}



	public void set__v(int __v) {
		this.__v = __v;
	}



	public ArrayList<Object> getDefaultCompanyRuns() {
		return defaultCompanyRuns;
	}



	public void setDefaultCompanyRuns(ArrayList<Object> defaultCompanyRuns) {
		this.defaultCompanyRuns = defaultCompanyRuns;
	}



	public Addr1 getAddr1() {
		return addr1;
	}



	public void setAddr1(Addr1 addr1) {
		this.addr1 = addr1;
	}



	public ArrayList<NameIdPair> getMeasureUnits() {
		return measureUnits;
	}



	public void setMeasureUnits(ArrayList<NameIdPair> measureUnits) {
		this.measureUnits = measureUnits;
	}



	public String getWebsite() {
		return website;
	}



	public void setWebsite(String website) {
		this.website = website;
	}



	public String getCommonStockProject() {
		return commonStockProject;
	}



	public void setCommonStockProject(String commonStockProject) {
		this.commonStockProject = commonStockProject;
	}



	public ArrayList<Object> getPurchaseOrderHistory() {
		return purchaseOrderHistory;
	}



	public void setPurchaseOrderHistory(ArrayList<Object> purchaseOrderHistory) {
		this.purchaseOrderHistory = purchaseOrderHistory;
	}



	public ArrayList<NameIdPair> getQaqcIssueTypes() {
		return qaqcIssueTypes;
	}



	public void setQaqcIssueTypes(ArrayList<NameIdPair> qaqcIssueTypes) {
		this.qaqcIssueTypes = qaqcIssueTypes;
	}



	
}
