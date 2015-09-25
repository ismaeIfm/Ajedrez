/**
 * Interfaz TableroAjedrez: Modela un objeto que representa un tablero de ajedrez. Este tablero consta de
 * 64 casillas (objeto de la clase Casilla) es decir de 8x8. Intercale casillas blancas y negras comenzando
 * cada renglon con par con una casilla negra cada renglon impar con una casilla blanca. En cada casilla de
 * tablero se puede colocar, obtener y quitar una pieza de ajedrez.
 * @author Alejandro Sanchez Aviles
 * @version 3.0
 * @see Pieza
 */ 
public interface TableroAjedrez{
  
  /**
   * Coloca una pieza, si es posible, en la casilla (realmente se indica su coordenada) del tablero de ajedrez
   * que se indica.
   * @param pieza Un objeto de clase Pieza que representa la pieza que se quiere colocar en el tablero.
   * @param posicionNueva Una cadena que representa la coordenada de la casilla donde se colocara la pieza.
   * Esta cadena es de la forma NW, donde N es un numero entre 1 y 8, y W una letra entre A y H. 
   * Esta coordenada es interpretada en el tablero como (N,W). Por ejemplo si se da la cadena "3F" la pieza
   * debe colocarse en la casilla que esta en el renglon 2 y columna 5 del arreglo de casillas del tablero.
   * @return Verdadero si se tuvo exito al colocar la pieza en la casilla del tablero. Falso si la casilla esta ocupada o
   * no es valida para un movimiento de la pieza; en este caso debe indicarse con un mensaje al usuario lo que ha pasado.
   */ 
  public boolean colocarPiezaEnCasilla(Pieza pieza, String posicionNueva);  
  /**
   * Retira la pieza de la casilla del tablero que se indica.
   * @param posicionTablero Una cadena que representa la coordenada de la casilla de donde se
   * quiere quetar la pieza. Esta cadena es de la forma NW, donde N es un numero entre 1 y 8, y W una letra entre A y H. 
   * Esta coordenada es interpretada en el tablero como (N,W). Por ejemplo si se da la cadena "3F" la pieza
   * debe colocarse en la casilla que esta en el renglon 2 y columna 5 del arreglo de casillas del tablero.
   */ 
  public void quitarPieza(String posicionTablero);
  
  /**
   * Obtiene la pieza que se encuetra en la casilla del tablero que se indica.
   * @param posicionTablero Una cadena que representa la coordenada de la casilla de donde se
   * quiere obtener la pieza. Esta cadena es de la forma NW, donde N es un numero entre 1 y 8, y W una letra entre A y H. 
   * Esta coordenada es interpretada en el tablero como (N,W). Por ejemplo si se da la cadena "3F" la pieza
   * debe colocarse en la casilla que esta en el renglon 2 y columna 5 del arreglo de casillas del tablero.
   * @return Un objero de clase Pieza que reprenta la pieza que esta en la casilla indicada. En caso de no tener
   * una pieza, se regresa NULL.
   */ 
  public Pieza obtenerPieza(String posicionTablero);
  
  /**
   * Verifica si la casilla indicada del tablero contiene o no una pieza de ajedrez.
   * @param posicionTablero Una cadena que representa la coordenada de la casilla que se quiere verificar
   * si hay o no una pieza. Esta cadena es de la forma NW, donde N es un numero entre 1 y 8, y W una letra entre A y H. 
   * Esta coordenada es interpretada en el tablero como (N,W). Por ejemplo si se da la cadena "3F" la pieza
   * debe colocarse en la casilla que esta en el renglon 2 y columna 5 del arreglo de casillas del tablero.
   * @return Verdadero (true) si la casilla contiene una pieza (un objeto de la clase Pieza), falso (false) si no
   * contien alguna pieza.
   */ 
  public boolean casillaOcupada(String posicionTablero);
  
