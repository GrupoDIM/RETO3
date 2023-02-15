package reto3.bbdd.gestores;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class GestorPelicula {

	private static Connection con = new Connection();

	public ArrayList<Date> getFechasDeUnaPelicula(int id, int idCine) {
		if (!con.isConnected())
			con.connect();
		ArrayList<Date> ret = new ArrayList<>();
		Statement sm = null;
		ResultSet rs = null;

		try {
			sm = con.connection.createStatement();

			String query = "SELECT sp.fecha  FROM proyeccion AS sp JOIN sala AS s ON sp.sala_id = s.sala_id WHERE sp.peli_id ='"
					+ id + "'AND s.cine_id = '" + idCine + "' AND fecha>= (CURDATE() + INTERVAL 1 DAY) GROUP BY fecha";

			rs = sm.executeQuery(query);
			while (rs.next()) {

				java.sql.Date date = rs.getDate("fecha");
				ret.add(new Date(date.getTime()));
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
