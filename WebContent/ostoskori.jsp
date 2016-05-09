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
</head>

<body>

	<c:import url="/WEB-INF/navigaatio.jsp"></c:import>


	<div class="stuff">
		<div class="container-fluid">
			<div class="row">
				<div class="box">
					<div class="col-md-12">
						<div class="ostoskori_yla">
							<c:choose>
								<c:when test="${empty kori}">
									<h1>Ostoskorisi on tyhjä</h1>
								</c:when>
								<c:otherwise>


									<c:forEach items="${kori}" var="itemi" varStatus="status">
										<div class="ostoskori">
											<h2>${itemi.nimi }</h2>
											<h3>Hinta: <fmt:formatNumber value="${itemi.hinta } " type="currency" currencySymbol="eur"/></h3><br> <br> <br> <a
												href="?poista=${status.index }">Poista</a> <br>
										</div>
										
									
								<br>
									</c:forEach>
										<h1><br>Yhteishinta:
								<fmt:formatNumber value="${ostoskorisumma}" type="currency" /></h1>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="ostoskori_ala">
							</br>
							<p></p>
							<h3>
								
								<br> <a href="checkout">Tilaukseen</a>
							</h3>



							<h3>
								<a href="controller">Hae lisää pizzoja</a>
							</h3>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>




	<!--Footer!-->
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