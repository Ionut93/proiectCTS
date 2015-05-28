package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ProiectJava.connection.ConnectionBase;

public class TestCaseGetInstance {

	@Test
	public void testGetInstance() {
		assertNotEquals(ConnectionBase.getInstance(), null);
	}

}
