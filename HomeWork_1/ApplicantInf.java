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

@WebServlet("/ApplicantInf")
public class ApplicantInf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplicantInf() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// 		
		String name = String.valueOf( request.getParameter( "name" ) );
		List<Applicant> applicants = (List<Applicant>) getServletContext().getAttribute( "applicants" );
		for (Applicant applicant: applicants){
			if (name.equals(applicant.getName())){
				request.setAttribute( "applicant", applicant );
			}
		}
		
		// 		
		Integer index = Integer.valueOf(request.getParameter( "index" ));
		List<Job> jobs = (List<Job>) getServletContext().getAttribute( "jobs" );
		for (Job job: jobs){
			if (index == job.getIndex()){
				request.setAttribute( "job", job );
			}
		}
		
        request.getRequestDispatcher( "/ApplicantInf.jsp" ).forward(
                request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
