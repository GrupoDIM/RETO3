package reto3.jUnit.junitPojos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Cliente;
import reto3.bbdd.pojo.Factura;

class ClienteTest {
	private Cliente cliente = null;

	public ClienteTest() {
		cliente = new Cliente();
	}

	@Test
	void testConstructor() {
		assertEquals(cliente.getId(), 0);
		assertEquals(cliente.getNombre(), null);
		assertEquals(cliente.getApellido1(), null);
		assertEquals(cliente.getApellido2(), null);
		assertEquals(cliente.getDni(), null);
		assertEquals(cliente.getGenero(), 0);
		assertEquals(cliente.getEmail(), null);
		assertEquals(cliente.getTele(), null);
		assertEquals(cliente.getPassword(), null);
		assertEquals(cliente.getTickets(), null);

	}

	@Test
	void testGetterSetterId() {
		cliente.setId(12);
		assertEquals(cliente.getId(), 12);

	}

	@Test
	void testGetterSetterNombre() {
		cliente.setNombre("user");
		assertEquals(cliente.getNombre(), "user");

	}

	@Test
	void testGetterSetterApellido1() {
		cliente.setApellido1("lastname1");
		assertEquals(cliente.getApellido1(), "lastname1");

	}

	@Test
	void testGetterSetterApellido2() {
		cliente.setApellido2("lastname2");
		assertEquals(cliente.getApellido2(), "lastname2");

	}

	@Test
	void testGetterSetterDni() {
		cliente.setDni("87654321k");
		assertEquals(cliente.getDni(), "87654321k");

	}

	@Test
	void testGetterSetterGenero() {
		cliente.setGenero('F');
		assertEquals(cliente.getGenero(), 'F');

	}

	@Test
	void testGetterSettereMAIL() {
		cliente.setEmail("user@gmail.com");
		assertEquals(cliente.getEmail(), "user@gmail.com");

	}

	@Test
	void testGetterSetterTele() {
		cliente.setTele("23456789");
		assertEquals(cliente.getTele(), "23456789");

	}

	@Test
	void testGetterSetterTickets() {
		Factura factura = new Factura();
		factura.setId(222);
		factura.setDescuento(0.2);
		factura.setPrecioTotal(122);
		factura.setCantidad(4);
		cliente.setTickets(new ArrayList<Factura>());
		cliente.getTickets().add(factura);
		assertNotNull(cliente.getTickets());

	}

	@Test
	void testGetterSetterToString() {
		Factura factura = new Factura();
		factura.setId(222);
		factura.setDescuento(0.2);
		factura.setPrecioTotal(122);
		factura.setCantidad(4);
		cliente.setTickets(new ArrayList<Factura>());
		cliente.getTickets().add(factura);
		cliente.setId(12);
		cliente.setNombre("user");
		cliente.setApellido1("lastname1");
		cliente.setApellido2("lastname2");
		cliente.setDni("87654321k");
		cliente.setGenero('F');
		cliente.setEmail("user@gmail.com");
		cliente.setTele("23456789");
		String esperado = "Cliente [id=12, dni=87654321k, nombre=user, apellido1=lastname1, apellido2=lastname2, email=user@gmail.com, tele=23456789, password=null, genero=F, tickets=[Factura [id=222, cantidad=4, descuento=0.2, precioTotal=122.0, cliente=null]]]";
		assertEquals(cliente.toString(), esperado);

	}

}
