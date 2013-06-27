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
<script type="text/javascript">
    $(document).ready(function()
	{
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
<script>
var item = 0;
var j=0;
$(document).ready(function(){

$('#save').click(function(){

valores = true;
valores = valores && $("#Cod" ).required();
valores = valores && $("#Nombre" ).required();
valores = valores && $("#Apellido" ).required();
valores = valores && $("#DNI" ).required();
valores = valores && $("#Profesion" ).required();
valores = valores && $("#Departamento" ).required();
valores = valores && $("#Provincia" ).required();
valores = valores && $("#Distrito" ).required();
valores = valores && $("#Perfil" ).required();
valores = valores && $("#Telefono" ).required();
valores = valores && $("#Direccion" ).required();
valores = valores && $("#FechaNac" ).required();
valores = valores && $("#FechaContrat" ).required();
valores = valores && $("#Usuario" ).required();
valores = valores && $("#Clave" ).required();
/*
if(valores){

campo_codigo = $("#cod" ).val();
campo_nombre = $("#Nombre").val();
campo_apellido = $("#Apelllido").val();
campo_dni = $("#DNI").val();
campo_profesion = $("#Profesion").val();
campo_departamento = $("#Departamento").val();
campo_provincia = $("#Provincia").val();
campo_distrito = $("#Distrito").val();
campo_perfil = $("#Perfil").val();
campo_telefono = $("#Telefono").val();
campo_direccion = $("#Direccion").val();
campo_fechanac = $("#FechaNac").val();
campo_fechacontrat = $("#FechaContrat").val();
campo_usuario = $("#Usuario").val();
campo_clave = $("#Clave").val();
alert('Listo para enviar, previa validación de datos');
}else{
alert('El Campo es requerido');	
}*/

});


});
</script>

<div id="div_pequenos" class="ui-corner-all">
<div id="titulo">Nuevo ${url}</div>
<br>
<table>
<tr>
	<td>C&oacute;digo: </td>
        <td><input type="text" name="cod" id="cod" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Codigo: " value="${cod}" readonly="">
        </td>
	<td>&nbsp;&nbsp;</td>
	<td>Nombre: </td>
        <td><input type="text" name="nombre" id="Nombre" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Nombre: " value="${nombre}"></td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Apellido: </td>
        <td><input type="text" name="apellido" id="Apellido" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Apellido: " value="${apellido}"></td>
	<td>&nbsp;&nbsp;</td>
	<td>DNI: </td>
        <td><input type="text" name="dni" id="DNI" class="cajatexto  ui-widget-content ui-corner-all" placeholder="DNI: " value="${dni}"></td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Profesi&oacute;n: </td>
	<td>
	<select  name="profesion" id="Profesion">
            <option value="" >:::Seleccione:::</option>
            <c:forEach items="${profesion}" var="varp">
                <option value="<c:out value="${varp[0]}"></c:out>"><c:out value="${varp[1]}"></c:out></option>
            </c:forEach>
	
    </select>
	</td>
	<td>&nbsp;&nbsp;</td>
	<td>Departamento: </td>
	<td>
	<select  name="departamento" id="departamento">	
	<option value="" >:::Seleccione:::</option>
            <c:forEach items="${region}" var="vard">
                <option value="<c:out value="${vard[0]}"></c:out>"><c:out value="${vard[1]}"></c:out></option>
            </c:forEach>
    </select>
	</td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Provincia: </td>
	<td>
	<select  name="provincia" id="provincia">	
	
    </select>
	</td>
	<td>&nbsp;&nbsp;</td>
	<td>Distrito: </td>
	<td>
	<select  name="distrito" id="distrito">	

    </select>
	</td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Perfil: </td>
	<td>
	<select  name="perfil" id="Perfil">	
            <option value="" >:::Seleccione:::</option>
            <c:forEach items="${perfil}" var="varper">
           <option value="<c:out value="${varper[0]}"></c:out>"><c:out value="${varper[1]}"></c:out></option>
            </c:forEach>
	
    </select>
	</td>
	<td>&nbsp;&nbsp;</td>
	<td>Tel&eacute;fono: </td>
        <td><input type="text" name="telefono" id="Telefono" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Telefono: " value="${telefono}"></td
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Direcci&oacuten: </td>
        <td><input type="text" name="direccion" id="Direccion" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Direccion: " value="${direccion}"></td>
	<td>&nbsp;&nbsp;</td>
	<td>FechaNac: </td>
        <td><input type="text" name="fechanac" id="FechaNac" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Fecha Nacimiento: " value="${fn}"></td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>FechaContrat: </td>
        <td><input type="text" name="fechacontrat" id="FechaContrat" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Fecha Contratacion: " value="${fc}"></td>
	<td>&nbsp;&nbsp;</td>
	<td>Usuario: </td>
        <td><input type="text" name="usuario" id="Usuario" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Usuario: " value="${usuario}"></td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Clave: </td>
        <td><input type="text" name="clave" id="Clave" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Clave: " value="${clave}"></td>
	<td>&nbsp;&nbsp;</td>
	<td>Estado: </td>
	<td><input type="checkbox" name="estado" value="1"checked>Activo </td>
</tr>
<td  colspan="5"><hr></td>
<tr>
    <td>
        <input type="submit" name="save" id="save" value="Guardar" class=" btn"/>
    </td>
    <!--
	<td colspan="2" align="left"><a href="#">
                <img src="images/cancel.JPG" style="width:80px;height:80px;"/></a></td>
	<td colspan="3" align="right"><a href="#">
        <img src="images/save.JPG" id="boton_enviar" style="width:80px;height:80px;"/></a></td>
    -->
</tr>
</table>
</div>

<%@include  file="/template/pie.jsp" %>
