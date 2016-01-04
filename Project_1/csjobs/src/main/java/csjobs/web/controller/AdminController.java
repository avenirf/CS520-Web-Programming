package csjobs.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;

import csjobs.model.Application;
import csjobs.model.Job;
import csjobs.model.User;
import csjobs.model.dao.ApplicationDao;
import csjobs.model.dao.JobDao;
import csjobs.model.dao.UserDao;
import csjobs.web.editor.UserPropertyEditor;
import csjobs.web.validator.JobValidator;
import csjobs.web.validator.UserValidator;

@Controller
@SessionAttributes("user")
public class AdminController {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ApplicationDao applicationDao;
    
    @Autowired
    private JobDao jobDao;
    
    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private JobValidator jobValidator;

    @Autowired
    private WebApplicationContext context;

    @InitBinder
    public void initBinder( WebDataBinder binder )
    {
        binder.registerCustomEditor( User.class,
            (UserPropertyEditor) context.getBean( "userPropertyEditor" ) );
        binder.registerCustomEditor( Date.class,
            new CustomDateEditor( new SimpleDateFormat( "M/d/yyyy" ), true ) );
    }
    
    private static final Logger logger = LoggerFactory
        .getLogger( UserController.class );
    
    @RequestMapping("/admin/home.html")
    public String admin( HttpSession session, ModelMap models )
    {	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        
    	User user = userDao.getUserByEmail(name);
    	
    	session.setAttribute( "authenticatedUser", user );
    	
    	List<Job> jobs = jobDao.getJobsByDate();
    	models.put( "user", user );
        models.put( "jobs", jobs );
    	 
        return "admin/home";
    }
    
    @RequestMapping("/admin/viewAll.html")
    public String viewAll( @RequestParam Long id, ModelMap models )
    {
    	Job job = jobDao.getJob( id );
    	List<Application> applications = applicationDao.getApplicationByJob(job);
        models.put( "job", job );
        models.put( "applications", applications );
        return "admin/viewAll";
    }
    
    @RequestMapping(value = "/admin/create.html", method = RequestMethod.GET)
    public String create( ModelMap models )
    {	
    	List<User> reviewers = userDao.getReviewers();
    	models.put( "reviewers", reviewers );
    	models.put( "job", new Job() );
        return "admin/create";
    }

    @RequestMapping(value = "/admin/create.html", method = RequestMethod.POST)
    public String create( @ModelAttribute Job job, BindingResult bindingResult, @RequestParam(required=false) Set<String> committeeMembers, 
    		@RequestParam Long committeeChair, SessionStatus sessionStatus)
    {	
        //jobValidator.validate( job, bindingResult );
        //if( bindingResult.hasErrors() ) return "admin/create";
    	
    	Boolean addChear = true;
    	User chear = userDao.getUser(committeeChair);
    	List<User> members = new ArrayList<User>();
    	
	    for (String member: committeeMembers){
	    	Long id = Long.valueOf(member).longValue();;
	    	User user = userDao.getUser(id);
	    	if (user.equals(chear)){
	    		addChear = false;
	    	}
	    	members.add(user);
	    }
	    	
	    if (addChear){
	    	members.add(chear);
	    }
	    	
	    job.setCommitteeChair(chear);
	    job.setReviewers(members);;
	    job = jobDao.saveJob( job );
	    sessionStatus.setComplete();
	    return "redirect: home.html";
    }
    
    @RequestMapping(value = "/admin/edit.html", method = RequestMethod.GET)
    public String edit( @RequestParam Long id, ModelMap models )
    {	
    	List<User> reviewers = userDao.getReviewers();
    	models.put( "reviewers", reviewers );
        models.put( "job", jobDao.getJob(id) );
        return "admin/edit";
    }

    @RequestMapping(value = "/admin/edit.html", method = RequestMethod.POST)
    public String edit( @ModelAttribute Job job, BindingResult bindingResult, @RequestParam(required=false) Set<String> committeeMembers, 
    		@RequestParam Long committeeChair, SessionStatus sessionStatus )
    {
        //jobValidator.validate( job, bindingResult );
        //if( bindingResult.hasErrors() ) return "job/edit";
    	
    	
        jobDao.saveJob(job);
        sessionStatus.setComplete();
        return "redirect: home.html";
    }
}
