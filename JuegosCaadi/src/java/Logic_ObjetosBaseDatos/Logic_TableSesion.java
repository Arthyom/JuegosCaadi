/*
    autor: alfredo gonzalez gavina
   
    Esta clase representa una fila de la base de datos
    puede ser usada para interactuar con la base de datos
    a travez del lenguaje y mediante la programacion 
    orientada a objetos

    

*/
package Logic_ObjetosBaseDatos;

import java.util.Date;

public class Logic_TableSesion {
    
/* 
    propiedades de la clase sesion, publicas todas
    y relacionadas uno a uno con los Campos de la base de datos
*/
    int     IdUsuario;
    int     IdSesion;   
    Date    Inicio;
    Date    Termino;
    double  Duracion;
}
