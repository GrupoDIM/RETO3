package reto3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.GestorCliente;
import reto3.bbdd.pojo.Cliente;
import reto3.controlador.Cart.Carrito;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Registrarse extends JFrame {

	private static final long serialVersionUID = -8362028360282304008L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido1;
	private JTextField textFieldApellido2;
	private JTextField textFieldTele;
	private JTextField textFieldEmail;
	private JPasswordField passwordField1;
	private JPasswordField password2;
	private JTextField textFieldDni;
	private JRadioButton rdbtnF;
	private JRadioButton rdbtnM;
	private JPanel jPanelBarraSuperior;
	private JLabel lblNewLabel;
	private JLabel jLabelDNI;
	private JLabel jLabelNombre;
	private JLabel lblApellido1;
	private JLabel lblApellido2;
	private JLabel lblCompletaLosCampara;
	private JLabel lblNewLabel_1;
	private JLabel jLabelTelefono;
	private JLabel jLabelEmail;
	private JLabel jLabelPass1;
	private JLabel jLabelPass2;
	private JLabel lblGenero;

	public Registrarse(Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 18, 97));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); // Desativado la redimenzionalidad
		setLocationRelativeTo(null); // Posicionamiento central de la pantalla

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(70, 224, 240, 30);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellido1 = new JTextField();
		textFieldApellido1.setBounds(350, 224, 240, 30);
		contentPane.add(textFieldApellido1);
		textFieldApellido1.setColumns(10);

		textFieldApellido2 = new JTextField();
		textFieldApellido2.setBounds(630, 224, 240, 30);
		contentPane.add(textFieldApellido2);
		textFieldApellido2.setColumns(10);

		textFieldTele = new JTextField();
		textFieldTele.setBounds(70, 350, 240, 30);
		contentPane.add(textFieldTele);
		textFieldTele.setColumns(10);

		rdbtnF = new JRadioButton("F");
		rdbtnF.setFont(new Font("Arial Black", Font.BOLD, 14));
		rdbtnF.setForeground(new Color(255, 255, 255));
		rdbtnF.setBackground(new Color(0, 0, 0));
		rdbtnF.setBounds(624, 295, 40, 23);
		contentPane.add(rdbtnF);

		rdbtnM = new JRadioButton("M");
		rdbtnM.setBackground(new Color(0, 0, 0));
		rdbtnM.setForeground(new Color(255, 255, 255));
		rdbtnM.setFont(new Font("Arial Black", Font.BOLD, 14));
		rdbtnM.setBounds(680, 295, 40, 23);
		contentPane.add(rdbtnM);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnM);
		grupo.add(rdbtnF);
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(350, 350, 240, 30);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		passwordField1 = new JPasswordField();
		passwordField1.setBounds(630, 350, 240, 30);
		contentPane.add(passwordField1);

		password2 = new JPasswordField();
		password2.setBounds(910, 350, 240, 30);
		contentPane.add(password2);

		textFieldDni = new JTextField();
		textFieldDni.setBounds(910, 224, 240, 30);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setLayout(null);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		contentPane.add(jPanelBarraSuperior);
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(Registrarse.class.getResource("/reto3/vista/imagenes/BotonAtras90x50.png")));
		btnAtras.setBounds(39, 0, 90, 50);
		jPanelBarraSuperior.add(btnAtras);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Registrarse.class.getResource("/reto3/vista/imagenes/Footer.png")));
		lblNewLabel.setBounds(0, 611, 1207, 50);
		contentPane.add(lblNewLabel);
		
		jLabelDNI = new JLabel("DNI:");
		jLabelDNI.setForeground(new Color(255, 255, 255));
		jLabelDNI.setFont(new Font("Arial Black", Font.BOLD, 14));
		jLabelDNI.setBounds(910, 195, 238, 33);
		contentPane.add(jLabelDNI);
		
		jLabelNombre = new JLabel("Nombre:");
		jLabelNombre.setForeground(Color.WHITE);
		jLabelNombre.setFont(new Font("Arial Black", Font.BOLD, 14));
		jLabelNombre.setBounds(70, 195, 238, 33);
		contentPane.add(jLabelNombre);
		
		lblApellido1 = new JLabel("Primer Apellido:");
		lblApellido1.setForeground(Color.WHITE);
		lblApellido1.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblApellido1.setBounds(351, 195, 238, 33);
		contentPane.add(lblApellido1);
		
		lblApellido2 = new JLabel("Segundo Apellido:");
		lblApellido2.setForeground(Color.WHITE);
		lblApellido2.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblApellido2.setBounds(630, 195, 238, 33);
		contentPane.add(lblApellido2);
		
		lblCompletaLosCampara = new JLabel("A UN PASO DE SER SOCIO");
		lblCompletaLosCampara.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompletaLosCampara.setForeground(Color.WHITE);
		lblCompletaLosCampara.setFont(new Font("Arial Black", Font.BOLD, 30));
		lblCompletaLosCampara.setBounds(249, 84, 709, 50);
		contentPane.add(lblCompletaLosCampara);
		
		lblNewLabel_1 = new JLabel("COMPLETA TODOS LOS CAMPOS PARA REGISTRARSE)");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(248, 212, 64));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(318, 120, 570, 29);
		contentPane.add(lblNewLabel_1);
		
		jLabelTelefono = new JLabel("Telefono:");
		jLabelTelefono.setForeground(Color.WHITE);
		jLabelTelefono.setFont(new Font("Arial Black", Font.BOLD, 14));
		jLabelTelefono.setBounds(70, 322, 240, 33);
		contentPane.add(jLabelTelefono);
		
		jLabelEmail = new JLabel("Email:");
		jLabelEmail.setForeground(Color.WHITE);
		jLabelEmail.setFont(new Font("Arial Black", Font.BOLD, 14));
		jLabelEmail.setBounds(350, 322, 240, 33);
		contentPane.add(jLabelEmail);
		
		jLabelPass1 = new JLabel("Nueva Contraseña:");
		jLabelPass1.setForeground(Color.WHITE);
		jLabelPass1.setFont(new Font("Arial Black", Font.BOLD, 14));
		jLabelPass1.setBounds(630, 322, 240, 33);
		contentPane.add(jLabelPass1);
		
		jLabelPass2 = new JLabel("Confirmar Contraseña:");
		jLabelPass2.setForeground(Color.WHITE);
		jLabelPass2.setFont(new Font("Arial Black", Font.BOLD, 14));
		jLabelPass2.setBounds(910, 322, 240, 33);
		contentPane.add(jLabelPass2);
		
		lblGenero = new JLabel("Genero:");
		lblGenero.setForeground(Color.WHITE);
		lblGenero.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblGenero.setBounds(543, 290, 121, 33);
		contentPane.add(lblGenero);
		
				JButton btnSignUp = new JButton("REGISTRARSE");
				btnSignUp.setBackground(new Color(0, 0, 0));
				btnSignUp.setForeground(new Color(255, 255, 255));
				btnSignUp.setFont(new Font("Arial Black", Font.BOLD, 30));
				btnSignUp.setBounds(303, 462, 600, 50);
				contentPane.add(btnSignUp);
				btnSignUp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//				if (!validar()) {

						GestorCliente gestor = new GestorCliente();
						gestor.insertCliente(serDatosCliente());
						Login login = new Login(cart);
						dispose();
						contentPane.setVisible(false);
						login.setVisible(true);

					}
				});
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login(cart);
				dispose();
				contentPane.setVisible(false);
				login.setVisible(true);
			}
		});
	}

	private boolean validar() {
		boolean ret = false;
		return ret;
	}

	private Cliente serDatosCliente() {
		Cliente ret = new Cliente();

		String apellido2 = null;
		if (!(textFieldApellido2.getText().isEmpty())) {
			apellido2 = textFieldApellido2.getText();
		}

		String genero = null;
		if (rdbtnM.isSelected()) {
			genero = "M";
		} else {
			genero = "F";
		}
		ret.setNombre(textFieldNombre.getText());
		ret.setApellido1(textFieldApellido1.getText());
		ret.setApellido2(apellido2);
		ret.setDni(textFieldDni.getText());
		ret.setGenero(genero.charAt(0));
		ret.setTele(textFieldTele.getText());
		ret.setEmail(textFieldEmail.getText());
		ret.setPassword(new String(passwordField1.getPassword()));
		return ret;

	}
}
