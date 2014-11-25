package juego;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.management.monitor.Monitor;

public class Tablero extends Monitor{
	
	int tamanio;
	private List<Posicion> posiciones;
	private Equipo equipoNorte;
	private Equipo equipoSur;
	private Posicion inicioNorte; //[(tamaño+1)/2]+1
	private Posicion finNorte; //(tamaño)
	private Posicion inicioSur; //(1)
	private Posicion finSur; //(tamaño-1)/2	

	public Tablero(int t){  
		this.tamanio = t;
		equipoNorte = new Equipo();
		equipoSur = new Equipo();
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
			Explorador explorador = new Explorador(posR, e);
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
	@Override
	public void start() {
		// TODO 
		
		//Crear una lista de Posiciones para cada equipo, donde luego
		// se van a agregar los exploradores y tesoros
		
		// Posiciones equipo NORTE
		// Posiciones equipo SUR
		
		
		//Crear N Exploradores y los ubica para el Equipo NORTE
		//Crear M Tesoros y los ubica para el Equipo NORTE
		

				
		//Crear N Exploradores y los ubica para el Equipo SUR
		//Crear M Tesoros y los ubica para el Equipo SUR
				


				
		//...
		this.equipoNorte.start();
		this.equipoSur.start();
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

	/**
	 * Mueve al explorador a la derecha (+1 en el eje x)
	 * Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	 * @param e
	 * @throws InterruptedException
	 */
	
	public synchronized void moverDer(Explorador e) throws InterruptedException{	
	/*	while(this.posOcupada(e.getPos().getX()+1,e.getPos().getY())){
		    wait();
		}
		e.getPos().setX(e.getPos().getX()+1);
		//Si hay tesoro del equipo contrario lo conquista
		notifyAll();
	*/		
	}

	/**
	 * Retorna true  si la posicion esta ocupada
	 * Se dice que una celda esta ocupada, cuando hay un participante en esa posicicion
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean posOcupada(Posicion p) {
		/*
		return this.equipoNorte.estaOcupada(p) || this.equipoSur.estaOcupada(p);
	*/
		return false; //BORRAR ESTA LINEA
	}

	/**
	 * Mueve al explorador a la izquierda (-1 en el eje x)
	 * Si la celda esta ocupada, se quedara bloqueado hasta tanto se libere
	 * @param e
	 * @throws InterruptedException
	 */
	public synchronized void moverIzq(Explorador e) throws InterruptedException{
	/*
		while(this.posOcupada(e.getPos()){
			//ARREGLAR
		    wait();
		}
		e.getPos().setX(e.getPos().getX()-1);
		//Si hay tesoro del equipo contrario lo conquista
		notifyAll();
		*/
	}

	/**
	 * Mueve al explorador hacia arriba (+1 en el eje y)
	 * Solo lo podra hacer si cuenta con al menos un compañero en alguna de las celdas contiguas laterales.
	 * Si no puede avanzar, se quedara bloqueado hasta tanto llegue un compañero a una celda contigua.
	 * @param e
	 * @throws InterruptedException
	 */
	public synchronized void moverNorte(Explorador e) throws InterruptedException{		
		/*
		 while(this.celdasContiguasDesocupadas(e.getPos().getX(),e.getPos().getY()+1) || this.posOcupada(e.getPos().getX(),e.getPos().getY()+1)){
		 
		    wait();
		}
		e.getPos().setY(e.getPos().getY()+1);
		//Si hay tesoro del equipo contrario lo conquista
		notifyAll();
		*/		
	}

	/**
	 * Retorna true si las celdas laterales estan desocupadas
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean celdasContiguasDesocupadas(int x, int y) {
		//TODO
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
		//Si hay tesoro del equipo contrario lo conquista
		notifyAll();
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