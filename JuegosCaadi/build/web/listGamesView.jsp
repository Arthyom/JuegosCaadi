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

<%String pw = "kike";%>
<%-- <%String pw = "UtnCboV1";%> --%>

﻿<!DOCTYPE html>
<html>
    <head>
        <title> Administrador de juegos </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/listGamesStyle.css">
        <link rel="stylesheet" href="css/crudStyle.css">
        <link rel="stylesheet" href="css/modalStyle.css">
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
                <p class="text"> A continuacion se muestra un listado de los juegos incluidos en el catalogo
                    del CAADI.
                </p>
            </div>

            <button id="btnInsert" align="center"> Insert new game </button>
            <% ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", pw); %>
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
                <td align="center"> </td>
            </tr>

            <% while( selectGames.next() ){ %>
                <tr>
                    <td align="center"> <%= selectGames.getString(1) %> </td>
                    <td> <%= selectGames.getString(2) %> </td>
                    <% String value = selectGames.getString(1); %>
                    <td> <%= selectGames.getString(3) %> </td>
                    <td> <%= selectGames.getString(4) %> </td>
                    <td> <%= selectGames.getString(5) %> </td>
                    <td> <input type="submit" class="btnModify" value="Modify">
                         <input type="submit" class="btnDelete" value="Delete"> </td>
                </tr>
            <% }%>
            </table>
            
            <!-- Contenedor del modal -->
            <div id="modalInsert" class="modalInsert">

              <!-- Contenido del modal -->
              <div class="modalInsert-content">
                <div class="modalInsert-header">
                  <span class="close">&times;</span>
                  <h2>Modal Header</h2>
                </div>
                <div class="modalInsert-body">
                <!-- Comienza el formulario para agregar un nuevo juego -->
                    <div class="mainContainer">
                        <div class="objetsContainer">
                            <h3 class="indication" align="center" > DATOS DEL JUEGO A INSERTAR EN EL CATALOGO DEL CAADI</h3>
                            <h5 id="num" > ID. </h5>
                            <input type="text" class="num" name="IdMaterial" value="" size="25" />
                            <h5 id="name"> Nombre </h5>
                            <input type="text" class="name" name="Nombre" value="" size="25" />
                            <h5 id="skills"> Clase </h5>
                            <input type="text" class="clase" name="Clase" value="" size="25" />
                            <h5 id="skills"> Existencia </h5>
                            <input type="text" class="existencia" name="Existencia" value="" size="25" />
                            <h5 id="skills"> Disponible </h5>
                            <input type="text" class="disponible" name="Disponible" value="" size="25" />
                            <h5 id="skills"> Habilidades </h5>
                            <input type="text" class="habilidad" name="Habilidad" value="" size="25" />
                            <h5 id="skills"> Idioma </h5>
                            <input type="text" class="idioma" name="Idioma" value="" size="25" />
                            <h5 id="time"> Numero de participantes </h5>
                            <input type="text" class="numeroParticipantes" name="NumeroParticipantes" value="" size="25" />
                            <h5 id="time"> Tiempo sugerido </h5>
                            <input type="text" class="time" name="TiempoSugerido" value="" size="25" />
                            <h5 id="time"> Vocabulario </h5>
                            <input type="text" class="vocabulario" name="EtiquetasVocabulario" value="" size="25" />
                            <h5 id="time"> Material adicional </h5>
                            <input type="text" class="materialAdicional" name="MaterialAdicional" value="" size="25" />
                            <h5 id="time"> Instrucciones de uso </h5>
                            <textarea class="instructions" name="InstruccionesUso" rows="4" cols="25" > </textarea>
                            <h5 id="description"> Descripcion </h5>
                            <textarea class="description" name="Description" rows="4" cols="25" > </textarea>
                            <input type="submit" value="Insertar">
                        </div>
                    </div>
                </div>
                <div class="modalInsert-footer">
                  <h3>Modal Footer</h3>
                </div>
              </div>

            </div>

<!-- Codigo JavaScript para abrir el modal y poder insertar un nuevo juego.
     Para ello, el formulario realiza la consulta correspondiente y redirecciona
     a la vista para administrar los juegos, lo que actualiza la tabla de juegos
     incluyendo los juegos recien agregados.
-->
            <script>
                // Get the modal
                var modal = document.getElementById("modalInsert");

                // Get the button that opens the modal
                var btn = document.getElementById("btnInsert");

                // Get the <span> element that closes the modal
                var span = document.getElementsByClassName("close")[0];

                // When the user clicks the button, open the modal 
                btn.onclick = function() {
                    modal.style.display = "block";
                }

                // When the user clicks on <span> (x), close the modal
                span.onclick = function() {
                    modal.style.display = "none";
                }

                // When the user clicks anywhere outside of the modal, close it
                window.onclick = function(event) {
                    if (event.target == modal) {
                        modal.style.display = "none";
                    }
                }
            </script>
            
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
