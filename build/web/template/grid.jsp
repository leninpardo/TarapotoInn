<%@page import="java.net.InetAddress"%>

  <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt" %>
      <%
      
     InetAddress addressg = InetAddress.getLocalHost();
          String sHostNameg;
    sHostNameg = addressg.getCanonicalHostName();
    //out.print(sHostName);
    
      
  %> 
 
   <!--<link href="http://<%out.print(sHostNameg);%>:8080/script/table/css/demo_page.css" rel="stylesheet" type="text/css" />-->
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
 <script>
     function del(table,cod)
     {
           i = $(this).parent().parent().index();
      if(confirm("Dese eliminar registor"))
          {
           $.get("Eliminar?option=delete&cod="+cod+"&table="+table, function(data)
                { 
                   
                    $("#msg").append(data);
                });
                v=$("#m").val();
              // v= opener.document.getElementByd('m').value;
                 alert(v);
                if(v="true")
                    {
                        
                        //alert("eliminado");
                         //i = $(this).parent().parent().index();
                     $('tbody tr:eq('+i+')').remove();
                    }
                    else{
                        alert("no elimino");
                    }
          }
     }
 </script>
<style>
#titulo{
padding-top:40px;
text-align:center;
font-size:16pt;
text-transform: uppercase;
}
</style>
<div id="dt_example">
<div id="container">
    
<div id="titulo"><u>${title}</u></div>
<a href="<c:url value="/${url}?option=add"/>" class="btn btn-success">Nuevo</a>
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
                                            <a class="btn" href="<c:url value="/${url}?option=edit&cod=${row2[0]}"/>">editar</a>
                                            
                                            <a class="btn btn-mini btn-danger"  href="javascript:del('${table}','${row2[0]}');">eliminar</a>
                                            </td>
                                    </tr>
                                </c:forEach>
		            </tbody>
		        </table>
		        </div>
 </div>
</div>
