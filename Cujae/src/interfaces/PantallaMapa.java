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

import auxiliar.Configuracion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class PantallaMapa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public PantallaMapa(final JFrame pantallaAnterior, final Configuracion configActual) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelContenedorOpciones = new JPanel();
		panelContenedorOpciones.setBounds(10, 63, 237, 597);
		panelContenedorOpciones.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panelContenedorOpciones);
		panelContenedorOpciones.setLayout(null);

		JTextArea txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setText("Aqui va una breve descripci\u00F3n del lugar");
		txtAreaDescripcion.setWrapStyleWord(true);
		txtAreaDescripcion.setLineWrap(true);
		txtAreaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		txtAreaDescripcion.setEditable(false);
		txtAreaDescripcion.setBounds(10, 241, 217, 345);
		panelContenedorOpciones.add(txtAreaDescripcion);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 11, 217, 181);
		panelContenedorOpciones.add(lblNewLabel);

		JLabel labelNombreLugar = new JLabel("Nombre de lugar");
		labelNombreLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		labelNombreLugar.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreLugar.setBounds(10, 203, 217, 32);
		panelContenedorOpciones.add(labelNombreLugar);

		JPanel panelContenedorMapa = new JPanel();
		panelContenedorMapa.setBounds(257, 63, 627, 597);
		panelContenedorMapa.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panelContenedorMapa);
		panelContenedorMapa.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.setBounds(0, 0, 884, 21);
		contentPane.add(menuBar);

		JMenu mnMenu = new JMenu("Men\u00FA");
		mnMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnMenu);

		JMenuItem mntmVolver = new JMenuItem("Volver");
		mntmVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantallaAnterior.setEnabled(true);
				pantallaAnterior.setVisible(true);
				dispose();


			}
		});
		mnMenu.add(mntmVolver);

		JMenu mnAcciones = new JMenu("Acciones");
		menuBar.add(mnAcciones);

		JMenuItem mntmCrere = new JMenuItem("Crear Nuevo Lugar");
		mntmCrere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaRegistrarLugar vRL = new VentanaRegistrarLugar(PantallaMapa.this, configActual);
				vRL.setVisible(true);
				setEnabled(false);

			}
		});
		mnAcciones.add(mntmCrere);

		JMenuItem mntmMostrarInformacion = new JMenuItem("Mostrar Informaci\u00F3n");
		mnAcciones.add(mntmMostrarInformacion);

		JMenuItem mntmVisitarLugar = new JMenuItem("Visitar Lugar");
		mntmVisitarLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PantallaVisita pV = new PantallaVisita(PantallaMapa.this, configActual);
				pV.setVisible(true);
				setEnabled(false);

			}
		});
		mnAcciones.add(mntmVisitarLugar);

		JMenuItem mntmRutaMsCorta = new JMenuItem("Ruta m\u00E1s corta");
		mnAcciones.add(mntmRutaMsCorta);

		JMenu mnMisc = new JMenu("Misc");
		menuBar.add(mnMisc);

		JMenuItem mntmAjustes = new JMenuItem("Ajustes");
		mntmAjustes.setIcon(new ImageIcon(PantallaMapa.class.getResource("/texturas/Ajustes.png")));
		mntmAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PantallaAjustes pA = new PantallaAjustes(PantallaMapa.this, configActual);
				pA.setVisible(true);
				setEnabled(false);

			}
		});
		mnMisc.add(mntmAjustes);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AcercaDe iS = new AcercaDe(PantallaMapa.this, configActual);
				iS.setVisible(true);
				setEnabled(false);

			}
		});
		mnMisc.add(mntmAyuda);
	}
}
