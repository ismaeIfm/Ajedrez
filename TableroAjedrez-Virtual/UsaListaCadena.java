import java.io.Serializable;

public class UsaListaCadena implements ListaCadena, Serializable {
	public NodoCadena nodoCadena;

	public UsaListaCadena(NodoCadena nodo) {
		nodoCadena = nodo;
	}

	public UsaListaCadena() {
		nodoCadena = null;
	}

	public NodoCadena obtenerElemento() {
		NodoCadena n = new NodoCadena(nodoCadena);
		return n;
	}

	public void borrarElemento() {
		NodoCadena n = new NodoCadena(nodoCadena.daAnterior());
		nodoCadena = n;
	}

	public void insertarElemento(NodoCadena nodoConCadena) {
		nodoConCadena.ponAnterior(nodoCadena);
		nodoCadena = nodoConCadena;
	}

	public void insertarElemento(String cadena) {
		NodoCadena n = new NodoCadena(cadena);
		n.ponAnterior(nodoCadena);
		nodoCadena = n;
	}

	public boolean esVacia() {
		return nodoCadena.daAnterior().equals(null);
	}

	public void verLista() {
		NodoCadena n = nodoCadena;
		String aux = "";
		if (nodoCadena == null)
			System.out.println("Lista vacia");
		else {
			do {
				aux += n + ", ";
				n = n.daAnterior();
			} while (n != null);
			System.out.println("Contenido: " + aux);
		}
	}

	public boolean buscarMovimientoValido(String posicion) {
		NodoCadena n = nodoCadena;
		boolean bandera = false;
		while (n != null && bandera == false) {
			if (n.daContenido().equals(posicion)) {
				bandera = true;
			}
			n = n.daAnterior();
		}
		return bandera;
	}

	public int cuantosElementos(){
		int cont = 0;
		NodoCadena n = new NodoCadena(obtenerElemento());
		while(n != null){
			cont++;
			n = obtenerElemento().daAnterior();
		}
		return cont;
	}
	
	public boolean compararElementoEnOtraLista(UsaListaCadena l){
		NodoCadena n = new NodoCadena(obtenerElemento());
		
		for(int i = cuantosElementos(); i == 0; i--){
			if(l.buscarMovimientoValido( n.daContenido()))
				return true;
			n = n.daAnterior();
		}
		return false;
	}
	
	public static void main(String[] args) {
		UsaListaCadena l = new UsaListaCadena();
		l.verLista();
		if (l.buscarMovimientoValido("8b"))
			System.out.println("si");
		else
			System.out.println("NO");
		l.insertarElemento("8b");
		if (l.buscarMovimientoValido("8b"))
			System.out.println("si");
		else
			System.out.println("NO");
	}

}
