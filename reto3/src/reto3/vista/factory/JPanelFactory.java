package reto3.vista.factory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import reto3.bbdd.gestores.GestorPelicula;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Gestor;
import reto3.controlador.Cart.Carrito;
import reto3.vista.PantallaFechaYSesion;
import reto3.vista.Peliculas;

public class JPanelFactory extends JFrame {

	private static final long serialVersionUID = 3441961518738822431L;

	public JPanel getPanel(Peliculas frame, Gestor gestor, int panelNumber, Proyeccion sesion, Carrito cart) {
		JPanel ret = null;
		int dimension = 0;

		switch (panelNumber) {
		case 1:
			ret = jpanelI(frame, gestor, sesion, cart);
			break;
		case 2:
			dimension = 291;
			ret = this.jpanelII(frame, dimension, gestor, sesion, cart);
			break;
		case 3:
			dimension = 291 * 2;
			ret = this.jpanelIII(frame, dimension, gestor, sesion, cart);
			break;
		case 4:
			dimension = 291 * 3;
			ret = this.jpanelIV(frame, dimension, gestor, sesion, cart);
			break;
		case 5:
			dimension = 291 * 4;
			ret = this.jpanelV(frame, dimension, gestor, sesion, cart);
			break;
		case 6:
			dimension = 291 * 5;
			ret = this.jpanelVI(frame, dimension, gestor, sesion, cart);
			break;
		case 7:
			dimension = 291 * 6;
			ret = this.jpanelVII(frame, dimension, gestor, sesion, cart);
			break;
		case 8:
			dimension = 291 * 7;
			ret = this.jpanelVIII(frame, dimension, gestor, sesion, cart);
			break;
		case 9:
			dimension = 423 * 8;
			ret = this.jpanelIX(frame, dimension, gestor, sesion, cart);
			break;
		case 10:
			dimension = 423 * 9;
			ret = this.jpanelX(frame, dimension, gestor, sesion, cart);
			break;
		case 11:
			dimension = 291 * 10;
			ret = this.jpanelXI(frame, dimension, gestor, sesion, cart);
			break;

		}
		return ret;

	}

	private JPanel jpanelI(Peliculas frame, Gestor con, Proyeccion sesion, Carrito cart) {

		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, 0, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(

				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);
			}
		});

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);
			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelIII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("New button");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);

			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelIV(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("New button");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);

			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelV(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("New button");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);

			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelVI(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("New button");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);

			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelVII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("New button");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);

			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelVIII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("New button");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);
			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelIX(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("New button");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);

			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelX(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("New button");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);

			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelXI(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 1189, 292);
		ret.setLayout(null);
		JButton btnImage = new JButton("New button");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(309, 250, WIDTH)));
		btnImage.setBounds(108, 22, 309, 247);
		ret.add(btnImage);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestorPelicula gestorPelicula = new GestorPelicula();
				PantallaFechaYSesion open = new PantallaFechaYSesion(gestorPelicula.getFechasDeUnaPelicula(
						sesion.getPelicula().getId(), sesion.getSala().getCine().getId()), sesion, cart);
				open.setVisible(true);

			}
		});

		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(
				sesion.getPelicula().getTituloCastellano() + "(" + sesion.getPelicula().getTituloOrigin() + ")");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(583, 121, 425, 23);
		ret.add(lblTitulo);
		return ret;
	}

}
