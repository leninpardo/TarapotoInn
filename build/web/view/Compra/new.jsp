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
        $(document).ready(function () {
            $("#proveedor").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
 </script>
      <script type="text/javascript">
        $(document).ready(function () {
            $("#productos").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
 </script>
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


    }); 

function add_proveedor(cod,rz,ruc)
{
 
    $("#codprov").val(cod);
    $("#rz").val(rz);
     $("#ruc").val(ruc);
}
function add_producto(cod,descrip,pc)
{
     $("#codprod").val(cod);
    $("#descripcion").val(descrip);
     $("#pc").val(pc); 
}
function agregar_producto()
{
    codp= $("#codprod").val();
    cant=$("#cantidad").val();
     pc=$("#pc").val();
     descrip=$("#descripcion").val();
  bval = true;
bval = bval && $("#cantidad").required();
//if(bval)
  //  {
        //alert(cant);
        //
        
    //}
}
</script>
    <%
      
     InetAddress addressg = InetAddress.getLocalHost();
          String sHostName;
    sHostName = addressg.getCanonicalHostName();
    //out.print(sHostName);
    
      
  %> 
<br>
<form  action="<c:url value="/${url}?option=save"/>" method="post" id="frm">
<div id="" class="ui-corner-all">
    <div id="titulo" class="btn-success">Nuevo ${url}</div>
<br>
<table>

<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>


	<td>Ruc: </td>
        <td>
            <input type="text" name="ruc" id="ruc" class="cajatexto  ui-widget-content ui-corner-all" placeholder="RUC: " value="${ruc}" readonly="">
            <input type="hidden" name="codprov" id="codprov" />
        </td>
        <td>&nbsp;&nbsp;</td>
	<td>Razon social: </td>
        <td><input type="text" name="rz" id="rz" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Razon Social: " value="${rz}" readonly=""></td>
        <td>&nbsp;&nbsp;</td>
        <td>
             <a data-toggle="modal" href="#modal-proveedor" class="btn">
               <img src="http://<%out.print(sHostName);%>:8080/script/images/buscar.png" alt="Buscar" title="Buscar" width="30" height="40">
           </a>
        </td>
       
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
    
	
	
	<td>fecha</td>
	<td>
            <input type="text" name="fecha" id="fecha"/>
	</td>
     <td>&nbsp;&nbsp;</td>
	<td>NroComprobante: </td>
	<td>
            <input type=" text" name="nrocomprobante" id="nrocomprobante" class="cajatexto  ui-widget-content ui-corner-all" placeholder="NroComprobante: "/> 
        </td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	
	
	<td>IGV</td>
	<td>
            <input type="text" class="cajatexto  ui-widget-content ui-corner-all" placeholder="igv: " value="0"/>
        </td>

	
	<td>&nbsp;&nbsp;</td>
	<td>Observaciones: </td>
        <td>
            <textarea name="obs" id="obs" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Observaciones: "></textarea>
        </td>
</tr>
<tr>
<td  colspan="5">&nbsp;</td>
</tr>
<tr>
	
	
        <td>Descripcion: </td>
        <td>
            <input type="text" name="descripcion" id="descripcion" class="cajatexto  ui-widget-content ui-corner-all" placeholder="Descripcion:"  size="" readonly="">
        <input type="hidden" name="codprod" id="codprod" />
        </td>
        
	<td>&nbsp;&nbsp;</td>
	<td>Cantidad: </td>
        <td><input type="text" name="cantidad" id="cantidad"  placeholder="Cantidad:"  size="1" style=" size: 2px;"></td>
        
        <td>&nbsp;&nbsp;</td>
	<td>Precio: </td>
        <td><input type="text" name="precio" id="pc"  placeholder="Precio Compra:"  size="1" readonly=""></td>
      
        <td>
             <a data-toggle="modal" href="#modal-producto" class="btn">
               <img src="http://<%out.print(sHostName);%>:8080/script/images/buscar.png" alt="Buscar" title="Buscar" width="20" height="20">
               </td>
               <td>
       <a data-toggle="modal" href="javascript:agregar_producto();" class="btn">
               <img src="http://<%out.print(sHostName);%>:8080/script/images/add1.png" alt="Buscar" title="Buscar" width="20" height="20">
       
               </td>
    
</tr>

</table>
        <div id="grilla">
            <table id="grilla_producto">
                <thead class="ui-widget ui-widget-content">
                    <tr class="ui-widget-header" style="height: 20px">
                              <td width="200px">Codigo</td>
				<td width="300px">Descripcion</td>
				<td width="200px">Cantidad</td>
                                <td width="200px">Precio Compra</td>
                    </tr>
                </thead> 
            </table>
        </div>
        <div id="complements">
            <label>
                Importe Total
            </label>
            <input type="text" name="importe" id="importe" placeholder="Total importe">
        </div>
        <center><div id="acciones"> <input type="submit" name="save" id="save" value="Guardar" class="btn"/></div></center>
</div>
        
</form>
        <div class="">${msg}</div>
        
 <!--modals-->
 
<div  id="modal-proveedor" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    
 <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
              <h3 id="myModalLabel">LISTA DE COMPRAS/TARAPOTO INN</h3>
                   <img src="http://<%out.print(sHostName);%>:8080/script/images/logo.png" alt="seleccionar" >
            </div>
            <div class="modal-body">
          <div id="dt_example">
<div id="container">
    
<div id="titulo"><u>Registro de Proveedores</u></div>
<div id="msg"></div><div id="msg1"></div>
<div id="demo_jui">
    <table id="proveedor" class="display" border="2" id="grd">
		            <thead > 
		                <tr>
                                    <c:forEach items="${nomp}" var="rowp">
                                        <th><u><c:out value="${rowp}"></c:out></u></th>
                                    </c:forEach>
		                   <th>Acciones</th>
		                </tr>
		            </thead>
		            <tbody>
                             
                                <c:forEach items="${proveedores}" var="rowp2">
                                    <tr>
                                    <c:forEach begin="1" end="${cantp}" step="1" var="k">
                                        <td><c:out value="${rowp2[k-1]}"></c:out></td>
                                    </c:forEach>
                                        <td>
                                           
                                            
                                            <a class="btn"  href="javascript:add_proveedor('${rowp2[0]}','${rowp2[1]}','${rowp2[2]}');">
                                                <img src="http://<%out.print(sHostName);%>:8080/script/images/add1.png" alt="seleccionar" >
                                            </a>
                                            </td>
                                    </tr>
                                </c:forEach>
		            </tbody>
		        </table>
		        </div>
<div class="alert" id="alert"></div>
 </div>
</div>

            </div>
            <div class="modal-footer">
               
              <button class="btn" data-dismiss="modal">Close</button>
              <button class="btn btn-primary"> </button>
            </div>
  </div>
    <!--grilla de productos-->        
 <div  id="modal-producto" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    
 <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
              <h3 id="myModalLabel">LISTA DE COMPRAS/TARAPOTO INN</h3>
                   <img src="http://<%out.print(sHostName);%>:8080/script/images/logo.png"  >
            </div>
            <div class="modal-body">
          <div id="dt_example">
<div id="container">
    
<div id="titulo"><u>Registro de Productos</u></div>
<div id="msg"></div><div id="msg1"></div>
<div id="demo_jui">
    <table id="productos" class="display" border="2" id="grd">
		            <thead > 
		                <tr>
                                    <c:forEach items="${nompr}" var="rowpr">
                                        <th><u><c:out value="${rowpr}"></c:out></u></th>
                                    </c:forEach>
		                   <th>Acciones</th>
		                </tr>
		            </thead>
		            <tbody>
                             
                                <c:forEach items="${productos}" var="rowpr2">
                                    <tr>
                                    <c:forEach begin="1" end="${cantpr}" step="1" var="k">
                                        <td><c:out value="${rowpr2[k-1]}"></c:out></td>
                                    </c:forEach>
                                        <td>
                                           
                                            
                                            <a class="btn"  href="javascript:add_producto('${rowpr2[0]}','${rowpr2[1]}','${rowpr2[4]}');">
                                                <img src="http://<%out.print(sHostName);%>:8080/script/images/add1.png" alt="seleccionar" >
                                            </a>
                                            </td>
                                    </tr>
                                </c:forEach>
		            </tbody>
		        </table>
		        </div>
<div class="alert" id="alert"></div>
 </div>
</div>

            </div>
            <div class="modal-footer">
               
              <button class="btn" data-dismiss="modal">Close</button>
              <button class="btn btn-primary"> </button>
            </div>
  </div>           
 <!--en modals-->
   <!--the css and script for table and modals-->
    
  <script src="http://<%out.print(sHostName);%>:8080/script/bootstrap/js/bootstrap-modal.js" type="text/javascript"></script>
 <script type="text/javascript" src="http://<%out.print(sHostName);%>:8080/script/bootstrap/js/jquery.js"></script>
 
 
 
<link href="http://<%out.print(sHostName);%>:8080/script/table/css/demo_table.css" rel="stylesheet" type="text/css" />
<link href="http://<%out.print(sHostName);%>:8080/script/table/css/demo_table_jui.css" rel="stylesheet" type="text/css" />
<link href="http://<%out.print(sHostName);%>:8080/script/table/css/jquery-ui-1.8.24.custom.css" rel="stylesheet" type="text/css" media="all" />
<script src="http://<%out.print(sHostName);%>:8080/script/table/js/jquery.js" type="text/javascript"></script>
<script src="http://<%out.print(sHostName);%>:8080/script/table/js/jquery.dataTables.js" type="text/javascript"></script>
   
<%@include  file="/template/pie.jsp" %>
