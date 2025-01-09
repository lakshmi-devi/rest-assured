package tests.e2e.services;

import java.util.ArrayList;
import java.util.HashMap;
import tests.e2e.module.Memos;
import tests.e2e.module.source;

public class MemosDao {

	public static Memos getMemosDao(String _id, String type, String stage) throws Exception {
		try {
			Memos memos = new Memos();
			memos.setArchived(ArchivedDao.getArchivedDAO(false));
			memos.setValue("");
			memos.setAssignedTo(new HashMap());
			memos.setDirty(true);
			memos.setNeedsToAttachId(false);

			ArrayList<source> sources = new ArrayList<source>();
			sources.add(sourceDao.getSourcesdDAO(_id, type, stage));
			memos.setSources(sources);
			return memos;
		} catch (Exception e) {
			throw new Exception("Error at getMemosDao" + e);
		}
	}
}
