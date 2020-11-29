package hei.project.siteInfoHei.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hei.project.siteInfoHei.dao.TeaDao;
import hei.project.siteInfoHei.entities.Tea;

public class TeaDaoImpl implements TeaDao  {

	@Override
	public List<Tea> listTea() {
		List<Tea> result = new ArrayList<>();
		String sql="SELECT * FROM tea WHERE valide IS NOT NULL ORDER BY title";
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
					PreparedStatement statement = cnx.prepareStatement(sql);
					) 
			{
				
				ResultSet resultSet=statement.executeQuery();
				
				while(resultSet.next()) {
					result.add(createTeaFromResultSet(resultSet));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Tea getTea(Integer id) {
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

	private Tea createTeaFromResultSet(ResultSet resultSet) throws SQLException {
		return new Tea(
				resultSet.getInt("tea_id"),
				resultSet.getString("title"),
				resultSet.getDate("release_date").toLocalDate(),
				resultSet.getInt("duration"),
				resultSet.getBoolean("valide"));
	
	}

	@Override
	public Tea addTea(Tea tea) {
		String sql = "INSERT INTO tea (title, release_date, duration, valide ) VALUES ( ?, ?, ?, ?)";
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
					PreparedStatement preparedStatement = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, tea.getTitle());
				preparedStatement.setDate(2, Date.valueOf(tea.getReleaseDate()));
				preparedStatement.setInt(3, tea.getDuration());
				preparedStatement.setBoolean(4, tea.getValide());
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

	
    @Override
    public Tea getRandomTea() {
        String sqlQuery = "SELECT * FROM tea ORDER BY RAND() LIMIT 1;";
        try(Connection connection = DataSourceProvider.getDataSource().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try(ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                    if (resultSet.next()) {
                        return createTeaFromResultSet(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
