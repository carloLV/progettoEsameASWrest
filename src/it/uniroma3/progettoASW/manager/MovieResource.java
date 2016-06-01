package it.uniroma3.progettoASW.manager;

import java.net.URI;
import java.util.List;
import javax.ejb.*;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import it.uniroma3.progettoASW.exceptions.MovieNotFoundException;
import it.uniroma3.progettoASW.model.Movie;

@Stateless
@Path("/movie/{id}")
public class MovieResource {
	@Context
	private UriInfo uriInfo;

	@PersistenceContext(unitName = "dbProgettoASW-unit")
	private EntityManager em;

	public MovieResource() {

	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@SuppressWarnings("unchecked")
	public Movie getMovie(@PathParam("id") int id) {

		try {
			Movie m = em.find(Movie.class, id);
			if (m==null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				return m;
			}
		} catch (Exception e) {
			String errorMessage = "Error while finding Movie with id: " + id +  ": " + e.getMessage();
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());

		}
	}

	@PUT
	@Transactional
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
	public Response updateMovie(@PathParam("id") int id, Movie p) {
		Movie oldMovie = em.find(Movie.class, id);
		if (oldMovie==null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		} else {
			try {
				em.merge(p);
				return Response.ok(p).status(Response.Status.OK).build();
			} catch (Exception e) {
				String errorMessage = "Error while updating Product " + p.toString() + ": " + e.getMessage();
				throw new WebApplicationException(
						Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorMessage).type("text/plain").build());
			}
		}
	}

	/* DELETE: Cancella un film */
	@DELETE
	@Transactional
	public Response deleteMovie(@PathParam("id") int id) {
		try {
			Movie movie = em.find(Movie.class, id);
			if (movie==null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				em.remove(movie);
				return Response.ok(movie).status(Response.Status.OK).build();
			}
		} catch (Exception e) {
			String errorMessage = "Error while deleting Product with id: " + id + ": " + e.getMessage();
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}





}
