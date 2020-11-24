package hei.project.siteInfoHei.entities;

import java.time.LocalDate;

public class B2 {
	
	private Integer id;
	private LocalDate datepassage;
	private Integer score;
	private Boolean valide;
	
	public B2(Integer id, LocalDate datepassage, Integer score, Boolean valide) {
		super();
		this.id = id;
		this.datepassage = datepassage;
		this.score = score;
		this.valide = valide;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDatepassage() {
		return datepassage;
	}

	public void setDatepassage(LocalDate datepassage) {
		this.datepassage = datepassage;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public boolean getValide() {
		return valide;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}
}
