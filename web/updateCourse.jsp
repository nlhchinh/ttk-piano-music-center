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
        <h2 style="text-align: center"><a href="updatenav?courseID=${courseDTO. courseID}">Update Course Page</a></h2>
        <form action="main" method="post">
            <div class="row">
                <strong>Image link:</strong>
                <input type="text" name="image" value="${courseDTO.image}" size="50" required="">
                <img class="col-sm-4" style="width: 270px; height: 290px;" src="${courseDTO.image}"><br><br>
                <strong>Name:</strong>
                <input type="texte" name="courseName" value="${courseDTO.courseName}" size="70" required=""><br><br>
                <strong> Description:</strong>
                <input type="text" name="description" value="${courseDTO.description}" size="150" required=""><br><br>
                <strong> Category:</strong>
                <label>${courseDTO.category}</label>
                <select name="cmbCateUp">
                    <option value="none">Choose a cate</option>
                    <option value="piano">Piano</option>
                    <option value="guitar">Guitar</option>
                    <option value="drawing">Drawing</option>
                </select><br><br>
                <strong> Price:</strong>
                <input type="number" name="tuitionFee" value="${courseDTO.tuitionFee}" required="" min="100000" max="10000000">
                <strong> Quantity:</strong>
                <input type="number" name="quantity" value="${courseDTO.quantity}" required="" min="1" max="100">
                <strong> Status:</strong>
                <c:if test='${courseDTO.status == "active"}'>
                    <label style="color: green">${courseDTO.status}</label>
                </c:if>
                <c:if test='${courseDTO.status == "close"}'>
                    <label style="color: blue">${courseDTO.status}</label>
                </c:if>
                <input type="hidden" name="status" value="${courseDTO.status}">
                <select name="cmbStatus">
                    <option value="none">Choose a status</option>
                    <option value="active">Active</option>
                    <option value="close">Close</option>
                </select><br><br>
                <strong> Start Date</strong>
                <input type="date" name="startDate" value="${courseDTO.startDate}">
                <strong> End Date:</strong>
                <input type="date" name="endDate" value="${courseDTO.endDate}"><br>
                <input type="hidden" name="result" value="${courseDTO}"><br>
                <input type="hidden" name="courseID" value="${courseDTO.courseID}"> 
                <input type="hidden" name="category" value="${courseDTO.category}"> 
                <input type="submit" name="action" value="Update Course">
            </div>
        </form>
        <c:if test='${invalidDate == "Invalid date!!! Please read the note and try again."}'>
            <h3 style="color: red; text-align: center">${invalidDate}</h3>
        </c:if>

        <h4 style="padding-left: 20px">
            <a href="adminhome">Back</a>    
        </h4>
        <label style="color: green; padding-left: 100px">
            Note:<br>
            - StartDate and EndDate must be days in the future.<br>
            - The interval between start and end days must be at least 7 days apart.
        </label>

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


