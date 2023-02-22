package reto3.bbdd.gestores.junitSprint3;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.Connection;
import reto3.bbdd.gestores.GestorFacturaEntrada;
import reto3.bbdd.pojo.Entrada;
import reto3.controlador.Cart.Carrito;

class CarritoTest {
	private GestorFacturaEntrada gestor = null;
	private Connection con = null;

	public CarritoTest() {
		gestor = new GestorFacturaEntrada();
		con = new Connection();
	}

	@Test
	void testReseteo() {
		ArrayList<Entrada> entradas = null;
		try {
			con.connect();
			entradas = gestor.getEntradasByIdFactura(10);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		// el carrito de la compra e que se pasa por todas las ventanas
		Carrito carrito = new Carrito();
		carrito.setCompras(entradas);
		assertTrue(carrito.size() == 2);

		// vaciamos el carrito
		carrito.clear();

		assertTrue(carrito.size() == 0);

	}

}
