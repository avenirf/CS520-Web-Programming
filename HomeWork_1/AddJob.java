package cs520_HW1.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520_HW1.model.Job;

@WebServlet("/AddJob")
public class AddJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddJob() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		 // forward to a JSP (i.e. view)
        request.getRequestDispatcher( "/AddJob.jsp" ).forward(
            request, response );
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// job
        String jobName = request.getParameter( "newJob" );
        String date = (String) new SimpleDateFormat("M/dd/yyyy").format(new Date());
        List<Job> jobs = (List<Job>) getServletContext().getAttribute( "jobs" );
		int index = jobs.size() + 1;
        Job newJob = new Job(jobName, date, index);
		if (!jobName.isEmpty())
		{
			jobs.add(0, newJob);
		}
		
		ServletContext context = getServletContext();
        context.setAttribute( "jobs", jobs );
        
        // redirect to the Admin page
        response.sendRedirect( "Admin" );
	}

}
