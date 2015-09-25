/**
 * Interfaz ListaCadena: Esta interfaz representa las operaciones b&aacute;sicas para una
 * listas de cadenas, en las cuales se puede insertar, obtener y borrar un elemento.
 * Cada elemento en la lista tiene una referencia al elemento o nodo que fue insertado
 * antes de su inserci&oacute;n en la lista. Los nodos de estas listas contienen cadenas.
 * 
 * La idea de tener listas de cadenas es que se pueda de manera din&aacute;mica (en tiempo de
 * ejecuci&oacute;n) insertar tantos elementos como se quiera sin saber el n&uacute;mero determinado 
 * de ellos. Funciona como un arreglo que puede cambiar de tama&ntilde;o en tiempo de 
 * ejecuci&oacute;n.
 * @author Alejandro S&aacute;nchez Aviles.
 * @version 3.0
 * @see NodoCadena
 */ 
public interface ListaCadena{
  
  /**
   * Obtiene un objeto de clase NodoCadena que se encuentra al frente de la lista.
   * Este elemento es el mas recientemente insertado en la lista de cadenas. Se debe 
   * regresar una copia del objeto y no propiamente ya que de no hacerlo se regresa 
   * toda la lista de cadenas.
   * @return Un objeto de clase NodoCadena que es la cadena que esta al inicio de la lista
   * de cadenas.
   */ 
  public NodoCadena obtenerElemento();
  
  /**
   * Borra el nodo que esta al inicio de la lista. Este nodo es el mas recientemente
   * insertado en la lista de cadenas. Al borrar este primer nodo, el segundo elemento
   * de la lista se vuelve el primero.
   */ 
  public void borrarElemento();
  
  /**
   * Inserta un nodo (o mas propiamente dicho una cadena) a la lista
   * de cadenas. Este nodo es insertado al frente de los demas, siendo
   * el primer elemento de la lista, y su referencia al antiguo primer 
   * nodo.
   * @param nodoConCadena Un objeto de clase NodoCadena que se insertar&aacute; como
   * primer elemento en la lista de cadenas.
   */ 
  public void insertarElemento(NodoCadena nodoConCadena);
  
  /**
   * Verifica si la lista esta vacia, es decir no contiene nigun nodo 
   * (o mas propiamente dicho ninguna cadena).
   * @return Verdadero (true) si la lista de cadenas esta no contiene elementos.
   * Falso (false) en otro caso.
   */ 
  public boolean esVacia();
  
  /**
   * Imprime todos los elementos de la lista de cadenas en pantalla. 
   * Por ejemplo si la lista contiene: "Hola", "Ver", "Otro" imprimera todos
   * ellos en un formato adecuado como: (Hola) (Ver) (otro). 
   * -Esto es un formato sugerido-.
   */ 
  public void verLista();
  
}