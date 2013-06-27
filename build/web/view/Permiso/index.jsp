<%-- 
    Document   : index
    Created on : 16-jun-2013, 21:01:55
    Author     : Fredesvinda
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="/template/menu.jsp" %>
<script type="text/javascript">
    $(document).ready(function()
	{
	    $("#perfil").change(function()
		{
            vv = $(this).val();
		alert(vv);	
                        
            $.get("Permiso?option=search&cod="+vv, function(data)
                { 
                   
                    $("#content").append(data);
                });
        });
		
    });  
</script>
<select name="perfil" id="perfil">
<%@include  file="../select.jsp" %>
</select>
<div id="content">
    
</div>

<%@include  file="/template/pie.jsp" %>