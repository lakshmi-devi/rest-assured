package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Stats {
	private int actualHrs;
	private int plannedHrs;
	private int pf;
	private int percComplete;
	private int totalSteps;
	private int doneSteps;
	private int riCompleted;
	private int riTotal;
	private int runsPercComplete;
	private int stepsPerc;
	private int runsPerc;
	private int itemPerc;
	private int binaryPercComplete;

	public int getPf() {
		return pf;
	}

	public void setPf(int pf) {
		this.pf = pf;
	}

	public int getPercComplete() {
		return percComplete;
	}

	public void setPercComplete(int percComplete) {
		this.percComplete = percComplete;
	}

	public int getTotalSteps() {
		return totalSteps;
	}

	public void setTotalSteps(int totalSteps) {
		this.totalSteps = totalSteps;
	}

	public int getDoneSteps() {
		return doneSteps;
	}

	public void setDoneSteps(int doneSteps) {
		this.doneSteps = doneSteps;
	}

	public int getRiCompleted() {
		return riCompleted;
	}

	public void setRiCompleted(int riCompleted) {
		this.riCompleted = riCompleted;
	}

	public int getRiTotal() {
		return riTotal;
	}

	public void setRiTotal(int riTotal) {
		this.riTotal = riTotal;
	}

	public int getRunsPercComplete() {
		return runsPercComplete;
	}

	public void setRunsPercComplete(int runsPercComplete) {
		this.runsPercComplete = runsPercComplete;
	}

	public int getStepsPerc() {
		return stepsPerc;
	}

	public void setStepsPerc(int stepsPerc) {
		this.stepsPerc = stepsPerc;
	}

	public int getRunsPerc() {
		return runsPerc;
	}

	public void setRunsPerc(int runsPerc) {
		this.runsPerc = runsPerc;
	}

	public int getItemPerc() {
		return itemPerc;
	}

	public void setItemPerc(int itemPerc) {
		this.itemPerc = itemPerc;
	}

	public int getBinaryPercComplete() {
		return binaryPercComplete;
	}

	public void setBinaryPercComplete(int binaryPercComplete) {
		this.binaryPercComplete = binaryPercComplete;
	}

	public void setActualHrs(int actualHrs) {
		this.actualHrs = actualHrs;
	}

	public int getActualHrs() {
		return this.actualHrs;
	}

	public void setPlannedHrs(int plannedHrs) {
		this.plannedHrs = plannedHrs;
	}

	public int getPlannedHrs() {
		return this.plannedHrs;
	}
}