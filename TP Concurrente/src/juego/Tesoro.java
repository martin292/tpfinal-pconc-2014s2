package juego;

public class Tesoro {

	private Posicion pos;
	private boolean conquistado;
	private Equipo equipo;
	
	public Tesoro(Posicion p, Equipo e){
		this.pos = p;
		this.equipo = e;
		this.conquistado = false;
	}
	
	public String toString(){
		return " Tesoro equipo: " + this.equipo;
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