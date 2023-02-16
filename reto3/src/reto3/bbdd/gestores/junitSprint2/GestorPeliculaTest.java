package reto3.bbdd.gestores.junitSprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.GestorPelicula;

class GestorPeliculaTest {
	private GestorPelicula gestor = null;

	public GestorPeliculaTest() {
		gestor = new GestorPelicula();
	}

	@Test
	void testFechasDeUnaPelicula() {
// se espera un ArrayList de tipo Date size() == 2 de la pelicula id = 2 cine id = 2 y ordenadas
		ArrayList<Date> fechas = gestor.getFechasDeUnaPelicula(2, 2);
		assertEquals(fechas.size(), 2);
		boolean result1 = fechas.get(0).before(fechas.get(1));
		assertTrue(result1);

	}

}
