package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.management.monitor.Monitor;

public class Tablero {
	
	int tamanio;
	private List<Posicion> posiciones = new ArrayList<Posicion>();
	private Equipo equipoNorte;
	private Equipo equipoSur;
	private Posicion inicioNorte; //[(tama�o+1)/2]+1
	private Posicion finNorte; //(tama�o)
	private Posicion inicioSur; //(1)
	private Posicion finSur; //(tama�o-1)/2	

	public Tablero(int t){  
		this.tamanio = t;		
		equipoNorte = new Equipo("Norte"); 
		equipoSur = new Equipo("Sur"); 		
		this.crearPosiciones(t); 
		this.agregarExploradores(equipoNorte, equipoSur);
		this.agregarTesoros(equipoNorte, equipoSur);
		/*
		this.inicioNorte = new Posicion(1,1);
		this.finNorte = new Posicion(((t-1)/2),t);
		this.inicioSur = new Posicion(1,(((t-1)/2)+1));
		this.finSur = new Posicion (t,t);
		*/
	}	
	
	public void crearPosiciones(int t){
		this.crearPosicionesNorte(t);
		this.crearLineaDivisoria(t); 
		this.crearPosicionesSur(t); 
	}
	
	public void crearPosicionesNorte(int t){
		List<Posicion> posicionesNorte = new ArrayList<Posicion>();
		int i,j;
		for(i=1; i<=((t-1)/2); i++){
			for(j=1; j<=t; j++){
				Posicion pos = new Posicion(i,j);
				pos.setEstaEnBorde(i == 1 || j == 1 || j == t);
				posicionesNorte.add(pos);
			}
		}
		
		equipoNorte.setPosiciones(posicionesNorte);
		posiciones.addAll(posicionesNorte);
	}
	
	public void crearLineaDivisoria(int t){
		List<Posicion> lineaDivisoria = new ArrayList<Posicion>();
		int j;

		for(j=1; j<=t; j++){
			Posicion pos = new Posicion(((t+1)/2),j);
			pos.setEstaEnBorde(j == 1 || j == t);
			lineaDivisoria.add(pos);
			}
		posiciones.addAll(lineaDivisoria);
	}
	
	public void crearPosicionesSur(int t){
		List<Posicion> posicionesSur = new ArrayList<Posicion>();
		int i,j;
		
		for(i=(((t-1)/2)+2); i<=t; i++){
			for(j=1; j<=t; j++){
				Posicion pos = new Posicion(i,j);
				pos.setEstaEnBorde(j == 1 || i == t || j == t);
				posicionesSur.add(pos);
			}
		}		
		
		equipoSur.setPosiciones(posicionesSur);
		posiciones.addAll(posicionesSur);
	}
	
	private void agregarTesoros(Equipo e){
		int cantTesoros;
		for(cantTesoros = 1; cantTesoros <= ((this.tamanio -1)/2); cantTesoros++){
			Posicion posR = posicionVaciaRandom(e);
			Tesoro tesoro = new Tesoro(posR);
			e.agregarTesoro(tesoro);
			e.getPosiciones().get(e.getPosiciones().indexOf(posR)).setTieneTesoro(true);
		}
	}
	
	private Posicion posicionVaciaRandom(Equipo e){
		List<Posicion> pos = e.getPosiciones();
		int cantPos = pos.size();
		Posicion posR = pos.get(0);
		while (posR.estaEnBorde() || posR.posicionOcupada()){
			Random rnd = new Random();
			int numR = rnd.nextInt(cantPos);
			posR = pos.get(numR);
		}	
		return posR;
	}
	
	private Posicion posicionRandom(Equipo e){
		List<Posicion> pos = e.getPosiciones();
		int cantPos = pos.size();
		Posicion posR = pos.get(0);
		while (posR.posicionOcupada()){
			Random rnd = new Random();
			int numR = rnd.nextInt(cantPos);
			posR = pos.get(numR);
		}	
		return posR;
	}
	
	private void agregarExploradores(Equipo e){
		int cantExploradores;
		for(cantExploradores = 1; cantExploradores <= (((this.tamanio -1)/2)+1); cantExploradores++){
			Posicion posR = posicionRandom(e);
			Explorador explorador = new Explorador(posR, e, this, cantExploradores);
			e.agregarExplorador(explorador);
			e.getPosiciones().get(e.getPosiciones().indexOf(posR)).setTieneExplorador(true);
		}
	}
	
	private void agregarExploradores(Equipo e1, Equipo e2){
		this.agregarExploradores(e1);
		this.agregarExploradores(e2);
	}
	
	public void agregarTesoros(Equipo e1, Equipo e2){
		this.agregarTesoros(e1);
		this.agregarTesoros(e2);
	}

	
	//-------------------------------------------------------------
	public void start() {		
		//...
		this.equipoNorte.start();
		this.equipoSur.start();
		//...
	}

