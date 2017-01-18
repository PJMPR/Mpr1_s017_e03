package rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import domain.model.Person;

@Path("people")
@Stateless
public class PersonService {
	IRepositoryCatalog catalog;
	
	@PersistenceContext
	EntityManager mgr;
	
	public PersonService(){
		try {
			catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAll() throws SQLException{

		return mgr.createNativeQuery("Select * FROM Person",Person.class).getResultList();

	}
	
	
	
}
