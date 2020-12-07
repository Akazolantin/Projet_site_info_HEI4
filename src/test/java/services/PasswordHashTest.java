package services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import hei.project.siteInfoHei.Service.PasswordHash;

public class PasswordHashTest {

	@Test
	public void shouldHash() {
		//GIVEN
		String mdp = "Desclodures";
		String hashMdp = "$argon2i$v=19$m=65536,t=22,p=";

		//WHEN
		String hash = PasswordHash.encrypt(mdp);

		//THEN
		for (int i=0;i<hashMdp.length();i++) {
			char j = hash.charAt(i);
			Assertions.assertThat(j==hashMdp.charAt(i));
		}
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
