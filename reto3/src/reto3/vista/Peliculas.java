package reto3.vista;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Peliculas extends JFrame {

	private JPanel contentPane;
	private JPanel panelDos;
	private JButton btnCarritoDeCompra;
	private JButton btnAtras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ArrayList<Proyeccion> sesiones = null;
		ArrayList<Factura> compras = null;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Peliculas frame = new Peliculas(sesiones, compras);
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
	public Peliculas(ArrayList<Proyeccion> sesiones, ArrayList<Factura> compras) {
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
				dispose();
				if (compras == null || compras.size() == 0) {
					msg = "0 compras!!";
					ShoppingCart open = new ShoppingCart(sesiones, compras, msg, 2);
					open.setVisible(true);
				} else {
					ShoppingCart shopCart = new ShoppingCart(sesiones, compras, null, 2);
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
				SeleccionCines open = new SeleccionCines(compras);
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
		panelDos.setPreferredSize(new Dimension(1931, 2000));
		panelDos.setLayout(null);
		new Gestor().addJpanelToPanelVentanaPelicula(panelDos, this, sesiones, compras);
		getContentPane().add(scrollPanel);

	}

}