	public void stop() {
		// TODO 		
		//Finalizar juego
	}
	//-------------------------------------------------------------
	
	
	/**
	 * Retorna true si el juego finalizo
	 * (El juego finaliza cuando todos los tesoros de un equipo son 
	 * conquistados)
	 */
	public boolean juegoFinalizado(){
		return this.equipoNorte.todosMisTesorosConquistados() || 
			   this.equipoSur.todosMisTesorosConquistados();
	}
	
	/**
	 * Retorna si la posicion dada se encuentra en el tablero
	 * @return
	 */
	public boolean existePos(Posicion p) {
		return this.posiciones.contains(p);
	}
	
	private void conquistarTesoro(Explorador e) {
		// TODO 
		//Si el tesoro es de equipo contrario, lo conquista		
	}

	private boolean hayTesoroEnPosicion(Posicion p) {
		boolean ret = false;
		
		for(Posicion pos: this.posiciones){
			if(pos.equals(p)){
				ret = pos.tieneTesoro();
				break;
			}
		}
		
		return ret;
	}

	/**
	 * Mueve al explorador a la derecha (+1 en el eje x)
	 * Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	 * @param e
	 * @throws InterruptedException
	 */
	
	public synchronized void moverDer(Explorador e) throws InterruptedException{
		
		Posicion p = new Posicion(e.getPos().getX()+1,e.getPos().getY());
		
		while(this.posOcupada(p)){
			System.out.println(e.toString() + " Bloquado");
		    wait();
		    System.out.println(e.toString() + " Desbloquado");
		}
		e.setPos(p);

		if(this.hayTesoroEnPosicion(e.getPos())){
			this.conquistarTesoro(e);
		}
		notifyAll();
			
	}

	/**
	 * Retorna true  si la posicion esta ocupada
	 * Se dice que una celda esta ocupada, cuando hay un participante en esa posicicion
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean posOcupada(Posicion p) {		
		return this.equipoNorte.estaOcupada(p) || this.equipoSur.estaOcupada(p);
	}

	/**
	 * Mueve al explorador a la izquierda (-1 en el eje x)
	 * Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	 * @param e
	 * @throws InterruptedException
	 */
	public synchronized void moverIzq(Explorador e) throws InterruptedException{
	
		Posicion p = new Posicion(e.getPos().getX()-1,e.getPos().getY());
		
		while(this.posOcupada(p)){
			System.out.println(e.toString() + " Bloquado");
		    wait();
		    System.out.println(e.toString() + " Desbloquado");
		}		
		e.setPos(p);
		
		if(this.hayTesoroEnPosicion(e.getPos())){
			this.conquistarTesoro(e);
		}
		notifyAll();		
	}

	/**
	 * Mueve al explorador hacia arriba (+1 en el eje y)
	 * Solo lo podra hacer si cuenta con al menos un compa�ero en alguna de las celdas contiguas laterales.
	 * Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compa�ero a una celda contigua.
	 * @param e
	 * @throws InterruptedException
	 */
	public synchronized void moverNorte(Explorador e) throws InterruptedException{		
		Posicion p = new Posicion(e.getPos().getX(),e.getPos().getY()+1);
		while(this.posOcupada(p) || !this.celdasContiguasOcupadas(p, e.getTeam())){
			System.out.println(e.toString() + " Bloquado");
		    wait();
		    System.out.println(e.toString() + " Desbloquado");
		}
		e.setPos(p);
		
		if(this.hayTesoroEnPosicion(e.getPos())){
			this.conquistarTesoro(e);
		}
		notifyAll();			
	}

	/**
	 * Mueve al explorador hacia abajo (-1 en el eje y)
	 * Solo lo podra hacer si cuenta con al menos un compa�ero en alguna de las celdas contiguas laterales.
	 * Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compa�ero a una celda contigua.
	 * @param e
	 * @throws InterruptedException
	 */
	public synchronized void moverSur(Explorador e) throws InterruptedException{
		Posicion p = new Posicion(e.getPos().getX(),e.getPos().getY()-1);
		while(this.posOcupada(p) || !this.celdasContiguasOcupadas(p, e.getTeam())){
			System.out.println(e.toString() + " Bloquado");
		    wait();
		    System.out.println(e.toString() + " Desbloquado");
		}
		e.setPos(p);
		
		if(this.hayTesoroEnPosicion(e.getPos())){
			this.conquistarTesoro(e);
		}
		notifyAll();
	}
	
	/**
	 * Retorna true si las celdas laterales estan desocupadas
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean celdasContiguasOcupadas(Posicion p, Equipo e) {
		Posicion posDer = new Posicion(p.getX()+1, p.getY());
		Posicion posIzq = new Posicion(p.getX()-1, p.getY());
		
		return e.estaOcupada(posDer) || e.estaOcupada(posIzq); 
	}
		
	//--------------------------------------------------------------------

	public List<Posicion> getPosiciones(){
		return this.posiciones;
	}
	
	public int getTamanio() {
		return tamanio;
	}

	public Equipo getNorte() {
		return this.equipoNorte;
	}
	
	public Equipo getSur() {
		return this.equipoSur;
	}
	
	/*
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
*/
}