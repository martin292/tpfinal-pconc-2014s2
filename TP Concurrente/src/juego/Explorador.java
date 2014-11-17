package juego;

public class Explorador extends Thread{
		
	private Posicion pos;
	private Equipo team;
	private Tablero tablero;
	
	public Explorador(Posicion p, Equipo e){
		this.pos = p;
		this.team = e;
	}
	
	
	/**
	 * Mientras que los tesoros no hayan sido conquistados, el explorador debe moverse aleatoriamente en una direccion.
	 * DERECHA   -> 1
	 * IZQUIERDA -> 2
	 * NORTE     -> 3
	 * SUR       -> 4
	 */
	public void run(){
		while(!this.team.tesorosConquistados()){
			
			int num = 1 + (int)(Math.random()*4);
			
			try{
			switch(num) {
			 case 1: 
				 this.moverEste();				
			     break;
			 case 2: 
				 this.moverOeste();			
			     break;
			 case 3: 
				 this.moverNorte();
			     break;
			 case 4: 
				 this.moverSur();
			     break;
			}
			}catch(InterruptedException e){e.printStackTrace();}
		}
	}	
	
	/**
	 * Si la posicion existe mueve al explorador a la derecha
	 * @throws InterruptedException
	 */
	public void moverEste() throws InterruptedException{
		if(this.tablero.existePos(this.getPos().getX()+1, this.getPos().getY())){
			this.tablero.moverDer(this);
		 }
		//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
	}
	
	/**
	 * Si la posicion existe mueve al explorador a la izquierda
	 * @throws InterruptedException
	 */
	public void moverOeste() throws InterruptedException{
		if(this.tablero.existePos(this.getPos().getX()-1, this.getPos().getY())){
			this.tablero.moverIzq(this);
		 }
		//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
	}
	
	/**
	 * Si la posicion existe mueve al explorador al norte
	 * @throws InterruptedException
	 */
	public void moverNorte() throws InterruptedException{
		if(this.tablero.existePos(this.getPos().getX(), this.getPos().getY()+1)){
			this.tablero.moverNorte(this);
		 }
		//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
	}
	
	/**
	 * Si la posicion existe mueve al explorador al sur
	 * @throws InterruptedException
	 */
	public void moverSur() throws InterruptedException{
		if(this.tablero.existePos(this.getPos().getX(), this.getPos().getY()-1)){
			this.tablero.moverSur(this); 
		 }
		//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
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
