package hei.project.siteInfoHei.dao;

import java.util.List;

import hei.project.siteInfoHei.entities.Tea;


public interface TeaDao {
	public List<Tea> listTea();

	public Tea getTea(Integer id);

	public Tea addTea(Tea tea);

	public Tea getRandomTea();

	

}
