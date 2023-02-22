package reto3.bbdd.gestores.junitSprint3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Entrada;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;

class GestorTest {
	private Gestor gestor = null;

	public GestorTest() {
		gestor = new Gestor();
	}

	@Test
	void testCalculoResumen() {

		Carrito cart = new Carrito();

		// entrada 1

		Entrada entrada1 = new Entrada();
		Proyeccion proyecc = new Proyeccion();
		proyecc.setPrecio(9.99);
		entrada1.setProyeccion(proyecc);
		entrada1.setCantidad(1);
		entrada1.setPrecio((entrada1.getProyeccion().getPrecio() * entrada1.getCantidad()));

		// entrada 2

		Entrada entrada2 = new Entrada();
		Proyeccion proyecc2 = new Proyeccion();
		proyecc2.setPrecio(6.50);
		entrada2.setCantidad(2);
		entrada2.setProyeccion(proyecc2);
		entrada2.setPrecio((entrada2.getProyeccion().getPrecio() * entrada2.getCantidad()));
		cart.addEntrada(entrada1);
		cart.addEntrada(entrada2);

		// calculo resumen
		double precioBase = gestor.calculatPriceBase(cart);
		assertEquals(precioBase, 22.990000000000002);

	}

	@Test
	void testCalculoDescuentos() {

		Carrito cart = new Carrito();

		// entrada 1

		Entrada entrada1 = new Entrada();
		Proyeccion proyecc = new Proyeccion();
		proyecc.setPrecio(9.99);
		entrada1.setProyeccion(proyecc);
		entrada1.setCantidad(1);
		entrada1.setPrecio((entrada1.getProyeccion().getPrecio() * entrada1.getCantidad()));

		// entrada 2

		Entrada entrada2 = new Entrada();
		Proyeccion proyecc2 = new Proyeccion();
		proyecc2.setPrecio(6.50);
		entrada2.setCantidad(2);
		entrada2.setProyeccion(proyecc2);
		entrada2.setPrecio((entrada2.getProyeccion().getPrecio() * entrada2.getCantidad()));
		cart.addEntrada(entrada1);
		cart.addEntrada(entrada2);

		// calculo Descuento
		double precioTotal = Double.parseDouble(gestor.calculateTotalPrice(cart).replace(",", "."));
		assertEquals(precioTotal, 16.09);

	}

}
