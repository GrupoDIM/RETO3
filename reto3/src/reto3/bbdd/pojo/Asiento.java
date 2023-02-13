package reto3.bbdd.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Asiento  implements Serializable  {
	/**
	 *
	 */
	private static final long serialVersionUID = -6034836009531020782L;
	

	
	
	//Primary Key
	private int id;
	
	
	
	//Atributos
	private int fila;
	private int numero;
	private boolean disponible = true;
	
	
	
	//Foreign Key	//La relacion entre Asiento y Sala es de 1:1
	private Sala sala = null;
	
	// GETTERS AND SETTERS //
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(disponible, fila, id, numero, sala);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asiento other = (Asiento) obj;
		return disponible == other.disponible && fila == other.fila && id == other.id && numero == other.numero
				&& Objects.equals(sala, other.sala);
	}
	@Override
	public String toString() {
		return "Asiento [id=" + id + ", fila=" + fila + ", numero=" + numero + ", disponible=" + disponible + ", sala="
				+ sala + "]";
	}
	
	
	
}