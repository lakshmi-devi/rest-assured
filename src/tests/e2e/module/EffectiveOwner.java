package tests.e2e.module;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import tests.e2e.services.CompanyDao;
import tests.e2e.services.UserDao;
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class EffectiveOwner {
	private User user;

	private Company company;

    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
    public void setCompany(Company company){
        this.company = company;
    }
    public Company getCompany(){
        return this.company;
    }
    

    public static EffectiveOwner getEffectiveOwnerDAO() throws Exception {

    	EffectiveOwner effectiveOwner = new EffectiveOwner();
    	effectiveOwner.setCompany(CompanyDao.getCompanyDAO());

    	effectiveOwner.setUser(UserDao.getUserDAO());
		return effectiveOwner;
    	
    }

}