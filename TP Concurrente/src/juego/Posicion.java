package juego;

public class Posicion {

	private int x;
	private int y;
	private boolean tieneTesoro;
	private boolean tieneExplorador;
	private boolean estaEnBorde;
	
	/**
	 * Crea una posición con las coordenadas x e y.
	 * También se inicializa sin tesoros y sin exploradores
	 * @param x
	 * @param y
	 */
	public Posicion(int x, int y){
		this.x = x;
		this.y = y;
		this.tieneTesoro = false;
		this.tieneExplorador = false;
	}
	
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Posicion && 
        		((Posicion)obj).x == this.x && 
        		((Posicion)obj).y == this.y;
    }
    
	/**
	 * Devuelve si la posición está ocupada, es decir, si contiene un 
	 * tesoro o un explorador
	 * @return true si tiene un explorador o un tesoro, false si no tiene ni
	 * tesoro ni explorador
	 */
	public boolean posicionOcupada(){
		return this.tieneTesoro || this.tieneExplorador;
	}
	
	//--------------------------------------------------------------------
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean estaEnBorde(){
		return this.estaEnBorde;
	}
	
	public void setEstaEnBorde(boolean estaEnBorde){
		this.estaEnBorde = estaEnBorde;
	}
	
	public boolean tieneTesoro(){
		return this.tieneTesoro;
	}
	
	public void setTieneTesoro(boolean tieneTesoro){
		this.tieneTesoro = tieneTesoro;
	}
	
	public boolean tieneExplorador(){
		return this.tieneExplorador;
	}
	
	public void setTieneExplorador(boolean tieneExplorador){
		this.tieneExplorador = tieneExplorador;

	}
}