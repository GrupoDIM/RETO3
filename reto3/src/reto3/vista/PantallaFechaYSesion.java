package reto3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.GestorProyeccion;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;

public class PantallaFechaYSesion extends JFrame {

	private static final long serialVersionUID = -5841819558911849299L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblTitulo;

	public PantallaFechaYSesion(ArrayList<Date> fechas, Proyeccion sesion, Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 907, 63);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GestorProyeccion gestorProyeccion = new GestorProyeccion();
				Peliculas peliculas = new Peliculas(
						gestorProyeccion.getProyeccionByIdCine(sesion.getSala().getCine().getId()), cart);
				peliculas.setVisible(true);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(37, 11, 128, 41);
		panel.add(btnAtras);

		JLabel lblImagen = new JLabel("New label");
		lblImagen.setIcon(new javax.swing.ImageIcon(
				new Gestor().readimg(sesion.getPelicula().getImage()).getScaledInstance(269, 334, WIDTH)));
		lblImagen.setBounds(38, 97, 269, 334);
		contentPane.add(lblImagen);

		lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblTitulo.setBounds(340, 97, 516, 33);
		contentPane.add(lblTitulo);
		new Gestor().addJbuttonToPanelVentanaFechaYSesion(contentPane, this, fechas, sesion, cart);
	}

}
