package reto3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.GestorPelicula;

import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;

public class ElegirHora extends JFrame {

	private static final long serialVersionUID = 4822076674316770008L;
	private JPanel contentPane;
	private JPanel panel;

	public ElegirHora(ArrayList<Proyeccion> sesiones, Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 813, 517);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblImagen = new JLabel("Image");
		lblImagen.setIcon(new javax.swing.ImageIcon(
				new Gestor().readimg(sesiones.get(0).getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		lblImagen.setBounds(45, 25, 248, 306);
		panel.add(lblImagen);

		JLabel lblTitle = new JLabel("title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblTitle.setText(sesiones.get(0).getPelicula().getTitulo());
		lblTitle.setBounds(303, 47, 500, 32);
		panel.add(lblTitle);

		JLabel lblGenero = new JLabel("genero");
		lblGenero.setText(sesiones.get(0).getPelicula().getGenero());
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 16));

		lblGenero.setText(sesiones.get(0).getPelicula().getGenero());

		lblGenero.setBounds(300, 111, 438, 32);
		panel.add(lblGenero);

		JLabel lblDuracion = new JLabel("duracion");
		lblDuracion.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDuracion.setText(sesiones.get(0).getPelicula().getDuracion() + "" + "min");
		lblDuracion.setBounds(303, 158, 105, 24);
		panel.add(lblDuracion);

		JLabel lblIconCalificacion = new JLabel("New label");
		lblIconCalificacion
				.setIcon(new ImageIcon(ElegirHora.class.getResource("/reto3/vista/imagenes/2107957 (1).png")));
		lblIconCalificacion.setBounds(675, 11, 46, 46);
		panel.add(lblIconCalificacion);

		JLabel lblCalificacion = new JLabel("New label");
		lblCalificacion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCalificacion.setText(sesiones.get(0).getPelicula().getCalificacion() + "");
		lblCalificacion.setBounds(734, 25, 46, 24);
		panel.add(lblCalificacion);

		JLabel lblPrecio = new JLabel("New label");
		lblPrecio.setText("Precio : " + sesiones.get(0).getPrecio() + "" + "€");
		lblPrecio.setForeground(new Color(0, 255, 0));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPrecio.setBounds(317, 256, 144, 24);
		panel.add(lblPrecio);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(668, 454, 124, 39);
		panel.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion fechaYSesion = new PantallaFechaYSesion(
						gestorPelicula.getFechasDeUnaPelicula(sesiones.get(0).getPelicula().getId(),
								sesiones.get(0).getSala().getCine().getId()),
						sesiones.get(0), cart);
				fechaYSesion.setVisible(true);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		Gestor gestor = new Gestor();
		gestor.addnewButtonToVentanaElegirHora(panel, this, sesiones, cart);
	}

}
