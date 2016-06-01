package it.uniroma3.progettoASW.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.*;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlAttribute
	private Long id;
	@Column(nullable = false)
	@XmlElement
	private String title;
	@XmlElement
	private Integer year;
	@XmlElement
	private String director;
	@XmlElement
	private Integer length;
	@ManyToOne
	@XmlElement
	private Catalogue catalogue;
	@XmlElement
	private String genre;
	
	public Movie(){}

	public Movie(String title, Integer year, String director, Integer length, String genre) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.length = length;
		this.genre=genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
		
}