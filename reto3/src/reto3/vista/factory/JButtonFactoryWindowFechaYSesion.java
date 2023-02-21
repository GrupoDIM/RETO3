package reto3.vista.factory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

import reto3.bbdd.gestores.GestorProyeccion;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;
import reto3.vista.ElegirHora;
import reto3.vista.PantallaFechaYSesion;

public class JButtonFactoryWindowFechaYSesion extends JFrame {
	public JButtonFactoryWindowFechaYSesion() {
	}

	private static final long serialVersionUID = -8193730902024199723L;

	public JButton getButton(Gestor gestor, PantallaFechaYSesion frame, int count, Proyeccion sesion, Date date,
			Carrito cart) {
		JButton ret = null;
		int dimension;
		switch (count) {
		case 1:
			ret = buttonI(frame, gestor, date, sesion, cart);
			break;
		case 2:
			dimension = 230 + 55;
			ret = buttonII(frame, gestor, dimension, date, sesion, cart);
			break;
		case 3:
			dimension = 230 + (55 * 2);
			ret = buttonIII(frame, gestor, dimension, date, sesion, cart);

			break;
		case 4:
			dimension = 230 + (55 * 3);
			ret = buttonIV(frame, gestor, dimension, date, sesion, cart);
			break;
		case 5:
			dimension = 230 + (55 * 4);
			ret = buttonV(frame, gestor, dimension, date, sesion, cart);
			break;
		case 6:
			dimension = 230 + (55 * 5);
			ret = buttonVI(frame, gestor, dimension, date, sesion, cart);
			break;
		}
		return ret;

	}

	private JButton buttonI(PantallaFechaYSesion frame, Gestor con, Date date, Proyeccion sesion, Carrito cart) {
		JButton ret = new JButton("");
		ret.setText(con.setDateOfTheDay(date));
		ret.setBounds(725, 230, 193, 40);
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				GestorProyeccion gestorProyeccion = new GestorProyeccion();
				ElegirHora elegirHora = new ElegirHora(
						gestorProyeccion.getProyeccionByDate(sesion.getPelicula().getId(),
								con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()),
						cart);
				elegirHora.setVisible(true);

			}
		});
		return ret;
	}

	private JButton buttonII(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			Carrito cart) {
		JButton ret = new JButton("New button");
		ret.setText(con.setDateOfTheDay(date));
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(725, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				GestorProyeccion gestorProyeccion = new GestorProyeccion();
				ElegirHora elegirHora = new ElegirHora(
						gestorProyeccion.getProyeccionByDate(sesion.getPelicula().getId(),
								con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()),
						cart);
				elegirHora.setVisible(true);

			}
		});
		return ret;
	}

	private JButton buttonIII(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			Carrito cart) {
		JButton ret = new JButton("");
		ret.setText(con.setDateOfTheDay(date));
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(725, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				GestorProyeccion gestorProyeccion = new GestorProyeccion();
				ElegirHora elegirHora = new ElegirHora(
						gestorProyeccion.getProyeccionByDate(sesion.getPelicula().getId(),
								con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()),
						cart);
				elegirHora.setVisible(true);
			}
		});
		return ret;
	}

	private JButton buttonIV(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			Carrito cart) {
		JButton ret = new JButton("");
		ret.setText(con.setDateOfTheDay(date));
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(725, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				GestorProyeccion gestorProyeccion = new GestorProyeccion();
				ElegirHora elegirHora = new ElegirHora(
						gestorProyeccion.getProyeccionByDate(sesion.getPelicula().getId(),
								con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()),
						cart);
				elegirHora.setVisible(true);

			}
		});
		return ret;
	}

	private JButton buttonV(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			Carrito cart) {
		JButton ret = new JButton("");
		ret.setText(con.setDateOfTheDay(date));
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(725, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				GestorProyeccion gestorProyeccion = new GestorProyeccion();
				ElegirHora elegirHora = new ElegirHora(
						gestorProyeccion.getProyeccionByDate(sesion.getPelicula().getId(),
								con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()),
						cart);
				elegirHora.setVisible(true);

			}
		});
		return ret;
	}

	private JButton buttonVI(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			Carrito cart) {
		JButton ret = new JButton("");
		ret.setText(con.setDateOfTheDay(date));
		ret.setForeground(new Color(255, 255, 255));
		ret.setFont(new Font("Arial Black", Font.BOLD, 20));
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(725, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				GestorProyeccion gestorProyeccion = new GestorProyeccion();
				ElegirHora elegirHora = new ElegirHora(
						gestorProyeccion.getProyeccionByDate(sesion.getPelicula().getId(),
								con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()),
						cart);
				elegirHora.setVisible(true);

			}
		});
		return ret;
	}

}
