import java.util.Random;
import java.util.Scanner;

public class PaseoDelCaballo extends UsaTableroAjedrez {
	public Caballo c;
	public int turno;
	public String[] movimientosCaballo;

	public PaseoDelCaballo() {
		movimientosCaballo = new String[64];
		turno = 0;
		Random r = new Random();
		c = new Caballo(r.nextBoolean());
		String posicionAleatoria = "";
		int aux2;
		aux2 = r.nextInt(8) + 49;
		posicionAleatoria += (char) aux2;
		aux2 = r.nextInt(8) + 97;
		posicionAleatoria += (char) aux2;
		colocarPiezaEnCasilla(c, posicionAleatoria);
		movimientosCaballo[0] = posicionAleatoria;
		turno++;
	}

	public int obtenerTurno() {
		return turno;
	}

	public void nuevaPosicion(String posicion) {
		String aux = c.daPosicion();
		if (c.movimientoValido(posicion)) {
			quitarPieza(aux);
			colocarPiezaEnCasilla(c, posicion);
			verificarPaseo(posicion);
			movimientosCaballo[turno] = posicion;
			turno++;

		} else {
			System.out.println("Movimiento no Valido");
		}
	}

	public void verificarPaseo(String posicion) {
		for (int i = 0; i <= turno; i++) {
			if (posicion.equals(movimientosCaballo[i])) {
				System.out.println("Repetiste una casilla\nPerdiste!!!");
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		PaseoDelCaballo p = new PaseoDelCaballo();
		String posicion;
		do {
			p.mostrarTablero();
			System.out.println("Introduce la siguiente posicion: ");
			posicion = teclado.nextLine();
			p.nuevaPosicion(posicion);
		} while (p.obtenerTurno() < 64);
		System.out.println("Haz Ganado");
	}
}
