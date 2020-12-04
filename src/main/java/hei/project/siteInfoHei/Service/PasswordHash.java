package hei.project.siteInfoHei.Service;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import hei.project.siteInfoHei.dao.impl.DataSourceProvider;

public class PasswordHash extends DataSourceProvider{
	
	public static String encrypt(String Mdp) {
		Argon2 argon2 = Argon2Factory.create();
		String hash = argon2.hash(17, 65536, 1, Mdp);
		return hash;
		}
	
	public static boolean verify(String hash, String mdp) {
		Argon2 argon2 = Argon2Factory.create();
		return argon2.verify(hash, mdp);
	}
}
