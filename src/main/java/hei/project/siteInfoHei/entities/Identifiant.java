package hei.project.siteInfoHei.entities;

public class Identifiant {
	
	private String NomUtil;
	private String Mdp;
	private boolean Admin;
	
	public Identifiant(String NomUtil, String Mdp, boolean Admin) {
		this.NomUtil=NomUtil;
		this.Mdp=Mdp;
		this.Admin=Admin;
	}
	
	public String getNomUtil() {
		return NomUtil;
	}
	
	public String getMdp() {
		return Mdp;
	}
	
	public boolean getAdmin() {
		return Admin;
	}
	// setteur pour que personne puisse changer son mot de passe //
}
