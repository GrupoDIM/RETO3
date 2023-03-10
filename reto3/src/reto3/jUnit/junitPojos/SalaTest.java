package reto3.jUnit.junitPojos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Cine;
import reto3.bbdd.pojo.Sala;

class SalaTest {
	private Sala sala = null;

	public SalaTest() {
		sala = new Sala();
	}

	// CONSTRUCTOR // 
	@Test
	void testConsructor() {

		assertEquals(sala.getId(), 0);
		assertEquals(sala.getNombre(), null);
		assertEquals(sala.getCine(), null);

	}

	// ID | GET AND SET //
	@Test
	void testGetterSetterId() {
		sala.setId(22);
		assertEquals(sala.getId(), 22);

	}

	// NOMBRE | GET AND SET //
	@Test
	void testGetterSetterNombre() {
		sala.setNombre("blue");
		assertEquals(sala.getNombre(), "blue");

	}

	// CINE | GET AND SET //
	@Test
	void testGetterSetterCine() {
		Cine cine = new Cine();
		cine.setId(11);
		cine.setNombre("zubiarte");
		cine.setDireccion("direccion123");
		cine.setTele("23456789");
		cine.setCodPostal("48012");
		cine.setMail("zubiarte@gmail.com");
		cine.setCiudad("bilbao");
		cine.setProvincia("bizkaia");
		sala.setCine(cine);
		assertNotNull(sala.getCine());

	}

	// PROYECCION | GET AND SET //
	@Test
	void testProyeccion() {
		sala.setProyecciones(null);
		assertNull(sala.getProyecciones());
	}
	
	// TO STRING //
	@Test
	void testToString() {
		Cine cine = new Cine();
		cine.setId(11);
		cine.setNombre("zubiarte");
		cine.setDireccion("direccion123");
		cine.setTele("23456789");
		cine.setCodPostal("48012");
		cine.setMail("zubiarte@gmail.com");
		cine.setCiudad("bilbao");
		cine.setProvincia("bizkaia");
		sala.setCine(cine);
		sala.setId(22);
		sala.setNombre("blue");
		String esperado = "Sala [id=22, nombre=blue, cine=Cine [id=11, nombre=zubiarte, direccion=direccion123, tele=23456789, mail=zubiarte@gmail.com, codPostal=48012, ciudad=bilbao, provincia=bizkaia, salas=null]]";
		assertEquals(sala.toString(), esperado);
	}

}
