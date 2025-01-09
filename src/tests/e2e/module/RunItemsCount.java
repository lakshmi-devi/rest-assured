package tests.e2e.module;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class RunItemsCount {
	private Quantity quantity;

	private double plannedHrs;

	private int actualHrs;

	private int percComplete;

	private String pf;

	private boolean riCompleted;

	private String status;

	private String _id;

	private String _runName;

	private List<String> ReturnHistory;

	public String get_runName() {
		return _runName;
	}

	public void set_runName(String _runName) {
		this._runName = _runName;
	}

	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	public Quantity getQuantity() {
		return this.quantity;
	}

	public void setPlannedHrs(double plannedHrs) {
		this.plannedHrs = plannedHrs;
	}

	public double getPlannedHrs() {
		return this.plannedHrs;
	}

	public void setActualHrs(int actualHrs) {
		this.actualHrs = actualHrs;
	}

	public int getActualHrs() {
		return this.actualHrs;
	}

	public void setPercComplete(int percComplete) {
		this.percComplete = percComplete;
	}

	public int getPercComplete() {
		return this.percComplete;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getPf() {
		return this.pf;
	}

	public void setRiCompleted(boolean riCompleted) {
		this.riCompleted = riCompleted;
	}

	public boolean getRiCompleted() {
		return this.riCompleted;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String get_id() {
		return this._id;
	}

	public void setReturnHistory(List<String> ReturnHistory) {
		this.ReturnHistory = ReturnHistory;
	}

	public List<String> getReturnHistory() {
		return this.ReturnHistory;
	}
}