package srcTest;

import static org.junit.Assert.*;
import juego.Equipo;
import juego.Posicion;
import juego.Tesoro;

import org.junit.Before;
import org.junit.Test;

public class TesoroTest {
	
	private Tesoro tesoro;
	private Posicion posicion;

	@Before
	public void setUp(){
		posicion = new Posicion(2,3);
		tesoro = new Tesoro(posicion, new Equipo("Norte"));
	}

	@Test
	public void testSetUp() {
		assertEquals(tesoro.getPos(), posicion);
		assertFalse(tesoro.fueConquistado());
	}
	
	@Test
	public void testSetPosicion() {
		Posicion pos2 = new Posicion(4,2);
		tesoro.setPos(pos2);
		assertEquals(tesoro.getPos(), pos2);
	}

	@Test
	public void testSetFueConquistado() {
		tesoro.setConquistado(true);
		assertTrue(tesoro.fueConquistado());
	}
}
