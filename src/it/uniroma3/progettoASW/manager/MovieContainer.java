package it.uniroma3.progettoASW.manager;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.net.URI;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import it.uniroma3.progettoASW.model.Movie;

@Stateless(name="movieContainer")
@Path("/movies")
public class MovieContainer {
	
	@Context
	private UriInfo uriInfo;
	@PersistenceContext(unitName = "dbProgettoASW-unit")
	private EntityManager em;

	public MovieContainer() {}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies() {
		try {
			List<Movie> movies = this.em.createQuery("SELECT m FROM Movie m").getResultList();
			if (movies==null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				return movies;
			}
		} catch (Exception e) {
			String errorMessage = "Error while finding all movies: " + e.getMessage();
			throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}

	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public Response createMovie(Movie m) {
		Movie oldMovie = this.findMovie(m.getTitle());
		if (oldMovie==null) {
			try {
				this.em.persist(m);
				return Response.created(URI.create("/" + m.getTitle())).entity(m).build();
			} catch (Exception e) {
				String errorMessage = "Error while creating Movie " + m.getTitle() + ": " + e.getMessage();
				throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorMessage).type("text/plain").build());
			}
		} else {
			String errorMessage = "Error while creating Movie with title " + m.getTitle() + ": a movie with the same title already exists";
			throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}

	private Movie findMovie(String title) {
		List<Movie> movies = this.getAllMovies();
		for(Movie m : movies){
			if(m.getTitle().equals(title))
				return m;
		}
		return null;
	}
	
}