package cs520_HW1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs520_HW1.model.Applicant;
import cs520_HW1.model.Degree;

@WebServlet("/AddDegree")
public class AddDegree extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddDegree() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{	
		//job
	    List<Applicant> applicants = (List<Applicant>) getServletContext().getAttribute( "applicants" );
		String name = request.getParameter( "name" );
		for (Applicant applicant: applicants){
			if (name.equals(applicant.getName())){
				request.setAttribute( "applicant", applicant );
			}
		}
		request.getRequestDispatcher( "/AddDegree.jsp" ).forward(
                request, response );
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{	
		//degree
		String newDegree = request.getParameter( "degree" );
		String newUniversity = request.getParameter( "university" );
		int newYear = Integer.valueOf(request.getParameter( "year" ));
		Degree degree = new Degree(newDegree, newUniversity, newYear);
		
		// applicant
	    String name = request.getParameter( "applicant" );
	    List<Applicant> applicants = (List<Applicant>) getServletContext().getAttribute( "applicants" );
	    
	    if (!newDegree.isEmpty() & !newUniversity.isEmpty())
		{
		    for (Applicant applicant: applicants){
				if (applicant.getName().equals(name)){
					applicant.addDegree(degree);
					response.sendRedirect( "ApplicantInf2?name="+name );
				}
			}
		} else {
			response.sendRedirect( "AddDegree?name="+name );
		}
	}

}
