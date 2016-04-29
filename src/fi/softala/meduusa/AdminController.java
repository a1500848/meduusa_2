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

@WebServlet("/adminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletRequest request;

	public AdminController() {

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		java.io.PrintWriter wout = response.getWriter();

		HttpSession sessio = request.getSession(false);

		if (sessio.getAttribute("kayttaja") != null) {

			Kayttaja kayttaja = (Kayttaja) sessio.getAttribute("kayttaja");

			if (kayttaja.sahkoposti.equals("admin@meduusa.fi")) {
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
				Date aloitusaika = new Date();
				sessio.setAttribute("kello", aloitusaika);

				// Setataan lista-attribuutti
				request.setAttribute("lista", lista);
				request.setAttribute("taytteet", tayte);

				RequestDispatcher rd = request
						.getRequestDispatcher("WEB-INF/adminlista.jsp");

				rd.forward(request, response);

				wout.close();
			}

			else {
				response.sendRedirect("controller");
			}

		} else {
			response.sendRedirect("controller");
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PizzaDAO pDao = new PizzaDAO();

		String action = request.getParameter("action");

		if (action != null && action.equals("lisaatayte")) {
			String tayteNimi = request.getParameter("tayteNimi");
			String tuoteNimi = request.getParameter("tuoteNimi");
			String tuoteHinta = request.getParameter("tuoteHinta");

			if (tayteNimi != null) {
				Tayte tayte = new Tayte();
				tayte.setTaytenimi(tayteNimi);
				pDao.lisaaTayte(tayte);
			}
		} else if (action != null && action.equals("lisaapizza")) {
			String tuoteNimi = request.getParameter("tuoteNimi");
			String tuoteHinta = request.getParameter("tuoteHinta");
			String[] taytteet = request.getParameterValues("tayteboksi");
			System.out.println("Pizzan nimi :" + tuoteNimi);
			System.out.println("Pizzan hinta :" + tuoteHinta);
			System.out.println("Pizzaan täytteitä :" + taytteet.length);
			if (taytteet != null) {
				for (int i = 0; i < taytteet.length; i++) {
					System.out.println(taytteet[i]);
				}
			}
			
			PizzaDAO dao = new PizzaDAO();
			
			Boolean onnistu = dao.lisaaTuote(tuoteNimi, tuoteHinta, taytteet);
			
			if (onnistu == true) {
				response.sendRedirect("adminController?pizzalisatty=true");
			}
			else {
				response.sendRedirect("adminController?pizzalisatty=false");
			}
			
			
			
		} else {
			doGet(request, response);
		}

	}

}
