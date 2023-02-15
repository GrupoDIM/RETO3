package reto3.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;

public class Peliculas extends JFrame {

	private static final long serialVersionUID = -3686762417105825415L;
	private JPanel contentPane;
	private JPanel panelDos;
	private JButton btnCarritoDeCompra;
	private JButton btnAtras;

	public Peliculas(ArrayList<Proyeccion> sesiones, Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 212, 64));
		panel.setBounds(0, 0, 1207, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		btnCarritoDeCompra = new JButton("");
		btnCarritoDeCompra.setForeground(new Color(255, 255, 255));
		btnCarritoDeCompra.setBackground(new Color(255, 255, 255));
		btnCarritoDeCompra.setIcon(new ImageIcon(Peliculas.class.getResource("/reto3/vista/imagenes/shCart.png")));
		btnCarritoDeCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = null;
				if (cart.isEmpty()) {
					msg = "0 compras!!";
					ShoppingCart open = new ShoppingCart(sesiones, new Carrito(), msg, 2);
					dispose();
					open.setVisible(true);
				} else {
					ShoppingCart shopCart = new ShoppingCart(sesiones, cart, null, 2);
					dispose();
					shopCart.setVisible(true);
				}

			}
		});
		btnCarritoDeCompra.setBounds(1060, 32, 73, 57);
		panel.add(btnCarritoDeCompra);

		btnAtras = new JButton("ATRAS");
		btnAtras.setBackground(Color.WHITE);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SeleccionCines open = new SeleccionCines(cart);
				open.setVisible(true);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtras.setBounds(29, 47, 144, 42);
		panel.add(btnAtras);

		panelDos = new JPanel();
		panelDos.setBackground(Color.WHITE);
		final JScrollPane scrollPanel = new JScrollPane(panelDos, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPanel.setBounds(0, 141, 1207, 520);
		panelDos.setBounds(0, 0, 1920, 1080);
		panelDos.setPreferredSize(new Dimension(1931, 3000));
		panelDos.setLayout(null);
		new Gestor().addJpanelToPanelVentanaPelicula(panelDos, this, sesiones, cart);
		getContentPane().add(scrollPanel);

	}

}
