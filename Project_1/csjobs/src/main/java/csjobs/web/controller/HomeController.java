package csjobs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import csjobs.model.User;
import csjobs.model.dao.JobDao;
import csjobs.model.dao.UserDao;
import csjobs.web.validator.UserValidator;


@Controller
public class HomeController {
	
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private JobDao jobDao;
    
    @Autowired
    private UserValidator userValidator;
	
    @RequestMapping("/index.html")
    public String index( ModelMap models )
    {
        models.put( "openJobs", jobDao.getOpenJobs() );
        return "index";
    }
	
	@RequestMapping("/jobDescription.html")
    public String jobDescription( @RequestParam Long id, ModelMap models )
    {
		models.put( "job", jobDao.getJob(id) );
		return "jobDescription";
    }
	
	@RequestMapping("/jobDescription/{id}.html")
    public String jobDescriptionId( @PathVariable Long id, ModelMap models )
    {
		return jobDescription( id, models );
    }

    @RequestMapping(value = "addUser.html", method = RequestMethod.GET)
    public String addUser( ModelMap models )
    {
        models.put( "user", new User() );
        return "addUser";
    }
    
    @RequestMapping(value = "addUser.html", method = RequestMethod.POST)
    public String addUser( @ModelAttribute User user, BindingResult result )
    {	
    	userValidator.validate(user, result);
    	if(result.hasErrors()) return "addUser";
    	
    	user = userDao.saveUser(user);
    	
        return "redirect: index.html";
    }
}