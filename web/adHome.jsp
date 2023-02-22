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
        <title>Admin Page</title>
    </head>
    <body>

        <c:if test="${acc != null}">
            <label style="padding-top: 20px; padding-left: 20px; color: green">
                Welcome, ${acc.userName}
            </label>

            <label style="padding-top: 20px; padding-left: 20px ">
                <a href="main?action=logout">Logout</a>
            </label>
        </c:if>
        <label style="padding-top: 20px; padding-left: 20px ">
            <a href="adminhome">Admin Page</a>
        </label>
        <h2 style="text-align: center"><a href="adminhome">Admin Page</a></h2>
        <c:if test='${createSucess == "Create New Course Successfull"}'>
            <h3 style="color: green; text-align: center">${createSucess}</h3>
        </c:if>
        <form style="padding-left: 20px" action="main" method="post">
            <label>Search:</label>
            <input type="text" name="txtSearch" value="">

            <select name="cmbCate">
                <option value="guitar">Guitar</option>
                <option value="piano">Piano</option>
                <option value="drawing">Drawing</option>
            </select>
            <select name="cmbStatus">
                <option value="active">Active</option>
                <option value="close">Close</option>
            </select>
            <input type="submit" name="action" value="Search Course">
            <h4 style="text-align: center"><a href="createnav">Create New Course</a></h4>
        </form>

        <c:if test='${noResult == "No course math your search value!!!"}'>
            <h3 style="text-align: center; color: red">${noResult}</h3>
        </c:if>
        <c:forEach items="${listC}" var="listC">
            <div class="row">
                <img class="col-sm-4" style="width: 250px; height: 250px;" src="${listC.image}"><br>
                <strong>Name:</strong>
                <label>${listC.courseName}</label><br>
                <strong> Description:</strong>
                <small>${listC.description}</small><br>
                <strong> Category:</strong>
                <label>${listC.category}</label><br>
                <strong> Price:</strong>
                <label>
                    <fmt:formatNumber value="${listC.tuitionFee}" pattern=" #,##0 VND" />
                </label><br>
                <strong> Quantity:</strong>
                <label>${listC.quantity}</label><br>
                <strong> Status:</strong>
                <label>${listC.status}</label><br>
                <strong> Start Date:</strong>
                <label>${listC.startDate}</label><br>
                <strong> End Date:</strong>
                <label>${listC.endDate}</label>
                <input type="hidden" name="result" value="${listC}"><br>
                <h4 style="text-align: center"><a href="updatenav?courseID=${listC.courseID}">Update Course</a></h4>
            </div>                
        </c:forEach>
        <c:forEach begin="1" end="${endP}" var="i">
            <a href="adminhome?index=${i}">${i}</a>
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


