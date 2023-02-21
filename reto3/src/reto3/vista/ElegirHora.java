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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.GestorPelicula;

import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;

public class ElegirHora extends JFrame {

	private static final long serialVersionUID = 4822076674316770008L;
	private JPanel contentPaneHorarios;
	private JPanel panel;

	public ElegirHora(ArrayList<Proyeccion> sesiones, Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPaneHorarios = new JPanel();
		contentPaneHorarios.setBackground(new Color(33, 18, 97));
		contentPaneHorarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); // Desativado la redimenzionalidad
		setLocationRelativeTo(null); // Posicionamiento central de la pantalla

		setContentPane(contentPaneHorarios);
		contentPaneHorarios.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(33, 18, 97));
		panel.setBounds(0, 50, 1207, 563);
		contentPaneHorarios.add(panel);
		panel.setLayout(null);

		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new javax.swing.ImageIcon(
				new Gestor().readimg(sesiones.get(0).getPelicula().getImage()).getScaledInstance(330, 400, WIDTH)));
		lblImagen.setBounds(104, 81, 330, 400);
		panel.add(lblImagen);

		JLabel lblTitle = new JLabel("title");
		lblTitle.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblTitle.setText(sesiones.get(0).getPelicula().getTitulo());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(458, 81, 709, 50);
		panel.add(lblTitle);

		JLabel lblGenero = new JLabel("genero");
		lblGenero.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenero.setForeground(new Color(255, 255, 255));
		lblGenero.setText(sesiones.get(0).getPelicula().getGenero());
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 16));

		lblGenero.setText(sesiones.get(0).getPelicula().getGenero());

		lblGenero.setBounds(601, 242, 438, 32);
		panel.add(lblGenero);

		JLabel lblDuracion = new JLabel("duracion");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setForeground(new Color(248, 212, 64));
		lblDuracion.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblDuracion.setText("DURACIÓN : " + sesiones.get(0).getPelicula().getDuracion() + "" + "min");
		lblDuracion.setBounds(423, 140, 288, 24);
		panel.add(lblDuracion);

		JLabel lblCalificacion = new JLabel("New label");
		lblCalificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalificacion.setForeground(new Color(248, 212, 64));
		lblCalificacion.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblCalificacion.setText("VALORACIÓN : " + sesiones.get(0).getPelicula().getCalificacion() + "");
		lblCalificacion.setBounds(708, 140, 216, 24);
		panel.add(lblCalificacion);

		JLabel lblPrecio = new JLabel("New label");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setText("PRECIO : " + sesiones.get(0).getPrecio() + "" + "€");
		lblPrecio.setForeground(new Color(248, 212, 64));
		lblPrecio.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblPrecio.setBounds(947, 140, 178, 24);
		panel.add(lblPrecio);
		Gestor gestor = new Gestor();
		gestor.addnewButtonToVentanaElegirHora(panel, this, sesiones, cart);
		
		JPanel jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setLayout(null);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		contentPaneHorarios.add(jPanelBarraSuperior);
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(ElegirHora.class.getResource("/reto3/vista/imagenes/BotonAtras90x50.png")));
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(10, 0, 90, 50);
		jPanelBarraSuperior.add(btnAtras);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ElegirHora.class.getResource("/reto3/vista/imagenes/Footer.png")));
		lblNewLabel.setBounds(0, 611, 1207, 50);
		contentPaneHorarios.add(lblNewLabel);
	}
}
