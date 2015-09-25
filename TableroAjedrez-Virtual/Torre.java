
public class Torre extends Pieza{

	public Torre(boolean color){
		super(color);
		
	}
	
	public ListaCadena posiblesMovimientos(){
		UsaListaCadena movimientos = new UsaListaCadena();
		if(daPosicion().equalsIgnoreCase("Ninguna"))
			return movimientos;
		else{
			int x = daPosicion().toLowerCase().charAt(0);
			int y = daPosicion().toLowerCase().charAt(1);
			for(int i = x; i < 57; i++){
				
				String aux = "";
				aux += (char) i;
				aux += (char) y;
				movimientos.insertarElemento(aux);
			}
			for(int i = x; i > 48; i--){
				String aux = "";
				aux += (char) i;
				aux += (char) y;
				movimientos.insertarElemento(aux);
			}
			for(int j = y; j < 105; j++){
				String aux = "";
				aux += (char) x;
				aux += (char) j;
				movimientos.insertarElemento(aux);
			}
			for(int j = y; j > 96; j--){
				String aux = "";
				aux += (char) x;
				aux += (char) j;
				movimientos.insertarElemento(aux);
			}
			return movimientos;
		}
	}

	public String toString(){
		String pieza;
		if(daColor())
			pieza = "Tn";
		else
			pieza = "Tb";
		return pieza;
	}
	
	public static void main(String[] args) {
		Torre a = new Torre(false);
		a.ponPosicion("2h");
		ListaCadena u = a.posiblesMovimientos();
		u.verLista();
	}
	
}
