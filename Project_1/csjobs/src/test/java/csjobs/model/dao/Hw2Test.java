package csjobs.model.dao;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import csjobs.model.Application;

@Test(groups = "Hw2Test")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Hw2Test extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    JobDao jobDao;
    
    @Autowired
    UserDao userDao;
    
    // There are a total of two job positions in the system
    @Test
    public void getPositions()
    {
        assert jobDao.getJobs().size() == 2;
    }
    
    // reviewer3 is on two committees
    @Test
    public void getReviewer3()
    {	
    	String email = "reviewer3@localhost.localdomain";
    	//assert  userDao.getUserByEmail(email)size() == 2;
    }
    
    // applicant1 applied for a job with the title "Tenure-Track Faculty Position (Start Fall 2015)"
    @Test
    public void isApplicant1AppliedForJob()
    {	
    	String email = "applicant1@localhost.localdomain";
    	String title = "Tenure-Track Faculty Position (Start Fall 2015)";
    	Set<Application> list = userDao.getUserByEmail(email).getApplications();
    	
    	for (Application app :list){
    		assert app.getJob().getTitle().equals(title);
    	}
    }
}