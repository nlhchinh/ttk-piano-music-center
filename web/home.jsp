<%-- 
    Document   : home
    Created on : Dec 10, 2022, 9:31:13 PM
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
        <title>Home Page</title>
    </head>
    <body>
        <c:if test="${acc == null}">
            <label style=" padding-left: 20px; padding-top: 20px"><a href="login.jsp">Login</a></label>
        </c:if>

        <c:if test="${acc != null && acc != []}">
            <label style="padding-top: 20px; padding-left: 20px; color: green">
                Welcome, ${acc.userName}
            </label>

            <label style="padding-top: 20px; padding-left: 20px ">
                <a href="main?action=logout">Logout</a>
            </label>

        </c:if>

        <label style="padding-top: 20px; padding-left: 20px">
            <a href="home">Home Page</a>
        </label>

        <label style="padding-top: 20px; padding-left: 20px ">
            <a href="trackorder">Track order</a>
        </label>
        <h1 style="color: green; text-align: center">TTK * Piano music center</h1><br>
        <h3 style="color: green; text-align: center"> TTK * Piano specializes in teaching piano, guitar and drawing.</h3>
        <h4 style="text-align: center">
            “Music is the common language of mankind. Music exists deep in each person's heart.”<br>
            . TTK * Piano has the mission of awakening and developing a love of music,
            contributing to creating a society that can sympathize,
            share and bring joy to others through the distribution of music equipment, audio equipment, and music.
            Sound - Light and Music Education.
        </h4>
        <h2 style="text-align: center"><a href="home">Home Page</a></h2>

        <c:if test='${outofstock1 == "The selected course is out of stock!!!"}'>
            <h3 style="text-align: center; color: red">${outofstock1}</h3>
        </c:if>

        <c:if test='${outofstock2 == "The selected course is out of stock!!!"}'>
            <h3 style="text-align: center; color: red">${outofstock2}</h3>
        </c:if>

        <c:if test='${outofstock3 == "The selected course is out of stock!!!"}'>
            <h3 style="text-align: center; color: red">${outofstock3}</h3>
        </c:if>

        <form action="main" method="post">
            <label>Search:</label>
            <input type="text" name="txtSearch" value="">

            <select name="cmbSearch">
                <option value="guitar">Guitar</option>
                <option value="piano">Piano</option>
                <option value="drawing">Drawing</option>
            </select>
            <input type="submit" name="action" value="search">
            <a href="viewcartnav">View Cart</a>
        </form>
        <c:if test='${noResult == "No course math your search value!!!"}'>
            <h3 style="text-align: center; color: red">${noResult}</h3>
        </c:if>
        <c:forEach items="${listC}" var="listC">
            <div class="row">
                <c:if test="${listC.quantity == 0}">
                    <h4 style="color: red; text-align: center">Out of stock!!!</h4>
                </c:if>
                <img class="col-sm-4" style="width: 	177px; height: 	175px;" src="${listC.image}"><br>
                <strong>Name:</strong>
                <strong> ${listC.courseName}</strong><br>
                <strong> Description:</strong>
                <small>${listC.description}</small><br>
                <strong> Category:</strong>
                <label>${listC.category}</label><br>
                <strong> Price:</strong>
                <fmt:formatNumber value="${listC.tuitionFee}" pattern=" #,##0 VND" /><br>
                <strong> Start Date:</strong>
                <label>${listC.startDate}</label><br>
                <strong> End Date:</strong>
                <label>${listC.endDate}</label><br>
                <a href="main?action=addToCart&courseID=${listC.courseID}">Add to Cart</a>
            </div>
        </c:forEach>
        <c:forEach begin="1" end="${endP}" var="i">
            <a href="home?index=${i}">${i}</a>
        </c:forEach>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>
<style>
    div {
        width: 1530px;
        padding: 10px;
        border: 5px solid gray;
        margin: 0;
    }
</style>


