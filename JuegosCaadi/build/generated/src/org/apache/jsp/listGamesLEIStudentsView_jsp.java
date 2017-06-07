package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.Connection;
import java.sql.Statement;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.DriverManager;
import ConnectionModel.ConnectionModel;

public final class listGamesLEIStudentsView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("    Document   : listGamesStudentsView\n");
      out.write("    Created on : 18/05/2017, 07:00:35 PM\n");
      out.write("    Author     : Iron-kike\n");
      out.write("--%>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
String pw = "UtnCboV1";
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("﻿<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/listGamesStyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/crudStyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/modalStyle.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/modal.js\"> </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\t    <div class=\"banner\">\n");
      out.write("\t        <div class=\"imageBanner\">\n");
      out.write("\t          <img src=\"images/escudo.jpg\" alt=\"Escudo UG\" width=\"112\" height=\"42\" title=\"Escudo de la Universidad de Guanajuato\">  \n");
      out.write("\t \t</div>\n");
      out.write("                \n");
      out.write("                <div class=\"header\">\n");
      out.write("                    <ul class=\"nav\">\n");
      out.write("                        <li><a href=\"homeLEIStudentsView.html\" class=\"inicio\"> Home </a></li>\n");
      out.write("                        <li><a href=\"listGamesLEIStudentsView.jsp\" class=\"administrar\"> Games</a></li>\n");
      out.write("                        <li><a href=\"\" class=\"reportes\"> Reports </a></li>\n");
      out.write("                        <li><a href=\"logInView.html\" class=\"sigout\"> Log out </a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\t    </div>\n");
      out.write("<!--CAMBIAR EL id Y class DE LOS DOS DIV PARA PODER HACER SUS PROPIOS ESTILOS -->\n");
      out.write("\n");
      out.write("            <div class=\"instrucciones\">\n");
      out.write("                <p class=\"text-stundent\"> A continuacion se muestra un listado de los juegos incluidos en el catalogo\n");
      out.write("                    del CAADI. Tienes la opcion de insertar un nuevo juego y modificar un juego existente.\n");
      out.write("                </p>\n");
      out.write("                <button id=\"btnInsert\" align=\"center\" onclick=\"openInsert()\"> Insert new game </button>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
 ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", pw); 
      out.write("\n");
      out.write("            ");
 Statement querySelect = connect.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
      out.write("\n");
      out.write("            ");
 String query = "SELECT Material.idMaterial, Material.Material_Nombre, Juego.Juego_Idioma, Material.Material_Habilidad, Material.Material_Disponible, Juego.Juego_NumeroParticipantes, Juego.Juego_TiempoSugerido, Juego.Juego_EtiquetasVocabulario, Juego.Juego_Descripcion, Juego.Juego_InstruccionesUso, Material.Material_Clase, Material.Material_Existencia, Juego.Juego_MaterialAdicional FROM Juego INNER JOIN Material ON Material.idMaterial = Juego.Material_idMaterial;"; 
      out.write("\n");
      out.write("            ");
 ResultSet selectGames = querySelect.executeQuery(query); 
      out.write("\n");
      out.write("            \n");
      out.write("            ");
 int count = 0; 
      out.write("\n");
      out.write("            ");
 while( selectGames.next() ){ 
      out.write("\n");
      out.write("                <table id=\"tableGames\" class=\"count\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th rowspan=\"5\" class=\"framImage\">\n");
      out.write("                            <img src=\"images/game2.jpg\" height=\"250\" width=\"230\" id=\"imageGame\">\n");
      out.write("                        </th>\n");
      out.write("                        <td align=\"left\" id=\"nameGame\"> Name:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"name_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(2) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                        <td align=\"left\" id=\"lenguageGame\"> Lenguage:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue2\" id=\"lenguage_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(3) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" id=\"skillsGame\"> Skills:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"skills_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(4) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                        <td align=\"left\" id=\"availableGame\"> Games available:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue2\" id=\"availableGame_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(5) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" id=\"vocabularyGame\"> Vocabulary:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"vocabularyGame_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(8) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                        <td align=\"left\" id=\"gamersNum\"> Number of gamers:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue2\" id=\"gamersNum_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(6) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" id=\"aditionalMaterial\"> Additional material\n");
      out.write("                            <input type=\"text\" class=\"textValue\" id=\"adicional_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(13) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                        <td align=\"left\" id=\"timeGame\"> Suggested time:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue2\" id=\"timeGame_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(7) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" id=\"descriptionGame\"> Description:\n");
      out.write("                            <textarea disabled=\"true\" class=\"textValueEspecial\" id=\"descriptionGame_");
      out.print(count);
      out.write('"');
      out.write('>');
      out.print( selectGames.getString(9) );
      out.write(" </textarea>\n");
      out.write("                        </td>\n");
      out.write("                        <td align=\"left\" id=\"instructionsGame\"> Instructions:\n");
      out.write("                            <textarea disabled=\"true\" class=\"textValueEspecial\" id=\"instructionsGame_");
      out.print(count);
      out.write("\" align=\"left\">");
      out.print( selectGames.getString(10) );
      out.write(" </textarea>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"3\">\n");
      out.write("                            <button id=\"btnModify-LEI\" onclick=\"modify(");
      out.print(count);
      out.write(")\"> Modify </button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <input type=\"text\" style=\"display: none\" disabled=\"true\" class=\"textValue\" id=\"id_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(1) );
      out.write("\">\n");
      out.write("                    <input type=\"text\" style=\"display: none\" class=\"textValue\" id=\"clase_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(11) );
      out.write("\">\n");
      out.write("                    <input type=\"text\" style=\"display: none\" class=\"textValue\" id=\"existencia_");
      out.print(count);
      out.write("\" value=\"");
      out.print( selectGames.getString(12) );
      out.write("\">\n");
      out.write("                </table>\n");
      out.write("                ");
 count++; 
      out.write("\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("            \n");
      out.write("<!-- COMIENZA EL MODAL DONDE SE MUESTRA EL FORMULARIO PARA INSERTAR UN NUEVO JUEGO -->\n");
      out.write("            <!-- Contenedor del modal -->\n");
      out.write("            <form action=\"InsertJuegoServlet\" method=\"post\">\n");
      out.write("            <div id=\"modalInsert\" class=\"modalInsert\">\n");
      out.write("              <!-- Contenido del modal -->\n");
      out.write("              <div class=\"modalInsert-content\">\n");
      out.write("                <div class=\"modalInsert-header\" align=\"center\">\n");
      out.write("                  <span class=\"close\" onclick=\"closeSpan1()\">&times;</span>\n");
      out.write("                  <h2> Llena todos los campos con los valores permitidos </h2>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modalInsert-body\">\n");
      out.write("                <!-- Comienza el formulario para agregar un nuevo juego -->\n");
      out.write("                    <div class=\"mainContainer\">\n");
      out.write("                        <div class=\"objetsContainer\">\n");
      out.write("                            <table class=\"tableInsert\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"num\" > ID </h5>\n");
      out.write("                                    <input type=\"text\" class=\"num\" name=\"IdMaterial\" value=\"\" size=\"25\" placeholder=\"  Solo numeros\" />                                        \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"name\"> Nombre </h5>\n");
      out.write("                                    <input type=\"text\" class=\"name\" name=\"Nombre\" value=\"\" size=\"25\" placeholder=\"  Nombre del juego\" />\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"class\"> Clase de juego a la que pertenece  </h5>\n");
      out.write("                                    <input type=\"text\" class=\"clase\" name=\"Clase\" value=\"\" size=\"25\" placeholder=\" e.g. Juego de roles, memorizacion\" />\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"exist\"> Numero de juegos en existencia </h5>\n");
      out.write("                                    <input type=\"text\" class=\"existencia\" name=\"Existencia\" value=\"\" size=\"25\" placeholder=\" Cantidad de juegos en existencia\" />\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"able\"> Numero de juegos disponibles </h5>\n");
      out.write("                                    <input type=\"text\" class=\"disponible\" name=\"Disponible\" value=\"\" size=\"25\" placeholder=\"  Cantidad de juegos disponibles\" />\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"skills\"> Habilidades que se practican </h5>\n");
      out.write("                                    <input type=\"text\" class=\"habilidad\" name=\"Habilidad\" value=\"\" size=\"25\" placeholder=\"  e.g. Speaking, Writting\" />\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"lenguage\"> Idioma que se practica </h5>\n");
      out.write("                                    <input type=\"text\" class=\"idioma\" name=\"Idioma\" value=\"\" size=\"25\" placeholder=\" e.g. Ingles, Frances \" />                          \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"numPart\"> Numero de participantes </h5>\n");
      out.write("                                    <input type=\"text\" class=\"numeroParticipantes\" name=\"NumeroParticipantes\" value=\"\" size=\"25\" placeholder=\"  e.g. 4, 5 \" />\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"time\"> Tiempo sugerido </h5>\n");
      out.write("                                    <input type=\"text\" class=\"time\" name=\"TiempoSugerido\" value=\"\" size=\"25\" placeholder=\"  e.g. 15 minutos. \" />\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"vocabulary\"> Vocabulario que incluye </h5>\n");
      out.write("                                    <input type=\"text\" class=\"vocabulario\" name=\"EtiquetasVocabulario\" value=\"\" size=\"25\" placeholder=\"  Vocabulario que incluye el juego \" />\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"material\"> Material adicional al juego </h5>\n");
      out.write("                                    <input type=\"text\" class=\"materialAdicional\" name=\"MaterialAdicional\" value=\"\" size=\"25\" placeholder=\"  e.g.  Dados, libro de instrucciones \" />\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"instrucciones\"> Instrucciones de uso </h5>\n");
      out.write("                                    <textarea class=\"instructions\" name=\"InstruccionesUso\" rows=\"4\" cols=\"28\" placeholder=\"  Breve descripcion de como se utiliza el juego.\" > </textarea>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"description\"> Descripcion del juego </h5>\n");
      out.write("                                    <textarea class=\"description\" name=\"Description\" rows=\"4\" cols=\"28\" placeholder=\"  En que consiste el juego y su dinamica. \" > </textarea>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"submit\" value=\"Save game\" class=\"btnInsertGame\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("<!-- COMIENZA EL MODAL DONDE SE MUESTRA EL FORMULARIO PARA MODIFICAR UN NUEVO JUEGO -->\n");
      out.write("            <!-- Contenedor del modal -->\n");
      out.write("            <form action=\"UpdateJuegoServlet\" method=\"post\">\n");
      out.write("            <div id=\"modalModify\" class=\"modalModify\">\n");
      out.write("              <!-- Contenido del modal -->\n");
      out.write("              <div class=\"modalModify-content\">\n");
      out.write("                <div class=\"modalModify-header\" align=\"center\">\n");
      out.write("                    <span class=\"close\" onclick=\"closeSpan2()\">&times;</span>\n");
      out.write("                  <h2> </h2>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modalModify-body\">\n");
      out.write("                <!-- Comienza el formulario para agregar un nuevo juego -->\n");
      out.write("                    <div class=\"mainContainer\">\n");
      out.write("                        <div class=\"objetsContainer\">\n");
      out.write("                            <table class=\"tableInsert\">\n");
      out.write("                            <tr>\n");
      out.write("                                    <input style=\"display: none\" type=\"text\" id=\"ID\" class=\"num\" name=\"IdMaterial\" value=\"\" size=\"25\" style=\"visibility:hidden;\" />\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"name\"> Nombre </h5>\n");
      out.write("                                    <input type=\"text\" id=\"NAME\" class=\"name\" name=\"Nombre\" value=\"\" size=\"25\" />                                        \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"clase\"> Clase </h5>\n");
      out.write("                                    <input type=\"text\" id=\"CLASE\" class=\"clase\" name=\"Clase\" value=\"\" size=\"25\" />                                        \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"exist\"> Existencia </h5>\n");
      out.write("                                    <input type=\"text\" id=\"EXIST\" class=\"existencia\" name=\"Existencia\" value=\"\" size=\"25\" />                                        \n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"able\"> Disponible </h5>\n");
      out.write("                                    <input type=\"text\" id=\"ABLE\" class=\"disponible\" name=\"Disponible\" value=\"\" size=\"25\" />                                        \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"skills\"> Habilidades </h5>\n");
      out.write("                                    <input type=\"text\" id=\"SKILLS\" class=\"habilidad\" name=\"Habilidad\" value=\"\" size=\"25\" />                                        \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"lenguage\"> Idioma </h5>\n");
      out.write("                                    <input type=\"text\" id=\"LENGUAGE\" class=\"idioma\" name=\"Idioma\" value=\"\" size=\"25\" />                                        \n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"numPart\"> Numero de participantes </h5>\n");
      out.write("                                    <input type=\"text\" id=\"NUMPART\" class=\"numeroParticipantes\" name=\"NumeroParticipantes\" value=\"\" size=\"25\" />                                        \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"time\"> Tiempo sugerido </h5>\n");
      out.write("                                    <input type=\"text\" id=\"TIME\" class=\"time\" name=\"TiempoSugerido\" value=\"\" size=\"25\" />                                        \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"vocabulary\"> Vocabulario </h5>\n");
      out.write("                                    <input type=\"text\" id=\"VOCABULARY\" class=\"vocabulario\" name=\"EtiquetasVocabulario\" value=\"\" size=\"25\" />\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"material\"> Material adicional </h5>\n");
      out.write("                                    <input type=\"text\" id=\"MATERIAL\" class=\"materialAdicional\" name=\"MaterialAdicional\" value=\"\" size=\"25\" />\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"instructions\"> Instrucciones de uso </h5>\n");
      out.write("                                    <textarea id=\"INSTRUCTIONS\" class=\"instructions\" name=\"InstruccionesUso\" rows=\"4\" cols=\"25\" > </textarea>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <h5 id=\"description\"> Descripcion </h5>\n");
      out.write("                                    <textarea id=\"DESCRIPTION\" class=\"description\" name=\"Description\" rows=\"4\" cols=\"25\" > </textarea>                                    \n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"submit\" value=\"Save game\" class=\"btnModifyGame\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <h3 class=\"footerText\" align=\"center\"> Department of Multidisciplinary Studies of Yuriria <br>\n");
      out.write("                           Suburb Yacatitas, C.P. 38940 <br>\n");
      out.write("                           Yuriria, Gto., Mexico <br>\n");
      out.write("                           Tel: +52 (445) 458 90 40. Exts: 1703, 1709, 1706 y 1718. <br>\n");
      out.write("                           dem@ugto.mx\n");
      out.write("        </h3>\n");
      out.write("    </footer>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
