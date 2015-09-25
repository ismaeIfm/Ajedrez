/**
 * Clase NodoCadena: Los objetos de esta clase representa contenedores de 
 * cadenas (String). La finalidad de guardar cadenas en ellos es para luego
 * con ellos se formen listas de cadenas. Cada objeto tiene una referencia a 
 * otro nodo.
 * @author Alejandro Sanchez Aviles
 * @version 3.0
 */ 

public class NodoCadena{
  
  //Cadena que se almacenara en el nodo (contenedor de cadenas)
  private String contenido;
  //Referencia a otro nodo (otro contenedor de cadenas)
  private NodoCadena anterior;
  
  /**
   * Construye un nodo a partir de una cadena dada. Esta cadena
   * sera el contenido del nodo.
   * @param contenido Cadena que reprenta el contenido del nodo o contenedor.
   */ 
  public NodoCadena(String contenido){
    this.contenido = contenido;
    anterior = null;
  }
  
  /**
   * Construye un nodo a partir de otro nodo dado. Crea un objeto
   * NodoCadena con el mismo contenido, pero con una referencia nula.
   * Se utiliza cuando se quiere solo obtener una copia del nodo
   * si alterarlo.
   * @param nodoCadena Representa el objeto que se copiara.
   */ 
  public NodoCadena(NodoCadena nodoCadena){
    this.contenido = nodoCadena.daContenido();
    this.anterior = null;
  }
  
  /**
   * Obtiene la cadena contenida en el nodo (contenedor).
   * @return Una cadena que es el contenido del nodo.
   */ 
  public String daContenido(){
    return contenido;
  }
  
  /**
   * Obtiene el nodo al que hace referencia el contenedor de cadenas.
   * @return Un objeto de clase NodoCadena, el cual es referenciado para
   * realizar una lista de cadenas.
   */ 
  public NodoCadena daAnterior(){
    return anterior;
  }
  
  /**
   * Coloca una cadena como contenido del nodo.
   * @param cadena Representa el contenido nuevo para el nodo.
   */ 
  public void ponContenido(String cadena){
    contenido = cadena;
  }
  
  /**
   * Coloca el nodo al que se quiere que el contenedor
   * de cadenas haga referencia.
   * @param anterior Objeto de la clase NodoCadena que se quiere referenciar.
   */ 
  public void ponAnterior(NodoCadena anterior){
    this.anterior = anterior;
  }
  
  /**
   * Obtiene la representacion como cadena del nodo.
   * @return Una cadena que es la representacion como cadena del nodo.
   */ 
  public String toString(){
    return "(" + contenido + ")";
  }
  
}