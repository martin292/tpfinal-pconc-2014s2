package srcTest;

import static org.junit.Assert.*;
import juego.Posicion;

import org.junit.Before;
import org.junit.Test;

public class PosicionTest {
	
	private Posicion posicion;
	private Posicion posicion2;
	private Posicion posicion3;
	
	@Before
	public void setUp(){
		posicion = new Posicion(2,3);
		posicion2 = new Posicion(5,2);
		posicion3 = new Posicion(2,3);
	}

	@Test
	public void testGetX() {
		assertEquals(posicion.getX(), 2);
	}

	@Test
	public void testGetY() {
		assertEquals(posicion.getY(), 3);
	}
	
	@Test
	public void testSetX() {
		posicion.setX(5);
		assertEquals(posicion.getX(), 5);
	}

	@Test
	public void testSetY() {
		posicion.setY(4);
		assertEquals(posicion.getY(), 4);
	}
	
	@Test
	public void testPosicionesNoIguales() {
		assertFalse(posicion.equals(posicion2));
	}
	
	@Test
	public void testPosicionesIguales() {
		assertTrue(posicion.equals(posicion3));
	}
	
	@Test
	public void testPosicionOcupada(){
		assertFalse(posicion.posicionOcupada());
	}
	
	@Test
	public void testPosicionNoOcupada(){
		posicion.setTieneExplorador(true);
		assertTrue(posicion.posicionOcupada());
	}
	
	@Test
	public void testSetEstaEnBorde(){
		posicion2.setEstaEnBorde(false);
		assertFalse(posicion.estaEnBorde());
	}
	
	@Test
	public void testSetTieneTesoro(){
		posicion3.setTieneTesoro(true);
		assertTrue(posicion3.tieneTesoro());
	}
	
	@Test
	public void testNoTieneExplorador(){
		assertFalse(posicion.tieneExplorador());
	}

	@Test
	public void testTieneExplorador(){
		posicion.setTieneExplorador(true);
		assertTrue(posicion.tieneExplorador());
	}

}
