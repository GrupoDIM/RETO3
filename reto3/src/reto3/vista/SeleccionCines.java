package reto3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.GestorCine;
import reto3.bbdd.gestores.GestorProyeccion;
import reto3.bbdd.pojo.Cine;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class SeleccionCines extends JFrame {

	private static final long serialVersionUID = -1525562907814196106L;

	private JPanel jPanelSelecionCines;
	private JButton btnCarritoDeCompra;

	public SeleccionCines(Carrito cart) {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		jPanelSelecionCines = new JPanel();
		jPanelSelecionCines.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); 
		setLocationRelativeTo(null); 
		getContentPane().setLayout(null);

		setContentPane(jPanelSelecionCines);
		jPanelSelecionCines.setLayout(null);

		
		JPanel jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		jPanelSelecionCines.add(jPanelBarraSuperior);
		jPanelBarraSuperior.setLayout(null);

	
		JButton btnInicio = new JButton("");
		btnInicio
				.setIcon(new ImageIcon(SeleccionCines.class.getResource("/reto3/vista/imagenes/BotonInicio90x50.png")));
		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnInicio.setBackground(new Color(0, 0, 0));
		btnInicio.setBounds(10, 0, 90, 50);
		jPanelBarraSuperior.add(btnInicio);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cart.isEmpty()) {
					Bienvenida bienvenida = new Bienvenida();
					dispose();
					bienvenida.frame.setVisible(true);
				}
			}
		});

	
		btnCarritoDeCompra = new JButton("");
		btnCarritoDeCompra.setForeground(new Color(255, 255, 255));
		btnCarritoDeCompra.setBackground(new Color(255, 255, 255));
		btnCarritoDeCompra.setBounds(1107, 0, 90, 50);
		jPanelBarraSuperior.add(btnCarritoDeCompra);
		btnCarritoDeCompra.setIcon(
				new ImageIcon(SeleccionCines.class.getResource("/reto3/vista/imagenes/BotonResumen90x50.png")));
		btnCarritoDeCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = null;
				dispose();
				if (cart.isEmpty()) {
					msg = "0 compras!!";
					ShoppingCart open = new ShoppingCart(null, cart, msg, 1);
					dispose();
					open.setVisible(true);
				} else {
					ShoppingCart shopCart = new ShoppingCart(null, cart, null, 1);
					dispose();
					shopCart.setVisible(true);
				}

			}
		});

	
		JPanel jPanelCines = new JPanel();
		jPanelCines.setBackground(new Color(33, 18, 97));
		jPanelCines.setBounds(0, 51, 1207, 598);
		jPanelSelecionCines.add(jPanelCines);
		jPanelCines.setLayout(null);
		new Gestor().addJbuttonsToTheJpanelSeleccionCines(this, jPanelCines, cart);
	
		JLabel jLabelSelecioneUnCine = new JLabel("SELECCIONE UN CINE:");
		jLabelSelecioneUnCine.setForeground(new Color(255, 255, 255));
		jLabelSelecioneUnCine.setFont(new Font("Arial Black", Font.BOLD, 30));
		jLabelSelecioneUnCine.setBounds(59, 29, 415, 41);
		jPanelCines.add(jLabelSelecioneUnCine);

		//
		JPanel jPanelEstrenos = new JPanel();
		jPanelEstrenos.setBackground(new Color(0, 0, 0));
		jPanelEstrenos.setBounds(0, 197, 1207, 309);
		jPanelCines.add(jPanelEstrenos);
		jPanelEstrenos.setLayout(null);

		JLabel jLabelEstrenos = new JLabel("");
		jLabelEstrenos.setFont(new Font("Arial Black", Font.PLAIN, 11));
		jLabelEstrenos.setIcon(
				new ImageIcon(SeleccionCines.class.getResource("/reto3/vista/imagenes/EstrenosPortadasRuleta.gif")));
		jLabelEstrenos.setBounds(0, 0, 1200, 309);
		jPanelEstrenos.add(jLabelEstrenos);

		JLabel jLabelPiePagina = new JLabel("");
		jLabelPiePagina.setIcon(new ImageIcon(SeleccionCines.class.getResource("/reto3/vista/imagenes/Footer.png")));
		jLabelPiePagina.setBounds(0, 563, 1207, 50);
		jPanelCines.add(jLabelPiePagina);

	}

}
