package reto3.controlador;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Asiento;
import reto3.bbdd.pojo.Cine;
import reto3.bbdd.pojo.Genero;
import reto3.bbdd.pojo.Pelicula;
import reto3.bbdd.pojo.Proyeccion;
import reto3.bbdd.pojo.Sala;

class ConnectionTest {
	Connection con = new Connection();

	@Test
	void testConstructor() {
		Connection con = new Connection();
		assertEquals(con.getHostname(), "localhost");
		assertEquals(con.getPort(), "3306");
		assertEquals(con.getPassword(), "");
		assertEquals(con.getDatabase(), "reto");
	}

	@Test
	void testGetFechasDeUnaPelicula() {
		// se espera un arraylist.size() == 2
		int idPeli = 8;
		int idCine = 4;
		ArrayList<Date> result = con.getFechasDeUnaPelicula(idPeli, idCine);
		int size = result.size();
		assertEquals(size, 2);

	}

	@Test
	void testGetProyeccionByIdCine() {
		// se espera un arrayList<Proyrccion>().size() == 3
		int idCine = 2;
		ArrayList<Proyeccion> result = con.getProyeccionByIdCine(idCine);
		int size = result.size();
		assertEquals(size, 3);

	}

	@Test
	void testGetSalaByID() {
		// se espera un Objeto de tipo Sala Not Null y con datos(id= 1 , nombre = 1 ,
		// disponibilidad = true , Cine = [id = 2 ... ] , ArrayList<Asiento>().size() ==
		// 39
		int idSala = 1;
		Sala sala = null;
		try {
			con.connect();
			sala = con.getSalaByID(idSala);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertEquals(sala.getCine().getId(), 2);
		assertNotNull(sala.getCine());
		assertEquals(sala.getAsientos().size(), 39);
		assertTrue(sala.isDisponible());

	}

	@Test
	void testGetCineByIdSala() {
		// se espera un Objeto de tipo Cine Not Null
		int idSala = 1;
		Cine cine = null;
		try {
			con.connect();
			cine = con.getCineByIdSala(idSala);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertEquals(cine.getId(), 2);
		assertNotNull(cine);

	}

	@Test
	void testGetAsientosByIdSala() {
		// se espera un ArrayList de tipo Asiento Not Null , size() == 39
		int idSala = 1;
		ArrayList<Asiento> result = null;
		try {
			con.connect();
			result = con.getAsientosByIdSala(idSala);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertNotNull(result);
		assertEquals(result.size(), 39);

	}

	@Test
	void testGetPeliculaByID() {
		// se espera un Objeto de tipo Pelicula Not Null con los datos( tituloOrigin
		// ="Avatar: The Way of Water" , tituloCastellano= El sentido del agua , ... ,
		// ArrayList<Genero>().siz()==1)
		int idPelicula = 1;
		Pelicula pelicula = null;
		try {
			con.connect();
			pelicula = con.getPeliculaByID(idPelicula);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertNotNull(pelicula);
		assertEquals(pelicula.getGenero().size(), 1);

	}

	@Test
	void testGetGeneroByIdPelicula() {
		// se espera un ArrayList<Genero>().siz()==1 NOT NULL de tipo Genero
		int idPelicula = 1;
		ArrayList<Genero> generos = null;
		try {
			con.connect();
			generos = con.getGeneroByIdPelicula(idPelicula);
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertNotNull(generos);
		assertEquals(generos.size(), 1);

	}

	@Test
	void testGetImageByIdPelicula() {
		// se espera un Objeto de tipo File NOT NULL con el nombre "encanto.png"
		int idPelicula = 8;
		File file = null;
		try {
			con.connect();
			file = con.getImageByIdPelicula(idPelicula, "Encanto");
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
		// se espera un ArrayList<Proyeccion>() de tipo Proyeccion NOT NULL
		int idPelicula = 8;
		File file = null;
		try {
			con.connect();
			file = con.getImageByIdPelicula(idPelicula, "Encanto");
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		assertNotNull(file);
		assertEquals(file, new File("encanto.png"));

	}

}
