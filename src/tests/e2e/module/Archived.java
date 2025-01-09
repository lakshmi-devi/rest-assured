package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Archived {
	private boolean value;

	private String at;

	public void setValue(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

	public void setAt(String at) {
		this.at = at;
	}

	public String getAt() {
		return this.at;
	}
}
