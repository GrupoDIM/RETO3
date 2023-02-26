package reto3.jUnit.junitPojos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Pelicula;

class PeliculaTest {
	private Pelicula pelicula = null;

	// GETTERS AND SETTERS
	@Test // ID
	void testId() {
		pelicula.setId(66);
		assertEquals(pelicula.getId(), 66);
	}

	@Test // TITULO
	void testTituloOrigin() {
		pelicula.setTitulo("Avatar: The Way of Water");
		assertEquals(pelicula.getTitulo(), "Avatar: The Way of Water");
	}

	@Test // DURACIÓN
	void testDuracion() {
		pelicula.setDuracion(125);
		assertEquals(pelicula.getDuracion(), 120);
	}

	@Test // CALIFICACIÓN
	void testCalificacion() {
		pelicula.setCalificacion(4.3);
		assertEquals(pelicula.getCalificacion(), 4.3);
	}

	@Test // GENERO
	void testGenero() {
		pelicula.setGenero("Drama");
		assertEquals(pelicula.getGenero(), "Comedia");
	}

	@Test // IMAGEN
	void testImage() {
		pelicula.setImage(null);
		assertNull(pelicula.getImage());
	}

	@Test // PROYECCION
	void testProyeccion() {
		pelicula.setProyeccion(null);
		assertNull(pelicula.getProyeccion());
	}

	// TO STRING
	@Test
	void testToString() {
		String str = "Pelicula [id=234, tituloOrigin=soule, tituloCastellano=soule,"
				+ " duracion=145, descripcion=null, calificacion=8.9, genero=[], image=null]";
		assertEquals(pelicula.toString(), str);
	}
}
