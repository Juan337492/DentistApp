<%-- 
   
 Java 3
 Juan Rodriguez
 I promise I wrote this code.
 12/2/2021
 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessObjects.dentist"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Dentist Information</title>
    </head>
       <% 
        dentist dent1;
        dent1 = (dentist)session.getAttribute("dent1");

        %>
    
    <body>
        <ul>
                 <li><a class="active" href="index.html">Home</a></li>
                 <li><a href="patientLogin.jsp">Patient Login</a></li>
                 <li><a href="dentistsLogin.jsp">Dentist Login</a></li>
            </ul>
        <h1 class="headerStandard">Update personal information</h1>
        <div class="loginPrompt">
        <form action="http://localhost:8080/DentistWebApp/dentistUpdateInfo" method="post" accept-charset="utf-8" class="loginForm" style="color: black;">
            <label for="id">Your ID</label><br>
            <input type="text" id="id" name="id" value=<%=dent1.getId()%>>
            <br><br>
            <label for="fname">Change dentist first name :</label><br>
            <input type="text" id="fname" name="fname" placeholder="First Name">
            <br><br>
            <label for="lname">Change dentist last name :</label><br>
            <input type="text" id="lname" name="lname" placeholder="Last Name" >
            <br><br>
            <label for="office">Change Office :</label><br>
            <input type="text" id="office" name="office" placeholder="office">
            <br><br>
            <p>On submit you will have to login again.</p>
            <br>
            <input type="submit" value="Update">
            <input type="reset" value="Clear">
        </form>
    </div>
        
<div class="buttonContainer">
    <a href="dentist.jsp"><button class="btnStyling">Dentist information</button></a>
     <a href="dentistUpdateInfo.jsp"><button class="btnStyling">Update information</button></a>
    <a href="dentistViewAppt.jsp"><button class="btnStyling">View appointments</button></a>   
</div>
    </body>
</html>
