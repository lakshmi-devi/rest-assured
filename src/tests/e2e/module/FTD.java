package tests.e2e.module;

import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FTD {
	private Archived archived;
	private Object assignedTo;
	private Boolean isDirty;
	private String kind;
	private Boolean needsToAttachId;
	private List<source> sources;
	private String stage;
	private String value;
	private Created created;

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

	public Boolean getIsDirty() {
		return isDirty;
	}

	public void setIsDirty(Boolean isDirty) {
		this.isDirty = isDirty;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Boolean getNeedsToAttachId() {
		return needsToAttachId;
	}

	public void setNeedsToAttachId(Boolean needsToAttachId) {
		this.needsToAttachId = needsToAttachId;
	}

	public List<source> getSources() {
		return sources;
	}

	public void setSources(List<source> sources) {
		this.sources = sources;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Created getCreated() {
		return created;
	}

	public void setCreated(Created created) {
		this.created = created;
	}

}
