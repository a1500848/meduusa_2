<%@ page import="java.util.List"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="fi.softala.meduusa.Tuote"%>
<%@ page import="java.util.ArrayList"%>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
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

    <script type="text/javascript">

    var image1=new Image()
    image1.src="img/pizza.jpg"
    var image2=new Image()
    image2.src="img/pizza2.jpg"
    var image3=new Image()
    image3.src="img/pizza3.jpg"

    </script>

<title>Insert title here</title>
</head>

 <body>

 <c:import url="/WEB-INF/navigaatio.jsp"></c:import>

    <div class="container">
      <div class="page-header">
        <h1>Castello &amp; Fiori</h1>
        <p>Parhaat pizzat koko maassa!</p>
      </div>
    </div>


<div class="main">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-12">
        <div class="slideshow">
          <img src="img/pizza.jpg" name="slide">
          <script type="text/javascript">

          var step=1
          function slideit(){
          document.images.slide.src=eval("image"+step+".src")
          if(step<3)
          step++
          else
          step=1
          setTimeout("slideit()",2500)
          }
          slideit()

          </script>
        </div>
        <h2> Tervetuloa Castello &amp; Fioriin!</h2>
        <p>Meiltä saat maan parhaat pizzat!</p>
      </div>
    </div>
  </div>
</div>






<!--Footer!-->
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