package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Qa {
	private boolean done;

	private boolean isRequired;

	private boolean orderCreator;

	private Object assignedTo;

	public void setDone(boolean done) {
		this.done = done;
	}

	public boolean getDone() {
		return this.done;
	}

	public void setIsRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

	public boolean getIsRequired() {
		return this.isRequired;
	}

	public void setOrderCreator(boolean orderCreator) {
		this.orderCreator = orderCreator;
	}

	public boolean getOrderCreator() {
		return this.orderCreator;
	}

	public Object getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Object assignedTo) {
		this.assignedTo = assignedTo;
	}

}
