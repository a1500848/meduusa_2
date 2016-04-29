package kirjautumisShitit;
import java.io.IOException;

import fi.softala.meduusa.*;
import fi.ostoskori.meduusa.*;
import fi.DAOT.meduusa.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fi.softala.meduusa.Kayttaja;
import fi.DAOT.meduusa.KayttajaDAO;


@WebServlet ("/Kirjautuminen")
public class KirjautumisController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public KirjautumisController() {
		super();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String action = req.getParameter("logout");
		
		if (action != null && action.equals("true")) {
			kirjauduUlos(req, res);
		}
		else {
		doPost(req, res);
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String action = req.getParameter("action");

		if (action != null && action.equals("Kirjaudu")) {
			kirjaudu(req, res);
		} else if (action != null && action.equals("logout")) {
			kirjauduUlos(req, res);
		}

		
	}
	public void kirjaudu(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		String sahkoposti = req.getParameter("sahkoposti");
		String salasana = req.getParameter("salasana");

		KayttajaDAO kayttajaDAO = new KayttajaDAO();
		Kayttaja kayttaja = kayttajaDAO.kirjaudu(sahkoposti, salasana);
		System.out.println(sahkoposti);
		if (kayttaja.getSahkoposti() != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("kayttaja", kayttaja);
			RequestDispatcher disp = req
					.getRequestDispatcher("loggedin.jsp");
			disp.forward(req, res);
		} else {
			req.setAttribute("virhe", "V‰‰r‰ tunnus tai salasana!");
			RequestDispatcher disp = req.getRequestDispatcher("index.jsp");
			disp.forward(req, res);
		}
	}
	private void kirjauduUlos(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.removeAttribute("kayttaja");
			session.invalidate();
			RequestDispatcher disp = req
					.getRequestDispatcher("loggedout.jsp");
			disp.forward(req, res);
		}
	}
}
