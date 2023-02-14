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

public class SeleccionCines extends JFrame {

	private static final long serialVersionUID = -1525562907814196106L;

	private JPanel contentPane;
	private JTextField txtSele;
	private JButton btnCineBallonti;
	private JButton btnCineYelmoArtea;
	private JButton btnCineBarakaldo;
	private JButton btnCarritoDeCompra;

	public SeleccionCines(Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 212, 64));
		panel.setBounds(0, 0, 1207, 72);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnInicio = new JButton("FINALIZAR");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cart.isEmpty()) {
					Bienvenida bienvenida = new Bienvenida();
					dispose();
					bienvenida.frame.setVisible(true);
				}
			}
		});
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnInicio.setBackground(new Color(0, 0, 0));
		btnInicio.setBounds(10, 11, 132, 50);
		panel.add(btnInicio);

		btnCarritoDeCompra = new JButton("");
		btnCarritoDeCompra.setForeground(new Color(255, 255, 255));
		btnCarritoDeCompra.setBackground(new Color(255, 255, 255));
		btnCarritoDeCompra.setIcon(new ImageIcon(Peliculas.class.getResource("/reto3/vista/imagenes/shCart.png")));
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
		btnCarritoDeCompra.setBounds(1060, 0, 73, 72);
		panel.add(btnCarritoDeCompra);

		JPanel panelUno = new JPanel();
		panelUno.setBackground(new Color(33, 18, 97));
		panelUno.setBounds(0, 35, 1207, 626);
		contentPane.add(panelUno);
		panelUno.setLayout(null);

		txtSele = new JTextField();
		txtSele.setForeground(new Color(255, 255, 255));
		txtSele.setBackground(new Color(33, 18, 97));
		txtSele.setHorizontalAlignment(SwingConstants.CENTER);
		txtSele.setText("Seleccione un cine:");
		txtSele.setFont(new Font("Arial Black", Font.PLAIN, 30));
		txtSele.setBounds(180, 54, 846, 78);
		panelUno.add(txtSele);
		txtSele.setColumns(10);

		btnCineBarakaldo = new JButton("CINESA MAX OCIO");
		btnCineBarakaldo.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCineBarakaldo.setBackground(Color.WHITE);
		btnCineBarakaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, cart);
			}
		});
		btnCineBarakaldo.setBounds(476, 259, 272, 188);
		panelUno.add(btnCineBarakaldo);

		btnCineYelmoArtea = new JButton("YELMO PREMIUM ARTEA");
		btnCineYelmoArtea.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCineYelmoArtea.setBackground(Color.WHITE);
		btnCineYelmoArtea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, cart);
			}
		});
		btnCineYelmoArtea.setBounds(842, 259, 269, 188);
		panelUno.add(btnCineYelmoArtea);

		btnCineBallonti = new JButton("DOCK CINE");
		btnCineBallonti.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCineBallonti.setBackground(Color.WHITE);
		btnCineBallonti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, cart);
			}
		});
		btnCineBallonti.setBounds(156, 259, 269, 188);
		panelUno.add(btnCineBallonti);
	}

	private void cambiarPanel(ActionEvent e, Carrito cart) {
		int id;
		GestorProyeccion gestor = new GestorProyeccion();
		if (e.getSource() == btnCineBarakaldo) {
			id = 3;

			Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(id), cart);
			dispose();
			open.setVisible(true);
		}
		if (e.getSource() == btnCineYelmoArtea) {
			id = 2;

			Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(id), cart);
			dispose();
			open.setVisible(true);

		}
		if (e.getSource() == btnCineBallonti) {
			id = 4;

			Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(id), cart);
			dispose();
			open.setVisible(true);
		}
	}

}
