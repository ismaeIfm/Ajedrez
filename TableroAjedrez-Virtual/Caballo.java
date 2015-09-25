public class Caballo extends Pieza {

	public Caballo(boolean color) {
		super(color);
	}

	public ListaCadena posiblesMovimientos() {
		UsaListaCadena movimientos = new UsaListaCadena();
		if (daPosicion().equalsIgnoreCase("Ninguna"))
			return movimientos;
		else {
			int x = daPosicion().toLowerCase().charAt(0);
			int y = daPosicion().toLowerCase().charAt(1);
			if (x > 48 && y > 96) {
				String aux = "";
				aux += (char) (x - 2);
				aux += (char) (y - 1);
				movimientos.insertarElemento(aux);
			}
			if (x > 48 && y < 104) {
				String aux = "";
				aux += (char) (x - 2);
				aux += (char) (y + 1);
				movimientos.insertarElemento(aux);
			}
			if (x > 49 && y > 97) {
				String aux = "";
				aux += (char) (x - 1);
				aux += (char) (y - 2);
				movimientos.insertarElemento(aux);
			}
			if (x > 49 && y < 103) {
				String aux = "";
				aux += (char) (x - 1);
				aux += (char) (y + 2);
				movimientos.insertarElemento(aux);
			}
			if (x < 56 && y > 97) {
				String aux = "";
				aux += (char) (x + 1);
				aux += (char) (y - 2);
				movimientos.insertarElemento(aux);
			}
			if (x < 56 && y < 103) {
				String aux = "";
				aux += (char) (x + 1);
				aux += (char) (y + 2);
				movimientos.insertarElemento(aux);
			}
			if (x < 55 && y > 96) {
				String aux = "";
				aux += (char) (x + 2);
				aux += (char) (y - 1);
				movimientos.insertarElemento(aux);
			}
			if (x < 55 && y < 104) {
				String aux = "";
				aux += (char) (x + 2);
				aux += (char) (y + 1);
				movimientos.insertarElemento(aux);
			}
			return movimientos;
		}
	}

	public String toString() {
		String pieza;
		if (daColor())
			pieza = "Cn";
		else
			pieza = "Cb";
		return pieza;
	}
	public static void main(String[] args) {
		Caballo a = new Caballo(false);
		a.ponPosicion("8g");
		ListaCadena u = a.posiblesMovimientos();
		u.verLista();
	}
}
