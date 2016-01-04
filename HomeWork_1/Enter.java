package cs520_HW1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520_HW1.model.Applicant;

@WebServlet("/Enter")
public class Enter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Enter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// forward to a JSP (i.e. view)
        request.getRequestDispatcher( "/Enter.jsp" ).forward(
            request, response );
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// applicant check
		Boolean check = false;
        String login = request.getParameter( "login" );
        List<Applicant> applicants = (List<Applicant>) getServletContext().getAttribute( "applicants" );
        if (!login.isEmpty()){
	        for (Applicant applicant: applicants){
				if (applicant.getName().equals(login)){
					check = true;
				}
			} 
	        if (check){
	        	response.sendRedirect( "ApplicantInf2?name="+login);
	        } else{       
		        response.sendRedirect( "CreateApplicant");
	        }
        } else {
        	response.sendRedirect( "Enter" );
        }
	}

}
