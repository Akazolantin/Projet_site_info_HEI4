package hei.project.siteInfoHei.Service;

public class TeaAlreadyExistingException extends Exception  {
	public TeaAlreadyExistingException(String title) {
        super("Tea '"+title+"' already exists");
    }

}
