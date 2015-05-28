package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ProiectJava.connection.ConnectionBase;

public class TestCaseConnectionValid {

	@Test
	public void testConnectionValid() {
		assertTrue(ConnectionBase.getInstance().connectionValid("1234"));
	}

}
