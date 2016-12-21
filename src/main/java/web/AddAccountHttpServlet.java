package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Account;
import domain.model.Person;

@WebServlet(urlPatterns = "/addAccount")
public class AddAccountHttpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html");

		HttpSession session = request.getSession();

		String currency = request.getParameter("currency");
		String amount = request.getParameter("amount");
		// sprawdzic parametry url
		if (currency == null  || currency.equals("") ||amount==null || amount.equals("")) {
			response.sendRedirect("/addAccount.html");
		} 
			Person person = (Person) session.getAttribute("person");
		
		if (person == null) {
			response.sendRedirect("/addPerson.html");
		}
		
		Account account = new Account();
		account.setAmount(Integer.parseInt(amount));
		account.setCurrency(currency);
		account.setPerson(person);
		List<Account> accounts = new ArrayList<Account>();
		if(session.getAttribute("accounts")!=null)
			accounts =(List<Account>) session.getAttribute("accounts");
		accounts.add(account);

		response.sendRedirect("/addAccount.html");

	}

}
