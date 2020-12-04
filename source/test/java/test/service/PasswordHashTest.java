package hei.project.siteInfoHei.testEntities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordHashTest {
	
	@Test
	public void shouldHash() {
		//GIVEN
		String mdp = "Paturel";
		String hashMdp = "$argon2i$v=19$m=65536,t=22,p=1$+0I+XAJBRoSGkKczm/wzqA$mZv9qrL0Cm0rZ4BisBo6yArTa8hUstdWy06SLTV11SY";
		
		//WHEN
		Argon2 argon2 = Argon2Factory.create();
		String hash = argon2.hash(17, 65536, 1, mdp);
		
		//THEN
		assertEquals(hashMdp,hash);
	}
}
