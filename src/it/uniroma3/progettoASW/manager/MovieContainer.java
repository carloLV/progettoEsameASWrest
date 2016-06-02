package it.uniroma3.progettoASW.manager;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.transaction.*;
import java.net.URI;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import it.uniroma3.progettoASW.model.Catalogue;
import it.uniroma3.progettoASW.model.Movie;
import it.uniroma3.progettoASW.exceptions.CatalogueNotFoundException;
import it.uniroma3.progettoASW.exceptions.MovieNotFoundException;


@Stateless(name="movieContainer")
@Path("/movies")
public class MovieContainer {
	@Context
	private UriInfo uriInfo;

	@PersistenceContext(unitName = "dbProgettoASW-unit")
	private EntityManager em;

	public MovieContainer() {

	}

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createMovie(@FormParam("title") String title,
			@FormParam("year") Integer year,
			@FormParam("director") String director, 
			@FormParam("length") Integer length, 
			@FormParam("genre") String genre) {
		Movie already_present=em.find(Movie.class, title);
		Movie m = new Movie(title, year, director, length, genre);
		if (already_present==null)  {
			try {
				this.em.persist(m);
				return Response.created(URI.create("/" + title)).entity(m).build();
			}
			catch (Exception e) {
				String errorMessage = "Error while creating Movie " + m.toString() + ": " + e.getMessage();
				throw new WebApplicationException(
						Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorMessage).type("text/plain").build());
			}
		} else {
			String errorMessage = "Error while creating Movie with title " + title + ": a movie with the same title already exists";
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}

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
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}


	//per il funzionamento serve l'implementazione di un catalogo
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@SuppressWarnings("unchecked")
	public List<Movie> getMoviesByCatalogue(Long id) {
		try {
			Query q = this.em.createQuery("SELECT m FROM Movie m WHERE m.catalogue.id = :id");
			q.setParameter("id", id);
			List<Movie> movies = q.getResultList();
			if (movies==null) {
				throw new WebApplicationException(Response.Status.NOT_FOUND);
			} else {
				return movies;
			}
		} catch (Exception e) {
			String errorMessage = "Error while finding all movies: " + e.getMessage();
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}


	public Movie findMovie(String title) throws MovieNotFoundException {
		List<Movie> movies = this.getAllMovies();
		for(Movie m : movies){
			if(m.getTitle().equals(title))
				return m;
		}
		throw new MovieNotFoundException();
	}

	@POST
	//@Transactional
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public Response createMovie(Movie m) {
		//Catalogue c = m.getCatalogue();
		Long id = m.getId();
		Movie oldMovie = this.em.find(Movie.class, id);
		if (oldMovie==null) {
			try {
				//				c.addMovie(m);
				//				c.setLastUpdate(new GregorianCalendar());
				//				this.em.merge(c);
				this.em.persist(m);
				return Response.created(URI.create("/" + id)).entity(m).build();
			} catch (Exception e) {
				String errorMessage = "Error while creating Movie " + m.toString() + ": " + e.getMessage();
				throw new WebApplicationException(
						Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity(errorMessage).type("text/plain").build());
			}
		} else {
			String errorMessage = "Error while creating Movie with id " + id + ": a movie with the same id already exists";
			throw new WebApplicationException(
					Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(errorMessage).type("text/plain").build());
		}
	}


}