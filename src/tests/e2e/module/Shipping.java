package tests.e2e.module;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Shipping {

	public Archived archived;
	public LastModified lastModified;
	public boolean fromExcel;
	public boolean isInternal;
	public boolean fromSchedule;
	public ArrayList<Object> externalEmails;
	public String status;
	public boolean isUnderDeliver;
	public String shipType;
	public ArrayList<Object> contributedCards;
	public ArrayList<Object> childShipments;
	public Project project;
	public CreatedBy createdBy;
	public boolean projectToCsRelayed;
	public int toReturnSerialCount;
	public boolean wholeLabelReturned;
	public boolean allAllocated;
	public String purpose;
	public boolean forBOM;
	public int itemElementsCount;
	public String _id;
	public String name;
	public String kind;
	public ArrayList<Object> files;
	public String createdAt;
	public ArrayList<Object> deliveryHistory;
	public ArrayList<Items> items;
	public String itemKind;
	public int __v;
	public String id;
	public Object delivery;

	public Archived getArchived() {
		return archived;
	}

	public void setArchived(Archived archived) {
		this.archived = archived;
	}

	public LastModified getLastModified() {
		return lastModified;
	}

	public void setLastModified(LastModified lastModified) {
		this.lastModified = lastModified;
	}

	public boolean isFromExcel() {
		return fromExcel;
	}

	public void setFromExcel(boolean fromExcel) {
		this.fromExcel = fromExcel;
	}

	public boolean isInternal() {
		return isInternal;
	}

	public void setInternal(boolean isInternal) {
		this.isInternal = isInternal;
	}

	public boolean isFromSchedule() {
		return fromSchedule;
	}

	public void setFromSchedule(boolean fromSchedule) {
		this.fromSchedule = fromSchedule;
	}

	public ArrayList<Object> getExternalEmails() {
		return externalEmails;
	}

	public void setExternalEmails(ArrayList<Object> externalEmails) {
		this.externalEmails = externalEmails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isUnderDeliver() {
		return isUnderDeliver;
	}

	public void setUnderDeliver(boolean isUnderDeliver) {
		this.isUnderDeliver = isUnderDeliver;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public ArrayList<Object> getContributedCards() {
		return contributedCards;
	}

	public void setContributedCards(ArrayList<Object> contributedCards) {
		this.contributedCards = contributedCards;
	}

	public ArrayList<Object> getChildShipments() {
		return childShipments;
	}

	public void setChildShipments(ArrayList<Object> childShipments) {
		this.childShipments = childShipments;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public CreatedBy getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(CreatedBy createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isProjectToCsRelayed() {
		return projectToCsRelayed;
	}

	public void setProjectToCsRelayed(boolean projectToCsRelayed) {
		this.projectToCsRelayed = projectToCsRelayed;
	}

	public int getToReturnSerialCount() {
		return toReturnSerialCount;
	}

	public void setToReturnSerialCount(int toReturnSerialCount) {
		this.toReturnSerialCount = toReturnSerialCount;
	}

	public boolean isWholeLabelReturned() {
		return wholeLabelReturned;
	}

	public void setWholeLabelReturned(boolean wholeLabelReturned) {
		this.wholeLabelReturned = wholeLabelReturned;
	}

	public boolean isAllAllocated() {
		return allAllocated;
	}

	public void setAllAllocated(boolean allAllocated) {
		this.allAllocated = allAllocated;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public boolean isForBOM() {
		return forBOM;
	}

	public void setForBOM(boolean forBOM) {
		this.forBOM = forBOM;
	}

	public int getItemElementsCount() {
		return itemElementsCount;
	}

	public void setItemElementsCount(int itemElementsCount) {
		this.itemElementsCount = itemElementsCount;
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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public ArrayList<Object> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<Object> files) {
		this.files = files;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public ArrayList<Object> getDeliveryHistory() {
		return deliveryHistory;
	}

	public void setDeliveryHistory(ArrayList<Object> deliveryHistory) {
		this.deliveryHistory = deliveryHistory;
	}

	public ArrayList<Items> getItems() {
		return items;
	}

	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}

	public String getItemKind() {
		return itemKind;
	}

	public void setItemKind(String itemKind) {
		this.itemKind = itemKind;
	}

	public int get__v() {
		return __v;
	}

	public void set__v(int __v) {
		this.__v = __v;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getDelivery() {
		return delivery;
	}

	public void setDelivery(Object delivery) {
		this.delivery = delivery;
	}

}
