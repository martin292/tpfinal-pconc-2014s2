package juego;

public class Tablero {
	
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
	
	public boolean juegoFinalizado(){
		return this.norte.tesorosConquistados() || this.sur.tesorosConquistados();
	}
	
	public void iniciar() {	}
	
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
	}
	public synchronized void moverNorte(Explorador e){
		//Solo lo podra hacer si cuenta con al menos un compañero en alguna de las celdas contiguas laterales o traseras. 
		//Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compañero a una celda contigua.
	}
	public synchronized void moverSur(Explorador e){
		//Solo lo podra hacer si cuenta con al menos un compañero en alguna de las celdas contiguas laterales o traseras. 
		//Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compañero a una celda contigua.
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

	

}
