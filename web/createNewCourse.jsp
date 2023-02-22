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
        <title>Create New Course Page</title>
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
        <h2 style="text-align: center"><a href="createNewCourse.jsp">Create New Course Page</a></h2>

        <c:if test='${invalidDate == "Invalid Date!!! Read the note and try again!!!"}'>
            <h3 style="text-align: center; color: red">${invalidDate}</h3>
        </c:if>
        <c:if test='${duplicateCourseID == "CourseID is duplicated!! Please choose another id"}'>
            <h3 style="text-align: center; color: red">${duplicateCourseID}</h3>
        </c:if>
        <label style="color: green; padding-left: 100px">
            Note:<br>
            - StartDate and EndDate must be days in the future.<br>
            - The interval between start and end days must be at least 7 days apart.
        </label>
        <form action="main" method="post">
            <div style="padding-left: 100px">
                <strong>Image Link:</strong><br>
                <input type="text" name="image" size="100" required=""><br><br>
                <strong>Course ID(Interger only):</strong><br>
                <input type="number" name="courseID" size="100" required=""><br><br>
                <strong>Course Name:</strong><br>
                <input type="text" name="courseName" size="50" required=""><br><br>
                <strong> Description:</strong><br>
                <input type="text" name="description" size="100" required=""><br><br>
                <strong> Category:</strong><br>
                <select name="cmbCate">
                    <option value="guitar">Guitar</option>
                    <option value="piano">Piano</option>
                    <option value="drawing">Drawing</option>                  
                </select><br><br>
                <strong> 
                    Status:
                    <label style="color: green">active</label>
                </strong>
                <br><br>
                <strong> Price(100.000 - 10.000.000 VND):</strong><br>
                <input type="number" name="price" required="" min="100000" max="10000000"><br><br>
                <strong> Quantity(1-100):</strong><br>
                <input type="number" name="quanitty" required="" min="1" max="100"><br><br>
                <strong> Start Date:</strong><br>
                <input type="date" name="startDate" required=""><br><br>
                <strong> End Date:</strong><br>
                <input type="date" name="endDate" required=""><br><br>
                <input type="submit" name="action" value="Create Course">
            </div>     
        </form>

        <h4 style="padding-left: 20px">
            <a href="adminhome">Back</a>    
        </h4>
    </body>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</html>


