package util;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

	private List<Memento> salvari = new ArrayList<Memento>();
	
	public void addSalvare(Memento m) {
		this.salvari.add(m);
	}
	
	public Memento getSalvare() {
		if(salvari.size()!=0) {
			Memento m = salvari.get(salvari.size() - 1);
			salvari.remove(salvari.size() - 1);
			return m;
		}
		else {
			return null;
		}
	}
}
