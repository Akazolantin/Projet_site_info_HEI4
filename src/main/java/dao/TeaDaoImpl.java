package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entities.Tea;
import sitehei.dao.TeaDao;

public class TeaDaoImpl implements TeaDao  {

	@Override
	public List<Tea> listTea() {
		List<Tea> result = new ArrayList<>();
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
					Statement statement = cnx.createStatement();
					ResultSet resultSelect = statement.executeQuery("SELECT * FROM tea JOIN eleve ON tea.eleve_id = eleve.eleve_id ORDER BY title")) {
				while(resultSelect.next()) {
					result.add(createTeaFromResultSet(resultSelect));
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
		String sql = "SELECT * FROM tea JOIN eleve ON tea.eleve_id = eleve.eleve_id WHERE tea_id=?";
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

	private Tea createTeaFromResultSet(ResultSet resultSelect) throws SQLException {
		return new Tea(
				resultSelect.getInt("tea_id"),
				resultSelect.getString("title"),
				resultSelect.getDate("release_date").toLocalDate(),
				resultSelect.getEleve("eleve_id"),
				resultSelect.getInt("duration"));
	}

	@Override
	public Tea addTea(Tea tea) {
		String sql = "INSERT INTO tea (title, release_date, eleve_id, duration ) VALUES (?, ?, ?, ?)";
		try {
			DataSource dataSource = DataSourceProvider.getDataSource();
			try (Connection cnx = dataSource.getConnection();
					PreparedStatement preparedStatement = cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				preparedStatement.setString(1, tea.getTitle());
				preparedStatement.setDate(2, Date.valueOf(tea.getReleaseDate()));
				preparedStatement.setEleve(3, tea.getEleve());
				preparedStatement.setInt(4, tea.getDuration());
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
		throw new RuntimeException("Erreur lors de la mise à jour du tea");
	}

    @Override
    public Tea getRandomTea() {
        String sqlQuery = "SELECT * FROM tea JOIN eleve ON tea.eleve_id = eleve.eleve_id ORDER BY RAND() LIMIT 1;";
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
