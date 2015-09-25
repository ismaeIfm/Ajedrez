import java.io.Serializable;
import java.util.Scanner;

public class UsaTableroAjedrez implements TableroAjedrez, Serializable {

	public Casilla[][] tablero = new Casilla[8][8];

	public UsaTableroAjedrez() {

		for (int j = 0; j < 8; j++, j++) {
			for (int i = 0; i < 8; i++, i++) {
				Casilla blanca = new Casilla(false);
				tablero[j][i] = blanca;
			}
		}
		for (int j = 1; j < 8; j++, j++) {
			for (int i = 1; i < 8; i++, i++) {
				Casilla blanca = new Casilla(false);
				tablero[j][i] = blanca;
			}
		}
		for (int j = 0; j < 8; j++, j++) {
			for (int i = 1; i < 8; i++, i++) {
				Casilla negra = new Casilla(true);
				tablero[j][i] = negra;
			}
		}
		for (int j = 1; j < 8; j++, j++) {
			for (int i = 0; i < 8; i++, i++) {
				Casilla negra = new Casilla(true);
				tablero[j][i] = negra;
			}
		}
	}

	public boolean colocarPiezaEnCasilla(Pieza pieza, String posicionNueva) {
		/*
		 * if (tablero[(int) posicionNueva.charAt(0) - 48][(int) posicionNueva
		 * .toLowerCase().charAt(1) - 97].casillaLibre() == true) {
		 * tablero[(int) posicionNueva.charAt(0) - 48][(int) posicionNueva
		 * .toLowerCase().charAt(1) - 97].ponPieza(pieza);
		 */
		if (tablero[obtenerCoordenada(posicionNueva, true)][obtenerCoordenada(
				posicionNueva, false)].casillaLibre() == true) {
			tablero[obtenerCoordenada(posicionNueva, true)][obtenerCoordenada(
					posicionNueva, false)].ponPieza(pieza);
			pieza.ponPosicion(posicionNueva);
			return true;
		} else
			return false;
	}

	public void quitarPieza(String posicionTablero) {
		tablero[obtenerCoordenada(posicionTablero, true)][obtenerCoordenada(
				posicionTablero, false)].quitaPieza();

	}

	public Pieza obtenerPieza(String posicionTablero) {
		return tablero[obtenerCoordenada(posicionTablero, true)][obtenerCoordenada(
				posicionTablero, false)].obtenerPieza();
	}

	public boolean casillaOcupada(String posicionTablero) {
		return !tablero[obtenerCoordenada(posicionTablero, true)][obtenerCoordenada(
				posicionTablero, false)].casillaLibre();
	}

	public int obtenerCoordenada(String posicion, boolean regresaXoY) {
		int aux;
		if (regresaXoY == true) {
			aux = (int) posicion.toLowerCase().charAt(0) - 49;
			return aux;
		} else
			aux = (int) posicion.toLowerCase().charAt(1) - 97;
		return aux;
	}

	public void mostrarTablero() {
		String aux1 = "|₪₪₪₪₪|     |₪₪₪₪₪|     |₪₪₪₪₪|     |₪₪₪₪₪|     |\n";
		String aux2 = "|     |₪₪₪₪₪|     |₪₪₪₪₪|     |₪₪₪₪₪|     |₪₪₪₪₪|\n";
		String table = "   a     b     c     d     e     f     g     h  \n ______________________________________________\n";

		for (int i = 0; i < 8; i++) {
			if (i == 0 || i == 2 || i == 4 || i == 6)
				table += aux2;
			else
				table += aux1;
			table += ("|" + tablero[i][0].toString() + tablero[i][1].toString()
					+ tablero[i][2].toString() + tablero[i][3].toString()
					+ tablero[i][4].toString() + tablero[i][5].toString()
					+ tablero[i][6].toString() + tablero[i][7].toString()
					+ "  " + (i + 1) + "\n");
			if (i == 0 || i == 2 || i == 4 || i == 6)
				table += aux2;
			else
				table += aux1;
		}
		table += " ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
		System.out.println(table);
	}

	/*
	 * public boolean guardarEstadoTablero(String nombreDelJuego) {
	 * 
	 * }
	 * 
	 * public boolean recuperarEstadoTablero(String nombreArchivoTablero) {
	 * 
	 * }
	 */
	public int decodificarPosicion(String posicion) {
		int aux;
		aux = (int) posicion.toLowerCase().charAt(0);
		return aux;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in); 
		UsaTableroAjedrez u = new UsaTableroAjedrez();
		u.mostrarTablero();
		Pieza p = new Peon(true);
		u.colocarPiezaEnCasilla(p, "2h");
		u.mostrarTablero();
		String posicionNueva;
		posicionNueva = teclado.nextLine();
		u.colocarPiezaEnCasilla(p, posicionNueva);
		u.mostrarTablero();
	}
}
