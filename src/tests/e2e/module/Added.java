package tests.e2e.module;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import tests.e2e.helper.Helper;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Added
{
    private String at;

    public Added() throws Exception{
    	this.at = Helper.getUtcTimeZone();
    }
    
	public String getAt() {
		return at;
	}

	public void setAt(String at) {
		this.at = at;
	}

}
