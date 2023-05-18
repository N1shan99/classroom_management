<%@ page import="com.spe.ClassroomManagementSystem.Models.TA" %>
<%@ page import="org.springframework.http.ResponseEntity" %>
<%@ page import="org.springframework.web.bind.annotation.RequestMapping" %>
<%--<%@ page import="org.springframework.web.bind.annotation.RequestBody" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> Internship</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/css/index.css">
    <link rel="stylesheet" href="/css/All.css">
    <script src="/js/AddClassroom.js"></script>

    <style>
        body{
            font-family: Ubuntu;
            /*background: rgba(181,123,229,0.16);*/
            background: url("/images/reduced_opacity_bg.jpeg");

        }
        nav a{ color: white;
        }

    </style>


</head>
<body>

<nav class="navbar navbar-fixed-top navbar-light" style="background-color: #563D7C; ">
    <!-- Navbar content -->
  <a class="navbar-brand" href="index.html">Clasroom Manager</a>
    <ul class="nav navbar-nav navbar-left">
        <li><a href="Internship.jsp"> Internship </a></li>
        
    </ul>
    <ul class="nav navbar-nav navbar-right">
    </ul>
</nav>



<div class="form-group">
                                               <h1 id="capacity-label" align="left">This is the internship form for the Kerala Police Academy,Thrissur</h1>
                       
                        <h5 id="capacity-label" align="left">Hey, You should send the internship Form data in the morning between 10 am to 12 pm,</h5>
                                         <h5 id="capacity-label" align="left">otherwise your data might not be viewed.</h5>
                 
                 </div>




<div class="container">
    <div class="login-container" style="width: 500px; margin: 30px auto">
        <div id="output"></div>
        <h5>Internship Form</h5>
        <div class="form-box">
            <form  id="addclass-form" action="/internship" method="">
                <div class="form-group">
                   <label>Name</label>
                    <input id="internname" name="internname" type="text" placeholder="Name" >
                </div>
                
                <div class="form-group">
                    <!-- <h5 id="capacity-label" align="left" style="margin-top: 5px">College Name</h5> -->
                    <label>College name</label>
                    <input id="collegename" name="collegename" type="text" placeholder="College Name" >
                </div>
                
            <!--      <div class="form-group">
                    <h5 id="capacity-label" align="left" style="margin-top: 5px">University Name</h5>
                    <input id="uniname" name="uniname" type="text" placeholder="University Name" >
                </div>
                
                
                <div class="form-group">
                    <h5 id="capacity-label" align="left" style="margin-top: 5px">Course Name</h5>
                    <input id="coursename" name="coursename" type="text" placeholder="Course Name" >
                </div> -->
                
                
               
                
                
                 <div class="form-group">
                   <label>Duration</label>
                    <input id="duration" name="duration" type="number" placeholder="Duration in days" >
                </div>
                
                
                 <h5 id="capacity-label" align="left"></h5>


                <div class="form-group">
                        <input id="noc" name="noc" type="file"  style="display: none;" placeholder="NOC as pdf">
                 </div>
               
           
                
                 <h5 id="capacity-label" align="left"></h5>


                <div class="form-group">
                        <input id="resume" name="resume" type="file"  style="display: none;" placeholder="Resume as pdf">
                 </div>
                
                
                 <label>Email address</label>
                 <div class="form-group">
                 <input type="email" id="professorEmail" name="professorEmail" class="form-control" placeholder="Email"  required>
                 </div>
                 
                 
                 <label>Mobile no</label>
                 <div class="form-group">
                 <input type="number" id="mob" name="mob" class="form-control" placeholder="Mobile no"  required>
                 </div>




                

                <button class="btn  btn-secondary btn-block login mybutton"  type="submit">Send Request Form</button>
<%--                <p>${class_save_msg}</p>--%>
            </form>
        </div>
    </div>

</div>
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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/additional-methods.js"></script>



</body>
</html>