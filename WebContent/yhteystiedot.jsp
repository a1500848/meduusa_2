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

    <title>Pizzeria</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="meta/custom.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css'>

<title>Insert title here</title>
</head>

  <body>

<c:import url="/WEB-INF/navigaatio.jsp"></c:import>


<section class="stuff">
<div class="container-fluid">
  <div class="row">
    <div class="box">
      <div class="col-md-12">
        <hr>
        <h2 class="intro-text text-center">Yhteystiedot</h2>
        <hr>
      </div>
      <div class="col-md-8">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d5316.138580898406!2d24.45782545958479!3d60.99488706694511!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x468e5c42a583f8cb%3A0x400b551554bad30!2sH%C3%A4meenlinna!5e0!3m2!1sfi!2sfi!4v1456954600548" width="550" height="350" frameborder="0" style="border:0" allowfullscreen></iframe>
      </div>
      <div class="col-md-4">
        <p><strong>Phone:</strong> 0402134433</p>
        <p><strong>Email:</strong> name@example.com</p>
        <p><strong>Osoite:</strong> Hämeenlinna, Keskusta 33110</p>
      </div>
    </div>
  </div>
  <div class="box">
    <div class="row">
      <div class="col-md-12">
        <hr>
        <h2 class="intro-text text-center">Palaute</h2>
        <hr>
        <form role="form">
          <div class="row">
            <div class="form-group col-lg-4">
              <label>Nimi</label>
              <input type="text" class="form-control">
            </div>
            <div class="form-group col-lg-4">
              <label>Sähköposti</label>
              <input type="text" class="form-control">
            </div>
            <div class="form-group col-lg-4">
              <label>Puhelinnumero</label>
              <input type="text" class="form-control">
          </div>
          <div class="form-group col-lg-12">
            <label>Palaute</label>
            <textarea class="form-control" rows="6"></textarea>
          </div>
          <div class="form-group col-lg-12">
            <input type="hidden" name="save" value="contact">
            <button type="submit" class="btn btn-default">Lähetä</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
</section>





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