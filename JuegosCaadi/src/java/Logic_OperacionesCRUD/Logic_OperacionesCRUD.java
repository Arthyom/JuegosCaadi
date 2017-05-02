/*
    Autor -> alfredo gonzalez gavina

    clase para englobar todas las operaciones de CRUD
*/

package Logic_OperacionesCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Logic_OperacionesCRUD {
    
    // se debe crear una propiedad que represente una nueva conexion 
    public Connection NuevaConexion;
    
    public Logic_OperacionesCRUD() {}
    
    
    /*
        Autor: Alfredo gonzalez gavina 
        
    Descripcion:
        Constructor sobrecargado, recibe la url de la base de datos, el usuario
        el password, usa estos parametros para crear una cadena de conexion 
        llamdno al constructor adecuado para crear un obejto que permita conectar 
        con la base de datos.
    
    Parametros:
        url : ruta a la base de datos.
        user: nombre del usuario con el que se entrara a la base de datos
        pwd : password para usar la base de datos, puede ser distinto para cada 
              usuario.
    */
    
    public Logic_OperacionesCRUD( String url, String user, String pwrd )
    {
        // crear una nueva conexion 
        /* 
            ejemplo 
            this.NuevaConexion = new ClaseConexionEscritaPorKike ( url, user, pwd );
        */
    }
    
    
    
    
}
