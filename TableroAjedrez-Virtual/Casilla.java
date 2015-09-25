import java.io.Serializable;

public class Casilla implements Serializable{

	public boolean color;
	public Pieza pieza;

	public Casilla(boolean col) {
		color = col;
		pieza = null;
	}

	public boolean daColor() {
		return color;
	}

	public void ponPieza(Pieza p) {
		pieza = p;
	}
	public void quitaPieza(){
		pieza = null;
	}
	
	public Pieza obtenerPieza(){
		return pieza;
	}

	public boolean casillaLibre() {
		if (pieza == null)
			return true;
		else
			return false;
	}

	public String toString() {
		String casilla = "";
		if (color && casillaLibre() == true)
			casilla = "₪₪₪₪₪|";
		if (color && casillaLibre() == false)
			casilla = "₪ " + pieza + "₪|";
		
		if(!color && casillaLibre() == false)
			casilla = "  " + pieza + " |";
		else if( !color && casillaLibre() == true)
		    casilla = "     |";
		return casilla;
	}

	public static void main(String[] args) {
		Casilla c1 = new Casilla(true);
		Casilla c2 = new Casilla(false);
		Pieza p = new Alfil(true);
		Pieza p2 = new Reina(false);
		c2.ponPieza(p2);
		System.out.println(c1.casillaLibre());
		System.out.println(p);
		System.out.println(c1);
		System.out.println(c2);
	}
}
