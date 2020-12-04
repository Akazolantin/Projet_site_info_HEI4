package hei.project.siteInfoHei.dao;

import java.time.LocalDate;
import java.util.List;

import hei.project.siteInfoHei.entities.Tea;


public interface TeaDao {
	public List<Tea> listTea();

	public Tea getTea(int id);

	public Tea addTea(Tea tea);

	public Tea modifTea(int id, String title, LocalDate releaseDate, int duration, Boolean valide);

	

}
