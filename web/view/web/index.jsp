<%@page import="java.net.InetAddress"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<TITLE>Hotel Tarapoto Inn - El Hotel m&aacute;s Econ&oacute;mico y C&eacute;ntrico de Tarapoto</TITLE>
<META http-equiv=Content-Type content="text/html; charset=iso-8859-1">
<META content="Hotel Tarapoto Inn" name=description>
<META content="hotel, hospedaje, turismo, restaurant, tarapoto, alojamiento" name=keywords>
      <%
      
     InetAddress address = InetAddress.getLocalHost();
          String sHostName;
    sHostName = address.getCanonicalHostName();
    //out.print(sHostName);
   
        String userk=(String)(request.getSession().getAttribute("user"));
if(userk==null)
    {
      
  %>
<meta http-equiv="content-type" content="es-ES" />
<link href="http://<%out.print(sHostName);%>:8080/script/css/style.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="http://<%out.print(sHostName);%>:8080/script/images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="http://<%out.print(sHostName);%>:8080/script/css/banner.css" />
<link rel="stylesheet" href="http://<%out.print(sHostName);%>:8080/script/css/slide_panel.css" type="text/css" media="all">
<link rel="stylesheet" type="text/css" href="http://<%out.print(sHostName);%>:8080/script/css/jquery-ui-1.8.18.custom.css" />

<script type="text/javascript" src="http://<%out.print(sHostName);%>:8080/script/script/jquery.min.js"></script>
<script type="text/javascript" src="http://<%out.print(sHostName);%>:8080/script/script/jquery.js"></script>
<!-- Sliding effect -->	<script type="text/javascript" src="http://<%out.print(sHostName);%>:8080/script/script/slide.js" ></script>
<script type="text/javascript" src="http://<%out.print(sHostName);%>:8080/script/script/acac1.js"></script>	
<script type="text/javascript" src="http://<%out.print(sHostName);%>:8080/script/script/jquery-ui-1.8.18.custom.min.js"></script>	
<!--[if IE ]>
<link href="css/style-ie.css" rel="stylesheet" type="text/css" />
<![endif]-->
<!--[if IE 6]>
<link href="css/style-ie6.css" rel="stylesheet" type="text/css" />
<![endif]-->


<script type="text/javascript">
 function cargar(div,desde)
{	cargando='<div style="width:400px;height:50px"><br><br><br><b>Cargando...</b><br/><img src="images/loading.gif" width="16" height="16" /></div>';
document.getElementById("body_right").innerHTML =cargando;
$(div).load(desde);
}
</script>
</head>

<style>
.menucito{
height:30px;
background:#0b0b0b;
}
.menucito a{
color:#fff;
text-decoration:none;
}
.menucito:hover{
background:#2f8e32;
}
#fondo{
 background: none repeat scroll 0 0 #171614;
}
</style>


<body id="fondo">
  <!-- Panel -->
<div id="toppanel">
	<div id="panel">
		<div class="content clearfix">
			<div class="left">
			<h1>HOTEL TARAPOTO INN te da la Bienvenida</h1>
				<h2>Estimado usuario</h2>		
				<p class="grey" style="text-align:justify">El ingreso de sesión es solo para personas autorizadas.</p>
			</div>
			<div class="left">	
			<!-- Login Form -->
				<form class="clearfix" action="Login" method="get">
					<h1>Inicio de Sesión</h1>
					<label class="grey" for="log">Usuario:</label>
					<input class="field" type="text" name="user" id="user" value="" size="23" onKeyPress="validar_numero();" maxlength="8"/>
					<label class="grey" for="pwd">Password:</label>
					<input class="field" type="password" name="clave" id="clave" size="23" onChange="conMayusculas(this)"/>
	            	<label><input name="rememberme" id="rememberme" type="checkbox" checked="checked" value="forever" /> &nbsp;Recordarme</label>
        			<div class="clear"></div>
					<input type="submit" name="submit" value="Aceptar" class="bt_login" onclick="return validar();"/>
				</form>
			</div>
			<div class="left right">			
			<center><img src="http://<%out.print(sHostName);%>:8080/script/images/123.jpg"/></center>	
			</div>
</div>
</div> <!-- /login -->	

	<!-- The tab on top -->	
	<div class="tab">
		<ul class="login">
			<li class="left">&nbsp;</li>
			<li>Bienvenido</li>
			<li class="sep">|</li>
			<li id="toggle">
				<a id="open" class="open" href="#">Iniciar Sesion</a>
				<a id="close" style="display: none;" class="close" href="#">Cerrar Panel</a>		
			</li>
			<li class="right">&nbsp;</li>
		</ul> 
	</div> <!-- / top -->
	
</div> <!--panel -->
<div class="page">

<div id="header">
	<div id="header_logo"><a class="replace" id="logo" title="Hotel Tarapoto Inn"><span>&nbsp;</span>logo</a></div>

    <div class="clear"></div>
</div>

