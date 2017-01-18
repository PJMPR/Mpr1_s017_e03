package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.model.Account;

@Path("accounts")
@Stateless
public class AccountService {
	
	@PersistenceContext
	EntityManager mgr;
	
	public AccountService() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Account> getAll() {
		
		return mgr.createNamedQuery("account.all").getResultList();
	}
	
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Account get(@PathParam("id") int id) {
		
		return mgr.find(Account.class, id);
		
	}
	
	
	
	
	
}
