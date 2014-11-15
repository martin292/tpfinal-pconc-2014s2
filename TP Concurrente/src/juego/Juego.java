package juego;

public class Juego {
	
	public static void main(String[] args) {
		
		//Se crea el tablero
		Tablero tablero = new Tablero(11);
		
		//Se crean los equipos
		Equipo e1 = new Equipo();
		Equipo e2 = new Equipo();
		
		//Se crean exploradores, tesoros y se agregan a los equipos
		//
				
		//Se agregan los equipos al tablero
		tablero.setNorte(e1);
		tablero.setSur(e2);
		
		//Comienza el juego	
		tablero.iniciar();
		
	}
}
