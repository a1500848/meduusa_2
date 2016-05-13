<%@ page import="java.util.List"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="fi.softala.meduusa.bean.Tuote"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>







<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta content="0; URL=./controller" />

<title>Pizzeria</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="meta/custom.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=PT+Sans+Narrow'
	rel='stylesheet' type='text/css'>
</head>




<body>

	<c:import url="/WEB-INF/navigaatio.jsp"></c:import>


	<div class="lista">
		<div class="container-fluid">
		<hr>
					<h2 class="intro-text text-center ostootsikko">Tilauksen teko</h2>
					<hr>
			<div class="row">
				<div class="col-md-6">
					
					<form role="form" method="post">
						<div class="row">
							<div class="form-group col-lg-12">
							
								<label >Nimi</label> <input type='text' class="form-control"
									name='cust_nimi'placeholder="Nimi" value="<c:if test="${not empty kayttaja }"><c:out value="${kayttaja.etunimi}"></c:out> <c:out value="${kayttaja.sukunimi}"></c:out></c:if>" />
							
							</div>
							<div class="form-group col-lg-12">
								<label>Osoite</label> <input type='text' class="form-control"
									name='cust_osoite'placeholder="Osoite" />
							</div>
							<div class="form-group col-lg-12">
								<label>Postinumero</label> <input type='text'
									class="form-control" name='cust_numero'placeholder="Postinumero" />
							</div>
							<div class="form-group col-lg-12">
								<label>Sähköposti</label> <input type='text'
									class="form-control" name='cust_sahkoposti' placeholder="Sähköposti" value="<c:out value="${kayttaja.sahkoposti}"></c:out>" />
							</div>
							<div class="form-group col-lg-12">
								<label>Puhelinnumero</label> <input type='text'
									class="form-control" name='cust_puhelin' placeholder="Puhelinnumero" value='<c:out value="${kayttaja.puhelin }"></c:out>'/>
							</div>
						</div>
</div>

<div class="col-md-6">
						<div class="tilaus">
<br>
						<table>

							
								<c:forEach items="${kori}" var="itemi">



									<tr>
										<th>Tuote</th>
										<td>${itemi.nimi }</td>
									</tr>

									<tr>
										<th>Hinta</th>
										<td>${itemi.hinta } &euro;</td>
									</tr>
									<tr><td colspan="2">&nbsp;</td></tr>

									

								</c:forEach>
								<c:choose>
								<c:when test="${not empty ostoskorisumma }">
								<tr>
								<th>Ostoskorin yhteishinta</th>
										<td>${ostoskorisumma } &euro;</td>
										

									</tr>
								</c:when>
								<c:otherwise>
								<td>Ostoskori on tyhjä</td>
								</c:otherwise>
								</c:choose>
						</table>
						<input type="checkbox" name="id" value="Käteinen"> Käteinen<BR>
				<input type="checkbox" name="id" value="Pankkikorti"> Pankkikortti<BR>
				<input type="checkbox" name="id" value="Verkkopankki"> Verkkopankki<BR>
				</div>


				




				<div class="form-group col-lg-12">
					<input type="hidden" name="save" value="contact">
					<button type="submit" class="btn btn-default jokunappi">Maksa tilaus</button>


				</div>
				</form>
			
		</div>
	</div>
	</div>
	</div>





	<!--Footer-->
	<div class="nav navbar-default navbar-fixed-bottom">
		<div class="container-fluid">
			<p class="pull-left">Copyright &amp; Meduusat</p>
			<div class="some pull-right">
				<a target="_blank" title="follow me on instagram"
					href="http://www.instagram.com/"><img
					alt="follow me on instagram"
					src="https://c866088.ssl.cf3.rackcdn.com/assets/instagram40x40.png"
					border=0></a> <a target="_blank" title="follow me on facebook"
					href="http://www.facebook.com/"><img
					alt="follow me on facebook"
					src="https://c866088.ssl.cf3.rackcdn.com/assets/facebook40x40.png"
					border=0></a> <a target="_blank" title="follow me on Twitter"
					href="http://www.twitter.com/"><img alt="follow me on twitter"
					src="https://c866088.ssl.cf3.rackcdn.com/assets/twiiter40x40.png"
					border=0></a>
			</div>
		</div>
	</div>

	<c:import url="/WEB-INF/modal.jsp"></c:import>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<script src="js/bootstrap.min.js"></script>

</body>

</html>
