package tests.e2e.module;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class PasswordSetting {
	private FailLoginAttempt failLoginAttempt;
	private boolean isConfigured;
	private int passwordLength;
	private ArrayList<Object> pattern;
	private int expiryDays;

	public FailLoginAttempt getFailLoginAttempt() {
		return failLoginAttempt;
	}

	public void setFailLoginAttempt(FailLoginAttempt failLoginAttempt) {
		this.failLoginAttempt = failLoginAttempt;
	}

	public boolean isConfigured() {
		return isConfigured;
	}

	public void setConfigured(boolean isConfigured) {
		this.isConfigured = isConfigured;
	}

	public int getPasswordLength() {
		return passwordLength;
	}

	public void setPasswordLength(int passwordLength) {
		this.passwordLength = passwordLength;
	}

	public ArrayList<Object> getPattern() {
		return pattern;
	}

	public void setPattern(ArrayList<Object> pattern) {
		this.pattern = pattern;
	}

	public int getExpiryDays() {
		return expiryDays;
	}

	public void setExpiryDays(int expiryDays) {
		this.expiryDays = expiryDays;
	}

}
