package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hei.project.siteInfoHei.dao.impl.DataSourceProvider;
import hei.project.siteInfoHei.entities.Identifiant;

public class ListeIdentifiants {
	public static String currentNomUtil;
	public static String currentMdp;
	public static boolean currentAdmin;
	public static int IdUtil;
	
	
	public static List<Identifiant> listeIdent() {
		List<Identifiant> Ident = new ArrayList();
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
					Statement statement = cnx.createStatement();
					ResultSet resultSet=statement.executeQuery("SELECT * FROM identifiant;")) {
				while(resultSet.next()) {Identifiant ident = new Identifiant(
						resultSet.getString("nomUtil"),
						resultSet.getString("Mdp"),
						resultSet.getBoolean("Admin"),
						resultSet.getInt("eleve_id"));
				Ident.add(ident);}
				}
		}catch(SQLException e) {e.printStackTrace();}
		return Ident;
		}
	
	public static boolean checkIdent(String nomUtil, String Mdp) {
		boolean res=false;
		for (int i=0; i<listeIdent().size();i++) {
			if(listeIdent().get(i).getNomUtil().equals(nomUtil)) {
				if(listeIdent().get(i).getMdp().equals(Mdp)) {
					currentNomUtil=listeIdent().get(i).getNomUtil();
					currentMdp=listeIdent().get(i).getMdp();
					currentAdmin=listeIdent().get(i).getAdmin();
					IdUtil=listeIdent().get(i).getId();
					res= true;
				}
			}
		}
		return res;
	}
	
	public static void changeMdp(String newMdp) {
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
				PreparedStatement statement = cnx.prepareStatement("UPDATE identifiant SET Mdp=? WHERE eleve_id=?;");) {
				statement.setInt(2,IdUtil);
				statement.setString(1,newMdp);
				statement.executeUpdate();
				listeIdent();
				currentMdp=newMdp;
				}
		}catch(SQLException e) {e.printStackTrace();}
		}
}
