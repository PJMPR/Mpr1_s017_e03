package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/addAccount")
public class ServletAddAccount extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");

		String currency = request.getParameter("currency");
		String value = request.getParameter("value");
		PrintWriter out = response.getWriter();
		out.println("<h1>Choosen currency: "
				+ currency
				+ "Choosen value"
				+ value
				+ "</h1>");
		out.close();
	}
	


}
