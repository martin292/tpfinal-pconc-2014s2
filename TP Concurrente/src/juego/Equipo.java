package juego;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends Thread{	
		
	private List<Explorador> exploradores = new ArrayList<Explorador>();
	private List<Tesoro> tesoros = new ArrayList<Tesoro>();

	public Equipo(){
		super();
	}
	
	/**
	 * Activa todos los threads explorador
	 */
	public void run(){
		for(Explorador e: this.exploradores){
			e.start();
		}
	}
	
	/**
	 * Retorna true si todos sus tesoros fueron conquistados
	 * @return
	 */
	public boolean tesorosConquistados() {
		boolean ret = true;
		for(Tesoro t: this.tesoros){
			ret = ret && t.isConquistado();
		}		
		return ret;
	}

	/**
	 * Retorna true si hay un explorador en esa posicion
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean estaOcupada(int x, int y) {
		boolean ret = false;
		
		for(Explorador e: this.exploradores){
			ret = ret || e.getPos().igual(x,y);
		}
		
		return ret;
	}
	
	
	//--------------------------------------------------------------------	

	public void agregarExplorador(Explorador e){
		this.exploradores.add(e);
	}
	public void agregarTesoro(Tesoro t){
		this.tesoros.add(t);
	}

	
	
	
}
