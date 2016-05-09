<%@ page import="java.util.List"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="fi.softala.meduusa.Tuote"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>






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
		<hr>
		<h3>Menú</h3>
		<hr>
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<c:forEach items="${lista}" var="Pizza">
						<div class="panel panel-default">


							<form action="koriservlet" method="get">
								<div class="panel-heading">
									<strong>${Pizza.nimi}</strong>
									
									<input type="hidden" name='tuote' value='${Pizza.id}'>
								
									<div class="lisaa">
										<input type="hidden" name="id" value="${Pizza.id }"> <input
											type="hidden" name="nimi" value="${Pizza.nimi }"> <input
											type="hidden" name="hinta" value="${Pizza.hinta }">
										<button type='submit' value='Lisää ostoskoriin'
											class="btn btn-success">Lisää</button>
									
									</div>
									<p>
										<fmt:formatNumber type="currency" currencySymbol="eur"
											value="${Pizza.hinta}" />
									</p>
								</div>
								<div class="panel-body">
									<c:forEach items="${Pizza.taytteet}" var="pizzantaytteet" varStatus="status">
 	${pizzantaytteet.taytenimi }<c:if test="${fn:length(Pizza.taytteet) > status.count }">, </c:if>
 	
 	</c:forEach>
								</div>
							</form>


						</div>
					</c:forEach>
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
							href="http://www.twitter.com/"><img
							alt="follow me on twitter"
							src="https://c866088.ssl.cf3.rackcdn.com/assets/twiiter40x40.png"
							border=0></a>
					</div>
				</div>
			</div>
			
			<c:import url="/WEB-INF/modal.jsp"></c:import>

			<div class="modal fade" id="tayte" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<p>Valitse Täyte</p>
						</div>
						<div class="modal-body">
							<c:forEach items="${taytteet }" var="tayte">
								<div class="checkbox-inline text-muted">
									<label><input type="checkbox" value="">${tayte.taytenimi }</label>
								</div>
							</c:forEach>
						</div>
						<div class="modal-footer">
							<a class="btn btn-success" data-dismiss="modal">Valitse</a> <a
								class="btn btn-default" data-dismiss="modal">Sulje</a>
						</div>
					</div>
				</div>
			</div>






			<script
				src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

			<script src="js/bootstrap.min.js"></script>
</body>

</html>