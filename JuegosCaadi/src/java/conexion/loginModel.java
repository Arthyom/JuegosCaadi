
package conexion;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author walter
 */

public class loginModel {
    public String url = "jdbc:mysql://localhost/mydb";
    public String user = "root";
    public String pw = "UtnCboV1";
 
    
    public Connection connection;

    public loginModel(){}

    public int    idUsuario (String usr, String password)
    {
       int id = 0 ;
       
        try {
            
            // conectarse a la base de datos
            this.connection = DriverManager.getConnection(url, user, pw);
            if ( this.connection != null )
            {
                String sql = "SELECT * FROM Usuario WHERE Usuario_Nombre = '"+ usr +"';";
                Statement queryStart = this.connection.createStatement();
                ResultSet Resultado = queryStart.executeQuery(sql);
                
                while ( Resultado.next() )
                    id = Resultado.getInt(1);
              
                connection.close();
                queryStart.close();
                Resultado.close();
            }
        } 
        catch (Exception ex)
        {
            Logger.getLogger(loginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
       return id;  
    }
    
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
                    int id;
                    id = bdQuery.getInt(1);
                    
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
    }
