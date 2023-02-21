package reto3.bbdd.pojo.junitPojos;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Cine;
import reto3.bbdd.pojo.Entrada;
import reto3.bbdd.pojo.Pelicula;
import reto3.bbdd.pojo.Proyeccion;
import reto3.bbdd.pojo.Sala;

class ProyeccionTest {
	private Proyeccion proyeccion = null;

	public ProyeccionTest() {
		proyeccion = new Proyeccion();
	}

	@Test
	void testConstructor() {
		assertEquals(proyeccion.getId(), 0);
		assertEquals(proyeccion.getDatetime(), null);
		assertEquals(proyeccion.getHora(), null);
		assertEquals(proyeccion.getFecha(), null);
		assertEquals(proyeccion.getPrecio(), 0);
		assertEquals(proyeccion.getSala(), null);
		assertEquals(proyeccion.getPelicula(), null);
		assertEquals(proyeccion.getEntradas(), null);

	}

	@Test
	void testGetterSetterId() throws ParseException {
		proyeccion.setId(11);
		assertEquals(proyeccion.getId(), 11);
	}

	@Test
	void testGetterSetterFecha() throws ParseException {
		proyeccion.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-14"));
		Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-14");
		assertEquals(proyeccion.getFecha(), fecha);
	}

	@Test
	void testGetterSetterHora() throws ParseException {
		proyeccion.setHora(new SimpleDateFormat("HH:mm").parse("14:02"));
		Date hora = new SimpleDateFormat("HH:mm").parse("14:02");
		assertEquals(proyeccion.getHora(), hora);
	}

	@Test
	void testGetterSetterDateTime() throws ParseException {
		proyeccion.setDatetime(LocalDateTime.of(2023, 02, 15, 16, 30));
		assertEquals(proyeccion.getDatetime(), LocalDateTime.of(2023, 02, 15, 16, 30));
	}

	@Test
	void testGetterSetterSala() {
		Sala sala = new Sala();
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
		proyeccion.setSala(sala);
		assertNotNull(proyeccion.getSala());
		assertEquals(proyeccion.getSala().getId(), 22);

	}

	@Test
	void testGetterSetterPelicula() {
		Pelicula pelicula = new Pelicula();
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
		proyeccion.setPelicula(pelicula);
		assertNotNull(proyeccion.getPelicula());
		assertEquals(proyeccion.getPelicula().getId(), 11);
	}

	@Test
	void testGetterSetterEntradas() throws ParseException {
		Entrada entrada = new Entrada();
		Entrada entrada2 = new Entrada();
		entrada.setPrecio(12);
		entrada.setCantidad(3);
		entrada2.setPrecio(6.6);
		entrada2.setCantidad(2);
		ArrayList<Entrada> entradas = new ArrayList<Entrada>();
		entradas.add(entrada);
		entradas.add(entrada2);
		proyeccion.setEntradas(entradas);

		assertNotNull(proyeccion.getEntradas());
		assertEquals(proyeccion.getEntradas().get(0).getCantidad(), 3);
		assertEquals(proyeccion.getEntradas().get(1).getPrecio(), 6.6);

	}

	@Test
	void testGetterSetterToString() throws ParseException {
		Pelicula pelicula = new Pelicula();

		pelicula.setId(11);
		pelicula.setTitulo("avatar");
		pelicula.setDuracion(111);
		pelicula.setCalificacion(5.5);
		pelicula.setImage(new File("avatar.png"));
		pelicula.setGenero("Drama");
		proyeccion.setPelicula(pelicula);
		Sala sala = new Sala();
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
		proyeccion.setId(11);
		proyeccion.setSala(sala);
		Entrada entrada = new Entrada();
		Entrada entrada2 = new Entrada();
		entrada.setPrecio(12);
		entrada.setCantidad(3);
		entrada2.setPrecio(6.6);
		entrada2.setCantidad(2);
		ArrayList<Entrada> entradas = new ArrayList<Entrada>();
		entradas.add(entrada);
		entradas.add(entrada2);
		proyeccion.setEntradas(entradas);
		proyeccion.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-14"));
		proyeccion.setHora(new SimpleDateFormat("HH:mm").parse("14:02"));
		proyeccion.setDatetime(LocalDateTime.of(2023, 02, 15, 16, 30));
		String esperado = "Proyeccion [id=11, fecha=Tue Feb 14 00:00:00 CET 2023, hora=Thu Jan 01 14:02:00 CET 1970, datetime=2023-02-15T16:30, precio=0.0, sala=Sala [id=22, nombre=blue, cine=Cine [id=11, nombre=zubiarte, direccion=direccion123, tele=23456789, mail=zubiarte@gmail.com, codPostal=48012, ciudad=bilbao, provincia=bizkaia, salas=null]], entradas=[Entrada [proyeccion=null, factura=null, cantidad=3, precio=12.0], Entrada [proyeccion=null, factura=null, cantidad=2, precio=6.6]], pelicula=Pelicula [id=11, titulo=avatar, duracion=111, calificacion=5.5, image=avatar.png, genero=Drama, proyeccion=null]]";
		assertEquals(proyeccion.toString(), esperado);

	}

}
