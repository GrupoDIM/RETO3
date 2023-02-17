package reto3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.GestorCliente;
import reto3.bbdd.gestores.GestorFacturaEntrada;
import reto3.bbdd.pojo.Cliente;
import reto3.controlador.Cart.Carrito;

public class Login extends JFrame {

	private static final long serialVersionUID = 3138475966442734198L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnRegistrarse;

	public Login(Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 882, 585);
		contentPane.add(panel);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(267, 129, 288, 37);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(267, 210, 288, 37);
		panel.add(passwordField);

		btnLogin = new JButton("login");
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
					GenerarFactura generarFactura = new GenerarFactura(cart);
					dispose();
					panel.setVisible(false);
					generarFactura.setVisible(true);
				}
			}
		});
		btnLogin.setBounds(351, 333, 109, 37);
		panel.add(btnLogin);

		btnRegistrarse = new JButton("registrate!!");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrarse registrarse = new Registrarse(cart);
				dispose();
				panel.setVisible(false);
				registrarse.setVisible(true);
			}
		});
		btnRegistrarse.setBounds(693, 11, 156, 30);
		panel.add(btnRegistrarse);

		JButton btnVolverAlinicio = new JButton("vover al inicio");
		btnVolverAlinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart.getCompras().clear();
				Bienvenida bienvenida = new Bienvenida();
				dispose();
				bienvenida.frame.setVisible(true);
			}
		});
		btnVolverAlinicio.setBounds(30, 15, 109, 23);
		panel.add(btnVolverAlinicio);
	}
}
