
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
import conexion.loginModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexion.*;
import javax.servlet.ServletContext;
import javax.swing.JOptionPane;

/**
 *
 * @author walter
 */
@WebServlet(name = "servlet", urlPatterns = {"/servlet"})
public class logInServletControler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request logInServletControler request
     * @param response logInServletControler response
     * @throws ServletException if a logInServletControler-specific error occurs
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
        //Herramientas.Utilidades.InicarDb();
        
        String usuario = request.getParameter("txtUSER");
        String password = request.getParameter("txtPASSWORD");

        // crear una conexion
        loginModel login = new loginModel();
        String tipoUsuario = login.logIn(usuario, password);
        int idUsuario = login.idUsuario(usuario, password);
        boolean correct = false;
        String direccionamiento = "/private/logInView.html";
        
        // almacenar el idusuario en el nivel de aplicacion
        ServletContext contxtAplication = getServletConfig().getServletContext();
        contxtAplication.setAttribute("IdUsuarioConectado", idUsuario);

        switch (tipoUsuario) {
            case "administrador":
                direccionamiento = "/private/homeAdministratorView.html";
                correct = true;
                break;
            case "profesor":
                direccionamiento = "/private/homeTeacherView.html";
                correct = true;
                break;
            case "EstudianteLei":
                direccionamiento = "/private/homeLEIStudentsView.html";
                correct = true;
                break;
            case "":
                correct = false;
                break;
            default:                
        }

        response.sendRedirect(direccionamiento);
        
        if( correct )
            System.out.println("USUARIO CORRECTO");
        else
            System.out.println("USUARIO INCORRECTO");

    }

    /**
     * Returns a short description of the logInServletControler.
     *
     * @return a String containing logInServletControler description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
