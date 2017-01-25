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


import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.PersonDto;

import rest.dto.PersonDto;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import domain.model.Person;

@Path("people")
@Stateless
public class PersonService {
	IRepositoryCatalog catalog;
	Mapper mapper = new DozerBeanMapper();
	
	@PersistenceContext
	EntityManager mgr;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonDto> getAll(){
		List<Person> people =  mgr.createNamedQuery("person.all",Person.class).getResultList();
		List<PersonDto> results = new ArrayList<PersonDto>();
		for(Person p: people)
			results.add(mapper.map(p, PersonDto.class));
		return results;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getperson(@PathParam("id") int personId){
		Person p = mgr.createNamedQuery("person.id", Person.class)
				.setParameter("personId",personId)
				.getSingleResult();
		if(p==null) 
			return Response.status(404).build();
		
		return	Response.ok(mapper.map(p, PersonDto.class)).build();
	}
	
	
}
