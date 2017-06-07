package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homeAdministratorView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title> Administracion del sistema de CAADI </title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/homeAdministratorStyle.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("    <div id=\"main\">\n");
      out.write("        <div class=\"banner\">\n");
      out.write("            <div class=\"imageBanner\">\n");
      out.write("                <img src=\"images/escudo.jpg\" alt=\"Escudo UG\" width=\"112\" height=\"42\" title=\"Escudo de la Universidad de Guanajuato\">  \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
 int number = 88; 
      out.write("\n");
      out.write("            <div class=\"header\">\n");
      out.write("                <ul class=\"nav\">\n");
      out.write("                    <li><a href=\"homeAdministratorView.html\" class=\"inicio\"> Home </a></li>\n");
      out.write("                    <li><a href=\"\" class=\"administrar\"> Manage </a>\n");
      out.write("                        <ul>\n");
      out.write("                            <li><a href=\"listGamesView.jsp\" class=\"juegos\"> Games</a></li>\n");
      out.write("                            <li><a href=\"listRequestView.jsp\" class=\"request\"> Request <p class=\"numberRequest\" align=\"center\">");
      out.print(number );
      out.write("</p> </a></li>\n");
      out.write("                            <li><a href=\"\" class=\"materias\"> Subjects </a></li>\n");
      out.write("                            <li><a href=\"\" class=\"estudiantes\"> Students </a></li>\n");
      out.write("                            <li><a href=\"\" class=\"usuarios\"> Users </a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li><a href=\"\" class=\"reportes\"> Reports  </a></li>\n");
      out.write("                    <li><a href=\"logInView.html\" class=\"sigout\"> Log out </a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\t<p class=\"welcomeMessages\" align=\"center\"> WELCOME TO THE SYSTEM FOR THE MANAGEMENT OF CAADI GAMES! </p>\n");
      out.write("\n");
      out.write("\t<div id=\"imageBody\">\n");
      out.write("\t\t<img src=\"images/english.jpg\" alt=\"Ingles\" width=\"600\" height=\"350\" >\n");
      out.write("\t</div>\n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("    <footer>\n");
      out.write("        <h3 class=\"footerText\" align=\"center\"> Department of Multidisciplinary Studies of Yuriria <br>\n");
      out.write("                           Suburb Yacatitas, C.P. 38940 <br>\n");
      out.write("                           Yuriria, Gto., Mexico <br>\n");
      out.write("                           Tel: +52 (445) 458 90 40. Exts: 1703, 1709, 1706 y 1718. <br>\n");
      out.write("                           dem@ugto.mx\n");
      out.write("        </h3> \n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("    </body>\n");
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
