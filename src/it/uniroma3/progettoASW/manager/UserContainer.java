package it.uniroma3.progettoASW.manager;

import java.net.URI;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import it.uniroma3.progettoASW.model.User;

@Stateless(name="userContainer")
@Path("/users")
public class UserContainer {
	@Context
	private UriInfo uriInfo;
	
	@PersistenceContext(unitName = "dbProgettoASW-unit")
	private EntityManager em;
	
	public UserContainer() {}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createUser(User u) {
		User oldUser = this.findUser(u.getNickname());
		if (oldUser==null)  {
			try {
				this.em.persist(u);
				return Response.created(URI.create("/" + u.getNickname())).entity(u).build();
			}
			catch (Exception e) {
				String errorMessage = "Error while creating Movie " + u.toString() + ": " + e.getMessage();
				throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorMessage).type("text/plain").build());
			}
		} else {
			String errorMessage = "Error while creating user with nickaname " + u.getNickname() + 
					": another user with the same nickname already exists";
			throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		try {
			List<User> users = this.em.createQuery("SELECT u FROM User u").getResultList();
			if (users==null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				return users;
			}
		} catch (Exception e) {
			String errorMessage = "Error while finding all movies: " + e.getMessage();
			throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}
	
	@SuppressWarnings("unchecked")
	private User findUser(String nickname) {
		List<User> users = this.em.createQuery("SELECT u FROM User u").getResultList();
		for(User u : users){
			if(u.getNickname().equals(nickname))
				return u;
		}
		return null;
	}
	
}