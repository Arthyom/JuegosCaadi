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
                        <li><a href="homeLEIStudentsView.html" class="inicio"> Home </a></li>
                        <li><a href="listGamesLEIStudentsView.jsp" class="administrar"> Games</a></li>
                        <li><a href="" class="reportes"> Reports </a></li>
                        <li><a href="logInView.html" class="sigout"> Log out </a></li>
                    </ul>
                </div>
	    </div>
<!--CAMBIAR EL id Y class DE LOS DOS DIV PARA PODER HACER SUS PROPIOS ESTILOS -->

            <div class="instrucciones">
                <p class="text-stundent"> A continuacion se muestra un listado de los juegos incluidos en el catalogo
                    del CAADI. Tienes la opcion de insertar un nuevo juego y modificar un juego existente.
                </p>
                <button id="btnInsert" align="center" onclick="openInsert()"> Insert new game </button>
            </div>

            <% ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", pw); %>
            <% Statement querySelect = connect.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); %>
            <% String query = "SELECT Material.idMaterial, Material.Material_Nombre, Juego.Juego_Idioma, Material.Material_Habilidad, Material.Material_Disponible, Juego.Juego_NumeroParticipantes, Juego.Juego_TiempoSugerido, Juego.Juego_EtiquetasVocabulario, Juego.Juego_Descripcion, Juego.Juego_InstruccionesUso FROM Material INNER JOIN Juego ON Material.idMaterial = Juego.Material_idMaterial;"; %>
            <% ResultSet selectGames = querySelect.executeQuery(query); %>
            
            <% int count = 0; %>
            <% while( selectGames.next() ){ %>
                <table id="tableGames" class="count">
                    <tr>
                        <th rowspan="5">
                            <img src="images/game2.jpg" height="250" width="230" id="imageGame">
                        </th>
                        <td align="left" id="ide"> ID:
                            <input type="text" disabled="true" class="textValue" id="id_<%=count%>" value="  <%= selectGames.getString(1) %>">
                        </td>
                        <td align="left" id="nameGame"> Name: 
                            <input type="text" disabled="true" class="textValue" id="name_<%=count%>" value="  <%= selectGames.getString(2) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="lenguageGame"> Lenguage:
                            <input type="text" disabled="true" class="textValue" id="lenguage_<%=count%>" value="  <%= selectGames.getString(3) %>">
                        </td>
                        <td align="left" id="skillsGame"> Skills:
                            <input type="text" disabled="true" class="textValue" id="skills_<%=count%>" value="  <%= selectGames.getString(4) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="availableGame"> Games available:
                            <input type="text" disabled="true" class="textValue" id="availableGame_<%=count%>" value="  <%= selectGames.getString(5) %>">
                        </td>
                        <td align="left" id="gamersNum"> In stock:
                            <input type="text" disabled="true" class="textValue" id="gamersNum_<%=count%>" value="  <%= selectGames.getString(6) %>">
                        </td>
                    </tr>
                    <tr>
                        <td align="left" id="timeGame"> Suggested time:
                            <input type="text" disabled="true" class="textValue" id="timeGame_<%=count%>" value="  <%= selectGames.getString(7) %>">
                        </td>
                        <td align="left" id="vocabularyGame"> Vocabulary:
                            <input type="text" disabled="true" class="textValue" id="vocabularyGame_<%=count%>" value="  <%= selectGames.getString(8) %>">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" align="left" id="descriptionGame"> Description:
                            <textarea disabled="true" class="textValueEspecial" id="descriptionGame_<%=count%>"> <%= selectGames.getString(9) %> </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" align="left" id="instructionsGame"> Instructions:
                            <textarea disabled="true" class="textValueEspecial" id="instructionsGame_<%=count%>" align="left">  <%= selectGames.getString(10) %> </textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <button id="btnModify" onclick="modify(<%=count%>)"> Modify </button>
                        </td>
                    </tr>
                </table>
                <% count++; %>
            <% }%>
            
