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

	public static List<Eleve> listEleves(String tripar,String anee,String dom,String rechNom) {
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
				year=Integer.parseInt(anee);
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
}
