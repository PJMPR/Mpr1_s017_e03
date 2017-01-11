package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import domain.model.EnumDictionary;

@WebServlet(urlPatterns = "/init")
public class InitServlet extends HttpServlet {
	
	private static final long serialVersionUID = 4L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		IRepositoryCatalog catalog = null;
		try {
			catalog= new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		{
			EnumDictionary dict1 = new EnumDictionary();
			dict1.setEnumName("currency");
			dict1.setIntKey(1);
			dict1.setStringKey("PLN");
			dict1.setValue("złoty");
			catalog.dictionaries().add(dict1);
		}
		{
			EnumDictionary dict2 = new EnumDictionary();
			dict2.setEnumName("currency");
			dict2.setIntKey(2);
			dict2.setStringKey("USD");
			dict2.setValue("dollar");
			catalog.dictionaries().add(dict2);
		}
		{
			EnumDictionary dict3 = new EnumDictionary();
			dict3.setEnumName("currency");
			dict3.setIntKey(3);
			dict3.setStringKey("CHF");
			dict3.setValue("frank");
			catalog.dictionaries().add(dict3);
		}
		catalog.saveAndClose();
	}

}
