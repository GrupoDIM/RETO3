package reto3.bbdd.gestores.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.Connection;
import reto3.bbdd.gestores.GestorProyeccion;
import reto3.bbdd.pojo.Cine;
import reto3.bbdd.pojo.Pelicula;
import reto3.bbdd.pojo.Proyeccion;
import reto3.bbdd.pojo.Sala;

class GestorProyeccionTest {
	/**
	 * FECHA DE REALIZACION DE LAS PRUEBAS JUNITS 13-02-2023
	 */
	private GestorProyeccion gestorProyeccion = new GestorProyeccion();
	private static Connection con = new Connection();

	@Test
	void testGetProyeccionByIdCine() {
		// se espera un arrayList de tipo proyeccion size() == 3
		int idCine = 2;
		ArrayList<Proyeccion> result = gestorProyeccion.getProyeccionByIdCine(idCine);
		int size = result.size();
		assertEquals(size, 3);
	}

	@Test
	void testGetSalaByID() {
		// se espera un Objeto de tipo Sala Not Null y con datos(id= 1 , nombre = 1 ,
		// disponibilidad = true , Cine = [id = 2 ... ] ,
		int idSala = 1;
		Sala sala = null;
		try {
			if (!con.isConnected()) {
				con.connect();
			}
			sala = gestorProyeccion.getSalaByID(idSala);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertEquals(sala.getCine().getId(), 2);
		assertNotNull(sala.getCine());

	}

	@Test
	void testGetCineByIdSala() {
		// se espera un Objeto de tipo Cine Not Null
		int idSala = 1;
		Cine cine = null;
		try {
			if (!con.isConnected()) {
				con.connect();
			}
			cine = gestorProyeccion.getCineByIdSala(idSala);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertEquals(cine.getId(), 2);
		assertNotNull(cine);

	}

	@Test
	void testGetPeliculaByID() {
		// se espera un Objeto de tipo Pelicula Not Null con los datos( tituloOrigin
		// ="Avatar: The Way of Water" , tituloCastellano= El sentido del agua , ... ,
		// ArrayList de tipo genero siz()==1)
		int idPelicula = 1;
		Pelicula pelicula = null;
		try {
			if (!con.isConnected()) {
				con.connect();
			}
			pelicula = gestorProyeccion.getPeliculaByID(idPelicula);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertNotNull(pelicula);

	}

	@Test
	void testGetImageByIdPelicula() {
		// se espera un Objeto de tipo File NOT NULL con el nombre "encanto.png"
		int idPelicula = 8;
		File file = null;
		try {
			if (!con.isConnected()) {
				con.connect();
			}
			file = gestorProyeccion.getImageByIdPelicula(idPelicula, "Encanto");
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertNotNull(file);
		assertEquals(file, new File("encanto.png"));

	}

	@Test
	void testGetProyeccionByDate() {
		// se espera un ArrayList de tipo proyeccion size() == 3
		ArrayList<Proyeccion> result = null;
		int idPelicula = 8;
		int idCine = 4;
		LocalDate fecha = LocalDate.of(2023, 02, 20);
		result = gestorProyeccion.getProyeccionByDate(idPelicula, fecha, idCine);
		assertNotNull(result);
		assertEquals(result.size(), 3);

	}
}
