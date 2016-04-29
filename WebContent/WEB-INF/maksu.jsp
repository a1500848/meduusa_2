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

<nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.html">Castello &amp; Fiori</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li><a href="index.html">Etusivu</a></li>
            <li class="active"><a href="./controller">Pizzalista <span class="sr-only">(current)</span></a></li>
            <li><a href="yhteystiedot.html">Yhteystiedot</a></li>
          </ul>
          <!-- oikeenpuoliset linkit -->
          <ul class="nav navbar-nav navbar-right">

            <li><a href="ostoskori.jsp"><span class="glyphicon glyphicon-euro" aria-hidden="true"></span> Ostoskori</a></li>
            <li><a href="login.html">Kirjaudu Sisään</a></li>

          </ul>
        </div>
      </div>
    </nav>



<div class="lista">
	<div class="container-fluid">
		<div class="row">
		      <div class="col-md-12">
		        <hr>
		        <h2 class="intro-text text-center">Tilauksen teko</h2>
		        <hr>
		        <form role="form" method="post">
		          <div class="row">
		            <div class="form-group col-lg-12">
		              <label>Nimi</label>
		              <input type='text' class="form-control" name='cust_nimi' />
		            </div>
		            <div class="form-group col-lg-12">
		              <label>Osoite</label>
		              <input type='text' class="form-control" name='cust_osoite' />
		            </div>
		            <div class="form-group col-lg-12">
		              <label>Postinumero</label>
		              <input type='text' class="form-control" name='cust_numero' />
		          	</div>
		          	 <div class="form-group col-lg-12">
		              <label>Sähköposti</label>
		              <input type='text' class="form-control" name='cust_sahkoposti' />
		          	</div>
		          	 <div class="form-group col-lg-12">
		              <label>Puhelin Numero</label>
		              <input type='text' class="form-control" name='cust_puhelin' />
		          	</div>
		          	
		          	
		          	<div style="background: #FFF;">
		          	<h2>Tilaus</h2>
		          	<table>
		          	

			<c:forEach items="${kori}" var="itemi">
				
				
		
		          		<tr>
		          			<th>Valitut tuotteet</th>
		          			<td>${itemi.nimi }</td>
		          		</tr>
		          			<tr>
		          			
		          			
		          			<th>Määrä</th>
		          			<td>${itemi.maara }</td>
		          			
		          			</tr>
		          		<tr>
		          			<th>${itemi.hinta }</th>
		          			<td>Yhteishinta</td>
		          		</tr>
		          				
			</c:forEach>
		          	</table>
		          	</div>
		          	
		          <div class="form-group col-lg-12">
		            <input type="hidden" name="save" value="contact">
		            <button type="submit" class="btn btn-default">Maksa tilaus</button>
		            
		            
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