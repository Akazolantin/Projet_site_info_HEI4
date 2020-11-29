package hei.project.siteInfoHei.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hei.project.siteInfoHei.dao.impl.DataSourceProvider;
import hei.project.siteInfoHei.entities.Eleve;

public class EleveDao {

	public static List<Eleve> listEleves(String tripar,String annee,String dom,String rechNom) {
		List<Eleve> eleves = new ArrayList();
		String sql="SELECT * FROM eleve WHERE (prenom LIKE ? OR nom LIKE ?) AND domaine LIKE ? AND year BETWEEN ? AND ?  ORDER BY ";

		sql+=tripar+" ;";
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx= dataSource.getConnection();
				PreparedStatement statement = cnx.prepareStatement(sql);
					)
				{
				statement.setString(1, rechNom+"%");
				statement.setString(2, rechNom+"%");
				int min,max;
				int year;
				statement.setString(3, dom);
				year=Integer.parseInt(annee);
				if(year!=0) {min=max=year;}else {min=1;max=5;}
				statement.setInt(4, min);
				statement.setInt(5, max);
			
				ResultSet resultSet=statement.executeQuery();
				while(resultSet.next()) {Eleve eleve= new Eleve(
						resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getInt("year"),
						resultSet.getString("domaine"),
						resultSet.getInt("eleve_id"));
				eleves.add(eleve);}
			}
		}catch(SQLException e) {e.printStackTrace();}
		return eleves;
	}
	
	public static int addEleve(String nom,String prenom, String annee,String dom) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			String sqlQuery = "insert into eleve(nom, prenom, year, domaine) VALUES(?,?,?,?)";
			try (PreparedStatement statement = connection.prepareStatement( sqlQuery,Statement.RETURN_GENERATED_KEYS)) 
			{ statement.setString(1, nom); 
			statement.setString(2, prenom); 
			int year=Integer.parseInt(annee);
			statement.setInt(3, year); 
			statement.setString(4, dom);
			statement.executeUpdate(); 
			ResultSet id=statement.getGeneratedKeys();
			if(id.next()) {return(id.getInt(1));}
		 } }
		catch (SQLException e) { e.printStackTrace(); }
		return 0;
		}
		
	
	
	public static void delete(Integer eleveId) {
		NNDao.deleteEleve(eleveId);ListeIdentifiants.deleteEleve(eleveId);
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) { 
			try (PreparedStatement statement = connection.prepareStatement( "delete from eleve where eleve_id=?")) {
				statement.setInt(1, eleveId); statement.executeUpdate(); } }
		catch (SQLException e) {e.printStackTrace(); } }
	
	public static Eleve getEleveById(int eleveId) {
		Eleve eleve=new Eleve("","",0,"",0);
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx= dataSource.getConnection();
				PreparedStatement statement = cnx.prepareStatement("SELECT * FROM eleve WHERE eleve_id=?");
					)
				{statement.setInt(1, eleveId);
				ResultSet resultSet=statement.executeQuery();
				while(resultSet.next()) {
				eleve=new Eleve(resultSet.getString("nom"),
						resultSet.getString("prenom"),
						resultSet.getInt("year"),
						resultSet.getString("domaine"),
						resultSet.getInt("eleve_id"));}}
		}catch(SQLException e) {e.printStackTrace();}
		return(eleve);
	}
	
	public static void modif(int eleveId,String nom,String prenom, int year,String dom) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			String sqlQuery = "update eleve set nom=?, prenom=?, year=?, domaine=? WHERE eleve_id=?;";
			try (PreparedStatement statement = connection.prepareStatement( sqlQuery)) 
			{ statement.setString(1, nom); 
			statement.setString(2, prenom); 
			statement.setInt(3, year); 
			statement.setString(4, dom);
			statement.setInt(5, eleveId);
			statement.executeUpdate(); 
		 } }
		catch (SQLException e) { e.printStackTrace(); }
	}
		
	}

