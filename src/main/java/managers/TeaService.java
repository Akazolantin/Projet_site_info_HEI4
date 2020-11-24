package managers;

import java.util.List;

import dao.TeaDaoImpl;
import entities.Tea;

import sitehei.dao.TeaDao;

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
				throw new IllegalArgumentException("A film must have a release date.");
			}

			if (tea.getDuration() == null) {
				throw new IllegalArgumentException("A film must have a duration.");
			}
			return teaDao.addTea(tea);
		}

}
