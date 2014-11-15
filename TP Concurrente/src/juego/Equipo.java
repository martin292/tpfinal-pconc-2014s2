package juego;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends Thread{
	
		
	private Tablero tablero;
	
	private List<Explorador> exploradores = new ArrayList<Explorador>();
	private List<Tesoro> tesoros = new ArrayList<Tesoro>();

	public Equipo(){
		super();
	}
	
	public void run(){
		for(Explorador e: this.exploradores){
			e.start();
		}
	}
	
	public void agregarExplorador(Explorador e){
		this.exploradores.add(e);
	}
	public void agregarTesoro(Tesoro t){
		this.tesoros.add(t);
	}

	//--------------------------------------------------------------------
	
	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
}
