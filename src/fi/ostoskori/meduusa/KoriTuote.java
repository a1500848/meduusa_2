package fi.ostoskori.meduusa;

public class KoriTuote {
	private int id;
	private String nimi;
	private double hinta;
	private static int maara;
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



	public static int getMaara() {
		return maara;
	}



	public static void setMaara(int maara) {
		KoriTuote.maara = maara;
	}



	public double getSumma() {
		return summa;
	}



	public void setSumma(double summa) {
		this.summa = summa;
	}



	public void vahennaLukumaaraa(int i) {
		maara--;

	}

	public static void remove(KoriTuote tuote) {

	}



	public void lisaaLukumaara() {
		
		
	}
	
}
