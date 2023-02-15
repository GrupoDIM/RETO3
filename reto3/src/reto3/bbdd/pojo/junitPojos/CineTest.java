package reto3.bbdd.pojo.junitPojos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Cine;
import reto3.bbdd.pojo.Sala;

class CineTest {
	private Cine cine = null;

	public CineTest() {
		cine = new Cine();
	}

	@Test
	void testConstructor() {
		assertEquals(cine.getId(), 0);
		assertEquals(cine.getNombre(), null);
		assertEquals(cine.getDireccion(), null);
		assertEquals(cine.getTele(), null);
		assertEquals(cine.getMail(), null);
		assertEquals(cine.getCodPostal(), null);
		assertEquals(cine.getCiudad(), null);
		assertEquals(cine.getProvincia(), null);
		assertEquals(cine.getSalas(), null);
	}

	@Test
	void testGetterSetterId() {
		cine.setId(11);
		assertEquals(cine.getId(), 11);

	}

	@Test
	void testGetterSetterNombre() {
		cine.setNombre("zubiarte");
		assertEquals(cine.getNombre(), "zubiarte");

	}

	@Test
	void testGetterSetterDireccion() {
		cine.setDireccion("direccion123");
		assertEquals(cine.getDireccion(), "direccion123");

	}

	@Test
	void testGetterSetterTele() {
		cine.setTele("23456789");

		assertEquals(cine.getTele(), "23456789");

	}

	@Test
	void testGetterSetterMail() {
		cine.setMail("zubiarte@gmail.com");

		assertEquals(cine.getMail(), "zubiarte@gmail.com");

	}

	@Test
	void testGetterSetterCodPostal() {
		cine.setCodPostal("48012");
		assertEquals(cine.getCodPostal(), "48012");

	}

	@Test
	void testGetterSetterCiudad() {
		cine.setCiudad("bilbao");
		assertEquals(cine.getCiudad(), "bilbao");

	}

	@Test
	void testGetterSetterProvincia() {
		cine.setProvincia("bizkaia");
		assertEquals(cine.getProvincia(), "bizkaia");

	}

	@Test
	void testGetterSetterSalas() {
		Sala sala = new Sala();
		sala.setId(1);
		sala.setNombre("12");
		sala.setCine(null);
		cine.setSalas(new ArrayList<Sala>());
		cine.getSalas().add(sala);
		assertNotNull(cine.getSalas().add(sala));

	}

	@Test
	void testToString() {
		Sala sala = new Sala();
		sala.setId(1);
		sala.setNombre("12");
		sala.setCine(null);
		cine.setSalas(new ArrayList<Sala>());
		cine.getSalas().add(sala);
		assertNotNull(cine.getSalas().add(sala));
		cine.setId(11);
		cine.setNombre("zubiarte");
		cine.setDireccion("direccion123");
		cine.setTele("23456789");
		cine.setCodPostal("48012");
		cine.setMail("zubiarte@gmail.com");
		cine.setCiudad("bilbao");
		cine.setProvincia("bizkaia");
		String esperado = "Cine [id=11, nombre=zubiarte, direccion=direccion123, tele=23456789, mail=zubiarte@gmail.com, codPostal=48012, ciudad=bilbao, provincia=bizkaia, salas=[Sala [id=1, nombre=12, cine=null], Sala [id=1, nombre=12, cine=null]]]";
		assertEquals(cine.toString(), esperado);

	}

}
