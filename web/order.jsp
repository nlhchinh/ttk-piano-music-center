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
        <title>Track Order Page</title>
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
        <h2 style="text-align: center"><a href="trackorder">Track Order Page</a></h2>
        <table border="2"  style="width: 100%">
            <thead>
                <tr>
                    <th>OrderID</th>
                    <th>OrderDate</th>
                    <th>Address</th>
                    <th>Note</th>
                    <th>Payment method</th>
                    <th>Payment status</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listO}" var="listO">
                    <tr>
                        <td>${listO.orderID}</td>
                        <td>${listO.orderDate}</td>
                        <td>${listO.address}</td>
                        <td>${listO.note}</td>
                        <td>${listO.paymentMethod}</td>
                        <td>${listO.paymentStatus}</td>
                        <td>
                            <fmt:formatNumber value="${listO.total}" pattern=" #,##0 VND" />
                        </td>
                        <td><a href="trackorderdetail?orderID=${listO.orderID}">Detail</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
