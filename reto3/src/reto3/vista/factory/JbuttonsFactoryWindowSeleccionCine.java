package reto3.vista.factory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import reto3.bbdd.gestores.GestorCine;
import reto3.bbdd.gestores.GestorProyeccion;
import reto3.bbdd.pojo.Cine;
import reto3.controlador.Cart.Carrito;
import reto3.vista.Peliculas;
import reto3.vista.SeleccionCines;

public class JbuttonsFactoryWindowSeleccionCine extends JFrame {

	private static final long serialVersionUID = -6611500024320189363L;

	private GestorProyeccion gestor = null;

	public JbuttonsFactoryWindowSeleccionCine() {
		gestor = new GestorProyeccion();
	}

	public JButton getJbutton(int number, Cine cine, SeleccionCines frame, JPanel jPanelCines, Carrito cart) {
		JButton ret = new JButton();
		switch (number) {
		case 1:
			ret = buttonI(cine, jPanelCines, frame, cart);
			break;
		case 2:
			ret = buttonII(cine, jPanelCines, frame, cart);
			break;
		case 3:
			ret = buttonIII(cine, jPanelCines, frame, cart);
			break;
		case 4:
			ret = buttonIV(cine, jPanelCines, frame, cart);
			break;
		case 5:
			ret = buttonV(cine, jPanelCines, frame, cart);
			break;
		case 6:
			ret = buttonVI(cine, jPanelCines, frame, cart);
			break;

		}

		return ret;
	}

	private JButton buttonI(Cine cine, JPanel panel, SeleccionCines frame, Carrito cart) {
		JButton ret = new JButton();
		ret = new JButton("");
		ret.setText(cine.getNombre());
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(738, 29, 183, 40);

		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(cine.getId()), cart);
				frame.dispose();
				panel.setVisible(false);
				open.setVisible(true);
			}
		});
		return ret;

	}

	private JButton buttonII(Cine cine, JPanel panel, SeleccionCines frame, Carrito cart) {
		JButton ret = new JButton();
		ret = new JButton("");
		ret.setText(cine.getNombre());
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(528, 29, 183, 40);

		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(cine.getId()), cart);
				frame.dispose();
				panel.setVisible(false);
				open.setVisible(true);
			}
		});
		return ret;

	}

	private JButton buttonIII(Cine cine, JPanel panel, SeleccionCines frame, Carrito cart) {
		JButton ret = new JButton();
		ret = new JButton("");
		ret.setText(cine.getNombre());
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(946, 29, 183, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(cine.getId()), cart);
				frame.dispose();
				panel.setVisible(false);
				open.setVisible(true);
			}
		});
		return ret;

	}

	private JButton buttonIV(Cine cine, JPanel panel, SeleccionCines frame, Carrito cart) {
		JButton ret = new JButton();
		ret = new JButton("");
		ret.setText(cine.getNombre());
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(524, 97, 183, 40);

		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(cine.getId()), cart);
				frame.dispose();
				panel.setVisible(false);
				open.setVisible(true);
			}
		});
		return ret;

	}

	private JButton buttonV(Cine cine, JPanel panel, SeleccionCines frame, Carrito cart) {
		JButton ret = new JButton();
		ret = new JButton("");
		ret.setText(cine.getNombre());
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(738, 97, 183, 40);

		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(cine.getId()), cart);
				frame.dispose();
				panel.setVisible(false);
				open.setVisible(true);
			}
		});
		return ret;

	}

	private JButton buttonVI(Cine cine, JPanel panel, SeleccionCines frame, Carrito cart) {
		JButton ret = new JButton();
		ret = new JButton("");
		ret.setText(cine.getNombre());
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(946, 97, 183, 40);

		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Peliculas open = new Peliculas(gestor.getProyeccionByIdCine(cine.getId()), cart);
				frame.dispose();
				panel.setVisible(false);
				open.setVisible(true);
			}
		});
		return ret;

	}

}
