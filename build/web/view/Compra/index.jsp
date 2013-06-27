<%-- 
    Document   : index
    Created on : 07/06/2013, 09:10:29 PM
    Author     : lenin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

  
<%@include  file="/template/menu.jsp" %>
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

<div id="dt_example">
<div id="container">
    
<h1>${title} </h1>
<a href="<c:url value="/${url}?option=add"/>" class="btn btn-success">Nuevo</a>
<div id="demo_jui">
<table id="companies" class="display" border="2">
		            <thead>
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
                                            <a class="btn" href="<c:url value="/${url}?option=show&cod=${row2[0]}"/>">Ver</a>
                                         
                                            </td>
                                    </tr>
                                </c:forEach>
		            </tbody>
		        </table>
		        </div>
 </div>
</div>


<%@include  file="/template/pie.jsp" %>