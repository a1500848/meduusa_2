package kirjautumisShitit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rekisteroidy")
public class RegisterController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String sahkoposti = request.getParameter("sahkoposti");
		String salasana = request.getParameter("salasana");
		String etunimi = request.getParameter("enimi");
		String sukunimi = request.getParameter("snimi");
		String puhelin = request.getParameter("puhelin");

		Salaaja salaaja = new Salaaja();

		try {
			Yhteys yhteys = new Yhteys();

			Paivitys paivitys = new Paivitys(yhteys.getYhteys());
			Kysely kysely = new Kysely(yhteys.getYhteys());

			String sql = "select sahkoposti from kayttaja where sahkoposti = ?";
			ArrayList<String> parametrit = new ArrayList<String>();
			parametrit.add(sahkoposti);
			
			int i = kysely.suoritaYksittainenKyselyParametreilla(sql, parametrit); 
			if (i > 0) {
				response.sendRedirect("loginfail.jsp");
			} else {
				
			

			String suola = salaaja.generoiSuola();
			String passuhash = salaaja.salaa(salasana, suola, "SHA-512", 500);

			
			sql = "insert into kayttaja values(null,?,?,?,?,?,?)";

			parametrit = new ArrayList<String>();
			parametrit.clear();
		
			parametrit.add(etunimi);
			parametrit.add(sukunimi);
			parametrit.add(puhelin);
			parametrit.add(sahkoposti);
			parametrit.add(passuhash);
			parametrit.add(suola);

			i = paivitys.suoritaSqlLauseParametreilla(sql, parametrit);
			if (i > 0) {
				response.sendRedirect("rekisterointi.jsp");
			} else {
				System.out.print("Rekisteröinti epäonnistui");
			}
			
		}

		} catch (Exception e2) {
			System.out.println(e2);
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
