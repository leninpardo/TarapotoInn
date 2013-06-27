<%-- 
    Document   : new
    Created on : 11/06/2013, 01:02:30 PM
    Author     : lenin
--%>

  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

     <%
      
     InetAddress addressg = InetAddress.getLocalHost();
          String sHostNameg;
    sHostNameg = addressg.getCanonicalHostName();
    //out.print(sHostName);
    
      
  %> 
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
 <script>
$(function() {
$( "#datepicker" ).datepicker();
});
</script>
<script>
    function add_compra(cod,prov,fechc)
    {
           $("#alert").empty(); 
         $("#codcompra").val(cod); 
       $("#rz").val(prov); 
        $("#fechac").val(fechc); 
       // $('#myModal').modal('close');
            $("#alert").append("Datos se selecionaron correctamente,cierre y vuelva al Resgistro"); 
    }
</script>
<br/>
<br/>
<div id="" class="ui-corner-all">
    <div id="titulo" class="btn-success">Nuevo ${url}</div>
        <fieldset class="ui-corner-all">
            <legend class="fieldset">Nuevo ${url}</legend>
    <form action="<c:url value="/${url}?option=save"/>" method="post" class="simple_form form-horizontal" id="frm">
        <table>
            <tr>
                
    <td>
        Codigo
    </td> 
    <td>
        <input type="text" name="cod" value="${cod}" id="cod" readonly=""/>
              </td>
              <td>
    
        Fecha Pago
    </td> 
    <td>
        <input type="text" name="fechapago" value="${fechapago}" id="datepicker"/>
              </td>
                  
    <td>
        Nro Pago
    </td> 
      <td>
        <input type="text" name="nropago" value="${nropago}" id="nropago"/>
              </td>
        </tr>
        
        <tr>
            <td>&nbsp;&nbsp;</td>
        </tr>
        <tr>
            
    <td>
        Monto Cuota
    </td> 
    <td>
        <input type="text" name="monto" value="${monto}" id="monto"/>
        
            </td>
            <td>
             Mora
                 </td>
      
           <td> 
        <input type="text" name="mora" value="${mora}" id="mora"/>
            </td>
                <td>
                
        Fecha vencimiento
    </td> 
    <td>
        <input type="text" name="fechav" value="${fechav}" id="fechav"/>
            </td>
        </tr>
        <tr>
            <td>&nbsp;&nbsp;</td>
        </tr>
        <tr>
            <td>
                Proveedor
            </td>
            <td>
                <input type="text" name="rz" id="rz" value="${rz}">
                <input type="hidden" name="codcompra" id="codcompra" value="${codcompra}">
            </td>
            
            <td>
               fecha Compra 
                
            </td>
            <td>
               <input type="text" name="fechac" id="fechac" value="${fechc}"> 
            </td>
          
            <td>
           <a data-toggle="modal" href="#myModal" class="btn">
               <img src="http://<%out.print(sHostNameg);%>:8080/script/images/buscar.png" alt="Buscar" title="Buscar" width="20" height="20">
           </a>
            </td>
        </tr>
        </table>

        <input type="submit" name="" value="Registrar${url}" class="btn" id="save">
</form>
  <div class="alert">${msg}</div>
</div>
        </fieldset>

<div  id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
    
 <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
              <h3 id="myModalLabel">LISTA DE COMPRAS/TARAPOTO INN</h3>
                   <img src="http://<%out.print(sHostNameg);%>:8080/script/images/logo.png" alt="seleccionar" >
            </div>
            <div class="modal-body">
          <div id="dt_example">
<div id="container">
    
<div id="titulo"><u>Registro de Compras</u></div>
<div id="msg"></div><div id="msg1"></div>
<div id="demo_jui">
    <table id="companies" class="display" border="2" id="grd">
		            <thead > 
		                <tr>
                                    <c:forEach items="${nom}" var="row1">
                                        <th><u><c:out value="${row1}"></c:out></u></th>
                                    </c:forEach>
		                   <th>Acciones</th>
		                </tr>
		            </thead>
		            <tbody>
                             
                                <c:forEach items="${list}" var="row2">
                                    <tr>
                                    <c:forEach begin="1" end="${cant}" step="1" var="k">
                                        <td><c:out value="${row2[k-1]}"></c:out></td>
                                    </c:forEach>
                                        <td>
                                           
                                            
                                            <a class="btn"  href="javascript:add_compra('${row2[0]}','${row2[2]}','${row2[1]}');">
                                                <img src="http://<%out.print(sHostNameg);%>:8080/script/images/add1.png" alt="seleccionar" >
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
 
  <script src="http://<%out.print(sHostNameg);%>:8080/script/bootstrap/js/bootstrap-modal.js" type="text/javascript"></script>
 <script type="text/javascript" src="http://<%out.print(sHostNameg);%>:8080/script/bootstrap/js/jquery.js"></script>
 
 
 
<link href="http://<%out.print(sHostNameg);%>:8080/script/table/css/demo_table.css" rel="stylesheet" type="text/css" />
<link href="http://<%out.print(sHostNameg);%>:8080/script/table/css/demo_table_jui.css" rel="stylesheet" type="text/css" />
<link href="http://<%out.print(sHostNameg);%>:8080/script/table/css/jquery-ui-1.8.24.custom.css" rel="stylesheet" type="text/css" media="all" />
<script src="http://<%out.print(sHostNameg);%>:8080/script/table/js/jquery.js" type="text/javascript"></script>
<script src="http://<%out.print(sHostNameg);%>:8080/script/table/js/jquery.dataTables.js" type="text/javascript"></script>
 <script type="text/javascript">
        $(document).ready(function () {
            $("#companies").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
 </script>
 
</div>
<%@include  file="/template/pie.jsp" %>