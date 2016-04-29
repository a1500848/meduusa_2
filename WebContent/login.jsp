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

<title>Pizzeria</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="meta/custom.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=PT+Sans+Narrow'
	rel='stylesheet' type='text/css'>

<title>Insert title here</title>
</head>

<body>

	<c:import url="/WEB-INF/navigaatio.jsp"></c:import>

	<div class="stuff" id="loginModal">
		<div class="modal-header">

			<h3>Kirjaudu sisään</h3>
		</div>
		<div class="modal-body">
			<div class="well">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#login" data-toggle="tab">Kirjaudu</a></li>
					<li><a href="#create" data-toggle="tab">Rekisteröidy</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane active in" id="login">
						<form method="post" action="Kirjautuminen">
							<div id="legend">
								<legend class="">Kirjaudu</legend>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Sähköposti</label> <input
									type="email" class="form-control" name="sahkoposti"
									placeholder="Sähköposti">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Salasana</label> <input
									type="password" class="form-control" name="salasana"
									placeholder="Salasana">
							</div>
							<button type="submit" class="btn btn-default" name="action"
								value="Kirjaudu">Kirjaudu</button>
						</form>
					</div>

					<div class="tab-pane fade" id="create">
						<form method="post" action="rekisteroidy">
							<div id="legend">
								<legend class="">Rekisteröidy</legend>
							</div>
							<div class="form-group">
								<label for="name">Etunimi</label> <input type="name"
									class="form-control" name="enimi" placeholder="Etunimi">
							</div>
							<div class="form-group">
								<label for="name">Sukunimi</label> <input type="name"
									class="form-control" name="snimi" placeholder="Sukunimi">
							</div>
							<div class="form-group">
								<label for="email">Sähköposti</label> <input type="email"
									class="form-control" name="sahkoposti" placeholder="Sähköposti">
							</div>
							<div class="form-group">
								<label for="phone">Puhelin</label> <input type="phone"
									class="form-control" name="puhelin" placeholder="Puhelin">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Salasana</label> <input
									type="password" class="form-control" name="salasana"
									placeholder="Salasana">
							</div>
							<button type="submit" class="btn btn-default">Rekisteröidy</button>
							<button type="reset" class="btn btn-default">Tyhjennä</button>
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




		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
</body>


</html>