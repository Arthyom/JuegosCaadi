package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class __0020bannerLogInView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<header>\n");
      out.write("    <div id=\"main\">\n");
      out.write("        <div class=\"banner\">\n");
      out.write("            <div class=\"imageBanner\">\n");
      out.write("              <img src=\"images/escudo.png\" alt=\"Escudo UG\" width=\"221\" height=\"188\" title=\"Escudo de la Universidad de Guanajuato\">          \n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<footer>\n");
      out.write("    <div class=\"footer\">\n");
      out.write("        <small>\n");
      out.write("           <h3 align=\"center\"> Departamento de Estudios Multidisciplinarios Sede Yuriria <br>\n");
      out.write("                              Colonia Yacatitas, C.P. 38940 <br>\n");
      out.write("                              Yuriria, Gto., Mexico <br>\n");
      out.write("                              Tel: +52 (445) 458 90 40. Exts: 1703, 1709, 1706 y 1718. <br>\n");
      out.write("                              dem@ugto.mx\n");
      out.write("           </h3>\n");
      out.write("        </small>\n");
      out.write("</div>\n");
      out.write("</footer>\n");
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
