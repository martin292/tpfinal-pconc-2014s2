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
	 * Mientras que queden tesoros por conquistar, el explorador debe 
	 * moverse aleatoriamente en una direccion.
	 * DERECHA   -> 1
	 * IZQUIERDA -> 2
	 * NORTE     -> 3
	 * SUR       -> 4
	 */
	public void run(){
		while(!this.team.todosMisTesorosConquistados()){
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
				} catch(InterruptedException e){
						e.printStackTrace();
						}
		}
	}	
	
	/**
	 * Si existe una posición a la derecha del explorador, éste se mueve
	 * hacia esa direccion
	 * @throws InterruptedException
	 */
	public void moverEste() throws InterruptedException{
		Posicion posAux = new Posicion (this.getPos().getX()+1, this.getPos().getY());
		
		if(this.tablero.existePos(posAux)){
			this.tablero.moverDer(this);
		 }
		//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
	}
	
	/**
	 * Si la posicion existe mueve al explorador a la izquierda
	 * @throws InterruptedException
	 */
	public void moverOeste() throws InterruptedException{
		Posicion posAux = new Posicion(this.getPos().getX()-1, this.getPos().getY());
		
		if(this.tablero.existePos(posAux)){
			this.tablero.moverIzq(this);
		 }
		//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
	}
	
	/**
	 * Si la posicion existe mueve al explorador al norte
	 * @throws InterruptedException
	 */
	public void moverNorte() throws InterruptedException{
		Posicion posAux = new Posicion(this.getPos().getX(), this.getPos().getY()+1);
		
		if(this.tablero.existePos(posAux)){
			this.tablero.moverNorte(this);
		 }
		//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
	}
	
	/**
	 * Si la posicion existe mueve al explorador al sur
	 * @throws InterruptedException
	 */
	public void moverSur() throws InterruptedException{
		Posicion posAux = new Posicion(this.getPos().getX(), this.getPos().getY()-1);
		
		if(this.tablero.existePos(posAux)){
			this.tablero.moverSur(this); 
		 }
		//Cuando un participante intenta un movimiento que lo llevaria fuera del 
		//tablero, se entera de que esta en el borde.
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