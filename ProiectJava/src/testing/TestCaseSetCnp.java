package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ProiectJava.model.Abonat;

public class TestCaseSetCnp {

	@Test
	public void testSetCnp() {
		Abonat a = new Abonat();
		a.setCnp("1930105000000");
		assertEquals("1930105000000", a.getCnp());
	}

}
