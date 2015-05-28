package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ProiectJava.model.Abonat;

public class TestCaseSetNume {

	@Test
	public void test() {
		Abonat a = new Abonat();
		a.setNume("Ilie");
		assertEquals("Ilie", a.getNume());
	}

}
