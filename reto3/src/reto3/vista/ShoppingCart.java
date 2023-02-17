package reto3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;

public class ShoppingCart extends JFrame {

	private static final long serialVersionUID = 228090564170995944L;

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAtras;
	private JButton btnComprar;
	private Gestor gestor = new Gestor();

	public ShoppingCart(ArrayList<Proyeccion> sesiones, Carrito cart, String message, int index) {
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
				cambiarPanel(e, sesiones, cart, index);
			}
		});
		btnAtras.setBounds(27, 556, 119, 38);
		panel.add(btnAtras);

		btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cart.size() == 0) {
					JOptionPane.showMessageDialog(null, "Para Comprar debe seleccionar alguna Pelicula!!");
				} else {
					cambiarPanel(e, sesiones, cart, index);
				}
			}
		});
		btnComprar.setBounds(359, 556, 119, 38);
		panel.add(btnComprar);

		JLabel lblPrecioTot = new JLabel("");
		lblPrecioTot.setForeground(Color.BLUE);
		lblPrecioTot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioTot.setBounds(203, 508, 275, 24);
		panel.add(lblPrecioTot);

		JLabel lbldescount = new JLabel("");

		lbldescount.setBounds(203, 473, 275, 24);
		panel.add(lbldescount);
		if (!cart.isEmpty()) {
			gestor.addJpanelToPanelShoppingCart(panel, this, cart, sesiones, index);
			String precioTotal = gestor.calculateTotalPrice(cart);
			lblPrecioTot.setText("PRECIO TOTAL: " + precioTotal + "€");
			if (gestor.calculateQuantity(cart) != 1) {
				lbldescount.setText("DESCUENTO % : " + " " + (gestor.descuento(cart) * 100) + "" + "%");
				lbldescount.setForeground(Color.RED);
				lbldescount.setFont(new Font("Tahoma", Font.BOLD, 16));
			}

		}

	}

	private void cambiarPanel(ActionEvent e, ArrayList<Proyeccion> sesiones, Carrito cart, int index) {

		if (e.getSource() == btnAtras) {
			if (index == 1) {
				this.dispose();
				panel.setVisible(true);
				SeleccionCines seleccionCine = new SeleccionCines(cart);
				seleccionCine.setVisible(true);
			} else {
				this.dispose();
				panel.setVisible(true);
				Peliculas open = new Peliculas(sesiones, cart);
				open.setVisible(true);
			}
		}
		if (e.getSource() == btnComprar) {
			Gestor gestor = new Gestor();
			Factura factura = new Factura();
			factura.setDescuento(gestor.descuento(cart));
			factura.setCantidad(gestor.calculateQuantity(cart));
			double precio = Double.parseDouble(gestor.calculateTotalPrice(cart).replace(",", "."));
			factura.setPrecioTotal(precio);
			cart.getCompras().get(0).setFactura(factura);
			Login login = new Login(cart);
			dispose();
			panel.setVisible(false);
			login.setVisible(true);
		}
	}

}
