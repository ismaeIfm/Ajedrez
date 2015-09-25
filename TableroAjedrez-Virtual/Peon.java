public class Peon extends Pieza {
	public int turno;

	public Peon(boolean color) {
		super(color);
		turno = 0;

	}

	public ListaCadena posiblesMovimientos() {
		UsaListaCadena movimientos = new UsaListaCadena();
		if (daPosicion().equalsIgnoreCase("Ninguna"))
			return movimientos;
		else {
			int x = daPosicion().toLowerCase().charAt(0);
			int y = daPosicion().toLowerCase().charAt(1);
			if (turno == 0) {
				if (!daColor()) {

					String aux = "";
					aux += (char) (x + 2);
					aux += (char) y;
					movimientos.insertarElemento(aux);
				} else {
					String aux = "";
					aux += (char) (x - 2);
					aux += (char) y;
					movimientos.insertarElemento(aux);
				}
			}

			if (!daColor() && x < 56) {
				String aux = "";
				aux += (char) (x + 1);
				aux += (char) y;
				movimientos.insertarElemento(aux);
			} else {
				String aux = "";
				aux += (char) (x - 1);
				aux += (char) y;
				movimientos.insertarElemento(aux);
			}

			/**
			 * if (daColor() && x > 49 && y < 104) { String aux = ""; aux +=
			 * (char) (x - 1); aux += (char) (y+1);
			 * movimientos.insertarElemento(aux); } if (daColor() && x > 49 && y
			 * > 96) { String aux = ""; aux += (char) (x - 1); aux += (char)
			 * (y-1); movimientos.insertarElemento(aux); } if (!daColor() && x <
			 * 56 && y < 104) { String aux = ""; aux += (char) (x + 1); aux +=
			 * (char) (y+1); movimientos.insertarElemento(aux); } if (!daColor()
			 * && x < 56 && y > 96) { String aux = ""; aux += (char) (x + 1);
			 * aux += (char) (y-1); movimientos.insertarElemento(aux); }
			 */
			return movimientos;
		}
	}

	public void actualizarTurno(){
		turno++;
	}
	
	public String toString() {
		String pieza;
		if (daColor())
			pieza = "Pn";
		else
			pieza = "Pb";
		return pieza;
	}

	public static void main(String[] args) {
		Peon a = new Peon(true);
		a.ponPosicion("7a");
		ListaCadena u = a.posiblesMovimientos();
		u.verLista();
	}

}
