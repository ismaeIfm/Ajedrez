import java.util.Scanner;

public class Ajedrez extends UsaTableroAjedrez {
	public Jugador blanco, negro;

	public Pieza pb1 = new Peon(false);
	public Pieza pb2 = new Peon(false);
	public Pieza pb3 = new Peon(false);
	public Pieza pb4 = new Peon(false);
	public Pieza pb5 = new Peon(false);
	public Pieza pb6 = new Peon(false);
	public Pieza pb7 = new Peon(false);
	public Pieza pb8 = new Peon(false);

	public Pieza tb1 = new Torre(false);
	public Pieza tb2 = new Torre(false);

	public Pieza cb1 = new Caballo(false);
	public Pieza cb2 = new Caballo(false);

	public Pieza ab1 = new Alfil(false);
	public Pieza ab2 = new Alfil(false);

	public Pieza qb = new Reina(false);

	public Pieza kb = new Rey(false);

	public Pieza pn1 = new Peon(true);
	public Pieza pn2 = new Peon(true);
	public Pieza pn3 = new Peon(true);
	public Pieza pn4 = new Peon(true);
	public Pieza pn5 = new Peon(true);
	public Pieza pn6 = new Peon(true);
	public Pieza pn7 = new Peon(true);
	public Pieza pn8 = new Peon(true);

	public Pieza tn1 = new Torre(true);
	public Pieza tn2 = new Torre(true);

	public Pieza cn1 = new Caballo(true);
	public Pieza cn2 = new Caballo(true);

	public Pieza an1 = new Alfil(true);
	public Pieza an2 = new Alfil(true);

	public Pieza qn = new Reina(true);

	public Pieza kn = new Rey(true);

	public Ajedrez(Jugador b, Jugador n) {

	}

	public void acomodarPiezas() {
		colocarPiezaEnCasilla(pn1, "7a");
		colocarPiezaEnCasilla(pn2, "7b");
		colocarPiezaEnCasilla(pn3, "7c");
		colocarPiezaEnCasilla(pn4, "7d");
		colocarPiezaEnCasilla(pn5, "7e");
		colocarPiezaEnCasilla(pn6, "7f");
		colocarPiezaEnCasilla(pn7, "7g");
		colocarPiezaEnCasilla(pn8, "7h");
		colocarPiezaEnCasilla(tn1, "8a");
		colocarPiezaEnCasilla(tn1, "8h");
		colocarPiezaEnCasilla(cn1, "8b");
		colocarPiezaEnCasilla(cn2, "8g");
		colocarPiezaEnCasilla(an1, "8c");
		colocarPiezaEnCasilla(an2, "8f");
		colocarPiezaEnCasilla(qn, "8d");
		colocarPiezaEnCasilla(kn, "8e");

		colocarPiezaEnCasilla(pb1, "2a");
		colocarPiezaEnCasilla(pb2, "2b");
		colocarPiezaEnCasilla(pb3, "2c");
		colocarPiezaEnCasilla(pb4, "2d");
		colocarPiezaEnCasilla(pb5, "2e");
		colocarPiezaEnCasilla(pb6, "2f");
		colocarPiezaEnCasilla(pb7, "2g");
		colocarPiezaEnCasilla(pb8, "2h");
		colocarPiezaEnCasilla(tb1, "1a");
		colocarPiezaEnCasilla(tb1, "1h");
		colocarPiezaEnCasilla(cb1, "1b");
		colocarPiezaEnCasilla(cb2, "1g");
		colocarPiezaEnCasilla(ab1, "1c");
		colocarPiezaEnCasilla(ab2, "1f");
		colocarPiezaEnCasilla(qb, "1d");
		colocarPiezaEnCasilla(kb, "1e");
		mostrarTablero();
	}

	public boolean pedirPosicion(Jugador j, String posicionActual,
			String posicionNueva) {
		if (j.daColor() == obtenerPieza(posicionActual).daColor()) {
			if (obtenerPieza(posicionActual).movimientoValido(posicionNueva)
					&& casillaOcupada(posicionNueva) && ! (obtenerPieza(posicionActual) instanceof Peon))
				quitarPieza(posicionNueva);
			if (obtenerPieza(posicionActual).movimientoValido(posicionNueva)) {
				colocarPiezaEnCasilla(obtenerPieza(posicionActual),
						posicionNueva);
				quitarPieza(posicionActual);
				if(obtenerPieza(posicionNueva) instanceof Peon)
					((Peon) obtenerPieza(posicionNueva)).actualizarTurno();
				return true;
			}
			return false;
		} else
			System.out.println("Esa no es tu pieza");
		String aux1, aux2;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce la coordena de la pieza a mover:");
		aux1 = teclado.nextLine();
		System.out.println("Introduce la nueva posicion: ");
		aux2 = teclado.nextLine();
		pedirPosicion(j, aux1, aux2);
		return false;
	}

