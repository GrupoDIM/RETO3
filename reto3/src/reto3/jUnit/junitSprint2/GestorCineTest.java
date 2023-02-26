package reto3.jUnit.junitSprint2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.GestorCine;
import reto3.bbdd.pojo.Cine;

class GestorCineTest {
	GestorCine gestor = null;

	public GestorCineTest() {
		gestor = new GestorCine();
	}

	@Test
	void testCinesDisponibles() {
		// se espera un arrayList de tipo cine size()==3
		ArrayList<Cine> cines = gestor.getCines();
		assertEquals(cines.size(), 3);
	}

}
