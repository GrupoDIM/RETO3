package reto3.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SeleccionCines extends JFrame {

	private JPanel contentPane;
	private JTextField txtSele;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionCines frame = new SeleccionCines();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeleccionCines() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 212, 64));
		panel.setBounds(0, 0, 1207, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("INICIO");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(0, 0, 89, 37);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(33, 18, 97));
		panel_1.setBounds(0, 35, 1207, 626);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtSele = new JTextField();
		txtSele.setForeground(new Color(255, 255, 255));
		txtSele.setBackground(new Color(33, 18, 97));
		txtSele.setHorizontalAlignment(SwingConstants.CENTER);
		txtSele.setText("Seleccione un cine:");
		txtSele.setFont(new Font("Arial Black", Font.PLAIN, 30));
		txtSele.setBounds(180, 54, 846, 78);
		panel_1.add(txtSele);
		txtSele.setColumns(10);
	}
}
