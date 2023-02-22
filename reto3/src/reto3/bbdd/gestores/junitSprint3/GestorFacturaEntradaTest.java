package reto3.bbdd.gestores.junitSprint3;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.Connection;
import reto3.bbdd.gestores.GestorCliente;
import reto3.bbdd.gestores.GestorFacturaEntrada;
import reto3.bbdd.gestores.GestorProyeccion;
import reto3.bbdd.pojo.Cliente;
import reto3.bbdd.pojo.Entrada;
import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;

class GestorFacturaEntradaTest {

	private GestorFacturaEntrada gestor = null;
	private Connection con = null;
	private GestorProyeccion gestorProyeccion = null;
	private GestorCliente gestorCliente = null;

	public GestorFacturaEntradaTest() {
		gestor = new GestorFacturaEntrada();
		con = new Connection();
		gestorProyeccion = new GestorProyeccion();
		gestorCliente = new GestorCliente();
	}

	@Test
	void testGuardadoCorrecto() {
		Carrito carrito = new Carrito();
		Proyeccion sesion1 = gestorProyeccion.getProyeccionById(11);

		// entrada1 sesion1

		Entrada entrada = new Entrada();
		entrada.setProyeccion(sesion1);
		entrada.setCantidad(1);
		entrada.setPrecio(sesion1.getPrecio() * entrada.getCantidad());

		// factura
		Factura factura = new Factura();

		Cliente cliente = gestorCliente.getClienteById(1);
		factura.setCliente(cliente);
		factura.setCantidad(1);
		factura.setDescuento(0);
		carrito.addEntrada(entrada);
		String precioTotal = new Gestor().calculateTotalPrice(carrito);
		factura.setPrecioTotal(Double.parseDouble(precioTotal.replace(",", ".")));

		entrada.setFactura(factura);
		// fecha y hora a la que se guarda la factura
		String dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());

		// insertamos factura en la base de datos

		gestor.insertFactura(carrito, dateTime);

		// ahora comprobamos si se ha guardado correctamente y la buscamos por
		// fechaHora (datetime)
		factura.setFechaHora(LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		Factura result = null;
		try {
			con.connect();
			result = gestor.getFacturaIdBydDateTime(dateTime);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}

		assertEquals(result.getCliente(), cliente);
		assertEquals(result.getDescuento(), factura.getDescuento(), "se esperaba descuento 0");
		assertEquals(result.getFechaHora(), factura.getFechaHora());
		assertEquals(result.getPrecioTotal(), factura.getPrecioTotal(), "8.0");
		assertEquals(result.getEntradas().size(), carrito.size());

	}

}
