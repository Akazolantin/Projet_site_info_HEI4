package hei.project.siteInfoHei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hei.project.siteInfoHei.entities.Eleve;
import hei.project.siteInfoHei.entities.Tea;

public class NNDao {
	
	
	public static List<Eleve> listNNEleve(int teaId) {
		List<Eleve> NNeleve = new ArrayList<Eleve>();
		String sql="SELECT eleve_id FROM NN WHERE tea_id = ? ;";
		String sql1="SELECT * FROM eleve WHERE eleve_id= ?;";
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx= dataSource.getConnection();
				PreparedStatement statement = cnx.prepareStatement(sql);
				PreparedStatement statement1 = cnx.prepareStatement(sql1);
					)
			{
				statement.setInt(1, teaId);
				ResultSet resultSet=statement.executeQuery();
				while(resultSet.next()) {
					statement1.setInt(1,resultSet.getInt("eleve_id") );
					ResultSet resultSet1=statement1.executeQuery();
					while(resultSet1.next()) {
					Eleve eleve= new Eleve(
							resultSet1.getString("nom"),
							resultSet1.getString("prenom"),
							resultSet1.getInt("year"),
							resultSet1.getString("domaine"),
							resultSet1.getInt("eleve_id"));
					NNeleve.add(eleve);}
				}
				
				
			}
		}catch(SQLException e) {e.printStackTrace();}
		return NNeleve;
	}
	
	public static List<Tea> listNNTea(int eleveId) {
		List<Tea> NNtea = new ArrayList<Tea>();
		String sql="SELECT tea_id FROM NN WHERE eleve_id = ? ;";
		String sql1="SELECT * FROM tea WHERE tea_id= ?;";
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx= dataSource.getConnection();
				PreparedStatement statement = cnx.prepareStatement(sql);
				PreparedStatement statement1 = cnx.prepareStatement(sql1);
					)
			{
				statement.setInt(1, eleveId);
				ResultSet resultSet=statement.executeQuery();
				while(resultSet.next()) {
					statement1.setInt(1,resultSet.getInt("tea_id") );
					ResultSet resultSet1=statement1.executeQuery();
					while(resultSet1.next()) {
					Tea tea= new Tea(
						resultSet1.getInt("tea_id"),
						resultSet1.getString("title"),
						resultSet1.getDate("release_date").toLocalDate(),
						resultSet1.getInt("duration"),
						resultSet1.getBoolean("valide"),
						resultSet1.getInt("nbrDispo"));
					
				NNtea.add(tea);}}
				
				
			}
		}catch(SQLException e) {e.printStackTrace();}
		return NNtea;
	}
	
	public static void deleteEleve(Integer eleveId) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) { 
			try (PreparedStatement statement = connection.prepareStatement( "delete from nn where eleve_id=?")) {
				statement.setInt(1, eleveId); statement.executeUpdate(); } }
		catch (SQLException e) {e.printStackTrace(); } }
	
	
	public static int checkNombreParticipant(int tea_id) {
		int nbr=0;
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) { 
			try (PreparedStatement statement = connection.prepareStatement( "select * from nn where tea_id=?")) {
				statement.setInt(1, tea_id);ResultSet resultSet= statement.executeQuery();
				while(resultSet.next()) {nbr++;}
			} }
		catch (SQLException e) {e.printStackTrace(); }
		return nbr;}
	

	public static void deleteTea(Integer TeaId) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) { 
			try (PreparedStatement statement = connection.prepareStatement( "delete from nn where tea_id=?")) {
				statement.setInt(1, TeaId); statement.executeUpdate(); } }
		catch (SQLException e) {e.printStackTrace(); } }
	
			

	public static void lienEleveTea(Integer eleveId, Integer teaId) {

String sql="SELECT nbrDispo FROM tea WHERE tea_id = ? ;";
try {
	DataSource dataSource = DataSourceProvider.getDataSource();
	try (Connection cnx= dataSource.getConnection();
		PreparedStatement statement = cnx.prepareStatement(sql);
			)
	{
		statement.setInt(1, teaId);
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()) {
		if (checkNombreParticipant(teaId)<((resultSet.getInt("nbrDispo")))) {
			String sql1="INSERT INTO NN(eleve_id, tea_id) VALUES( ?, ?)";
			try {
				PreparedStatement statement1 = cnx.prepareStatement(sql1);
				statement1.setInt(1,eleveId);
				statement1.setInt(2,teaId);
				statement1.executeQuery();
			} catch (SQLException e) {e.printStackTrace(); }
		} else {
			System.out.println("Plein");	
		}
}
}}catch (SQLException e) {e.printStackTrace(); }
	}
	
	public static boolean checkdoExist(Integer eleveId, Integer teaId) {
		String sql = "SELECT * FROM NN WHERE eleve_id=? AND tea_id=?";
		boolean res=false;
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx= dataSource.getConnection();
				PreparedStatement statement = cnx.prepareStatement(sql);
					)
			{
				statement.setInt(1, eleveId);
				statement.setInt(2, teaId);
				ResultSet resultSet=statement.executeQuery();
				if (!resultSet.isBeforeFirst()) {
					res=false;
				}
				else {
					res=true;
				}
			}
	} catch (SQLException e) {e.printStackTrace(); } 
	return res;
}
}
		
