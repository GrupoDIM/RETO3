package reto3.controlador;

import java.awt.Window;
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
import javax.swing.JButton;
import javax.swing.JPanel;

import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Genero;
import reto3.bbdd.pojo.Proyeccion;
import reto3.vista.Peliculas;
import reto3.vista.ElegirHora;
import reto3.vista.Jpanels;
import reto3.vista.PantallaFechaYSesion;
import reto3.vista.ShoppingCart;

public class Gestor {
	private double calculatPriceBase(ArrayList<Factura> compras) {
		double ret = 0.0;
		for (Factura compra : compras) {
			if (null != compra) {
				ret += (compra.getPrecioTotal());
			}

		}
		return ret;
	}

	public String calculateTotalPrice(ArrayList<Factura> compras) {
		DecimalFormat decfor = new DecimalFormat("0.00");
		double totalPrice = 0;
		double precioBase = calculatPriceBase(compras);
		if (descuento(compras) != 0) {
			totalPrice = precioBase * descuento(compras);
		} else {
			totalPrice = precioBase;
		}
		return (decfor.format(totalPrice));

	}

	public int calculateQuantity(ArrayList<Factura> compras) {
		int ret = 0;
		for (Factura compra : compras) {
			if (null != compra) {
				ret += compra.getCantidad();
			}

		}
		return ret;
	}

