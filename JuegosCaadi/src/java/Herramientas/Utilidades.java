/*
    Autor -> alfredo gonzalez gavina

    clase para englobar todas las operaciones de CRUD
*/

package Herramientas;

import Logic_ObjetosBaseDatos.*;

// los imports para la base datos deben estar en la clase conexion de kike

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ConnectionModel.*;
import java.io.*;

public class Utilidades {
    
    public static String pw = "kike";
    //public static String pw = "UtnCboV1";
    //public static String pw = "";

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
    public static boolean Insert    ( Logic_TablaAdministrador NuevoAdministrador,  ConnectionModel NuevaConexion, String TablaDestino ) throws SQLException
    {
        String Sql = "INSERT INTO"+ TablaDestino + 
                " VALUES (" + 
                    NuevoAdministrador.IdUsuario + ","+ 
                    NuevoAdministrador.NivelIngels+
                ");" ;
        
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
        return estado;
    }
    
    public static boolean Insert    ( Logic_EstudianteLei NuevoEstudianteLei,       ConnectionModel NuevaConexion, String TablaDestino ) throws SQLException
    {
        String Sql = "INSERT INTO"+ TablaDestino + 
                " VALUES (" + 
                    NuevoEstudianteLei.IdUsuario + ","+ 
                    NuevoEstudianteLei.Calificacion + ", "+
                    NuevoEstudianteLei.NivelIngles +  ", " +
                    NuevoEstudianteLei.Semestre +
                ");" ;
        
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
        return estado;
    }
    
    public static boolean Insert    ( Logic_TablaJuegos NuevoJuego,       ConnectionModel NuevaConexion, String TablaDestino ) throws SQLException
    {
        // insertar un material uevo
        
        Insert( (Logic_TablaMaterial) NuevoJuego , NuevaConexion, "Material");
        NuevaConexion.Open("jdbc:mysql://localhost/mydb", "root", pw);
        String Sql = "INSERT INTO "+ TablaDestino + 
                " VALUES ('" + 
                    NuevoJuego.Idioma + "','"+ 
                    NuevoJuego.EnlaceDigital + "','"+ 
                    NuevoJuego.InstruccionesUso + "','"+ 
                    NuevoJuego.Descripcion + "','"+ 
                    NuevoJuego.MaterialAdicional + "',"+ 
                    NuevoJuego.NumeroParticipantes + ",'"+ 
                    NuevoJuego.TiempoSugerido + "','"+ 
                    NuevoJuego.EtiquetasTemas + "','"+ 
                    NuevoJuego.EtiquetasVocabulario + "',"+ 
                    NuevoJuego.IdMaterial+
                    
                ");" ;
        
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
        return estado;
    }
    
