package reto3.bbdd.gestores.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.GestorPelicula;

class GestorPeliculaTest {
	/**
	 * Fecha de realizacion 13-02-2023
	 */
	@Test
	void testGetFechasDeUnaPelicula() {
		// se espera un arraylist.size() == 2 // fecha de realizacion(13/02/2023)
		GestorPelicula gestorPelicula = new GestorPelicula();
		int idPeli = 8;
		int idCine = 4;
		ArrayList<Date> result = gestorPelicula.getFechasDeUnaPelicula(idPeli, idCine);
		int size = result.size();
		assertEquals(size, 2);

	}
}
