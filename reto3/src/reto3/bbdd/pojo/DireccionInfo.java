package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class DireccionInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4967828610781846313L;
	private int codPostal;
	private String ciudad = null;
	private String provincia = null;

	public int getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(int codPostal) {
		this.codPostal = codPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciudad, codPostal, provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DireccionInfo other = (DireccionInfo) obj;
		return Objects.equals(ciudad, other.ciudad) && codPostal == other.codPostal
				&& Objects.equals(provincia, other.provincia);
	}

	@Override
	public String toString() {
		return "Direccion_Info [codPostal=" + codPostal + ", ciudad=" + ciudad + ", provincia=" + provincia + "]";
	}

}
