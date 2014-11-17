package juego;

import javax.management.monitor.Monitor;

public class Tablero extends Monitor{
	
	private int tamaño;
	
	private Equipo norte;
	private Equipo sur;
	
	private int inicioN; //[(tamaño+1)/2]+1
	private int finN; //(tamaño)
	private int inicioS; //(1)
	private int finS; //(tamaño-1)/2	
	
	public Tablero(int t){
		this.tamaño = t;
		
		this.inicioN = ((t+1)/2)+1;
		this.finN = t;
		this.inicioS = 1;
		this.finS = (t-1)/2;
	}	
	
	//-------------------------------------------------------------
	@Override
	public void start() {
		// TODO 
		
		//Crear N Exploradores para el Equipo NORTE
		//Crear M Tesoros para el Equipo NORTE
				
		//Crear N Exploradores para el Equipo SUR
		//Crear M Tesoros para el Equipo SUR
				
		//Asignar Posiciones a Exploradores y Tesoros

		//Agregar Exploradores y Tesoros al Equipo NORTE y SUR
				
		//...
		this.norte.start();
		this.sur.start();
		//...		
	}

	@Override
	public void stop() {
		// TODO 
		
		//Finalizar juego
	}
	//-------------------------------------------------------------
	
	
	/**
	 * Retorna true si el juego finalizo
	 * (El juego finaliza cuando todos los tesoros de un equipo son conquistados)
	 */
	public boolean juegoFinalizado(){
		return this.norte.tesorosConquistados() || this.sur.tesorosConquistados();
	}
	
	/**
	 * Retorna true si las coordenadas entran en el tablero
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean existePos(int x, int y) {
		return (x > 0 && x <= this.tamaño) && (y > 0 && y <= this.tamaño);
	}
	
	/**
	 * Mueve al explorador a la derecha (+1 en el eje x)
	 * Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	 * @param e
	 * @throws InterruptedException
	 */
	public synchronized void moverDer(Explorador e) throws InterruptedException{	
		while(this.posOcupada(e.getPos().getX()+1,e.getPos().getY())){
		    wait();
		}
		e.getPos().setX(e.getPos().getX()+1);
		notifyAll();		
	}
	
	/**
	 * Retorna true  si la posicion esta ocupada
	 * Se dice que una celda esta ocupada, cuando hay un participante en esa posicicion
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean posOcupada(int x, int y) {
		//TODO
		return false;
	}

	/**
	 * Mueve al explorador a la izquierda (-1 en el eje x)
	 * Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	 * @param e
	 * @throws InterruptedException
	 */
	public synchronized void moverIzq(Explorador e) throws InterruptedException{
		//Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
		while(this.posOcupada(e.getPos().getX()-1,e.getPos().getY())){
		    wait();
		}
		e.getPos().setX(e.getPos().getX()-1);
		notifyAll();
	}
	
	/**
	 * Mueve al explorador hacia arriba (+1 en el eje y)
	 * Solo lo podra hacer si cuenta con al menos un compañero en alguna de las celdas contiguas laterales.
	 * Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compañero a una celda contigua.
	 * @param e
	 * @throws InterruptedException
	 */
	public synchronized void moverNorte(Explorador e) throws InterruptedException{		
		while(this.celdasContiguasDesocupadas(e.getPos().getX(),e.getPos().getY()+1)){
		    wait();
		}
		e.getPos().setY(e.getPos().getY()+1);
		notifyAll();		
	}
	
	/**
	 * Retorna true si las celdas laterales estan desocupadas
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean celdasContiguasDesocupadas(int x, int y) {
		// TODO 
		return false;
	}

	/**
	 * Mueve al explorador hacia abajo (-1 en el eje y)
	 * Solo lo podra hacer si cuenta con al menos un compañero en alguna de las celdas contiguas laterales.
	 * Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compañero a una celda contigua.
	 * @param e
	 * @throws InterruptedException
	 */
	public synchronized void moverSur(Explorador e) throws InterruptedException{
		while(this.celdasContiguasDesocupadas(e.getPos().getX(),e.getPos().getY()-1)){
		    wait();
		}
		e.getPos().setY(e.getPos().getY()-1);
		notifyAll();
	}
	
	
	
	
	//--------------------------------------------------------------------
	
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	public Equipo getNorte() {
		return norte;
	}
	public void setNorte(Equipo norte) {
		this.norte = norte;
	}
	public Equipo getSur() {
		return sur;
	}
	public void setSur(Equipo sur) {
		this.sur = sur;
	}
	public int getInicioN() {
		return inicioN;
	}
	public void setInicioN(int inicioN) {
		this.inicioN = inicioN;
	}
	public int getFinN() {
		return finN;
	}
	public void setFinN(int finN) {
		this.finN = finN;
	}
	public int getInicioS() {
		return inicioS;
	}
	public void setInicioS(int inicioS) {
		this.inicioS = inicioS;
	}
	public int getFinS() {
		return finS;
	}
	public void setFinS(int finS) {
		this.finS = finS;
	}

	//

}
