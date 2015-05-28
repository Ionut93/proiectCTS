package util;

import java.util.ArrayList;
import java.util.List;

import ProiectJava.model.Abonat;

public class Memento {
	
	private final List<Abonat> listaSalvare;
	
	public Memento (List<Abonat> listaSalvare) {
		this.listaSalvare = listaSalvare;
	}
	
	public List<Abonat> getMemento() {
		return this.listaSalvare;
	}
}
