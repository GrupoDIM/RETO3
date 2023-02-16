package reto3.bbdd.gestores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import reto3.bbdd.pojo.Cine;

public class GestorCine {

	private Connection con = null;

	public GestorCine() {
		con = new Connection();
	}

	public ArrayList<Cine> getCines() {

		if (!con.isConnected())
			con.connect();
		ArrayList<Cine> ret = new ArrayList<Cine>();
		Statement sm = null;
		ResultSet rs = null;
		try {
			sm = con.connection.createStatement();

			String query = "SELECT * FROM `cine`";

			rs = sm.executeQuery(query);
			while (rs.next()) {
				Cine cine = new Cine();
				cine.setId(rs.getInt("cine_id"));
				cine.setNombre(rs.getString("nombre"));
				cine.setTele(rs.getString("tele"));
				cine.setMail(rs.getString("email"));
				cine.setDireccion(rs.getString("direccion"));
				cine.setCodPostal(rs.getString("cod_postal"));
				cine.setCiudad(rs.getString("ciudad"));
				cine.setProvincia(rs.getString("provincia"));
				ret.add(cine);
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

}
