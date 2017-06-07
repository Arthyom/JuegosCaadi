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

<%--String pw = "";--%>
<%String pw = "UtnCboV1";%>
<%--String pw = "";--%>

﻿<!DOCTYPE html>
<html>
    <head>
        <title> Teacher's Request </title>
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
                        <li><a href="homeTeacherView.html" class="inicio"> Home </a></li>
                        <li><a href="listGamesTeacherView.jsp" class="administrar"> Games</a></li>
                        <li><a href="logInView.html" class="sigout"> Log out </a></li>
                    </ul>
                </div>
	    </div>
<!--CAMBIAR EL id Y class DE LOS DOS DIV PARA PODER HACER SUS PROPIOS ESTILOS -->

            <div class="instrucciones">
                <p class="text-teacher"> A continuacion se muestra un listado de los juegos incluidos en el catalogo
                    del CAADI. Tienes la opcion de solicitar un juego existente.
                </p>
            </div>

            <% ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", pw); %>
            <% Statement querySelect = connect.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); %>
            <% String query = "SELECT Material.idMaterial, Material.Material_Nombre, Juego.Juego_Idioma, Material.Material_Habilidad, Material.Material_Disponible, Juego.Juego_NumeroParticipantes, Juego.Juego_TiempoSugerido, Juego.Juego_EtiquetasVocabulario, Juego.Juego_Descripcion, Juego.Juego_InstruccionesUso, Material.Material_Clase, Material.Material_Existencia, Juego.Juego_MaterialAdicional FROM Juego INNER JOIN Material ON Material.idMaterial = Juego.Material_idMaterial;"; %>
            <% ResultSet selectGames = querySelect.executeQuery(query); %>

            <% int count = 0; %>
            <% while( selectGames.next() ){ %>
                <table id="tableGames" class="count">
                    <tr>
                        <th rowspan="5" class="framImage">
                            <img src="images/game2.jpg" height="250" width="230" id="imageGame">
                        </th>
                        <td align="left" id="nameGame"> Name:
                            <input type="text" disabled="true" class="textValue" id="name_<%=count%>" value="<%= selectGames.getString(2) %>">
                        </td>
                        <td align="left" id="lenguageGame"> Lenguage:
                            <input type="text" disabled="true" class="textValue2" id="lenguage_<%=count%>" value="<%= selectGames.getString(3) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="skillsGame"> Skills:
                            <input type="text" disabled="true" class="textValue" id="skills_<%=count%>" value="<%= selectGames.getString(4) %>">
                        </td>
                        <td align="left" id="availableGame"> Games available:
                            <input type="text" disabled="true" class="textValue2" id="availableGame_<%=count%>" value="<%= selectGames.getString(5) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="vocabularyGame"> Vocabulary:
                            <input type="text" disabled="true" class="textValue" id="vocabularyGame_<%=count%>" value="<%= selectGames.getString(8) %>">
                        </td>
                        <td align="left" id="gamersNum"> Number of gamers:
                            <input type="text" disabled="true" class="textValue2" id="gamersNum_<%=count%>" value="<%= selectGames.getString(6) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="aditionalMaterial"> Additional material
                            <input type="text" class="textValue" id="adicional_<%=count%>" value="<%= selectGames.getString(13) %>">
                        </td>
                        <td align="left" id="timeGame"> Suggested time:
                            <input type="text" disabled="true" class="textValue2" id="timeGame_<%=count%>" value="<%= selectGames.getString(7) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="descriptionGame"> Description:
                            <textarea disabled="true" class="textValueEspecial" id="descriptionGame_<%=count%>"><%= selectGames.getString(9) %> </textarea>
                        </td>
                        <td align="left" id="instructionsGame"> Instructions:
                            <textarea disabled="true" class="textValueEspecial" id="instructionsGame_<%=count%>" align="left"><%= selectGames.getString(10) %> </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <button class="btnRequest" onclick="Request(<%=count%>)"> Request </button>
                        </td>
                    </tr>
                    <input type="text" style="display: none" disabled="true" class="textValue" id="id_<%=count%>" value="<%= selectGames.getString(1) %>">
                    <input type="text" style="display: none" class="textValue" id="clase_<%=count%>" value="<%= selectGames.getString(11) %>">
                    <input type="text" style="display: none" class="textValue" id="existencia_<%=count%>" value="<%= selectGames.getString(12) %>">
                </table>
                <% count++; %>
            <% }%>
            
            <!-- COMIENZA EL MODAL DONDE SE MUESTRA LA CONFIRMACIÓN DE UNA SOLICITUD DE UN JUEGO -->
            <!-- Contenedor del modal -->
            <form action="InsertSolcitudServlet" method="post">
            <div id="modalRequest" class="modalRequest">
              <!-- Contenido del modal -->
              <div class="modalRequest-content">
                <div class="modalRequest-header" align="center">
                    <span class="close" onclick="closeSpan4()">&times;</span>
                </div>
                <div class="modalRequest-body">
                    <div class="mainContainer">
                        <div class="objetsContainer">
                            <img src="images/Question.png" class="warningImage">
                            <p class="textDelete" > Are you sure you want to request: </p>
                            <input type="text" class="requestGame" id="requestID" value="" disabled="true"/>
                            <input type="text" class="requestGame" id="IdMaterialSolicitado" name="IdMaterialSolicitado" style="display: none"/>
                                <button class="btnRequestM"> Request </button>
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
