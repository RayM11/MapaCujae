package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPresentación extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public PantallaPresentación() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaMenuEsqueleto pME = new PantallaMenuEsqueleto();
				pME.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(216, 303, 139, 33);
		contentPane.add(btnNewButton);
		
		JProgressBar barraCargaPantallaPresentación = new JProgressBar();
		barraCargaPantallaPresentación.setFont(new Font("Tahoma", Font.BOLD, 11));
		barraCargaPantallaPresentación.setForeground(Color.GREEN);
		barraCargaPantallaPresentación.setStringPainted(true);
		barraCargaPantallaPresentación.setBounds(181, 239, 194, 14);
		contentPane.add(barraCargaPantallaPresentación);
		
		JLabel papelTapuis = new JLabel("d");
		papelTapuis.setIcon(new ImageIcon(PantallaPresentación.class.getResource("/texturas/tapiz.jpg")));
		papelTapuis.setBounds(0, 0, 534, 221);
		contentPane.add(papelTapuis);
	}
}
