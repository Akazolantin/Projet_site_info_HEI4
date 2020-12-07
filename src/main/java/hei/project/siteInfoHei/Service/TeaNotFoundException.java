package hei.project.siteInfoHei.Service;

public class TeaNotFoundException extends Exception  {
	    public TeaNotFoundException(String title) {
	        super("Tea '"+title+"' does not exist");
	    }
	

}
