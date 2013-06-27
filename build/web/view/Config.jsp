<%-- 
    Document   : Config
    Created on : 06/06/2013, 12:07:06 AM
    Author     : lenin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 <%
        String userq=(String)(request.getSession().getAttribute("user"));
if(userq!=null)
    {
       %>
<%@include  file="../../template/menu.jsp" %>
<br><br>
<div id="formulario" align="center">
    <form action="Config/Writer" method=""  class="simple_form form-horizontal">
       configurando archivo .ini
       
       <label>Tip base de datos</label>
       <select name="tbd">
           <optgroup label="base datos">
             
               <option value="mysql">mysql</option>
               <option value="postgresql">postgres</option>
               <option value="sqlserver">sqlserver</option>
                <option value="oracle">oracle</option>
           </optgroup>
       </select>
        <label>Host:</label><input type="text" name="host" id="host"/>
         <label>Puerto:</label><input type="text" name="port" id="port"/>
           <label>Base datos:</label><input type="text" name="bd" id="bd"/>
                <label>Usuario:</label><input type="text" name="user" id="user"/>
                     <label>Clave:</label><input type="text" name="clave" id="clave"/>
           <label><input type="submit" name="ok" value="Guardar/save" class="btn"/></label>
    </form>
  <!---->


  
</div>
<%@include  file="../../template/pie.jsp" %>
<% 
}        else
            {
            response.sendRedirect("index");

        }%>