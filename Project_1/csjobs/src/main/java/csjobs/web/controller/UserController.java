package csjobs.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import csjobs.model.Application;
import csjobs.model.Job;
import csjobs.model.User;
import csjobs.model.dao.ApplicationDao;
import csjobs.model.dao.JobDao;
import csjobs.model.dao.UserDao;
import csjobs.web.validator.ApplicationValidator;
import csjobs.web.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private JobDao jobDao;
    
    @Autowired
    private ApplicationDao applicationDao;
    
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private ApplicationValidator appValidator;
    
    private static final Logger logger = LoggerFactory
            .getLogger( UserController.class );
    
    @RequestMapping("/user/home.html")
    public String userHome( HttpSession session, ModelMap models )
    {	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        
    	User user = userDao.getUserByEmail(name);
    	
    	session.setAttribute( "authenticatedUser", user );
    	
    	List<Job> jobs = new ArrayList<Job>();
    	List<Job> list = jobDao.getJobs();
    	Set<Application> applications = user.getApplications();
    	for (Job element:list){
    		if (!element.isClosed() && element.isPublished()){
    			for (Application app:applications){
    				if(app.getJob().getId() == element.getId()){
    					element.setCheck(true);
    				}
    			}
				jobs.add(element);
    		}
    	}
    	
    	models.put( "jobs", jobs );
    	//models.put( "positions", user.getPositions());
    	models.put( "applications", applications);
    	models.put( "user", user );
    	
        return "/user/home";
    }
       
    @RequestMapping("reviewer/home.html")
    public String reviewerHome( HttpSession session, ModelMap models )
    {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        
    	User user = userDao.getUserByEmail(name);
    	
    	session.setAttribute( "authenticatedUser", user );
    	
    	return "reviewer/home";
    }
    
    @RequestMapping("user/viewApp.html")
    public String viewApp( @ModelAttribute User user, @RequestParam Long id, ModelMap models )
    {	 	
    	Application application = applicationDao.getApplication(id);
    	
    	models.put( "app", application );
    	models.put( "user", user);
    	
        return "user/viewApp";
    }
    
    @RequestMapping("user/info.html")
    public String info( @RequestParam Long id, ModelMap models )
    {	
    	User user = userDao.getUser(id);
    	
    	models.put( "user", user );
    	
        return "user/info";
    }
    
	@RequestMapping("/user/info/{id}.html")
    public String infoId( @PathVariable Long id, ModelMap models )
    {
		return info( id, models );
    }
	
    @RequestMapping("user/login.html")
    public String login(  )
    {	 	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
    	
        User user = userDao.getUserByEmail(name);
        
        if(user.isAdmin()){
    		return "redirect: ../../../admin/home.html";
    	} else if (user.isReviewer()){
    		return "redirect: ../../../reviewer/home.html";
    	} else return "redirect: ../../../user/home.html";
    }
}