	public boolean estaEnJaque(Jugador j) {
		if (j.daColor()) {
			if (pn1.movimientoValido(kb.daPosicion())
					|| pn2.movimientoValido(kb.daPosicion())
					|| pn3.movimientoValido(kb.daPosicion())
					|| pn4.movimientoValido(kb.daPosicion())
					|| pn5.movimientoValido(kb.daPosicion())
					|| pn6.movimientoValido(kb.daPosicion())
					|| pn7.movimientoValido(kb.daPosicion())
					|| pn8.movimientoValido(kb.daPosicion())
					|| an1.movimientoValido(kb.daPosicion())
					|| an2.movimientoValido(kb.daPosicion())
					|| tn1.movimientoValido(kb.daPosicion())
					|| tn2.movimientoValido(kb.daPosicion())
					|| cn1.movimientoValido(kb.daPosicion())
					|| cn2.movimientoValido(kb.daPosicion())
					|| qn.movimientoValido(kb.daPosicion())
					|| kn.movimientoValido(kb.daPosicion()))
				return true;
			else
				return false;
		} else {
			if (pb1.movimientoValido(kn.daPosicion())
					|| pb2.movimientoValido(kn.daPosicion())
					|| pb3.movimientoValido(kn.daPosicion())
					|| pb4.movimientoValido(kn.daPosicion())
					|| pb5.movimientoValido(kn.daPosicion())
					|| pb6.movimientoValido(kn.daPosicion())
					|| pb7.movimientoValido(kn.daPosicion())
					|| pb8.movimientoValido(kn.daPosicion())
					|| ab1.movimientoValido(kn.daPosicion())
					|| ab2.movimientoValido(kn.daPosicion())
					|| tb1.movimientoValido(kn.daPosicion())
					|| tb2.movimientoValido(kn.daPosicion())
					|| cb1.movimientoValido(kn.daPosicion())
					|| cb2.movimientoValido(kn.daPosicion())
					|| qb.movimientoValido(kn.daPosicion())
					|| kb.movimientoValido(kn.daPosicion()))
				return true;
			else
				return false;

		}

	}

	public boolean estaEnJaqueMate(Jugador j) {
		UsaListaCadena u = (UsaListaCadena) queRey(j).posiblesMovimientos();
		if (estaEnJaque(j)) {
			if (j.daColor()) {
				return u.compararElementoEnOtraLista((UsaListaCadena) pb1
						.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pb2
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pb3
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pb4
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pb5
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pb6
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pb7
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pb8
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) ab1
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) ab2
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) cb1
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) cb2
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) tb1
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) tb2
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) qb
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) kb
								.posiblesMovimientos());
			} else {
				return u.compararElementoEnOtraLista((UsaListaCadena) pn1
						.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pn2
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pn3
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pn4
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pn5
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pn6
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pn7
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) pn8
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) an1
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) an2
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) cn1
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) cn2
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) tn1
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) tn2
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) qn
								.posiblesMovimientos())
						|| u.compararElementoEnOtraLista((UsaListaCadena) kn
								.posiblesMovimientos());
			}
		}else
			return false;
	}

	public Pieza queRey(Jugador j) {
		if (j.daColor())
			return kn;
		else
			return kb;
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String pieza, posicionNueva;
		Jugador b = new Jugador("Ismael", false);
		Jugador n = new Jugador("José", true);
		Ajedrez a = new Ajedrez(b, n);
		a.acomodarPiezas();
		do {
			System.out
					.println("Jugador blanco: Introduce la coordena de la pieza a mover:");
			pieza = teclado.nextLine();
			System.out.println("Introduce la nueva posicion: ");
			posicionNueva = teclado.nextLine();
			a.pedirPosicion(b, pieza, posicionNueva);
			a.mostrarTablero();
			System.out
					.println("Jugador negro: Introduce la coordena de la pieza a mover:");
			pieza = teclado.nextLine();
			System.out.println("Introduce la nueva posicion: ");
			posicionNueva = teclado.nextLine();
			a.pedirPosicion(n, pieza, posicionNueva);
			a.mostrarTablero();
		} while (a.estaEnJaqueMate(n) == false || a.estaEnJaqueMate(b) == false);
	}
}