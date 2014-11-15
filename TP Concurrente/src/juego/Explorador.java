package juego;

public class Explorador extends Thread{
	
	
	private Posicion pos;
	private Equipo team;
	
	public Explorador(Posicion p, Equipo e){
		this.pos = p;
		this.team = e;
	}
	
	public void run(){
		while(!this.team.tesorosConquistados()){
			this.moverse();
		}
	}	
	
	private void moverse() {
		//El explorador debe elegir en que direccion moverse (der, izq, norte, sur)		
	}
	
	public void moverDer(){
		//Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	}
	public void moverIzq(){
		//Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	}
	public void moverNorte(){
		//Solo lo podra hacer si cuenta con al menos un compañero en alguna de las celdas contiguas laterales o traseras. 
		//Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compañero a una celda contigua.
	}
	public void moverSur(){
		//Solo lo podra hacer si cuenta con al menos un compañero en alguna de las celdas contiguas laterales o traseras. 
		//Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compañero a una celda contigua.
	}
	
	//--------------------------------------------------------------------
	
	public Posicion getPos() {
		return pos;
	}
	public void setPos(Posicion pos) {
		this.pos = pos;
	}
	
}
