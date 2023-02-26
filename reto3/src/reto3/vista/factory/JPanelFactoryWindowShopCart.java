package reto3.vista.factory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import reto3.bbdd.pojo.Entrada;

import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;
import reto3.vista.ShoppingCart;

public class JPanelFactoryWindowShopCart extends JFrame {
	public JPanelFactoryWindowShopCart() {
	}

	private static final long serialVersionUID = 4099213746768850950L;

	public JPanel getPanel(Gestor gestor, ShoppingCart frame, int count, Entrada compra, Carrito cart,

			ArrayList<Proyeccion> sesiones, int index) {
		JPanel ret = null;

		int dimension;
		switch (count) {
		case 1:
			ret = panelShopCartI(compra, cart, gestor, frame, sesiones, index);
			break;
		case 2:
			dimension = 110;
			ret = panelShopCartII(dimension, compra, cart, gestor, frame, sesiones, index);
			break;
		case 3:
			dimension = 110 * 2;
			ret = panelShopCartIII(dimension, compra, cart, gestor, frame, sesiones, index);

			break;
		case 4:
			dimension = 110 * 3;
			ret = panelShopCartIV(dimension, compra, cart, gestor, frame, sesiones, index);
			break;
		}
		return ret;
	}

	private JPanel panelShopCartI(Entrada compra, Carrito cart, Gestor con, ShoppingCart frame,

			ArrayList<Proyeccion> sesiones, int index) {

		JPanel ret = new JPanel();
		ret.setBackground(new Color(248, 212, 64));
		ret.setBounds(0, 0, 600, 111);
		ret.setLayout(null);

		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new javax.swing.ImageIcon(new Gestor().readimg(compra.getProyeccion().getPelicula().getImage())
				.getScaledInstance(80, 111, WIDTH)));
		lblImage.setBounds(0, 0, 80, 111);
		ret.add(lblImage);

