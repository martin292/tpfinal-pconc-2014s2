package juego;

import java.util.ArrayList;
import java.util.List;

public class Equipo extends Thread{

	private String nombre;
	private List<Posicion> posiciones;
	private List<Explorador> exploradores;
	private List<Tesoro> tesoros;
	private List<Tesoro> tesorosConquistados;

	public Equipo(String name){
		this.nombre = name;
		this.posiciones = new ArrayList<Posicion>();
		this.exploradores = new ArrayList<Explorador>();
		this.tesoros = new ArrayList<Tesoro>();
		this.tesorosConquistados = new ArrayList<Tesoro>();
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
	 * Retorna si todos sus tesoros fueron conquistados, es decir, si perdió
	 * @return true si fueron todos conquistados, false si queda alguno por conquistar
	 */
	public boolean todosMisTesorosConquistados() {
		boolean ret = true;
		for(Tesoro t: this.tesoros){
			ret = ret && t.fueConquistado();
		}		
		return ret;
	}

	/**
	 * Retorna true si hay un explorador en esa posicion
	 * @param x
	 * @param y
	 * @return
	 */

	public boolean estaOcupada(Posicion p) {
		boolean ret = false;
		
		for(Posicion pos: this.posiciones){
			if(pos.equals(p)){
				ret = pos.tieneExplorador();
				break;
			}
		}
		
		return ret;
	}
	
	public String toString(){
		return this.nombre;
	}
	
	
	//--------------------------------------------------------------------	
	public List<Posicion> getPosiciones(){
		return this.posiciones;
	}
	
	public void setPosiciones(List<Posicion> p){
		this.posiciones = p;
	}
	
	public List<Tesoro> getTesorosConquistados(){
		return this.tesorosConquistados;
	}
	
	public List<Explorador> getExploradores(){
		return this.exploradores;
	}
	/**
	 * Agrega un explorador a la colección de exploradores de un equipo 
	 * @param Explorador e
	 */
	public void agregarExplorador(Explorador e){
		this.exploradores.add(e);
	}
	
	/**
	 * Agrega un tesoro a la colección de tesoros de un equipo 
	 * @param Tesoro t
	 */
	public void agregarTesoro(Tesoro t){
		this.tesoros.add(t);
	}
}