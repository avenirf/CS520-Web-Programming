package csjobs.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import csjobs.model.Job;
import csjobs.model.User;
import csjobs.model.dao.JobDao;
import csjobs.model.dao.UserDao;
import csjobs.web.validator.UserValidator;

@Controller
public class AdminController {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private JobDao jobDao;
    
    @Autowired
    private UserValidator userValidator;

    private static final Logger logger = LoggerFactory
        .getLogger( UserController.class );
    
    @RequestMapping("/admin.html")
    public String admin( HttpSession session, ModelMap models )
    {	
    	User authenticatedUser = (User) session
                .getAttribute( "authenticatedUser" );
    	User user = userDao.getUser( authenticatedUser.getId() );
    	
    	List<Job> jobs = jobDao.getJobsByDate();
    	models.put( "user", user );
        models.put( "jobs", jobs );
    	 
        return "admin";
    }
}
