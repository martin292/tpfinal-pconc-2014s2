package juego;

public class Tesoro {

	private Posicion pos;
	//private boolean conquistado = false;
	
	public Tesoro(Posicion p){
		this.pos = p;
	}
	
	//--------------------------------------------------------------------
	
	public Posicion getPos() {
		return pos;
	}
	public void setPos(Posicion pos) {
		this.pos = pos;
	}
	
}
