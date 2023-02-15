
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Proyeccion getProyeccion() {
		return proyeccion;
	}

	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calificacion, duracion, genero, id, image, proyeccion, titulo);
	}

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

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", duracion=" + duracion + ", calificacion=" + calificacion
				+ ", image=" + image + ", genero=" + genero + ", proyeccion=" + proyeccion + "]";
	}

}
