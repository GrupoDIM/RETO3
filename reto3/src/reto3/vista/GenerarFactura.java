package reto3.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import reto3.bbdd.gestores.GestorFicheros;
import reto3.bbdd.pojo.Factura;
import reto3.controlador.Cart.Carrito;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GenerarFactura extends JFrame {

	private static final long serialVersionUID = -3459780300651637500L;
	private JPanel contentPane;

	public GenerarFactura(Factura factura , Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(33, 18, 97));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); // Desativado la redimenzionalidad
		setLocationRelativeTo(null); // Posicionamiento central de la pantalla

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("GENERAR FACTURA");
		btnNewButton.setBackground(new Color(248, 212, 64));
		btnNewButton.setForeground(new Color(33, 18, 97));
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorFicheros gestor = new GestorFicheros();
				gestor.writeFile(factura);
				cart.getCompras().clear();
				Bienvenida bienvenida = new Bienvenida();
				dispose();
				contentPane.setVisible(false);
				bienvenida.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(453, 300, 300, 60);
		contentPane.add(btnNewButton);
		
		JPanel jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setLayout(null);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setBounds(0, 0, 1207, 50);
		contentPane.add(jPanelBarraSuperior);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GenerarFactura.class.getResource("/reto3/vista/imagenes/Footer.png")));
		lblNewLabel.setBounds(0, 611, 1207, 50);
		contentPane.add(lblNewLabel);
		
		JLabel jLabelFondoFactura = new JLabel("");
		jLabelFondoFactura.setIcon(new ImageIcon(GenerarFactura.class.getResource("/reto3/vista/imagenes/FondoFactura.gif")));
		jLabelFondoFactura.setBounds(0, 50, 1207, 561);
		contentPane.add(jLabelFondoFactura);
	}

}
