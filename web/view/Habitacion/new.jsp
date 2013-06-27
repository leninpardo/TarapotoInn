<%-- 
    Document   : new
    Created on : 11/06/2013, 01:02:30 PM
    Author     : lenin
--%>

  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="/template/menu.jsp" %>

      <script>

$(document).ready(function(){
$( "#save" ).click(function(){
bval = true;
bval=bval && $("#tipo_habitacion").required();
bval=bval && $("#numero").required();
bval=bval && $("#costo").required();
bval = bval && $("#descripcion").required();

if ( bval ) {
$("#frm").submit();
}

return false;
});

});
</script>  
<br/>
<br/>
<div id="formulario" align="center"  class="span12">
    <div id="div_pequenos">
        <fieldset class="ui-corner-all">
            <legend class="fieldset">Nuevo ${url}</legend>
    <form action="<c:url value="/${url}?option=save"/>" method="post" class="simple_form form-horizontal" id="frm">
    
    <label>
        Codigo
    </label> 
        <input type="text" name="cod" value="${cod}" id="cod" readonly=""/>
    <label>
        Tipo habitacion
    </label> 
    <select name="tipo_habitacion" onselect="" id="tipo_habitacion">
        <optgroup title="" label="${url}">
            <c:forEach items="${th}" var="tiph">
                <option value="<c:out value="${tiph[0]}"></c:out>">
                    <c:out value="${tiph[1]}"></c:out>
                </option>
            </c:forEach>
        </optgroup>
    </select>
      <label>
        numero habitacion
    </label> 
        <input type="text" name="numero" value="${numero}" id="numero">
            
      <label>
        costo
    </label> 
        <input type="text" name="costo" value="${costo}" id="costo">
     <label>
        descripcion
    </label> 
        <input type="text" name="descripcion" value="${descripcion}"  id="descripcion">
                    <label>
                        
                    </label>
        <input type="submit" name="" value="Registrar${url}" class="btn" id="save">
</form>
  <div class="alert">${msg}</div>
</div>
        </fieldset>
</div>
<%@include  file="/template/pie.jsp" %>