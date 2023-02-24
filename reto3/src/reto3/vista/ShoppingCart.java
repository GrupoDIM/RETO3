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
import javax.swing.ImageIcon;

public class ShoppingCart extends JFrame {

	private static final long serialVersionUID = 228090564170995944L;

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAtras;
	private JButton btnComprar;
	private Gestor gestor = new Gestor();

	public ShoppingCart(ArrayList<Proyeccion> sesiones, Carrito cart, String message, int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 18, 97));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); // Desativado la redimenzionalidad
		setLocationRelativeTo(null); // Posicionamiento central de la pantalla

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(33, 18, 97));
		panel.setBounds(303, 80, 600, 500);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMessage = new JLabel("");
		lblMessage.setForeground(new Color(255, 255, 255));
		if (message != null) {
			lblMessage.setText(message);
		}
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblMessage.setBounds(0, 200, 600, 100);
		panel.add(lblMessage);

		

		JLabel lbldescount = new JLabel("");
		lbldescount.setFont(new Font("Arial Black", Font.BOLD, 14));
		lbldescount.setHorizontalAlignment(SwingConstants.CENTER);

		lbldescount.setBounds(0, 449, 600, 24);
		panel.add(lbldescount);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/Footer.png")));
		lblNewLabel.setBounds(0, 611, 1207, 50);
		contentPane.add(lblNewLabel);

		JPanel jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setLayout(null);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		contentPane.add(jPanelBarraSuperior);


		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/BotonAtras90x50.png")));
		btnAtras.setBounds(29, 0, 90, 50);
		btnAtras.setBackground(Color.WHITE);
		jPanelBarraSuperior.add(btnAtras);
		
				btnComprar = new JButton("COMPRAR");
				btnComprar.setBounds(1046, 0, 130, 50);
				jPanelBarraSuperior.add(btnComprar);
				btnComprar.setBackground(new Color(0, 0, 0));
				btnComprar.setForeground(new Color(255, 255, 255));
				btnComprar.setFont(new Font("Arial Black", Font.BOLD, 14));
				btnComprar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cart.size() == 0) {
							JOptionPane.showMessageDialog(null, "Para Comprar debe seleccionar alguna Pelicula!!");
						} else {
							cambiarPanel(e, sesiones, cart, index);
						}
					}
				});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesiones, cart, index);
			}
		});
		
		JLabel lblPrecioTot = new JLabel("");
		lblPrecioTot.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioTot.setForeground(new Color(255, 255, 255));
		lblPrecioTot.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblPrecioTot.setBounds(0, 468, 600, 32);
		panel.add(lblPrecioTot);
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
