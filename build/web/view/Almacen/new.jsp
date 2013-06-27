<%-- 
    Document   : new
    Created on : 11/06/2013, 01:02:30 PM
    Author     : lenin
--%>
  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="/template/menu.jsp" %>
<br/>  

      <script>

$(document).ready(function(){
$( "#save" ).click(function(){
bval = true;
bval = bval && $("#descripcion").required();

if ( bval ) {
$("#frm").submit();
}
return false;
});

});
</script>  
<br/>
<div id="formulario" align="center"  class="span12">
    <div id="div_pequenos">
        <fieldset class="ui-corner-all">
            <legend class="fieldset">Nuevo ${url}</legend>
            <form action="<c:url value="/${url}?option=save"/>" method="post" class="simple_form form-horizontal" id="frm">   
    
     <label>
        Codigo 
    </label> 
    <input type="text" name="cod" value="${cod}" readonly="">
      <label>
      Almacen
    </label> 
    <input type="text" name="descripcion" value="${descrip}" id="descripcion">
   <label>
       
   </label>
              
                    
    <input type="submit" name="save" id="save" value="Registrar ${url}" class="btn">
</form>
        </fieldset>
    </div>               <div class="alert">${msg}</div>
</div>

<%@include  file="/template/pie.jsp" %>