package services;

import java.io.FileNotFoundException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import hei.project.siteInfoHei.Service.TeaServiceImpl;
import hei.project.siteInfoHei.dao.impl.DataSourceProvider;
import hei.project.siteInfoHei.dao.impl.TeaDaoImpl;
import hei.project.siteInfoHei.entities.Tea;


@RunWith(MockitoJUnitRunner.class) 
public class TeaServiceTestCase {


	@Mock
	private TeaDaoImpl teaDao;

	@InjectMocks
	private TeaServiceImpl teaService;


	@Test
	public void shouldListTea() {
		//GIVEN
		Tea tea =new Tea(1, "tea2", LocalDate.of(2020, 9, 13), 2, false, 2);
		Tea tea1 =new Tea(2, "tea3", LocalDate.of(2020, 8, 12), 1, false, 3);
		List<Tea> titles = Arrays.asList(tea,tea1);
		Mockito.when(teaDao.listTea()).thenReturn(titles);

		//WHEN
		List<Tea> result = teaDao.listTea();

		//THEN
		Assertions.assertThat(result).containsExactlyInAnyOrderElementsOf(titles);
	}


	@Test
	public void shouldGetTea() throws FileNotFoundException, DataFormatException {
		// WHEN
		Tea tea = teaDao.getTea(1);
		// THEN

		Assertions.assertThat(tea).isNotNull();
		Assertions.assertThat(tea.getId()).isEqualTo(1);
		Assertions.assertThat(tea.getTitle()).isEqualTo("my title 1");
		Assertions.assertThat(tea.getReleaseDate()).isEqualTo(LocalDate.of(2019, Month.NOVEMBER, 26));
		Assertions.assertThat(tea.getDuration()).isEqualTo(2);
		Assertions.assertThat(tea.getValide()).isEqualTo(false);
		Assertions.assertThat(tea.getNbrDispo()).isEqualTo(3);
	}

	@Test
	public void shouldAddTea() throws Exception, FileNotFoundException  {
		//GIVEN

		Tea teaToCreate = new Tea(null, "My new tea", LocalDate.of(2019, Month.OCTOBER, 20), 2,false, null);
		String title = "avenger";
		Integer duration = 2;
		teaToCreate.setTitle(title);
		teaToCreate.setDuration(duration);


		Mockito.when(storageService.read(title)).thenThrow(new SeriesNotFoundException(title));
		Mockito.when(converterService.encode(series)).thenReturn(data);

		//WHEN
		Tea teaCreated =  teaService.addTea(teaToCreate);

		//THEN

	} {
		// GIVEN
		Tea teaToCreate = new Tea(null, "My new tea", LocalDate.of(2019, Month.OCTOBER, 20), 2,false, null);
		// WHEN
		Tea teaCreated = teaDao.addTea(teaToCreate);
		// THEN
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tea WHERE tea_id = ?")) {
			stmt.setInt(1, teaCreated.getId());
			try (ResultSet rs = stmt.executeQuery()) {
				Assertions.assertThat(rs.next()).isTrue();
				Assertions.assertThat(rs.getInt("tea_id")).isEqualTo(teaCreated.getId());
				Assertions.assertThat(rs.getString("title")).isEqualTo("My new tea");
				Assertions.assertThat(rs.getDate("release_date").toLocalDate()).isEqualTo(LocalDate.of(2019, Month.OCTOBER, 20));
				Assertions.assertThat(rs.getInt("duration")).isEqualTo(2);
				Assertions.assertThat(rs.getBoolean("valide")).isEqualTo(false);
				Assertions.assertThat(rs.getInt("nbrDispo")).isEqualTo(2);
				Assertions.assertThat(rs.next()).isFalse();
			}
		}
	}


}