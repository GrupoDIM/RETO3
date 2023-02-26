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
import javax.swing.ImageIcon;

public class PantallaFechaYSesion extends JFrame {

	private static final long serialVersionUID = -5841819558911849299L;
	private JPanel contentPaneFechaSesion;
	private JLabel lblTitulo;

	public PantallaFechaYSesion(ArrayList<Date> fechas, Proyeccion sesion, Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPaneFechaSesion = new JPanel();
		contentPaneFechaSesion.setBackground(new Color(33,18,97));
		contentPaneFechaSesion.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); 
		setLocationRelativeTo(null); 

		setContentPane(contentPaneFechaSesion);
		contentPaneFechaSesion.setLayout(null);

		JLabel lblImagen =  new JLabel("");
		lblImagen.setIcon(new javax.swing.ImageIcon(
				new Gestor().readimg(sesion.getPelicula().getImage()).getScaledInstance(330, 400, WIDTH)));
		lblImagen.setBounds(104, 130, 330, 400);
		contentPaneFechaSesion.add(lblImagen);

		lblTitulo = new JLabel("");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblTitulo.setBounds(458, 130, 709, 50);
		contentPaneFechaSesion.add(lblTitulo);
		new Gestor().addJbuttonToPanelVentanaFechaYSesion(contentPaneFechaSesion, this, fechas, sesion, cart);
		
		JPanel jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setLayout(null);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		contentPaneFechaSesion.add(jPanelBarraSuperior);
		
				JButton btnAtras = new JButton("");
				btnAtras.setIcon(new ImageIcon(PantallaFechaYSesion.class.getResource("/reto3/vista/imagenes/BotonAtras90x50.png")));
				btnAtras.setBounds(38, 0, 90, 50);
				jPanelBarraSuperior.add(btnAtras);
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
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(PantallaFechaYSesion.class.getResource("/reto3/vista/imagenes/Footer.png")));
				lblNewLabel.setBounds(0, 611, 1207, 50);
				contentPaneFechaSesion.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("(HAGA CLICK SOBRE LA FECHA DESEADA)");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setForeground(new Color(248, 212, 64));
				lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
				lblNewLabel_1.setBounds(535, 177, 570, 29);
				contentPaneFechaSesion.add(lblNewLabel_1);
	}
}
