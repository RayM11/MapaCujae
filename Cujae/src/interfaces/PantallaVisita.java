package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaVisita extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaVisita(final JFrame pantallaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botonDireccionGirar = new JButton("");
		botonDireccionGirar.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/giro.png")));
		botonDireccionGirar.setBounds(73, 368, 26, 23);
		contentPane.add(botonDireccionGirar);
		
		JButton salirBotonPantallaVisita = new JButton("Salir");
		salirBotonPantallaVisita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pantallaAnterior.setEnabled(true);
				pantallaAnterior.setVisible(true);
				dispose();
				
			}
		});
		salirBotonPantallaVisita.setFont(new Font("Tahoma", Font.BOLD, 13));
		salirBotonPantallaVisita.setBounds(10, 11, 89, 23);
		contentPane.add(salirBotonPantallaVisita);
		
		JButton botonDirecionAdelante = new JButton("");
		botonDirecionAdelante.setBounds(73, 312, 26, 47);
		contentPane.add(botonDirecionAdelante);
		botonDirecionAdelante.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/arriba.png")));
		
		JButton botonDireccionIzquierda = new JButton("");
		botonDireccionIzquierda.setBounds(10, 368, 53, 23);
		contentPane.add(botonDireccionIzquierda);
		botonDireccionIzquierda.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/izquierda.png")));
		
		JButton botonDirecionDerecha = new JButton("");
		botonDirecionDerecha.setBounds(109, 368, 53, 23);
		contentPane.add(botonDirecionDerecha);
		botonDirecionDerecha.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/derecha.png")));
		
		JButton botonDireccionAtras = new JButton("");
		botonDireccionAtras.setIcon(new ImageIcon(PantallaVisita.class.getResource("/texturas/abajo.png")));
		botonDireccionAtras.setBounds(73, 409, 26, 45);
		contentPane.add(botonDireccionAtras);
		botonDireccionAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
}
