package tests.e2e.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;

import groovyjarjarantlr4.v4.parse.ANTLRParser.block_return;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Items {

	private StageMap stageMap;

	private Created created;

	private Company company;

	private String itemId;

	private Qa qa;

	private String orderId;

	private Vendor vendor;

	private Vendor vendors;

	private Actual actual;

	private Summary summary;

	private Serials serials;

	private Archived archived;

	private List<String> installLocs;

	private String catId;

	private boolean hasBom;

	private String status;

	private String purpose;

	private String stage;

	private int quantity;

	private int minQuantity;

	private int maxQuantity;

	private String inventoryNotes;

	private String activeSupplier;

	private Boolean purchase;

	private int leadTime;

	private String measureUnits;

	private List<String> revitGuids;

	private List<String> cards;

	private String pf;

//    private StageMap stageMap;

	private boolean fromMasterCatalog;

	private boolean combinedQuantity;

	private String updatedVia;

	private String __t;

	private String _id;

	private String name;

	private String contributingPOItem;

	private List<String> qtyLocations;

	private ArrayList<MaterialItems> materialItems;

	private Category category;

	private SubCategory subCategory;

	private Project project;

	private String baseCardType;

	private Location location;

	private int __v;

	private String customId;

	private String cardKind;

	private String costCode;

	private String uuid;

	private Prefab prefab;

	private String id;

	private String _place;

	private String _accessor;

	private int measure;

	private String level;

	private String zone;

	private boolean isNew;

	private boolean isEditing;
	private Object simpleDates;
	private ArrayList<Object> simpleTodos;
	private ArrayList<Object> simpleFiles;
	private Object unitCost;
	private Object totalCost;
	private Object totalItemsCost;
	private int runCount;
	private int inRunCount;
	private int actualHrs;
	private int plannedHrs;

	private int actualQty;
	private Object underDeliver;
	private String issueNote;
	private String runId;

	private String itemLevel;
	private String itemZone;

	private boolean toConsume;

	private int returnedCount;
	private int viewIndex;

	private Object cardId;
	private ArrayList<Object> returnHistory;

	public StageMap getStageMap() {
		return stageMap;
	}

	public void setStageMap(StageMap stageMap) {
		this.stageMap = stageMap;
	}

	public Created getCreated() {
		return created;
	}

	public void setCreated(Created created) {
		this.created = created;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Qa getQa() {
		return qa;
	}

	public void setQa(Qa qa) {
		this.qa = qa;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Vendor getVendors() {
		return vendors;
	}

	public void setVendors(Vendor vendors) {
		this.vendors = vendors;
	}

	public Actual getActual() {
		return actual;
	}

	public void setActual(Actual actual) {
		this.actual = actual;
	}

	public Summary getSummary() {
		return summary;
	}

	public void setSummary(Summary summary) {
		this.summary = summary;
	}

	public Serials getSerials() {
		return serials;
	}

	public void setSerials(Serials serials) {
		this.serials = serials;
	}

	public Archived getArchived() {
		return archived;
	}

	public void setArchived(Archived archived) {
		this.archived = archived;
	}

	public List<String> getInstallLocs() {
		return installLocs;
	}

	public void setInstallLocs(List<String> installLocs) {
		this.installLocs = installLocs;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public boolean isHasBom() {
		return hasBom;
	}

	public void setHasBom(boolean hasBom) {
		this.hasBom = hasBom;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		this.minQuantity = minQuantity;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public String getInventoryNotes() {
		return inventoryNotes;
	}

	public void setInventoryNotes(String inventoryNotes) {
		this.inventoryNotes = inventoryNotes;
	}

	public String getActiveSupplier() {
		return activeSupplier;
	}

	public void setActiveSupplier(String activeSupplier) {
		this.activeSupplier = activeSupplier;
	}

	public Boolean getPurchase() {
		return purchase;
	}

	public void setPurchase(Boolean purchase) {
		this.purchase = purchase;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public String getMeasureUnits() {
		return measureUnits;
	}

	public void setMeasureUnits(String measureUnits) {
		this.measureUnits = measureUnits;
	}

	public List<String> getRevitGuids() {
		return revitGuids;
	}

	public void setRevitGuids(List<String> revitGuids) {
		this.revitGuids = revitGuids;
	}

	public List<String> getCards() {
		return cards;
	}

	public void setCards(List<String> cards) {
		this.cards = cards;
	}

	public String getPf() {
		return pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public boolean isFromMasterCatalog() {
		return fromMasterCatalog;
	}

	public void setFromMasterCatalog(boolean fromMasterCatalog) {
		this.fromMasterCatalog = fromMasterCatalog;
	}

	public boolean isCombinedQuantity() {
		return combinedQuantity;
	}

	public void setCombinedQuantity(boolean combinedQuantity) {
		this.combinedQuantity = combinedQuantity;
	}

	public String getUpdatedVia() {
		return updatedVia;
	}

	public void setUpdatedVia(String updatedVia) {
		this.updatedVia = updatedVia;
	}

	public String get__t() {
		return __t;
	}

	public void set__t(String __t) {
		this.__t = __t;
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

	public String getContributingPOItem() {
		return contributingPOItem;
	}

	public void setContributingPOItem(String contributingPOItem) {
		this.contributingPOItem = contributingPOItem;
	}

	public List<String> getQtyLocations() {
		return qtyLocations;
	}

	public void setQtyLocations(List<String> qtyLocations) {
		this.qtyLocations = qtyLocations;
	}

	public ArrayList<MaterialItems> getMaterialItems() {
		return materialItems;
	}

	public void setMaterialItems(ArrayList<MaterialItems> materialItems) {
		this.materialItems = materialItems;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getBaseCardType() {
		return baseCardType;
	}

	public void setBaseCardType(String baseCardType) {
		this.baseCardType = baseCardType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public String getCustomId() {
		return customId;
	}

	public void setCustomId(String customId) {
		this.customId = customId;
	}

	public String getCardKind() {
		return cardKind;
	}

	public void setCardKind(String cardKind) {
		this.cardKind = cardKind;
	}

	public String getCostCode() {
		return costCode;
	}

	public void setCostCode(String costCode) {
		this.costCode = costCode;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Prefab getPrefab() {
		return prefab;
	}

	public void setPrefab(Prefab prefab) {
		this.prefab = prefab;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String get_place() {
		return _place;
	}

	public void set_place(String _place) {
		this._place = _place;
	}

	public String get_accessor() {
		return _accessor;
	}

	public void set_accessor(String _accessor) {
		this._accessor = _accessor;
	}

	public int getMeasure() {
		return measure;
	}

	public void setMeasure(int measure) {
		this.measure = measure;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public boolean isEditing() {
		return isEditing;
	}

	public void setEditing(boolean isEditing) {
		this.isEditing = isEditing;
	}

	public Object getSimpleDates() {
		return simpleDates;
	}

	public void setSimpleDates(Object simpleDates) {
		this.simpleDates = simpleDates;
	}

	public ArrayList<Object> getSimpleTodos() {
		return simpleTodos;
	}

	public void setSimpleTodos(ArrayList<Object> simpleTodos) {
		this.simpleTodos = simpleTodos;
	}

	public ArrayList<Object> getSimpleFiles() {
		return simpleFiles;
	}

	public void setSimpleFiles(ArrayList<Object> simpleFiles) {
		this.simpleFiles = simpleFiles;
	}

	public Object getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Object unitCost) {
		this.unitCost = unitCost;
	}

	public Object getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Object totalCost) {
		this.totalCost = totalCost;
	}

	public Object getTotalItemsCost() {
		return totalItemsCost;
	}

	public void setTotalItemsCost(Object totalItemsCost) {
		this.totalItemsCost = totalItemsCost;
	}

	public int getRunCount() {
		return runCount;
	}

	public void setRunCount(int runCount) {
		this.runCount = runCount;
	}

	public int getInRunCount() {
		return inRunCount;
	}

	public void setInRunCount(int inRunCount) {
		this.inRunCount = inRunCount;
	}

	public int getActualHrs() {
		return actualHrs;
	}

	public void setActualHrs(int actualHrs) {
		this.actualHrs = actualHrs;
	}

	public int getPlannedHrs() {
		return plannedHrs;
	}

	public void setPlannedHrs(int plannedHrs) {
		this.plannedHrs = plannedHrs;
	}

	public int getActualQty() {
		return actualQty;
	}

	public void setActualQty(int actualQty) {
		this.actualQty = actualQty;
	}

	public Object getUnderDeliver() {
		return underDeliver;
	}

	public void setUnderDeliver(Object underDeliver) {
		this.underDeliver = underDeliver;
	}

	public String getIssueNote() {
		return issueNote;
	}

	public void setIssueNote(String issueNote) {
		this.issueNote = issueNote;
	}

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId;
	}

	public String getItemLevel() {
		return itemLevel;
	}

	public void setItemLevel(String itemLevel) {
		this.itemLevel = itemLevel;
	}

	public String getItemZone() {
		return itemZone;
	}

	public void setItemZone(String itemZone) {
		this.itemZone = itemZone;
	}

	public boolean isToConsume() {
		return toConsume;
	}

	public void setToConsume(boolean toConsume) {
		this.toConsume = toConsume;
	}

	public int getReturnedCount() {
		return returnedCount;
	}

	public void setReturnedCount(int returnedCount) {
		this.returnedCount = returnedCount;
	}

	public int getViewIndex() {
		return viewIndex;
	}

	public void setViewIndex(int viewIndex) {
		this.viewIndex = viewIndex;
	}

	public Object getCardId() {
		return cardId;
	}

	public void setCardId(Object cardId) {
		this.cardId = cardId;
	}

	public ArrayList<Object> getReturnHistory() {
		return returnHistory;
	}

	public void setReturnHistory(ArrayList<Object> returnHistory) {
		this.returnHistory = returnHistory;
	}

}
