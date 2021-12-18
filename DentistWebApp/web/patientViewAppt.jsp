<%-- 
   
 Java 3
 Juan Rodriguez
 I promise I wrote this code.
 12/2/2021
 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessObjects.appointment"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">

        <title>View your appointment</title>
    </head>
    <%
        appointment p2;
        p2 = (appointment)session.getAttribute("p2");
       
    %>
    <body>
         <ul>
                 <li><a class="active" href="index.html">Home</a></li>
                 <li><a href="patientLogin.jsp">Patient Login</a></li>
                 <li><a href="dentistsLogin.jsp">Dentist Login</a></li>
            </ul>
        
        <h1 class="headerStandard">View appointment</h1>
        
        <div class="accountData" >
            <tr >
                <td><p class="dataP">Your ID is</p><%=p2.getPatId()%></td>
            <br>
                <td><p class="dataP">Your appointment is on</p><%=p2.getApptDateTime()%></td>
            <br>
</tr>
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