  /**
   * Obtiene una coordenada valida para un arreglo bidimencional de 8x8 casillas a partir de una cadena de la forma
   * NW, donde N es un numero entre 1 y 8, y W una letra entre A y H. Esta coordenada es interpretada en el tablero 
   * como (N,W).
   * @param posicion Una cadena que representa la coordenada de la casilla que se quiere verificar
   * si hay o no una pieza. Esta cadena es de la forma NW, donde N es un numero entre 1 y 8, y W una letra entre A y H. 
   * Esta coordenada es interpretada en el tablero como (N,W). Por ejemplo si se da la cadena "3F" la pieza
   * debe colocarse en la casilla que esta en el renglon 2 y columna 5 del arreglo de casillas del tablero.
   * @param regresaXoY Si es verdadero (true) se obtiene la coordenada X o del renglon de la casilla en el arreglo. Si es
   * falso (false) se obtiene la coordenada Y o de la columna de la casilla en el arreglo. Si la coordenada en el tablero
   * es (N,W) se obtiene X a partirnde N o se obtiene Y a partir de W.
   * @return Un entero que representa una coordenada valida en un arreglo bidimencional de 8x8.
   * 
   * Por ejemplo si se usa como:
   * 
   * int x = tablero.obtenerCoordenada("8G", true);
   * 
   * El valor de la variable X es de 7. Pero si se usa:
   * 
   * int y = tablero.obtenerCoordenada("8G", false);
   * 
   * El valor de la variable Y es de 6. 
   * 
   * Entonces una coordenada en el tablero de ajedrez NW es decir (N,W) se traduce en una coordenada del tipo:
   * 
   * (tablero.obtenerCoordenada(nW, true), tablero.obtenerCoordenada(nW, false))
   * 
   * Valida en un arreglo bidimencional de 8x8 casillas. Para el ejemplo dado seria:
   * 
   * "8G" -> (8, G) -> (7,6) es decir el elemento [7][6] del arreglo bidimencional.
   * 
   * 
   */ 
  public int obtenerCoordenada(String posicion, boolean regresaXoY);
  
  /**
   * Imprime en pantalla de una manera sencilla y facil de interpretar el tablero de ajedrez con todos
   * sus elementos, tanto las casilla negras y blancas, asi como las piezas (ya sean blancas o negras)
   * contenidas en cada casilla.
   */ 
  public void mostrarTablero();
  
   /**
   * Guarda, si es posible, el estado del tablero en un archivo. El tablero se guarda
   * con la configuracion que tenga en el momento en que se guarda, es decir: la posicion de cada
   * pieza (con el color respectivo) y casilla vacias u ocupadas.
   * 
   * El tablero se guarda por medio de serializacion en un archivo nombrado de la siguiente manera:
   * 
   * <NOMBREJUEGO><fecha del guardado><extension .tablero>
   * 
   * Donde:
   * 
   * -> NOMBREJUEGO es el nombre del juego que usa el tablero de acuerdo a la siguiente regla
   *         -> Si es el juego de las 8 reinas: "reinasTablero"
   *         -> Si es el juego del paseo del caballo: "caballosTablero"
   *         -> Si es el jueog de ajedrez: "ajedrezTablero"
   * 
   * -> Fecha del guardado: Es la fecha del dia en que se realiza el guardado en un formato DDMMAA y si se realizan
   * guardados en el mismo dia se debe inclir la hora de la siguiente manera: DDMMAA-HHMMSS.
   * 
   * -> La extension para los archivos es: "tablero".
   * 
   * Por ejemplo si un usuario esta jugando con el tablero el juego de las 8 reinas un dia 23/junio/2011 a las 4 de la
   * tarde el archivo es nombrado como:
   * 
   * "reinasTablero230611-160000.tablero"
   * @param nombreDelJuego Una cadena que representa el nombre del juego que se esta jugando en el tablero del ajedrez se acuerdo
   * a las reglas antes dadas.
   * @return Verdadero (true) si se guardo con exito el archivo, y falso (false) en otro caso. Se indica con un mensaje en pantalla
   * si el tablero no puedo ser guardado y se explica la razon de este caso.
   * 
   * 
   */ 
 // public boolean guardarEstadoTablero(String nombreDelJuego);
  
  /**
   * Se coloca al tablero, si es posible, el estado de un tablero previamente guardado por medio de serializacion.
   * @param nombreArchivoTablero Una cadena que representa el nombre del archivo en donde se guardo
   * el estado del tablero previamente.
   * @return Verdadero (true) si se recupero con exito el estado del tablero, y falso (false) en otro caso. Se indica con un 
   * mensaje en pantalla si el tablero no pudo ser recuperado y se explica la razon de este caso.
   */ 
  //public boolean recuperarEstadoTablero(String nombreArchivoTablero);
  
}