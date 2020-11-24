package hei.project.siteInfoHei.managers;

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

		public Tea getTea(Integer id) {
			return teaDao.getTea(id);
		}

		public Tea getRandomTea() {
			return teaDao.getRandomTea();
		}
		public Tea addTea(Tea tea) {
			if(tea == null) {
				throw new IllegalArgumentException("The tea can not be null.");
			}
			if (tea.getTitle() == null || "".equals(tea.getTitle())) {
				throw new IllegalArgumentException("A tea must have a title.");
			}
			if (tea.getReleaseDate() == null) {
				throw new IllegalArgumentException("A tea must have a release date.");
			}

			if (tea.getDuration() == null) {
				throw new IllegalArgumentException("A tea must have a duration.");
			}
			if (tea.getValide() == null) {
				throw new IllegalArgumentException("A tea must have a disponible or not.");
			}
			return teaDao.addTea(tea);
		}

}
