package fi.softala.meduusa.ostoskori;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.*;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import java.sql.Connection;

@WebServlet("/koriservlet")
public class KoriServlet extends HttpServlet {
	private Connection yhteys = null;
	private ServletRequest request;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Testaus kommentti

		String pizzaid = request.getParameter("id");
		String pizzanimi = request.getParameter("nimi");
		String pizzahinta = request.getParameter("hinta");

		String poista = request.getParameter("poista");

		// hae nykyinen httpsession jos ei ole tee uusi
		HttpSession session = request.getSession(true);

		ArrayList<KoriTuote> ostoskori = null;

		if (session.getAttribute("kori") == null) {
			ostoskori = new ArrayList<KoriTuote>();
		} else {
			ostoskori = (ArrayList<KoriTuote>) session.getAttribute("kori");
		}

		if (pizzaid != null && pizzanimi != null && pizzahinta != null) {
			KoriTuote korituote = new KoriTuote();
			String id = request.getParameter("tuote");
			korituote.setId(Integer.parseInt(id));
			korituote.setHinta(Double.parseDouble(pizzahinta));

			Boolean pizzaloyty = false;
			if (ostoskori.size() > 0) {
				for (int i = 0; i < ostoskori.size(); i++) {
					int tilausint = -1;
					try {
						tilausint = Integer.valueOf(pizzaid);
					} catch (Exception ex) {
						System.out.println("Virhe inttiä kääntäessä");
						return;
					}
					if (ostoskori.get(i).getId() == tilausint) {

						pizzaloyty = true;
						i = ostoskori.size();
					}
				}
			}

			if (pizzaloyty == false) {

				KoriTuote uusituote = new KoriTuote();
				uusituote.setHinta(Double.parseDouble(pizzahinta));
				uusituote.setNimi(pizzanimi);

				ostoskori.add(uusituote);
			}
			double summa = 0;
			for (int i = 0; i < ostoskori.size(); i++) {
				summa += ostoskori.get(i).getHinta();
			}

			// Setataan lista-attribuutti
			session.setAttribute("kori", ostoskori);
			session.setAttribute("ostoskorisumma", summa);
			request.setAttribute("kori", ostoskori);
			request.setAttribute("ostoskorisumma", summa);
			
			response.sendRedirect(request.getContextPath() + "/controller?" + pizzanimi + "_lisatty_koriin");

		} else if (poista != null) {
			// tuotteeen poisto

			System.out.println("Tultiin poistoon, poista = " + poista);
			
			System.out.println("Ennen poistoa:");
			for (int i = 0; i < ostoskori.size(); i++) {
				System.out.println(i + " - " + ostoskori.get(i).getNimi());
			}

			ostoskori.remove(Integer.parseInt(poista));
			
			System.out.println("Poiston jälkeen:");
			for (int i = 0; i < ostoskori.size(); i++) {
				System.out.println(i + " - " + ostoskori.get(i).getNimi());
			}
			double summa = 0;
			for (int i = 0; i < ostoskori.size(); i++) {
				summa += ostoskori.get(i).getHinta();
			}

			// Setataan lista-attribuutti
			session.setAttribute("kori", ostoskori);
			session.setAttribute("ostoskorisumma", summa);
			request.setAttribute("kori", ostoskori);
			request.setAttribute("ostoskorisumma", summa);
			
			response.sendRedirect(request.getContextPath() + "/koriservlet");
		}

		// Yhteissumma
		else {
		double summa = 0;
		for (int i = 0; i < ostoskori.size(); i++) {
			summa += ostoskori.get(i).getHinta();
		}

		// Setataan lista-attribuutti
		session.setAttribute("kori", ostoskori);
		session.setAttribute("ostoskorisumma", summa);
		request.setAttribute("kori", ostoskori);
		request.setAttribute("ostoskorisumma", summa);

		RequestDispatcher rd = request.getRequestDispatcher("ostoskori.jsp");
		//response.sendRedirect("koriservlet");
		rd.forward(request, response);

	}}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}
