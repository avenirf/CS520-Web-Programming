package csjobs.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import csjobs.model.Job;
import csjobs.model.User;
import csjobs.model.dao.JobDao;
import csjobs.model.dao.UserDao;
import csjobs.web.validator.JobValidator;
import csjobs.web.validator.UserValidator;

@Controller
public class JobController {

    @Autowired
    private JobDao jobDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private JobValidator jobValidator;

    @RequestMapping({ "/index.html", "/job/list.html" })
    public String list( ModelMap models )
    {
        models.put( "openJobs", jobDao.getOpenJobs() );
        return "job/list";
    }

    @RequestMapping("/job/view.html")
    public String view( @RequestParam Long id, ModelMap models )
    {
        models.put( "job", jobDao.getJob( id ) );
        return "job/view";
    }
    
    @RequestMapping("/job/viewAll.html")
    public String viewAll( @RequestParam Long id, ModelMap models )
    {
        models.put( "job", jobDao.getJob( id ) );
        return "job/viewAll";
    }

    @RequestMapping(value = "/job/create.html", method = RequestMethod.GET)
    public String create( ModelMap models )
    {	
    	List<User> reviewers = userDao.getReviewers();
    	models.put( "reviewers", reviewers );
    	models.put( "job", new Job() );
        return "job/create";
    }

    @RequestMapping(value = "/job/create.html", method = RequestMethod.POST)
    public String create( @ModelAttribute Job job, BindingResult bindingResult, @RequestParam(required=false) Set<String> committeeMembers, 
    		@RequestParam Long committeeChair)
    {	
        //jobValidator.validate( job, bindingResult );
        //if( bindingResult.hasErrors() ) return "job/create";
    	
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
    	job.setCommitteeMembers(members);
        job = jobDao.saveJob( job );
    	return "redirect: /../../admin.html";
    }
    
    @RequestMapping(value = "/job/edit.html", method = RequestMethod.GET)
    public String edit( @RequestParam Long id, ModelMap models )
    {
        models.put( "job", jobDao.getJob(id) );
        return "job/edit";
    }

    @RequestMapping(value = "/job/edit.html", method = RequestMethod.POST)
    public String edit( @ModelAttribute Job job, BindingResult bindingResult,
        SessionStatus sessionStatus )
    {
        //jobValidator.validate( job, bindingResult );
        //if( bindingResult.hasErrors() ) return "job/edit";

        jobDao.saveJob(job);
        sessionStatus.setComplete();
        return "redirect: /../../admin.html";
    }
}
