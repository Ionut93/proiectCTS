package ProiectJava.model;

public class Telefon {
	private int id;
	private int id_abonat;
	private int tip;
	private String numar;
	private int first;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_abonat() {
		return id_abonat;
	}
	public void setId_abonat(int id_abonat) {
		this.id_abonat = id_abonat;
	}
	public int getTip() {
		return tip;
	}
	public void setTip(int tip) {
		this.tip = tip;
	}
	public String getNumar() {
		return numar;
	}
	public void setNumar(String numar) {
		this.numar = numar;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public Telefon (int id_abonat, int tip, String numar, int first) {
		super();
		this.id_abonat = id_abonat;
		this.tip = tip;
		this.numar = numar;
		this.first = first;
	}
	public Telefon(){};
	public Telefon(String numar) {
		this.numar = numar;
	}
}