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

public final class homeTeacherView_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
String pw = "UtnCboV1";
      out.write("\n");
      out.write("\n");
      out.write("﻿<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title> Solicitar juegos </title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/listGamesStyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/crudStyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/modalStyle.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/modal.js\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\t    <div class=\"banner\">\n");
      out.write("\t        <div class=\"imageBanner\">\n");
      out.write("\t          <img src=\"images/escudo.jpg\" alt=\"Escudo UG\" width=\"112\" height=\"42\" title=\"Escudo de la Universidad de Guanajuato\">  \n");
      out.write("\t \t</div>\n");
      out.write("                \n");
      out.write("                <div class=\"header-teacher\">\n");
      out.write("                    <ul class=\"nav-teacher\">\n");
      out.write("                        <li><a href=\"logInView.html\" class=\"logout\"> Log out </a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\t    </div>\n");
      out.write("<!--CAMBIAR EL id Y class DE LOS DOS DIV PARA PODER HACER SUS PROPIOS ESTILOS -->\n");
      out.write("\n");
      out.write("            <div class=\"instrucciones\">\n");
      out.write("                <p class=\"text\"> Del siguiente listado de juegos incluidos en el catalogo del CAADI, usted podra elegir cual desea solicitar.\n");
      out.write("                                 Escriba, dentro del cuadro de texto de debajo, el ID del juego que desee solicitar.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <input type=\"text\" id=\"txtSolicitar\" name=\"txtSolicitar\" value=\"\" placeholder=\"  ID\">\n");
      out.write("            <button id=\"btnSolicitar\" align=\"center\" onclick=\"openSolicit()\"> Solicit </button>\n");
      out.write("<!--            ");
 ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", pw); 
      out.write("\n");
      out.write("            ");
 Statement querySelect = connect.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
      out.write("\n");
      out.write("            ");
 String query = "SELECT Material.idMaterial, Material.Material_Nombre, Juego.Juego_Idioma, Material.Material_Habilidad, Material.Material_Disponible, Juego.Juego_NumeroParticipantes, Juego.Juego_TiempoSugerido, Juego.Juego_EtiquetasVocabulario, Juego.Juego_Descripcion, Juego.Juego_InstruccionesUso FROM Material INNER JOIN Juego ON Material.idMaterial = Juego.Material_idMaterial;"; 
      out.write("\n");
      out.write("            ");
 ResultSet selectGames = querySelect.executeQuery(query); 
      out.write("\n");
      out.write("            \n");
      out.write("            ");
 while( selectGames.next() ){ 
      out.write("\n");
      out.write("                <table id=\"tableGames\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th rowspan=\"4\" id=\"imageGame\">\n");
      out.write("                            <img src=\"images/noimage1.png\" height=\"250\" width=\"230\">\n");
      out.write("                        </th>\n");
      out.write("                        <td align=\"left\" id=\"ide\"> ID: ");
      out.print( selectGames.getString(1) );
      out.write(" </td>\n");
      out.write("                        <td align=\"left\" id=\"nameGame\"> Name: ");
      out.print( selectGames.getString(2) );
      out.write(" </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" id=\"lenguageGame\"> Lenguage: ");
      out.print( selectGames.getString(3) );
      out.write(" </td>\n");
      out.write("                        <td align=\"left\" id=\"skillsGame\"> Skills: ");
      out.print( selectGames.getString(4) );
      out.write(" </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" id=\"availableGame\"> Games available: ");
      out.print( selectGames.getString(5) );
      out.write(" </td>\n");
      out.write("                        <td align=\"left\" id=\"gamersNum\"> Number of gamers: ");
      out.print( selectGames.getString(6) );
      out.write(" </td>\n");
      out.write("                    </tr>\n");
      out.write("                        <td align=\"left\" id=\"timeGame\"> Suggested time: ");
      out.print( selectGames.getString(7) );
      out.write(" </td>\n");
      out.write("                        <td align=\"left\" id=\"vocabularyGame\"> Vocabulary: ");
      out.print( selectGames.getString(8) );
      out.write(" </td>\n");
      out.write("                    <tr> \n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"3\" align=\"left\" id=\"descriptionGame\"> Description: ");
      out.print( selectGames.getString(9) );
      out.write(" </th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"3\" align=\"left\" id=\"instructionsGame\"> Instructions: ");
      out.print( selectGames.getString(10) );
      out.write(" </th>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("-->\n");
      out.write("<!-- COMIENZA EL MODAL DONDE SE MUESTRA EL FORMULARIO PARA INSERTAR UN NUEVO JUEGO -->\n");
      out.write("            <!-- Contenedor del modal -->\n");
      out.write("            <form action=\"SolicitarJuegoServlet\" method=\"post\">\n");
      out.write("            <div id=\"modalSolicit\" class=\"modalSolicit\">\n");
      out.write("              <!-- Contenido del modal -->\n");
      out.write("              <div class=\"modalSolicit-content\">\n");
      out.write("                <div class=\"modalSolicit-header\" align=\"center\">\n");
      out.write("                  <span class=\"close\" onclick=\"closeSpan()\">&times;</span>\n");
      out.write("                  <h2> Confirm game to solicit </h2>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modalSolicit-body\">\n");
      out.write("                <!-- Comienza el formulario para agregar un nuevo juego -->\n");
      out.write("                    <div class=\"mainContainer\">\n");
      out.write("                        <div class=\"objetsContainer\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            </form>\n");
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
