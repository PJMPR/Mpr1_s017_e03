package web;

import domain.model.Account;
import domain.model.Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;

@WebServlet(urlPatterns="/finalize")
public class FinalizeHttpServlet extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		IRepositoryCatalog catalog;
		try {
			catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
			Person person = (Person)session.getAttribute("person");
			List<Account> accounts = (List<Account>)session.getAttribute("accounts");
			
			catalog.people().add(person);
			catalog.save();
			int id = catalog.people().getMaxId();
			for(Account account : accounts)
				{
					account.setPersonId(id);
					catalog.accounts().add(account);
				}
			catalog.saveAndClose();
			session.removeAttribute("person");
			session.removeAttribute("accounts");
			response.sendRedirect("index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	
	
	
}
