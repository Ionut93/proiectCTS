package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ProiectJava.model.Abonat;

public class TestCaseGetPrenume {

	@Test
	public void test() {
		Abonat a = new Abonat("George","Ion","1930105000000");
		assertEquals("Ion",a.getPrenume());
	}

}
