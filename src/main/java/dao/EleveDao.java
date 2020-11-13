package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.DataSourceProvider;
import entities.Eleve;

public class EleveDao {

	public static List<Eleve> listEleves(int tripar,int year,int dom,String rechNom) {
		List<Eleve> eleves = new ArrayList();
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx= dataSource.getConnection();
				PreparedStatement statement = cnx.prepareStatement("SELECT * FROM eleve ORDER BY nom;");
					)
				{
				
			
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
}
