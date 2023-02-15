package reto3.bbdd.pojo.junitPojos;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Entrada;
import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;

class EntradaTest {
	Entrada entrada = null;

	public EntradaTest() {
		entrada = new Entrada();
	}

	@Test
	void testConstructor() {
		assertEquals(entrada.getProyeccion(), null);
		assertEquals(entrada.getFactura(), null);
		assertEquals(entrada.getPrecio(), 0);
		assertEquals(entrada.getCantidad(), 0);

	}

	@Test
	void testGetterSetterProyeccion() throws ParseException {
		Proyeccion proyecc = new Proyeccion();
		proyecc.setId(11);
		proyecc.setPrecio(9.9);
		proyecc.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-14"));
		proyecc.setHora(new SimpleDateFormat("HH:mm").parse("16:04"));
		entrada.setProyeccion(proyecc);
		assertNotNull(entrada.getProyeccion());
		assertEquals(entrada.getProyeccion().getPrecio(), 9.9);

	}

	@Test
	void testGetterSetterFactura() {
		Factura factura = new Factura();
		factura.setCantidad(4);
		factura.setDescuento(0.5);
		factura.setPrecioTotal(122.55);
		entrada.setFactura(factura);
		assertNotNull(entrada.getFactura());

	}

	@Test
	void testGetterSetterPrecio() {
		entrada.setPrecio(12);
		assertEquals(entrada.getPrecio(), 12);

	}

	@Test
	void testGetterSetterCantidad() {
		entrada.setCantidad(3);
		assertEquals(entrada.getCantidad(), 3);

	}

	@Test
	void testGetterSetterToString() throws ParseException {
		Proyeccion proyecc = new Proyeccion();
		proyecc.setId(11);
		proyecc.setPrecio(9.9);
		proyecc.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-14"));
		proyecc.setHora(new SimpleDateFormat("HH:mm").parse("16:04"));
		entrada.setProyeccion(proyecc);
		entrada.setPrecio(12);
		entrada.setCantidad(3);
		String esperado = "Entrada [proyeccion=Proyeccion [id=11, sala=null, pelicula=null, fecha=Tue Feb 14 00:00:00 CET 2023, hora=Thu Jan 01 16:04:00 CET 1970, datetime=null, precio=9.9], factura=null, cantidad=3, precio=12.0]";
		assertEquals(entrada.toString(), esperado);
	}

}
