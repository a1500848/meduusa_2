package fi.softala.meduusa.ostoskori;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.*;

import javax.naming.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		KoriServlet kori = null;
		// hae ostoskori
		HttpSession session = request.getSession(false);

		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/maksu.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if (session == null) {
			out.println("<h3>Ostoskorisi on tyhj‰!</h3></body></html>");
		} else {

			String custNimi = request.getParameter("cust_nimi");
			boolean hasCustNimi = custNimi != null
					&& ((custNimi = custNimi.trim()).length() > 0);

			String custOsoite = request.getParameter("cust_osoite");
			boolean hasCustOsoite = custNimi != null
					&& ((custOsoite = custOsoite.trim()).length() > 0);

			String custNumero = request.getParameter("cust_numero");
			boolean hasCustNumero = custNimi != null
					&& ((custNumero = custNumero.trim()).length() > 0);

			String custSahkoposti = request.getParameter("cust_sahkoposti")
					.trim();
			boolean hasCustSahkoposti = custSahkoposti != null
					&& ((custSahkoposti = custSahkoposti.trim()).length() > 0);

			String custPuhelin = request.getParameter("cust_puhelin").trim();
			boolean hasCustPuhelin = custPuhelin != null
					&& ((custPuhelin = custPuhelin.trim()).length() > 0);

			// inputit
			if (!hasCustNimi) {

				out.println(" Lis‰‰ Oma nimesi");
				return;
			} else if (!hasCustOsoite || custOsoite.length() < 10) {
				out.println("Osoiteessa virhe!!!");
				return;
			} else if (!hasCustNumero || custNumero.length() != 5) {
				out.println("Postinumerossa viallinen m‰‰r‰ numeroita!");
				return;
			} else if (!hasCustSahkoposti
					|| (custSahkoposti.indexOf('@') == -1)) {
				out.println("S‰hkˆposti osoitteessa virhe! Tarkista, ett‰ on muodossa k‰ytt‰j‰@palvelin!");
				return;
			} else if (!hasCustPuhelin || custPuhelin.length() < 7) {
				out.println("Puhelin numerossa viallinen m‰‰r‰ numeorita!");
				return;
			
			}

		}

		RequestDispatcher rd = request
				.getRequestDispatcher("WEB-INF/tilausvahvistus.jsp");
		rd.forward(request, response);

	}
	}
