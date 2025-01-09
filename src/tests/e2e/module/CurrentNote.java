package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class CurrentNote {
	private Added added;
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setAdded(Added added){
        this.added = added;
    }
    public Added getAdded(){
        return this.added;
    }
    public static CurrentNote getCurrentNotesObject(String text) throws Exception {
    	Added added = new Added();
    	CurrentNote currentNotes = new CurrentNote();
    	currentNotes.setText(text);
    	currentNotes.setAdded(added);
    	
    	return currentNotes;
    }
}
