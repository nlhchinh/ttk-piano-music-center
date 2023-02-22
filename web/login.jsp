<%-- 
    Document   : login
    Created on : Dec 10, 2022, 9:31:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
    </head>
    <body>
        <a href="home">Home Page</a>
        <h1 style="color: green">Login page</h1>
        <form action="main" method="post">
            <label>UserID:</label>
            <input type="text" name="txtUserID" value=""><br><br>
            <label>Password:</label>
            <input type="password" name="txtPassword" value=""><br><br>
            <input type="submit" name="action" value="login">
            <input type="reset" value="reset">
        </form>
        <c:if test='${checklogin == "User is not found!!!"}'>
            <h4 style="color: red">
                ${checklogin}
            </h4>
        </c:if>
    </body>
</html>
