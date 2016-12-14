package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/test")
public class TestServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		
		if(name!=null && !name.equals("")){
			session.setAttribute("name", name);
		}
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Imię (request): "
				+ name 
				+ "</h1>");
		out.println("<h1>Imię (session): "
				+ session.getAttribute("name") 
				+ "</h1>");
		out.close();
	}
	

}
