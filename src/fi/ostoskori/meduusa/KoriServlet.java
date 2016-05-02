package fi.ostoskori.meduusa;

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

//Testaus kommentti		

			String pizzaid = request.getParameter("id");
			String pizzanimi = request.getParameter("nimi");
			String pizzahinta = request.getParameter("hinta");
			String pizzamaara = request.getParameter("maara");
			
			String poista = request.getParameter("poista");

			// hae nykyinen httpsession jos ei ole tee uusi
			HttpSession session = request.getSession(false);
			if (session == null) {
				session = request.getSession(true);
			}
			
			
			if (pizzaid != null && pizzanimi != null && pizzahinta != null && pizzamaara != null) {
			ArrayList<KoriTuote> ostoskori = null;
			if (session.getAttribute("kori") == null) {
				ostoskori = new ArrayList<KoriTuote>();
			} else {
				ostoskori = (ArrayList<KoriTuote>) session.getAttribute("kori");
			}
			if (ostoskori == null) { // ei koria, tee yksi
				ostoskori = new ArrayList<KoriTuote>();
				KoriTuote korituote = new KoriTuote();
				String id = request.getParameter("tuote");
				korituote.setId(Integer.parseInt(id));
			}
			
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
						for (int j = 0; j < Integer.parseInt(pizzamaara); j++) {
							ostoskori.get(i).lisaaLukumaara();
						}
						pizzaloyty = true;
						i = ostoskori.size();
					}
				}
			}
			
			if (pizzaloyty == false) {

			KoriTuote uusituote = new KoriTuote(Integer.parseInt(pizzaid),
					pizzanimi, pizzahinta, Integer.parseInt(pizzamaara));

			ostoskori.add(uusituote);
			
			}
			
			// tuotteen poisto korista
			
			{
				KoriTuote tuote = new KoriTuote();
				if (tuote.getMaara() > 1) {
					tuote.vahennaLukumaaraa(-1);
				} else {
					KoriTuote.remove(tuote);
				}
			}
			
			//Yhteissumma
			
			

			session.setAttribute("kori", ostoskori); // Tallenna sessioon
			
			 // Sessionhallinta / kello
			 HttpSession sessio = request.getSession();
			 Date aloitusaika = new Date();
			 sessio.setAttribute("kello", aloitusaika);

			// Setataan lista-attribuutti
			 request.setAttribute("kori", ostoskori);
		
			 response.sendRedirect("koriservlet");
			
			}
			else if (poista != null) {
				RequestDispatcher rd = request
						 .getRequestDispatcher("ostoskori.jsp");
						 rd.forward(request, response);
			}
			else {
				 RequestDispatcher rd = request
						 .getRequestDispatcher("ostoskori.jsp");
						 rd.forward(request, response);
			}
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}
}
