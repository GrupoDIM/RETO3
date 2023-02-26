package reto3.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;

import reto3.controlador.Cart.Carrito;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bienvenida {

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public Bienvenida() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
	
		frame = new JFrame();
		frame.setBounds(100, 100, 1223, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false); 
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

	
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBounds(0, 0, 1207, 661);
		frame.getContentPane().add(panelBienvenida);
		panelBienvenida.setLayout(null);

	
		JButton jButtonBienvenida = new JButton("");
		jButtonBienvenida.setIcon(new ImageIcon(Bienvenida.class.getResource("/reto3/vista/imagenes/Bienvenida.png")));
		jButtonBienvenida.setBounds(0, 0, 1207, 661);
		panelBienvenida.add(jButtonBienvenida);
		jButtonBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelBienvenida.setVisible(false); 
				frame.dispose(); 
				SeleccionCines seleccionCines = new SeleccionCines(new Carrito());
				seleccionCines.setVisible(true);
			}
		});

	}
}
