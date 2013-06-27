<%-- 
    Document   : select
    Created on : 17-jun-2013, 21:08:16
    Author     : Fredesvinda
--%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:forEach items="${data}" var="vard">

         <option value="<c:out value="${vard[0]}"></c:out>"><c:out value="${vard[1]}"></c:out></option>
       
         
            </c:forEach>