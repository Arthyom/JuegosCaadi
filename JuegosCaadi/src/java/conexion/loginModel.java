
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

public class loginModel {
    public String url = "jdbc:mysql://localhost/mydb";
    public String user = "root";
    //public String pw = "UtnCboV1";
    public String pw = "kike";
    public Connection connection;

    public loginModel(){}

    public String logIn(String usr, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pw);

            if( connection != null ){
                System.out.println("¡LA CONEXION SE HIZO EN EL METODO LOGIN!");
                Statement queryStart = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet bdQuery = queryStart.executeQuery("SELECT * FROM Usuario");
                
                String usuario = "";
                String pass = "";
                String clase = "";
                String out = "";
                boolean retorno = false;

                while( bdQuery.next() && !retorno ){
                    usuario = bdQuery.getString(3);
                    pass = bdQuery.getString(6);
                    clase = bdQuery.getString(2);
                    
                    if( usuario.equals(usr) && pass.equals(password) ){
                        out = clase;
                        retorno = true;
                    }
                }
                
                queryStart.close();
                bdQuery.close();
                connection.close();
                return out;
            }

        }catch(Exception e){
            System.out.println("ERROR EN EL METODO CONECT");
        }
        return "ERROR!";
    }
    
    public ResultSet select(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pw);

            if( connection != null ){
                System.out.println("¡LA CONEXION SE HIZO EN EL METODO SELECT!");
                Statement queryStart = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet bdQuery = queryStart.executeQuery("SELECT * FROM Juego;");
                
                return bdQuery;
            }

        }catch(Exception e){
            System.out.println("ERROR EN EL METODO CONECT");
        }
        return null;
    }
    
}
