<%-- 
    Document   : HomeAdministratorView
    Created on : May 14, 2017, 5:54:30 PM
    Author     : walter
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="ConnectionModel.ConnectionModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--String pw = "";--%>
<%String pw = "UtnCboV1";%>

﻿<!DOCTYPE html>
<html>
    <head>
        <title> Administrador de juegos </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/crudStyle.css">
        <link rel="stylesheet" href="css/modalStyle.css">
        <link rel="stylesheet" href="css/listGamesStyle.css">
        <script src="./js/modal.js"></script>
    </head>

    <body>
	    <div class="banner">
	        <div class="imageBanner">
	          <img src="images/escudo.jpg" alt="Escudo UG" width="112" height="42" title="Escudo de la Universidad de Guanajuato">  
	 	</div>

                <% int num = 0; %>
                <div class="header">
                    <ul class="nav">
                        <li><a href="homeAdministratorView.html" class="inicio"> Home </a></li>
                        <li><a href="" class="administrar"> Manage </a>
                            <ul>
                                <li><a href="listGamesView.jsp" class="juegos"> Games</a></li>
                                <li><a href="listRequestView.jsp" class="request"> Request <h6 class="noti" align="center"><%= num %></h6> </a></li>
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
<!--CAMBIAR EL id Y class DE LOS DOS DIV PARA PODER HACER SUS PROPIOS ESTILOS -->

            <div class="instrucciones">
                <p class="text"> La siguiente tabla muestra las solicitudes de juegos que han sido realizadas
                                 por parte de los profesores registrados en el sistema. Para aceptar una solicitud
                                 escriba el ID de la solicitud en el cuadro de texto de debajo y presione en boton
                                 "Accept request".
                </p>
            </div>

            <input type="text" id="txtRequest" name="txtRequest" value="" placeholder="  ID">
            <button id="btnAccept" onclick="openInsert()"> Accept request </button>
<!--            <% ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", pw); %>
            <% Statement querySelect = connect.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); %>
            <% String query = "SELECT Material.idMaterial, Material.Material_Nombre, Juego.Juego_Idioma, Material.Material_Habilidad, Material.Material_Disponible, Juego.Juego_NumeroParticipantes, Juego.Juego_TiempoSugerido, Juego.Juego_EtiquetasVocabulario, Juego.Juego_Descripcion, Juego.Juego_InstruccionesUso FROM Material INNER JOIN Juego ON Material.idMaterial = Juego.Material_idMaterial;"; %>
            <% ResultSet selectGames = querySelect.executeQuery(query); %>

            <% while( selectGames.next() ){ %>
            
            <% }%>
-->
<!-- COMIENZA EL MODAL DONDE SE MUESTRA EL FORMULARIO PARA INSERTAR UN NUEVO JUEGO -->
            <!-- Contenedor del modal -->
            <form action="InsertJuegoServlet" method="post">
            <div id="modalInsert" class="modalInsert">
              <!-- Contenido del modal -->
              <div class="modalInsert-content">
                <div class="modalInsert-header" align="center">
                  <span class="close" onclick="closeSpanInsert()">&times;</span>
                  <h2> Add the values of the games to insert </h2>
                </div>
                <div class="modalInsert-body">
                <!-- Comienza el formulario para agregar un nuevo juego -->
                    <div class="mainContainer">
                        <div class="objetsContainer">

                        </div>
                    </div>
                </div>
              </div>
            </div>
            </form>

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
