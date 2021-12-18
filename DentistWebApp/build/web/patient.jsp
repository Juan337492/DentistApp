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
        <title>Patient</title>
    </head>
    <body>
        <ul>
                 <li><a class="active" href="index.html">Home</a></li>
                 <li><a href="patientLogin.jsp">Patient Login</a></li>
                 <li><a href="dentistsLogin.jsp">Dentist Login</a></li>
            </ul>
        <h1 class="headerStandard">Patient information</h1>
        
        <% 
        patient p1;
        p1 = (patient)session.getAttribute("p1");

        %>
        <div class="accountData" >
            <tr >
                <td><p class="dataP">Patient first name: </p><%=p1.getFirstName()%></td>
            <br>
                <td><p class="dataP">Patient last name: </p><%=p1.getLastName()%></td>
            <br>            
                <td><p class="dataP">Patient address: </p><%=p1.getAddress()%></td>
            <br>
                <td><p class="dataP">Patient email:</p><%=p1.getEmail()%></td>
            <br>
                <td><p class="dataP">Patient insurance company: </p><%=p1.getInsCo()%></td>
</tr>
    </div>
<div class="buttonContainer">
    <a href="patientUpdateInfo.jsp"><button class="btnStyling">Update information</button></a>
    <a href="patientUpdateAppt.jsp"><button class="btnStyling">Update appointment</button></a>
    <a href="patientViewAppt.jsp"><button class="btnStyling">View appointment</button></a>
    <a href="patientNewAptt.jsp"><button class="btnStyling">Add new appointment</button></a>
</div>
    </body>
</html>
