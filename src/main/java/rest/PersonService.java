package rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import domain.model.Person;

@Path("people")
public class PersonService {
	IRepositoryCatalog catalog;
	public PersonService(){
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll() throws SQLException{

		Person p = new Person();
		p.setName("Jan");
		p.setSurname("Kowalski");
		List<Person> result = new ArrayList<Person>();
		result.add(p);
		return catalog.people().getAll();
	}
	
	
	
}
