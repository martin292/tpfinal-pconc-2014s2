package juego;

public class Explorador extends Thread{
	
	
	private Posicion pos;
	//private Tablero tablero;
	
	public Explorador(Posicion p){
		this.pos = p;
	}
	
	public void run(){
		while(true){
			this.moverse();
		}
	}
	
	
	private void moverse() {
		//El explorador debe moverse por el tablero		
	}
	public void moverDer(){
		//Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	}
	public void moverIzq(){
		//Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	}
	public void moverNorte(){
		//Solo lo podra hacer si cuenta con al menos un compa�ero en alguna de las celdas contiguas laterales o traseras. 
		//Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compa�ero a una celda contigua.
	}
	public void moverSur(){
		//Solo lo podra hacer si cuenta con al menos un compa�ero en alguna de las celdas contiguas laterales o traseras. 
		//Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compa�ero a una celda contigua.
	}
	
	//--------------------------------------------------------------------
	
	public Posicion getPos() {
		return pos;
	}
	public void setPos(Posicion pos) {
		this.pos = pos;
	}
	
}
