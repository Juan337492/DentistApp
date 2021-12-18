<%-- 
   
 Java 3
 Juan Rodriguez
 I promise I wrote this code.
 12/2/2021
 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessObjects.appointment"%>
<%@page import="BusinessObjects.patient"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="style.css">
        <title>New appointment</title>
    </head>
       <%
        appointment appt1;
        appt1 = (appointment)session.getAttribute("p2");
       
    %>
    <body>
            <ul>
                 <li><a class="active" href="index.html">Home</a></li>
                 <li><a href="patientLogin.jsp">Patient Login</a></li>
                 <li><a href="dentistsLogin.jsp">Dentist Login</a></li>
            </ul>
        <h1 class="headerStandard">Add new appointment</h1>
         <div class="loginPrompt">
        <form action="http://localhost:8080/DentistWebApp/patientNewAppt" method="post" accept-charset="utf-8" class="loginForm" style="color: black;">
            <label for="id">Your ID</label><br>
            <input type="text" id="id" name="id" value=<%=appt1.getPatId()%>>
            <br><br>
            <label for="date">New appointment date :</label><br>
            <input type="text" id="date" name="date" placeholder="Month day, year, time">
            <br><br>
            <label for="dentId">Dentist Id :</label><br>
            <input type="text" id="dentId" name="dentId" value=<%=appt1.getDentId()%>>
            <br><br>
            <label for="procCode">Procedure :</label><br>
            <input type="text" id="procCode" name="procCode" value=<%=appt1.getProcCode()%>>
            <br><br>
            <p>If patient already has appointment you will be re-directed to view appointment page.</p>
            <p>If appointment does not exist on submit new appointment will be made and you will have to login again.</p>
            <br>
            <input type="submit" value="Submit">
            <input type="reset" value="Clear">
        </form>
    </div>
<div class="buttonContainer">
     <a href="patient.jsp"><button class="btnStyling">Patient information</button></a>
    <a href="patientUpdateInfo.jsp"><button class="btnStyling">Update information</button></a>
    <a href="patientUpdateAppt.jsp"><button class="btnStyling">Change appointment</button></a>
    <a href="patientViewAppt.jsp"><button class="btnStyling">View appointment</button></a>
    <a href="patientNewAptt.jsp"><button class="btnStyling">Add appointment</button></a>
</div>
    </body>
</html>
