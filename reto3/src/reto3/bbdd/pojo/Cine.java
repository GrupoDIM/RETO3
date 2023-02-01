package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Cine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6651744658859466141L;
	/**
	 * 
	 */

	private int id;
	private String nombre = null;
	private String direccion = null;
	private String tele = null;
	private String mail = null;
	private DireccionInfo info = null;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public DireccionInfo getInfo() {
		return info;
	}

	public void setInfo(DireccionInfo info) {
		this.info = info;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cine other = (Cine) obj;
		return Objects.equals(direccion, other.direccion) && id == other.id && Objects.equals(info, other.info)
				&& Objects.equals(mail, other.mail) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(tele, other.tele);
	}

	@Override
	public String toString() {
		return "Cine [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", tele=" + tele + ", mail="
				+ mail + ", info=" + info + "]";
	}

}
