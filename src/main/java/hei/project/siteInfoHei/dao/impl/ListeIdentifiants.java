package hei.project.siteInfoHei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import hei.project.siteInfoHei.entities.Identifiant;

public class ListeIdentifiants {
	public static String currentNomUtil;
	public static String currentMdp;
	public static boolean currentAdmin;
	public static int IdUtil;
	
	public static void addIdent(int eleve_id,String ident, String mdp) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			String sqlQuery = "insert into identifiant(eleve_id, nomUtil, Mdp, Admin) VALUES(?,?,?,false)";
			try (PreparedStatement statement = connection.prepareStatement( sqlQuery)) 
			{ statement.setInt(1, eleve_id); 
			statement.setString(2, ident);
			String hash = PasswordHash.encrypt(mdp);
			statement.setString(3, hash);
			statement.executeUpdate(); 
		 } }
		catch (SQLException e) { e.printStackTrace(); }
		}
	
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
				if(PasswordHash.verify(listeIdent().get(i).getMdp(),Mdp)) {
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
		String hash = PasswordHash.encrypt(newMdp);
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
				PreparedStatement statement = cnx.prepareStatement("UPDATE identifiant SET Mdp=? WHERE eleve_id=?;");) {
				statement.setInt(2,IdUtil);
				statement.setString(1,hash);
				statement.executeUpdate();
				listeIdent();
				currentMdp=hash;
				}
		}catch(SQLException e) {e.printStackTrace();}
		}
	
	public static void deleteEleve(Integer eleveId) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) { 
			try (PreparedStatement statement = connection.prepareStatement( "delete from identifiant where eleve_id=?")) {
				statement.setInt(1, eleveId); statement.executeUpdate(); } }
		catch (SQLException e) {e.printStackTrace(); } }
	}
