
import ConnectionModel.ConnectionModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import conexion.linkDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexion.*;

/**
 *
 * @author walter
 */
@WebServlet(name = "servlet", urlPatterns = {"/servlet"})
public class servlet extends HttpServlet {

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
            out.println("<title>Servlet servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("txtUSER");
        String password = request.getParameter("txtPASSWORD");

        PrintWriter out = response.getWriter();
        out.println("¡Hola "+usuario+", bienvenido!");
        out.println("Tu contraseña es: "+password);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("txtUSER");
        String password = request.getParameter("txtPASSWORD");

        // crear una conexion
        
        linkDB login = new linkDB();     
        String user = login.logIn(usuario, password);
        boolean correct = false;
        String direccionamiento;
        if( user != "" ){
            direccionamiento = "/private/homeAdministratorView.html";
            response.sendRedirect(direccionamiento);
            correct = true;
        }
        else if( user.equals("Profesor") ){
            direccionamiento = "/private/homeProfessorView.html";
            response.sendRedirect(direccionamiento);
            correct = true;
        }
        else if( user.equals("Alumno") ){
            direccionamiento = "/private/homeStudentsEnglishView.html";
            response.sendRedirect(direccionamiento);
            correct = true;
        }
        else if( user == "" || user == null ){
            direccionamiento = "/private/logInView.html";
            response.sendRedirect(direccionamiento);
            correct = false;
        }
        if( correct )
            System.out.println("USUARIO CORRECTO");
        else
            System.out.println("USUARIO INCORRECTO");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

/*    public String verificationUser(String usr, String pwd) throws SQLException{
         conexion.linkDB login = new conexion.linkDB();
         String user = login.conect(usr, pwd);
         
         if( user.equals("Admin") ){
            return "Admin";
         }
        
         return user;
    }*/
}
