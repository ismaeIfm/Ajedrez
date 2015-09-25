import java.io.Serializable;

public class Jugador implements Serializable {
	
	public String nombre;
	public boolean color;

	public Jugador (String nom, boolean col){
		nombre = nom;
		color = col;
	}
	
	public String daNombre(){
		return nombre;
	}
	
	public boolean daColor(){
		return color;
	}
	
}
