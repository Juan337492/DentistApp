<%-- 
   
 Java 3
 Juan Rodriguez
 I promise I wrote this code.
 12/2/2021
 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="BusinessObjects.appointment"%>
<%@page import="BusinessObjects.dentist"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Dentist Appointments</title>
    </head>

    <body>
        <ul>
                 <li><a class="active" href="index.html">Home</a></li>
                 <li><a href="patientLogin.jsp">Patient Login</a></li>
                 <li><a href="dentistsLogin.jsp">Dentist Login</a></li>
        </ul>
        <h1 class="headerStandard">Dentist Appointments</h1>
            <% 
    dentist dent1; 
    dent1 = (dentist)session.getAttribute("dent1");  
    
    appointment p3;
    p3 = (appointment)session.getAttribute("p3");

    int appointments = dent1.aList.count;
        for (int n = 0 ; n < appointments; n++){
         p3 = dent1.aList.accArr[n];
    %>
        
         <div class="accountData" style="border: 1px black solid;">
            <tr >
                <td><p class="dataP">Appointment date: </p><%=p3.getApptDateTime()%></td>
            <br>
                <td><p class="dataP">Patient ID: </p><%=p3.getPatId()%></td>
            <br>            
                <td><p class="dataP">Dentist ID: <p><%=p3.getDentId()%></td>
            <br>
                <td><p class="dataP">Procedure code: <p><%=p3.getProcCode()%></td>
</tr>
<% } %>
    </div>
    
<div class="buttonContainer">
       <a href="dentist.jsp"><button class="btnStyling">Dentist information</button></a>
    <a href="dentistUpdateInfo.jsp"><button class="btnStyling">Update information</button></a>
    <a href="dentistViewAppt.jsp"><button class="btnStyling">View appointments</button></a>   
</div>
    </body>
</html>
