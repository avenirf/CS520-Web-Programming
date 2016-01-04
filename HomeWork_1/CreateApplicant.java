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

import cs520_HW1.model.Applicant;

@WebServlet("/CreateApplicant")
public class CreateApplicant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateApplicant() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request.getRequestDispatcher( "/CreateApplicant.jsp" ).forward(
	            request, response );
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String name = String.valueOf( request.getParameter( "newName" ) );
		String date = (String) new SimpleDateFormat("M/dd/yyyy").format(new Date());
		List<Applicant> applicants = (List<Applicant>) getServletContext().getAttribute( "applicants" );
		int index = applicants.size() + 1;
		Applicant app = new Applicant(name, date, index);
		applicants.add(app);
		
		ServletContext context = getServletContext();
        context.setAttribute( "applicants", applicants );
		
		response.sendRedirect( "ApplicantInf2?name="+name );
	}

}
