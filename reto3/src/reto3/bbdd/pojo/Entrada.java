package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Entrada implements Serializable {

	private static final long serialVersionUID = 219025034152596743L;

	// PRIMARY KEY LA RELACION DE 1:1 con proyeccion
	private Proyeccion proyeccion = null;
	// PRIMARY KEY LA RELACION DE 1:1 con factura
	private Factura factura = null;

	// ATRIBUTOS
	private int cantidad = 0;
	private double precio = 0;
	

	public Proyeccion getProyeccion() {
		return proyeccion;
	}

	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, factura, precio, proyeccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return cantidad == other.cantidad && Objects.equals(factura, other.factura)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio)
				&& Objects.equals(proyeccion, other.proyeccion);
	}

	@Override
	public String toString() {
		return "Entrada [proyeccion=" + proyeccion + ", factura=" + factura + ", cantidad=" + cantidad + ", precio="
				+ precio + "]";
	}

}
