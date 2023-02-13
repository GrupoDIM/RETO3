package reto3.bbdd.pojo;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pelicula implements Serializable {

	private static final long serialVersionUID = -1118137812699292414L;
	// Primary key
	private int id;

	private String tituloOrigin = null;
	private String tituloCastellano = null;
	private String duracion;
	private String descripcion = null;
	private double calificacion;
	private File image = null;
	// Foreign key //La relacion entre Pelicula y Genero es 1:N
	private List<Genero> genero = new ArrayList<Genero>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTituloOrigin() {
		return tituloOrigin;
	}

	public void setTituloOrigin(String tituloOrigin) {
		this.tituloOrigin = tituloOrigin;
	}

	public String getTituloCastellano() {
		return tituloCastellano;
	}

	public void setTituloCastellano(String tituloCastellano) {
		this.tituloCastellano = tituloCastellano;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	public List<Genero> getGenero() {
		return genero;
	}

	public void setGenero(List<Genero> genero) {
		this.genero = genero;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	@Override
	public int hashCode() {
		return Objects.hash(calificacion, descripcion, duracion, genero, id, image, tituloCastellano, tituloOrigin);
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
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(duracion, other.duracion)
				&& Objects.equals(genero, other.genero) && id == other.id && Objects.equals(image, other.image)
				&& Objects.equals(tituloCastellano, other.tituloCastellano)
				&& Objects.equals(tituloOrigin, other.tituloOrigin);
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", tituloOrigin=" + tituloOrigin + ", tituloCastellano=" + tituloCastellano
				+ ", duracion=" + duracion + ", descripcion=" + descripcion + ", calificacion=" + calificacion
				+ ", image=" + image + ", genero=" + genero + "]";
	}

}
