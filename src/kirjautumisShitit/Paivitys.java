package kirjautumisShitit;

import kirjautumisShitit.Yhteys;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Sis�lt�� tietokannan tietojen muuttamisessa tarvittavat metodit.
 * 
 * @author Jukka Harju, Jukka Juslin
 */
public class Paivitys {
	private Connection yhteys;

	public Paivitys(Connection avattuYhteys) {
		yhteys = avattuYhteys;
	}

	/**
	 * Suorittaa INSERT-, UPDATE- sek� DELETE-lauseet.
	 * 
	 * @param sqlLause
	 *            Suoritettava SQL-lause.
	 * @param parametrit
	 *            SQL-lauseen parametrit prepared statementsia varten. Voi olla
	 *            my�s monimuotoinen ArrayLista.
	 * @return tulokset N, riippuen monelleko riville muutoksia tehtiin, muutoin
	 *         0.
	 */
	public int suoritaSqlLauseParametreilla(String sqlLause,
			ArrayList<String> parametrit) {
		int tulokset = 0;

		try {
			PreparedStatement valmisteltuLause = yhteys
					.prepareStatement(sqlLause);
			for (int i = 0; i < parametrit.size(); i++) {
				valmisteltuLause.setObject(i + 1, parametrit.get(i));
			}

			System.out.println(valmisteltuLause);
			tulokset = valmisteltuLause.executeUpdate();
		} catch (SQLException ex) {
			Yhteys.kasitteleVirhe("Virhe kyselyn suorittamisessa.", ex);
		}
		return tulokset;
	}

	/**
	 * Suorittaa INSERT-, UPDATE- sekä DELETE-lauseet.
	 * 
	 * @param sqlLause
	 *            Suoritettava SQL-lause.
	 * @return suoritusOk true, mikäli lauseen suorittaminen onnistui, muutoin
	 *         false.
	 */
	public boolean suoritaSqlLause(String sqlLause) {
		boolean suoritusOk = true;
		Statement statement = null;

		try {
			statement = yhteys.createStatement();
			statement.executeUpdate(sqlLause);
		} catch (SQLException ex) {
			Yhteys.kasitteleVirhe("Virhe SQL-lauseen suorittamisessa.", ex);
			suoritusOk = false;
		} finally {
			try {
				statement.close();
			} catch (SQLException ex) {
				Yhteys.kasitteleVirhe("Virhe sulkemisessa.", ex);
			}
		}

		return suoritusOk;
	}
}
