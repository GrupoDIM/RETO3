package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4351637911824554935L;

	// Primary key
	private int id;

	// Atributos
	private String dni = null;
	private String nombre = null;
	private String apellido1 = null;
	private String apellido2 = null;
	private String email = null;
	private String tele = null;
	private String password = null;
	private char genero;

	// Foreign key //La relacion entre Cliente y Factura es de 0:N
	private List<Factura> tickets = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public List<Factura> getTickets() {
		return tickets;
	}

	public void setTickets(List<Factura> tickets) {
		this.tickets = tickets;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido1, apellido2, dni, email, genero, id, nombre, password, tele, tickets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido1, other.apellido1) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(dni, other.dni) && Objects.equals(email, other.email) && genero == other.genero
				&& id == other.id && Objects.equals(nombre, other.nombre) && Objects.equals(password, other.password)
				&& Objects.equals(tele, other.tele) && Objects.equals(tickets, other.tickets);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
				+ apellido2 + ", email=" + email + ", tele=" + tele + ", password=" + password + ", genero=" + genero
				+ ", tickets=" + tickets + "]";
	}

}
