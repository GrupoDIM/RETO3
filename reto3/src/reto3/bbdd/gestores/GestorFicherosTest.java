package reto3.bbdd.gestores;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Cliente;
import reto3.bbdd.pojo.Entrada;
import reto3.bbdd.pojo.Pelicula;
import reto3.bbdd.pojo.Proyeccion;
import reto3.bbdd.pojo.Sala;
import reto3.controlador.Cart.Carrito;

class GestorFicherosTest {

	private GestorFicheros gestor = null;
	private Connection con = null;
	private GestorProyeccion gestorProyeccion = null;

	public GestorFicherosTest() {
		gestor = new GestorFicheros();
		con = new Connection();
		gestorProyeccion = new GestorProyeccion();
	}

	@Test
	void testCreacionDelFichero() throws SQLException {
		Carrito cart = new Carrito();
		Cliente cliente = new GestorCliente().getClienteByEmailAndPassword("madiha@gmail.com", "madiha123");
		Proyeccion proyeccion = gestorProyeccion.getProyeccionById(7);
		Entrada entrada = new Entrada();
		
		
		

	}

}
