package cs520_HW1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520_HW1.model.Applicant;
import cs520_HW1.model.Degree;
import cs520_HW1.model.Job;

@WebServlet(urlPatterns = "/CSJob", loadOnStartup = 1)
public class CSJob extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CSJob() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init( config );
		
		Job a = new Job("Instructor for CS320 in Fall 2015", "6/21/2015", 1);
		Job b = new Job("Full-time Tenure Track Position", "3/20/2015", 2);
		
		List<Job> jobs = new ArrayList<Job>();
		jobs.add(a);
		jobs.add(b);
		
		Applicant jd = new Applicant("John Doe", "4/5/2015", 1);
		jd.addJob(b);
		Applicant jad = new Applicant("Jane Dohe", "3/29/2015", 2);
		jad.addJob(b);
		
		List<Applicant> applicants = new ArrayList<Applicant>();
		applicants.add(jd);
		applicants.add(jad);
		
		Degree jd1 = new Degree("Ph.D. in Computer Science", "UCLA", 2014);
		jd.addDegree(jd1);
		Degree jd2 = new Degree("MS in Computer Science", "UCLA", 2011);
		jd.addDegree(jd2);
		Degree jd3 = new Degree("BS in Computer Science", "CSULA", 2009);
		jd.addDegree(jd3);
		
		ServletContext context = getServletContext();
        context.setAttribute( "jobs", jobs );
        context.setAttribute( "applicants", applicants );
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// forward to a JSP (i.e. view)
        request.getRequestDispatcher( "/CSJob.jsp" ).forward(
            request, response );
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}

