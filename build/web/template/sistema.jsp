<%-- 
    Document   : sistema
    Created on : 01/06/2013, 08:45:07 PM
    Author     : lenin
--%>

     <%
      
     InetAddress addresss = InetAddress.getLocalHost();
          String sHostNames;
    sHostNames = addresss.getCanonicalHostName();
    //out.print(sHostName);   
  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Hotelero TarpotoINN</title>
		<style>
		#contenedor{
		width:1000px;
		height:auto;
		background:#f2f2f2;
		 margin: 0 auto;
		}
		#concepto{
		padding-top:80px;
		height:400px;
		text-align: justify;
		}
		#internos{
		width:700px;
		text-aling:justify;
		margin: 0 auto;
		font-size:11pt;
		}
		.content{
		background:white;
		}
		</style>
    </head>
    <body id="fondo">
    <div id="contenedor">
	
        <%  String userq=(String)(request.getSession().getAttribute("user"));
		if(userq!=null)
		{
       %> <%@include  file="menu.jsp" %>
        <div id="concepto">
		<div id="internos">
		<center>
		<img src="http://<% out.print(sHostNames); %>:8080/script/images/Bienvenido.jpg"/></center> <br><br>
		El Hotel Tarapoto Inn est&aacute estrat&eacute;gicamente ubicado en el coraz&oacuten de la ciudad de Tarapoto, especificamente en la Plaza de Armas. Zona de buena iluminacion, seguro y bajo ruido. La cercan&iacutea a los m&aacutes importantes atractivos tur&iacutesticos de la ciudad hace que los Turistas que visitan a nuestro hotel no tengan que hacer grandes movimientos dentro de la ciudad para poder disfrutar su estancia.<br><br>
        </div>
		</div>
         <%@include  file="pie.jsp" %>
         <%}
        else
            {
            response.sendRedirect("index");
        }
     
%>
</div>
    </body>
</html>
