<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : index
    Created on : 13/06/2013, 01:01:36 AM
    Author     : lenin
--%>

<style>
    
/*For tooltip box*/
div#mcTooltip 
{
    line-height:20px;
    border-width: 2px;   
    color:#DDDDDD; 
    border-color:#666666;
    font-size: 12px;
    font-family: Verdana, Arial;
    border-radius:3px; /*Rounded corners. N/A for IE 8 and below.*/
	background:#353c40;
}
div#mcTooltip, div#mcTooltip div
{
    background-color:#353c40;
}

/* For hyperlink within tooltip */
div#mcTooltip a { color:#6CF; }

/*The settings below should remain unchanged*/
div#mcTooltipWrapper {position:absolute;visibility:hidden;overflow:visible;z-index:9999999999;top:-2000px;}
div#mcTooltip {float:left;border-style:solid;position:relative;overflow:hidden;}
div#mcttCo {position:absolute;text-align:left;}
div#mcttCo em, div#mcttCo b {display:block; width:0; height:0;overflow:hidden;}
</style>

<%@ taglib prefix="z" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

 
<%@include  file="/template/menu.jsp" %>
${title}
<div id="formulario" >
    <div id='datos_venta'>Datos de la venta</div>
    

<div style="width:680px;height:auto;border: 1px solid #3366ff;">
<CENTER>HABITACIONES HOTEL TARAPOTO INN</CENTER>
    <table>
       
        <z:set var="row" value="0"></z:set>
        <z:forEach begin="1" end="${total_filas}" var="i">
            <tr>
                <z:forEach begin="1" end="8" var="j">
                    <td id=" <z:out value="${habit[row][0]}"></z:out>">
                        <z:choose>
                            <z:when test="${habit[row][5]==0}">
                          <a data-toggle="modal" href="#myModal" >
                              <p>Hab.${habit[row][4]}</p> <img src="http://localhost:8080/script/images/disponible1.jpg" title="Habitacion ${habit[row][4]}" onmouseover="tooltip.pop(this, '#${habit[row][0]}', {offsetY: -10})"/>
                          </a>
                          <div style=" display: none;">
                          <div id="${habit[row][0]}" >
                              <div>Descripcion:${habit[row][1]}</div>
                              <div>Tipo cama:${habit[row][2]}</div>
                                  <div>Precio:${habit[row][3]}</div>
                                  <div>Numero:${habit[row][4]}</div>
                          </div>
                          </div>
                            </z:when>
                                  <z:when test="${habit[row][5]==1}">
                                yy
                            </z:when>
                        </z:choose>
                    </td>
                   
                   <z:set var="row" value="${row+1}"></z:set>
                </z:forEach>
               
            </tr>
           
        </z:forEach>
    </table>
</div>
        <div>la grilla del carrito de habitaciones</div>       
    
<a data-toggle="modal" href="#myModal" class="btn btn-primary btn-large">Launch demo modal</a>

<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
              <h3 id="myModalLabel">Modal Heading</h3>
            </div>
            <div class="modal-body">
              <h4>Text in a modal</h4>
              <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem.</p>

              <h4>Popover in a modal</h4>
              <p>This <a href="#" role="button" class="btn popover-test" title="" data-content="And here's some amazing content. It's very engaging. right?" data-original-title="A Title">button</a> should trigger a popover on click.</p>

              <h4>Tooltips in a modal</h4>
              <p><a href="#" class="tooltip-test" title="" data-original-title="Tooltip">This link</a> and <a href="#" class="tooltip-test" title="" data-original-title="Tooltip">that link</a> should have tooltips on hover.</p>

              <hr>

              <h4>Overflowing text to show optional scrollbar</h4>
              <p>We set a fixed <code>max-height</code> on the <code>.modal-body</code>. Watch it overflow with all this extra lorem ipsum text we've included.</p>
              <p>Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
              <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
              <p>Aenean lacinia bibendum nulla sed consectetur. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Donec sed odio dui. Donec ullamcorper nulla non metus auctor fringilla.</p>
              <p>Cras mattis consectetur purus sit amet fermentum. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
              <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
              <p>Aenean lacinia bibendum nulla sed consectetur. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Donec sed odio dui. Donec ullamcorper nulla non metus auctor fringilla.</p>
            </div>
            <div class="modal-footer">
              <button class="btn" data-dismiss="modal">Close</button>
              <button class="btn btn-primary">Save changes</button>
            </div>
          </div>
</div>
<script src="http://localhost:8080/script/bootstrap/js/bootstrap-modal.js" type="text/javascript"></script>
 <script type="text/javascript" src="http://localhost:8080/script/bootstrap/js/jquery.js"></script>
<%@include  file="/template/pie.jsp" %>