	public double descuento(ArrayList<Factura> compras) {
		double ret = 0.0;
		int cantidad = calculateQuantity(compras);
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

	public void addnewButtonToVentanaElegirHora(JPanel panel, ElegirHora frame, ArrayList<Proyeccion> sesiones,
			ArrayList<Factura> compras) {
		int count = 0;
		for (Proyeccion sesion : sesiones) {
			if (null != sesion) {
				count++;
				panel.add(addNewButton(frame, count, sesion, compras));

			}
		}
	}

	public int quantityNowPlus(int cantidad) {
		return cantidad + 1;
	}

	public int quantityNowMinus(int cantidad) {
		return cantidad - 1;
	}

	public String generoToString(ArrayList<Genero> generos) {
		String ret = "";
		for (Genero genero : generos) {
			ret += genero.getGenero() + "|";
		}
		return ret;
	}

	public void addJbuttonToPanelVentanaFechaYSesion(JPanel panel, PantallaFechaYSesion frame, ArrayList<Date> fechas,
			Proyeccion sesion, ArrayList<Factura> compras) {
		int count = 0;
		for (Date date : fechas) {
			if (null != date) {
				count++;
				panel.add(addNewJButton(frame, count, sesion, date, compras));
			}
		}
	}

	public void addJpanelToPanelShoppingCart(JPanel panel, ShoppingCart frame, ArrayList<Factura> compras,
			ArrayList<Proyeccion> sesiones, int index) {
		int count = 0;
		for (Factura compra : compras) {
			if (null != compra) {
				count++;
				panel.add(addNewJpanelToShopCart(frame, count, compra, compras, sesiones, index));
			}
		}
	}

	public void addJpanelToPanelVentanaPelicula(JPanel panel, Peliculas frame, ArrayList<Proyeccion> sesiones,
			ArrayList<Factura> compras) {
		int count = 0;
		for (Proyeccion sesion : sesiones) {
			if (null != sesion) {
				count++;
				panel.add(addNewJpanel(frame, count, sesion, compras));
			}
		}
	}

	public JPanel addNewJpanel(Peliculas frame, int count, Proyeccion sesion, ArrayList<Factura> compras) {
		JPanel ret = null;
		Jpanels myp = new Jpanels();
		int dimension = 0;
		switch (count) {
		case 1:
			ret = myp.jpanelI(frame, this, sesion, compras);
			break;
		case 2:
			dimension = 291;
			ret = myp.jpanelII(frame, dimension, this, sesion, compras);
			break;
		case 3:
			dimension = 291 * 2;
			ret = myp.jpanelIII(frame, dimension, this, sesion, compras);

			break;
		case 4:
			dimension = 291 * 3;
			ret = myp.jpanelIV(frame, dimension, this, sesion, compras);
			break;
		case 5:
			dimension = 291 * 4;
			ret = myp.jpanelV(frame, dimension, this, sesion, compras);
			break;
		case 6:
			dimension = 291 * 5;
			ret = myp.jpanelVI(frame, dimension, this, sesion, compras);
			break;
		case 7:
			dimension = 291 * 6;
			ret = myp.jpanelVII(frame, dimension, this, sesion, compras);
			break;
		case 8:
			dimension = 291 * 7;
			ret = myp.jpanelVIII(frame, dimension, this, sesion, compras);
			break;
		case 9:
			dimension = 423 * 8;
			ret = myp.jpanelIX(frame, dimension, this, sesion, compras);
			break;
		case 10:
			dimension = 423 * 9;
			ret = myp.jpanelX(frame, dimension, this, sesion, compras);
			break;
		case 11:
			dimension = 291 * 10;
			ret = myp.jpanelXI(frame, dimension, this, sesion, compras);
			break;

		}
		return ret;

	}

	public JButton addNewJButton(PantallaFechaYSesion frame, int count, Proyeccion sesion, Date date,
			ArrayList<Factura> compras) {
		JButton ret = null;
		Jpanels myp = new Jpanels();
		int dimension = 0;
		switch (count) {
		case 1:
			ret = myp.buttonI(frame, this, date, sesion, compras);
			break;
		case 2:
			dimension = 165 + 55;
			ret = myp.buttonII(frame, this, dimension, date, sesion, compras);
			break;
		case 3:
			dimension = 165 + (55 * 2);
			ret = myp.buttonIII(frame, this, dimension, date, sesion, compras);

			break;
		case 4:
			dimension = 165 + (55 * 3);
			ret = myp.buttonIV(frame, this, dimension, date, sesion, compras);
			break;
		case 5:
			dimension = 165 + (55 * 4);
			ret = myp.buttonV(frame, this, dimension, date, sesion, compras);
			break;
		case 6:
			dimension = 165 + (55 * 5);
			ret = myp.buttonVI(frame, this, dimension, date, sesion, compras);
			break;
		}
		return ret;

	}

	public JButton addNewButton(ElegirHora frame, int count, Proyeccion sesion, ArrayList<Factura> compras) {
		JButton ret = null;
		Jpanels myp = new Jpanels();
		int dimension = 0;
		switch (count) {
		case 1:
			ret = myp.buttonHoraI(this, frame, sesion, compras);
			break;
		case 2:
			dimension = 202 * 2;
			ret = myp.buttonHoraII(this, frame, dimension, sesion, compras);
			break;
		case 3:
			dimension = 202 * 3;
			ret = myp.buttonHoraIII(this, frame, dimension, sesion, compras);

			break;
		case 4:
			dimension = 202 * 4;
			ret = myp.buttonHoraIV(this, frame, dimension, sesion, compras);
			break;
		}
		return ret;
	}

	public JPanel addNewJpanelToShopCart(ShoppingCart frame, int count, Factura compra, ArrayList<Factura> compras,
			ArrayList<Proyeccion> sesiones, int index) {
		JPanel ret = null;
		Jpanels myp = new Jpanels();
		int dimension = 0;
		switch (count) {
		case 1:
			ret = myp.panelShopCartI(compra, compras, this, frame, sesiones, index);
			break;
		case 2:
			dimension = 110;
			ret = myp.panelShopCartII(dimension, compra, compras, this, frame, sesiones, index);
			break;
		case 3:
			dimension = 110 * 2;
			ret = myp.panelShopCartIII(dimension, compra, compras, this, frame, sesiones, index);

			break;
		case 4:
			dimension = 110 * 3;
			ret = myp.panelShopCartIV(dimension, compra, compras, this, frame, sesiones, index);
			break;
		}
		return ret;
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
