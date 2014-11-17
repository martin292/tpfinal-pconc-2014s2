package juego;

public class Posicion {

	private int x;
	private int y;
	
	public Posicion(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Retorna true si las coordenadas son iguales
	 * @param x2
	 * @param y2
	 * @return
	 */
	public boolean igual(int x2, int y2) {
		return this.x == x2 && this.y == y2;
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

			
}