    public static boolean Insert    ( Logic_TablaMaterial NuevoMaterial,       ConnectionModel NuevaConexion, String TablaDestino ) throws SQLException
    {
        String Sql = "INSERT INTO "+ TablaDestino + 
                " VALUES (" + 
                    NuevoMaterial.IdMaterial + ",'"+ 
                    NuevoMaterial.Nombre + "','"+ 
                    NuevoMaterial.Clase + "',"+ 
                    NuevoMaterial.Existencia + ","+ 
                    NuevoMaterial.Disponible + ",'"+ 
                    NuevoMaterial.Habilidad + "'"+ 
                ");" ;
        
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
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
    public static boolean Delete    ( Logic_EstudianteLei AdministradorDeseado,       ConnectionModel NuevaConexion, String TablaDestino ) throws SQLException
    {
        String Sql = "DELETE FROM "+ TablaDestino + " WHERE IdUsuario =" + AdministradorDeseado.IdUsuario;
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
        return estado;
    }
    
    public static boolean Delete    ( Logic_TablaAdministrador AdministradorDeseado,  ConnectionModel NuevaConexion, String TablaDestino ) throws SQLException
    {
        String Sql = "DELETE FROM "+ TablaDestino + " WHERE IdUsuario =" + AdministradorDeseado.IdUsuario;
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
        return estado;
    }
    
    
    public static boolean Delete    ( Logic_TablaJuegos JuegoDeseado,  ConnectionModel NuevaConexion, String TablaDestino ) throws SQLException
    {
       
        
        String Sql = "DELETE FROM "+ TablaDestino + " WHERE Material_idMaterial = " + JuegoDeseado.IdMaterial;
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
         Delete((Logic_TablaMaterial)JuegoDeseado, NuevaConexion, "Material");
        
        return estado;
    }
    
    public static boolean Delete    ( Logic_TablaMaterial MaterialDeseado,  ConnectionModel NuevaConexion, String TablaDestino ) throws SQLException
    {
        
        NuevaConexion.Open("jdbc:mysql://localhost/mydb", "root", pw);
        String Sql = "DELETE FROM "+ TablaDestino + " WHERE IdMaterial = " +  MaterialDeseado.IdMaterial;
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
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
    
    public static boolean Update    ( Logic_TablaJuegos JuegoActual,         ConnectionModel NuevaConexion, String TablaDestino  ) throws SQLException
    {
        Update((Logic_TablaMaterial)JuegoActual, NuevaConexion, "Material");
        
       
        String Sql = "UPDATE " + TablaDestino + 
                " SET " + 
                   "Juego_Idioma = ' " + JuegoActual.Idioma + " ',"+ 
                   "Juego_EnlaceDigital =' " + JuegoActual.EnlaceDigital + "',"+ 
                   "Juego_InstruccionesUso = ' " + JuegoActual.InstruccionesUso + "',"+ 
                   "Juego_Descripcion    =' " + JuegoActual.Descripcion + "',"+ 
                   "Juego_MaterialAdicional =' " + JuegoActual.MaterialAdicional + "',"+ 
                   "Juego_NumeroParticipantes = " +  JuegoActual.NumeroParticipantes + ","+ 
                   "Juego_TiempoSugerido =' "+ JuegoActual.TiempoSugerido + "',"+ 
                   "Juego_EtiquetaTemas =' "+ JuegoActual.EtiquetasTemas + "',"+ 
                   "Juego_EtiquetasVocabulario = ' " + JuegoActual.EtiquetasVocabulario + "'"+ 
                  // "Material_idMaterial"  + JuegoActual.IdMaterial+
                " WHERE Material_idMaterial = " + JuegoActual.IdMaterial +";" ;
        
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
        
        
        return estado;
    }
    
 
    
    public static boolean Update    ( Logic_TablaMaterial MaterialActual,         ConnectionModel NuevaConexion, String TablaDestino  ) throws SQLException
    {
        String Sql = "UPDATE " + TablaDestino + 
                " SET  " + 
                    //"IdMaterial = "            +MaterialActual.IdMaterial + ","+ 
                    "Material_Nombre     = ' " +MaterialActual.Nombre + "',"+ 
                    "Material_Clase =      ' " +MaterialActual.Clase + "',"+ 
                    "Material_Existencia = "   +MaterialActual.Existencia + ","+ 
                    "Material_Disponible = "   +MaterialActual.Disponible + ","+ 
                    "Material_Habilidad =  ' " +MaterialActual.Habilidad + "'"+ 
                "WHERE IdMaterial =" + MaterialActual.IdMaterial +";";
        
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();

        return estado;
    }
    
    public static boolean Update    ( Logic_TablaAdministrador AdministradorActual,    ConnectionModel NuevaConexion, String TablaDestino  ) throws SQLException
    {
        String Sql = "UPDATE" + TablaDestino + 
                " SET " + 
                   "NivelIngles="+ AdministradorActual.NivelIngels+
                ";" ;
        
        Statement consulta = NuevaConexion.connection.createStatement();
        Boolean estado = consulta.execute(Sql);
        consulta.close();
        NuevaConexion.Close();
        
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
    public static ResultSet Select  (  ConnectionModel NuevaConexion, String TablaDestino  ) throws SQLException
    {
        Statement consulta  = NuevaConexion.connection.createStatement();
        ResultSet Resultado = consulta.executeQuery( "SELECT * FROM "+ TablaDestino + " ;");
        consulta.close();
        NuevaConexion.Close();
        
        return Resultado;
    }
    
    public static Logic_TablaJuegos CrearJuego ( HttpServletRequest req )
    {
        Logic_TablaJuegos jn = new Logic_TablaJuegos();
        
        jn.IdMaterial = Integer.parseInt( req.getParameter("IdMaterial"));
        jn.Nombre =  req.getParameter("Nombre");
        jn.Clase = req.getParameter("Clase");
        jn.Existencia = Integer.parseInt( req.getParameter("Existencia"));
        jn.Disponible = Integer.parseInt( req.getParameter("Disponible"));
        jn.Habilidad = req.getParameter("Habilidad");
        jn.Idioma = req.getParameter("Idioma");
        jn.EnlaceDigital = req.getParameter("Enlace");
        jn.InstruccionesUso = req.getParameter("InstruccionesUso");
        jn.Descripcion = req.getParameter("Description");
        jn.MaterialAdicional = req.getParameter("MaterialAdicional");
        jn.NumeroParticipantes = Integer.parseInt( req.getParameter("NumeroParticipantes"));
        jn.TiempoSugerido = req.getParameter("TiempoSugerido");
        jn.EtiquetasTemas = req.getParameter("EtiquetasTemas");
        jn.EtiquetasVocabulario = req.getParameter("EtiquetasVocabulario");
        
        return jn;
    }
    
    public static void InicarDb () 
    {
        // conseguir rutas
        String RutaBsDtsSqlScript = "C:\\Users\\frodo\\Documents\\JuegosCaadi\\BaseDatos\\BaseCaadi.sql";
        String RutaInsrtSqlScript = "C:\\Users\\frodo\\Documents\\JuegosCaadi\\BaseDatos\\insercionDatosPrueba.sql";
        String RutaUsersSqlScript = "C:\\Users\\frodo\\Documents\\JuegosCaadi\\BaseDatos\\insercionDatosPrueba.sql";
        
         
        try
        {
            // crear lectores
            FileReader LectorBaseDatos = new FileReader (RutaBsDtsSqlScript);
            FileReader LectorInserts   = new FileReader (RutaInsrtSqlScript);
            FileReader LectorUsuaris   = new FileReader (RutaUsersSqlScript);
            
            BufferedReader BdReader = new BufferedReader(LectorBaseDatos);
            BufferedReader IsReader = new BufferedReader(LectorInserts);
            BufferedReader UsReader = new BufferedReader(LectorUsuaris);
            
            String CreacionSql = "";
            String InsertsSql = "";
            String UsuarioSql = "";
            
            String linea1, linea2, linea3;
            
            // leer los caracteres de los archivos sql
            while ( (  linea1 = BdReader.readLine() ) != null )
                CreacionSql += " " + linea1 + " ";
            
            // leer los caracteres de los archivos sql
            while ( (  linea2 = IsReader.readLine() ) != null )
                InsertsSql += " " + linea2 + " ";
            
            // leer los caracteres de los archivos sql
            while ( (  linea3 = UsReader.readLine() ) != null )
                UsuarioSql += " "+ linea3 + " ";
            
            BdReader.close();
            IsReader.close();
            UsReader.close();
            
            // crear una nueva conexion 
            ConnectionModel cn = new ConnectionModel("jdbc:mysql://localhost/sys","root", pw);
            
            Statement st =  cn.connection.createStatement();
            
            // crear base de datos
            if (st.execute(CreacionSql))
                System.out.println("Base de datos creada!");
            else
                System.out.println("error de creacion!");
            
            // insertar datos
           // st.execute(InsertsSql);
            
            // insertar usuarios
           // st.execute(UsuarioSql);
            
            cn.Close();
            st.close();
            
                
        }
        catch ( Exception ex )
        {
            
        }
        
        
        
    }
    
    
    
}
