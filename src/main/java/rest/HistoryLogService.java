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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.HistoryLogDto;
import rest.dto.PersonDto;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import domain.model.HistoryLog;
import domain.model.Person;

@Path("History")
@Stateless


public class HistoryLogService {
	
IRepositoryCatalog catalog;
	
	@PersistenceContext
	EntityManager mgr;
	

	Mapper mapper = new DozerBeanMapper();

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<HistoryLogDto> getAll() throws SQLException{

		List<HistoryLog> history =  mgr.createNamedQuery("historyLog.all",HistoryLog.class).getResultList();
		List<HistoryLogDto> results = new ArrayList<HistoryLogDto>();
		for(HistoryLog h: history)
			results.add(mapper.map(h, HistoryLogDto.class));
		return results;

	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gethistoryLog(@PathParam("id") int historyLogId){
		HistoryLog h = mgr.createNamedQuery("historyLog.id", HistoryLog.class)
				.setParameter("historyLogId",historyLogId)
				.getSingleResult();
		if(h==null) 
			return Response.status(404).build();
		
		return	Response.ok(mapper.map(h, HistoryLogDto.class)).build();
	}
}
