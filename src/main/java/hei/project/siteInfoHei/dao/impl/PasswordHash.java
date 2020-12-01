package hei.project.siteInfoHei.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Helper;

public class PasswordHash extends DataSourceProvider{
	
	public static String encrypt(String Mdp) {
		Argon2 argon2 = Argon2Factory.create();
		String hash = argon2.hash(17, 65536, 1, Mdp);
		return hash;
		}
	}
