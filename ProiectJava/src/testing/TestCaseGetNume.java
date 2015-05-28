package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ProiectJava.model.Abonat;

public class TestCaseGetNume {

	@Test
	public void test() {
		Abonat a = new Abonat("George","Ion","1930105000000");
		assertEquals("George",a.getNume());
	}

}
