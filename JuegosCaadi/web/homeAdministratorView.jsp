<%-- 
    Document   : homeAdministratorView
    Created on : Jun 7, 2017, 1:49:44 AM
    Author     : walter
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title> Administracion del sistema de CAADI </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/homeAdministratorStyle.css">
    </head>

    <body>
    <div id="main">
        <div class="banner">
            <div class="imageBanner">
                <img src="images/escudo.jpg" alt="Escudo UG" width="112" height="42" title="Escudo de la Universidad de Guanajuato">  
            </div>

            <% int number = 0; %>
            <div class="header">
                <ul class="nav">
                    <li><a href="homeAdministratorView.html" class="inicio"> Home </a></li>
                    <li><a href="" class="administrar"> Manage </a>
                        <ul>
                            <li><a href="listGamesView.jsp" class="juegos"> Games</a></li>
                            <li><a href="listRequestView.jsp" class="request"> Request <p class="numberRequest" align="center"><%=number %></p> </a></li>
                            <li><a href="" class="materias"> Subjects </a></li>
                            <li><a href="" class="estudiantes"> Students </a></li>
                            <li><a href="" class="usuarios"> Users </a></li>
                        </ul>
                    </li>
                    <li><a href="" class="reportes"> Reports  </a></li>
                    <li><a href="logInView.html" class="sigout"> Log out </a></li>
                </ul>
            </div>
        </div>

	<p class="welcomeMessages" align="center"> WELCOME TO THE SYSTEM FOR THE MANAGEMENT OF CAADI GAMES! </p>

	<div id="imageBody">
		<img src="images/english.jpg" alt="Ingles" width="600" height="350" >
	</div>
    </div>
        
    <footer>
        <h3 class="footerText" align="center"> Department of Multidisciplinary Studies of Yuriria <br>
                           Suburb Yacatitas, C.P. 38940 <br>
                           Yuriria, Gto., Mexico <br>
                           Tel: +52 (445) 458 90 40. Exts: 1703, 1709, 1706 y 1718. <br>
                           dem@ugto.mx
        </h3> 
    </footer>

    </body>
</html>
