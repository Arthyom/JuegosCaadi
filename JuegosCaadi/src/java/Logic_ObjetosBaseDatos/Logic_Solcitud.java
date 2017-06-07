/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic_ObjetosBaseDatos;

/**
 *
 * @author frodo
 */
public class Logic_Solcitud {
    
   // propiedades de la clase Logic_Solicitud
   public int     idSolicitud ;
   public String  ObsvSalida ;
   public String  ObsvEntrada;
   public String  FechaPeticion;
   public String  FechaRespuesta;
   public String  FechaTerminacion;
   public String  EstadoSolicitud;
   public int     Prf_IdProfesor; 
   public int     Id_Material;
   
   public static String SOL_Actp = "Aceptado";
   public static String SOL_Regt = "Rechazado";
   public static String SOL_Pndt = "Pendiente";
   

   // constructor por defecto
   public Logic_Solcitud(){}

}
