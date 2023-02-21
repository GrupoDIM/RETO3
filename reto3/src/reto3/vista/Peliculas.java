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
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Peliculas extends JFrame {

	private static final long serialVersionUID = -3686762417105825415L;
	private JPanel contentPanePeliculas;
	private JPanel jPanelListadoPeliculas;
	private JButton btnCarritoDeCompra;
	private JButton btnAtras;
	private JPanel jPanelCentral;
	private JLabel lblNewLabel_1;

	public Peliculas(ArrayList<Proyeccion> sesiones, Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPanePeliculas = new JPanel();
		contentPanePeliculas.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		setContentPane(contentPanePeliculas);
		contentPanePeliculas.setLayout(null);

		JPanel jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		contentPanePeliculas.add(jPanelBarraSuperior);
		jPanelBarraSuperior.setLayout(null);
		
		btnCarritoDeCompra = new JButton("");
		btnCarritoDeCompra.setForeground(new Color(255, 255, 255));
		btnCarritoDeCompra.setBackground(new Color(255, 255, 255));
		btnCarritoDeCompra.setIcon(new ImageIcon(Peliculas.class.getResource("/reto3/vista/imagenes/BotonResumen90x50.png")));
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
		btnCarritoDeCompra.setBounds(1091, 0, 90, 50);
		jPanelBarraSuperior.add(btnCarritoDeCompra);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(Peliculas.class.getResource("/reto3/vista/imagenes/BotonAtras90x50.png")));
		btnAtras.setForeground(new Color(255, 255, 255));
		btnAtras.setBackground(new Color(0, 0, 0));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SeleccionCines open = new SeleccionCines(cart);
				open.setVisible(true);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAtras.setBounds(24, 0, 90, 50);
		jPanelBarraSuperior.add(btnAtras);

		jPanelListadoPeliculas = new JPanel();
		jPanelListadoPeliculas.setForeground(Color.WHITE);
		jPanelListadoPeliculas.setBackground(new Color(33, 18, 97));
		final JScrollPane jScrollPanelListadoPeliculas = new JScrollPane(jPanelListadoPeliculas, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPanelListadoPeliculas.setBounds(53, 150, 1100, 400);
		jPanelListadoPeliculas.setBounds(0, 0, 1920, 1080);
		jPanelListadoPeliculas.setPreferredSize(new Dimension(1080, 3201));
		jPanelListadoPeliculas.setLayout(null);
		new Gestor().addJpanelToPanelVentanaPelicula(jPanelListadoPeliculas, this, sesiones, cart);
		getContentPane().add(jScrollPanelListadoPeliculas);
		
		jPanelCentral = new JPanel();
		jPanelCentral.setBackground(new Color(33, 18, 97));
		jPanelCentral.setBounds(0, 48, 1207, 613);
		contentPanePeliculas.add(jPanelCentral);
		jPanelCentral.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 212, 64));
		panel.setBounds(0, 563, 1207, 50);
		jPanelCentral.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Peliculas.class.getResource("/reto3/vista/imagenes/Footer.png")));
		lblNewLabel.setBounds(0, 0, 1207, 50);
		panel.add(lblNewLabel);
		
		JLabel lblSelecioneUnaPelicula = new JLabel("SELECIONE UNA PELICULA:");
		lblSelecioneUnaPelicula.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneUnaPelicula.setForeground(Color.WHITE);
		lblSelecioneUnaPelicula.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblSelecioneUnaPelicula.setBounds(326, 27, 555, 41);
		jPanelCentral.add(lblSelecioneUnaPelicula);
		
		lblNewLabel_1 = new JLabel("(HAGA CLICK SOBRE LA IMAGEN DESEADA)");
		lblNewLabel_1.setForeground(new Color(248, 212, 64));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(318, 64, 570, 29);
		jPanelCentral.add(lblNewLabel_1);

	}
}
