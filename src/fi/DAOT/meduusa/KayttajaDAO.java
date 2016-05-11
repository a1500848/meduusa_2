package fi.DAOT.meduusa;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kirjautumisShitit.Kysely;
import kirjautumisShitit.Paivitys;
import kirjautumisShitit.Yhteys;
import kirjautumisShitit.Salaaja;
import fi.softala.meduusa.Kayttaja;


public class KayttajaDAO extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	public Kayttaja kirjaudu(String sahkoposti, String salasanaVepista) {

		Yhteys yhteys = new Yhteys();
		Kysely kysely = new Kysely(yhteys.getYhteys());

		// SELVITETÄÄN MIKÄ ON SALASANAN KRYPTATTY MUOTO
		String sqlsuola = "SELECT suola FROM kayttaja WHERE sahkoposti=?";
		ArrayList<String> parametrit = new ArrayList<String>();
		parametrit.add(sahkoposti);

		int maara = kysely.suoritaYksittainenKyselyParametreilla(sqlsuola, parametrit);
		
		if (maara < 1) {
			Kayttaja homokayttaja = new Kayttaja();
			homokayttaja.setSahkoposti(null);
			return homokayttaja;
		}
		
		ArrayList<HashMap<String, String>> tulosjoukko = kysely.getTulosjoukko();

		Iterator iter = kysely.getTulosjoukko().iterator();
		String suola = null;

		while (iter.hasNext()) {
			HashMap sahkopostiMap = (HashMap) iter.next();
			suola = (String) sahkopostiMap.get("suola");
		}

		// SELVITETÄÄN MIKÄ ON SALASANAN KRYPTATTY MUOTO
		Salaaja salaus = new Salaaja();
		String salasanaKryptattuna = null;
		try {
			salasanaKryptattuna = salaus.salaa(salasanaVepista, suola,
					"SHA-512", 500);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "SELECT * FROM kayttaja WHERE sahkoposti=? AND salasana=?";

		parametrit.add(salasanaKryptattuna);

		kysely.suoritaYksittainenKyselyParametreilla(sql, parametrit);
		tulosjoukko = kysely.getTulosjoukko();

		iter = kysely.getTulosjoukko().iterator();
		Kayttaja kayttaja = new Kayttaja();

		while (iter.hasNext()) {
			HashMap sahkopostiMap = (HashMap) iter.next();
			String sahkopostiKannasta = (String) sahkopostiMap
					.get("sahkoposti");
			String idString = (String) sahkopostiMap
					.get("id");
			String etunimiKannasta = (String) sahkopostiMap
					.get("etunimi");
			String sukunimiKannasta = (String) sahkopostiMap
					.get("sukunimi");
			String puhelinKannasta = (String) sahkopostiMap
					.get("puhelin");
			
			int id = Integer.parseInt(idString);
			kayttaja.setSahkoposti(sahkopostiKannasta);
			kayttaja.setId(id);
			kayttaja.setEtunimi(etunimiKannasta);
			kayttaja.setSukunimi(sukunimiKannasta);
			kayttaja.setPuhelin(puhelinKannasta);
			
		}
		yhteys.katkaise();

		return kayttaja;
	}
}