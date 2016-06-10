package it.uniroma3.progettoASW.manager;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import it.uniroma3.progettoASW.model.User;

@Stateless
@Path("/user/{id}")
public class UserResource {
	
	@Context
	private UriInfo uriInfo;
	@PersistenceContext(unitName = "dbProgettoASW-unit")
	private EntityManager em;

	public UserResource() {}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	public User getUser(@PathParam("id") long id) {
		try {
			User u = this.em.find(User.class, id);
			if (u==null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				return u;
			}
		} catch (Exception e) {
			String errorMessage = "Error while finding User with id: " + id +  ": " + e.getMessage();
			throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}

	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public Response updateUser(@PathParam("id") long id, User u) {
		User oldUser = this.em.find(User.class, id);
		if (oldUser==null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			try {
				oldUser.setNickname(u.getNickname());
				oldUser.setSurname(u.getSurname());
				oldUser.setName(u.getName());
				oldUser.setEmail(u.getEmail());
				this.em.merge(oldUser);
				return Response.ok(u).status(Response.Status.OK).build();
			} catch (Exception e) {
				String errorMessage = "Error while updating User id: " + u.getId().toString() + " " + e.getMessage();
				throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorMessage).type("text/plain").build());
			}
		}
	}

	@DELETE
	public Response deleteMovie(@PathParam("id") long id) {
		try {
			User user = this.em.find(User.class, id);
			if (user==null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				this.em.remove(user);
				return Response.ok(user).status(Response.Status.OK).build();
			}
		} catch (Exception e) {
			String errorMessage = "Error while deleting User with id: " + id + ": " + e.getMessage();
			throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}
	
}