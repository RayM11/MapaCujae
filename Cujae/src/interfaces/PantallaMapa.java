package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaMapa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaMapa(final JFrame pantallaAnterior) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelContenedorOpciones = new JPanel();
		panelContenedorOpciones.setBounds(10, 63, 220, 436);
		panelContenedorOpciones.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panelContenedorOpciones);
		panelContenedorOpciones.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 177, 200, 230);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelContenedorOpciones.add(panel);
		panel.setLayout(null);
		
		JButton botónVisitarPantallaMapa = new JButton("Visitar");
		botónVisitarPantallaMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaVisita pV = new PantallaVisita(PantallaMapa.this);
				pV.setVisible(true);
				setEnabled(false);
				
			}
		});
		botónVisitarPantallaMapa.setFont(new Font("Tahoma", Font.BOLD, 13));
		botónVisitarPantallaMapa.setBounds(25, 59, 153, 23);
		panel.add(botónVisitarPantallaMapa);
		
		JButton botonInformaciónPantallaMpa = new JButton("M\u00E1s Informaci\u00F3n");
		botonInformaciónPantallaMpa.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonInformaciónPantallaMpa.setBounds(25, 101, 153, 23);
		panel.add(botonInformaciónPantallaMpa);
		
		JButton botonRutaViajePantallaMapa = new JButton("Ruta de Viaje");
		botonRutaViajePantallaMapa.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonRutaViajePantallaMapa.setBounds(25, 138, 153, 23);
		panel.add(botonRutaViajePantallaMapa);
		
		JButton botonMenúPantallaMapa = new JButton("Men\u00FA");
		botonMenúPantallaMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pantallaAnterior.setEnabled(true);
				pantallaAnterior.setVisible(true);
				dispose();
				
			}
		});
		botonMenúPantallaMapa.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonMenúPantallaMapa.setBounds(25, 172, 153, 23);
		panel.add(botonMenúPantallaMapa);
		
		JLabel lblNewLabel = new JLabel("aqu\u00ED sale una brebe descripci\u00F3n del lugar");
		lblNewLabel.setBounds(10, 11, 200, 155);
		panelContenedorOpciones.add(lblNewLabel);
		
		JPanel panelContenedorMapa = new JPanel();
		panelContenedorMapa.setBounds(240, 63, 569, 436);
		panelContenedorMapa.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panelContenedorMapa);
		
		JButton botonAjustePantallaMapa = new JButton("");
		botonAjustePantallaMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaAjustes pA = new PantallaAjustes(PantallaMapa.this);
				pA.setVisible(true);
				setEnabled(false);
				
			}
		});
		botonAjustePantallaMapa.setIcon(new ImageIcon(PantallaMapa.class.getResource("/texturas/Ajustes.png")));
		botonAjustePantallaMapa.setBounds(10, 11, 40, 31);
		contentPane.add(botonAjustePantallaMapa);
	}
}
