package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Quantity {
	private int total;

	private int thisRun;

	private int haveShippingLabel;

	private int shipped;

	private int returned;

	private int inReturn;

	private int completed;

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal() {
		return this.total;
	}

	public void setThisRun(int thisRun) {
		this.thisRun = thisRun;
	}

	public int getThisRun() {
		return this.thisRun;
	}

	public void setHaveShippingLabel(int haveShippingLabel) {
		this.haveShippingLabel = haveShippingLabel;
	}

	public int getHaveShippingLabel() {
		return this.haveShippingLabel;
	}

	public void setShipped(int shipped) {
		this.shipped = shipped;
	}

	public int getShipped() {
		return this.shipped;
	}

	public void setReturned(int returned) {
		this.returned = returned;
	}

	public int getReturned() {
		return this.returned;
	}

	public void setInReturn(int inReturn) {
		this.inReturn = inReturn;
	}

	public int getInReturn() {
		return this.inReturn;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public int getCompleted() {
		return this.completed;
	}
}