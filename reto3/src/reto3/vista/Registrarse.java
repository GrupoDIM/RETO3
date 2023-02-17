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

	public Registrarse(Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(287, 68, 238, 33);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellido1 = new JTextField();
		textFieldApellido1.setBounds(287, 130, 238, 39);
		contentPane.add(textFieldApellido1);
		textFieldApellido1.setColumns(10);

		textFieldApellido2 = new JTextField();
		textFieldApellido2.setBounds(287, 210, 238, 39);
		contentPane.add(textFieldApellido2);
		textFieldApellido2.setColumns(10);

		textFieldTele = new JTextField();
		textFieldTele.setBounds(287, 330, 238, 39);
		contentPane.add(textFieldTele);
		textFieldTele.setColumns(10);

		rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(375, 281, 67, 23);
		contentPane.add(rdbtnF);

		rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(458, 281, 67, 23);
		contentPane.add(rdbtnM);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnM);
		grupo.add(rdbtnF);
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(287, 419, 238, 33);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		passwordField1 = new JPasswordField();
		passwordField1.setBounds(287, 485, 238, 33);
		contentPane.add(passwordField1);

		password2 = new JPasswordField();
		password2.setBounds(287, 538, 238, 33);
		contentPane.add(password2);

		JButton btnSignUp = new JButton("signUp");
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
		btnSignUp.setBounds(630, 218, 113, 31);
		contentPane.add(btnSignUp);

		textFieldDni = new JTextField();
		textFieldDni.setBounds(286, 11, 239, 35);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
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
