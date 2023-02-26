
package reto3.bbdd.pojo;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;

public class Pelicula implements Serializable {

	private static final long serialVersionUID = -1118137812699292414L;
	// Primary key
	private int id;

	// Atributos
	private String titulo = null;
	private int duracion;
	private double calificacion;
	private File image = null;
	private String genero = null;

	// FK la relacion de 1:1 con Proyeccion
	private Proyeccion proyeccion = null;

	// GETTERS AND SETTERS //
	// ID | GET
	public int getId() {
		return id;
	}

	// ID | SET
	public void setId(int id) {
		this.id = id;
	}

	// TITULO | GET
	public String getTitulo() {
		return titulo;
	}

	// TITULO | SET
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	// DURACION | GET
	public int getDuracion() {
		return duracion;
	}

	// DURACION | SET
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	// CALIFICACION | GET
	public double getCalificacion() {
		return calificacion;
	}

	// CALIFICACION | SET
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	// IMAGEN | GET
	public File getImage() {
		return image;
	}

	// IMAGEN | SET
	public void setImage(File image) {
		this.image = image;
	}

	// GENERO | GET
	public String getGenero() {
		return genero;
	}

	// GENERO | SET
	public void setGenero(String genero) {
		this.genero = genero;
	}

	// PROYECCION | GET
	public Proyeccion getProyeccion() {
		return proyeccion;
	}

	// PROYECCION | SET
	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}

	// HASHCODE //
	@Override
	public int hashCode() {
		return Objects.hash(calificacion, duracion, genero, id, image, proyeccion, titulo);
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
		Pelicula other = (Pelicula) obj;
		return Double.doubleToLongBits(calificacion) == Double.doubleToLongBits(other.calificacion)
				&& duracion == other.duracion && Objects.equals(genero, other.genero) && id == other.id
				&& Objects.equals(image, other.image) && Objects.equals(proyeccion, other.proyeccion)
				&& Objects.equals(titulo, other.titulo);
	}

	// TO STRING //
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", calificacion=" + calificacion
				+ ", image=" + image + ", genero=" + genero + ", proyeccion=" + proyeccion + "]";
	}

}
