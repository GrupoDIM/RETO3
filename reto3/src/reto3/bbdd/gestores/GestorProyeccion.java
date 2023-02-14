package reto3.bbdd.gestores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import reto3.bbdd.pojo.Cine;
import reto3.bbdd.pojo.Genero;
import reto3.bbdd.pojo.Pelicula;
import reto3.bbdd.pojo.Proyeccion;
import reto3.bbdd.pojo.Sala;
import reto3.bbdd.pojo.Proyeccion.orderSessionesByDateTime;

import reto3.controlador.Gestor;

public class GestorProyeccion {
	private Connection con = null;

	public GestorProyeccion() {
		con = new Connection();
	}

	public ArrayList<Proyeccion> getProyeccionByIdCine(int id) {

		if (!con.isConnected())
			con.connect();
		ArrayList<Proyeccion> ret = new ArrayList<Proyeccion>();
		Statement sm = null;
		ResultSet rs = null;

		int idSala = 0;
		int idPeli = 0;

		try {
			sm = con.connection.createStatement();

			String query = "SELECT DISTINCT `id_sala_pelicula`, sp.sala_id ,`peli_id` , `precio` , `fecha` , `hora` FROM sala_pelicula AS sp JOIN sala AS s ON sp.sala_id = s.sala_id AND s.cine_id = '"
					+ id + "' WHERE `fecha` >= CURRENT_DATE() GROUP BY `peli_id`";

			rs = sm.executeQuery(query);
			while (rs.next()) {
				Proyeccion proyec = new Proyeccion();
				proyec.setId(rs.getInt("id_sala_pelicula"));

				idSala = rs.getInt("sala_id");
				idPeli = rs.getInt("peli_id");
				Double precio = rs.getDouble("precio");
				java.sql.Date date = rs.getDate("fecha");
				java.sql.Time time = rs.getTime("hora");
				Sala sala = getSalaByID(idSala);
				Pelicula pelicula = getPeliculaByID(idPeli);
				proyec.setSala(sala);
				proyec.setPelicula(pelicula);
				proyec.setPrecio(precio);
				proyec.setFecha(new Date(date.getTime()));
				proyec.setHora(new Date(time.getTime()));
				Gestor gestor = new Gestor();
				proyec.setDatetime(gestor.converttoLocalDateTime(proyec.getFecha(), proyec.getHora()));
				ret.add(proyec);
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
		Collections.sort(ret, new orderSessionesByDateTime());

		return ret;
	}

	public Sala getSalaByID(int id) throws SQLException {

		if (!con.isConnected())
			con.connect();
		Sala ret = null;
		Statement sm = con.connection.createStatement();
		String query = "SELECT * FROM `sala` WHERE `sala_id` = '" + id + "'";
		ResultSet rs = sm.executeQuery(query);
		if (rs.next()) {
			Sala sala = new Sala();
			sala.setId(rs.getInt("sala_id"));
			sala.setNombre(rs.getString("numero"));
			sala.setCine(getCineByIdSala(id));
			ret = sala;
		}
		return ret;
	}

	public Cine getCineByIdSala(int id) throws SQLException {
		if (!con.isConnected())
			con.connect();
		Cine ret = null;
		Statement sm = con.connection.createStatement();
		String query = "SELECT c.cine_id, c.nombre, c.tele , c.email , c.direccion , c.cod_postal , cp.ciudad, cp.provincia FROM `cine`"
				+ " AS c JOIN codigo_postal AS cp ON c.cod_postal = cp.cod_postal JOIN sala AS s ON s.cine_id = c.cine_id AND s.sala_id = '"
				+ id + "'";
		ResultSet rs = sm.executeQuery(query);
		if (rs.next()) {
			Cine cine = new Cine();
			cine.setId(rs.getInt("cine_id"));
			cine.setNombre(rs.getString("nombre"));
			cine.setTele(rs.getString("tele"));
			cine.setMail(rs.getString("email"));
			cine.setDireccion(rs.getString("direccion"));
			cine.setCodPostal(rs.getString("cod_postal"));
			cine.setCiudad(rs.getString("ciudad"));
			cine.setProvincia(rs.getString("provincia"));
			ret = cine;
		}
		return ret;
	}

	public Pelicula getPeliculaByID(int id) throws SQLException {
		if (!con.isConnected())
			con.connect();
		Pelicula ret = null;

		Statement sm = con.connection.createStatement();
		String query = "SELECT `titulo_origin`, `titulo_castellano`, `duracion`,`calificacion` FROM `pelicula` WHERE`peli_id` = '"
				+ id + "'";
		ResultSet rs = sm.executeQuery(query);

		if (rs.next()) {

			Pelicula peli = new Pelicula();
			peli.setId(id);
			peli.setTituloOrigin(rs.getString("titulo_origin"));
			peli.setTituloCastellano(rs.getString("titulo_castellano"));
			peli.setDuracion(rs.getString("duracion"));
			peli.setCalificacion(rs.getDouble("calificacion"));
			File img = getImageByIdPelicula(id, peli.getTituloCastellano().trim().toLowerCase());
			peli.setImage(img);
			peli.setGenero(getGeneroByIdPelicula(id));
			ret = peli;
		}
		return ret;

	}

	public ArrayList<Genero> getGeneroByIdPelicula(int id) throws SQLException {
		if (!con.isConnected())
			con.connect();
		ArrayList<Genero> ret = new ArrayList<Genero>();

		String query = "SELECT genero FROM genero AS g JOIN pelicula_genero AS  pg ON pg.genero_id = g.genero_id WHERE pg.peli_id = '"
				+ id + "'";
		Statement sm = con.connection.createStatement();
		ResultSet rs = sm.executeQuery(query);

		while (rs.next()) {

			Genero genero = new Genero();
			genero.setGenero(rs.getString("genero"));
			ret.add(genero);
		}
		return ret;

	}

	public File getImageByIdPelicula(int id, String name) throws SQLException {
		if (!con.isConnected())
			con.connect();
		byte bytes[];
		Blob blob;
		FileOutputStream fos = null;
		File file = new File(name + ".png");
		Statement sm = con.connection.createStatement();
		String query = "SELECT image FROM `pelicula` WHERE `peli_id` = '" + id + "'";
		ResultSet rs = sm.executeQuery(query);

		try {
			if (rs.next()) {
				fos = new FileOutputStream(file);
				blob = rs.getBlob("image");
				bytes = blob.getBytes(1, (int) blob.length());
				fos.write(bytes);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.flush();
				} catch (IOException e) {
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
		return file;
	}

	public ArrayList<Proyeccion> getProyeccionByDate(int id, LocalDate fecha, int idCine) {
		if (!con.isConnected())
			con.connect();
		ArrayList<Proyeccion> ret = new ArrayList<Proyeccion>();
		Statement sm = null;
		ResultSet rs = null;

		int idSala = 0;
		int idPeli = 0;

		try {
			sm = con.connection.createStatement();

			String query = "SELECT sp.id_sala_pelicula , sp.sala_id , sp.peli_id , sp.precio , sp.fecha , sp.hora FROM sala_pelicula AS sp JOIN sala AS s ON sp.sala_id = s.sala_id WHERE sp.peli_id = '"
					+ id + "' AND s.cine_id = '" + idCine + "'  AND sp.fecha = '" + fecha + "'  ORDER BY sp.hora ASC";

			rs = sm.executeQuery(query);
			while (rs.next()) {
				Proyeccion proyec = new Proyeccion();
				proyec.setId(rs.getInt("id_sala_pelicula"));
				idSala = rs.getInt("sala_id");
				idPeli = rs.getInt("peli_id");
				Double precio = rs.getDouble("precio");
				java.sql.Date date = rs.getDate("fecha");
				java.sql.Time time = rs.getTime("hora");
				Sala sala = getSalaByID(idSala);
				Pelicula pelicula = getPeliculaByID(idPeli);
				proyec.setSala(sala);
				proyec.setPelicula(pelicula);
				proyec.setPrecio(precio);
				proyec.setFecha(new Date(date.getTime()));
				proyec.setHora(new Date(time.getTime()));
				Gestor gestor = new Gestor();
				proyec.setDatetime(gestor.converttoLocalDateTime(proyec.getFecha(), proyec.getHora()));
				ret.add(proyec);
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
