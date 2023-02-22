package reto3.bbdd.gestores.junitSprint3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.GestorCliente;
import reto3.bbdd.pojo.Cliente;

class GestorClienteTest {
	private GestorCliente gestor = null;

	public GestorClienteTest() {
		gestor = new GestorCliente();
	}

	@Test
	void testComprobacionLoginIncorrecto() {
// se espera un Objeto de Tipo Cliente Null por que usuario no existe 
		String email = "adrian@gmail.com";
		String pass = "adrian1234";
		Cliente cliente = gestor.getClienteByEmailAndPassword(email, pass);
		assertNull(cliente);
	}

	@Test
	void testComprobacionLoginCorrecto() {
// se espera un Objeto de Tipo Cliente Not  Null id = 1 dni 12345678K 
		String email = "marta@gmail.com";
		String pass = "1234";
		Cliente cliente = gestor.getClienteByEmailAndPassword(email, pass);
		assertNotNull(cliente);
		assertEquals(cliente.getId(), 1);
		assertEquals(cliente.getDni(), "12345678K");
	}

}
