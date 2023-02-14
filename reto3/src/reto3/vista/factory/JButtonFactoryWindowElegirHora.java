package reto3.vista.factory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;
import reto3.vista.AddMovieToTheCart;
import reto3.vista.ElegirHora;

public class JButtonFactoryWindowElegirHora extends JFrame {

	private static final long serialVersionUID = 5545147865159145887L;

	public JButton getButton(Gestor gestor, ElegirHora frame, int count, Proyeccion sesion, Carrito cart) {
		JButton ret = null;
		int dimension;
		switch (count) {
		case 1:
			ret = buttonHoraI(gestor, frame, sesion, cart);
			break;
		case 2:
			dimension = 202 * 2;
			ret = buttonHoraII(gestor, frame, dimension, sesion, cart);
			break;
		case 3:
			dimension = 202 * 3;
			ret = buttonHoraIII(gestor, frame, dimension, sesion, cart);

			break;
		case 4:
			dimension = 202 * 4;
			ret = buttonHoraIV(gestor, frame, dimension, sesion, cart);
			break;
		}
		return ret;
	}

	private JButton buttonHoraI(Gestor con, ElegirHora frame, Proyeccion sesion, Carrito cart) {
		JButton ret = new JButton("New button");
		ret.setText(con.getTime(sesion.getHora()) + "\n SALA" + sesion.getSala().getNombre());
		ret.setBounds(202, 356, 149, 44);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				AddMovieToTheCart open = new AddMovieToTheCart(sesion, cart);
				open.setVisible(true);
			}
		});
		return ret;
	}

	private JButton buttonHoraII(Gestor con, ElegirHora frame, int dimension, Proyeccion sesion, Carrito cart) {
		JButton ret = new JButton("New button");
		ret.setText(con.getTime(sesion.getHora()) + "\n SALA" + sesion.getSala().getNombre());
		ret.setBounds(dimension, 356, 149, 44);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				AddMovieToTheCart open = new AddMovieToTheCart(sesion, cart);
				open.setVisible(true);
			}
		});
		return ret;
	}

	private JButton buttonHoraIII(Gestor con, ElegirHora frame, int dimension, Proyeccion sesion, Carrito cart) {
		JButton ret = new JButton("New button");
		ret.setText(con.getTime(sesion.getHora()) + "\n SALA" + sesion.getSala().getNombre());
		ret.setBounds(dimension, 356, 149, 44);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				AddMovieToTheCart open = new AddMovieToTheCart(sesion, cart);
				open.setVisible(true);
			}
		});
		return ret;
	}

	private JButton buttonHoraIV(Gestor con, ElegirHora frame, int dimension, Proyeccion sesion, Carrito cart) {
		JButton ret = new JButton("New button");
		ret.setText(con.getTime(sesion.getHora()) + "\n SALA" + sesion.getSala().getNombre());
		ret.setBounds(dimension, 356, 149, 44);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				AddMovieToTheCart open = new AddMovieToTheCart(sesion, cart);
				open.setVisible(true);
			}
		});
		return ret;
	}

}
