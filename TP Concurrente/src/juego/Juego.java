package juego;

public class Juego {
	
	private Tablero tablero;
	
	public Juego(int tamaņoTablero){
		this.tablero = new Tablero(tamaņoTablero);
	}
	

	public void iniciar(){
		//TODO
	}
	
	public void finalizar(){
		//TODO
	}
	
	public static void main(String[] args) {
		//TODO 
	}
	
	
	public Tablero getTablero() {
		return tablero;
	}
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

}
