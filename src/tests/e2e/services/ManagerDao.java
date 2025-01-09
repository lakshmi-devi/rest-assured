package tests.e2e.services;

import java.util.ArrayList;
import java.util.HashMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tests.e2e.helper.Helper;
import tests.e2e.module.Archived;
import tests.e2e.module.FTD;
import tests.e2e.module.Location;
import tests.e2e.module.FTD;
import tests.e2e.module.Manager;
import tests.e2e.module.Owner;
import tests.e2e.module.Runs;
import tests.e2e.module.Tag;

public class ManagerDao {

	public static Manager getManagerDao() throws Exception {
		try {
			Manager manage = new Manager();
			manage.setCompanies(new ArrayList<FTD>());
			manage.setLocation(LocationDao.getLocationForItemDao());

			manage.setArchived(ArchivedDao.getArchivedDAO(false));
			manage.setName("");
			manage.setNotes("");
			manage.setOwner(OwnerDao.getOwnerDAO());
			manage.setQaNotes("");
			manage.setRuns(new ArrayList<Runs>());
			manage.setTags(new ArrayList<Tag>());
			manage.setSimpleDates(new HashMap<String,Object>());
			manage.setSimpleFiles(new ArrayList<FTD>());
			manage.setSimpleMemos(new ArrayList<FTD>());
			manage.setSimpleTodos(new ArrayList<FTD>());

//        manage.setUuid("68e393c4-b180-419b-99e2-bf7f530f5bbf");
			manage.set_accessor(null);
			manage.set_place("manager");
			manage.setMemos(new ArrayList<FTD>());
			manage.setUuid(Helper.getUuid());

			return manage;
		} catch (Exception e) {
			throw new Exception("Error at getManagerDao" + e);
		}
	}
	
	public static Manager getManagerRuns() throws Exception {
		try {
			Manager manage = new Manager();
			manage.setRuns(RunsDao.getRunsDAO());
			manage.setSimpleDates(new HashMap<String,Object>());
			manage.setCompanies(new ArrayList<FTD>());
			manage.setLocation(LocationDao.getLocationForItemDao());
			manage.set_accessor(null);
			manage.setArchived(ArchivedDao.getArchivedDAO(false));
			manage.setName("");
			manage.setNotes("");
			manage.setOwner(OwnerDao.getOwnerDAO());
			manage.setQaNotes("");
		    manage.setSimpleFiles(new ArrayList<FTD>());
			manage.setSimpleMemos(new ArrayList<FTD>());
			manage.setSimpleTodos(new ArrayList<FTD>());
			manage.setTags(new ArrayList<Tag>());
	        manage.set_accessor(null);
			manage.set_place("manager");
			manage.setMemos(new ArrayList<FTD>());
			manage.setUuid(Helper.getUuid());

			return manage;
		} catch (Exception e) {
			throw new Exception("Exception during get MangerDao");
		}
		
	}
}
