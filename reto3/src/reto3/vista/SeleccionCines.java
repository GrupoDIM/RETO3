package reto3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.GestorProyeccion;
import reto3.controlador.Cart.Carrito;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class SeleccionCines extends JFrame {

	private static final long serialVersionUID = -1525562907814196106L;

	private JPanel jPanelSelecionCines;
	private JButton jButtonCineArteaId4;
	private JButton jButtonCineMegaparkId2;
	private JButton jButtonCineZubiarteId3;
	private JButton btnCarritoDeCompra;

	public SeleccionCines(Carrito cart) {
		// JPANEL PRINCIPAL | PROPIEDADE GENERALES
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		jPanelSelecionCines = new JPanel();
		jPanelSelecionCines.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); // Desativado la redimenzionalidad
		setLocationRelativeTo(null); // Posicionamiento central de la pantalla
		getContentPane().setLayout(null);

		setContentPane(jPanelSelecionCines);
		jPanelSelecionCines.setLayout(null);

		// JPANEL | BARRA SUPERIOR "AMARILLO"
		JPanel jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		jPanelSelecionCines.add(jPanelBarraSuperior);
		jPanelBarraSuperior.setLayout(null);

		// JBUTTON | BOTON DE "INICIO"
		JButton btnInicio = new JButton("");
		btnInicio.setIcon(new ImageIcon(SeleccionCines.class.getResource("/reto3/vista/imagenes/BotonInicio90x50.png")));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnInicio.setBackground(new Color(0, 0, 0));
		btnInicio.setBounds(10, 0, 90, 50);
		jPanelBarraSuperior.add(btnInicio);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cart.isEmpty()) {
					Bienvenida bienvenida = new Bienvenida();
					dispose();
					bienvenida.frame.setVisible(true);
				}
			}
		});

		// JBUTTON | BOTON DE
		btnCarritoDeCompra = new JButton("");
		btnCarritoDeCompra.setForeground(new Color(255, 255, 255));
		btnCarritoDeCompra.setBackground(new Color(255, 255, 255));
		btnCarritoDeCompra.setBounds(1107, 0, 90, 50);
		jPanelBarraSuperior.add(btnCarritoDeCompra);
		btnCarritoDeCompra
				.setIcon(new ImageIcon(SeleccionCines.class.getResource("/reto3/vista/imagenes/BotonResumen90x50.png")));
		btnCarritoDeCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = null;
				dispose();
				if (cart.isEmpty()) {
					msg = "0 compras!!";
					ShoppingCart open = new ShoppingCart(null, cart, msg, 1);
					dispose();
					open.setVisible(true);
				} else {
					ShoppingCart shopCart = new ShoppingCart(null, cart, null, 1);
					dispose();
					shopCart.setVisible(true);
				}

			}
		});

		// JPANEL | PANEL DE "CINES"
		JPanel jPanelCines = new JPanel();
		jPanelCines.setBackground(new Color(33, 18, 97));
		jPanelCines.setBounds(0, 48, 1207, 613);
		jPanelSelecionCines.add(jPanelCines);
		jPanelCines.setLayout(null);

		// JBUTTON | CINE "ZUBIARTE" | CINE_ID = 3
		jButtonCineZubiarteId3 = new JButton("ZUBIARTE");
		jButtonCineZubiarteId3.setForeground(new Color(255, 255, 255));
		jButtonCineZubiarteId3.setFont(new Font("Arial Black", Font.BOLD, 20));
		jButtonCineZubiarteId3.setBackground(new Color(0, 0, 0));
		jButtonCineZubiarteId3.setBounds(738, 29, 183, 40);
		jPanelCines.add(jButtonCineZubiarteId3);
		jButtonCineZubiarteId3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, cart);
			}
		});

		// JBUTTON | CINE "MEGAPARK" | CINE_ID = 2
		jButtonCineMegaparkId2 = new JButton("MEGAPARK");
		jButtonCineMegaparkId2.setForeground(new Color(255, 255, 255));
		jButtonCineMegaparkId2.setFont(new Font("Arial Black", Font.BOLD, 20));
		jButtonCineMegaparkId2.setBackground(new Color(0, 0, 0));
		jButtonCineMegaparkId2.setBounds(528, 29, 183, 40);
		jPanelCines.add(jButtonCineMegaparkId2);
		jButtonCineMegaparkId2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, cart);
			}
		});

		// JBUTTON | CINE "ARTEA" | CINE_ID = 4
		jButtonCineArteaId4 = new JButton("ARTEA");
		jButtonCineArteaId4.setForeground(new Color(255, 255, 255));
		jButtonCineArteaId4.setFont(new Font("Arial Black", Font.BOLD, 20));
		jButtonCineArteaId4.setBackground(new Color(0, 0, 0));
		jButtonCineArteaId4.setBounds(946, 29, 183, 40);
		jPanelCines.add(jButtonCineArteaId4);
		jButtonCineArteaId4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, cart);
			}
		});

		// JLABEL | "SELECIONE UN CINE"
		JLabel jLabelSelecioneUnCine = new JLabel("SELECCIONE UN CINE:");
		jLabelSelecioneUnCine.setForeground(new Color(255, 255, 255));
		jLabelSelecioneUnCine.setFont(new Font("Arial Black", Font.BOLD, 30));
		jLabelSelecioneUnCine.setBounds(59, 29, 415, 41);
		jPanelCines.add(jLabelSelecioneUnCine);

		// 
		JPanel jPanelEstrenos = new JPanel();
		jPanelEstrenos.setBackground(new Color(0, 0, 0));
		jPanelEstrenos.setBounds(0, 106, 1207, 400);
		jPanelCines.add(jPanelEstrenos);
		jPanelEstrenos.setLayout(null);

		JLabel jLabelEstrenos = new JLabel("");
		jLabelEstrenos.setFont(new Font("Arial Black", Font.PLAIN, 11));
		jLabelEstrenos.setIcon(
				new ImageIcon(SeleccionCines.class.getResource("/reto3/vista/imagenes/EstrenosPortadasRuleta.gif")));
		jLabelEstrenos.setBounds(0, 0, 1200, 400);
		jPanelEstrenos.add(jLabelEstrenos);

		JLabel jLabelPiePagina = new JLabel("");
		jLabelPiePagina.setIcon(new ImageIcon(SeleccionCines.class.getResource("/reto3/vista/imagenes/Footer.png")));
		jLabelPiePagina.setBounds(0, 563, 1207, 50);
		jPanelCines.add(jLabelPiePagina);

	}

	// METODO | CAMBIAR DE PANEL EN FUNCION DE JBUTTON DE CINE
	private void cambiarPanel(ActionEvent e, Carrito cart) {
		int id;
		GestorProyeccion gestor = new GestorProyeccion();
		if (e.getSource() == jButtonCineZubiarteId3) {
			id = 3;

			Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(id), cart);
			dispose();
			open.setVisible(true);
		}
		if (e.getSource() == jButtonCineMegaparkId2) {
			id = 2;

			Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(id), cart);
			dispose();
			open.setVisible(true);

		}
		if (e.getSource() == jButtonCineArteaId4) {
			id = 4;

			Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(id), cart);
			dispose();
			open.setVisible(true);
		}
	}
}
