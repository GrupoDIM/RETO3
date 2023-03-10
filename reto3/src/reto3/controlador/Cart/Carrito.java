package reto3.controlador.Cart;

import java.util.ArrayList;

import reto3.bbdd.pojo.Entrada;

import reto3.bbdd.pojo.Factura;

/**
 * Carrito de la compra. Se va a pasar por todas las ventanas
 */
public class Carrito {

	private ArrayList<Entrada> compras = null;

	public ArrayList<Entrada> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Entrada> compras) {
		this.compras = compras;
	}

	public void addEntrada(Entrada entrada) {
		if (!isEmpty()) {
			compras.add(entrada);
		} else {
			compras = new ArrayList<Entrada>();
			compras.add(entrada);

		}
	}

	public boolean isEmpty() {
		boolean ret = false;
		if ((null == compras) || (compras.isEmpty())) {
			ret = true;
		}
		return ret;
	}

	public void clear() {
		if (!(null == compras) || (compras.isEmpty())) {
			compras.clear();
		}
	}

	public int size() {
		int ret = 0;
		if ((null == compras) || (compras.isEmpty())) {
			ret = 0;
		} else {
			ret = compras.size();
		}
		return ret;
	}
}
