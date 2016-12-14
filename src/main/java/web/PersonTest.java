package web;

import domain.model.Person;

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

        Person person = new Person();
        person.setName(nameSession);
        person.setSurname(surnameSession);


		if (   !person.getName().equals("") && !person.getSurname().equals("") && !person.getName().equals(null) && !person.getSurname().equals(null)){
			session.setAttribute("person", person);
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
