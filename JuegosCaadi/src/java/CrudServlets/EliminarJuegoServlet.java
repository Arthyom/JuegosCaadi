/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudServlets;

import ConnectionModel.ConnectionModel;
import Logic_ObjetosBaseDatos.Logic_TablaJuegos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "EliminarJuegoServlet", urlPatterns = {"/EliminarJuegoServlet"})
public class EliminarJuegoServlet extends HttpServlet {

    public String pw = "kike";
    //public String pw = "UtnCboV1";
    //public String pw = "";
    
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
            out.println("<title>Servlet EliminarJuegoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarJuegoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        try 
        {
            ConnectionModel cn = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", "");
            Logic_TablaJuegos j1 = new Logic_TablaJuegos();
            String id = request.getParameter("IdMaterialBorrar");
            j1.IdMaterial = Integer.parseInt( request.getParameter("IdMaterialBorrar"));          
            try 
            {
             // cn.connection.setAutoCommit(false);
              Herramientas.Utilidades.Delete(j1, cn, "Juego");
             // cn.connection.commit();
            }
            catch (SQLException ex) {
                cn.connection.rollback();
                Logger.getLogger(EliminarJuegoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }   
        } catch (SQLException ex) {
            
            Logger.getLogger(EliminarJuegoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
