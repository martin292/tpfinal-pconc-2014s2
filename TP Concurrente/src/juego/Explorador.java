package juego;

public class Explorador extends Thread{
		
	private int id;
	private Posicion pos;
	private Equipo team;
	private Tablero tablero;
	
	public Explorador(Posicion p, Equipo e, Tablero t, int i){
		this.pos = p;
		this.team = e;
		this.tablero = t;
		this.id = i;
	}
		
	/**
	 * Mientras que queden tesoros por conquistar, el explorador debe 
	 * moverse aleatoriamente en una direccion.
	 * DERECHA   -> 1
	 * IZQUIERDA -> 2
	 * NORTE     -> 3
	 * SUR       -> 4
	 * NADA      -> 5
	 */
	public void run(){
		while(!this.team.todosMisTesorosConquistados()){
			int num = 1 + (int)(Math.random()*5);
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
				  case 5:
					  //Se queda en el lugar
					  break;
					}
				} catch(InterruptedException e){
						e.printStackTrace();
						}
		}
		System.out.println("Tesoros de equipo " + this.team.toString() + " conquistados");
	}	
	
	/**
	 * Si existe una posici�n a la derecha del explorador, �ste se mueve
	 * hacia esa direccion
	 * @throws InterruptedException
	 */
	public void moverEste() throws InterruptedException{
		Posicion posAux = new Posicion (this.getPos().getX()+1, this.getPos().getY());
		Posicion pos = this.getPos();
		
		if(this.tablero.existePos(posAux)){	
			System.out.println(this.toString() + " De posicion: " + pos.toString() + " intente mover derecha");
			this.tablero.moverDer(this);			
		 }else{
			//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
		 }
	}
	
	/**
	 * Si la posicion existe mueve al explorador a la izquierda
	 * @throws InterruptedException
	 */
	public void moverOeste() throws InterruptedException{
		Posicion posAux = new Posicion(this.getPos().getX()-1, this.getPos().getY());
		Posicion pos = this.getPos();
		
		if(this.tablero.existePos(posAux)){
			System.out.println(this.toString() + " De posicion: " + pos.toString() + " intente mover izquierda");
			this.tablero.moverIzq(this);
		 }else{
			//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
		 }
	}
	
	/**
	 * Si la posicion existe mueve al explorador al norte
	 * @throws InterruptedException
	 */
	public void moverNorte() throws InterruptedException{
		Posicion posAux = new Posicion(this.getPos().getX(), this.getPos().getY()+1);
		Posicion pos = this.getPos();
		
		if(this.tablero.existePos(posAux)){
			System.out.println(this.toString() + " De posicion: " + pos.toString() + " intente mover arriva");
			this.tablero.moverNorte(this);
		 }else{
			//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
		 }
	}
	
	/**
	 * Si la posicion existe mueve al explorador al sur
	 * @throws InterruptedException
	 */
	public void moverSur() throws InterruptedException{
		Posicion posAux = new Posicion(this.getPos().getX(), this.getPos().getY()-1);
		Posicion pos = this.getPos();
		
		if(this.tablero.existePos(posAux)){
			System.out.println(this.toString() + " De posicion: " + pos.toString() + " intente mover abajo");
			this.tablero.moverSur(this); 
		 }else{
			//Cuando un participante intenta un movimiento que lo llevaria fuera del tablero, se entera de que esta en el borde.
		 }
	}
	
	public String toString(){
		return "Explorador: " + this.id + " Equipo: " + this.team.toString();
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
	public Equipo getTeam() {
		return team;
	}
	public void setTeam(Equipo team) {
		this.team = team;
	}
}