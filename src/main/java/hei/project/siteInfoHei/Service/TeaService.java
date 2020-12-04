package hei.project.siteInfoHei.Service;

import java.time.LocalDate;
import java.util.List;

import hei.project.siteInfoHei.dao.TeaDao;
import hei.project.siteInfoHei.dao.impl.TeaDaoImpl;
import hei.project.siteInfoHei.entities.Tea;

public class TeaService {

		private static class TeaLibraryHolder {
			private final static TeaService instance = new TeaService();
		}

		public static TeaService getInstance() {
			return TeaLibraryHolder.instance;
		}

		private TeaDao teaDao = new TeaDaoImpl();


		private TeaService() {
		}

		public List<Tea> listTea() {
			return teaDao.listTea();
		}

		public Tea getTea(int id) {
			return teaDao.getTea(id);
		}
		
		public Tea modifTea(int id,String title,LocalDate releaseDate, int duration,Boolean valide) {
			return teaDao.modifTea(id,title,releaseDate, duration,valide);
		}
		
		

		public Tea addTea(Tea tea) {
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
