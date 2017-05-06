/*
    Autor -> alfredo gonzalez gavina

    clase para englobar todas las operaciones de CRUD
*/

package Herramientas;

import Logic_ObjetosBaseDatos.*;

// los imports para la base datos deben estar en la clase conexion de kike
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilidades {
    
    /*
        autor : alfredo gonzalez gavina 
        Constructor por defentoc
    */
    public Utilidades () {
    
    }
    
    ////////////////////////////////////////////////////////////////////////
    
            /// para estudiante de ley
    
    ////////////////////////////////////////////////////////////////////////
    
    /*
        autor: alfredo gonzalez gavina 
        
        Insert. inserta una nueva instancia de la clase estudiante ley en la 
                base de datos. regresa true o false dependiendo si la operacin
                tuvo exito o no.
     
        parametros. una nueva instancia de la clase estudiante de ley y una 
                    nueva instancia de la clase conexion.
    */
    public static boolean Insert    ( Logic_TablaAdministrador NuevoAdministrador,  Connection NuevaConexion, String TablaDestino ) throws SQLException
    {
        String Sql = "INSERT INTO"+ TablaDestino + 
                " VALUES (" + 
                    NuevoAdministrador.IdUsuario + ","+ 
                    NuevoAdministrador.NivelIngels+
                ");" ;
        
        Statement consulta = NuevaConexion.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.close();
        
        return estado;
    }
    
    public static boolean Insert    ( Logic_EstudianteLei NuevoEstudianteLei,       Connection NuevaConexion, String TablaDestino ) throws SQLException
    {
        String Sql = "INSERT INTO"+ TablaDestino + 
                " VALUES (" + 
                    NuevoEstudianteLei.IdUsuario + ","+ 
                    NuevoEstudianteLei.Calificacion + ", "+
                    NuevoEstudianteLei.NivelIngles +  ", " +
                    NuevoEstudianteLei.Semestre +
                ");" ;
        
        Statement consulta = NuevaConexion.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.close();
        
        return estado;
    }
    
    /*
        autor: alfredo gonzalez gavina 
        
        Insert. elimina una instancia dada de la clase estudiante ley en la 
                base de datos. regresa true o false dependiendo si la operacin
                tuvo exito o no.
     
        parametros. una nueva instancia de la clase estudiante de ley y una 
                    nueva instancia de la clase conexion.
    */
    public static boolean Delete    ( Logic_EstudianteLei AdministradorDeseado,       Connection NuevaConexion, String TablaDestino ) throws SQLException
    {
        String Sql = "DELETE FROM "+ TablaDestino + " WHERE IdUsuario =" + AdministradorDeseado.IdUsuario;
        Statement consulta = NuevaConexion.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.close();
        
        return estado;
    }
    
    public static boolean Delete    ( Logic_TablaAdministrador AdministradorDeseado,  Connection NuevaConexion, String TablaDestino ) throws SQLException
    {
        String Sql = "DELETE FROM "+ TablaDestino + " WHERE IdUsuario =" + AdministradorDeseado.IdUsuario;
        Statement consulta = NuevaConexion.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.close();
        
        return estado;
    }

    
    /*
        autor: alfredo gonzalez gavina 
        
        Insert. actualiza una instancia dada de la clase estudiante ley en la 
                base de datos. regresa true o false dependiendo si la operacin
                tuvo exito o no.
     
        parametros. una nueva instancia de la clase estudiante de ley y una 
                    nueva instancia de la clase conexion.
    */
    public static boolean Update    ( Logic_EstudianteLei EstudianteLeiActual,         Connection NuevaConexion, String TablaDestino  ) throws SQLException
    {
        String Sql = "UPDATE" + TablaDestino + 
                " SET" + 
                   "Semestre = "+ EstudianteLeiActual.Semestre+ ","+ 
                   "Calificacion ="+ EstudianteLeiActual.Calificacion + ", "+
                   "NivelIngles="+ EstudianteLeiActual.NivelIngles + 
                ";" ;
        
        Statement consulta = NuevaConexion.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.close();
        
        return estado;
    }
    
    public static boolean Update    ( Logic_TablaAdministrador AdministradorActual,    Connection NuevaConexion, String TablaDestino  ) throws SQLException
    {
        String Sql = "UPDATE" + TablaDestino + 
                " SET " + 
                   "NivelIngles="+ AdministradorActual.NivelIngels+
                ";" ;
        
        Statement consulta = NuevaConexion.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.close();
        
        return estado;
    }
    
    /*
        autor: alfredo gonzalez gavina 
        
        Insert. muestra los datos de cualquier tabla en la 
                base de datos. regresa un resultset dependiendo si la operacin
                tuvo exito o no.
     
        parametros. una nueva instancia de la clase conexion.
                    string indicando la tabla que ha ser seleccionada
    */
    public static ResultSet Select  (  Connection NuevaConexion, String TablaDestino  ) throws SQLException
    {
        Statement consulta  = NuevaConexion.createStatement();
        ResultSet Resultado = consulta.executeQuery( "SELECT * FROM "+ TablaDestino + " ;");
        consulta.close();
        NuevaConexion.close();
        
        return Resultado;
    }
}
