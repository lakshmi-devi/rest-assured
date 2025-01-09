package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreatedVia {

	String createdVia;

	public void setCreatedVia(String createdVia) {
		this.createdVia = createdVia;
	}

	public String getCreatedVia(String createdVia) {
		return this.createdVia;
	}

}
