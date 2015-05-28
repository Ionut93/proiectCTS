package util;

import ProiectJava.model.Abonat;
import ProiectJava.model.Telefon;


public class AbonatBuilder extends Abonat {
	private Abonat abonat;
	
	public AbonatBuilder(){
		abonat = new Abonat();
	}
	public AbonatBuilder adaugaNume(String nume){
		this.abonat.setNume(nume);
		return this;
	}
	public AbonatBuilder adaugaCnp(String cnp){
		this.abonat.setCnp(cnp);
		return this;
	}
	public AbonatBuilder adaugaPrenume(String prenume) {
		this.abonat.setPrenume(prenume);
		return this;
	}
	public AbonatBuilder adaugaTelefon(Telefon tel) {
		this.abonat.setListaTelefoane(tel);
		return this;
	}
	public Abonat build(){
		return this.abonat;
	}
}

