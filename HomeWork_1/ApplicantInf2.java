package cs520_HW1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520_HW1.model.Applicant;
import cs520_HW1.model.Job;
import cs520_HW1.model.appJobs;

@WebServlet("/ApplicantInf2")
public class ApplicantInf2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplicantInf2() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{	
		//applicant 
		//appJobs appJobs = new appJobs();
		List<Job> jobs = (List<Job>) getServletContext().getAttribute( "jobs" );
		String name = String.valueOf( request.getParameter( "name" ) );
		List<Applicant> applicants = (List<Applicant>) getServletContext().getAttribute( "applicants" );
		for (Applicant applicant: applicants){
			if (name.equals(applicant.getName())){
				request.setAttribute( "applicant", applicant );
				List<appJobs> list = new ArrayList<appJobs>();
				for (Job job: jobs){
					appJobs a = new appJobs();
					a.setJob(job);
					for (Job job2: applicant.getJob()){
						if(job2.getIndex() == job.getIndex()){
							a.setLink(true);
						}
					}
					list.add(a);
				}
				request.setAttribute( "list", list );
			}
		}
		
		
		
        request.getRequestDispatcher( "/ApplicantInf2.jsp" ).forward(
                request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
