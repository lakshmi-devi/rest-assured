package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ExcludeFields {
	@JsonPropertyDescription("manager.runs")
	private int managerRuns;

	public int getManagerRuns() {
		return managerRuns;
	}

	public void setManagerRuns(int managerRuns) {
		this.managerRuns = managerRuns;
	}


}
