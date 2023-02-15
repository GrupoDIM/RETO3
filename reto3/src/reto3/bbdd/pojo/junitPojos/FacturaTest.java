package reto3.bbdd.pojo.junitPojos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Cliente;
import reto3.bbdd.pojo.Factura;

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
	void testGetterSetterToString() {
		Cliente cliente = new Cliente();
		cliente.setId(11);
		cliente.setNombre("user");
		cliente.setApellido1("userLastName");
		cliente.setGenero('F');
		factura.setCliente(cliente);
		factura.setId(222);
		factura.setDescuento(0.2);
		factura.setPrecioTotal(122);
		factura.setCantidad(4);
		String esperado = "Factura [id=222, cantidad=4, descuento=0.2, precioTotal=122.0, cliente=Cliente [id=11, dni=null, nombre=user, apellido1=userLastName, apellido2=null, email=null, tele=null, password=null, genero=F, tickets=null]]";
		assertEquals(factura.toString(), esperado);

	}

}
