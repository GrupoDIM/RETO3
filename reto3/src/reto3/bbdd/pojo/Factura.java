package reto3.bbdd.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
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

	private double descuento;
	private double precioTotal;
	private LocalDateTime fechaHora;

	// Foreign key La relacion entre Factura y Cliente es de 1:1
	private Cliente cliente = null;
	// fk la relacion de 1:N con Entrada
	private List<Entrada> entradas = null;

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

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;

	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public List<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<Entrada> entradas) {
		this.entradas = entradas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, cliente, descuento, entradas, fechaHora, id, precioTotal);
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
				&& Double.doubleToLongBits(descuento) == Double.doubleToLongBits(other.descuento)
				&& Objects.equals(entradas, other.entradas) && Objects.equals(fechaHora, other.fechaHora)
				&& id == other.id && Double.doubleToLongBits(precioTotal) == Double.doubleToLongBits(other.precioTotal);
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", cantidad=" + cantidad + ", descuento=" + descuento + ", precioTotal="
				+ precioTotal + ", fechaHora=" + fechaHora + ", cliente=" + cliente + ", entradas=" + entradas + "]";
	}

}
