package csjobs.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import csjobs.model.Application;
import csjobs.model.FileS;
import csjobs.model.User;
import csjobs.model.dao.ApplicationDao;
import csjobs.model.dao.FileDao;

@Controller
@SessionAttributes("application")
public class FileController {
	
    @Autowired
    private ServletContext context;
    
    @Autowired
    private ApplicationDao applicationDao;
    
    @Autowired
    private FileDao fileDao;
    
    private File getFileDirectory(){
    	String path = context.getRealPath("/WEB-INF/files");
    	return new File(path);
    }
    
    @RequestMapping(value = "user/upload.html", method = RequestMethod.GET)
    public String upload( @RequestParam Long applicationId, ModelMap models )
    {  	
    	models.put( "application",
                applicationDao.getApplication( applicationId ) );
        return "user/upload";
    }
    
	@RequestMapping(value = "user/upload.html", method = RequestMethod.POST)
	public String upload( @RequestParam(required=false) MultipartFile c_v, @RequestParam(required=false) MultipartFile research_s,
			@RequestParam(required=false) MultipartFile teaching_s, @RequestParam Long applicationId, HttpSession session, 
			SessionStatus sessionStatus ) 
			throws IllegalStateException, IOException
	{
		Application application = applicationDao.getApplication(applicationId);
	    User applicant = (User) session.getAttribute( "authenticatedUser" );
	    
	    FileS cv = new FileS(); 
	    cv.setDate(new Date());
	    cv.setOwner(applicant);
	    cv.setName(c_v.getOriginalFilename());
	    cv.setSize(c_v.getSize());
	    cv.setType(c_v.getContentType());
	    cv = fileDao.saveFile(cv);
	    application.setC_v(cv);
	    
	    FileS teachingS = new FileS();
	    teachingS.setDate(new Date());
	    teachingS.setOwner(applicant);
	    teachingS.setName(teaching_s.getOriginalFilename());
	    teachingS.setSize(teaching_s.getSize());
	    teachingS.setType(teaching_s.getContentType());
	    teachingS = fileDao.saveFile(teachingS);
	    application.setTeaching_s(teachingS);

	    FileS researchS = new FileS();
	    researchS.setDate(new Date());
	    researchS.setOwner(applicant);
	    researchS.setName(research_s.getOriginalFilename());
	    researchS.setSize(research_s.getSize());
	    researchS.setType(research_s.getContentType());
	    researchS = fileDao.saveFile(researchS);
	    application.setResearch_s(researchS);
	    
	    application = applicationDao.saveApplication(application);
	    
		//save this file under /WEB-INF/files
		c_v.transferTo( new File( getFileDirectory(), cv.getId().toString()+cv.getName() ) );
		research_s.transferTo( new File( getFileDirectory(), researchS.getId().toString()+researchS.getName() ) );
		teaching_s.transferTo( new File( getFileDirectory(), teachingS.getId().toString()+teachingS.getName() ) );
		
		sessionStatus.setComplete();
		return "redirect: addDegree.html?applicationId=" + application.getId();
	}
	
	@RequestMapping("user/download.html")
	public String download( HttpServletResponse response, @RequestParam Long fileId ) throws IOException
	{	
		FileS file = fileDao.getFile(fileId);
		
		response.setContentType( file.getType().toString() );
		response.setHeader("Content-Disposition", "inline");
		
		// read in the file
		FileInputStream in = new FileInputStream( new File(getFileDirectory(), file.getId().toString()+file.getName()) );
		OutputStream out = response.getOutputStream();
		// write it to response
		
		byte buffer[] = new byte[2048];
		int bytesRead;
		while( (bytesRead = in.read(buffer)) > 0)
			out.write(buffer, 0, bytesRead);
		
		in.close();
		
		return null;
	}
}
