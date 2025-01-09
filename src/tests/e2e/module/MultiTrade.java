package tests.e2e.module;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class MultiTrade {
	private boolean value;

	private List<FTD> companies;

	public void setValue(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

	public void setCompanies(ArrayList<FTD> arrayList) {
		this.companies = arrayList;
	}

	public List<FTD> getCompanies() {
		return this.companies;
	}

}