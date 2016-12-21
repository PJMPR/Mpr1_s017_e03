package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Account;
import domain.model.Person;

@WebServlet(urlPatterns="/addAccount")
public class AddAccountHttpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();

		String currency = request.getParameter("currency");
		String amount = request.getParameter("amount");
		// sprawdzic parametry url
		
		Person person = (Person) session.getAttribute("person");
		// sprawdzic czy jest person
		//jesli nie to przekierowac na addPerson
		
		if(person != null){
			Account account = new Account();
			account.setAmount(Double.parseDouble(amount));
			account.setCurrency(currency);
			account.setPerson(person);
			session.setAttribute("account", account);		
      PrintWriter out = response.getWriter();
      out.println("<h1>Choosen currency: "
          + currency
          + "</br>"
          + "Choosen amount: "
          + amount
          + "</h1>");
      out.close();
		}
		else{
			response.sendRedirect("/addPerson.html");
		}
	}
	


}
