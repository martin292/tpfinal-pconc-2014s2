package juego;

public class Tesoro {

	private Posicion pos;
	private boolean conquistado;
	
	public Tesoro(Posicion p){
		this.pos = p;
		this.conquistado = false;
	}
	
	//--------------------------------------------------------------------
	
	public Posicion getPos() {
		return pos;
	}
	
	public void setPos(Posicion pos) {
		this.pos = pos;
	}

	public boolean fueConquistado() {
		return conquistado;
	}

	public void setConquistado(boolean conquistado) {
		this.conquistado = conquistado;
	}	
}