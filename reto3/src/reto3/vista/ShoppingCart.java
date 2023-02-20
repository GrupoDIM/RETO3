package reto3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;
import javax.swing.ImageIcon;

public class ShoppingCart extends JFrame {

	private static final long serialVersionUID = 228090564170995944L;

	private JPanel contentPaneShopping;
	private JPanel panel;
	private JButton btnAtras;
	private JButton btnComprar;
	private Gestor gestor = new Gestor();
	private JLabel lblNewLabel;
	private JPanel jPanelBarraSuperior;

	public ShoppingCart(ArrayList<Proyeccion> sesiones, Carrito cart, String message, int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPaneShopping = new JPanel();
		contentPaneShopping.setBackground(new Color(33, 18, 97));
		contentPaneShopping.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); // Desativado la redimenzionalidad
		setLocationRelativeTo(null); // Posicionamiento central de la pantalla

		setContentPane(contentPaneShopping);
		contentPaneShopping.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(33, 18, 97));
		panel.setBounds(0, 50, 1207, 561);
		contentPaneShopping.add(panel);
		panel.setLayout(null);

		JLabel lblMessage = new JLabel("");
		if (message != null) {
			lblMessage.setText(message);
		}
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMessage.setBounds(99, 172, 308, 52);
		panel.add(lblMessage);

		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(359, 500, 119, 38);
		panel.add(btnComprar);

		JLabel lblPrecioTot = new JLabel("");
		lblPrecioTot.setForeground(Color.BLUE);
		lblPrecioTot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioTot.setBounds(203, 450, 275, 24);
		panel.add(lblPrecioTot);

		JLabel lbldescount = new JLabel("");

		lbldescount.setBounds(203, 430, 275, 24);
		panel.add(lbldescount);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/Footer.png")));
		lblNewLabel.setBounds(0, 611, 1207, 50);
		contentPaneShopping.add(lblNewLabel);
		
		jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setLayout(null);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		contentPaneShopping.add(jPanelBarraSuperior);
		
				btnAtras = new JButton("");
				btnAtras.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/BotonAtras90x50.png")));
				btnAtras.setBounds(34, 0, 90, 50);
				jPanelBarraSuperior.add(btnAtras);
				btnAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cambiarPanel(e, sesiones, cart, index);
					}
				});
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

		}
	}

}
