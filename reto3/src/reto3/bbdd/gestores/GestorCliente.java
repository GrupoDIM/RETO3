package reto3.bbdd.gestores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import reto3.bbdd.pojo.Cliente;

public class GestorCliente {

	private Connection con = null;

	public GestorCliente() {
		con = new Connection();
	}

	public Cliente getClienteByEmailAndPassword(String email, String pass) {
		if (!con.isConnected())
			con.connect();
		Cliente ret = null;
		Statement sm = null;
		ResultSet rs = null;

		try {
			sm = con.connection.createStatement();

			String query = "SELECT `cliente_id`, `dni`, `nombre`, `apellido1`, `apellido2`, `genero`, `tele` FROM `cliente` WHERE `email` = '"
					+ email + "' AND `pass` = '" + pass + "'";

			rs = sm.executeQuery(query);
			if (rs.next()) {

				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("cliente_id"));
				cliente.setDni(rs.getString("dni"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido1(rs.getString("apellido1"));
				cliente.setApellido2(rs.getString("apellido2"));
				cliente.setGenero(rs.getString("genero").charAt(0));
				cliente.setTele(rs.getString("tele"));
				cliente.setEmail(email);
				ret = cliente;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (sm != null) {
				try {
					sm.close();
				} catch (SQLException e) {
				}

				con.disconnect();
			}
		}
		return ret;
	}

	public void insertCliente(Cliente cliente) {
		if (!con.isConnected())
			con.connect();
		PreparedStatement ps = null;
		try {

			String query = "INSERT INTO `cliente`( `dni`, `nombre`, `apellido1`, `apellido2`, `genero`, `tele`, `email`, `pass`)"
					+ "VALUES ('" + cliente.getDni() + "','" + cliente.getNombre() + "','" + cliente.getApellido1()
					+ "' , '" + cliente.getApellido2() + "','" + cliente.getGenero() + "','" + cliente.getTele() + "','"
					+ cliente.getEmail() + "','" + cliente.getPassword() + "') ";
			ps = con.connection.prepareStatement(query);
			ps.execute();

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

	}

}
