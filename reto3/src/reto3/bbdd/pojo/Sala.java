package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sala implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2125851948391893223L;
	/**
	 * 
	 */
	// Primary key
	private int id;

	// Atributos
	private String nombre = null;

	// relacion N:1 con Cine
	private Cine cine = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cine getCine() {
		return cine;
	}

	public void setCine(Cine cine) {
		this.cine = cine;
	}

	@Override
	public int hashCode() {

		return Objects.hash(cine, id, nombre);

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;

		return Objects.equals(cine, other.cine) && id == other.id && Objects.equals(nombre, other.nombre);

	}

	@Override
	public String toString() {
  
		return "Sala [id=" + id + ", nombre=" + nombre + ", cine=" + cine + "]";

	}

}
