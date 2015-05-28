package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import ProiectJava.connection.ConnectionBase;
import ProiectJava.dao.AbonatDao;
import ProiectJava.model.Abonat;
import ProiectJava.model.Telefon;

public class TestCaseInserAbonat {

	@Test
	public void test() {
		Abonat a = new Abonat("Gigel", "Florica", "1930203031031");
		a.setListaTelefoane(new Telefon("0722334455"));
		boolean b = ConnectionBase.getInstance().connectionValid("1234");
		if(b) {
			int max1 = AbonatDao.max();
			AbonatDao.insert(a);
			int max2 = AbonatDao.max();
			assertTrue((max1 + 1) == max2);
		}
	}

}
