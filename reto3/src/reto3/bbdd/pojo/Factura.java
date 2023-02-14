package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Factura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4533221672779696289L;
	/**
	 * 
	 */

	// Primary key
	private int id;

	// Atributos
	private int cantidad;
	private double precioUnidad;
	private double precioTotal;

	// fk La relacion entre Factura y Proyeccion es de N:1
	private Proyeccion proyeccion = null;

	// Foreign key La relacion entre Factura y Cliente es de 1:1
	private Cliente cliente = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Proyeccion getProyeccion() {
		return proyeccion;
	}

	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, cliente, id, precioTotal, precioUnidad, proyeccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		return cantidad == other.cantidad && Objects.equals(cliente, other.cliente) && id == other.id
				&& Double.doubleToLongBits(precioTotal) == Double.doubleToLongBits(other.precioTotal)
				&& Double.doubleToLongBits(precioUnidad) == Double.doubleToLongBits(other.precioUnidad)
				&& Objects.equals(proyeccion, other.proyeccion);
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", cantidad=" + cantidad + ", precioUnidad=" + precioUnidad + ", precioTotal="
				+ precioTotal + ", proyeccion=" + proyeccion + ", cliente=" + cliente + "]";
	}

}
