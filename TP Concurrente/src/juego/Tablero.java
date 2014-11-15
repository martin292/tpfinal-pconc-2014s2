package juego;

public class Tablero extends Thread{
	
	private int tama�o;
	
	private Equipo norte;
	private Equipo sur;
	
	private int inicioN; //[(tama�o+1)/2]+1
	private int finN; //(tama�o)
	private int inicioS; //(1)
	private int finS; //(tama�o-1)/2
	
	
	public Tablero(int t){
		this.tama�o = t;
		
		this.inicioN = ((t+1)/2)+1;
		this.finN = t;
		this.inicioS = 1;
		this.finS = (t-1)/2;
	}
	
	public boolean juegoFinalizado(){
		return this.norte.tesorosConquistados() || this.sur.tesorosConquistados();
	}
	
	public void run() {
		//Crear N Exploradores para el Equipo NORTE
		//Crear M Tesoros para el Equipo NORTE
		
		//Crear N Exploradores para el Equipo SUR
		//Crear M Tesoros para el Equipo SUR
		
		//Asignar Posiciones a Exploradores y Tesoros

		//
		
		//...
		this.norte.start();
		this.sur.start();
		//...
	}
	
	public synchronized void moverDer(Explorador e){
		//Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
		/*
		while(this.posOcupada(x,y)){
		    wait();
		}
		mover
		signalAll();
		*/
	}
	public synchronized void moverIzq(Explorador e){
		//Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
		/*
		while(this.posOcupada(x,y)){
		    wait();
		}
		mover
		signalAll();
		*/
	}
	public synchronized void moverNorte(Explorador e){
		//Solo lo podra hacer si cuenta con al menos un compa�ero en alguna de las celdas contiguas laterales. 
		//Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compa�ero a una celda contigua.
		/*
		while(this.celdasContiguasDesocupadas(x,y)){
		    wait();
		}
		mover
		signalAll();
		*/
	}
	public synchronized void moverSur(Explorador e){
		//Solo lo podra hacer si cuenta con al menos un compa�ero en alguna de las celdas contiguas laterales. 
		//Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compa�ero a una celda contigua.
		/*
		while(this.celdasContiguasDesocupadas(x,y)){
		    wait();
		}
		mover
		signalAll();
		*/
	}
	
	//--------------------------------------------------------------------
	
	public int getTama�o() {
		return tama�o;
	}
	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
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

	

}
