package services;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionTeaIsNull() throws Exception, FileNotFoundException  {
		//GIVEN
		Tea tea = null;
	
		//WHEN
		Tea result =  teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		

	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionTitleIsNull() throws Exception, FileNotFoundException  {
		//GIVEN
		Tea tea = new Tea();
		Integer id=1;
		String title;
		LocalDate releaseDate= LocalDate.of(2020, 9, 13);
		Integer duration=2;
		Boolean valide = false;
		Integer nbrDispo = 2;
		
		tea.setId(id);
		tea.setReleaseDate(releaseDate);
		tea.setDuration(duration);
		tea.setValide(valide);
		tea.setNbrDispo(nbrDispo);
	
		//WHEN
		Tea result =  teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		

	} 
	
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionReleaseDateIsNull() throws Exception, FileNotFoundException  {
		//GIVEN
		Tea tea = new Tea();
		Integer id=1;
		String title="My new Tea";
		LocalDate releaseDate;
		Integer duration=2;
		Boolean valide = false;
		Integer nbrDispo = 2;
		
		tea.setId(id);
		tea.setTitle(title);
		tea.setDuration(duration);
		tea.setValide(valide);
		tea.setNbrDispo(nbrDispo);
	
		//WHEN
		Tea result =  teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		
	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionDurationIsNull() throws Exception, FileNotFoundException  {
		//GIVEN
		Tea tea = new Tea();
		Integer id=1;
		String title="My new Tea";
		LocalDate releaseDate= LocalDate.of(2020, 9, 13);
		Integer duration;
		Boolean valide = false;
		Integer nbrDispo = 2;
		
		tea.setId(id);
		tea.setTitle(title);
		tea.setReleaseDate(releaseDate);
		tea.setValide(valide);
		tea.setNbrDispo(nbrDispo);
	
		//WHEN
		Tea result =  teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		

	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionNbreDispoDateIsNull() throws Exception, FileNotFoundException  {
		//GIVEN
		Tea tea = new Tea();
		Integer id=1;
		String title="My new Tea";
		LocalDate releaseDate= LocalDate.of(2020, 9, 13);
		Integer duration=2;
		Boolean valide = false;
		Integer nbrDispo;
		
		tea.setId(id);
		tea.setTitle(title);
		tea.setDuration(duration);
		tea.setReleaseDate(releaseDate);
		tea.setValide(valide);

	
		//WHEN
		Tea result =  teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		
	} 
	
	
	
	

}
