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
bval=bval && $("#modulo").required();
bval=bval && $("#urlm").required();
bval=bval && $("#padre").required();
bval = bval && $("#estado").required();

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
<div id="formulario" align="center">
    <form action="<c:url value="/${url}?option=save"/>" method="post" class="simple_form form-horizontal" id="frm">
    
    <label>
        Codigo
    </label> 
        <input type="text" name="cod" value="${cod}" id="cod" readonly=""/>
    <label>
       Modulo Padre
    </label> 
    <select name="padre" onselect="" id="padre">
        <option value="0">Ninguno</option>
            <c:forEach items="${padre}" var="ft">
                <option value="<c:out value="${ft[0]}"></c:out>">
                    <c:out value="${ft[1]}"></c:out>
                </option>
            </c:forEach>
       
    </select>
      <label>
        Modulo
    </label> 
        <input type="text" name="modulo" value="${modulo}" id="modulo">
            
      <label>
        url
    </label> 
        <input type="text" name="urlm" value="${urlm}" id="urlm">
     <label>
       Estado
    </label> 
     <select name="estado" id="estado">
         <option value="0">Activo</option>
           <option value="1">Inabilitado</option>
     </select>
                    <label>
                        
                    </label>
     <input type="submit" name="save" id="save" value="Registrar Modulo" class=" btn">
     
</form>
        </fieldset>
  <div class="alert">${msg}</div>
</div>
    </div>
        
<%@include  file="/template/pie.jsp" %>