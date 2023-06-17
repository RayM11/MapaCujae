package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;

import auxiliar.Configuracion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class PantallaMapa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelContenedorOpciones;
	private JTextArea txtAreaDescripcion;
	private JLabel lblFotoLugar;
	private JLabel labelNombreLugar;
	private JPanel panelContenedorMapa;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmAjustes;
	private JMenu mnMisc;
	private JMenuItem mntmRutaMsCorta;
	private JMenuItem mntmVisitarLugar;
	private JMenuItem mntmMostrarInformacion;
	private JMenuItem mntmCrearLugar;
	private JMenu mnAcciones;
	private JMenuItem mntmVolver;
	private JMenu mnMenu;
	private JMenuBar menuBar;

	public PantallaMapa(final JFrame pantallaAnterior, final Configuracion configActual) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelContenedorOpciones = new JPanel();
		panelContenedorOpciones.setBounds(10, 63, 237, 597);
		panelContenedorOpciones.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panelContenedorOpciones);
		panelContenedorOpciones.setLayout(null);

		txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setText("Aqui va una breve descripci\u00F3n del lugar");
		txtAreaDescripcion.setWrapStyleWord(true);
		txtAreaDescripcion.setLineWrap(true);
		txtAreaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		txtAreaDescripcion.setEditable(false);
		txtAreaDescripcion.setBounds(10, 241, 217, 345);
		panelContenedorOpciones.add(txtAreaDescripcion);

		lblFotoLugar = new JLabel("");
		lblFotoLugar.setBounds(10, 11, 217, 181);
		panelContenedorOpciones.add(lblFotoLugar);

		labelNombreLugar = new JLabel("Nombre de lugar");
		labelNombreLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		labelNombreLugar.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreLugar.setBounds(10, 203, 217, 32);
		panelContenedorOpciones.add(labelNombreLugar);

		panelContenedorMapa = new JPanel();
		panelContenedorMapa.setBounds(257, 63, 627, 597);
		panelContenedorMapa.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panelContenedorMapa);
		panelContenedorMapa.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.setBounds(0, 0, 884, 21);
		contentPane.add(menuBar);

		mnMenu = new JMenu("Men\u00FA");
		mnMenu.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		menuBar.add(mnMenu);

		mntmVolver = new JMenuItem("Volver");
		mntmVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pantallaAnterior.setEnabled(true);
				pantallaAnterior.setVisible(true);
				configActual.setEsAdmin(false);
				dispose();


			}
		});
		mnMenu.add(mntmVolver);

		mnAcciones = new JMenu("Acciones");
		mnAcciones.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		menuBar.add(mnAcciones);
		
		mntmCrearLugar = new JMenuItem("Crear Nuevo Lugar");
		mntmCrearLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaRegistrarLugar vRL = new VentanaRegistrarLugar(PantallaMapa.this, configActual);
				vRL.setVisible(true);
				setEnabled(false);

			}
		});
		if(!configActual.getEsAdmin()){
			mntmCrearLugar.setEnabled(false);
		}
		mnAcciones.add(mntmCrearLugar);

		mntmMostrarInformacion = new JMenuItem("Mostrar Informaci\u00F3n");
		mnAcciones.add(mntmMostrarInformacion);

		mntmVisitarLugar = new JMenuItem("Visitar Lugar");
		mntmVisitarLugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PantallaVisita pV = new PantallaVisita(PantallaMapa.this, configActual);
				pV.setVisible(true);
				setEnabled(false);

			}
		});
		mnAcciones.add(mntmVisitarLugar);

		mntmRutaMsCorta = new JMenuItem("Ruta m\u00E1s corta");
		mnAcciones.add(mntmRutaMsCorta);

		mnMisc = new JMenu("Misc");
		mnMisc.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		menuBar.add(mnMisc);

		mntmAjustes = new JMenuItem("Ajustes");
		mntmAjustes.setIcon(new ImageIcon(PantallaMapa.class.getResource("/texturas/Ajustes.png")));
		mntmAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PantallaAjustes pA = new PantallaAjustes(PantallaMapa.this, configActual);
				pA.setVisible(true);
				setEnabled(false);

			}
		});
		mnMisc.add(mntmAjustes);

		mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AcercaDe iS = new AcercaDe(PantallaMapa.this, configActual);
				iS.setVisible(true);
				setEnabled(false);

			}
		});
		mnMisc.add(mntmAyuda);
		
	}
	
	public void ajustarFuentes(Configuracion configActual){
		
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mnMenu.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmVolver.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mnAcciones.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmCrearLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmMostrarInformacion.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmVisitarLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmRutaMsCorta.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mnMisc.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmAjustes.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmAyuda.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		
		labelNombreLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		txtAreaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		
	}
	
}
