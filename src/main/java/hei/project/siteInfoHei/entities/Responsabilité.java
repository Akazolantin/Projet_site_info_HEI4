package hei.project.siteInfoHei.entities;

import java.time.LocalDate;

public class Responsabilité {

	private Integer id;
	private String title;
	private LocalDate releaseDate;
	private Integer duration;
	private Boolean valide;


	public Responsabilité(Integer id, String title, LocalDate releaseDate, Integer duration, Boolean valide) {
		super();
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.valide = valide;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public LocalDate getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public Boolean getValide() {
		return valide;
	}


	public void setValide(Boolean valide) {
		this.valide = valide;
	}
}
