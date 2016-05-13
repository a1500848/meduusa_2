package fi.softala.meduusa.daot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import java.util.HashMap;
import java.util.Iterator;

import fi.softala.meduusa.bean.Pizzatayte;
import fi.softala.meduusa.bean.Tayte;
import fi.softala.meduusa.bean.Tuote;
import fi.softala.meduusa.tietokanta.Kysely;
import fi.softala.meduusa.tietokanta.Paivitys;
import fi.softala.meduusa.tietokanta.Yhteys;

public class PizzaDAO {

	private Connection yhteys = null;

	

	public ArrayList<Tayte> haeTaytteet() {

		Yhteys yhteys = new Yhteys();

		ArrayList<Tayte> taytet = new ArrayList<Tayte>();

		try {
			// suoritetaan haku
			String sql = "select * from tayte";
			Kysely kysely = new Kysely(yhteys.getYhteys());
			kysely.suoritaYksittainenKysely(sql);
			
			ArrayList<HashMap> tulokset = kysely.getTulosjoukko();
			
			Iterator iterator = kysely.getTulosjoukko().iterator();

			// käydään hakutulokset läpi
			while (iterator.hasNext()) {
				HashMap map = (HashMap) iterator.next();
				String id = (String) map.get("tayteid");
				String nimi = (String) map.get("taytenimi");

				// tulostetaan yksittäinen hakutulos responseen
				System.out.println(id + ". " + nimi);

				Tayte tayte = new Tayte();
				tayte.setTayteid(Integer.parseInt(id));
				tayte.setTaytenimi(nimi);

				taytet.add(tayte);
			}

		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			e.printStackTrace();
			System.out
					.println("Tietokantahaku aiheutti virheen");
		} finally {

		}

		System.out
				.println("HAETTIIN TIETOKANNASTA tayte: " + taytet.toString());
		
		if (yhteys.getYhteys() != null) {yhteys.katkaise();}
		return taytet;
	}

	public void lisaaTayte(Tayte t) {

		// avataan yhteys
		Yhteys yhteys = new Yhteys();

		try {

			// suoritetaan haku

			// alustetaan sql-lause
			String sql = "insert into tayte(taytenimi) values(?)";
			ArrayList<String> parametrit = new ArrayList<String>();
			parametrit.add(t.getTaytenimi());
			Paivitys paivitys = new Paivitys(yhteys.getYhteys());
			paivitys.suoritaSqlLauseParametreilla(sql, parametrit);

			
			System.out.println("LISÄTTIIN tayte TIETOKANTAAN: " + t);
		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("tapahtui virhe");
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			if (yhteys.getYhteys() != null) {yhteys.katkaise();}
			}
	}


