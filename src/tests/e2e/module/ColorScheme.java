package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ColorScheme {
	private String _id;
	private String prefab;
	private String coordination;
	private String detailing;
	private String manufacturing;
	private String qa;
	private String delivery;
	private String inTransit;
	private String inStorage;
	private String complete;
	private String notStarted;
	private String fulfilled;
	private String mixColor;
	private String preparation;
	private String ordering;
	private String fieldverify;
	private String catalogue;
	private String zombie;
	private String releasedToInventory;
	private String consumed;
	private String sourcing;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPrefab() {
		return prefab;
	}

	public void setPrefab(String prefab) {
		this.prefab = prefab;
	}

	public String getCoordination() {
		return coordination;
	}

	public void setCoordination(String coordination) {
		this.coordination = coordination;
	}

	public String getDetailing() {
		return detailing;
	}

	public void setDetailing(String detailing) {
		this.detailing = detailing;
	}

	public String getManufacturing() {
		return manufacturing;
	}

	public void setManufacturing(String manufacturing) {
		this.manufacturing = manufacturing;
	}

	public String getQa() {
		return qa;
	}

	public void setQa(String qa) {
		this.qa = qa;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getInTransit() {
		return inTransit;
	}

	public void setInTransit(String inTransit) {
		this.inTransit = inTransit;
	}

	public String getInStorage() {
		return inStorage;
	}

	public void setInStorage(String inStorage) {
		this.inStorage = inStorage;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

	public String getNotStarted() {
		return notStarted;
	}

	public void setNotStarted(String notStarted) {
		this.notStarted = notStarted;
	}

	public String getFulfilled() {
		return fulfilled;
	}

	public void setFulfilled(String fulfilled) {
		this.fulfilled = fulfilled;
	}

	public String getMixColor() {
		return mixColor;
	}

	public void setMixColor(String mixColor) {
		this.mixColor = mixColor;
	}

	public String getPreparation() {
		return preparation;
	}

	public void setPreparation(String preparation) {
		this.preparation = preparation;
	}

	public String getOrdering() {
		return ordering;
	}

	public void setOrdering(String ordering) {
		this.ordering = ordering;
	}

	public String getFieldverify() {
		return fieldverify;
	}

	public void setFieldverify(String fieldverify) {
		this.fieldverify = fieldverify;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public String getZombie() {
		return zombie;
	}

	public void setZombie(String zombie) {
		this.zombie = zombie;
	}

	public String getReleasedToInventory() {
		return releasedToInventory;
	}

	public void setReleasedToInventory(String releasedToInventory) {
		this.releasedToInventory = releasedToInventory;
	}

	public String getConsumed() {
		return consumed;
	}

	public void setConsumed(String consumed) {
		this.consumed = consumed;
	}

	public String getSourcing() {
		return sourcing;
	}

	public void setSourcing(String sourcing) {
		this.sourcing = sourcing;
	}

}
