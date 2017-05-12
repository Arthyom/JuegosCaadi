
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
    public String url = "jdbc:mysql://localhost/mydb";
    public String user = "root";
    public String pw = "";
    public Connection connection;

    public linkDB(){}

    public String logIn(String usr, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pw);

            if( connection != null ){
                System.out.println("¡LA CONEXION SE HIZO EN EL METODO CONECT!");
                Statement queryStart = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet bdQuery = queryStart.executeQuery("SELECT * FROM Usuario;");
                
               
                
                String usuario = "";
                String pass = "";
                String out = "";
                boolean retorno = false;

                while( bdQuery.next() && !retorno ){
                    usuario = bdQuery.getString(3);
                    pass = bdQuery.getString(6);
                    
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
    
    public ResultSet select(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, pw);

            if( connection != null ){
                System.out.println("¡LA CONEXION SE HIZO EN EL METODO CONECT!");
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
