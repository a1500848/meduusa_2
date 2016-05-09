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
	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body>

	<c:import url="/WEB-INF/navigaatio.jsp"></c:import>



<div class="container ostoskori">
<c:choose>
								<c:when test="${empty kori}">
									<h1>Ostoskorisi on tyhjä</h1>
								</c:when>
								<c:otherwise>
								<c:forEach items="${kori}" var="itemi" varStatus="status">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Tuote</th>
							<th style="width:10%"></th>
							<th style="width:8%"></th>
							<th style="width:22%" class="text-center">Hinta</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td data-th="Tuote">
								<div class="row">
									<div class="col-sm-12">
										<h4 class="nomargin">${itemi.nimi }</h4>
									</div>
								</div>
							</td>
							<td data-th=""></td>
							<td data-th="">
							</td>
							<td data-th="Hinta" class="text-center"><fmt:formatNumber value="${itemi.hinta } " type="currency" currencySymbol="eur"/></td>
							<td class="actions" data-th="">
								<a href="?poista=${status.index }" class="btn btn-danger btn-sm">Poista</a>								
							</td>
						</tr>
					</tbody>
					</c:forEach>
					<tfoot>
						
						<tr>
							<td><a href="controller" class="btn btn-warning"><i class="fa fa-angle-left"></i> Jatka ostoksia</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong><p>Yhteishinta:</p><fmt:formatNumber value="${ostoskorisumma}" type="currency" currencySymbol="eur" /></strong></td>
							<td><a href="checkout" class="btn btn-success btn-block">Tilaukseen <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>
</c:otherwise>
</c:choose>


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