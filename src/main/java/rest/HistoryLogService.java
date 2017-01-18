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
import domain.model.HistoryLog;
import domain.model.Operation;
import domain.model.Person;

@Path("History")
@Stateless


public class HistoryLogService {
	
IRepositoryCatalog catalog;
	
	@PersistenceContext
	EntityManager mgr;
	
	public HistoryLogService(){
		try {
			catalog = new RepositoryCatalog("jdbc:hsqldb:hsql://localhost/workdb");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public List<HistoryLog> getAll() throws SQLException{

		HistoryLog h = new HistoryLog();
		h.setId(1);
		h.setRate(0.3);
		h.setType(Operation.INCOME);
		List<HistoryLog> result = new ArrayList<HistoryLog>();
		result.add(h);

		return mgr.createNativeQuery("Select * FROM historyLog",HistoryLog.class).getResultList();

	}
	

}
