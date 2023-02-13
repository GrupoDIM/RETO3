package reto3.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.pojo.Cine;
import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Connection;
import reto3.controlador.Gestor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class SeleccionCines extends JFrame {

	private JPanel contentPane;
	private JTextField txtSele;
	private JButton btnCineBallonti;
	private JButton btnCineYelmoArtea;
	private JButton btnCineBarakaldo;
	private JButton btnCarritoDeCompra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<Factura> compras = null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionCines frame = new SeleccionCines(compras);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeleccionCines(ArrayList<Factura> compras) {
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
				if (compras == null || compras.size() == 0) {
					System.exit(0);
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
				if (compras == null || compras.size() == 0) {
					msg = "Usted Ha realizado 0 compras!!";
					ShoppingCart open = new ShoppingCart(null, compras, msg, 1);
					open.setVisible(true);
				} else {
					ShoppingCart shopCart = new ShoppingCart(null, compras, null, 1);
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
				cambiarPanel(e, compras);
			}
		});
		btnCineBarakaldo.setBounds(476, 259, 272, 188);
		panelUno.add(btnCineBarakaldo);

		btnCineYelmoArtea = new JButton("YELMO PREMIUM ARTEA");
		btnCineYelmoArtea.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCineYelmoArtea.setBackground(Color.WHITE);
		btnCineYelmoArtea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, compras);
			}
		});
		btnCineYelmoArtea.setBounds(842, 259, 269, 188);
		panelUno.add(btnCineYelmoArtea);

		btnCineBallonti = new JButton("DOCK CINE");
		btnCineBallonti.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCineBallonti.setBackground(Color.WHITE);
		btnCineBallonti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, compras);
			}
		});
		btnCineBallonti.setBounds(156, 259, 269, 188);
		panelUno.add(btnCineBallonti);
	}

	private void cambiarPanel(ActionEvent e, ArrayList<Factura> compras) {
		int id = 0;
		Connection con = new Connection();
		if (e.getSource() == btnCineBarakaldo) {
			id = 3;
			dispose();
			Peliculas open = new Peliculas(con.getProyeccionByIdCine(3), compras);
			open.setVisible(true);
		}
		if (e.getSource() == btnCineYelmoArtea) {
			id = 2;
			dispose();
			Peliculas open = new Peliculas(con.getProyeccionByIdCine(2), compras);
			open.setVisible(true);

		}
		if (e.getSource() == btnCineBallonti) {
			id = 4;
			dispose();
			Peliculas open = new Peliculas(con.getProyeccionByIdCine(4), compras);
			open.setVisible(true);
		}
	}

}
