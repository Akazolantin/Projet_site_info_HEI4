package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entities.Eleve;
import entities.Tea;

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
					statement.setInt(1,resultSet.getInt("eleve_id") );
					ResultSet resultSet1=statement.executeQuery();
					Eleve eleve= new Eleve(
							resultSet1.getString("nom"),
							resultSet1.getString("prenom"),
							resultSet1.getInt("year"),
							resultSet1.getString("domaine"),
							resultSet1.getInt("eleve_id"));
					NNeleve.add(eleve);
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
					statement.setInt(1,resultSet.getInt("tea_id") );
					ResultSet resultSet1=statement.executeQuery();
					Tea tea= new Tea(
						resultSet1.getInt("tea_id"),
						resultSet1.getString("title"),
						resultSet1.getDate("release_date").toLocalDate(),
						resultSet1.getInt("duration"));
				NNtea.add(tea);}
				
				
			}
		}catch(SQLException e) {e.printStackTrace();}
		return NNtea;
	}

}

		