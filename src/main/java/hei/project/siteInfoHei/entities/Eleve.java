package hei.project.siteInfoHei.entities;

public class Eleve {
	private String nom;
	private String prenom;
	private int year;
	private String domaine;
	private int eleve_id;
	
	public Eleve(String nom, String prenom,int year, String domaine,int eleve_id) {
		this.nom=nom;this.prenom=prenom;this.year=year; this.domaine=domaine;this.eleve_id=eleve_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public int getEleve_id() {
		return eleve_id;
	}

	public void setEleve_id(int eleve_id) {
		this.eleve_id = eleve_id;
	}
}