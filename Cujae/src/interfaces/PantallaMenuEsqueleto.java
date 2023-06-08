package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JLabel;

public class PantallaMenuEsqueleto extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaMenuEsqueleto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton botonInvitado = new JButton("Invitado");
		botonInvitado.setBounds(150, 57, 160, 29);
		botonInvitado.setFont(new Font("Tahoma", Font.BOLD, 17));
		botonInvitado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PantallaMapa pM = new PantallaMapa(PantallaMenuEsqueleto.this);
				pM.setVisible(true);
				setEnabled(false);
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(botonInvitado);
		
		JButton botonIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		botonIniciarSesion.setBounds(150, 90, 160, 29);
		botonIniciarSesion.setFont(new Font("Tahoma", Font.BOLD, 17));
		botonIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InicioSesion iS = new InicioSesion(PantallaMenuEsqueleto.this);
				iS.setVisible(true);
				setEnabled(false);
			}
		});
		contentPane.add(botonIniciarSesion);
		
		JButton botonAjustesPantallaInicio = new JButton("");
		botonAjustesPantallaInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaAjustes pA = new PantallaAjustes(PantallaMenuEsqueleto.this);
				pA.setVisible(true);
				setEnabled(false);
			}
		});
		botonAjustesPantallaInicio.setBounds(399, 168, 65, 41);
		botonAjustesPantallaInicio.setIcon(new ImageIcon(PantallaMenuEsqueleto.class.getResource("/texturas/Ajustes.png")));
		contentPane.add(botonAjustesPantallaInicio);
		
		JLabel label = new JLabel("");
		label.setBounds(81, 57, 46, 0);
		contentPane.add(label);
		
		JButton botonSalirPantallaInicio = new JButton("Salir");
		botonSalirPantallaInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		botonSalirPantallaInicio.setBounds(150, 123, 160, 29);
		botonSalirPantallaInicio.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(botonSalirPantallaInicio);
		
		JButton buttonAcercaDe = new JButton("?");
		buttonAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AcercaDe iS = new AcercaDe(PantallaMenuEsqueleto.this);
				iS.setVisible(true);
				setEnabled(false);
			}
		});
		buttonAcercaDe.setFont(new Font("Arial Black", Font.PLAIN, 18));
		buttonAcercaDe.setBounds(324, 168, 65, 41);
		contentPane.add(buttonAcercaDe);
	}
}
