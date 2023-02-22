<%-- 
    Document   : cart
    Created on : Dec 11, 2022, 2:17:08 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
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
            <a href="trackorder">Track order</a>
        </label>
        <h1 style="text-align: center; color: green">Your Cart</h1>
        <br>
        <c:if test='${outofstock4 == "The selected course is out of stock!!!"}'>
            <h3 style="text-align: center; color: red">${outofstock4}</h3>
        </c:if>
        <c:if test="${cart == null}">
            <h1 style="text-align: center">Your cart is empty!!!</h1>
        </c:if>
        <c:if test="${cart != null}">
            <table>
                <tr>
                    <th style="text-align: center">Image</th>
                    <th style="text-align: center">Course Name</th>
                    <th style="text-align: center">Amount</th>
                    <th style="text-align: center">Tuition Fee</th>
                    <th style="text-align: center">Sub Total</th>
                    <th style="text-align: center">Update</th>
                    <th style="text-align: center">Remove</th>
                </tr>
                <c:forEach items="${cart}" var="c">
                    <tr> 
                        <td style="text-align: center">
                            <img style="width:150px; height:100px; " src="${c.course.image}">
                        </td>
                        <td style="text-align: center">${c.course.courseName}</td>
                    <form action="main" method="post">
                        <td style="text-align: center">
                            <input type="number" name="amount" value="${c.amount}" min="1" max="20">    
                        </td>

                        <td style="text-align: center">
                            <fmt:formatNumber value="${c.course.tuitionFee}" pattern=" #,##0 VND" />
                        </td>
                        <td style="text-align: center">
                            <fmt:formatNumber value="${c.amount * c.course.tuitionFee}" pattern=" #,##0 VND" />
                        </td>

                        <td style="text-align: center">
                            <input type="submit" name="action" value="update">
                        </td>
                        <input type="hidden" name="courseID" value="${c.course.courseID}">
                        <td style="text-align: center">
                            <a onclick="showMess1(${c.course.courseID})">remove</a>
                        </td>
                    </form>
                </tr>
            </c:forEach>
            <script>
                function showMess1(id) {
                    var option = confirm("Are you sure, you want to remove this course ?");
                    if (option === true) {
                        window.location.href = "main?action=remove&courseID=" + id;
                    }
                }
            </script>
        </table>
        <c:if test='${cart == null}'>
            <h2 style="text-align: center">Total: 0 VND</h2>
        </c:if>
        <c:if test='${cart != null}'>
            <h2 style="text-align: center">Total: <fmt:formatNumber value="${totalPrice}" pattern=" #,##0 VND" /></h2>
        </c:if>
        <h2 style="text-align: center">
            <a href="checkoutnav">Check Out</a>
        </h2>

    </c:if>
</body>
</html>
<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }
</style>