<div id="menu">
<table border="0" align="right" width="450" style="padding-top:15px;">
<thead>
<tr>
		<th class="menucito ui-corner-all">
		<a href="index">Inicio</a>
		</th>
		<th>&nbsp;</th>
		<th class="menucito ui-corner-all">
		<a href="JavaScript:cargar('#body_right','qs');">Nosotros</a>
		</th>
		<th>&nbsp;</th>
		<th class="menucito ui-corner-all">
		<a href="JavaScript:cargar('#body_right','servicio');">Servicios</a>
		</th>
		<th>&nbsp;</th>
		<th class="menucito ui-corner-all">
		<a href="JavaScript:cargar('#body_right','tarifa');">Tarifas</a>
		</th>
		<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
</tr>		
</thead>
</table>
  
</div>

<div id="banner">
<!--banner--->
<div id="wowslider-container1">
	<div class="ws_images"><ul>
<li><img src="http://<%out.print(sHostName);%>:8080/script/images/11.jpg" alt="siscomp" title="<strong>HOTEL TARAPOTO INN</strong>" id="wows1_0"/></li>
<li><img src="http://<%out.print(sHostName);%>:8080/script/images/33.jpg" alt="Banner2" title="" id="wows1_1"/></li>
<li><img src="http://<%out.print(sHostName);%>:8080/script/images/44.jpg" alt="Banner3" title="" id="wows1_2"/></li>
<li><img src="http://<%out.print(sHostName);%>:8080/script/images/22.jpg" alt="banner 4" title="" id="wows1_3"/></li>
<li><img src="http://<%out.print(sHostName);%>:8080/script/images/55.jpg" alt="banner 5" title="" id="wows1_4"/></li>
<li><img src="http://<%out.print(sHostName);%>:8080/script/images/66.jpg" alt="Banner6." title="" id="wows1_5"/></li>
<li><img src="http://<%out.print(sHostName);%>:8080/script/images/77.jpg" alt="Banner7." title="" id="wows1_5"/></li>
</ul></div>

	<div class="ws_shadow"></div>
	</div>
<script type="text/javascript" src="http://<%out.print(sHostName);%>:8080/script/script/wowslider.js"></script>
<script type="text/javascript" src="http://<%out.print(sHostName);%>:8080/script/script/script.js"></script>
 <!--banner--->
</div>

<div id="body">
    <div id="body_left">
	   <div id="left_pad">
	   <br><br><br>
	     <script>ac1init_doc('',1);</script>
		<br><br><br> <br><br><br>
	   </div> 
	</div> 			
		
	<div id="body_right">
	  <div id="right_pad">
        <img src="http://<%out.print(sHostName);%>:8080/script/images/title-bienvenidos.png" width="255" height="40" />	  </div>
	  <div id="right_pad">
        El Hotel Tarapoto Inn est&aacute estrat&eacutegicamente ubicado en el corazón de la ciudad de Tarapoto, especificamente en la Plaza de Armas. Zona de buena iluminacion, seguro y bajo ruido. La cercan&iacutea a los m&aacutes importantes atractivos tur&iacutesticos de la ciudad hace que los Turistas que visitan a nuestro hotel no tengan que hacer grandes movimientos dentro de la ciudad para poder disfrutar su estancia.
	  </div>
	  <div id="right_pad">
        <img src="http://<%out.print(sHostName);%>:8080/script/images/title-galeria-imagenes.png" width="300" height="40" />	  </div>
      <div id="right_pad">
        <table width="100%"  border="0" cellpadding="0" cellspacing="8">
            <tr>
              <td align="left"><a href="#"><img src="http://<%out.print(sHostName);%>:8080/script/images/banner-hotel.jpg" width="300" height="180" border="0"/></a></td>
              <td align="left"><a href="#"><img src="http://<%out.print(sHostName);%>:8080/script/images/banner-gastronomia.jpg" width="300" height="180" border="0" /></a></td>
            </tr>
	        <tr>
              <td align="left"><a href="#"><img src="http://<%out.print(sHostName);%>:8080/script/images/banner-catarata.jpg" width="300" height="180" border="0"/></a></td>
	          <td align="left"><a href="#"><img src="http://<%out.print(sHostName);%>:8080/script/images/banner-laguna.jpg" width="300" height="180" border="0"/></a></td>
          </tr>
          </table>
	  </div>		  
    </div>
	
    <div class="clear"></div>
</div>

<div class="clear"></div>
<div id="footer" >
  <div class="menu_foot"> <a href="index">Inicio</a> &nbsp; | &nbsp; <a href="#" onclick="cargar('#body_right', 'qs')">Nosotros</a> &nbsp; | &nbsp; <a href="#" onclick="cargar('#body_right', 'servicio')">Servicios</a> &nbsp; | &nbsp; <a href="#" onclick="cargar('#body_right', 'tarifa')">Tarifas</a></div>
  <div id="foot"> 
   <div id="foot_right">Desarrollado por: <a target="_blank">Alumnos del Curso de Diseño</a></div>
  </div>
</div>
</div>
</body>
</html>
<%
    }
else{
    response.sendRedirect("Sistema");
    
}
%>