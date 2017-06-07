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
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author frodo
 */
@WebServlet(name = "RechazarSolicitudServlet", urlPatterns = {"/RechazarSolicitudServlet"})
public class RechazarSolicitudServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RechazarSolicitudServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RechazarSolicitudServlet at " + request.getContextPath() + "</h1>");
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
        // actualizar el status de la consulta para que diga aceptada 
        String Sql = " UPDATE Solicitud SET "+            
                "Status = '"+ Logic_ObjetosBaseDatos.Logic_Solcitud.SOL_Regt + "'"
                + " WHERE  idSolicitud = " + request.getParameter("rechID") ;
        
        try {
            // crear conexiones y ejecutar consulta
            ConnectionModel cn = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", "");
            
             Statement consulta = cn.connection.createStatement();
             Boolean estado = consulta.execute(Sql);
             consulta.close();
             cn.Close();
        } catch (SQLException ex) {
            Logger.getLogger(AceptarJuegoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
