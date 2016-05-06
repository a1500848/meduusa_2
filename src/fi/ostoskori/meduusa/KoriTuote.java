package fi.ostoskori.meduusa;

public class KoriTuote {
	private int id;
	private String nimi;
	private double hinta;
	private double summa;

	// Constructor
	public KoriTuote() {

	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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




	public double getSumma() {
		return summa;
	}



	public void setSumma(double summa) {
		this.summa = summa;
	}





	public static void remove(KoriTuote tuote) {

	}




	
}
