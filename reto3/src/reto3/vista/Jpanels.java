package reto3.vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import reto3.bbdd.pojo.Factura;
import reto3.bbdd.pojo.Proyeccion;
import reto3.controlador.Connection;
import reto3.controlador.Gestor;

public class Jpanels extends JFrame {

	public JPanel jpanelI(Peliculas frame, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {

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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelIII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelIV(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelV(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelVI(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelVII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelVIII(Peliculas frame, int dimension, Gestor con, Proyeccion sesion,
			ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelIX(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelX(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JPanel jpanelXI(Peliculas frame, int dimension, Gestor con, Proyeccion sesion, ArrayList<Factura> compras) {
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
				Connection con = new Connection();
				PantallaFechaYSesion open = new PantallaFechaYSesion(
						con.getFechasDeUnaPelicula(sesion.getPelicula().getId(), sesion.getSala().getCine().getId()),
						sesion, compras);
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

	public JButton buttonI(PantallaFechaYSesion frame, Gestor con, Date date, Proyeccion sesion,
			ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");

		ret.setText(con.setDateOfTheDay(date));
		ret.setBounds(308, 156, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				Connection conn = new Connection();
				ElegirHora open = new ElegirHora(conn.getProyeccionByDate(sesion.getPelicula().getId(),
						con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()), compras);
				open.setVisible(true);

			}
		});
		return ret;
	}

	public JButton buttonII(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");
		ret.setText(con.setDateOfTheDay(date));
		ret.setBounds(308, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				Connection conn = new Connection();
				ElegirHora open = new ElegirHora(conn.getProyeccionByDate(sesion.getPelicula().getId(),
						con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()), compras);
				open.setVisible(true);
			}
		});
		return ret;
	}

	public JButton buttonIII(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");
		ret.setText(con.setDateOfTheDay(date));
		ret.setBounds(308, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				Connection conn = new Connection();
				ElegirHora open = new ElegirHora(conn.getProyeccionByDate(sesion.getPelicula().getId(),
						con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()), compras);
				open.setVisible(true);
			}
		});
		return ret;
	}

	public JButton buttonIV(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");
		ret.setText(con.setDateOfTheDay(date));
		ret.setBounds(308, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				Connection conn = new Connection();
				ElegirHora open = new ElegirHora(conn.getProyeccionByDate(sesion.getPelicula().getId(),
						con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()), compras);
				open.setVisible(true);
			}
		});
		return ret;
	}

	public JButton buttonV(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");
		ret.setText(con.setDateOfTheDay(date));
		ret.setBounds(308, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				Connection conn = new Connection();
				ElegirHora open = new ElegirHora(conn.getProyeccionByDate(sesion.getPelicula().getId(),
						con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()), compras);
				open.setVisible(true);
			}
		});
		return ret;
	}

	public JButton buttonVI(PantallaFechaYSesion frame, Gestor con, int dimension, Date date, Proyeccion sesion,
			ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");
		ret.setText(con.setDateOfTheDay(date));
		ret.setBounds(308, dimension, 193, 40);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frame.getContentPane().setVisible(false);
				Connection conn = new Connection();
				ElegirHora open = new ElegirHora(conn.getProyeccionByDate(sesion.getPelicula().getId(),
						con.convertToLocalDateViaInstant(date), sesion.getSala().getCine().getId()), compras);
				open.setVisible(true);
			}
		});
		return ret;
	}

	public JButton buttonHoraI(Gestor con, ElegirHora frame, Proyeccion sesion, ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");
		ret.setText(con.getTime(sesion.getHora()) + "\n SALA" + sesion.getSala().getNombre());
		ret.setBounds(202, 356, 149, 44);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				AddMovieToTheCart open = new AddMovieToTheCart(sesion, compras);
				open.setVisible(true);
			}
		});
		return ret;
	}

	public JButton buttonHoraII(Gestor con, ElegirHora frame, int dimension, Proyeccion sesion,
			ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");
		ret.setText(con.getTime(sesion.getHora()) + "\n SALA" + sesion.getSala().getNombre());
		ret.setBounds(dimension, 356, 149, 44);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				AddMovieToTheCart open = new AddMovieToTheCart(sesion, compras);
				open.setVisible(true);
			}
		});
		return ret;
	}

	public JButton buttonHoraIII(Gestor con, ElegirHora frame, int dimension, Proyeccion sesion,
			ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");
		ret.setText(con.getTime(sesion.getHora()) + "\n SALA" + sesion.getSala().getNombre());
		ret.setBounds(dimension, 356, 149, 44);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				AddMovieToTheCart open = new AddMovieToTheCart(sesion, compras);
				open.setVisible(true);
			}
		});
		return ret;
	}

	public JButton buttonHoraIV(Gestor con, ElegirHora frame, int dimension, Proyeccion sesion,
			ArrayList<Factura> compras) {
		JButton ret = new JButton("New button");
		ret.setText(con.getTime(sesion.getHora()) + "\n SALA" + sesion.getSala().getNombre());
		ret.setBounds(dimension, 356, 149, 44);
		ret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				AddMovieToTheCart open = new AddMovieToTheCart(sesion, compras);
				open.setVisible(true);
			}
		});
		return ret;
	}

	public JPanel panelShopCartI(Factura compra, ArrayList<Factura> compras, Gestor con, ShoppingCart frame,
			ArrayList<Proyeccion> sesiones, int index) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, 0, 488, 111);
		ret.setLayout(null);

		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new javax.swing.ImageIcon(new Gestor().readimg(compra.getProyeccion().getPelicula().getImage())
				.getScaledInstance(73, 81, WIDTH)));
		lblImage.setBounds(10, 11, 73, 81);
		ret.add(lblImage);

		JButton btnEliminarCompra = new JButton("");
		btnEliminarCompra.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/x_39x23.png")));
		btnEliminarCompra.setBounds(394, 25, 56, 23);
		ret.add(btnEliminarCompra);
		btnEliminarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar la Compra  ", "",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					if (compras.contains(compra)) {
						compras.remove(compra);
						frame.dispose();
						ShoppingCart open = new ShoppingCart(sesiones, compras, null, index);
						open.setVisible(true);

					}

				}
			}
		});

		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTitle.setText(compra.getProyeccion().getPelicula().getTituloCastellano() + "("
				+ compra.getProyeccion().getPelicula().getTituloOrigin() + ")");
		lblTitle.setBounds(88, 11, 274, 14);
		ret.add(lblTitle);

		JLabel lbl = new JLabel("Cantidad: ");
		lbl.setBounds(88, 49, 56, 14);
		ret.add(lbl);

		JLabel lblCantidad = new JLabel("");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setText(compra.getCantidad() + "");
		lblCantidad.setBounds(156, 45, 46, 23);
		ret.add(lblCantidad);
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setText("Precio Unidad : " + compra.getPrecio() + "" + "€");
		lblPrecio.setBounds(88, 78, 274, 14);
		ret.add(lblPrecio);
		return ret;

	}

	public JPanel panelShopCartII(int dimension, Factura compra, ArrayList<Factura> compras, Gestor con,
			ShoppingCart frame, ArrayList<Proyeccion> sesiones, int index) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 488, 111);
		ret.setLayout(null);

		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new javax.swing.ImageIcon(new Gestor().readimg(compra.getProyeccion().getPelicula().getImage())
				.getScaledInstance(73, 81, WIDTH)));
		lblImage.setBounds(10, 11, 73, 81);
		ret.add(lblImage);

		JButton btnEliminarCompra = new JButton("");
		btnEliminarCompra.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/x_39x23.png")));
		btnEliminarCompra.setBounds(394, 25, 56, 23);
		ret.add(btnEliminarCompra);
		btnEliminarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar la Compra  ", "",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					if (compras.contains(compra)) {
						compras.remove(compra);
						frame.dispose();
						ShoppingCart open = new ShoppingCart(sesiones, compras, null, index);
						open.setVisible(true);

					}

				}
			}
		});

		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTitle.setText(compra.getProyeccion().getPelicula().getTituloCastellano() + "("
				+ compra.getProyeccion().getPelicula().getTituloOrigin() + ")");
		lblTitle.setBounds(88, 11, 274, 14);
		ret.add(lblTitle);

		JLabel lbl = new JLabel("Cantidad: ");
		lbl.setBounds(88, 49, 56, 14);
		ret.add(lbl);

		JLabel lblCantidad = new JLabel("");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setText(compra.getCantidad() + "");
		lblCantidad.setBounds(156, 45, 46, 23);
		ret.add(lblCantidad);
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setText("Precio Unidad : " + compra.getPrecio() + "" + "€");
		lblPrecio.setBounds(88, 78, 274, 14);
		ret.add(lblPrecio);
		return ret;

	}

	public JPanel panelShopCartIII(int dimension, Factura compra, ArrayList<Factura> compras, Gestor con,
			ShoppingCart frame, ArrayList<Proyeccion> sesiones, int index) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 488, 111);
		ret.setLayout(null);

		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new javax.swing.ImageIcon(new Gestor().readimg(compra.getProyeccion().getPelicula().getImage())
				.getScaledInstance(73, 81, WIDTH)));
		lblImage.setBounds(10, 11, 73, 81);
		ret.add(lblImage);

		JButton btnEliminarCompra = new JButton("");
		btnEliminarCompra.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/x_39x23.png")));
		btnEliminarCompra.setBounds(394, 25, 56, 23);
		ret.add(btnEliminarCompra);
		btnEliminarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar la Compra  ", "",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					if (compras.contains(compra)) {
						compras.remove(compra);
						frame.dispose();
						ShoppingCart open = new ShoppingCart(sesiones, compras, null, index);
						open.setVisible(true);

					}

				}
			}
		});

		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTitle.setText(compra.getProyeccion().getPelicula().getTituloCastellano() + "("
				+ compra.getProyeccion().getPelicula().getTituloOrigin() + ")");
		lblTitle.setBounds(88, 11, 274, 14);
		ret.add(lblTitle);

		JLabel lbl = new JLabel("Cantidad: ");
		lbl.setBounds(88, 49, 56, 14);
		ret.add(lbl);

		JLabel lblCantidad = new JLabel("");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setText(compra.getCantidad() + "");
		lblCantidad.setBounds(156, 45, 46, 23);
		ret.add(lblCantidad);
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setText("Precio Unidad : " + compra.getPrecio() + "" + "€");
		lblPrecio.setBounds(88, 78, 274, 14);
		ret.add(lblPrecio);
		return ret;

	}

	public JPanel panelShopCartIV(int dimension, Factura compra, ArrayList<Factura> compras, Gestor con,
			ShoppingCart frame, ArrayList<Proyeccion> sesiones, int index) {
		JPanel ret = new JPanel();
		ret.setBackground(new Color(255, 255, 255));
		ret.setBounds(0, dimension, 488, 111);
		ret.setLayout(null);

		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new javax.swing.ImageIcon(new Gestor().readimg(compra.getProyeccion().getPelicula().getImage())
				.getScaledInstance(73, 81, WIDTH)));
		lblImage.setBounds(10, 11, 73, 81);
		ret.add(lblImage);

		JButton btnEliminarCompra = new JButton("");
		btnEliminarCompra.setIcon(new ImageIcon(ShoppingCart.class.getResource("/reto3/vista/imagenes/x_39x23.png")));
		btnEliminarCompra.setBounds(394, 25, 56, 23);
		ret.add(btnEliminarCompra);
		btnEliminarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "seguro que quieres eliminar la Compra  ", "",
						JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					if (compras.contains(compra)) {
						compras.remove(compra);
						frame.dispose();
						ShoppingCart open = new ShoppingCart(sesiones, compras, null, index);
						open.setVisible(true);

					}

				}
			}
		});

		JLabel lblTitle = new JLabel("");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTitle.setText(compra.getProyeccion().getPelicula().getTituloCastellano() + "("
				+ compra.getProyeccion().getPelicula().getTituloOrigin() + ")");
		lblTitle.setBounds(88, 11, 274, 14);
		ret.add(lblTitle);

		JLabel lbl = new JLabel("Cantidad: ");
		lbl.setBounds(88, 49, 56, 14);
		ret.add(lbl);

		JLabel lblCantidad = new JLabel("");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setText(compra.getCantidad() + "");
		lblCantidad.setBounds(156, 45, 46, 23);
		ret.add(lblCantidad);
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setText("Precio Unidad : " + compra.getPrecio() + "" + "€");
		lblPrecio.setBounds(88, 78, 274, 14);
		ret.add(lblPrecio);

		return ret;

	}

}
