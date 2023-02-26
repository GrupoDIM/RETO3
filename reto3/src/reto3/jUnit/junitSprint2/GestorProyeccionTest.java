package reto3.jUnit.junitSprint2;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.GestorProyeccion;
import reto3.bbdd.pojo.Proyeccion;

class GestorProyeccionTest {
	private GestorProyeccion gestor = null;

	public GestorProyeccionTest() {
		gestor = new GestorProyeccion();
	}

	@Test
	void testPeliculasDeUncine() {
		// se espera un arraylist de tipo proyeccion siz()== 4 cine id= 2
		int idCine = 2;
		ArrayList<Proyeccion> sesiones = gestor.getProyeccionByIdCine(idCine);
		assertEquals(sesiones.size(), 4);

	}

	@Test
	void testOrdenarPeliculas() {
		int idCine = 2;
		ArrayList<Proyeccion> sesiones = gestor.getProyeccionByIdCine(idCine);
		assertEquals(sesiones.size(), 4);
		LocalDateTime fechayHora1 = sesiones.get(0).getDatetime();
		LocalDateTime fechayHora2 = sesiones.get(1).getDatetime();
		LocalDateTime fechayHora3 = sesiones.get(2).getDatetime();
		LocalDateTime fechayHora4 = sesiones.get(3).getDatetime();
		boolean result1 = fechayHora1.isBefore(fechayHora2);
		boolean result2 = fechayHora2.isBefore(fechayHora3);
		boolean result3 = fechayHora3.isBefore(fechayHora4);
		assertEquals(result1, true);
		assertEquals(result2, true);
		assertEquals(result3, true);

	}

	@Test
	void testSesionesDeUnaFechaYPelicula() {
		// se espera un ArrayList de tipo Proyeccion size()==2
		// fecha "2023-02-19" , cine id = 2 , pelicula id = 2

		ArrayList<Proyeccion> sesiones = gestor.getProyeccionByDate(2, LocalDate.of(2023, 02, 19), 2);
		assertEquals(sesiones.size(), 2);
		LocalDateTime fechahora1 = sesiones.get(0).getDatetime();
		LocalDate fecha1 = fechahora1.toLocalDate();
		LocalTime hora1 = fechahora1.toLocalTime();

		LocalDateTime fechahora2 = sesiones.get(1).getDatetime();
		LocalDate fecha2 = fechahora2.toLocalDate();
		LocalTime hora2 = fechahora2.toLocalTime();
		// si las fechas son iguales
		boolean dateIsEqual = fecha1.isEqual(fecha2);
		// sesion1 antes que sesion2
		boolean comparaSesiones = hora1.isBefore(hora2);

		assertTrue(dateIsEqual);
		assertTrue(comparaSesiones);

	}

	@Test
	void PrecioDeUnaPelicula() {
		// se espera un ArrayList de tipo Proyeccion size()==2
		// fecha "2023-02-19" , cine id = 2 , pelicula id = 2
		// sesion1 precio (6€) , sesion2 precio (5.99€)
		ArrayList<Proyeccion> sesiones = gestor.getProyeccionByDate(2, LocalDate.of(2023, 02, 19), 2);
		double precioSesion1 = sesiones.get(0).getPrecio();
		double precioSesion2 = sesiones.get(1).getPrecio();
		assertEquals(precioSesion1, 6);
		assertEquals(precioSesion2, 5.99);
	}

	@Test
	void SalasDeUnaPeliculaYFecha() {
		// se espera un ArrayList de tipo Proyeccion size()==2
		// fecha "2023-02-19" , cine id = 2 , pelicula id = 2
		// sesion1 sala id_2 numero 2 , sesion2 sala id_1 numero 1
		ArrayList<Proyeccion> sesiones = gestor.getProyeccionByDate(2, LocalDate.of(2023, 02, 19), 2);
		String numeroSalaSesion1 = sesiones.get(0).getSala().getNombre();
		int idSalaSesion1 = sesiones.get(0).getSala().getId();
		String numeroSalaSesion2 = sesiones.get(1).getSala().getNombre();
		int idSalaSesion2 = sesiones.get(1).getSala().getId();
		assertEquals(numeroSalaSesion1, "2");
		assertEquals(numeroSalaSesion2, "1");
		assertEquals(idSalaSesion1, 2);
		assertEquals(idSalaSesion2, 1);

	}

}
