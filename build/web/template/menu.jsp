<%-- 
    Document   : menu
    Created on : 04/06/2013, 09:35:33 AM
    Author     : lenin
--%>

<%@page import="java.net.InetAddress"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


     <%
      
     InetAddress addressm = InetAddress.getLocalHost();
          String sHostNamem;
    sHostNamem = addressm.getCanonicalHostName();
    //out.print(sHostName);   
  %>
   
  
  
  
  
 <link href="http://localhost:8080/script/cssfrm/tooltip.css" rel="stylesheet" type="text/css" />
         <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/js/tooltip.js"></script>
 
 

 
 
         <link href="http://<%out.print(sHostNamem);%>:8080/script/css/style.css" rel="stylesheet" type="text/css" />
       
   
     <link href="http://<%out.print(sHostNamem);%>:8080/script/bootstrap/css/bootstrap.css" rel="stylesheet">
        <link href="http://<%out.print(sHostNamem);%>:8080/script/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        
         <link href="http://<%out.print(sHostNamem);%>:8080/script/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
          <link href="http://<%out.print(sHostNamem);%>:8080/script/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
     
          <!--our js bootrap-->
           <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/bootstrap/js/bootstrap.js"></script>
           <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/bootstrap/js/bootstrap.min.js"></script>
             <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/bootstrap/js/bootstrap-dropdown.js"></script>
             
             <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/script/jquery.min.js"></script>
<script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/script/jquery.js"></script>
             <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/script/jquery-ui-1.8.18.custom.min.js"></script>
              <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/js/jquery.js"></script>
             <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/js/required.js"></script>

       <link href="http://<%out.print(sHostNamem);%>:8080/script/css/menu.css" rel="stylesheet">
         <link href="http://<%out.print(sHostNamem);%>:8080/script/menu/style.css" rel="stylesheet">
          <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/menu/jquery.js"></script>
          <script type="text/javascript" src="http://<%out.print(sHostNamem);%>:8080/script/menu/query.js"></script>
       
        <link href="http://<%out.print(sHostNamem);%>:8080/script/cssfrm/style.css" rel="stylesheet">
  <link href="http://<%out.print(sHostNamem);%>:8080/script/cssfrm/jquery-ui-1.8.18.custom.css" rel="stylesheet">
  
  



    <script>
      /*  stuHover = function() {
	var cssRule;
	var newSelector;
	for (var i = 0; i < document.styleSheets.length; i++)
		for (var x = 0; x < document.styleSheets[i].rules.length ; x++)
			{
			cssRule = document.styleSheets[i].rules[x];
			if (cssRule.selectorText.indexOf("LI:hover") != -1)
			{
				 newSelector = cssRule.selectorText.replace(/LI:hover/gi, "LI.iehover");
				document.styleSheets[i].addRule(newSelector , cssRule.style.cssText);
			}
		}
	var getElm = document.getElementById("nav").getElementsByTagName("LI");
	for (var i=0; i<getElm.length; i++) {
		getElm[i].onmouseover=function() {
			this.className+=" iehover";
		}
		getElm[i].onmouseout=function() {
			this.className=this.className.replace(new RegExp(" iehover\\b"), "");
		}
	}
}
if (window.attachEvent) window.attachEvent("onload", stuHover);*/
    </script>
   <title>Sistema Hotelero TarapotoINN</title>
       
    </head>
    <body>
        <div id="page" class="page"> 
       <div class="content">
            <section id="">
        <div class="navbar">
	<div class="navbar-inner" style=''>
    	<div class="container-fluid">
	     	<a class="brand" href="index">INICIO <span class='brand-plus' style='font-size:.7em; position:relative; top:-1px'>TARAPOTO INN</span></a>
			<ul class="nav">
                            <li class="divider-vertical online-only"></li>
				<li class='online-only'><a href="Config"></a></li>
				<li class="divider-vertical online-only"></li>
				<li class='online-only'><a href="">BD:</a></li>
				<li class="divider-vertical online-only"></li>
				<li class='online-only'><a href="/reports/index">Informes</a></li>
				<li class="divider-vertical online-only"></li>
				<li class='online-only'><a href="/help/index">Ayuda</a></li>
	    	</ul>
		<div class='pull-right login-status online-only'>
			  Hola, <strong><a href="/usuario/edit">
                                  <%  String user=(String)(request.getSession().getAttribute("user"));
                                  out.print(user);
                          %>
                              </a></strong> |
			  <a href="Logout" data-method="delete" rel="nofollow">Salir/Logout</a>
                         
		</div>
		<div class='pull-right'>
			<h5 class='badge badge-success' data-toggle="tooltip" data-placement='bottom' id='pending-count' style='line-height:20px' title='Status'>
                            Perfil:
                            <%
                            String cargo=(String)(request.getSession().getAttribute("perfil"));
                                  out.print(cargo);
                            %>
                        </h5>
			</div>

    </div>
  </div>
</div>
                          </section>                  

   
  <!---->
 <%@page  import=" model.Menu" %>
  
  <!---->        
   <!--<div class="main-nav" id="main-nav">
  <div class="menu-fixed">
    <div class="menu">
    <div class="zocalo1">
    <script type="text/javascript">eplAD4M("Zocalo1");</script>
</div><div class="zocalo2">
    <script type="text/javascript">eplAD4M("Zocalo2");</script>
</div>
    <em><a href="/"></a></em>
    <ul id="destacados-menu">
        
        <%
        /*
         String M[][];
        String SM[][];
        String idusuario=(String)(request.getSession().getAttribute("idusuario"));
         String idperfil=(String)(request.getSession().getAttribute("idperfil"));
         Menu m=new Menu();
         M=m.getMenu(idperfil);
         for(int i=0;i<M.length;i++)
             {
             out.print("<li class='economia'><a href='"+M[i][2]+"'>"+M[i][1]+"</a>");
             SM=m.getSubMenu(idperfil, M[i][0]);
             out.print("<div class='subcategorias' ><ul>");
             for(int j=0;j<SM.length;j++)
                 {
                 out.print("<li><a href='"+SM[j][2]+"'>"+SM[j][1]+"</a></li>");
                 }
             out.print("</ul><div class='clear'></div></div></li>");
             
             }*/
        
        %>

    </ul>
    </div>
  </div>
   </div>-->
        <br>
        <br>
        
       
         <div id="principal">
        
        <div id="div_menu-contenedor">
      <ul id="div_menu">
	  <div class="menuholder">
        <ul class="menu slide"> 
                 
            <%
           String M[][];
        String SM[][];
        String idusuario=(String)(request.getSession().getAttribute("idusuario"));
         String idperfil=(String)(request.getSession().getAttribute("idperfil"));
         Menu m=new Menu();
         M=m.query("vista_modulos where idperfil="+idperfil+" and acceso=0 and submodulo=0 order by idmodulo asc");
         for(int i=0;i<M.length;i++)
             {
             out.print("<li><a class='green' href='"+M[i][2]+"'>"+M[i][1]+"</a>");
             //SM=m.query(idperfil, M[i][0]);
             SM=m.query("vista_modulos where idperfil="+idperfil+" and submodulo="+M[i][0]+" and acceso=0 order by idmodulo asc");
             out.print("<div class='subs' >");
             for(int j=0;j<SM.length;j++)
                 {
                 out.print("<dl><dt><a href='"+SM[j][2]+"'>"+SM[j][1]+"</a></dt></dl>");
                 }
             out.print("</div></li>");
             }
            %>
             
          
        </ul>
        <div class="back"></div>
        <div class="shadow"></div>
      </div>
 </ul>