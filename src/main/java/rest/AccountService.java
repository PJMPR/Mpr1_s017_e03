package rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.AccountDto;
import rest.dto.PersonDto;
import dao.IRepositoryCatalog;
import domain.model.Account;
import domain.model.Person;

@Path("accounts")
@Stateless
public class AccountService {
	IRepositoryCatalog catalog;
	Mapper mapper = new DozerBeanMapper();
	
	@PersistenceContext
	EntityManager mgr;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AccountDto> getAll() throws SQLException{

		List<Account> accounts =  mgr.createNamedQuery("account.all",Account.class).getResultList();
		List<AccountDto> results = new ArrayList<AccountDto>();
		for(Account a: accounts)
			results.add(mapper.map(a, AccountDto.class));

		return results;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getaccount(@PathParam("id") int accountId){
		Account a = mgr.createNamedQuery("account.id", Account.class)
				.setParameter("accountId",accountId)
				.getSingleResult();
		if(a==null) 
			return Response.status(404).build();
		
		return	Response.ok(mapper.map(a, AccountDto.class)).build();
	}
	
	
}
