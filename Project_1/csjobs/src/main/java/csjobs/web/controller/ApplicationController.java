package csjobs.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import csjobs.model.Application;
import csjobs.model.Degree;
import csjobs.model.Job;
import csjobs.model.User;
import csjobs.model.dao.ApplicationDao;
import csjobs.model.dao.JobDao;

@Controller
@SessionAttributes("application")
public class ApplicationController {
	
    @Autowired
    private JobDao jobDao;
	
    @Autowired
    private ApplicationDao applicationDao;
	
    @RequestMapping(value = "user/apply.html", method = RequestMethod.GET)
    public String apply( @RequestParam Long jobId, HttpSession session,
            ModelMap models )
    {  	   	   	
        Job job = jobDao.getJob( jobId );
        User applicant = (User) session.getAttribute( "authenticatedUser" );
        Application application = applicationDao.getApplication( job,
            applicant );
        
        if( application != null )
        {
            models.put( "errorCode", "error.application.submitted" );
            return "error";
        }

        if( application == null )
            application = new Application( job, applicant );
        
        models.put( "application", application );
        return "user/apply";
    }
    
    @RequestMapping(value = "user/apply.html", method = RequestMethod.POST)
    public String apply( @ModelAttribute Application application,
            SessionStatus sessionStatus )
    {	
    	//appValidator.validate(application, result);
    	//if(result.hasErrors()) return "user/apply";    	
    	
        application = applicationDao.saveApplication( application );
        sessionStatus.setComplete();
        return "redirect: upload.html?applicationId=" + application.getId();
    	
    }
    
    //return "redirect: addDegree.html?applicationId=" + application.getId();
    //return "redirect: upload.html?applicationId=" + application.getId();
    
    @RequestMapping(value = "user/addDegree.html", method = RequestMethod.GET)
        public String addDegree( @RequestParam Long applicationId, ModelMap models )
        {
            models.put( "application",
                applicationDao.getApplication( applicationId ) );
            models.put( "degree", new Degree() );
            return "user/addDegree";
        }
    
    @RequestMapping(value = "user/addDegree.html", method = RequestMethod.POST)
        public String addDegree( @ModelAttribute Application application,
            @ModelAttribute Degree degree, SessionStatus sessionStatus )
        {
            application.getDegree().add(degree);
            application = applicationDao.saveApplication( application );
            sessionStatus.setComplete();
            return "redirect: addDegree.html?applicationId=" + application.getId();
        }
}
