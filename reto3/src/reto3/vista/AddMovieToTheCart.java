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
import javax.swing.ImageIcon;

public class AddMovieToTheCart extends JFrame {

	private static final long serialVersionUID = -4470453863269260917L;
	private JPanel contentPaneAddMovie;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnAtras;
	private JLabel lblQuantity;
	private JButton btnAdd;
	private JPanel panel;
	private JPanel jPanelBarraSuperior;
	private JButton btnAtras_1;
	private JLabel lblNewLabel;
	private JLabel lblSeleccioneLaCantidad;
	private JLabel lblNewLabel_1;

	public AddMovieToTheCart(Proyeccion sesion, Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPaneAddMovie = new JPanel();
		contentPaneAddMovie.setBackground(new Color(33, 18, 97));
		contentPaneAddMovie.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); // Desativado la redimenzionalidad
		setLocationRelativeTo(null); // Posicionamiento central de la pantalla

		setContentPane(contentPaneAddMovie);
		contentPaneAddMovie.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(33, 18, 97));
		panel.setBounds(0, 50, 1207, 563);
		contentPaneAddMovie.add(panel);
		panel.setLayout(null);

		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new javax.swing.ImageIcon(
				new Gestor().readimg(sesion.getPelicula().getImage()).getScaledInstance(316, 400, WIDTH)));
		lblImage.setBounds(104, 81, 330, 400);
		panel.add(lblImage);

		btnPlus = new JButton("");
		btnPlus.setIcon(new ImageIcon(AddMovieToTheCart.class.getResource("/reto3/vista/imagenes/BotonMas90x50.png")));
		btnPlus.setBackground(Color.WHITE);
		btnPlus.setForeground(Color.GREEN);
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 48));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesion, cart);
			}

		});
		btnPlus.setBounds(862, 262, 90, 50);
		panel.add(btnPlus);

		btnMinus = new JButton("");
		btnMinus.setIcon(new ImageIcon(AddMovieToTheCart.class.getResource("/reto3/vista/imagenes/BotonMenos90x50.png")));
		btnMinus.setBackground(Color.WHITE);
		btnMinus.setForeground(Color.RED);
		btnMinus.setFont(new Font("Arial Black", Font.BOLD, 30));
		btnMinus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesion, cart);
			}

		});
		btnMinus.setBounds(662, 262, 90, 50);
		panel.add(btnMinus);

		lblQuantity = new JLabel("quantity");
		lblQuantity.setForeground(new Color(255, 255, 255));
		lblQuantity.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblQuantity.setText("1");

		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(762, 262, 90, 50);
		panel.add(lblQuantity);

		btnAdd = new JButton("AÑADIR AL CARRITO");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Arial Black", Font.BOLD, 30));
		btnAdd.setBackground(new Color(0, 0, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesion, cart);
			}
		});
		btnAdd.setBounds(568, 358, 500, 50);
		panel.add(btnAdd);
		
		lblSeleccioneLaCantidad = new JLabel("SELECCIONE LA CANTIDAD DESEADA");
		lblSeleccioneLaCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneLaCantidad.setForeground(Color.WHITE);
		lblSeleccioneLaCantidad.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblSeleccioneLaCantidad.setBounds(460, 128, 709, 50);
		panel.add(lblSeleccioneLaCantidad);
		
		lblNewLabel_1 = new JLabel("(HAGA CLICK SOBRE EL MAS O MENOS)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(248, 212, 64));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(537, 175, 570, 29);
		panel.add(lblNewLabel_1);

		jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setLayout(null);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		contentPaneAddMovie.add(jPanelBarraSuperior);

		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(AddMovieToTheCart.class.getResource("/reto3/vista/imagenes/BotonAtras90x50.png")));
		btnAtras.setBounds(29, 0, 90, 50);
		jPanelBarraSuperior.add(btnAtras);
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAtras.setBackground(Color.WHITE);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddMovieToTheCart.class.getResource("/reto3/vista/imagenes/Footer.png")));
		lblNewLabel.setBounds(0, 611, 1207, 50);
		contentPaneAddMovie.add(lblNewLabel);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarPanel(e, sesion, cart);
			}
		});

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

				JOptionPane.showMessageDialog(null, "NO puedes realizar mas de 4 compras a la vez !!!");
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
