package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JProgressBar;

import auxiliar.Configuracion;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PantallaPresentacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JProgressBar barraCargaPantallaPresentacion;


	private void cargarBarra(){

		Thread x = new Thread(){

			public void run(){
				for(int i = 0; i <= 100; i++){

					try {
						Thread.sleep(10);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					barraCargaPantallaPresentacion.setValue(i);
				}
				btnNewButton.setEnabled(true);
				btnNewButton.setText("Continuar");
			}

		};

		x.start();
	}

	public PantallaPresentacion(final Configuracion configActual) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Iniciar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(btnNewButton.getText().equalsIgnoreCase("Iniciar")){

					btnNewButton.setEnabled(false);
					cargarBarra();

				}else{

					PantallaMenuEsqueleto pME = new PantallaMenuEsqueleto(configActual);
					pME.setVisible(true);
					dispose();

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(212, 350, 139, 33);
		contentPane.add(btnNewButton);

		barraCargaPantallaPresentacion = new JProgressBar();
		barraCargaPantallaPresentacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		barraCargaPantallaPresentacion.setForeground(Color.GREEN);
		barraCargaPantallaPresentacion.setStringPainted(true);
		barraCargaPantallaPresentacion.setBounds(169, 294, 216, 25);
		contentPane.add(barraCargaPantallaPresentacion);

		JLabel papelTapuis = new JLabel("");
		papelTapuis.setIcon(new ImageIcon(PantallaPresentacion.class.getResource("/texturas/tapiz.jpg")));
		papelTapuis.setBounds(0, 55, 544, 221);
		contentPane.add(papelTapuis);
		
		JLabel lblMapacujae = new JLabel("MapaCUJAE");
		lblMapacujae.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblMapacujae.setHorizontalAlignment(SwingConstants.CENTER);
		lblMapacujae.setBounds(96, 0, 339, 46);
		contentPane.add(lblMapacujae);
	}
}
