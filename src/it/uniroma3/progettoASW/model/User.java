package it.uniroma3.progettoASW.model;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute
	private Long id;
	@Column(nullable = false , unique = true)
	@XmlElement
	private String nickname;
	@Column(nullable = false)
	@XmlElement
	private String surname;
	@XmlElement
	private String name;
	@XmlElement
	private String email;
	@OneToMany(fetch = FetchType.EAGER)
	@XmlElement
	private List<Movie> favourteMovies;
	
	public User() {}
	
	public User(String nickname, String surname, String name, String email) {
		this.nickname = nickname;
		this.surname = surname;
		this.name = name;
		this.email = email;
		this.favourteMovies = new LinkedList<Movie>();
	}
	
	public void addMovie(Movie movie){
		List<Movie> lm = this.getMovies();
		lm.add(movie);
		this.setMovies(lm);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname= nickname;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Movie> getMovies() {
		return favourteMovies;
	}

	public void setMovies(List<Movie> favouriteMovies) {
		this.favourteMovies = favouriteMovies;
	}

}
