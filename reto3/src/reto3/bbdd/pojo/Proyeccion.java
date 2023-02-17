package reto3.bbdd.pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

import reto3.controlador.Gestor;

public class Proyeccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2520498191594699200L;

	// Primary Key
	private int id;

	// Atributos
	private Date fecha = null;
	private Date hora = null;
	private LocalDateTime datetime = null;
	private double precio;

	// FK relacion de 1:1 con Proyeccion
	private Sala sala = null;

	//La relación entre proyección y entradas es de 1:N
    private ArrayList <Entrada> entradas = null;
	
	// FK relacion de 1:1 con pelicula

	private Pelicula pelicula = null;

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public static class orderSessionesByDateTime implements Comparator<Proyeccion> {
		@Override
		public int compare(Proyeccion s1, Proyeccion s2) {
			return s1.datetime.compareTo(s2.datetime);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(datetime, fecha, hora, id, pelicula, precio, sala);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyeccion other = (Proyeccion) obj;
		return Objects.equals(datetime, other.datetime) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora) && id == other.id && Objects.equals(pelicula, other.pelicula)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(sala, other.sala);
	}

	@Override
	public String toString() {
		return "Proyeccion [id=" + id + ", sala=" + sala + ", pelicula=" + pelicula + ", fecha=" + fecha + ", hora="
				+ hora + ", datetime=" + datetime + ", precio=" + precio + "]";
	}

}
