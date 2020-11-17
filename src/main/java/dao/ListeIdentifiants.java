package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.DataSourceProvider;
import hei.project.siteInfoHei.entities.Identifiant;

public class ListeIdentifiants {
	public static String currentNomUtil;
	public static String currentMdp;
	public static boolean currentAdmin;
	
	
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
						resultSet.getBoolean("Admin"));
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
					res= true;
				}
			}
		}
		return res;
	}
	}
