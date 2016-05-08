<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>


	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Castello &amp; Fiori</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">Etusivu <span class="sr-only">(current)</span></a></li>
				<li><a href="./controller">Menú</a></li>
				<li><a href="yhteystiedot.jsp">Yhteystiedot</a></li>
				<c:choose>
					<c:when test="${ kayttaja.sahkoposti == 'admin@meduusa.fi' }">
						<li><a href="./adminController">Adminlista</a>
					</c:when>
					<c:otherwise>
						<li></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<!-- oikeenpuoliset linkit -->
			<ul class="nav navbar-nav navbar-right">


				<li><a href="ostoskori.jsp"><span
						class="glyphicon glyphicon-euro" aria-hidden="true"></span>
						Ostoskori</a></li>
				<c:choose>
					<c:when test="${empty kayttaja }">
						<button type="button" class="btn btn-info btn-lg nappi"
					data-toggle="modal" data-target="#myModal">Kirjaudu sisään</button>
					</c:when>

					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/Kirjautuminen?logout=true" class="btn btn-info btn-lg nappi">Kirjaudu
								ulos</a></li>
					</c:otherwise>
				</c:choose>
				

			</ul>
		</div>
	</div>
	</nav>

</body>
</html>