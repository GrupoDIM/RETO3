package reto3.bbdd.gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import reto3.bbdd.pojo.Cine;
import reto3.bbdd.pojo.Cliente;
import reto3.bbdd.pojo.Entrada;
import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Pelicula;
import reto3.bbdd.pojo.Proyeccion;
import reto3.bbdd.pojo.Sala;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;

public class GestorFacturaEntrada {
	private Connection con = null;

	public GestorFacturaEntrada() {
		con = new Connection();
	}

	public int insertFactura(Carrito cart, String dateTime) {
		if (!con.isConnected())
			con.connect();
		PreparedStatement ps = null;
		int ret = 0;
		try {
			String query = "INSERT INTO `factura`(`cliente_id`, `fecha_hora`, `DESCUENTO`, `precio`) VALUES ( '"
					+ cart.getCompras().get(0).getFactura().getCliente().getId() + "', '" + dateTime + "','"
					+ cart.getCompras().get(0).getFactura().getDescuento() + "','"
					+ cart.getCompras().get(0).getFactura().getPrecioTotal() + "')";
			ps = con.connection.prepareStatement(query);
			ps.execute();
			Factura factura = getFacturaIdBydDateTime(dateTime);
			for (int i = 0; i < cart.getCompras().size(); i++) {
				if (cart.getCompras().get(i) != null) {
					insertIntoEntrada(factura.getId(), cart.getCompras().get(i));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			con.disconnect();
		}

		return ret;
	}

	public Factura getFacturaIdBydDateTime(String datetime) throws SQLException {
		if (!con.isConnected())
			con.connect();
		Factura ret = null;
		Statement sm = con.connection.createStatement();

		String query = "SELECT `factura_id`, `cliente_id`, `fecha_hora`, `DESCUENTO`, `precio` FROM `factura` WHERE `fecha_hora` =  '"
				+ datetime + "'";
		ResultSet rs = sm.executeQuery(query);
		if (rs.next()) {
			Factura factura = new Factura();
			Cliente cliente = new GestorCliente().getClienteById(rs.getInt("cliente_id"));
			factura.setCliente(cliente);
			factura.setId(rs.getInt("factura_id"));
			factura.setFechaHora(rs.getTimestamp("fecha_hora").toLocalDateTime());
			factura.setPrecioTotal(rs.getDouble("precio"));
			factura.setDescuento(rs.getDouble("DESCUENTO"));
			ArrayList<Entrada> entradas = getEntradasByIdFactura(factura.getId());
			factura.setEntradas(entradas);
			ret = factura;
		}

		return ret;

	}

	public void insertIntoEntrada(int idFactura, Entrada entrada) throws SQLException {
		PreparedStatement ps = null;
		String query = "INSERT INTO `entrada`(`proyeccio_id`, `factura_id`, `cantidad`, `precio`) VALUES ('"
				+ entrada.getProyeccion().getId() + "','" + idFactura + "','" + entrada.getCantidad() + "','"
				+ entrada.getPrecio() + "')";
		ps = con.connection.prepareStatement(query);
		ps.execute();

	}

	public ArrayList<Entrada> getEntradasByIdFactura(int id) throws SQLException {
		if (!con.isConnected())
			con.connect();
		ArrayList<Entrada> ret = new ArrayList<Entrada>();
		Statement sm = con.connection.createStatement();
		String query = "SELECT `proyeccio_id`, `cantidad`, `precio` FROM `entrada` WHERE `factura_id` = '" + id + "'";
		sm = con.connection.prepareStatement(query);
		ResultSet rs = sm.executeQuery(query);
		while (rs.next()) {
			Entrada entrada = new Entrada();
			Proyeccion proyeccion = new GestorProyeccion().getProyeccionById(rs.getInt("proyeccio_id"));
			entrada.setProyeccion(proyeccion);
			entrada.setCantidad(rs.getInt("cantidad"));
			entrada.setPrecio(rs.getDouble("precio"));
			ret.add(entrada);
		}

		return ret;
	}

}
