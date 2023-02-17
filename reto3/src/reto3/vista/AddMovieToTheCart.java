package reto3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.GestorProyeccion;

import reto3.bbdd.pojo.Entrada;

import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;

public class AddMovieToTheCart extends JFrame {

	private static final long serialVersionUID = -4470453863269260917L;
	private JPanel contentPane;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnAtras;
	private JLabel lblQuantity;
	private JButton btnAdd;
	private JPanel panel;

	public AddMovieToTheCart(Proyeccion sesion, Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 885, 547);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new javax.swing.ImageIcon(
				new Gestor().readimg(sesion.getPelicula().getImage()).getScaledInstance(316, 400, WIDTH)));
		lblImage.setBounds(55, 38, 316, 400);
		panel.add(lblImage);

		btnPlus = new JButton("+");
		btnPlus.setBackground(Color.WHITE);
		btnPlus.setForeground(Color.GREEN);
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 48));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesion, cart);
			}

		});
		btnPlus.setBounds(701, 166, 82, 59);
		panel.add(btnPlus);

		btnMinus = new JButton("-");
		btnMinus.setBackground(Color.WHITE);
		btnMinus.setForeground(Color.RED);
		btnMinus.setFont(new Font("Verdana", Font.BOLD, 75));
		btnMinus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesion, cart);
			}

		});
		btnMinus.setBounds(501, 166, 82, 59);
		panel.add(btnMinus);

		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAtras.setBackground(Color.WHITE);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesion, cart);
			}
		});
		btnAtras.setBounds(590, 471, 178, 46);
		panel.add(btnAtras);

		lblQuantity = new JLabel("quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblQuantity.setText("1");

		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(578, 101, 105, 25);
		panel.add(lblQuantity);

		btnAdd = new JButton("AÑADIR AL CARRITO");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBackground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesion, cart);
			}
		});
		btnAdd.setBounds(590, 404, 178, 46);
		panel.add(btnAdd);
	}

	private void cambiarPanel(ActionEvent e, Proyeccion sesion, Carrito cart) {

		if (e.getSource() == btnPlus) {
			int cantidad = Integer.parseInt(lblQuantity.getText().toString());
			lblQuantity.setText(new Gestor().quantityNowPlus(cantidad) + "");
		}
		if (e.getSource() == btnMinus) {
			if (Integer.parseInt(lblQuantity.getText().toString()) == 1) {

			} else {
				int cantidad = Integer.parseInt(lblQuantity.getText().toString());
				lblQuantity.setText(new Gestor().quantityNowMinus(cantidad) + "");
			}
		}
		if (e.getSource() == btnAtras) {
			panel.setVisible(false);
			dispose();
			GestorProyeccion gestorProyeccion = new GestorProyeccion();
			ElegirHora elegirHora = new ElegirHora(gestorProyeccion.getProyeccionByDate(sesion.getPelicula().getId(),
					new Gestor().convertToLocalDateViaInstant(sesion.getFecha()), sesion.getSala().getCine().getId()),
					cart);
			elegirHora.setVisible(true);
		}
		if (e.getSource() == btnAdd) {
			if ((!cart.isEmpty()) && (cart.getCompras().size()) == 4) {

				JOptionPane.showMessageDialog(null, "NO puedes realizar mas de 4 compras  !!!");
				panel.setVisible(false);
				dispose();
				SeleccionCines open = new SeleccionCines(cart);
				open.setVisible(true);

			} else {

				Entrada compra = new Entrada();

				compra.setCantidad(Integer.parseInt(lblQuantity.getText()));
				compra.setProyeccion(sesion);
				compra.setPrecio(sesion.getPrecio() * compra.getCantidad());

				cart.addEntrada(compra);
				JOptionPane.showMessageDialog(null,
						"Operación realizada correctamente, has seleccionado " + sesion.getPelicula().getTitulo() + "\n"

								+ new Gestor().setDateOfTheDay(sesion.getFecha()) + "\nhora: "
								+ new Gestor().getTime(sesion.getHora()) + "\nSala:" + sesion.getSala().getNombre());
				panel.setVisible(false);
				dispose();
				SeleccionCines open = new SeleccionCines(cart);
				open.setVisible(true);
			}
		}

	}

}
