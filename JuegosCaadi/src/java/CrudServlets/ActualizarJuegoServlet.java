/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudServlets;

import ConnectionModel.ConnectionModel;
import Herramientas.Utilidades;
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
@WebServlet(name = "ActualizarJuegoServlet", urlPatterns = {"/ActualizarJuegoServlet"})
public class ActualizarJuegoServlet extends HttpServlet {
    
    
    //public String pw = "UtnCboV1";
    //public String pw = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActualizarJuegoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarJuegoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try 
        {
           ConnectionModel cn = new ConnectionModel("jdbc:mysql://localhost/mydb", "root", "");
            Logic_TablaJuegos jn = Utilidades.CrearJuego(request);
            try{
               // cn.connection.setAutoCommit(false);
                Utilidades.Update(jn, cn, "Juego");
               // cn.connection.commit();
            }
            catch (SQLException ex) {
                cn.connection.rollback();
            Logger.getLogger(InsertJuegoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(InsertJuegoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
