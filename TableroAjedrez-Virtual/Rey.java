
public class Rey extends Pieza{

	public Rey(boolean color){
		super(color);
	}
	public ListaCadena posiblesMovimientos(){
		UsaListaCadena movimientos = new UsaListaCadena();
		if (daPosicion().equalsIgnoreCase("Ninguna"))
			return movimientos;
		else{
			int x = daPosicion().toLowerCase().charAt(0);
			int y = daPosicion().toLowerCase().charAt(1);
			if (x > 49 ) {
				String aux = "";
				aux += (char) (x - 1);
				aux += (char) y;
				movimientos.insertarElemento(aux);
			}
			if (x < 56) {
				String aux = "";
				aux += (char) (x + 1);
				aux += (char) y;
				movimientos.insertarElemento(aux);
			}
			if (y < 104 ) {
				String aux = "";
				aux += (char) x;
				aux += (char) (y+1);
				movimientos.insertarElemento(aux);
			}
			if (y > 96) {
				String aux = "";
				aux += (char) x;
				aux += (char) (y-1);
				movimientos.insertarElemento(aux);
			}
			if (x > 49  && y < 104) {
				String aux = "";
				aux += (char) (x - 1);
				aux += (char) (y+1);
				movimientos.insertarElemento(aux);
			}
			if (x > 49  && y > 96) {
				String aux = "";
				aux += (char) (x - 1);
				aux += (char) (y-1);
				movimientos.insertarElemento(aux);
			}
			if (x < 56 && y < 104) {
				String aux = "";
				aux += (char) (x + 1);
				aux += (char) (y+1);
				movimientos.insertarElemento(aux);
			}
			if (x < 56 && y > 96) {
				String aux = "";
				aux += (char) (x + 1);
				aux += (char) (y-1);
				movimientos.insertarElemento(aux);
			}

			return movimientos;

		}
	}
	public String toString(){
		String pieza;
		if(daColor())
			pieza = "Kn";
		else
			pieza = "Kb";
		return pieza;
	}
	public static void main(String[] args) {
		Rey a = new Rey(false);
		a.ponPosicion("5e");
		ListaCadena u = a.posiblesMovimientos();
		u.verLista();
	}
}
