package it.uniroma3.progettoASW.model;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalogue implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlAttribute
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	@XmlElement
	private Calendar lastUpdate;
	@Column(unique = true, nullable = false)
	@XmlElement
	private String genre;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "catalogue_id")
	@XmlElement
	private List<Movie> movies;
	
	public Catalogue(){}

	public Catalogue(Calendar lastUpdate, String genre) {
		this.lastUpdate = lastUpdate;
		this.setGenre(genre);
		this.movies = new LinkedList<Movie>();
	}

	public void addMovie(Movie m){
		List<Movie> l= this.getMovies();
		l.add(m);
		this.setMovies(l);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre.toLowerCase();
	}
	
}