<%-- 
   
 Java 3
 Juan Rodriguez
 I promise I wrote this code.
 12/2/2021
 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessObjects.patient"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link rel="stylesheet" href="style.css">
        <title>Update Information</title>
    </head>
   <% 
        patient p1;
        p1 = (patient)session.getAttribute("p1");

        %>
    <body>
         <ul>
                 <li><a class="active" href="index.html">Home</a></li>
                 <li><a href="patientLogin.jsp">Patient Login</a></li>
                 <li><a href="dentistsLogin.jsp">Dentist Login</a></li>
            </ul>
        <h1 class="headerStandard">Update personal information</h1>
        <div class="loginPrompt">
        <form action="http://localhost:8080/DentistWebApp/patientUpdateInfo" method="post" accept-charset="utf-8" class="loginForm" style="color: black;">
            <label for="id">Your ID</label><br>
            <input type="text" id="customerId" name="id" placeholder="ID" value=<%=p1.getPatId()%>>
            <br><br>
            <label for="fname">Change patient first name :</label><br>
            <input type="text" id="fname" name="fname" placeholder="First Name">
            <br><br>
            <label for="lname">Change patient last name :</label><br>
            <input type="text" id="lname" name="lname" placeholder="Last Name" >
            <br><br>
            <label for="address">Change address :</label><br>
            <input type="text" id="address" name="address" placeholder="Address">
            <br><br>
            <p>On submit you will have to login again.</p>
            <br>
           
        <br />
            <input type="submit" value="Update">
            <input type="reset" value="Clear">
        </form>
    </div>
        
<div class="buttonContainer">
    <a href="patient.jsp"><button class="btnStyling">Patient information</button></a>
    <a href="patientUpdateInfo.jsp"><button class="btnStyling">Update information</button></a>
    <a href="patientUpdateAppt.jsp"><button class="btnStyling">Update appointment</button></a>
    <a href="patientViewAppt.jsp"><button class="btnStyling">View appointment</button></a>
    <a href="patientNewAptt.jsp"><button class="btnStyling">Add new appointment</button></a>
</div>

    </body>
</html>
