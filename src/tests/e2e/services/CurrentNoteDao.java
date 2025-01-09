package tests.e2e.services;

import tests.e2e.module.Added;
import tests.e2e.module.CurrentNote;

public class CurrentNoteDao {

	public static CurrentNote getCurrentNotesObject(String text) throws Exception {
		try {
			Added added = new Added();
			CurrentNote currentNotes = new CurrentNote();
			currentNotes.setText(text);
			currentNotes.setAdded(added);

			return currentNotes;
		} catch (Exception e) {
			throw new Exception("Error at getCurrentNotesObject" + e);
		}
	}
}
