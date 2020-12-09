package services;

import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import hei.project.siteInfoHei.Service.TeaServiceImpl;
import hei.project.siteInfoHei.dao.impl.TeaDaoImpl;
import hei.project.siteInfoHei.entities.Tea;



@RunWith(MockitoJUnitRunner.class) 
public class TeaServiceTestCase {


	@Mock
	private TeaDaoImpl teaDao;

	@InjectMocks
	private TeaServiceImpl teaService;


	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionTeaIsNull() throws IllegalArgumentException  {
		//GIVEN
		Tea tea = null;
	
		//WHEN
		teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		

	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionTitleIsNull() throws IllegalArgumentException {
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
		teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		

	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionTitleIsEmpty() throws IllegalArgumentException {
		//GIVEN
		Tea tea = new Tea();
		Integer id=1;
		String title="";
		LocalDate releaseDate= LocalDate.of(2020, 9, 13);
		Integer duration=2;
		Boolean valide = false;
		Integer nbrDispo = 2;
		
		tea.setId(id);
		tea.setTitle(title);
		tea.setReleaseDate(releaseDate);
		tea.setDuration(duration);
		tea.setValide(valide);
		tea.setNbrDispo(nbrDispo);
	
		//WHEN
		teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		

	} 
	
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionReleaseDateIsNull() throws IllegalArgumentException  {
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
		teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		
	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionDurationIsNull() throws IllegalArgumentException  {
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
		teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		

	} 
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionNbreDispoDateIsNull() throws IllegalArgumentException  {
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
		teaService.addTea(tea);

		//THEN
		fail("Should throw a IllegalArgumentException");
		
	} 
	
	@Test
	public void shouldCallAddTeaDao()   {
		//GIVEN
		Tea tea = new Tea();
		Integer id=1;
		String title="My new Tea";
		LocalDate releaseDate=LocalDate.of(2020, 9, 13);
		Integer duration=2;
		Boolean valide = false;
		Integer nbrDispo = 2;
		
		tea.setId(id);
		tea.setTitle(title);
		tea.setReleaseDate(releaseDate);
		tea.setDuration(duration);
		tea.setValide(valide);
		tea.setNbrDispo(nbrDispo);
	
		//WHEN
		teaService.addTea(tea);

		//THEN
		 Mockito.verify(teaDao,Mockito.times(1)).addTea(tea);
	} 
	
	
	
	
	

}
