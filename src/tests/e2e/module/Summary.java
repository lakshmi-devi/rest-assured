package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Summary {
	private int inTransit;

	private int inStorage;

	private int inventory;

	public void setInTransit(int inTransit) {
		this.inTransit = inTransit;
	}

	public int getInTransit() {
		return this.inTransit;
	}

	public void setInStorage(int inStorage) {
		this.inStorage = inStorage;
	}

	public int getInStorage() {
		return this.inStorage;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getInventory() {
		return this.inventory;
	}

}
