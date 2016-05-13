package fi.softala.meduusa.tietokanta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Yhteys {
	private Connection yhteys;

    public Yhteys() {
        avaaYhteys();
    }

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
	 public void katkaise() {
	        try {
	            yhteys.close();
	        } catch (SQLException ex) {
	            kasitteleVirhe(
	                "Virhe tietokantayhteyden sulkemisessa", ex);
	        }
	    }

	    public Connection getYhteys() {
	        if (yhteys == null) {
	            avaaYhteys();
	        }

	        return yhteys;
	    }
	    public static void kasitteleVirhe(
	            String selite, SQLException ex) {
	            System.out.println(selite);
	            System.out.println("Message:   " + ex.getMessage());
	            System.out.println("SQLState:  " + ex.getSQLState());
	            System.out.println("ErrorCode: " + ex.getErrorCode());
	        }
}
