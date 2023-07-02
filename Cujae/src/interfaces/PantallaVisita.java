package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;

import auxiliar.Configuracion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;

public class PantallaVisita extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaVisita(final JFrame ventanaAnterior, Configuracion configActual) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setOpaque(false);
		panelBotones.setBorder(null);
		panelBotones.setBounds(10, 297, 152, 176);
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);
		
		JButton botonDireccionGirar = new JButton("");
		botonDireccionGirar.setBounds(120, 0, 33, 33);
		panelBotones.add(botonDireccionGirar);
		botonDireccionGirar.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/giro.png")));
		
		JButton salirBotonPantallaVisita = new JButton("Salir");
		salirBotonPantallaVisita.setBounds(31, 153, 89, 23);
		panelBotones.add(salirBotonPantallaVisita);
		salirBotonPantallaVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		salirBotonPantallaVisita.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton botonDirecionAdelante = new JButton("");
		botonDirecionAdelante.setBounds(63, 11, 26, 47);
		panelBotones.add(botonDirecionAdelante);
		botonDirecionAdelante.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/arriba.png")));
		
		JButton botonDireccionIzquierda = new JButton("");
		botonDireccionIzquierda.setBounds(10, 55, 53, 23);
		panelBotones.add(botonDireccionIzquierda);
		botonDireccionIzquierda.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/izquierda.png")));
		
		JButton botonDirecionDerecha = new JButton("");
		botonDirecionDerecha.setBounds(89, 55, 53, 23);
		panelBotones.add(botonDirecionDerecha);
		botonDirecionDerecha.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/derecha.png")));
		
		JButton botonDireccionAtras = new JButton("");
		botonDireccionAtras.setBounds(63, 77, 26, 45);
		panelBotones.add(botonDireccionAtras);
		botonDireccionAtras.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/abajo.png")));
		
		JButton button = new JButton("");
		button.setBounds(0, 0, 33, 33);
		panelBotones.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(0, 0, 723, 484);
		contentPane.add(lblNewLabel);
		botonDireccionAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {

				ventanaAnterior.setEnabled(true);
				ventanaAnterior.setVisible(true);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				ventanaAnterior.setEnabled(true);
				ventanaAnterior.setVisible(true);
			}

			@Override
			public void windowActivated(WindowEvent e) {
				
			}
		});
	}
}
