<%-- 
    Document   : order
    Created on : Dec 11, 2022, 9:18:32 PM
    Author     : Admin
--%>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Track Order Detail Page</title>
    </head>
    <body>
        <label style="padding-top: 20px; padding-left: 20px; color: green">
            Welcome, ${acc.userName}
        </label>
        <label style="padding-top: 20px; padding-left: 20px; text-align: center">
            <a href="main?action=logout">Logout</a>
        </label>
        <label style="padding-top: 20px; padding-left: 20px; text-align: center">
            <a href="home">Home Page</a>
        </label>
        <label style="padding-top: 20px; padding-left: 20px; text-align: center">
            <a href="trackorder">Track Order Page</a>
        </label>

        <h2 style="text-align: center"><a href="trackorder">Track Order Detail Page</a></h2>
        <table border="2"  style="width: 100%">
            <thead>
                <tr>
                    <th>OrderDetailID</th>
                    <th>Course Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Sub Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listODetail}" var="listODetail">
                    <tr>
                        <td>${listODetail.orderDetailID}</td>
                        <td>${listODetail.courseName}</td>
                        <td>${listODetail.orderDetailQty}</td>
                        <td>${listODetail.price}</td>
                        <td>${listODetail.price * listODetail.orderDetailQty}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
