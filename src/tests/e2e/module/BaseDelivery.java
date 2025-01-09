package tests.e2e.module;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class BaseDelivery {
	private Location location;

	private Vendor vendor;

	private NameIdPair recipient;

	public void setLocation(Location arrayList) {
		this.location = arrayList;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Vendor getVendor() {
		return this.vendor;
	}

	public void setRecipient(NameIdPair recipient) {
		this.recipient = recipient;
	}

	public NameIdPair getRecipient() {
		return this.recipient;
	}

}