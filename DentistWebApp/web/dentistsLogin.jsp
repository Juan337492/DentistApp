<%-- 
   
 Java 3
 Juan Rodriguez
 I promise I wrote this code.
 12/2/2021
 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Dentist Login</title>
    </head>
    <body style="background-color: #005c99;">
        <ul>
                 <li><a class="active" href="index.html">Home</a></li>
                 <li><a href="patientLogin.jsp">Patient Login</a></li>
                 <li><a href="dentistsLogin.jsp">Dentist Login</a></li>
            </ul>

    <h1 class="loginHeader"> Dentist Login </h1>
    <div class="loginPrompt">
        <form action="http://localhost:8080/DentistWebApp/dentistLoginServlet" method="post" accept-charset="utf-8" class="loginForm" >
            <label for="id">Dentist ID :</label><br>
            <input type="text" id="dentId" name="dentId" placeholder="ID"><br>
            <br>
            <label for="password">Password :</label><br>
            <input type="password" id="pass" name="password" placeholder="Password" >
            <br><br>
            <input type="submit" value="Login">
            <input type="reset" value="Clear">
        </form>
    </div>
    </body>
</html>
