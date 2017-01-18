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
import domain.model.Account;

@Path("accounts")
@Stateless
public class AccountService {
	IRepositoryCatalog catalog;
	
	@PersistenceContext
	EntityManager mgr;
	
	public AccountService(){
		try {
			catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Account> getAll() throws SQLException{

		return mgr.createNativeQuery("Select * FROM Account",Account.class).getResultList();

	}
	
	
	
}
