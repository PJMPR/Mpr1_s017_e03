package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/addPerson")
public class PersonTest extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String nameSession = request.getParameter("name");
		String surnameSession = request.getParameter("surname");
		if (nameSession!= null && !nameSession.equals("") && surnameSession!= null && !surnameSession.equals((""))){
			session.setAttribute("name", nameSession);
			session.setAttribute("surname",surnameSession);
		}

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		PrintWriter out = response.getWriter();
		out.println("Imie: "
				+ name
				+"</br>"
				+ "Nazwisko: "
				+ surname);
		out.close();
	}
	
}
