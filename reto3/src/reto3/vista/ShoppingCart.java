package reto3.vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import java.awt.Color;

public class ShoppingCart extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblTitle;
	private JButton btnAtras;
	private JButton btnComprar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<Proyeccion> sesiones = null;
		ArrayList<Factura> compras = null;
		String message = null;
		int index = 0;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShoppingCart frame = new ShoppingCart(sesiones, compras, message, index);
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
	public ShoppingCart(ArrayList<Proyeccion> sesiones, ArrayList<Factura> compras, String message, int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 488, 605);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMessage = new JLabel("");
		if (message != null) {
			lblMessage.setText(message);
		}
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMessage.setBounds(99, 172, 308, 52);
		panel.add(lblMessage);

		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesiones, compras, index);
			}
		});
		btnAtras.setBounds(27, 556, 119, 38);
		panel.add(btnAtras);

		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(359, 556, 119, 38);
		panel.add(btnComprar);

		JLabel lblPrecioTot = new JLabel("");
		String precioTotal = new Gestor().calculateTotalPrice(compras);

		lblPrecioTot.setText("PRECIO TOTAL: " + precioTotal + "€");
		lblPrecioTot.setForeground(Color.BLUE);
		lblPrecioTot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioTot.setBounds(203, 508, 275, 24);
		panel.add(lblPrecioTot);

		JLabel lbldescount = new JLabel("");
		if (new Gestor().calculateQuantity(compras) != 1) {
			lbldescount.setText("DESCUENTO % : " + " " + (new Gestor().descuento(compras) * 100) + "" + "%");
			lbldescount.setForeground(Color.RED);
			lbldescount.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		lbldescount.setBounds(203, 473, 275, 24);
		panel.add(lbldescount);
		if (compras != null) {
			Gestor gestor = new Gestor();
			gestor.addJpanelToPanelShoppingCart(panel, this, compras, sesiones, index);
		}
	}

	private void cambiarPanel(ActionEvent e, ArrayList<Proyeccion> sesiones, ArrayList<Factura> compras, int index) {

		if (e.getSource() == btnAtras) {
			if (index == 1) {
				this.dispose();
				panel.setVisible(true);
				SeleccionCines seleccionCine = new SeleccionCines(compras);
				seleccionCine.setVisible(true);
			} else {
				this.dispose();
				panel.setVisible(true);
				Peliculas open = new Peliculas(sesiones, compras);
				open.setVisible(true);
			}
		}
		if (e.getSource() == btnComprar) {

		}
	}

}
