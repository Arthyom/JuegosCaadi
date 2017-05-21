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

            <button id="btnInsert" onclick="openInsert()"> Add new game </button>
            <button id="btnModify" onclick="openModify()"> Modify </button>
            <button class="btnDelete" onclick="openDelete()"> Delete </button>
            <% ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", pw); %>
            <% Statement querySelect = connect.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); %>
            <% String query = "SELECT Material.idMaterial, Material.Material_Nombre, Material.Material_Habilidad, Juego.Juego_TiempoSugerido, Juego.Juego_Descripcion FROM Material INNER JOIN Juego ON Material.idMaterial = Juego.Material_idMaterial"; %>
            <% ResultSet selectGames = querySelect.executeQuery(query); %>

            <table id="tableColumns">
            <tr>
                <td align="left" id="ID"> ID </td>
                <td align="left" id="Nombre"> Nombre </td>
                <td align="center" id="Habilidades"> Habilidades </td>
                <td align="center" id="Duracion"> Duracion </td>
                <td align="center" id="Descripcion"> Descripcion </td>
            </tr>
            </table>

            <table id="tableGames">
            <% while( selectGames.next() ){ %>
                <tr>
                    <td align="center" id="ide"> <%= selectGames.getString(1) %> </td>
                    <td> <%= selectGames.getString(2) %> </td>
                    <% String value = selectGames.getString(1); %>
                    <td> <%= selectGames.getString(3) %> </td>
                    <td> <%= selectGames.getString(4) %> </td>
                    <td> <%= selectGames.getString(5) %> </td>
                </tr>
            <% }%>
            </table>

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
                                    <h5 id="able"> NUmero de juegos disponibles </h5>
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
                    <span class="close" onclick="closeSpanModify()">&times;</span>
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
                                    <input type="text" class="num" name="IdMaterial" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="name"> Nombre </h5>
                                    <input type="text" class="name" name="Nombre" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="class"> Clase </h5>
                                    <input type="text" class="clase" name="Clase" value="" size="25" />                                        
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="exist"> Existencia </h5>
                                    <input type="text" class="existencia" name="Existencia" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="able"> Disponible </h5>
                                    <input type="text" class="disponible" name="Disponible" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="skills"> Habilidades </h5>
                                    <input type="text" class="habilidad" name="Habilidad" value="" size="25" />                                        
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="lenguage"> Idioma </h5>
                                    <input type="text" class="idioma" name="Idioma" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="numPart"> Numero de participantes </h5>
                                    <input type="text" class="numeroParticipantes" name="NumeroParticipantes" value="" size="25" />                                        
                                </td>
                                <td>
                                    <h5 id="time"> Tiempo sugerido </h5>
                                    <input type="text" class="time" name="TiempoSugerido" value="" size="25" />                                        
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="vocabulary"> Vocabulario </h5>
                                    <input type="text" class="vocabulario" name="EtiquetasVocabulario" value="" size="25" />
                                </td>
                                <td>
                                    <h5 id="material"> Material adicional </h5>
                                    <input type="text" class="materialAdicional" name="MaterialAdicional" value="" size="25" />    
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <h5 id="instrucciones"> Instrucciones de uso </h5>
                                    <textarea class="instructions" name="InstruccionesUso" rows="4" cols="25" > </textarea>
                                </td>
                                <td>
                                    <h5 id="description"> Descripcion </h5>
                                    <textarea class="description" name="Description" rows="4" cols="25" > </textarea>                                    
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

<!-- COMIENZA EL MODAL DONDE SE MUESTRA EL FORMULARIO PARA ELIMINAR UN NUEVO JUEGO -->
            <!-- Contenedor del modal -->
            <form action="EliminarJuegoServlet" method="post">
            <div id="modalDelete" class="modalDelete">
              <!-- Contenido del modal -->
              <div class="modalDelete-content">
                <div class="modalDelete-header" align="center">
                    <span class="close" onclick="closeSpanDelete()">&times;</span>
                    <h3 align="center"> Delete a game </h3>
                </div>
                <div class="modalDelete-body">
                <!-- Comienza el formulario para agregar un nuevo juego -->
                    <div class="mainContainer">
                        <div class="objetsContainer">
                            <p class="textDelete" > Type the ID game to delete it </p>
                            <input type="text" class="deleteID" name="IdMaterialBorrar" id="IdMaterialBorrar">
                                <button class="btnDeleteM"> Delete game </button>
                           </form>
                        </div>
                    </div>
                </div>
              </div>
            </div>


<!-- Codigo JavaScript para abrir el modal y poder insertar un nuevo juego.
     Para ello, el formulario realiza la consulta correspondiente y redirecciona
     a la vista para administrar los juegos, lo que actualiza la tabla de juegos
     incluyendo los juegos recien agregados.
-->
            <script>
                var modal = document.getElementById("modalInsert");
                var modal2 = document.getElementById("modalModify");
                var modal3 = document.getElementById("modalDelete");

                function openInsert(){
                    modal.style.display = "block";
                }

                function openModify(){
                    modal2.style.display = "block";
                }
                
                function openDelete(){
                    modal3.style.display = "block";                    
                }

                function closeSpanModify(){
                    modal2.style.display = "none";
                }

                function closeSpanInsert(){
                    modal.style.display = "none";
                }

                function closeSpanDelete(){
                    modal3.style.display = "none";
                }

                window.onclick = function(event) {
                    if (event.target == modal || event.target == modal2 || event.target == modal3) {
                        modal.style.display = "none";
                        modal2.style.display = "none";
                        modal3.style.display = "none";
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
