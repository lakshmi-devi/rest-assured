package tests.e2e.module;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Baseorder implements Cloneable {
	private BaseDelivery baseDelivery;

	private CurrentNote currentNote;

	private Owner owner;

	private EffectiveOwner effectiveOwner;

	private Created created;

	private ArrayList<NameIdPair> materials;

	private LastModified lastModified;

	private MultiTrade multiTrade;

	private Archived archived;

	private CreatedFrom createdFrom;

	private boolean notFromRequisition;

	private boolean massUpdate;

	private boolean purchase;

	private int templateLeadTime;

	private boolean hideFromMobile;

	private List<Object> keywords;

	private ArrayList<String> kitIds;

	private List<Object> source;

	private String stage;

	private String status;

	private String secondaryStatus;

	private String visibility;

	private String purpose;

	private boolean fromSchedule;

	private List<Object> revitGuids;

	private int numberOfItems;

	private boolean hasReserved;

	private boolean isLocked;

	private ArrayList<String> searchText;

	private String createdVia;

	private String poCreatedAt;

	private String updatedVia;

	private String runBaseTime;

	private String __t;

	private List<RunItemsCount> runItemsCount;

	private ArrayList<Object> dates;

	private ArrayList<Object> files;

	private ArrayList<FTD> todos;
	private ArrayList<Memos> memos;
//	private ArrayList<String> tags;
	private ArrayList<Tag> tags;
	private List<Object> notes;
	private List<Object> linkedCompanies;
	private List<Object> linkedOrders;
	private String _id;
	private String name;
	private String customId;
	private String linkedAssembly;
	private String contributingCatId;
	private Project project;
	private int stageWeight;
	private int __v;
	private ProductionOrder productionOrder;
	private Manager manager;
	private List<Items> items;
	private String id;
	private boolean updateAfterCreation;
	private DefaultRunNew defaultRun;
	private int estHrs;
	private double weldInches;
	private int extraCost;
	private ArrayList<String> idsMap;
	private boolean isDefault;
	private boolean isManager;
	private boolean isTrackingEnabled;
	private LeadDates leadDates;
	private String leastStage;
	private Location location;
	private Object simpleDates;
	private Object simpleFiles;
	private Object simpleMemos;
	private Object simpleTodos;
	private String stageUsed;
	private String templateId;
	private String templateName;
	private String totalCost;
	private String _customStage;
	private ArrayList<String> _excludedFields;
	private boolean _slimSave;
	private boolean isOneOrderPerItem;
	private ArrayList<Object> catQtyMaps;
	private ArrayList<Object> archiveManager;
	private ArrayList<Object> NotifyUsers;
	private boolean orderCreator;
	private String deliverDate;
	private boolean PTrackEnabled;
	private String PoDetailBy;
	private String PoManufactureBy;
	private boolean isEditing;
	private Specification specification;
	private ArrayList<Object> runs;
	private String templateOrder;
	private String projectId;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	private String QaBy;

	public String getQaBy() {
		return QaBy;
	}

	public void setQaBy(String qaBy) {
		QaBy = qaBy;
	}

	public BaseDelivery getBaseDelivery() {
		return baseDelivery;
	}

	public void setBaseDelivery(BaseDelivery baseDelivery) {
		this.baseDelivery = baseDelivery;
	}

	public CurrentNote getCurrentNote() {
		return currentNote;
	}

	public void setCurrentNote(CurrentNote currentNote) {
		this.currentNote = currentNote;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public EffectiveOwner getEffectiveOwner() {
		return effectiveOwner;
	}

	public void setEffectiveOwner(EffectiveOwner effectiveOwner) {
		this.effectiveOwner = effectiveOwner;
	}

	public Created getCreated() {
		return created;
	}

	public void setCreated(Created created) {
		this.created = created;
	}

	public ArrayList<NameIdPair> getMaterials() {
		return materials;
	}

	public void setMaterials(ArrayList<NameIdPair> materials) {
		this.materials = materials;
	}

	public LastModified getLastModified() {
		return lastModified;
	}

	public void setLastModified(LastModified lastModified) {
		this.lastModified = lastModified;
	}

	public MultiTrade getMultiTrade() {
		return multiTrade;
	}

	public void setMultiTrade(MultiTrade multiTrade) {
		this.multiTrade = multiTrade;
	}

	public Archived getArchived() {
		return archived;
	}

	public void setArchived(Archived archived) {
		this.archived = archived;
	}

	public CreatedFrom getCreatedFrom() {
		return createdFrom;
	}

	public void setCreatedFrom(CreatedFrom createdFrom) {
		this.createdFrom = createdFrom;
	}

	public boolean isNotFromRequisition() {
		return notFromRequisition;
	}

	public void setNotFromRequisition(boolean notFromRequisition) {
		this.notFromRequisition = notFromRequisition;
	}

	public boolean isMassUpdate() {
		return massUpdate;
	}

	public void setMassUpdate(boolean massUpdate) {
		this.massUpdate = massUpdate;
	}

	public int getTemplateLeadTime() {
		return templateLeadTime;
	}

	public void setTemplateLeadTime(int templateLeadTime) {
		this.templateLeadTime = templateLeadTime;
	}

	public boolean isHideFromMobile() {
		return hideFromMobile;
	}

	public void setHideFromMobile(boolean hideFromMobile) {
		this.hideFromMobile = hideFromMobile;
	}

	public List<Object> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<Object> keywords) {
		this.keywords = keywords;
	}

	public ArrayList<String> getKitIds() {
		return kitIds;
	}

	public void setKitIds(ArrayList<String> kitIds) {
		this.kitIds = kitIds;
	}

	public List<Object> getSource() {
		return source;
	}

	public void setSource(List<Object> source) {
		this.source = source;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSecondaryStatus() {
		return secondaryStatus;
	}

	public void setSecondaryStatus(String secondaryStatus) {
		this.secondaryStatus = secondaryStatus;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public boolean isFromSchedule() {
		return fromSchedule;
	}

	public void setFromSchedule(boolean fromSchedule) {
		this.fromSchedule = fromSchedule;
	}

	public List<Object> getRevitGuids() {
		return revitGuids;
	}

	public void setRevitGuids(List<Object> revitGuids) {
		this.revitGuids = revitGuids;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public boolean isHasReserved() {
		return hasReserved;
	}

	public void setHasReserved(boolean hasReserved) {
		this.hasReserved = hasReserved;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setIsLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public ArrayList<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(ArrayList<String> searchText) {
		this.searchText = searchText;
	}

	public String getCreatedVia() {
		return createdVia;
	}

	public void setCreatedVia(String createdVia) {
		this.createdVia = createdVia;
	}

	public String getPoCreatedAt() {
		return poCreatedAt;
	}

	public void setPoCreatedAt(String poCreatedAt) {
		this.poCreatedAt = poCreatedAt;
	}

	public String getUpdatedVia() {
		return updatedVia;
	}

	public void setUpdatedVia(String updatedVia) {
		this.updatedVia = updatedVia;
	}

	public String getRunBaseTime() {
		return runBaseTime;
	}

	public void setRunBaseTime(String runBaseTime) {
		this.runBaseTime = runBaseTime;
	}

	public String get__t() {
		return __t;
	}

	public void set__t(String __t) {
		this.__t = __t;
	}

	public List<RunItemsCount> getRunItemsCount() {
		return runItemsCount;
	}

	public void setRunItemsCount(List<RunItemsCount> runItemsCount) {
		this.runItemsCount = runItemsCount;
	}

	public ArrayList<Object> getDates() {
		return dates;
	}

	public void setDates(ArrayList<Object> dates) {
		this.dates = dates;
	}

	public ArrayList<Object> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<Object> files) {
		this.files = files;
	}

	public ArrayList<FTD> getTodos() {
		return todos;
	}

	public void setTodos(ArrayList<FTD> todos) {
		this.todos = todos;
	}

	public ArrayList<Memos> getMemos() {
		return memos;
	}

	public void setMemos(ArrayList<Memos> memos) {
		this.memos = memos;
	}

	public ArrayList<Tag> getTags() {
		return tags;
	}

	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}

//	public ArrayList<String> getTags() {
//		return tags;
//	}
//
//	public void setTags(ArrayList<String> tags) {
//		this.tags = tags;
//	}

	public List<Object> getNotes() {
		return notes;
	}

	public void setNotes(List<Object> notes) {
		this.notes = notes;
	}

	public List<Object> getLinkedCompanies() {
		return linkedCompanies;
	}

	public void setLinkedCompanies(List<Object> linkedCompanies) {
		this.linkedCompanies = linkedCompanies;
	}

	public List<Object> getLinkedOrders() {
		return linkedOrders;
	}

	public void setLinkedOrders(List<Object> linkedOrders) {
		this.linkedOrders = linkedOrders;
	}

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

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getLinkedAssembly() {
		return linkedAssembly;
	}

	public void setLinkedAssembly(String linkedAssembly) {
		this.linkedAssembly = linkedAssembly;
	}

	public String getContributingCatId() {
		return contributingCatId;
	}

	public void setContributingCatId(String contributingCatId) {
		this.contributingCatId = contributingCatId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public int getStageWeight() {
		return stageWeight;
	}

	public void setStageWeight(int stageWeight) {
		this.stageWeight = stageWeight;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public ProductionOrder getProductionOrder() {
		return productionOrder;
	}

	public void setProductionOrder(ProductionOrder productionOrder) {
		this.productionOrder = productionOrder;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isUpdateAfterCreation() {
		return updateAfterCreation;
	}

	public void setUpdateAfterCreation(boolean updateAfterCreation) {
		this.updateAfterCreation = updateAfterCreation;
	}

	public DefaultRunNew getDefaultRun() {
		return defaultRun;
	}

	public void setDefaultRun(DefaultRunNew defaultRun) {
		this.defaultRun = defaultRun;
	}

	public int getEstHrs() {
		return estHrs;
	}

	public void setEstHrs(int estHrs) {
		this.estHrs = estHrs;
	}

	public double getWeldInches() {
		return weldInches;
	}

	public void setWeldInches(double weldInches) {
		this.weldInches = weldInches;
	}

	public int getExtraCost() {
		return extraCost;
	}

	public void setExtraCost(int extraCost) {
		this.extraCost = extraCost;
	}

	public ArrayList<String> getIdsMap() {
		return idsMap;
	}

	public void setIdsMap(ArrayList<String> idsMap) {
		this.idsMap = idsMap;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setIsManager(boolean isManager) {
		this.isManager = isManager;
	}

	public boolean isTrackingEnabled() {
		return isTrackingEnabled;
	}

	public void setTrackingEnabled(boolean isTrackingEnabled) {
		this.isTrackingEnabled = isTrackingEnabled;
	}

	public LeadDates getLeadDates() {
		return leadDates;
	}

	public void setLeadDates(LeadDates leadDates) {
		this.leadDates = leadDates;
	}

	public String getLeastStage() {
		return leastStage;
	}

	public void setLeastStage(String leastStage) {
		this.leastStage = leastStage;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Object getSimpleDates() {
		return simpleDates;
	}

	public void setSimpleDates(Object simpleDates) {
		this.simpleDates = simpleDates;
	}

	public Object getSimpleFiles() {
		return simpleFiles;
	}

	public void setSimpleFiles(Object simpleFiles) {
		this.simpleFiles = simpleFiles;
	}

	public Object getSimpleMemos() {
		return simpleMemos;
	}

	public void setSimpleMemos(Object simpleMemos) {
		this.simpleMemos = simpleMemos;
	}

	public Object getSimpleTodos() {
		return simpleTodos;
	}

	public void setSimpleTodos(Object simpleTodos) {
		this.simpleTodos = simpleTodos;
	}

	public String getStageUsed() {
		return stageUsed;
	}

	public void setStageUsed(String stageUsed) {
		this.stageUsed = stageUsed;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public String get_customStage() {
		return _customStage;
	}

	public void set_customStage(String _customStage) {
		this._customStage = _customStage;
	}

	public ArrayList<String> get_excludedFields() {
		return _excludedFields;
	}

	public void set_excludedFields(ArrayList<String> _excludedFields) {
		this._excludedFields = _excludedFields;
	}

	public boolean is_slimSave() {
		return _slimSave;
	}

	public void set_slimSave(boolean _slimSave) {
		this._slimSave = _slimSave;
	}

	public boolean isOneOrderPerItem() {
		return isOneOrderPerItem;
	}

	public void setOneOrderPerItem(boolean isOneOrderPerItem) {
		this.isOneOrderPerItem = isOneOrderPerItem;
	}

	public ArrayList<Object> getCatQtyMaps() {
		return catQtyMaps;
	}

	public void setCatQtyMaps(ArrayList<Object> catQtyMaps) {
		this.catQtyMaps = catQtyMaps;
	}

	public ArrayList<Object> getArchiveManager() {
		return archiveManager;
	}

	public void setArchiveManager(ArrayList<Object> archiveManager) {
		this.archiveManager = archiveManager;
	}

	public ArrayList<Object> getNotifyUsers() {
		return NotifyUsers;
	}

	public void setNotifyUsers(ArrayList<Object> notifyUsers) {
		NotifyUsers = notifyUsers;
	}

	public boolean isOrderCreator() {
		return orderCreator;
	}

	public void setOrderCreator(boolean orderCreator) {
		this.orderCreator = orderCreator;
	}

	public String getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}

	public boolean isPTrackEnabled() {
		return PTrackEnabled;
	}

	public void setPTrackEnabled(boolean pTrackEnabled) {
		PTrackEnabled = pTrackEnabled;
	}

	public String getPoDetailBy() {
		return PoDetailBy;
	}

	public void setPoDetailBy(String poDetailBy) {
		PoDetailBy = poDetailBy;
	}

	public String getPoManufactureBy() {
		return PoManufactureBy;
	}

	public void setPoManufactureBy(String poManufactureBy) {
		PoManufactureBy = poManufactureBy;
	}

	public boolean isEditing() {
		return isEditing;
	}

	public void setEditing(boolean isEditing) {
		this.isEditing = isEditing;
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public ArrayList<Object> getRuns() {
		return runs;
	}

	public void setRuns(ArrayList<Object> runs) {
		this.runs = runs;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public boolean isPurchase() {
		return purchase;
	}

	public String getTemplateOrder() {
		return templateOrder;
	}

	public void setPurchase(boolean purchase) {
		this.purchase = purchase;
	}

	public void setTemplateOrder(String templateOrder) {
		this.templateOrder = templateOrder;
	}
}
