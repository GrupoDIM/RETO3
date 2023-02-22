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

public class GenerarFactura extends JFrame {

	private static final long serialVersionUID = -3459780300651637500L;
	private JPanel contentPane;

	public GenerarFactura(Factura factura , Carrito cart) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Cargar Factura");
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
		btnNewButton.setBounds(279, 153, 144, 35);
		contentPane.add(btnNewButton);
	}

}
