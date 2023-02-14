package reto3.controlador;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

import reto3.bbdd.pojo.Factura;
import reto3.controlador.Cart.Carrito;

class GestorTest {
	private Gestor gestor = null;

	public GestorTest() {
		gestor = new Gestor();
	}

	@Test
	void testCalculatPriceBase() {
		Factura factura = new Factura();
		factura.setPrecioTotal(12);
		factura.setCantidad(6);
		Carrito cart = new Carrito();
		cart.addFactura(factura);
		double result = gestor.calculatPriceBase(cart);
		assertEquals(result, 12.0);

	}

	@Test
	void testCalculatQuantity() {
		Factura factura = new Factura();
		factura.setPrecioTotal(12);
		factura.setCantidad(6);
		Carrito cart = new Carrito();
		cart.addFactura(factura);
		int result = gestor.calculateQuantity(cart);
		assertEquals(result, 6);

	}

	@Test
	void testDescuento() {
		Factura factura = new Factura();
		factura.setPrecioTotal(12);
		factura.setCantidad(6);
		Carrito cart = new Carrito();
		cart.addFactura(factura);
		double result = gestor.descuento(cart);
		assertEquals(result, 0.50);
	}

	@Test
	void testConvertToLocalTimeViaInstant() throws ParseException {

		Date myDate = new SimpleDateFormat("HH:mm").parse("14:12");
		LocalTime result = gestor.convertToLocalTimeViaInstant(myDate);
		assertEquals(result, LocalTime.of(14, 12, 00));

	}

	@Test
	void testGetTime() throws ParseException {

		Date myDate = new SimpleDateFormat("HH:mm").parse("14:10");
		String result = gestor.getTime(myDate);
		assertEquals(result, "14:10");

	}

	@Test
	void testConvertToLocalDateViaInstant() throws ParseException {

		Date myDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-14");
		LocalDate result = gestor.convertToLocalDateViaInstant(myDate);
		assertEquals(result, LocalDate.of(2023, 02, 14));

	}

	@Test
	void testConvertToLocalDateTimeViaInstant() throws ParseException {

		Date myDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2023-02-14 14:12");
		LocalDateTime result = gestor.converttoLocalDateTime(myDate, myDate);
		assertEquals(result, LocalDateTime.of(2023, 02, 14, 14, 12));
	}

	@Test
	void testSetDateOfTheDay() throws ParseException {

		Date myDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-02-14");
		String result = gestor.setDateOfTheDay(myDate);
		assertEquals(result.trim(), "mar 14  feb".trim());

	}

}
