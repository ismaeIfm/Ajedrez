import java.io.Serializable;

/**
 * Clase Abstracta Pieza: Esta clase provee una plantilla para objetos que representan
 * a las piezas de ajedrez: rey, reina, peon, caballo, torre y alfil.
 * @author Alejandro Sanchez Aviles
 * @version 3.0
 * @see ListaCadena, NodoCadena
 */ 
abstract public class Pieza implements Serializable{
  
  /**
   * Si color es verdadero la pieza es de color negra,
   * si color es falso la pieza es de color blanca.
   *
   */
  private boolean color;
  
  /**
   * Representa la posicion de la pieza en el tablero de ajedrez.
   * Es una cadena del tipo NW, donde N es un numero entre 1 y 8,
   * y W es un caracter entre A y H.
   *
   */
  private String posicion;
  
  /**
   * Construye una pieza a partir de un
   * color dado. Especifica una posicion no definida (cadena "Ninguna") dentro del tablero de ajedrez.
   * @param color Si es verdadero (true) la pieza es de color negro, si es falso (false)
   * la pieza es de color blanco.
   */
  public Pieza(boolean color){
    this.color = color;
    this.posicion = "Ninguna";
  }
  
  /**
   * Obtiene el color de la pieza. 
   * @return Verdadero (true) si la pieza es color negro, falso (false) si es color blanca.
   *
   */
  public boolean daColor(){
    return color;
  }
  
  /**
   * Obtiene la posicion actual de la pieza en el tablero de ajedrez. Esto
   * ayuda a saber donde se a colocado el objeto instanciado en el tablero.
   * De otra forma se tendria que buscar casilla por casilla a la pieza en
   * cuestion.
   * @return Una cadena de la forma NW que representa una coordenada en el tablero de ajedrez
   * de la forma (N,W).
   */ 
  public String daPosicion(){
    return posicion;
  }
  
  /**
   * Colaca una posicion en el tablero de ajedrez a la pieza. Esta
   * posicion esta dada con una cadena de la forma NW, donde N es un
   * numero entre 1 y 8, y W es una letra entre A y H.
   * @param posicion Cadena que representa la posicion de una pieza en el tablero de
   * ajedrez en una coordenada (N, W).
   */ 
  public void ponPosicion(String posicion){
    this.posicion = posicion;
  }
  
  /**
   * Verifica si ya se ha asignado una posicion en tablero a la pieza.
   * @return Verdadero (true) si la pieza no tiene una posicion en el tablero,
   * falso (false) en otro caso.
   */ 
  public boolean ningunaPosicion(){
    return posicion.equals("Ninguna");
  }
  
   /**
   * Verifica si una coordenada (a una casilla) dada es un 
   * movimiento valido para la pieza a partir de su posicion actual.
   * @param posicionNueva Una cadena que representa una posible posicion
   * a donde se puede mover la pieza de acuerdo a la lista de casilla generada 
   * de acuerdo a su posicion actual.
   * @return Verdadero (true) si es una casilla valida, falso (false) si no lo es.
   * 
   * NOTA: Este método debe ser implementado por ustedes en esta clase abstracta.
   * 
   */ 
  public boolean movimientoValido(String posicionNueva){
   ListaCadena movimientos = posiblesMovimientos();
   return ((UsaListaCadena) movimientos).buscarMovimientoValido(posicionNueva);
   
  }
  
  /**
   * Obtiene las coordenadas de las casillas a donde es
   * posible mover la pieza, a partir de la posicion actual
   * de esta y a su movimiento valido. El numero de casilla posibles
   * no siempre es el mismo, por ello se necesita una lista y no
   * un arreglo de ellas.
   * @return Un objeto de la clase ListaCadena que representa la lista de cadenas 
   * (coordenadas de la casilla) donde es posible mover la pieza.
   */
  public abstract ListaCadena posiblesMovimientos();
  
}