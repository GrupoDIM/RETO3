package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Descuento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1420023108967886087L;
	private int id;
	private int cantidad;
	private double descuento;
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
	@Override
	public int hashCode() {
		return Objects.hash(cantidad, descuento, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Descuento other = (Descuento) obj;
		return cantidad == other.cantidad
				&& Double.doubleToLongBits(descuento) == Double.doubleToLongBits(other.descuento) && id == other.id;
	}
	@Override
	public String toString() {
		return "Descuento [id=" + id + ", cantidad=" + cantidad + ", descuento=" + descuento + "]";
	}
	
	
}
