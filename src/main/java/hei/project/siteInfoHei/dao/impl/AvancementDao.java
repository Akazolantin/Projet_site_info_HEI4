package hei.project.siteInfoHei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entities.Eleve;
import entities.Tea;

public class AvancementDao extends DataSourceProvider {

	public static List<Tea> listTEA(String eleveid) {
		List<Tea> TEA = new ArrayList();
		
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx= dataSource.getConnection();
				PreparedStatement statement = cnx.prepareStatement("SELECT * FROM TEA JOIN eleve ON tea.eleve_id = eleve.eleve_id ORDER BY title WHERE eleveId = ?");
				)
			{
				statement.setString(1, eleveid);
				
				ResultSet resultSet=statement.executeQuery();
				while(resultSet.next()) {Tea tea= new Tea(
						resultSet.getInt("id"),
						resultSet.getString("title"),
						resultSet.getDate("year").toLocalDate(),
						resultSet.getInt("eleve_id"),
						resultSet.getBoolean("valide"));
				TEA.add(tea);}
			}
			
	}
	
catch(SQLException e) {e.printStackTrace();}
	return (TEA);
	}
}
