<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.spe.ClassroomManagementSystem.Models.TA" %>
<%@ page import="org.springframework.http.ResponseEntity" %>
<%@ page import="org.springframework.web.bind.annotation.RequestMapping" %>
<%@ page import="org.springframework.boot.web.servlet.server.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Objects" %>

<%@ page import="com.spe.ClassroomManagementSystem.Service.ReturnableRequest" %>
<%@ page import="com.spe.ClassroomManagementSystem.Models.ClassTiming" %>
<%--<%@ page import="org.springframework.web.bind.annotation.RequestBody" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="/css/All.css">

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        body{
            font-family: Ubuntu;
            background: url("/images/reduced_opacity_bg.jpeg");
            background-repeat:repeat-x;

        }
        nav a{ color: white;
        }

    </style>



</head>
<body>
<%
    if(session.getAttribute("admin_login")!=null) {
%>
<script type="text/javascript">
    <%
     if (session.getAttribute("view_req_msg")!=null){
     %>
    alert('<%= session.getAttribute("view_req_msg")%>');
    <%
    session.setAttribute("view_req_msg",null);
    %>
    <%
    }else {}
    %>
</script>
<nav class="navbar navbar-fixed-top navbar-light" style="background-color: #563D7C; ">
    <!-- Navbar content -->
    <a class="navbar-brand" href="AdminDashboard.jsp">Clasroom Manager</a>
    <ul class="nav navbar-nav navbar-left">
        <li><a href="RegisterUser.jsp"> Add User </a></li>
        <li><a href="/getAllRequests">View Requests</a></li>
        <li><a href="AddClassroom.jsp">Add Classroom</a> </li>
        <li><a href="/getAllClassrooms">Add Timetable</a> </li>
         <li><a href="/gettimetable">View Timetable</a> </li>
         <!--  <li><a href="AddCourse.jsp">Add Course</a> </li> -->
          <li><a href="/getInternship">Internship Requests</a> </li>
         
         
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/destroy" style="margin-right: 10px"><span class="glyphicon glyphicon-log-in" ></span> Logout</a></li>
    </ul>
</nav>

<br>
<%
  /*   List<ReturnableRequest> returnableRequestList = (List<ReturnableRequest>) session.getAttribute("timetableList");
    if (returnableRequestList.size() >0){ */
    	List<ClassTiming> timetableList = new ArrayList();
    	
    	if(Objects.nonNull( session.getAttribute("timetableList"))){
        	timetableList = (List<ClassTiming>) session.getAttribute("timetableList");
    	}
    if (timetableList.size() >0){ 
%>

<div class="container" >
    <br><br>

    <h2 >Hey, here are the timetables</h2>
    <h5 style="color:darkblue"></h5>

    <br>
    <table class="table table-hover table-responsive table-bordered" style="background: white">
        <thead style="background-color: #cccccc">
        <tr>
                    <th scope="col">Class Code</th>

            <th scope="col">Day</th>
            <th scope="col">Start time</th>
            <th scope="col">End time</th>

            <!-- <th scope="col">Action</th>  -->
           
        </tr>
        </thead>
        <tbody>
        <br>

        <c:forEach var="e" items="${timetableList}">
            <tr>
                <td>${e.classroom.classCode}</td>

                <td>${e.dayOfTheWeek}</td>
                <td>${e.startTime}</td>
                <td>${e.endTime}</td>
               
               <%--    <td><a href="@{/timetable/delete/{classTimingId}(classTimingId=${e.classTimingId})}" class="btn btn-success">Delete</a></td>  --%>
                <!-- <td><a href="" class="btn btn-success">Update</a></td> -->



            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<% }else{        %>
<br><br><br>
<div class="container">
    <h3 align="center"> No pending Requests..</h3>

</div>


<% } %>


<br>
<div>
    <!-- Footer -->
    <footer class="page-footer font-small blue">

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">
            <a>KEPA</a>
        </div>
        <!-- Copyright -->

    </footer>
    <!-- Footer -->
</div>
<% }
    else {
    response.sendRedirect("LoginFirst.jsp");
    }
%>
</body>
</html>