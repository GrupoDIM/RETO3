package reto3.jUnit.junitPojos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Cliente;
import reto3.bbdd.pojo.Entrada;
import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;

class FacturaTest {
	private Factura factura = null;

	public FacturaTest() {
		factura = new Factura();
	}

	@Test
	void testConstructor() {
		assertEquals(factura.getId(), 0);
		assertEquals(factura.getDescuento(), 0);
		assertEquals(factura.getPrecioTotal(), 0);
		assertEquals(factura.getCantidad(), 0);
		assertEquals(factura.getCliente(), null);
		assertEquals(factura.getEntradas(), null);
	}

	@Test
	void testGetterSetterId() {
		factura.setId(222);
		assertEquals(factura.getId(), 222);

	}

	@Test
	void testGetterSetterDescuento() {
		factura.setDescuento(0.2);
		assertEquals(factura.getDescuento(), 0.2);

	}

	@Test
	void testGetterSetterPrecioTotal() {
		factura.setPrecioTotal(122);
		assertEquals(factura.getPrecioTotal(), 122);

	}

	@Test
	void testGetterSetterCantidad() {
		factura.setCantidad(4);
		assertEquals(factura.getCantidad(), 4);

	}

	@Test
	void testGetterSetterCliente() {
		Cliente cliente = new Cliente();
		cliente.setId(11);
		cliente.setNombre("user");
		cliente.setApellido1("userLastName");
		cliente.setGenero('F');
		factura.setCliente(cliente);
		assertNotNull(factura.getCliente());
		assertEquals(factura.getCliente().getId(), 11);

	}

	@Test
	void testGetterSetterEntradas() throws ParseException {
		Proyeccion proyecc = new Proyeccion();
		proyecc.setId(11);
		proyecc.setPrecio(9.9);
		proyecc.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-14"));
		proyecc.setHora(new SimpleDateFormat("HH:mm").parse("16:04"));
		Entrada entrada = new Entrada();
		Entrada entrada2 = new Entrada();
		entrada.setProyeccion(proyecc);
		entrada2.setProyeccion(proyecc);
		entrada.setPrecio(12);
		entrada.setCantidad(3);
		entrada2.setPrecio(6.6);
		entrada2.setCantidad(2);
		ArrayList<Entrada> entradas = new ArrayList<Entrada>();
		entradas.add(entrada);
		entradas.add(entrada2);
		factura.setEntradas(entradas);
		assertNotNull(factura.getEntradas());
		assertEquals(factura.getEntradas().get(0).getPrecio(), 12);

	}

	@Test
	void testGetterSetterToString() throws ParseException {
		Cliente cliente = new Cliente();
		cliente.setId(11);
		cliente.setNombre("user");
		cliente.setApellido1("userLastName");
		cliente.setGenero('F');
		Proyeccion proyecc = new Proyeccion();
		proyecc.setId(11);
		proyecc.setPrecio(9.9);
		proyecc.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-14"));
		proyecc.setHora(new SimpleDateFormat("HH:mm").parse("16:04"));
		Entrada entrada = new Entrada();
		Entrada entrada2 = new Entrada();
		entrada.setProyeccion(proyecc);
		entrada2.setProyeccion(proyecc);
		entrada.setPrecio(12);
		entrada.setCantidad(3);
		entrada2.setPrecio(6.6);
		entrada2.setCantidad(2);
		ArrayList<Entrada> entradas = new ArrayList<Entrada>();
		entradas.add(entrada);
		entradas.add(entrada2);
		factura.setEntradas(entradas);
		factura.setCliente(cliente);
		factura.setId(222);
		factura.setDescuento(0.2);
		factura.setPrecioTotal(122);
		factura.setCantidad(4);
		String esperado = "Factura [id=222, cantidad=4, descuento=0.2, precioTotal=122.0, fechaHora=null, cliente=Cliente [id=11, dni=null, nombre=user, apellido1=userLastName, apellido2=null, email=null, tele=null, password=null, genero=F, tickets=null], entradas=[Entrada [proyeccion=Proyeccion [id=11, fecha=Tue Feb 14 00:00:00 CET 2023, hora=Thu Jan 01 16:04:00 CET 1970, datetime=null, precio=9.9, sala=null, entradas=null, pelicula=null], factura=null, cantidad=3, precio=12.0], Entrada [proyeccion=Proyeccion [id=11, fecha=Tue Feb 14 00:00:00 CET 2023, hora=Thu Jan 01 16:04:00 CET 1970, datetime=null, precio=9.9, sala=null, entradas=null, pelicula=null], factura=null, cantidad=2, precio=6.6]]]";
		assertEquals(factura.toString(), esperado);

	}

}
