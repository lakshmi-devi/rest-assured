package tests.e2e.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;



@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Manager {

	    public Created created;
	    public LastModified modified;
	    public Owner owner;
	    public UniqueOrderId uniqueOrderId;
	    public ArrayList<Object> keywords;
	    public ArrayList<FTD> companies;
	    public boolean pTrackEnabled;
	    public boolean isManageRemainder;
	    public String _id;
	    public ArrayList<Tag> tags;
	    public ArrayList<Object> runItemLinkStatus;
	    public ArrayList<Runs> runs;
	    public ArrayList<Object> events;
	    public Location location;
	    public Stats stats;
	    public String notes;
	    public String id;
	    private Archived archived;
	    private String name;
	    private String qaNotes;
	    private Object simpleDates;
		private ArrayList<FTD> simpleFiles;
		private ArrayList<FTD> simpleMemos;
		private ArrayList<FTD> simpleTodos;
		private Object _accessor;
		private String _place;
		private ArrayList<FTD> memos;
		private String uuid;
	    
		public Archived getArchived() {
			return archived;
		}
		public void setArchived(Archived archived) {
			this.archived = archived;
		}
		public Created getCreated() {
			return created;
		}
		public void setCreated(Created created) {
			this.created = created;
		}
		public LastModified getModified() {
			return modified;
		}
		public void setModified(LastModified modified) {
			this.modified = modified;
		}
		public Owner getOwner() {
			return owner;
		}
		public void setOwner(Owner owner) {
			this.owner = owner;
		}
		public UniqueOrderId getUniqueOrderId() {
			return uniqueOrderId;
		}
		public void setUniqueOrderId(UniqueOrderId uniqueOrderId) {
			this.uniqueOrderId = uniqueOrderId;
		}
		public ArrayList<Object> getKeywords() {
			return keywords;
		}
		public void setKeywords(ArrayList<Object> keywords) {
			this.keywords = keywords;
		}
		public ArrayList<FTD> getCompanies() {
			return companies;
		}
		public void setCompanies(ArrayList<FTD> companies) {
			this.companies = companies;
		}
		public boolean ispTrackEnabled() {
			return pTrackEnabled;
		}
		public void setpTrackEnabled(boolean pTrackEnabled) {
			this.pTrackEnabled = pTrackEnabled;
		}
		public boolean isManageRemainder() {
			return isManageRemainder;
		}
		public void setManageRemainder(boolean isManageRemainder) {
			this.isManageRemainder = isManageRemainder;
		}
		public String get_id() {
			return _id;
		}
		public void set_id(String _id) {
			this._id = _id;
		}
		public ArrayList<Tag> getTags() {
			return tags;
		}
		public void setTags(ArrayList<Tag> tags) {
			this.tags = tags;
		}
		public ArrayList<Object> getRunItemLinkStatus() {
			return runItemLinkStatus;
		}
		public void setRunItemLinkStatus(ArrayList<Object> runItemLinkStatus) {
			this.runItemLinkStatus = runItemLinkStatus;
		}
		public ArrayList<Runs> getRuns() {
			return runs;
		}
		public void setRuns(ArrayList<Runs> runs) {
			this.runs = runs;
		}
		public ArrayList<Object> getEvents() {
			return events;
		}
		public void setEvents(ArrayList<Object> events) {
			this.events = events;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public Stats getStats() {
			return stats;
		}
		public void setStats(Stats stats) {
			this.stats = stats;
		}

		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getQaNotes() {
			return qaNotes;
		}
		public void setQaNotes(String qaNotes) {
			this.qaNotes = qaNotes;
		}
		
		
		public Object getSimpleDates() {
			return simpleDates;
		}
		public void setSimpleDates(Object simpleDates) {
			this.simpleDates = simpleDates;
		}
		public ArrayList<FTD> getSimpleFiles() {
			return simpleFiles;
		}
		public void setSimpleFiles(ArrayList<FTD> simpleFiles) {
			this.simpleFiles = simpleFiles;
		}
		public ArrayList<FTD> getSimpleMemos() {
			return simpleMemos;
		}
		public void setSimpleMemos(ArrayList<FTD> simpleMemos) {
			this.simpleMemos = simpleMemos;
		}
		public ArrayList<FTD> getSimpleTodos() {
			return simpleTodos;
		}
		public void setSimpleTodos(ArrayList<FTD> simpleTodos) {
			this.simpleTodos = simpleTodos;
		}
		public Object get_accessor() {
			return _accessor;
		}
		public void set_accessor(Object _accessor) {
			this._accessor = _accessor;
		}
		public String get_place() {
			return _place;
		}
		public void set_place(String _place) {
			this._place = _place;
		}
		public ArrayList<FTD> getMemos() {
			return memos;
		}
		public void setMemos(ArrayList<FTD> memos) {
			this.memos = memos;
		}
		public String getUuid() {
			return uuid;
		}
		public void setUuid(String uuid) {
			this.uuid = uuid;
		}
	    
		
	}

