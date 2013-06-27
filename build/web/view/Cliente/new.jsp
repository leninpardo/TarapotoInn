<%-- 
    Document   : new
    Created on : 12/06/2013, 05:14:00 PM
    Author     : lenin
--%>

 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="/template/menu.jsp" %>
<br/>
<br/>
sdfsd
<div id="formulario" align="center" class="span12">
    <div id="div_pequenos">
<fieldset class="ui-corner-all">
<legend class="fieldset">Nuevo ${url}</legend>
<table>
<tr>
	<td>Ubigeo: </td>
	<td><input type="text" name="Ubigeo" id="Ubigeo" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Ubigeo: "></td>
	<td>&nbsp;</td>
	<td>Nombres: </td>
	<td><input type="text" name="nombres" id="nombres" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Nombres: "></td>
</tr>
<td  colspan="5">&nbsp;</td>
<tr>
	<td>Profesion: </td>
	<td><input type="text" name="Profesion" id="Profesion" class="cajatexto ui-widget-content ui-corner-all" placeholder="Profesion: "></td>
	<td>&nbsp;</td>
	<td>Apellidos: </td>
	<td><input type="text" name="Apellidos" id="Apellidos" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Apellidos: "></td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>NroDocumento: </td>
	<td><input type="text" name="NroDocumento" id="NroDocumento" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Numero de Documento: "></td>
	<td>&nbsp;</td>
	<td>FechaNac: </td>
	<td><input type="text" name="nombre" id="nombre" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Nombre y Apellidos: "></td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Direccion: </td>
	<td><input type="text" name="Direccion" id="Direccion" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Direccion: "></td>
	<td>&nbsp;</td>
	<td>FechaNac: </td>
	<td><input type="text" name="Telefono" id="Telefono" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Telefono: "></td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	<td>Email: </td>
	<td><input type="text" name="Email" id="Email" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Email: "></td>
	<td>&nbsp;</td>
	<td>Estado Civil: </td>
	<td>
	<select  name="estado_civil" id="estado_civil">	
                    <option selected="selected">:::Seleccione:::</option>
                    <option value="0">Soltero</option>
                    <option value="1">Casado</option>
					 <option value="2">Viudo</option>
    </select>
	</td>
</tr>
<td  colspan="5">&nbsp;</td>
<tr>
	<td>Sexo: </td>
	<td> M <input name="sexo"  id="sexo" type="radio" value="M"> F <input name="sexo"  id="sexo" type="radio" value="M"></td>
	<td COLSPAN="3">&nbsp;</td>
</tr>
<tr align="right">
	<td colspan="5"><input class="com_enviar ui-widget-content ui-corner-all"  type="button" id="boton_enviar" name="contacto" value="Guardar"></td>
</tr>
</table>
</fieldset>
</div>

</div>                                                

<%@include  file="/template/pie.jsp" %>


<script>
var item = 0;
var j=0;
$(document).ready(function(){

$('#boton_enviar').click(function(){

alert('ok');


valores = true;
valores = valores && $("#nombres" ).required();
valores = valores && $("#Ubigeo" ).required();
valores = valores && $("#Profesion" ).required();
valores = valores && $("#Apellidos" ).required();

if(valores){

campo_nombre = $("#nombre").val();
campo_email = $("#Ubigeo").val();
campo_asunto = $("#Profesion").val();
comentario = $("#Apellidos").val();
alert('listo par enviar, previa validacion del correo electronico-- \n NOMBRE: '+campo_nombre+' \n EMAIL: '+campo_email+' \n ASUNTO: '+campo_asunto+' \n COMENTARIO: '+comentario);
}
else{
alert('ztmz cagaos');	
}

});


});
</script>