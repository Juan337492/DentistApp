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
        <title>Dentist</title>
    </head>
    <body>
               <ul>
                 <li><a class="active" href="index.html">Home</a></li>
                 <li><a href="patientLogin.jsp">Patient Login</a></li>
                 <li><a href="dentistsLogin.jsp">Dentist Login</a></li>
            </ul>
        <h1 class="headerStandard">Dentist information</h1>
        
        <% 
        dentist dent1;
        dent1 = (dentist)session.getAttribute("dent1");

        %>
        <div class="accountData" >
            <tr >
                <td><p class="dataP">Dentist id: </p><%=dent1.getId()%></td>
            <br>
                <td><p class="dataP">Dentist first name: </p><%=dent1.getFirstName()%></td>
            <br>
                <td><p class="dataP">Dentist last name:</p><%=dent1.getLastName()%></td>
            <br>
                <td><p class="dataP">Dentist office:</p><%=dent1.getOffice()%></td>
            <br>
</tr>
    </div>
<div class="buttonContainer">
    <a href="dentistUpdateInfo.jsp"><button class="btnStyling">Update information</button></a>
    <a href="dentistViewAppt.jsp"><button class="btnStyling">View appointments</button></a>
    
</div>
    </body>
</html>
