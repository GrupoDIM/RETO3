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
	public JPanelFactory() {
	}

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

		// JPANEL | PELICULA Nº1
		JPanel ret = new JPanel();
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(150, 20, 800, 250);
		ret.setLayout(null);

		// JBUTTON | BOTON DE IMAGEN DE PELICULA Nº1
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº1
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.WHITE);
		ret.add(lblTitulo);

		//
		return ret;
	}

	private JPanel jpanelII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON | IMAGEN "PORTADA DE PELICULA Nº2"
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº2
		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.BLACK);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelIII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON | BOTON DE IMAGEN
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº3
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.WHITE);
		ret.add(lblTitulo);

		//
		return ret;
	}

	private JPanel jpanelIV(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON |BOTON DE IMAGEN DE PELICULA Nº4
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº4
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.BLACK);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelV(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON | BOTON DE IMAGEN DE PELICULA Nº5
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº5
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.WHITE);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelVI(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON | BOTON DE IMAGEN DE PELICULA Nº6
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº6
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.BLACK);
		ret.add(lblTitulo);

		//
		return ret;
	}

	private JPanel jpanelVII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON | BOTON DE IMAGEN DE PELICULA Nº7
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº7
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.WHITE);
		ret.add(lblTitulo);
		return ret;
	}

	private JPanel jpanelVIII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON | BOTON DE IMAGEN DE PELICULA Nº8
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PALICULA Nº8
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.BLACK);
		ret.add(lblTitulo);

		//
		return ret;
	}

	private JPanel jpanelIX(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON | BOTON DE IMAGEN DE PELICULA Nº9
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº9
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.WHITE);
		ret.add(lblTitulo);

		//
		return ret;
	}

	private JPanel jpanelX(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON | BOTON DE IMAGEN DE PELICULA Nº10
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº10
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.WHITE);
		ret.add(lblTitulo);
		
		//
		return ret;
	}

	private JPanel jpanelXI(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, Carrito cart) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(0, 0, 0));
		ret.setBounds(150, dimension, 800, 250);
		ret.setLayout(null);

		// JBUTTON | BOTON DE IMAGEN DE PELICULA Nº11
		JButton btnImage = new JButton("");
		btnImage.setIcon(new javax.swing.ImageIcon(
				con.readimg(sesion.getPelicula().getImage()).getScaledInstance(150, 200, WIDTH)));
		btnImage.setBounds(100, 25, 150, 200);
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

		// JLABEL | TITULO DE PELICULA Nº11
		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setText(sesion.getPelicula().getTitulo());
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(300, 121, 425, 23);
		lblTitulo.setForeground(Color.WHITE);
		ret.add(lblTitulo);
		
		//
		return ret;
	}

}
