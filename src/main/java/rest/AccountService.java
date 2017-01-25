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

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.PersonDto;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
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
	public List<Account> getAll() throws SQLException{

		List<Account> accounts =  mgr.createNamedQuery("account.all",Account.class).getResultList();
		List<Account> results = new ArrayList<Account>();
		for(Account a: accounts)
			results.add(mapper.map(a, Account.class));
		return results;
	}
	
	
	
}
