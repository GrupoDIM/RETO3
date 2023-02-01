package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Proyeccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2520498191594699200L;
	private Sala sala = null;
	private Pelicula pelicula = null;
	private Date fecha = null;
	private Date hora = null;
	private double precio;

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

	@Override
	public int hashCode() {
		return Objects.hash(fecha, hora, pelicula, precio, sala);
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
		return Objects.equals(fecha, other.fecha) && Objects.equals(hora, other.hora)
				&& Objects.equals(pelicula, other.pelicula)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(sala, other.sala);
	}

	@Override
	public String toString() {
		return "Proyeccion [sala=" + sala + ", pelicula=" + pelicula + ", fecha=" + fecha + ", hora=" + hora
				+ ", precio=" + precio + "]";
	}

}
