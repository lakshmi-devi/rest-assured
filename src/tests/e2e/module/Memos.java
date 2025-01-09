package tests.e2e.module;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.transform.Source;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Memos {
	private String value;
	private ArrayList<source> sources;
	private boolean needsToAttachId;
	private Archived archived;
	// private AssignedTo assignedTo;
	private Object assignedTo;
	private boolean isDirty;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	


	public ArrayList<source> getSources() {
		return sources;
	}

	public void setSources(ArrayList<source> sources) {
		this.sources = sources;
	}

	public boolean isNeedsToAttachId() {
		return needsToAttachId;
	}

	public void setNeedsToAttachId(boolean needsToAttachId) {
		this.needsToAttachId = needsToAttachId;
	}

	public Archived getArchived() {
		return archived;
	}

	public void setArchived(Archived archived) {
		this.archived = archived;
	}

	public Object getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Object assignedTo) {
		this.assignedTo = assignedTo;
	}

	public boolean isDirty() {
		return isDirty;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}

}
