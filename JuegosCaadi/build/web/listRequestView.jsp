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

<%String pw = "";%>
<%--String pw = "UtnCboV1";--%>
<%--String pw = "";--%>



﻿<!DOCTYPE html>
<html>
    <head>
        <title> Administrar solicitudes</title>
        <meta charset="UTF-8">
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
                
                <div class="header">
                    <ul class="nav">
                        <li><a href="homeAdministratorView.html" class="inicio"> Home </a></li>
                        <li><a href="" class="administrar"> Manage </a>
                            <ul>
                                <li><a href="listGamesView.jsp" class="juegos"> Games</a></li>
                                <li><a href="listRequestView.jsp" class="request"> Request </a></li>
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
                                  presione en el botón "Approve" correspondiente a cada juego. En su defecto para
                                  rechazar dicho prestamo pulse en "Desapprove" del respectivo juego.
                </p>
            </div>

            <% ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", pw); %>
            <% Statement querySelect = connect.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); %>
            <% String query = "SELECT * FROM Solicitud WHERE Status = 'Pendiente';"; %> <%--WHERE Fecha_Respuesta = 'NO'--%>
            <% ResultSet selectGames = querySelect.executeQuery(query); %>
            
            <% int count = 0; %>
            <% while( selectGames.next() ){ %>
                <table id="tableGames" class="count">
                    <tr>
                        <th rowspan="5">
                            <img src="images/game2.jpg" height="250" width="230" id="imageGame">
                        </th>
                        <td align="left" id="ide"> idSolicitud:
                            <input type="text" disabled="true" class="textValue" id="id_<%=count%>" value="  <%= selectGames.getString(1) %>">
                        </td>
                        <td align="left" id="nameGame"> Observaciones de salida: 
                            <input type="text" disabled="true" class="textValue" id="name_<%=count%>" value="  <%= selectGames.getString(2) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="lenguageGame"> Observaciones de entrada:
                            <input type="text" disabled="true" class="textValue" id="lenguage_<%=count%>" value="  <%= selectGames.getString(3) %>">
                        </td>
                        <td align="left" id="skillsGame"> Fecha de petición:
                            <input type="text" disabled="true" class="textValue" id="skills_<%=count%>" value="  <%= selectGames.getString(4) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="availableGame"> Fecha de respuesta:
                            <input type="text" disabled="true" class="textValue" id="availableGame_<%=count%>" value="  <%= selectGames.getString(5) %>">
                        </td>
                        <td align="left" id="gamersNum"> Fecha de terminación:
                            <input type="text" disabled="true" class="textValue" id="gamersNum_<%=count%>" value="  <%= selectGames.getString(6) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="timeGame"> Profesor al que fue prestado:
                            <input type="text" disabled="true" class="textValue" id="timeGame_<%=count%>" value="  <%= selectGames.getString(7) %>">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <button class="btnAprov" onclick="Aprov(<%=count%>)"> Approve</button>
                            <button class="btnRech" onclick="Rech(<%=count%>)"> Disapprove </button>
                        </td>
                    </tr>
                </table>
                <% count++; %>
            <% }%>
            
            <!-- COMIENZA EL MODAL DONDE SE MUESTRA LA APROVACIÓN DE UNA SOLICITUD DE UN JUEGO -->
            <!-- Contenedor del modal -->
            <form action="AceptarJuegoServlet" method="post">
            <div id="modalAprov" class="modalAprov">
              <!-- Contenido del modal -->
              <div class="modalAprov-content">
                <div class="modalAprov-header" align="center">
                    <span class="close" onclick="closeSpan5()">&times;</span>
                </div>
                <div class="modalAprov-body">
                    <div class="mainContainer">
                        <div class="objetsContainer">
                            <img src="images/Question.png" class="warningImage">
                            <p class="textDelete" > Are you sure you want to approve: </p>
                            <input type="text" class="aprovGame" id="aprovID" value="" disabled="false"/>
                            <input type="text" class="aprovtGame" id="IdMaterialAprov" name="IdMaterialAprov" style="display: none"/>
                                <button class="btnAprovM"> Approve </button>
                           </form>
                        </div>
                    </div>
                </div>
              </div>
            </div>
                
                
                <!-- COMIENZA EL MODAL DONDE SE MUESTRA LA DESAPROVACION DE UNA SOLICITUD DE UN JUEGO -->
            <!-- Contenedor del modal -->
            <form action="RechazarSolicitudServlet" method="post">
            <div id="modalRech" class="modalRech">
              <!-- Contenido del modal -->
              <div class="modalRech-content">
                <div class="modalRech-header" align="center">
                    <span class="close" onclick="closeSpan6()">&times;</span>
                </div>
                <div class="modalRech-body">
                    <div class="mainContainer">
                        <div class="objetsContainer">
                            <img src="images/Question.png" class="warningImage">
                            <p class="textDelete" > Are you sure you want to desapprove: </p>
                            <input type="text" class="rechGame" id="rechID" value="" disabled="false"/>
                            <input type="text" class="rechGame" id="IdMaterialRech" name="IdMaterialRech" style="display: none"/>
                                <button class="btnRechM"> Disapprove </button>
                           </form>
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