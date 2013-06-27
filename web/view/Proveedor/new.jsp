<%-- 
    Document   : new
    Created on : 16-jun-2013, 21:02:13
    Author     : Fredesvinda
--%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="/template/menu.jsp" %>
<br/>  
<style>
.titulo_form{
     background-color: #5BB75B;
    background-image: linear-gradient(to bottom, #62C462, #51A351);
    background-repeat: repeat-x;
    border-color: rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.1) rgba(0, 0, 0, 0.25);
    color: #FFFFFF;
    height: 25px;
    padding-top: 10px;
    text-align: center;
    text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.25);
}
</style>
<script type="text/javascript">
    $(document).ready(function()
	{
                $("#save").click(function(){
bval = true;
bval = bval && $("#rz").required();

if ( bval ) {
$("#frm").submit();
}
return false;
});
	    $("#departamento").change(function()
		{
            vv = $(this).val();
			vv = vv.substring(0,2); 	
			$("#provincia").empty();
			$("#distrito").empty();
                        
            $.get("Ubigeo?option=provincia&cod="+vv, function(data)
                { 
                   
                    $("#provincia").append(data);
                });
        });
		$("#provincia").change(function()
		{
            vv = $(this).val();
			vv = vv.substring(0,4); 	
            $.get("Ubigeo?option=distrito&cod="+vv, function(data)
            { 
				$("#distrito").empty().append(data);
            });
        });
    }); 

</script>

<br><br><br>
<form aling="center"  action="<c:url value="/${url}?option=save"/>" method="post" id="frm">
<div id="div_pequenos" class="ui-corner-all">
    <div id="titulo" class="titulo_form ui-corner-all">Nuevo ${url}</div>
<br>
<table>
<tr>
	<td>C&oacute;digo: </td>
        <td><input type="text" name="cod" id="cod" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Codigo: " value="${cod}" readonly="">
        </td>
	<td>&nbsp;&nbsp;</td>
	<td>Razon Social: </td>
        <td><input type="text" name="rz" id="rz" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Razon Social: " value="${rz}"></td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Representante: </td>
        <td><input type="text" name="representante" id="Apellido" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Representante: " value="${representante}"></td>
	<td>&nbsp;&nbsp;</td>
	<td>Ruc: </td>
        <td><input type="text" name="ruc" id="ruc" class="cajatexto  ui-widget-content ui-corner-all" placeholder="RUC: " value="${ruc}" maxlength="11"></td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
    
	
	
	<td>Departamento: </td>
	<td>
	<select  name="departamento" id="departamento">	
	<option value="" >:::Seleccione:::</option>
            <c:forEach items="${region}" var="vard">
                <option value="<c:out value="${vard[0]}"></c:out>"><c:out value="${vard[1]}"></c:out></option>
            </c:forEach>
    </select>
	</td>
     <td>&nbsp;&nbsp;</td>
	<td>Provincia: </td>
	<td>
	<select  name="provincia" id="provincia">	
	${provincia}
    </select>
        </td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	
	
	<td>Distrito: </td>
	<td>
	<select  name="distrito" id="distrito">	

    </select>
        </td>

	
	<td>&nbsp;&nbsp;</td>
	<td>Tel&eacute;fono: </td>
        <td><input type="text" name="telefono" id="telefono" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Telefono: " value="${telefono}"></td
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Direcci&oacuten: </td>
        <td><input type="text" name="direccion" id="Direccion" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Direccion: " value="${direccion}"></td>
	<td>&nbsp;&nbsp;</td>
        <td>Email: </td>
        <td><input type="text" name="email" id="Direccion" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Email: " value="${email}"></td>
	<td>&nbsp;&nbsp;</td>
	
    
</tr>
<tr title="Acciones">
    <td>
        <input type="submit" name="save" id="save" value="Guardar" class="btn"/>
    </td>
</tr>
</table>
</div>
</form>
        <div class="">${msg}</div>
<br>
<h2 style="border-bottom:2px solid #333;border-padding:5px;"></h2>		
<%@include  file="/template/pie.jsp" %>
