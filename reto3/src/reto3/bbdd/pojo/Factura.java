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
	private double descuento;
	private double precio;
	private double precioTotal;
	private TipoDePago info = null;
	// fk //La relacion entre Factura y Proyeccion es de N:1
	private Proyeccion proyeccion = null;

	// Foreign key //La relacion entre Factura y Cliente es de 1:1
	private Cliente cliente = null;

	public Proyeccion getProyeccion() {
		return proyeccion;
	}

	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}

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

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public TipoDePago getInfo() {
		return info;
	}

	public void setInfo(TipoDePago info) {
		this.info = info;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, cliente, descuento, id, info, precio, precioTotal, precioUnidad, proyeccion);
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
		return cantidad == other.cantidad && Objects.equals(cliente, other.cliente)
				&& Double.doubleToLongBits(descuento) == Double.doubleToLongBits(other.descuento) && id == other.id
				&& Objects.equals(info, other.info)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Double.doubleToLongBits(precioTotal) == Double.doubleToLongBits(other.precioTotal)
				&& Double.doubleToLongBits(precioUnidad) == Double.doubleToLongBits(other.precioUnidad)
				&& Objects.equals(proyeccion, other.proyeccion);
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", cantidad=" + cantidad + ", precioUnidad=" + precioUnidad + ", descuento="
				+ descuento + ", precio=" + precio + ", precioTotal=" + precioTotal + ", info=" + info + ", proyeccion="
				+ proyeccion + ", cliente=" + cliente + "]";
	}

}
