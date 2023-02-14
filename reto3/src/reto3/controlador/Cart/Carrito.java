package reto3.controlador.Cart;

import java.util.ArrayList;

import reto3.bbdd.pojo.Factura;

/**
 * Carrito de la compra. Se va a pasar por todas las ventanas
 */
public class Carrito {

	private ArrayList<Factura> compras = null;

	public ArrayList<Factura> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Factura> compras) {
		this.compras = compras;
	}

	public void addFactura(Factura factura) {
		if (!isEmpty()) {
			compras.add(factura);
		} else {
			compras = new ArrayList<Factura>();
			compras.add(factura);
		}
	}

	public boolean isEmpty() {
		boolean ret = false;
		if ((null == compras) || (compras.isEmpty())) {
			ret = true;
		}
		return ret;
	}
}
