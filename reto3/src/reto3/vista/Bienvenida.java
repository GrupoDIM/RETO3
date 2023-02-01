package reto3.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Bienvenida {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bienvenida window = new Bienvenida();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		

		
	}
}
