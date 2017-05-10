/*
    autor: alfredo gonzalez gavina
   
    Esta clase representa una fila de la base de datos
    puede ser usada para interactuar con la base de datos
    a travez del lenguaje y mediante la programacion 
    orientada a objetos

    

*/
package Logic_ObjetosBaseDatos;


public class Logic_TablaJuegos extends Logic_TablaMaterial {
    
    /* propiedades de la clase juegos, publicas todas
       y relacionadas uno a uno con los Campos de la base de datos
    */
    
    public String   Idioma;
    public String   EnlaceDigital;
    public String   InstruccionesUso;
    public String   Descripcion;
    public String   MaterialAdicional;
    
    public int      NumeroParticipantes;
    public String   TiempoSugerido;
    public String   EtiquetasTemas;
    public String   EtiquetasVocabulario;
    
    
    public Logic_TablaJuegos() {
    }
    
   
    
    
    
}
