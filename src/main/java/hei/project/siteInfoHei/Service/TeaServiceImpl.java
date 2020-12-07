package hei.project.siteInfoHei.Service;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;



import hei.project.siteInfoHei.dao.impl.TeaDaoImpl;
import hei.project.siteInfoHei.entities.Tea;




public class TeaServiceImpl  {
	
	private final Logger LOG = LogManager.getLogger();
	
	private static class TeaLibraryHolder {
		private final static TeaServiceImpl instance = new TeaServiceImpl();
	}

		public static TeaServiceImpl getInstance() {
			return TeaLibraryHolder.instance;
		}
		
		private TeaDaoImpl teaDao = new TeaDaoImpl();
		
		private TeaServiceImpl() {
			
		}
		

		public Tea addTea(Tea tea)  {	    	
		    if(tea == null) {
				throw new IllegalArgumentException("Le TEA ne peut pas être nul.");
			}
			if (tea.getTitle() == null || "".equals(tea.getTitle())) {
				throw new IllegalArgumentException("Un TEA doit avoir un titre.");
			}
			if (tea.getReleaseDate() == null) {
				throw new IllegalArgumentException("Un TEA doit avoir une date.");
			}

			if (tea.getDuration() == null) {
				throw new IllegalArgumentException("Un TEA doit avoir une durée.");
			}
			
			if (tea.getNbrDispo() == null) {
				throw new IllegalArgumentException("Un TEA doit avoir un nombre de place disponible.");
			}
			
			return teaDao.addTea(tea);
		}

		

	
}
