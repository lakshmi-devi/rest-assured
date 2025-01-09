package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class UniqueOrderId {
	private String _id;
	private String value;
	private boolean isSystemGenerated;

	public boolean isSystemGenerated() {
		return isSystemGenerated;
	}

	public void setSystemGenerated(boolean isSystemGenerated) {
		this.isSystemGenerated = isSystemGenerated;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}
