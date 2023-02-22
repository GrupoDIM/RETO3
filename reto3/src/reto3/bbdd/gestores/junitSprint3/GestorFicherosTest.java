package reto3.bbdd.gestores.junitSprint3;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.Connection;
import reto3.bbdd.gestores.GestorFacturaEntrada;
import reto3.bbdd.gestores.GestorFicheros;
import reto3.bbdd.pojo.Factura;

class GestorFicherosTest {
	private GestorFacturaEntrada gestor = null;
	private Connection con = null;
	private GestorFicheros gestorFichero = null;

	public GestorFicherosTest() {
		gestor = new GestorFacturaEntrada();
		con = new Connection();
		gestorFichero = new GestorFicheros();
	}

	@Test
	void testCreacionCorrectaArchivo() {
		Factura factura = null;
		try {
			con.connect();
			factura = gestor.getFacturaIdBydDateTime(LocalDateTime.of(2023, 02, 22, 15, 21, 46).toString());
			con.disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
			con.disconnect();
		}
		
		
		File file = gestorFichero.writeFile(factura);
		
		
		// comprobamos si el fichero existe
		assertTrue(file.exists());
		// comprobamos si el fichero no esta vacio
		assertTrue(file.length() != 0);

	}

}
