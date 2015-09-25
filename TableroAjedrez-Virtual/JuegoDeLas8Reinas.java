import java.util.Random;
import java.util.Scanner;

public class JuegoDeLas8Reinas extends UsaTableroAjedrez {
	public int turno;
	public Pieza q1, q2, q3, q4, q5, q6, q7, q8;

	public JuegoDeLas8Reinas() {
		turno = 0;
		Random r = new Random();
		boolean aux = r.nextBoolean();
		q1 = new Reina(aux);
		q2 = new Reina(aux);
		q3 = new Reina(aux);
		q4 = new Reina(aux);
		q5 = new Reina(aux);
		q6 = new Reina(aux);
		q7 = new Reina(aux);
		q8 = new Reina(aux);
		String posicionAleatoria = "";
		int aux2;
		aux2 = r.nextInt(8) + 49;
		posicionAleatoria += (char) aux2;
		aux2 = r.nextInt(8) + 97;
		posicionAleatoria += (char) aux2;
		colocarPiezaEnCasilla(q1, posicionAleatoria);
		mostrarTablero();
	}

	public int obtenerTurno() {
		return turno;
	}

	public void posicionReina(String posicion) {
		switch (turno) {
		case 0:
			colocarPiezaEnCasilla(q2, posicion);
			turno++;
			break;
		case 1:
			colocarPiezaEnCasilla(q3, posicion);
			turno++;
			break;
		case 2:
			colocarPiezaEnCasilla(q4, posicion);
			turno++;
			break;
		case 3:
			colocarPiezaEnCasilla(q5, posicion);
			turno++;
			break;
		case 4:
			colocarPiezaEnCasilla(q6, posicion);
			turno++;
			break;
		case 5:
			colocarPiezaEnCasilla(q7, posicion);
			turno++;
			break;
		case 6:
			colocarPiezaEnCasilla(q8, posicion);
			verificarJuego();
			break;
		default:
			System.out.println("Hola");
			break;
		}
	}

	public void verificarJuego() {
		if (q1.movimientoValido(q2.daPosicion())
				|| q1.movimientoValido(q3.daPosicion())
				|| q1.movimientoValido(q4.daPosicion())
				|| q1.movimientoValido(q5.daPosicion())
				|| q1.movimientoValido(q6.daPosicion())
				|| q1.movimientoValido(q7.daPosicion())
				|| q1.movimientoValido(q8.daPosicion())
				|| q2.movimientoValido(q1.daPosicion())
				|| q2.movimientoValido(q3.daPosicion())
				|| q2.movimientoValido(q4.daPosicion())
				|| q2.movimientoValido(q5.daPosicion())
				|| q2.movimientoValido(q6.daPosicion())
				|| q2.movimientoValido(q7.daPosicion())
				|| q2.movimientoValido(q8.daPosicion())
				|| q3.movimientoValido(q1.daPosicion())
				|| q3.movimientoValido(q2.daPosicion())
				|| q3.movimientoValido(q4.daPosicion())
				|| q3.movimientoValido(q5.daPosicion())
				|| q3.movimientoValido(q6.daPosicion())
				|| q3.movimientoValido(q7.daPosicion())
				|| q3.movimientoValido(q8.daPosicion())
				|| q4.movimientoValido(q1.daPosicion())
				|| q4.movimientoValido(q2.daPosicion())
				|| q4.movimientoValido(q3.daPosicion())
				|| q4.movimientoValido(q5.daPosicion())
				|| q4.movimientoValido(q6.daPosicion())
				|| q4.movimientoValido(q7.daPosicion())
				|| q4.movimientoValido(q8.daPosicion())
				|| q5.movimientoValido(q1.daPosicion())
				|| q5.movimientoValido(q2.daPosicion())
				|| q5.movimientoValido(q3.daPosicion())
				|| q5.movimientoValido(q4.daPosicion())
				|| q5.movimientoValido(q6.daPosicion())
				|| q5.movimientoValido(q7.daPosicion())
				|| q5.movimientoValido(q8.daPosicion())
				|| q6.movimientoValido(q1.daPosicion())
				|| q6.movimientoValido(q2.daPosicion())
				|| q6.movimientoValido(q3.daPosicion())
				|| q6.movimientoValido(q4.daPosicion())
				|| q6.movimientoValido(q5.daPosicion())
				|| q6.movimientoValido(q7.daPosicion())
				|| q6.movimientoValido(q8.daPosicion())
				|| q7.movimientoValido(q1.daPosicion())
				|| q7.movimientoValido(q2.daPosicion())
				|| q7.movimientoValido(q3.daPosicion())
				|| q7.movimientoValido(q4.daPosicion())
				|| q7.movimientoValido(q5.daPosicion())
				|| q7.movimientoValido(q6.daPosicion())
				|| q7.movimientoValido(q8.daPosicion())
				|| q8.movimientoValido(q1.daPosicion())
				|| q8.movimientoValido(q2.daPosicion())
				|| q8.movimientoValido(q3.daPosicion())
				|| q8.movimientoValido(q4.daPosicion())
				|| q8.movimientoValido(q5.daPosicion())
				|| q8.movimientoValido(q6.daPosicion())
				|| q8.movimientoValido(q7.daPosicion()))
			System.out.println("Perdiste");
		else 
			System.out.println("Ganaste");
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		JuegoDeLas8Reinas j = new JuegoDeLas8Reinas();
		String coordenada;
		do {

			System.out.println("Coordenada:");

			coordenada = teclado.nextLine();
			j.posicionReina(coordenada);
			j.mostrarTablero();
		} while (j.obtenerTurno() < 7);
	}
}