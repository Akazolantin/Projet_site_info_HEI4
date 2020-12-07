package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import hei.project.siteInfoHei.Service.PasswordHash;

public class PasswordHashTest {
	
	@Test
	public void shouldHash() {
		//GIVEN
		String mdp = "Paturel";
		String hashMdp = "$argon2i$v=19$m=65536,t=22,p=1$+0I+XAJBRoSGkKczm/wzqA$mZv9qrL0Cm0rZ4BisBo6yArTa8hUstdWy06SLTV11SY";
		
		//WHEN
		String hash = PasswordHash.encrypt(mdp);
		
		//THEN
		assertEquals(hashMdp,hash);
	}
	
	@Test
	public void shouldVerify() {
		//GIVEN
		String  hash = "$argon2i$v=19$m=65536,t=22,p=1$+0I+XAJBRoSGkKczm/wzqA$mZv9qrL0Cm0rZ4BisBo6yArTa8hUstdWy06SLTV11SY";
		String mdp = "Paturel";
		
		//WHEN
		boolean check = PasswordHash.verify(hash, mdp);
		
		//THEN
		assertTrue(check);
	}
}
