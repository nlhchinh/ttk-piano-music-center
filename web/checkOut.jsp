<%-- 
    Document   : checkOut.jsp
    Created on : Dec 11, 2022, 5:41:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Out Page</title>
    </head>
    <body>
        <c:if test="${acc == null}">
            <label style=" padding-left: 20px; padding-top: 20px"><a href="login.jsp">Login</a></label>
        </c:if>

        <c:if test="${acc != null}">
            <label style="padding-top: 20px; padding-left: 20px; color: green">
                Welcome, ${acc.userName}
            </label>

            <label style="padding-top: 20px; padding-left: 20px ">
                <a href="main?action=logout">Logout</a>
            </label>
        </c:if>
        <label style="padding-top: 20px; padding-left: 20px ">
            <a href="home">Home Page</a>
        </label>
        <label style="padding-top: 20px; padding-left: 20px ">
            <a href="cart.jsp">View Cart</a>
        </label>
        <label style="padding-top: 20px; padding-left: 20px ">
            <a href="trackorder">Track order</a>
        </label>
        <h1 style="text-align: center; color: green">Check Out Page</h1>
        <c:if test="${cart == null}">
            <h3 style="text-align: center; color: red">Your cart is empty!!!Please add a course to cart to check out.</h3>
        </c:if>
        <c:if test="${cart != null}">
            <div style="text-align: center">
                <form action="main" method="post">
                    <label>User ID(*):</label>
                    <input type="text" name="userID" value="${acc.userID}" required=""><br><br>
                    <label>Address(*):</label>
                    <input type="text" name="address" value="" required=""><br><br>
                    <label>Note(optional):</label>
                    <input type="text" name="note"><br><br>
                    <label>Payment method:</label>

                    <select name="payment">
                        <option value="cash">Cash Payment</option>
                    </select>
                    <br><br>
                    <input type="submit" name="action" value="confirm">
                </form>
            </div>
        </c:if>
        <label style="padding-left: 20px; color: green">Note:
            <br> - If you don't remember your account information,<br> please login and your field'll be auto fill.
        </label><br>
        <c:if test='${invalidRole == "This account does not have permission to checkout!!!We sorry for the inconvenient"}'>
            <h3 style="text-align: center; color: red">${invalidRole}</h3>
        </c:if>
        <c:if test='${invalidID == "This userID does not have permission to checkout!!!We sorry for the inconvenient"}'>
            <h3 style="text-align: center; color: red">${invalidID}</h3>
        </c:if>
        <c:if test='${existID == "This userID is not found in database. Please choose another ID."}'>
            <h3 style="text-align: center; color: red">${existID}</h3>
        </c:if>
    </body>
</html>
