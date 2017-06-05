<%-- 
    Document   : listGamesStudentsView
    Created on : 18/05/2017, 07:00:35 PM
    Author     : Iron-kike
--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="ConnectionModel.ConnectionModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%String pw = "UtnCboV1";%>

﻿<!DOCTYPE html>
<html>
    <head>
        <title> Solicitar juegos </title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/listGamesStyle.css">
        <link rel="stylesheet" href="css/crudStyle.css">
        <link rel="stylesheet" href="css/modalStyle.css">
        <script type="text/javascript" src="js/modal.js"> </script>
    </head>

    <body>
	    <div class="banner">
	        <div class="imageBanner">
	          <img src="images/escudo.jpg" alt="Escudo UG" width="112" height="42" title="Escudo de la Universidad de Guanajuato">  
	 	</div>
                
                <div class="header-teacher">
                    <ul class="nav-teacher">
                        <li><a href="logInView.html" class="logout"> Log out </a></li>
                    </ul>
                </div>
	    </div>
<!--CAMBIAR EL id Y class DE LOS DOS DIV PARA PODER HACER SUS PROPIOS ESTILOS -->

            <div class="instrucciones">
                <p class="text"> Del siguiente listado de juegos incluidos en el catalogo del CAADI, usted podra elegir cual desea solicitar.
                                 Escriba, dentro del cuadro de texto de debajo, el ID del juego que desee solicitar.
                </p>
            </div>

            <input type="text" id="txtSolicitar" name="txtSolicitar" value="" placeholder="  ID">
            <button id="btnSolicitar" align="center" onclick="openInsert()"> Solicit </button>

<!-- COMIENZA EL MODAL DONDE SE MUESTRA EL FORMULARIO PARA INSERTAR UN NUEVO JUEGO -->
            <!-- Contenedor del modal -->
            <div id="modalInsert" class="modalInsert" name='modal'>
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
