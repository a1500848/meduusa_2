package fi.ostoskori.meduusa;

public class KoriTuote {
	private int id;
	private String nimi;
	private String hinta;
	private static int maara;

	// Constructor
	public KoriTuote() {

	}

	// Constructor
	public KoriTuote(int id, String nimi, String hinta, int maara) {
		this.id = id;
		this.nimi = nimi;
		this.hinta = hinta;
		this.maara = maara;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public void setHinta(String hinta) {
		this.hinta = hinta;
	}

	public int getId() {
		return id;
	}

	public String getNimi() {
		return nimi;
	}

	public String getHinta() {
		return hinta;
	}

	public int getMaara() {
		return maara;
	}

	public void setMaara(int maara) {
		this.maara = maara;
	}

	public void vahennaLukumaara() {
		maara--;
	}
	public void lisaaLukumaara() {
		maara++;

	}
}
