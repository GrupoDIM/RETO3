package reto3.bbdd.pojo.junitPojos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Pelicula;
import reto3.bbdd.pojo.Proyeccion;

class PeliculaTest {
	private Pelicula pelicula = null;

	public PeliculaTest() {
		pelicula = new Pelicula();
	}

	@Test
	void testConstructor() {
		assertEquals(pelicula.getId(), 0);
		assertEquals(pelicula.getTitulo(), null);
		assertEquals(pelicula.getDuracion(), 0);
		assertEquals(pelicula.getCalificacion(), 0);
		assertEquals(pelicula.getImage(), null);
		assertEquals(pelicula.getGenero(), null);
		assertEquals(pelicula.getProyeccion(), null);

	}

	@Test
	void testGetterSetterId() {
		pelicula.setId(11);
		assertEquals(pelicula.getId(), 11);

	}

	@Test
	void testGetterSetterTitulo() {
		pelicula.setTitulo("avatar");
		assertEquals(pelicula.getTitulo(), "avatar");

	}

	@Test
	void testGetterSetterDuracion() {
		pelicula.setDuracion(111);

		assertEquals(pelicula.getDuracion(), 111);

	}

	@Test
	void testGetterSetterCalificacion() {
		pelicula.setCalificacion(5.5);
		assertEquals(pelicula.getCalificacion(), 5.5);

	}

	@Test
	void testGetterSetterImage() {
		pelicula.setImage(new File("avatar.png"));
		assertEquals(pelicula.getImage(), new File("avatar.png"));

	}

	@Test
	void testGetterSetterGenero() {
		pelicula.setGenero("Drama");
		assertEquals(pelicula.getGenero(), "Drama");

	}

	@Test
	void testGetterSetterProyeccion() {
		Proyeccion proyecc = new Proyeccion();
		proyecc.setId(11);
		proyecc.setPrecio(9.9);
		pelicula.setProyeccion(proyecc);
		assertNotNull(pelicula.getProyeccion());

	}

	@Test
	void testGetterSetterToString() {
		Proyeccion proyecc = new Proyeccion();
		proyecc.setId(11);
		proyecc.setPrecio(9.9);
		pelicula.setProyeccion(proyecc);
		pelicula.setId(11);
		pelicula.setTitulo("avatar");
		pelicula.setDuracion(111);
		pelicula.setCalificacion(5.5);
		pelicula.setImage(new File("avatar.png"));
		pelicula.setGenero("Drama");
		String esperado = "Pelicula [id=11, titulo=avatar, duracion=111, calificacion=5.5, image=avatar.png, genero=Drama, proyeccion=Proyeccion [id=11, sala=null, pelicula=null, fecha=null, hora=null, datetime=null, precio=9.9]] ";
		assertEquals(pelicula.toString(), esperado.trim());
	}

}
