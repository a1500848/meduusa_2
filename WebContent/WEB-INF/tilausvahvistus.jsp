<%@ page import="java.util.List"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="fi.softala.meduusa.Tuote"%>
<%@ page import="java.util.ArrayList"%>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
    
    
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<meta  content="0; URL=./controller" />
	
    <title>Pizzeria</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="meta/custom.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css'>
</head>




<body>

<c:import url="/WEB-INF/navigaatio.jsp"></c:import>

<div class="lista">
	<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<h2>Tilausvahvistus</h2>
				</div>
				<div class="col-md-12">

					<h2><p>Tilauksen tiedot</p></h2><!-- Tähän kohtaan tulee tilauksen tiedot lisättynä javalla tietokannasta -->

      	<table>
		          	

			<c:forEach items="${kori}" var="itemi">
				
				
		
		          		<tr>
		          			<th>Tuotteet</th>
		          			<td>${itemi.nimi }</td>
		          		</tr>
		          		
		          		<tr>
		          			
		          			<td>Hinta</td>
		          			<th>${itemi.hinta }</th>
		          		
		          		</tr>
		          				
			</c:forEach>
		          	</table>



					<h2><p>Asiakkaan tiedot</p></h2>
					<table>
						<tr>
							<td>Asiakas nimi:</td>
							<td><% out.println(request.getParameter("cust_nimi")); %></td>
						</tr>
						<tr>
							<td>Asiakas osoite:</td>
							<td><% out.println(request.getParameter("cust_osoite")); %></td>
						</tr>
						<td>Asiakas postinumero:</td>
						<td><% out.println(request.getParameter("cust_numero")); %></td>
						</tr>
						<td>Asiakas sähköposti:</td>
						<td><% out.println(request.getParameter("cust_sahkoposti")); %></td>
						</tr>
						<tr>
							<td>Asiakas puhelinnumero:</td>
							<td><% out.println(request.getParameter("cust_puhelin")); %></td>
							
						</tr>
						<tr>
							<td>Maksutapa:</td>
							<td><%  String b=request.getParameter("maksu"); %></td>
						</tr>
					</table>


				</div>
				<div class="col-md-12">
					<h3>Kiitos tilauksesta!</h3>
				</div>
				<div class="col-md-12">
					<a href="index.jsp">Takaisin etusivulle</a>
				</div>
			</div>
		</div>
	</div>


    
  



<!--Footer-->
<div class="nav navbar-default navbar-fixed-bottom">
  <div class="container-fluid">
    <p class="pull-left">Copyright &amp; Meduusat</p>
    <div class="some pull-right">
      <a target="_blank" title="follow me on instagram" href="http://www.instagram.com/"><img alt="follow me on instagram" src="https://c866088.ssl.cf3.rackcdn.com/assets/instagram40x40.png" border=0></a>
      <a target="_blank" title="follow me on facebook" href="http://www.facebook.com/"><img alt="follow me on facebook" src="https://c866088.ssl.cf3.rackcdn.com/assets/facebook40x40.png" border=0></a>
      <a target="_blank" title="follow me on Twitter" href="http://www.twitter.com/"><img alt="follow me on twitter" src="https://c866088.ssl.cf3.rackcdn.com/assets/twiiter40x40.png" border=0></a>
    </div>
  </div>
</div>



    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <script src="js/bootstrap.min.js"></script>

</body>

</html>