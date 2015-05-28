package ProiectJava.model;

import java.util.ArrayList;
import java.util.List;

public class Abonat {
	private int id;
	private String nume;
	private String prenume;
	private String cnp;
	private List<Telefon> listaTelefoane;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String string) {
		this.cnp = string;
	}
	public List<Telefon> getListaTelefoane() {
		return listaTelefoane;
	}
	public void setListaTelefoane(Telefon tel) {
		this.listaTelefoane.add(tel);
	}
	public Abonat(String nume, String prenume, String cnp) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.cnp = cnp;
		this.listaTelefoane = new ArrayList<Telefon>();
		
	}
	public Abonat() {
		this.listaTelefoane = new ArrayList<Telefon>();
	}
	
	
}
