package fi.softala.meduusa;

import java.io.IOException;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import fi.DAOT.meduusa.PizzaDAO;


@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletRequest request;

	public ControllerServlet() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		java.io.PrintWriter wout = response.getWriter();

		// Tietokannasta pizzat
		PizzaDAO pDao = new PizzaDAO();
		pDao.avaaYhteys();
		ArrayList<Tuote> lista = pDao.haeTuotteet();
		ArrayList<Tayte> tayte = pDao.haeTaytteet();
		try {
			pDao.suljeYhteys();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		// Sessionhallinta / kello
		HttpSession sessio = request.getSession();
		Date aloitusaika = new Date();
		sessio.setAttribute("kello", aloitusaika);

		// Setataan lista-attribuutti
		request.setAttribute("lista", lista);
		request.setAttribute("taytteet", tayte);

		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/pizzalista.jsp");

		rd.forward(request, response);

		wout.close();
		
		

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PizzaDAO pDao = new PizzaDAO();
		
		String tayteNimi = request.getParameter("tayteNimi");
		String tuoteNimi = request.getParameter("tuoteNimi");
		String tuoteHinta = request.getParameter("tuoteHinta");
		String pizzataytePizzaid = request.getParameter("pizzataytePizzaid");
		String pizzatayteTayteid = request.getParameter("pizzatayteTayteid");
		
		if (tayteNimi != null) {
		Tayte tayte = new Tayte();
		tayte.setTaytenimi(tayteNimi);
		pDao.lisaaTayte(tayte);
		}
		
		if (tuoteNimi != null && tuoteHinta != null) {
		Tuote tuote = new Tuote();
		double hinta = Double.parseDouble(tuoteHinta);
		tuote.setNimi(tuoteNimi);
		tuote.setHinta(hinta);
		pDao.lisaaTuote(tuote);
		}
		
		if (pizzataytePizzaid != null && pizzatayteTayteid != null) {
			Pizzatayte pizzatayte = new Pizzatayte();
			
			pizzatayte.setPizzaid(pizzataytePizzaid);
			
			pizzatayte.setTayteid(pizzatayteTayteid);
			pDao.lisaaTaytteita(pizzatayte);
		}

	}

}
