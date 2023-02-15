package reto3.controlador;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import reto3.bbdd.pojo.Entrada;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Cart.Carrito;
import reto3.vista.ElegirHora;
import reto3.vista.PantallaFechaYSesion;
import reto3.vista.Peliculas;
import reto3.vista.ShoppingCart;
import reto3.vista.factory.JButtonFactoryWindowElegirHora;
import reto3.vista.factory.JButtonFactoryWindowFechaYSesion;
import reto3.vista.factory.JPanelFactoryWindowShopCart;

public class Gestor {
	public double calculatPriceBase(Carrito cart) {
		double ret = 0.0;
		for (Entrada compra : cart.getCompras()) {
			if (null != compra) {
				ret += (compra.getPrecio());
			}

		}
		return ret;
	}

	public String calculateTotalPrice(Carrito cart) {
		DecimalFormat decfor = new DecimalFormat("0.00");
		double totalPrice = 0;
		double precioBase = calculatPriceBase(cart);
		if (descuento(cart) != 0) {
			totalPrice = precioBase * descuento(cart);
		} else {
			totalPrice = precioBase;
		}
		return (decfor.format(totalPrice));

	}

	public int calculateQuantity(Carrito cart) {
		int ret = 0;
		for (Entrada compra : cart.getCompras()) {
			if (null != compra) {
				ret += compra.getCantidad();
			}

		}
		return ret;
	}

	public double descuento(Carrito cart) {
		double ret = 0.0;
		int cantidad = calculateQuantity(cart);
		switch (cantidad) {
		case 2:
			ret = 0.20;
			break;
		case 3:
			ret = 0.30;
			break;
		case 4:
			ret = 0.40;
			break;
		case 5:
			ret = 0.50;
			break;

		}
		if (cantidad > 5) {
			ret = 0.50;
		}
		return ret;
	}

	public LocalTime convertToLocalTimeViaInstant(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}

	public String getTime(Date date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		return formatter.format(convertToLocalTimeViaInstant(date));
	}

	public LocalDate convertToLocalDateViaInstant(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public LocalDateTime converttoLocalDateTime(Date fecha, Date hora) {
		return LocalDateTime.of(convertToLocalDateViaInstant(fecha), convertToLocalTimeViaInstant(hora));

	}

	public int quantityNowPlus(int cantidad) {
		return cantidad + 1;
	}

	public int quantityNowMinus(int cantidad) {
		return cantidad - 1;
	}

	public void addnewButtonToVentanaElegirHora(JPanel panel, ElegirHora frame, ArrayList<Proyeccion> sesiones,
			Carrito cart) {
		JButtonFactoryWindowElegirHora factory = new JButtonFactoryWindowElegirHora();
		int count = 0;
		for (Proyeccion sesion : sesiones) {
			if (null != sesion) {
				count++;
				panel.add(factory.getButton(this, frame, count, sesion, cart));

			}
		}
	}

	public void addJbuttonToPanelVentanaFechaYSesion(JPanel panel, PantallaFechaYSesion frame, ArrayList<Date> fechas,
			Proyeccion sesion, Carrito cart) {
		JButtonFactoryWindowFechaYSesion factory = new JButtonFactoryWindowFechaYSesion();
		int count = 0;
		for (Date date : fechas) {
			if (null != date) {
				count++;

				panel.add(factory.getButton(this, frame, count, sesion, date, cart));
			}
		}
	}

	public void addJpanelToPanelShoppingCart(JPanel panel, ShoppingCart frame, Carrito cart,
			ArrayList<Proyeccion> sesiones, int index) {
		JPanelFactoryWindowShopCart factory = new JPanelFactoryWindowShopCart();
		int count = 0;
		for (Entrada compra : cart.getCompras()) {
			if (null != compra) {
				count++;
				panel.add(factory.getPanel(this, frame, count, compra, cart, sesiones, index));
			}
		}
	}

	public void addJpanelToPanelVentanaPelicula(JPanel panel, Peliculas frame, ArrayList<Proyeccion> sesiones,
			Carrito cart) {
		int count = 0;
		for (Proyeccion sesion : sesiones) {
			if (null != sesion) {
				count++;
				reto3.vista.factory.JPanelFactory jPanelFactory = new reto3.vista.factory.JPanelFactory();
				panel.add(jPanelFactory.getPanel(frame, this, count, sesion, cart));
			}
		}
	}

	public String setDateOfTheDay(Date date) {
		return new SimpleDateFormat("EEE dd  MMM ").format(date);
	}

	public BufferedImage readimg(File file) {
		BufferedImage ret = null;
		try {
			ret = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
