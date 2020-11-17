package entities;

public class Identifiant {
	
	private String NomUtil;
	private String Mdp;
	private boolean Admin;
	private int IdUtil;
	
	public Identifiant(String NomUtil, String Mdp, boolean Admin, int IdUtil) {
		this.NomUtil=NomUtil;
		this.Mdp=Mdp;
		this.Admin=Admin;
		this.IdUtil=IdUtil;
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
	
	public void setMdp(String Mdp) {
		this.Mdp=Mdp;
	}
	
	public int getId() {
		return IdUtil;
	}
	
	public void setid() {
		this.IdUtil=IdUtil;
	}
	// setteur pour que personne puisse changer son mot de passe //
}

//garde en memoire l'identifiant + on doit passer par la connexion + quand on ferme onglet on deco //
