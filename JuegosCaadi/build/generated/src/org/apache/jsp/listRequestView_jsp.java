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

public final class listRequestView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("﻿<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title> Administrar solicitudes</title>\n");
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
      out.write("                        <li><a href=\"homeAdministratorView.html\" class=\"inicio\"> Home </a></li>\n");
      out.write("                        <li><a href=\"\" class=\"administrar\"> Manage </a>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"listGamesView.jsp\" class=\"juegos\"> Games</a></li>\n");
      out.write("                                <li><a href=\"listRequestView.jsp\" class=\"request\"> Request </a></li>\n");
      out.write("                                <li><a href=\"\" class=\"materias\"> Subjects </a></li>\n");
      out.write("                                <li><a href=\"\" class=\"estudiantes\"> Students </a></li>\n");
      out.write("                                <li><a href=\"\" class=\"usuarios\"> Users </a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"\" class=\"reportes\"> Reports </a></li>\n");
      out.write("                        <li><a href=\"logInView.html\" class=\"sigout\"> Log out </a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\t    </div>\n");
      out.write("<!--CAMBIAR EL id Y class DE LOS DOS DIV PARA PODER HACER SUS PROPIOS ESTILOS -->\n");
      out.write("\n");
      out.write("            <div class=\"instrucciones\">\n");
      out.write("                <p class=\"text-request\"> La siguiente tabla muestra las solicitudes de juegos que han sido realizadas\n");
      out.write("                                 por parte de los profesores registrados en el sistema. Para aceptar una solicitud\n");
      out.write("                                  presione en el botón \"Approve\" correspondiente a cada juego. En su defecto para\n");
      out.write("                                  rechazar dicho prestamo pulse en \"Disapprove\" del respectivo juego.\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
 ConnectionModel connect = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", pw); 
      out.write("\n");
      out.write("            ");
 Statement querySelect = connect.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
      out.write("\n");
      out.write("            ");
 String query = "SELECT * FROM Solicitud;"; 
      out.write(' ');
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
      out.write("                        <th rowspan=\"5\">\n");
      out.write("                            <img src=\"images/game2.jpg\" height=\"250\" width=\"230\" id=\"imageGame\">\n");
      out.write("                        </th>\n");
      out.write("                        <td align=\"left\" id=\"ide\"> idSolicitud:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"id_");
      out.print(count);
      out.write("\" value=\"  ");
      out.print( selectGames.getString(1) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                        <td align=\"left\" id=\"nameGame\"> Observaciones de salida: \n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"name_");
      out.print(count);
      out.write("\" value=\"  ");
      out.print( selectGames.getString(2) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" id=\"lenguageGame\"> Observaciones de entrada:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"lenguage_");
      out.print(count);
      out.write("\" value=\"  ");
      out.print( selectGames.getString(3) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                        <td align=\"left\" id=\"skillsGame\"> Fecha de petición:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"skills_");
      out.print(count);
      out.write("\" value=\"  ");
      out.print( selectGames.getString(4) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" id=\"availableGame\"> Fecha de respuesta:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"availableGame_");
      out.print(count);
      out.write("\" value=\"  ");
      out.print( selectGames.getString(5) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                        <td align=\"left\" id=\"gamersNum\"> Fecha de terminación:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"gamersNum_");
      out.print(count);
      out.write("\" value=\"  ");
      out.print( selectGames.getString(6) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td align=\"left\" id=\"timeGame\"> Profesor al que fue prestado:\n");
      out.write("                            <input type=\"text\" disabled=\"true\" class=\"textValue\" id=\"timeGame_");
      out.print(count);
      out.write("\" value=\"  ");
      out.print( selectGames.getString(7) );
      out.write("\">\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"3\">\n");
      out.write("                            <button class=\"btnAprov\" onclick=\"Aprov(");
      out.print(count);
      out.write(")\"> Approve</button>\n");
      out.write("                            <button class=\"btnRech\" onclick=\"Rech(");
      out.print(count);
      out.write(")\"> Disapprove </button>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                </table>\n");
      out.write("                ");
 count++; 
      out.write("\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("            \n");
      out.write("            <!-- COMIENZA EL MODAL DONDE SE MUESTRA LA APROVACIÓN DE UNA SOLICITUD DE UN JUEGO -->\n");
      out.write("            <!-- Contenedor del modal -->\n");
      out.write("            <form action=\"AceptarJuegoServlet\" method=\"post\">\n");
      out.write("            <div id=\"modalAprov\" class=\"modalAprov\">\n");
      out.write("              <!-- Contenido del modal -->\n");
      out.write("              <div class=\"modalAprov-content\">\n");
      out.write("                <div class=\"modalAprov-header\" align=\"center\">\n");
      out.write("                    <span class=\"close\" onclick=\"closeSpan5()\">&times;</span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modalAprov-body\">\n");
      out.write("                    <div class=\"mainContainer\">\n");
      out.write("                        <div class=\"objetsContainer\">\n");
      out.write("                            <img src=\"images/Question.png\" class=\"warningImage\">\n");
      out.write("                            <p class=\"textDelete\" > Are you sure you want to approve: </p>\n");
      out.write("                            <input type=\"text\" class=\"aprovGame\" id=\"aprovID\" value=\"\" disabled=\"false\"/>\n");
      out.write("                            <input type=\"text\" class=\"aprovtGame\" id=\"IdMaterialAprov\" name=\"IdMaterialAprov\" style=\"display: none\"/>\n");
      out.write("                                <button class=\"btnAprovM\"> Approve </button>\n");
      out.write("                           </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <!-- COMIENZA EL MODAL DONDE SE MUESTRA LA DESAPROVACION DE UNA SOLICITUD DE UN JUEGO -->\n");
      out.write("            <!-- Contenedor del modal -->\n");
      out.write("            <form action=\"RechazarSolicitudServlet\" method=\"post\">\n");
      out.write("            <div id=\"modalRech\" class=\"modalRech\">\n");
      out.write("              <!-- Contenido del modal -->\n");
      out.write("              <div class=\"modalRech-content\">\n");
      out.write("                <div class=\"modalRech-header\" align=\"center\">\n");
      out.write("                    <span class=\"close\" onclick=\"closeSpan6()\">&times;</span>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modalRech-body\">\n");
      out.write("                    <div class=\"mainContainer\">\n");
      out.write("                        <div class=\"objetsContainer\">\n");
      out.write("                            <img src=\"images/Question.png\" class=\"warningImage\">\n");
      out.write("                            <p class=\"textDelete\" > Are you sure you want to desapprove: </p>\n");
      out.write("                            <input type=\"text\" class=\"rechGame\" id=\"rechID\" value=\"\" disabled=\"false\"/>\n");
      out.write("                            <input type=\"text\" class=\"rechGame\" id=\"IdMaterialRech\" name=\"IdMaterialRech\" style=\"display: none\"/>\n");
      out.write("                                <button class=\"btnRechM\"> Disapprove </button>\n");
      out.write("                           </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
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
      out.write("</html>");
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
