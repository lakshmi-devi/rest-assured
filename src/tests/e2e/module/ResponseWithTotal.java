package tests.e2e.module;

import java.util.ArrayList;


public class ResponseWithTotal {


	private ArrayList<Baseorder> orders;
	private ArrayList<Object> badData;
	private String total;

	public ArrayList<Baseorder> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Baseorder> orders) {
		this.orders = orders;
	}

	public ArrayList<Object> getBadData() {
		return badData;
	}

	public void setBadData(ArrayList<Object> badData) {
		this.badData = badData;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	 
}
