package fi.softala.meduusa.bean;

public class Kayttaja {
	int id;
	String tunnus;
	String etunimi;
	String sukunimi;
	String puhelin;
	String sahkoposti;
	
	public Kayttaja() {		
	}

	public Kayttaja(int id, String tunnus, String etunimi, String sukunimi,
			String puhelin, String sahkoposti, String salasana, String suola) {
		super();
		this.id = id;
		this.tunnus = tunnus;
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.puhelin = puhelin;
		this.sahkoposti = sahkoposti;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTunnus() {
		return tunnus;
	}

	public void setTunnus(String tunnus) {
		this.tunnus = tunnus;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getPuhelin() {
		return puhelin;
	}

	public void setPuhelin(String puhelin) {
		this.puhelin = puhelin;
	}

	public String getSahkoposti() {
		return sahkoposti;
	}

	public void setSahkoposti(String sahkoposti) {
		this.sahkoposti = sahkoposti;
	}


	@Override
	public String toString() {
		return "Kayttaja [id=" + id + ", tunnus=" + tunnus + ", etunimi="
				+ etunimi + ", sukunimi=" + sukunimi + ", puhelin=" + puhelin
				+ ", sahkoposti=" + sahkoposti + "]";
	}
	
	
}
