
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
    public String url = "jdbc:mysql://localhost:3306/tenis";
    public String user = "root";
    public String pw = "UtnCboV1";
    public Connection connection;

    public linkDB(){
    }

    public String conect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pw);

            if( connection != null ){
                System.out.println("¡LA CONEXION SE HA REALIZADO CON EXITO!");
                Statement queryStart = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet query = queryStart.executeQuery("SELECT *FROM teams");

                String out = "";
                boolean next = query.next();
                
                while( next ){
                    out += query.getString(1)+"\n";
                    next = query.next();
                }
                            
                return out;
            }

        }catch(Exception e){
            System.out.println("ERROR AL REALIZAR LA CONEXION CON LA BASE DE DATOS");
        }
        return "¡ERROR!";
    }

    public String searchUser(String User, String password) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pw);

            if( connection != null ){
                System.out.println("¡LA CONEXION SE HA REALIZADO CON EXITO!");
                Statement queryStart = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet queryUser = queryStart.executeQuery("SELECT name FROM teams WHERE name ="+User);
                ResultSet queryPassword = queryStart.executeQuery("SELECT playerNum FROM teams WHERE playerNum="+password);
                
                String out = "";
                if( queryUser.next() && queryPassword.next() ) {                    
                    queryUser.previous();
                    queryPassword.previous();
                    out += queryUser+" "+ queryPassword;
                    return out;
                }else {
                    return "ERROR AL INICIAR SESION";
                }
            }
        }catch(Exception e){
            System.out.println("ERROR AL REALIZAR LA CONEXION CON LA BASE DE DATOS");
        }
        return "ERROR";
    }
    
}
