package hei.project.siteInfoHei.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import hei.project.siteInfoHei.entities.Tea;
import hei.project.siteInfoHei.servlets.PageAccueilServlet;
import hei.project.siteInfoHei.dao.impl.NNDao;

public class TeaDaoImpl   {


	public static List<Tea> listTea() {
		List<Tea> result = new ArrayList<>();
		String sql="SELECT * FROM tea WHERE valide=false ";
		if (!ListeIdentifiants.currentAdmin) {sql+=" AND release_date > CURRENT_DATE() ";}
		sql+="ORDER BY title;";
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
					PreparedStatement statement = cnx.prepareStatement(sql);
					) 
			{
				
				ResultSet resultSet=statement.executeQuery();
				
				while(resultSet.next()) {
					Integer teaId = resultSet.getInt("tea_id");
					if(NNDao.checkNombreParticipant(resultSet.getInt("tea_id"))<resultSet.getInt("nbrDispo") && !ListeIdentifiants.currentAdmin) {
						if (NNDao.checkdoExist(ListeIdentifiants.IdUtil, teaId)==false) {
							result.add(createTeaFromResultSet(resultSet));
						}
					}else {result.add(createTeaFromResultSet(resultSet));}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	public static Tea getTea(int id) {
		Tea tea = null;
		String sql = "SELECT * FROM tea WHERE tea_id=?";
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
					PreparedStatement preparedStatement = cnx.prepareStatement(sql)) {
				preparedStatement.setInt(1, id);
				try(ResultSet result = preparedStatement.executeQuery()) {
					if(result.next()) {
						tea = createTeaFromResultSet(result);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tea;
	}

	private static Tea createTeaFromResultSet(ResultSet resultSet) throws SQLException {
		return new Tea(
				resultSet.getInt("tea_id"),
				resultSet.getString("title"),
				resultSet.getDate("release_date").toLocalDate(),
				resultSet.getInt("duration"),
				resultSet.getBoolean("valide"),
				resultSet.getInt("nbrDispo"));
				
	
	}

	
	public Tea addTea(Tea tea) {
		String sql = "INSERT INTO tea (title, release_date, duration, valide,nbrDispo ) VALUES ( ?, ?, ?, ?,?)";
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
					PreparedStatement preparedStatement = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, tea.getTitle());
				preparedStatement.setDate(2, Date.valueOf(tea.getReleaseDate()));
				preparedStatement.setInt(3, tea.getDuration());
				preparedStatement.setBoolean(4, tea.getValide());
				preparedStatement.setInt(5, tea.getNbrDispo());
				preparedStatement.executeUpdate();
				ResultSet ids = preparedStatement.getGeneratedKeys();
				if (ids.next()) {
					tea.setId(ids.getInt(1));
					return tea;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Erreur lors de la mise à jour du tea");}

	

    public static void valideTea(int TeaId) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			String sqlQuery = "update tea set valide=true WHERE tea_id=?;";
			try (PreparedStatement statement = connection.prepareStatement( sqlQuery)) 
			{
				statement.setInt(1, TeaId);
				statement.executeUpdate();
		 } }
		catch (SQLException e) { e.printStackTrace(); }
	}
    
    
    
    public static Tea modifTea (int id,String title,LocalDate releaseDate, int duration,Boolean valide) {
    	Tea tea = null;
    	try (Connection connection = DataSourceProvider.getDataSource().getConnection()) {
			String sqlQuery = "update tea set title=?, release_date=?, duration=?, valide=? WHERE tea_id=?;";
			try (PreparedStatement statement = connection.prepareStatement( sqlQuery)) 
			{ 
			statement.setString(1, title); 
			statement.setDate(2, Date.valueOf(releaseDate)); 
			statement.setInt(3, duration); 
			statement.setBoolean(4, valide);
			statement.setInt(5, id);
			statement.executeUpdate();
		 } }
		catch (SQLException e) { e.printStackTrace(); }
		return tea;
	}
		
    	
    }

