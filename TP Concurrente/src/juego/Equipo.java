package juego;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	
	private int id;
	
	//private Tablero tablero;
	
	private List<Explorador> exploradores = new ArrayList<Explorador>();
	private List<Tesoro> tesoros = new ArrayList<Tesoro>();

	public Equipo(int id){
		this.id = id;
	}
	
	public void agregarExplorador(Explorador e){
		this.exploradores.add(e);
	}
	public void agregarTesoro(Tesoro t){
		this.tesoros.add(t);
	}
	
	//--------------------------------------------------------------------
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	

}
