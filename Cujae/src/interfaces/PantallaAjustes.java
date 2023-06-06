package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaAjustes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaAjustes(final JFrame pantallaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonSalirAjustes = new JButton("Salir");
		botonSalirAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pantallaAnterior.setEnabled(true);
				pantallaAnterior.setVisible(true);
				dispose();
				
			}
		});
		botonSalirAjustes.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonSalirAjustes.setBounds(222, 354, 140, 23);
		contentPane.add(botonSalirAjustes);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PantallaAjustes.class.getResource("/texturas/megapibe.png")));
		lblNewLabel.setBounds(121, 45, 259, 251);
		contentPane.add(lblNewLabel);
	}
}
