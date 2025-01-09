package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Serials {
	private int returned;

	private int available;

	private int unavailable;

	public void setReturned(int returned) {
		this.returned = returned;
	}

	public int getReturned() {
		return this.returned;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getAvailable() {
		return this.available;
	}

	public void setUnavailable(int unavailable) {
		this.unavailable = unavailable;
	}

	public int getUnavailable() {
		return this.unavailable;
	}

}
