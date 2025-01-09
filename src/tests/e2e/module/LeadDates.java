package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class LeadDates {

	private int available;
	private int coordination;
	private int detailing;
	private int fab;
	private int manufacturing;
	private int partsManufacturing;
	private int qa;
	private int ship;

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getCoordination() {
		return coordination;
	}

	public void setCoordination(int coordination) {
		this.coordination = coordination;
	}

	public int getDetailing() {
		return detailing;
	}

	public void setDetailing(int detailing) {
		this.detailing = detailing;
	}

	public int getFab() {
		return fab;
	}

	public void setFab(int fab) {
		this.fab = fab;
	}

	public int getManufacturing() {
		return manufacturing;
	}

	public void setManufacturing(int manufacturing) {
		this.manufacturing = manufacturing;
	}

	public int getPartsManufacturing() {
		return partsManufacturing;
	}

	public void setPartsManufacturing(int partsManufacturing) {
		this.partsManufacturing = partsManufacturing;
	}

	public int getQa() {
		return qa;
	}

	public void setQa(int qa) {
		this.qa = qa;
	}

	public int getShip() {
		return ship;
	}

	public void setShip(int ship) {
		this.ship = ship;
	}

}
