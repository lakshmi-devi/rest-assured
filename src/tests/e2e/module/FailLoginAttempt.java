package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class FailLoginAttempt {
	private boolean isConfigured;
	private int lockedPeriod;

	public boolean isConfigured() {
		return isConfigured;
	}

	public void setConfigured(boolean isConfigured) {
		this.isConfigured = isConfigured;
	}

	public int getLockedPeriod() {
		return lockedPeriod;
	}

	public void setLockedPeriod(int lockedPeriod) {
		this.lockedPeriod = lockedPeriod;
	}

}
