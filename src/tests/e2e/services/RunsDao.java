package tests.e2e.services;

import java.util.ArrayList;
import java.util.HashMap;

import tests.e2e.dataStore.DataStore;
import tests.e2e.helper.Helper;
import tests.e2e.module.Company;
import tests.e2e.module.Runs;
import tests.e2e.staticKeys.Statickeys;

public class RunsDao {

	public static ArrayList<Runs> getRunsDAO() throws Exception{
		try {
			ArrayList<Runs> runs = new ArrayList<>();
			
			Runs run = new Runs();
			run.setArchived(ArchivedDao.getArchivedDAO(false));
			run.setCompleted(false);
			
			Company company = (Company) Helper.getDatastore(Statickeys.company);
			run.setCopiedFromId(company.getCompanyRuns().get(0).get_id());
			
			run.setTracked(false);
			run.setLocation(LocationDao.getProjectLocationDAO());
			run.setName(company.getCompanyRuns().get(0).getName());
			run.setOrderCreator(true);
			run.setOwner(OwnerDao.getOwnerDAO());
			run.setRunItemsCount(new ArrayList<>());
			run.setSimpleDates(new HashMap<>());
			run.setSimpleFiles(new ArrayList<>());
			run.setSimpleTodos(new ArrayList<>());
			run.setUuid(Helper.getUuid());
			run.set_accessor("manager.runs");
			run.set_place("run");
			runs.add(run);
			
			return runs;
		} catch (Exception e) {
			throw new Exception("Exception while get RUN DAO");
		}


	}
}
