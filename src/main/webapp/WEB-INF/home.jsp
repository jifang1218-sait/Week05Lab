<%-- 
    Document   : home.jsp
    Created on : Feb 1, 2023, 10:10:47 AM
    Author     : jifang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello ${user.username}</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${user.username}</h3>
        <a href="login?logout">Log out</a>
    </body>
</html>
