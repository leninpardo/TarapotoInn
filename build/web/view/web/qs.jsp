<%@page import="java.net.InetAddress"%>
<style>
.lex{
list-style:none
}
</style>
     <%
      
     InetAddress address = InetAddress.getLocalHost();
          String sHostName;
    sHostName = address.getCanonicalHostName();
    //out.print(sHostName);
    
    %>
    <div class="content" id="right_pad">
          <h2><img src="http://<%out.print(sHostName);%>:8080/script/images/title-nosotros.png" width="300" height="40" /></h2>
    </div>
	
	<div class="content" id="right_pad">	 
	   <p><img src="http://<%out.print(sHostName);%>:8080/script/images/hotel-tarapoto-inn.jpg" width="170" height="200" align="right" />El Hotel est&aacute; ubicado en la plaza de armas de Tarapoto, zona segura e iluminada, donde podr&aacute; encontrar tiendas, restaurants de todo tipo y precio, cabinas de Internet, tiendas de artesan&iacute;a, servicios de transporte y mucho m&aacute;s. Adem&aacute;s si busca entretenimiento muy cerca encontrar&aacute; discotecas, pubs, bares y pe&ntilde;as donde podr&aacute; pasar momentos agradables. </p>
	   <p>&nbsp;</p>
	   <p>Nuestro Hotel Tarapoto Inn, fue unos de los primeros hoteles de la Regi&oacute;n San Mart&iacute;n, con una ubicaci&oacute;n privilegiada y cercana a todo lo mejor que Tarapoto puede ofrecer siendo el m&aacute;s cercano a &nbsp;la Plaza de Armas Ha sido recientemente renovado y esta&nbsp; concebido para que el hospedado disponga de una estad&iacute;a c&oacute;moda, en pleno centro de la ciudad. </p>
	   <p>&nbsp;</p>
	   <p>Y se mejora constantemente con nuevo equipamiento e infraestructura hotelera.</p>
	   <p>&nbsp;</p>
	   <p><strong>Hemos pensado en tres factores que har&aacute;n de nuestro hotel su favorito.</strong></p>
	   <p>&nbsp;</p>
	   <ul>
	     <li class="lex">En primer lugar, un servicio&nbsp; de confort, limpio y seguro.&nbsp; Con los beneficios de las comunicaciones Internet y WI-FI, ubicado en el mejor lugar de la Plaza de Armas, rodeado de todas las empresas e instituciones mas importantes de la ciudad.&nbsp; En la noche podr&aacute; disfrutar de nuestra cafeter&iacute;a, bar, Internet o del casino ubicado en el primer piso.</li><br>
	     <li class="lex">En segundo lugar,&nbsp; que disponga de amplios ambientes de reuniones y posibilidad de traer a sus invitados o pasar un buen momento en nuestra nueva&nbsp;cafeter&iacute;a , piano bar, el cual har&aacute; programaciones en vivo los fines de semana. Dentro de&nbsp;los servicios hemos pensado &nbsp;tambi&eacute;n&nbsp; en un&nbsp;sal&oacute;n&nbsp;&nbsp;de mas de 100 personas de capacidad,&nbsp;para presentaciones y conferencias con equipo multimedia y excelentes equipos de sonido.</li><br>
	     <li class="lex">Y finalmente hemos pensado en&nbsp;su total econom&iacute;a, con tarifas que est&aacute;n casi a la mitad de precio de otros hoteles similares, que inclusive se ubican mucho mas distantes del centro de la ciudad.&nbsp; otorg&aacute;ndole Ahorro en tarifas, ahorro en movilidad, ahorro en tiempo y costo de servicios..</li><br>
        </ul>
	   <p>&nbsp;</p>
	   <p> En resumen esperamos la total satisfacci&oacute;n de nuestros alojados. </p>
	   <p>&nbsp;</p>
	</div>