<!-- COMIENZA EL MODAL DONDE SE MUESTRA EL FORMULARIO PARA INSERTAR UN NUEVO JUEGO -->
            <!-- Contenedor del modal -->
            <form action="InsertJuegoServlet" method="post">
            <div id="modalInsert" class="modalInsert">
              <!-- Contenido del modal -->
              <div class="modalInsert-content">
                <div class="modalInsert-header" align="center">
                  <span class="close" onclick="closeSpan1()">&times;</span>
                  <h2> Llena todos los campos con los valores permitidos </h2>
                </div>
                <div class="modalInsert-body">
                <!-- Comienza el formulario para agregar un nuevo juego -->
                    <div class="mainContainer">
                        <div class="objetsContainer">
                            <table class="tableInsert">
                            <tr>
                                <td>
                                    <h5 id="num" > ID </h5>
                                    <input type="text" class="num" name="IdMaterial" value="" size="25" placeholder="  Solo numeros" />                                        
                                </td>
                                <td>
                                    <h5 id="name"> Nombre </h5>
                                    <input type="text" class="name" name="Nombre" value="" size="25" placeholder="  Nombre del juego" />
                                </td>
                                <td>
                                    <h5 id="class"> Clase de juego a la que pertenece  </h5>
                                    <input type="text" class="clase" name="Clase" value="" size="25" placeholder=" e.g. Juego de roles, memorizacion" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="exist"> Numero de juegos en existencia </h5>
                                    <input type="text" class="existencia" name="Existencia" value="" size="25" placeholder=" Cantidad de juegos en existencia" />
                                </td>
                                <td>
                                    <h5 id="able"> Numero de juegos disponibles </h5>
                                    <input type="text" class="disponible" name="Disponible" value="" size="25" placeholder="  Cantidad de juegos disponibles" />
                                </td>
                                <td>
                                    <h5 id="skills"> Habilidades que se practican </h5>
                                    <input type="text" class="habilidad" name="Habilidad" value="" size="25" placeholder="  e.g. Speaking, Writting" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="lenguage"> Idioma que se practica </h5>
                                    <input type="text" class="idioma" name="Idioma" value="" size="25" placeholder=" e.g. Ingles, Frances " />                          
                                </td>
                                <td>
                                    <h5 id="numPart"> Numero de participantes </h5>
                                    <input type="text" class="numeroParticipantes" name="NumeroParticipantes" value="" size="25" placeholder="  e.g. 4, 5 " />
                                </td>
                                <td>
                                    <h5 id="time"> Tiempo sugerido </h5>
                                    <input type="text" class="time" name="TiempoSugerido" value="" size="25" placeholder="  e.g. 15 minutos. " />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="vocabulary"> Vocabulario que incluye </h5>
                                    <input type="text" class="vocabulario" name="EtiquetasVocabulario" value="" size="25" placeholder="  Vocabulario que incluye el juego " />
                                </td>
                                <td>
                                    <h5 id="material"> Material adicional al juego </h5>
                                    <input type="text" class="materialAdicional" name="MaterialAdicional" value="" size="25" placeholder="  e.g.  Dados, libro de instrucciones " />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="instrucciones"> Instrucciones de uso </h5>
                                    <textarea class="instructions" name="InstruccionesUso" rows="4" cols="28" placeholder="  Breve descripcion de como se utiliza el juego." > </textarea>
                                </td>
                                <td>
                                    <h5 id="description"> Descripcion del juego </h5>
                                    <textarea class="description" name="Description" rows="4" cols="28" placeholder="  En que consiste el juego y su dinamica. " > </textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="submit" value="Save game" class="btnInsertGame">
                                </td>
                            </tr>
                            </table>
                        </div>
                    </div>
                </div>
              </div>
            </div>
            </form>

<!-- COMIENZA EL MODAL DONDE SE MUESTRA EL FORMULARIO PARA MODIFICAR UN NUEVO JUEGO -->
            <!-- Contenedor del modal -->
            <form action="UpdateJuegoServlet" method="post">
            <div id="modalModify" class="modalModify">
              <!-- Contenido del modal -->
              <div class="modalModify-content">
                <div class="modalModify-header" align="center">
                    <span class="close" onclick="closeSpan2()">&times;</span>
                  <h2> Modify the values of the games</h2>
                </div>
                <div class="modalModify-body">
                <!-- Comienza el formulario para agregar un nuevo juego -->
                    <div class="mainContainer">
                        <div class="objetsContainer">
                            <table class="tableInsert">
                            <tr>
                                <td>
                                    <h5 id="num" > ID </h5>
                                    <input type="text" id="ID" class="num" name="IdMaterial" value="" size="25" />
                                </td>
                                <td>
                                    <h5 id="name"> Nombre </h5>
                                    <input type="text" id="NAME" class="name" name="Nombre" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="class"> Clase </h5>
                                    <input type="text" id="CLASE" class="clase" name="Clase" value="" size="25" />                                        
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="exist"> Existencia </h5>
                                    <input type="text" id="EXIST" class="existencia" name="Existencia" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="able"> Disponible </h5>
                                    <input type="text" id="ABLE" class="disponible" name="Disponible" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="skills"> Habilidades </h5>
                                    <input type="text" id="SKILLS" class="habilidad" name="Habilidad" value="" size="25" />                                        
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="lenguage"> Idioma </h5>
                                    <input type="text" id="LENGUAGE" class="idioma" name="Idioma" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="numPart"> Numero de participantes </h5>
                                    <input type="text" id="NUMPART" class="numeroParticipantes" name="NumeroParticipantes" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="time"> Tiempo sugerido </h5>
                                    <input type="text" id="TIME" class="time" name="TiempoSugerido" value="" size="25" />                                        
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="vocabulary"> Vocabulario </h5>
                                    <input type="text" id="VOCABULARY" class="vocabulario" name="EtiquetasVocabulario" value="" size="25" />
                                </td>
                                <td>
                                    <h5 id="material"> Material adicional </h5>
                                    <input type="text" id="MATERIAL" class="materialAdicional" name="MaterialAdicional" value="" size="25" />    
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="instrucciones"> Instrucciones de uso </h5>
                                    <textarea id="INSTRUCTIONS" class="instructions" name="InstruccionesUso" rows="4" cols="25" > </textarea>
                                </td>
                                <td>
                                    <h5 id="description"> Descripcion </h5>
                                    <textarea id="DESCRIPTION" class="description" name="Description" rows="4" cols="25" > </textarea>                                    
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="submit" value="Save game" class="btnModifyGame">                                    
                                </td>
                            </tr>
                            </table>
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
