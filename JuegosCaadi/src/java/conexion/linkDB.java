
package conexion;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author walter
 */

public class linkDB {
    public String url = "jdbc:mysql://localhost:3306/example";
    public String user = "root";
    public String pw = "UtnCboV1";
    public Connection connection;

    public linkDB(){}

    public String logIn(String usr, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pw);

            if( connection != null ){
                System.out.println("¡LA CONEXION SE HIZO EN EL METODO CONECT!");
                Statement queryStart = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet bdQuery = queryStart.executeQuery("SELECT *FROM usuarios");
                
                String usuario = "";
                String pass = "";
                String out = "";
                boolean retorno = false;

                while( bdQuery.next() && !retorno ){
                    usuario = bdQuery.getString(1);
                    pass = bdQuery.getString(2);
                    
                    if( usuario.equals(usr) && pass.equals(password) ){
                        out = usuario;
                        retorno = true;
                    }
                }
                
 //               System.out.println("USUARIO = "+ out );
                bdQuery.close();
                queryStart.close();
                connection.close();
                return out;
            }

        }catch(Exception e){
            System.out.println("ERROR EN EL METODO CONECT");
        }
        return "ERROR!";
    }
              
/*    public String searchUser(String User, String password) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pw);
            
            if( connection != null ){
                System.out.println("¡LA CONEXION SE HA REALIZADO CON EXITO!");
                Statement queryStart = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet queryUser = queryStart.executeQuery("SELECT usr FROM usuarios WHERE name ="+User);
                ResultSet queryPassword = queryStart.executeQuery("SELECT pws FROM usuarios WHERE pws="+password);
                
                String out = "";
                out = queryUser.getString(1) + " " + queryPassword.getString(1);
                System.out.println("Resultado de la BD = "+ out);
                return out;
            }
        }catch(Exception e){
            System.out.println("ERROR AL REALIZAR LA CONEXION CON LA BASE DE DATOS EN EL METODO searchUser");
        }
        return "ERROR";
    }
*/
}
