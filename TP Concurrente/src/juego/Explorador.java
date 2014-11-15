package juego;

public class Explorador extends Thread{
	
	
	private Posicion pos;
	private Equipo team;
	private Tablero tablero;
	
	public Explorador(Posicion p, Equipo e){
		this.pos = p;
		this.team = e;
	}
	
	public void run(){
		while(!this.team.tesorosConquistados()){
			//El explorador debe moverse en una direccion (der, izq, norte, sur)
			//this.tablero.moverDer(this)
			//this.tablero.moverIzq(this)
			//this.tablero.moverNorte(this)
			//this.tablero.moverSur(this)
		}
	}	
		
	//--------------------------------------------------------------------
	
	public Posicion getPos() {
		return pos;
	}
	public void setPos(Posicion pos) {
		this.pos = pos;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
}
