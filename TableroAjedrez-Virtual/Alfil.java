
public class Alfil extends Pieza{

	public Alfil(boolean color){
		super(color);
	}
	
	public ListaCadena posiblesMovimientos(){
		UsaListaCadena movimientos = new UsaListaCadena();
		if(daPosicion().equalsIgnoreCase("Ninguna"))
				return movimientos;
		else{
			int x = daPosicion().toLowerCase().charAt(0);
			int y = daPosicion().toLowerCase().charAt(1);
			for(int i = x,  j = y; i < 57 && j < 105 ; i++, j++){
				String aux = "";
				aux += (char) i;
				aux += (char) j;
				movimientos.insertarElemento(aux);
			}
			for(int i = x, j = y; i < 57 && j > 96; i++, j--){
				String aux = "";
				aux += (char) i;
				aux += (char) j;
				movimientos.insertarElemento(aux);
			}
			for(int i = x, j = y; i > 48 && j < 105; i--, j++){
				String aux = "";
				aux += (char) i;
				aux += (char) j;
				movimientos.insertarElemento(aux);				
			}
			for(int i = x, j = y; i > 48 && j > 96; i--, j--){
				String aux = "";
				aux += (char) i;
				aux += (char) j;
				movimientos.insertarElemento(aux);			
			}
			return movimientos;
		}
		
	}
	
	public String toString(){
		String pieza;
		if(daColor())
			pieza = "An";
		else
			pieza = "Ab";
		return pieza;
		
	}
	public static void main(String[] args) {
		Alfil a = new Alfil(false);
		a.ponPosicion("2h");
		ListaCadena u = a.posiblesMovimientos();
		u.verLista();
	}
}
