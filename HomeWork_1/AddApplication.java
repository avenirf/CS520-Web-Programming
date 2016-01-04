package cs520_HW1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520_HW1.model.Applicant;
import cs520_HW1.model.Job;


@WebServlet("/AddApplication")
public class AddApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddApplication() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{		
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{			
		//job
		List<Job> jobs = (List<Job>) getServletContext().getAttribute( "jobs" );
		int jobIndex = Integer.valueOf( request.getParameter( "index" ) );
		Job jJob = null;
		for (Job job: jobs){
			if (jobIndex == job.getIndex()){
				jJob = job;
			}
		}
		
		String name = request.getParameter( "name" );
		if (jJob != null){
			List<Applicant> applicants = (List<Applicant>) getServletContext().getAttribute( "applicants" );
			for (Applicant applicant: applicants){
				if (applicant.getName().equals(name)){
					applicant.addJob(jJob);
				}
			}
		}
		
		response.sendRedirect( "ApplicantInf2?name="+name );
	}
}
