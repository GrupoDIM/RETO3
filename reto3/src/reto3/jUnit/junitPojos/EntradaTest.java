package reto3.jUnit.junitPojos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		factura.setId(122);
		factura.setCantidad(4);
		factura.setDescuento(0.5);
		factura.setPrecioTotal(122.55);
		entrada.setFactura(factura);
		assertNotNull(entrada.getFactura());
		assertEquals(entrada.getFactura().getId(), 122);

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
		Factura factura = new Factura();
		factura.setId(122);
		factura.setCantidad(4);
		factura.setDescuento(0.5);
		factura.setPrecioTotal(122.55);
		entrada.setProyeccion(proyecc);
		entrada.setFactura(factura);
		entrada.setPrecio(12);
		entrada.setCantidad(3);
		String esperado = "Entrada [proyeccion=Proyeccion [id=11, fecha=Tue Feb 14 00:00:00 CET 2023, hora=Thu Jan 01 16:04:00 CET 1970, datetime=null, precio=9.9, sala=null, entradas=null, pelicula=null], factura=Factura [id=122, cantidad=4, descuento=0.5, precioTotal=122.55, fechaHora=null, cliente=null, entradas=null], cantidad=3, precio=12.0]";
		assertEquals(entrada.toString(), esperado);
	}

}
