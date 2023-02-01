<%-- 
    Document   : login
    Created on : Jan 26, 2023, 7:11:35 AM
    Author     : jifang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="POST">
            Username: <input type="text" name="username" value="${user.username}"/><br>
            Password: <input type="text" name="password" value="${user.password}"/><br>
            <input type="submit" value="Login in"/><br>
            ${message}
        </form>
    </body>
</html>
