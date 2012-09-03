<%-- 
    Document   : result
    Created on : Sep 2, 2012, 1:29:27 PM
    Author     : Kevin Nangle
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu selection results</title>
    </head>
    <body>
    <h1 align="center">Your dining selections:</h1>
    <p style="margin-left:700px;">

    <%
        List items = (List)request.getAttribute("choices");
        Iterator it = items.iterator();
        while(it.hasNext()) {
            out.print("<br/>" + it.next());
        }
    %>
    </p>
    <p style="margin-left:700px;"><a href="orderForm.html">Back</p>
    
    </body>
</html>
