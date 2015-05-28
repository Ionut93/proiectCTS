package testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ProiectJava.connection.ConnectionBase;
import ProiectJava.dao.AbonatDao;
import ProiectJava.model.Abonat;

public class TestCaseGetAbonatById {

	@Test
	public void testGetAbonatById() {
		ArrayList<Abonat> listaAbonati = new ArrayList<Abonat>();
		boolean b = ConnectionBase.getInstance().connectionValid("1234");
		if(b) {
			listaAbonati = (ArrayList<Abonat>) AbonatDao.loadPersoane(0, "");
			Abonat a = AbonatDao.getAbonatById(listaAbonati.get(0).getId());
			assertEquals(listaAbonati.get(0).getId(), a.getId());
		}
		else
			fail("Failed");
	}
	

}
