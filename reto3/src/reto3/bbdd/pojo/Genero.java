package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Genero implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8795581819198864173L;
	/**
	 * 
	 */

	private int id;
	private String genero= null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public int hashCode() {
		return Objects.hash(genero, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		return Objects.equals(genero, other.genero) && id == other.id;
	}
	@Override
	public String toString() {
		return "Genero [id=" + id + ", genero=" + genero + "]";
	}
	
	

}
