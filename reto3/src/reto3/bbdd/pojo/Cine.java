package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Cine implements Serializable {

	/**
	 * Esta clase es para generara el objeto cine
	 */
	private static final long serialVersionUID = -6651744658859466141L;
	
	// clave primaria
	private int id = 0;

	// atributos
	private String nombre = null;
	private String direccion = null;
	private String tele = null;
	private String mail = null;
	private String codPostal = null;
	private String ciudad = null;
	private String provincia = null;
	
	//relacion de 1:N con Sala
	private ArrayList <Sala> salas = null;

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

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
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

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> salas) {
		this.salas = salas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciudad, codPostal, direccion, id, mail, nombre, provincia, salas, tele);
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
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(codPostal, other.codPostal)
				&& Objects.equals(direccion, other.direccion) && id == other.id && Objects.equals(mail, other.mail)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(provincia, other.provincia)
				&& Objects.equals(salas, other.salas) && Objects.equals(tele, other.tele);
	}

	@Override
	public String toString() {
		return "Cine [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", tele=" + tele + ", mail="
				+ mail + ", codPostal=" + codPostal + ", ciudad=" + ciudad + ", provincia=" + provincia + ", salas="
				+ salas + "]";
	}
	
	
}