	public ArrayList<Tuote> haeTuotteet() {

		Yhteys yhteys = new Yhteys();
		ArrayList<Tuote> tuotteet = new ArrayList<Tuote>();

		try {

			// suoritetaan haku
			String sql = "SELECT pizzaid, p.nimi, hinta, t.tayteid, t.taytenimi FROM pizzatayte pt JOIN pizzakoe p ON pt.pizzaid = p.id JOIN tayte t USING(tayteid) WHERE piilotus = 0 ORDER BY nimi ASC;";
			Kysely kysely = new Kysely(yhteys.getYhteys());
			kysely.suoritaYksittainenKysely(sql);
			
			ArrayList<HashMap> tulokset = kysely.getTulosjoukko();
			
			Iterator iterator = kysely.getTulosjoukko().iterator();
			// käydään hakutulokset läpi
			while (iterator.hasNext()) {
				HashMap map = (HashMap) iterator.next();
				String tuoteId = (String) map.get("pizzaid");
				String tuoteNimi = (String) map.get("nimi");
				String tuoteHinta = (String) map.get("hinta");
				String tayteId = (String) map.get("tayteid");
				String tayte = (String) map.get("taytenimi");
				boolean pizzaloytyi = false;

				for (int i = 0; i < tuotteet.size(); i++) {
					if (tuotteet.get(i).getId() == Integer.parseInt(tuoteId)) {
						ArrayList<Tayte> pizzantaytteet = tuotteet.get(i)
								.getTaytteet();
						Tayte uusitayte = new Tayte(Integer.parseInt(tayteId),tayte);
						pizzantaytteet.add(uusitayte);
						tuotteet.get(i).setTaytteet(pizzantaytteet);
						pizzaloytyi = true;
						i = tuotteet.size();
					}
				}

				if (pizzaloytyi == false) {
					ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
					Tayte tayteolio = new Tayte(Integer.parseInt(tayteId),
							tayte);
					taytteet.add(tayteolio);
					Tuote tuote = new Tuote(Integer.parseInt(tuoteId),
							tuoteNimi, Double.parseDouble(tuoteHinta), taytteet);
					tuotteet.add(tuote);
				}

			}

		} catch (Exception e) {
			// JOTAIN VIRHEITÄ

		} finally {

		}
		if (yhteys.getYhteys() != null) {yhteys.katkaise();}
		return tuotteet;
	}
	public ArrayList<Tuote> adminHaeTuotteet() {

		Yhteys yhteys = new Yhteys();
		ArrayList<Tuote> tuotteet = new ArrayList<Tuote>();

		try {

			// suoritetaan haku
			String sql = "SELECT pizzaid, p.nimi, hinta, t.tayteid, t.taytenimi AS tayte, p.piilotus FROM pizzatayte pt JOIN pizzakoe p ON pt.pizzaid = p.id JOIN tayte t USING(tayteid) ORDER BY nimi ASC";
			Kysely kysely = new Kysely(yhteys.getYhteys());
			kysely.suoritaYksittainenKysely(sql);
			
			ArrayList<HashMap> tulokset = kysely.getTulosjoukko();
			
			Iterator iterator = kysely.getTulosjoukko().iterator();
			// käydään hakutulokset läpi

				while (iterator.hasNext()) {
					HashMap map = (HashMap) iterator.next();
					String tuoteId = (String) map.get("pizzaid");
					String tuoteNimi = (String) map.get("nimi");
					String tuoteHinta = (String) map.get("hinta");
					String tayteId = (String) map.get("tayteid");
					String tayte = (String) map.get("taytenimi");
					String piilotus = (String) map.get("piilotus");
					boolean pizzaloytyi = false;
				

				

				for (int i = 0; i < tuotteet.size(); i++) {
					if (tuotteet.get(i).getId() == Integer.parseInt(tuoteId)) {
						ArrayList<Tayte> pizzantaytteet = tuotteet.get(i)
								.getTaytteet();
						Tayte uusitayte = new Tayte(Integer.parseInt(tayteId),
								tayte);
						pizzantaytteet.add(uusitayte);
						tuotteet.get(i).setTaytteet(pizzantaytteet);
						pizzaloytyi = true;
						i = tuotteet.size();
					}
				}

				if (pizzaloytyi == false) {
					ArrayList<Tayte> taytteet = new ArrayList<Tayte>();
					Tayte tayteolio = new Tayte(Integer.parseInt(tayteId),
							tayte);
					taytteet.add(tayteolio);
					Tuote tuote = new Tuote(Integer.parseInt(tuoteId),
							tuoteNimi, Double.parseDouble(tuoteHinta), taytteet);
					int piilo = 0;
					if (piilotus != null && Integer.parseInt(piilotus) == 1) {
						piilo = 1;
					}
					else if (piilotus == null) {
						piilo = 2;
					}
					tuote.setPiilotus(piilo);
					tuotteet.add(tuote);
				}

			}

		} catch (Exception e) {
			// JOTAIN VIRHEITÄ

		} finally {

		}

		return tuotteet;
	}
	public boolean lisaaTuote(String nimi, String hinta, String[] taytteet) {
		// avataan yhteys
		Yhteys yhteys = new Yhteys();

		try {

			// suoritetaan haku

			// alustetaan sql-lause
			String sql = "insert into pizzakoe(nimi, hinta) values(?,?)";
			ArrayList<String> parametrit = new ArrayList<String>();
			parametrit.add(nimi);
			parametrit.add(hinta);
			Paivitys paivitys = new Paivitys(yhteys.getYhteys());
			int avain = paivitys.suoritaSqlParametreillaPalautaAvaimetOstoskoriin(sql, parametrit);
	

			// täytetään puuttuvat tiedot
			
			System.out.println("Avain: " + avain);
			parametrit.clear();
			
			// pizzatäytteiden lisäys
			for (int i = 0; i < taytteet.length; i++) {
				if (i == 0) {
				sql = "insert into pizzatayte(pizzaid, tayteid) values (?, ?)";
				}
				else {
					sql += ", (?, ?)";
				}
				parametrit.add(String.valueOf(avain));
				parametrit.add(String.valueOf(taytteet[i]));
			}
		
			int onnistuks = paivitys.suoritaSqlLauseParametreilla(sql, parametrit);
		
			

			
			System.out.println("Palautti " + onnistuks);
			
			if (onnistuks == taytteet.length) {
				System.out.println("Jee pizzan lisäys onnistu");
				return true;
			}
			else {
				return false;
			}
			
			
		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("tapahtui virhe");
			System.out.println(e);
			return false;
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			if (yhteys.getYhteys() != null) {yhteys.katkaise();}
		}
		
		
		
	}
	public void piilotaTuote(int id){
		try {
			
			Yhteys yhteys = new Yhteys();
			Paivitys paivitys = new Paivitys(yhteys.getYhteys());
			
			// suoritetaan haku
			String sql = "UPDATE pizzakoe SET piilotus = '1'  WHERE id = ?;";

			ArrayList<String> parametrit = new ArrayList<String>();
			parametrit.add(String.valueOf(id));

			// käydään hakutulokset läpi
			
			int i = paivitys.suoritaSqlLauseParametreilla(sql, parametrit);
			if (i > 0) {
				System.out.println("onnistu piilotus");
			} else {
				System.out.println("ei onnistunu piiloltus");
			}

			
			

		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			e.printStackTrace();
			System.out
					.println("Tietokantahaku aiheutti virheen");
		} finally {

		}
		
	}
	
	public void tuoTuote(int id){
		try {
			
			Yhteys yhteys = new Yhteys();
			Paivitys paivitys = new Paivitys(yhteys.getYhteys());
			
			// suoritetaan haku
			String sql = "UPDATE pizzakoe SET piilotus = '0'  WHERE id = ?;";

			ArrayList<String> parametrit = new ArrayList<String>();
			parametrit.add(String.valueOf(id));

			// käydään hakutulokset läpi
			
			int i = paivitys.suoritaSqlLauseParametreilla(sql, parametrit);
			if (i > 0) {
				System.out.println("onnistu tuominen");
			} else {
				System.out.println("ei onnistunu tuominen");
			}

			
			

		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			e.printStackTrace();
			System.out
					.println("Tietokantahaku aiheutti virheen");
		} finally {

		}
	}}

