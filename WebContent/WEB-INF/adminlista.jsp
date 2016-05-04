<%@ page import="java.util.List"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="fi.softala.meduusa.Tuote"%>
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

<meta content="0; URL=./adminController" />

<title>Pizzeria</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="meta/custom.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=PT+Sans+Narrow'
	rel='stylesheet' type='text/css'>
</head>




<body>

	<c:import url="/WEB-INF/navigaatio.jsp"></c:import>





	<!--  Admin pizzalista -->
	<div class="lista">
		<hr>
		<h3>Ylläpitäjän pizzalista</h3>
		<hr>

		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<c:forEach items="${lista}" var="Pizza">
						<div class="panel panel-default">


							<form action="koriservlet" method="get">
								<div class="panel-heading">
									<strong>${Pizza.nimi}</strong>
									<p>
										<fmt:formatNumber type="currency" currencySymbol="eur"
											value="${Pizza.hinta}" />
									</p>
									<input type="hidden" name='tuote' value='${Pizza.id}'>
									<div class="checkbox-inline text-muted"></div>
									<div class="checkbox-inline text-muted"></div>
									</form>
									<form action="adminController" method="post">
									<div class="lisaaAdmin">
									<input type="hidden" name="id" value="${Pizza.id }">
										<button type='submit' value='piilotaPizza'
											class="btn btn-success" name="action">Piilota</button>
									</div>
									<div class="lisaaAdmin">
										<button type='submit' value='tuoPizza'
											class="btn btn-success" name="action">Näytä</button>
									</div>
								</div>

								<div class="panel-body">
									<c:forEach items="${Pizza.taytteet }" var="pizzantaytteet">
 	${pizzantaytteet.taytenimi }, </c:forEach>
								</div>
							</form>


						</div>
					</c:forEach>
				</div>
				<div class="col-md-6">
					<!-- Adminin täytteen lisäys tietokantaan kenttä -->
					<div class="panel-heading">
						<h2>
							<strong>Lisää täyte tietokantaan</strong>
						</h2>
					</div>
					<div class="panel-body">
						<form action="controller" method="Post">
							<input type="text" name="tayteNimi" placeholder="tayte" />

							<button type='submit' name="action" value="lisaatayte">Lähetä
								täytteen tiedot</button>
						</form>
					</div>

					<!-- Adminin pizzanlisäys kenttä -->

					<form method="post" action="adminController">
						<div class="panel-heading">
							<h2>
								<strong>Lisää pizza tietokantaan</strong>
							</h2>
						</div>
						<div class="panel-body">
							<input type="text" name="tuoteNimi" placeholder="Tuotteen nimi" />
							<br> <br> <input type="text" name="tuoteHinta"
								placeholder="Tuotteen hinta" /> <br></br>
							<button type='submit' name="action" value="lisaapizza">Lähetä
								tuotteen tiedot</button>
						</div>

						<!-- Adminin valitse täyte uuteen pizzaan kenttä -->
						<div class="panel-heading">
							<h2>
								<strong>Valitse täyte</strong>
							</h2>
						</div>
						<div class="panel-body">
							<c:forEach items="${taytteet }" var="tayte">
								<div class="checkbox-inline text-muted">
									<input type="checkbox" id="${tayte.tayteid }" name="tayteboksi"
										value="${tayte.tayteid }"><label
										for="${tayte.tayteid }">${tayte.taytenimi }</label>
								</div>
							</c:forEach>
							<br>
						</div>

					</form>

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