		JButton btnEliminarCompra = new JButton("");
		btnEliminarCompra.setBounds(540, 0, 60, 111);
		ret.add(btnEliminarCompra);
		btnEliminarCompra
				.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/BotonCross60x111.png")));
		btnEliminarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar la Compra  ", "",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (cart.getCompras().contains(compra)) {
						cart.getCompras().remove(compra);
						frame.dispose();
						ShoppingCart open = new ShoppingCart(sesiones, cart, null, index);
						open.setVisible(true);

					}

				}
			}
		});

		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTitle.setText(compra.getProyeccion().getPelicula().getTitulo());
		lblTitle.setBounds(88, 11, 300, 14);
		ret.add(lblTitle);

		JLabel lbl = new JLabel("Cantidad: ");
		lbl.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl.setBounds(88, 49, 70, 14);
		ret.add(lbl);

		JLabel lblCantidad = new JLabel("");
		lblCantidad.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCantidad.setText(compra.getCantidad() + "");
		lblCantidad.setBounds(156, 45, 46, 23);
		ret.add(lblCantidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPrecio.setText("Precio Unidad : " + compra.getProyeccion().getPrecio() + "" + "€");
		lblPrecio.setBounds(88, 78, 274, 14);
		ret.add(lblPrecio);
		return ret;

	}

	private JPanel panelShopCartII(int dimension, Entrada compra, Carrito cart, Gestor con, ShoppingCart frame,

			ArrayList<Proyeccion> sesiones, int index) {

		JPanel ret = new JPanel();
		ret.setBackground(new Color(248, 212, 64));
		ret.setBounds(0, dimension, 600, 111);
		ret.setLayout(null);

		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 80, 111);
		ret.add(lblImage);
		lblImage.setIcon(new javax.swing.ImageIcon(new Gestor().readimg(compra.getProyeccion().getPelicula().getImage())
				.getScaledInstance(80, 111, WIDTH)));

		JButton btnEliminarCompra = new JButton("");
		btnEliminarCompra.setBounds(540, 0, 60, 111);
		ret.add(btnEliminarCompra);
		btnEliminarCompra
				.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/BotonCross60x111.png")));
		btnEliminarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar la Compra  ", "",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (cart.getCompras().contains(compra)) {
						cart.getCompras().remove(compra);
						frame.dispose();
						ShoppingCart open = new ShoppingCart(sesiones, cart, null, index);
						open.setVisible(true);
					}
				}
			}
		});

		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTitle.setText(compra.getProyeccion().getPelicula().getTitulo());
		lblTitle.setBounds(88, 11, 300, 14);
		ret.add(lblTitle);

		JLabel lbl = new JLabel("Cantidad: ");
		lbl.setBounds(88, 49, 70, 14);
		lbl.setFont(new Font("Arial Black", Font.BOLD, 11));
		ret.add(lbl);

		JLabel lblCantidad = new JLabel("");
		lblCantidad.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCantidad.setText(compra.getCantidad() + "");
		lblCantidad.setBounds(156, 45, 46, 23);
		ret.add(lblCantidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPrecio.setText("Precio Unidad : " + compra.getProyeccion().getPrecio() + "" + "€");
		lblPrecio.setBounds(88, 78, 274, 14);
		ret.add(lblPrecio);
		return ret;

	}

	private JPanel panelShopCartIII(int dimension, Entrada compra, Carrito cart, Gestor con, ShoppingCart frame,

			ArrayList<Proyeccion> sesiones, int index) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(248, 212, 64));
		ret.setBounds(0, dimension, 600, 111);
		ret.setLayout(null);

		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new javax.swing.ImageIcon(new Gestor().readimg(compra.getProyeccion().getPelicula().getImage())
				.getScaledInstance(80, 111, WIDTH)));
		lblImage.setBounds(0, 0, 80, 111);
		ret.add(lblImage);

		JButton btnEliminarCompra = new JButton("");
		btnEliminarCompra
				.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/BotonCross60x111.png")));
		btnEliminarCompra.setBounds(540, 0, 60, 111);
		ret.add(btnEliminarCompra);
		btnEliminarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar la Compra  ", "",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					if (cart.getCompras().contains(compra)) {
						cart.getCompras().remove(compra);
						frame.dispose();
						ShoppingCart open = new ShoppingCart(sesiones, cart, null, index);
						open.setVisible(true);

					}

				}
			}
		});

		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTitle.setText(compra.getProyeccion().getPelicula().getTitulo());
		lblTitle.setBounds(88, 11, 300, 14);
		ret.add(lblTitle);

		JLabel lbl = new JLabel("Cantidad: ");
		lbl.setBounds(88, 49, 70, 14);
		lbl.setFont(new Font("Arial Black", Font.BOLD, 11));
		ret.add(lbl);

		JLabel lblCantidad = new JLabel("");
		lblCantidad.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCantidad.setText(compra.getCantidad() + "");
		lblCantidad.setBounds(156, 45, 46, 23);
		ret.add(lblCantidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPrecio.setText("Precio Unidad : " + compra.getProyeccion().getPrecio() + "" + "€");
		lblPrecio.setBounds(88, 78, 274, 14);
		ret.add(lblPrecio);
		return ret;

	}

	private JPanel panelShopCartIV(int dimension, Entrada compra, Carrito cart, Gestor con, ShoppingCart frame,

			ArrayList<Proyeccion> sesiones, int index) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(248, 212, 64));
		ret.setBounds(0, dimension, 600, 111);
		ret.setLayout(null);

		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new javax.swing.ImageIcon(new Gestor().readimg(compra.getProyeccion().getPelicula().getImage())
				.getScaledInstance(80, 111, WIDTH)));
		lblImage.setBounds(0, 0, 80, 111);
		ret.add(lblImage);

		JButton btnEliminarCompra = new JButton("");
		btnEliminarCompra
				.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/BotonCross60x111.png")));
		btnEliminarCompra.setBounds(540, 0, 60, 111);
		ret.add(btnEliminarCompra);
		btnEliminarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar la Compra  ", "",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					if (cart.getCompras().contains(compra)) {
						cart.getCompras().remove(compra);
						frame.dispose();
						ShoppingCart open = new ShoppingCart(sesiones, cart, null, index);
						open.setVisible(true);

					}

				}
			}
		});

		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblTitle.setText(compra.getProyeccion().getPelicula().getTitulo());
		lblTitle.setBounds(88, 11, 300, 14);
		ret.add(lblTitle);

		JLabel lbl = new JLabel("Cantidad: ");
		lbl.setBounds(88, 49, 70, 14);
		lbl.setFont(new Font("Arial Black", Font.BOLD, 11));
		ret.add(lbl);

		JLabel lblCantidad = new JLabel("");
		lblCantidad.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblCantidad.setText(compra.getCantidad() + "");
		lblCantidad.setBounds(156, 45, 46, 23);
		ret.add(lblCantidad);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblPrecio.setText("Precio Unidad : " + compra.getProyeccion().getPrecio() + "" + "€");
		lblPrecio.setBounds(88, 78, 274, 14);
		ret.add(lblPrecio);

		return ret;

	}

}
