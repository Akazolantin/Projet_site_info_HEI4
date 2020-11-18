package entities;

import java.time.LocalDate;

public class Tea {

		private Integer id;
		private String title;
		private LocalDate releaseDate;
		private Integer duration;
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public LocalDate getReleaseDate() {
			return releaseDate;
		}

		public void setReleaseDate(LocalDate releaseDate) {
			this.releaseDate = releaseDate;
		}

		public Integer getDuration() {
			return duration;
		}

		public void setDuration(Integer duration) {
			this.duration = duration;
		}

	

		public Tea(Integer id, String title, LocalDate releaseDate, Integer duration) {
			super();
			this.id = id;
			this.title = title;
			this.releaseDate = releaseDate;
			this.duration = duration;
			
		}


		

	}
