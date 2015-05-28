package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ProiectJava.model.Abonat;

public class TestCaseSetPrenume {

	@Test
	public void test() {
		Abonat a = new Abonat();
		a.setPrenume("Mihai");
		assertEquals("Mihai", a.getPrenume());
	}

}
