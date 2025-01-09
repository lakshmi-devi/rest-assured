package tests.e2e.module;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Runs {
	private Object simpleDates;
	private boolean orderCreator;
	private String _id;
	private String id;
	private Archived archived;
	private List<RunItemsCount> runItemsCount;
	private Stats stats;
	private boolean completed;
	private Quantity quantity;
	private double plannedHrs;
	private int actualHrs;
	private int percComplete;
	private Object pf;
	private boolean riCompleted;
	private String status;
	@JsonProperty("ReturnHistory")
	private ArrayList<Object> returnHistory;
	private LastModified modified;
	private String _place;
	private String _accessor;
	private String name;
	private String uuid;
	private ArrayList<Object> simpleTodos;
	private ArrayList<Object> simpleFiles;
	private Created created;
	private Owner owner;
	private int hours;
	private int viewIndex;
	private Location location;
	private String copiedFromId;
	private Object completedAt;
	private boolean isTracked;
	private ArrayList<Object> simpleMemos;
	private boolean isEditing;
	private boolean dirty;
	private boolean markCompleteDisabled;
	private String instanceOf;
	public Object getSimpleDates() {
		return simpleDates;
	}
	public void setSimpleDates(Object simpleDates) {
		this.simpleDates = simpleDates;
	}
	public boolean isOrderCreator() {
		return orderCreator;
	}
	public void setOrderCreator(boolean orderCreator) {
		this.orderCreator = orderCreator;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Archived getArchived() {
		return archived;
	}
	public void setArchived(Archived archived) {
		this.archived = archived;
	}
	public List<RunItemsCount> getRunItemsCount() {
		return runItemsCount;
	}
	public void setRunItemsCount(List<RunItemsCount> runItemsCount) {
		this.runItemsCount = runItemsCount;
	}
	public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Quantity getQuantity() {
		return quantity;
	}
	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}
	public double getPlannedHrs() {
		return plannedHrs;
	}
	public void setPlannedHrs(double plannedHrs) {
		this.plannedHrs = plannedHrs;
	}
	public int getActualHrs() {
		return actualHrs;
	}
	public void setActualHrs(int actualHrs) {
		this.actualHrs = actualHrs;
	}
	public int getPercComplete() {
		return percComplete;
	}
	public void setPercComplete(int percComplete) {
		this.percComplete = percComplete;
	}
	public Object getPf() {
		return pf;
	}
	public void setPf(Object pf) {
		this.pf = pf;
	}
	public boolean isRiCompleted() {
		return riCompleted;
	}
	public void setRiCompleted(boolean riCompleted) {
		this.riCompleted = riCompleted;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ArrayList<Object> getReturnHistory() {
		return returnHistory;
	}
	public void setReturnHistory(ArrayList<Object> returnHistory) {
		this.returnHistory = returnHistory;
	}
	public LastModified getModified() {
		return modified;
	}
	public void setModified(LastModified modified) {
		this.modified = modified;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	public Created getCreated() {
		return created;
	}
	public void setCreated(Created created) {
		this.created = created;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getViewIndex() {
		return viewIndex;
	}
	public void setViewIndex(int viewIndex) {
		this.viewIndex = viewIndex;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getCopiedFromId() {
		return copiedFromId;
	}
	public void setCopiedFromId(String copiedFromId) {
		this.copiedFromId = copiedFromId;
	}
	public Object getCompletedAt() {
		return completedAt;
	}
	public void setCompletedAt(Object completedAt) {
		this.completedAt = completedAt;
	}
	public boolean isTracked() {
		return isTracked;
	}
	public void setTracked(boolean isTracked) {
		this.isTracked = isTracked;
	}
	public ArrayList<Object> getSimpleMemos() {
		return simpleMemos;
	}
	public void setSimpleMemos(ArrayList<Object> simpleMemos) {
		this.simpleMemos = simpleMemos;
	}
	public boolean isEditing() {
		return isEditing;
	}
	public void setEditing(boolean isEditing) {
		this.isEditing = isEditing;
	}
	public boolean isDirty() {
		return dirty;
	}
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}
	public boolean isMarkCompleteDisabled() {
		return markCompleteDisabled;
	}
	public void setMarkCompleteDisabled(boolean markCompleteDisabled) {
		this.markCompleteDisabled = markCompleteDisabled;
	}
	public String getInstanceOf() {
		return instanceOf;
	}
	public void setInstanceOf(String instanceOf) {
		this.instanceOf = instanceOf;
	}

}
