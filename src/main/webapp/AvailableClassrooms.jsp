<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.sql.Date" %>

<%@ page import="com.spe.ClassroomManagementSystem.Models.Classroom" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- <meta http-equiv="refresh" content="10"> -->
    <meta charset="UTF-8">


    <title>Available Classrooms</title>
    <link rel="stylesheet" href="/css/All.css">

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <style>
        body{
            font-family: Ubuntu;
            background: url("/images/reduced_opacity_bg.jpeg");

        }
        nav a{ color: white;
        }

        .b{
            background-color: darkgray;
            color: white;
            padding: 10px 30px 10px 30px;
        }
        .b:hover{
            background-color: #999999;
            color: white;
            padding: 10px 30px 10px 30px;

        }
        a, a:hover{
            text-decoration: none;
            color: white;
        }
        a:hover{
            text-decoration: none;
            color: white;
            background-color: #999999;
        }

    </style>
    <link rel="stylesheet" href="/css/All.css">

</head>
<body>
<%


    if(session.getAttribute("login")!=null){
%>
<nav class="navbar navbar-fixed-top navbar-light" style="background-color: #563D7C; ">
    <!-- Navbar content -->
    <a class="navbar-brand" href="#">IIIT-B Clasroom Manager</a>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="/destroy" style="margin-right: 10px"><span class="glyphicon glyphicon-log-in" ></span> Logout</a></li>
    </ul>
</nav>
<%
Map<Date,List<Classroom>> classroomList =  (Map<Date,List<Classroom>>) session.getAttribute("availableClassrooms");
Set<Date> dates = classroomList.keySet();
List<Date> selectedDates = new ArrayList();

if(!Objects.isNull(session.getAttribute("selectedDates"))){
	selectedDates = (List<Date>) session.getAttribute("selectedDates");
} 
    if (dates.size() > 0){
%>
<div class="container">
    <h4>Hey, here are the available classrooms..</h4>
   <%--  <table class="table table-hover table-bordered table-responsive" style="background: white">
        <thead style="background:rgba(85,85,85,0.33)">
        <tr>
            <th scope="col">Classroom</th>
            <th scope="col">Capacity</th>
            <th scope="col">Projectors</th>
            <th scope="col">Plugs</th>
            <th scope="col">Date</th>
            <th scope="col">Request</th>
        </tr>
        </thead>
        <tbody>
        <%
        for(Date date : dates){
        	if(Objects.isNull(selectedDates) || !selectedDates.contains(date)){
        	for(Classroom clsroom : classroomList.get(date)){
        %>
        <tr>
       		<td><%=clsroom.getClassCode()%></td>
            <td><%=clsroom.getCapacity()%></td>
            <td><%=clsroom.isProjector()%></td>
            <td><%=clsroom.getPlugs()%></td>
            <td><%=date%></td>
            <td><a href="/postRequest/<%= clsroom.getClassCode() %>/<%= date %>" class="btn btn-success">Request this room</a></td>
        </tr>
        <%
        }
        	}
        }
        %>

        </tbody>
    </table> --%>
    
    
    
    
    
    
    <table class="table table-hover table-bordered table-responsive" style="background: white">
    <thead style="background:rgba(85,85,85,0.33)">
    <tr>
        <th scope="col">Classroom</th>
        <th scope="col">Capacity</th>
        <th scope="col">Projectors</th>
        <th scope="col">Plugs</th>
        <th scope="col">Date</th>
        <th scope="col">Request</th>
    </tr>
    </thead>
    <tbody>
    <%
    Date prevDate = null;
    for(Date date : dates){
        if(Objects.isNull(selectedDates) || !selectedDates.contains(date)){
            if (prevDate != null && !date.equals(prevDate)) {
                %>
                <tr  style="background-color: transparent;"><td colspan="6">&nbsp;</td></tr>
                <%
            }
            for(Classroom clsroom : classroomList.get(date)){
                %>
                <tr>
                    <td><%=clsroom.getClassCode()%></td>
                    <td><%=clsroom.getCapacity()%></td>
                    <td><%=clsroom.isProjector()%></td>
                    <td><%=clsroom.getPlugs()%></td>
                    <td><%=date%></td>
                    <td><a href="/postRequest/<%= clsroom.getClassCode() %>/<%= date %>" class="btn btn-success">Request this room</a></td>
                </tr>
                <%
            }
            prevDate = date;
        }
    }
    %>

    </tbody>
</table>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
</div>
<%
    }else {
%>

<div class="container text-center">
    <h3 align="center">No Classrooms available for your choice</h3>
    <h4 align="center">Try Again!</h4>
    <% if (session.getAttribute("userType").equals("professor")){%>
    <button class="btn b"> <a href="/AvailableClassrooms.jsp">Return to Dashboard</a></button>
    <% } else if (session.getAttribute("userType").equals("sac")){%>
    <button class="btn b"> <a href="/SACDashboard.jsp">Return to Dashboard</a></button>
    <% } else if (session.getAttribute("userType").equals("committee")){%>
    <button class="btn b"> <a href="/CommitteeDashboard.jsp">Return to Dashboard</a></button>
    <% } else if (session.getAttribute("userType").equals("ta")){%>
    <button class="btn b"> <a href="/TADashboard.jsp">Return to Dashboard</a></button>
    <% } %>
</div>

<%
    }
%>

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

<!-- <script>
  window.location.reload(true);
</script>
 -->



<%-- 
<script th:if="${param.req_save_msg}">
    location.reload();
</script> --%>



<script>
    var refreshTime = ${refreshTime};
    setTimeout(function() {
        location.reload();
    }, refreshTime * 1000);
</script>



</body>
<% }
else {
    response.sendRedirect("LoginFirst.jsp");
}
%>
</html>