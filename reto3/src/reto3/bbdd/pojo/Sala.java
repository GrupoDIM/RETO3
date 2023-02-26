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
	
	// Primary key
	private int id;

	// Atributos
	private String nombre = null;

	// FK relacion 1:1 con Cine
	private Cine cine = null;

	// FK relacion 1:N con proyeccion
	private ArrayList<Proyeccion> proyecciones = null;

	// GETTERS AND SETTERS //
	// ID | GET
	public int getId() {
		return id;
	}

	// ID | SET
	public void setId(int id) {
		this.id = id;
	}

	// NOMBRE | GET
	public String getNombre() {
		return nombre;
	}

	// NOMBRE | SET
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// CINE | GET
	public Cine getCine() {
		return cine;
	}

	// CINE | SET
	public void setCine(Cine cine) {
		this.cine = cine;
	}

	// PROYECCION | GET
	public ArrayList<Proyeccion> getProyecciones() {
		return proyecciones;
	}

	// PROYECCION | SET
	public void setProyecciones(ArrayList<Proyeccion> proyecciones) {
		this.proyecciones = proyecciones;
	}

	// HASCODE //
	@Override
	public int hashCode() {
		return Objects.hash(cine, id, nombre, proyecciones);
	}

	// EQUALS //
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		return Objects.equals(cine, other.cine) && id == other.id && Objects.equals(nombre, other.nombre)
				&& Objects.equals(proyecciones, other.proyecciones);
	}

	// TO STRING //
	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + ", cine=" + cine + ", proyecciones=" + proyecciones + "]";
	}

}
