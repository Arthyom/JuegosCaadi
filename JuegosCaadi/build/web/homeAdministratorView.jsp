<%-- 
    Document   : HomeAdministratorView
    Created on : May 14, 2017, 5:54:30 PM
    Author     : Iron-kike
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="ConnectionModel.ConnectionModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿<!DOCTYPE html>
<html>
    <head>
        <title>Vista de Administradores</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/listGamesStyle.css">
        <link rel="stylesheet" href="css/crudStyle.css">
    </head>

    <body>
	    <div class="banner">
	        <div class="imageBanner">
	          <img src="images/escudo.jpg" alt="Escudo UG" width="112" height="42" title="Escudo de la Universidad de Guanajuato">  
	 	</div>

                <div class="header">
                    <ul class="nav">
                        <li><a href="homeAdministratorView.html" class="inicio"> Home </a></li>
                        <li><a href="" class="administrar"> Manage </a>
                            <ul>
                                <li><a href="homeAdministratorView.jsp" class="juegos"> Games</a></li>
                                <li><a href="" class="materias"> Subjects </a></li>
                                <li><a href="" class="estudiantes"> Students </a></li>
                                <li><a href="" class="usuarios"> Users </a></li>
                            </ul>
                        </li>
                        <li><a href="" class="reportes"> Reports </a></li>
                        <li><a href="logInView.html" class="sigout"> Log out </a></li>
                    </ul>
                </div>
	    </div>

            <div class="instrucciones">
                <p> A continuacion se muestra un listado de los juegos inlcuidos en el catalogo
                    del CAADI. Para modificar o eliminar un juego mueva el cursos encima de cada
                    juego.
                </p>
            </div>

            <input type="submit" value="Insert new game" class="btnInsert">
            <% ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", "kike"); %>
            <!-- ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", "UtnCboV1"); -->
            <% Statement querySelect = connect.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); %>
            <% String query = "SELECT Material.idMaterial, Material.Material_Nombre, Material.Material_Habilidad, Juego.Juego_TiempoSugerido, Juego.Juego_Descripcion FROM Material INNER JOIN Juego ON Material.idMaterial = Juego.Material_idMaterial"; %>
            <% ResultSet selectGames = querySelect.executeQuery(query); %>

            <table id="tableGames">
            <tr>
                <td align="center"> ID </td>
                <td align="center"> Nombre </td>
                <td align="center"> Habilidades </td>
                <td align="center"> Duracion </td>
                <td align="center"> Descripcion </td>
                <td> </td>
            </tr>

            <% while( selectGames.next() ){ %>
                <tr>
                    <td align="center" > <%= selectGames.getString(1) %> </td>
                    <td align="center" > <%= selectGames.getString(2) %> </td>
                    <% String value = selectGames.getString(1); %>
                    <%-- <%= value %> --%>
                    <td align="center" > <%= selectGames.getString(3) %> </td>
                    <td align="center" > <%= selectGames.getString(4) %> </td>
                    <td align="center" > <%= selectGames.getString(5) %> </td>
                    <td> <input type="submit" class="btnModify" value="Modify">
                         <input type="submit" class="btnDelete" value="Delete"> </td>
                </tr>
            <% }%>
            </table>
            
    </body>

    <footer>
        <h3 class="footerText" align="center"> Department of Multidisciplinary Studies of Yuriria <br>
                           Suburb Yacatitas, C.P. 38940 <br>
                           Yuriria, Gto., Mexico <br>
                           Tel: +52 (445) 458 90 40. Exts: 1703, 1709, 1706 y 1718. <br>
                           dem@ugto.mx
        </h3>
    </footer>
</html>
