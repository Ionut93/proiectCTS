package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ProiectJava.connection.ConnectionBase;
import ProiectJava.dao.AbonatDao;
import ProiectJava.model.Abonat;

public class TestCaseLoadPersoane {

	
	@SuppressWarnings("deprecation")
	@Test
	public void testLoadPersoane() {
		ArrayList<Abonat> listaAbonati = new ArrayList<Abonat>();
		boolean b = ConnectionBase.getInstance().connectionValid("1234");
		if(b) {
			listaAbonati = (ArrayList<Abonat>) AbonatDao.loadPersoane(0, "");
			float max = AbonatDao.max();
			assertEquals(max, (float)listaAbonati.size(),0);
		}
		else
			fail("Failed");
	}


	

}
