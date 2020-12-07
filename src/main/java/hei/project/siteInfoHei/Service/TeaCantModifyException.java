package hei.project.siteInfoHei.Service;

public class TeaCantModifyException extends Exception {
		public TeaCantModifyException(String title) {
	        super("Tea '"+title+"' cannot modify");
	    }

	

}
