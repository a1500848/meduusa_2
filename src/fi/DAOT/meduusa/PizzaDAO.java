package fi.DAOT.meduusa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import java.util.Iterator;

import kirjautumisShitit.Kysely;
import kirjautumisShitit.Paivitys;
import kirjautumisShitit.Yhteys;
import fi.softala.meduusa.Pizzatayte;
import fi.softala.meduusa.Tayte;
import fi.softala.meduusa.Tuote;

public class PizzaDAO {

	private Connection yhteys = null;

	public void avaaYhteys() {
		// TIETOKANTAHAKU

		String username = "a1500848";
		String password = "wiQEVw44m";
		String url = "jdbc:mariadb://localhost/a1500848";

		// YHTEYDEN AVAUS JA HAKU
		// ajurin lataus
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// avataan yhteys
		try {
			yhteys = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Tayte> haeTaytteet() {

		avaaYhteys();

		ArrayList<Tayte> taytet = new ArrayList<Tayte>();

		try {
			// suoritetaan haku
			String sql = "select * from tayte";
			Statement haku = yhteys.createStatement();
			ResultSet tulokset = haku.executeQuery(sql);

			// käydään hakutulokset läpi
			while (tulokset.next()) {
				int id = tulokset.getInt("tayteid");
				String nimi = tulokset.getString("taytenimi");

				// tulostetaan yksittäinen hakutulos responseen
				System.out.println(id + ". " + nimi);

				Tayte tayte = new Tayte();
				tayte.setTayteid(id);
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
		suljeYhteys();
		return taytet;
	}

	public void lisaaTayte(Tayte t) {

		// avataan yhteys
		avaaYhteys();

		try {

			// suoritetaan haku

			// alustetaan sql-lause
			String sql = "insert into tayte(taytenimi) values(?)";
			PreparedStatement lause = yhteys.prepareStatement(sql);

			// täytetään puuttuvat tiedot
			lause.setString(1, t.getTaytenimi());

			// suoritetaan lause
			lause.executeUpdate();
			System.out.println("LISÄTTIIN tayte TIETOKANTAAN: " + t);
		} catch (Exception e) {
			// JOTAIN VIRHETTÄ TAPAHTUI
			System.out.println("tapahtui virhe");
		} finally {
			// LOPULTA AINA SULJETAAN YHTEYS
			suljeYhteys();
		}
	}

	public void suljeYhteys() {
		try {
			yhteys.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Tuote> haeTuotteet() {

		ArrayList<Tuote> tuotteet = new ArrayList<Tuote>();

		try {

			// suoritetaan haku
			String sql = "SELECT pizzaid, p.nimi, hinta, t.tayteid, t.taytenimi AS tayte FROM pizzatayte pt JOIN pizzakoe p ON pt.pizzaid = p.id JOIN tayte t USING(tayteid) WHERE piilotus = 0";
			Statement haku = yhteys.createStatement();
			ResultSet resultset = haku.executeQuery(sql);
			
			// käydään hakutulokset läpi
			while (resultset.next()) {

				String tuoteId = resultset.getString("pizzaid");
				String tuoteNimi = resultset.getString("nimi");
				String tuoteHinta = resultset.getString("hinta");
				String tayteId = resultset.getString("tayteid");
				String tayte = resultset.getString("tayte");

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
					tuotteet.add(tuote);
				}

			}

		} catch (Exception e) {
			// JOTAIN VIRHEITÄ

		} finally {

		}

		return tuotteet;
	}
	public ArrayList<Tuote> adminHaeTuotteet() {

		ArrayList<Tuote> tuotteet = new ArrayList<Tuote>();

		try {

			// suoritetaan haku
			String sql = "SELECT pizzaid, p.nimi, hinta, t.tayteid, t.taytenimi AS tayte FROM pizzatayte pt JOIN pizzakoe p ON pt.pizzaid = p.id JOIN tayte t USING(tayteid)";
			Statement haku = yhteys.createStatement();
			ResultSet resultset = haku.executeQuery(sql);
			
			// käydään hakutulokset läpi
			while (resultset.next()) {

				String tuoteId = resultset.getString("pizzaid");
				String tuoteNimi = resultset.getString("nimi");
				String tuoteHinta = resultset.getString("hinta");
				String tayteId = resultset.getString("tayteid");
				String tayte = resultset.getString("tayte");

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
		avaaYhteys();

		try {

			// suoritetaan haku

			// alustetaan sql-lause
			String sql = "insert into pizzakoe(nimi, hinta) values(?,?)";
			PreparedStatement lause = yhteys.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// täytetään puuttuvat tiedot
			lause.setString(1, nimi);
			lause.setString(2, hinta);

			// suoritetaan lause
			lause.executeUpdate();
			
			ResultSet rs = lause.getGeneratedKeys();
			rs.next();
			int avain = rs.getInt(1);
			
			System.out.println("Avain: " + avain);
			
			ArrayList<String> parametrit = new ArrayList<String>();
			
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
		
			lause = yhteys.prepareStatement(sql);
			
			System.out.println(lause.toString());
			
			for (int i = 0; i < parametrit.size(); i++) {
				lause.setString((i+1), parametrit.get(i));
			}
			
			int onnistuks = lause.executeUpdate();
			
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
			suljeYhteys();
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

