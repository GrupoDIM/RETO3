package reto3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.Connection;
import reto3.bbdd.gestores.GestorCliente;
import reto3.bbdd.gestores.GestorFacturaEntrada;
import reto3.bbdd.pojo.Cliente;
import reto3.bbdd.pojo.Factura;
import reto3.controlador.Cart.Carrito;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 3138475966442734198L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnRegistrarse;
	private JPanel jPanelBarraSuperior;
	private JLabel jLabelFooter;
	private JLabel jLabelUsuario;
	private JLabel jLabelPass;
	private JLabel lblyaEresSocio;
	private JLabel lblNewLabel_1;
	private JLabel jLabelFondoLogin;

	public Login(Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); // Desativado la redimenzionalidad
		setLocationRelativeTo(null); // Posicionamiento central de la pantalla

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(33, 18, 97));
		panel.setBounds(0, 51, 1207, 562);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.BOLD, 14));
		textField.setBounds(403, 194, 400, 50);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(403, 308, 400, 50);
		panel.add(passwordField);

		btnLogin = new JButton("INICIAR SESION");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnLogin.setBounds(453, 463, 300, 50);
		panel.add(btnLogin);
		
		jLabelUsuario = new JLabel("INTRODUZCA SU EMAIL:");
		jLabelUsuario.setForeground(new Color(255, 255, 255));
		jLabelUsuario.setFont(new Font("Arial Black", Font.BOLD, 18));
		jLabelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelUsuario.setBounds(403, 150, 400, 50);
		panel.add(jLabelUsuario);
		
		jLabelPass = new JLabel("INTRODUZCA SU PASSWORD:");
		jLabelPass.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelPass.setForeground(Color.WHITE);
		jLabelPass.setFont(new Font("Arial Black", Font.BOLD, 18));
		jLabelPass.setBounds(403, 267, 400, 50);
		panel.add(jLabelPass);
		
		lblyaEresSocio = new JLabel("¿YA ERES SOCIO? INICIA SESION:");
		lblyaEresSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblyaEresSocio.setForeground(Color.WHITE);
		lblyaEresSocio.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblyaEresSocio.setBounds(249, 40, 709, 50);
		panel.add(lblyaEresSocio);
		
		lblNewLabel_1 = new JLabel("(SI NO ERES SOCIO, PUEDE REGISTRARSE)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(248, 212, 64));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(318, 84, 570, 29);
		panel.add(lblNewLabel_1);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText().toLowerCase();
				String pass = new String(passwordField.getPassword());

				Cliente cliente = new GestorCliente().getClienteByEmailAndPassword(email, pass);
				if (cliente == null) {
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecto !!");
				} else {

					cart.getCompras().get(0).getFactura().setCliente(cliente);
					GestorFacturaEntrada gestor = new GestorFacturaEntrada();
					String dateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
					gestor.insertFactura(cart, dateTime);
					Connection con = new Connection();
					Factura factura = null;
					try {
						con.connect();
						factura = gestor.getFacturaIdBydDateTime(dateTime);
						con.disconnect();
					} catch (SQLException e1) {
						e1.printStackTrace();
						con.disconnect();
					}
					GenerarFactura generarFactura = new GenerarFactura(factura, cart);
					dispose();
					panel.setVisible(false);
					generarFactura.setVisible(true);
				}
			}
		});

		jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setLayout(null);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		contentPane.add(jPanelBarraSuperior);

		JButton btnVolverAlinicio = new JButton("");
		btnVolverAlinicio.setIcon(new ImageIcon(Login.class.getResource("/reto3/vista/imagenes/BotonAtras90x50.png")));
		btnVolverAlinicio.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnVolverAlinicio.setBounds(34, 0, 90, 50);
		jPanelBarraSuperior.add(btnVolverAlinicio);
		btnVolverAlinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart.getCompras().clear();
				Bienvenida bienvenida = new Bienvenida();
				dispose();
				bienvenida.frame.setVisible(true);
			}
		});

		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setBackground(new Color(0, 0, 0));
		btnRegistrarse.setForeground(new Color(255, 255, 255));
		btnRegistrarse.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnRegistrarse.setBounds(981, 0, 156, 50);
		jPanelBarraSuperior.add(btnRegistrarse);
		
		jLabelFondoLogin = new JLabel("");
		jLabelFondoLogin.setIcon(new ImageIcon(Login.class.getResource("/reto3/vista/imagenes/FondoLogin.gif")));
		jLabelFondoLogin.setBounds(0, 0, 1207, 561);
		panel.add(jLabelFondoLogin);

		jLabelFooter = new JLabel("");
		jLabelFooter.setIcon(new ImageIcon(Login.class.getResource("/reto3/vista/imagenes/Footer.png")));
		jLabelFooter.setBounds(0, 611, 1207, 50);
		contentPane.add(jLabelFooter);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrarse registrarse = new Registrarse(cart);
				dispose();
				panel.setVisible(false);
				registrarse.setVisible(true);
			}
		});

	}
}
