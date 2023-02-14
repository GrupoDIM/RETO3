package reto3.bbdd.gestores.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import reto3.bbdd.gestores.Connection;

class ConnectionTest {
	private Connection con = new Connection();

	@Test
	void testContructor() {

		assertEquals(con.getHostname(), "localhost");
		assertEquals(con.getPort(), "3306");
		assertEquals(con.getPassword(), "");
		assertEquals(con.getDatabase(), "reto");
	}

	@Test
	void testIsConnected() {
		con.connect();
		boolean result = con.isConnected();
		assertTrue(result);
		con.disconnect();

	}

}
