/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudServlets;

import ConnectionModel.ConnectionModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frodo
 */
@WebServlet(name = "InsertSolcitudServlet", urlPatterns = {"/InsertSolcitudServlet"})
public class InsertSolcitudServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertSolcitudServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertSolcitudServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* insertar una nueva solicitud en la base de datos */
        
        // conseguir el id del profesor que acaba de entrar al servlet
        ServletContext contxtAplication = getServletConfig().getServletContext();
        int idProf = (int) contxtAplication.getAttribute("IdUsuarioConectado");
        
        // crear un nuevo objeto solicitud e iniciarlo con valores definidos en el request
        Logic_ObjetosBaseDatos.Logic_Solcitud sn = Herramientas.Utilidades.CrearSolicitud(request,  idProf);

        try {
            // ejecutar la consulta de incercion
            Herramientas.Utilidades.Insert( sn, new ConnectionModel("jdbc:mysql://localhost/mydb", "root", "UtnCboV1") );
        } catch (SQLException ex) {
            Logger.getLogger(InsertSolcitudServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
