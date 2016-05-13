package fi.softala.meduusa.bean;

import java.util.ArrayList;

public class Tuote {

	int id;
	String nimi;
	double hinta;
	ArrayList<Tayte> taytteet;
	int piilotus;

	public Tuote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tuote(int id, String nimi, double hinta, ArrayList<Tayte> taytteet) {
		super();
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.taytteet = taytteet;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getPiilotus(){
		return piilotus;
	}
	public void setPiilotus(int piilotus){
		this.piilotus = piilotus;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public ArrayList<Tayte> getTaytteet() {
		return taytteet;
	}

	public void setTaytteet(ArrayList<Tayte> taytteet) {
		this.taytteet = taytteet;
	}

	@Override
	public String toString() {
		return "Tuote [id=" + id + ", nimi=" + nimi + ", hinta=" + hinta
				+ ", taytteet=" + taytteet + ", piilotus=" + piilotus + "]";
	}



}
