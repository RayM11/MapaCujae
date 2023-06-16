package interfaces;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import auxiliar.Configuracion;

import javax.swing.SwingConstants;

public class PantallaAjustes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String tema;
	private int tamanoFuente;
	private JButton botonAceptarAjustes;
	private JLabel lblTamanoFuente;
	private JComboBox<String> comBoxTemaVisual;
	private JComboBox<String> comBoxTamanoFuente;
	private JLabel lblTemaVisual;
	private JLabel labelConfiguracion;

	public PantallaAjustes(final JFrame pantallaAnterior, final Configuracion configActual) {

		tema = configActual.getTemaLAF();
		tamanoFuente = configActual.getTamanoFuente();
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 592, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		botonAceptarAjustes = new JButton("Aceptar");
		botonAceptarAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(getContentPane(), "¿Está seguro que desea mantener esta configuración?",
						"Aviso",2, JOptionPane.WARNING_MESSAGE);
				if (opcion == 0){
					configActual.guardarConfiguracion(tema, (String)comBoxTemaVisual.getSelectedItem(),
							tamanoFuente, (String)comBoxTamanoFuente.getSelectedItem());

					SwingUtilities.updateComponentTreeUI(pantallaAnterior);
					pantallaAnterior.setVisible(true);
					pantallaAnterior.setEnabled(true);
					dispose();
				}
			}
		});
		botonAceptarAjustes.setFont(new Font("Tahoma", Font.BOLD, 13));
		botonAceptarAjustes.setBounds(195, 355, 140, 23);
		contentPane.add(botonAceptarAjustes);

		lblTamanoFuente = new JLabel("Tama\u00F1o de fuente");
		lblTamanoFuente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTamanoFuente.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		lblTamanoFuente.setBounds(38, 195, 199, 32);
		contentPane.add(lblTamanoFuente);



		comBoxTemaVisual = new JComboBox<String>();
		comBoxTemaVisual.setModel(new DefaultComboBoxModel<String>(new String[] {"Acryl", "Aero", "Aluminiun", "Metal", "Nimbus", "NimROD", "Texture"}));
		comBoxTemaVisual.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		comBoxTemaVisual.setBounds(247, 95, 289, 32);
		comBoxTemaVisual.setSelectedItem(configActual.getTemaLAFnombre());
		comBoxTemaVisual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cambiarTema(comBoxTemaVisual.getSelectedIndex());
			}});
		contentPane.add(comBoxTemaVisual);

		comBoxTamanoFuente = new JComboBox<String>();
		comBoxTamanoFuente.setModel(new DefaultComboBoxModel<String>(new String[] {"Peque\u00F1o", "Mediano", "Grande"}));
		comBoxTamanoFuente.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		comBoxTamanoFuente.setBounds(247, 195, 289, 32);
		comBoxTamanoFuente.setSelectedItem(configActual.getTamanoFuenteNombre());
		comBoxTamanoFuente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cambiarFuente(comBoxTamanoFuente.getSelectedIndex());


			}});
		contentPane.add(comBoxTamanoFuente);

		lblTemaVisual = new JLabel("Tema visual");
		lblTemaVisual.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTemaVisual.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		lblTemaVisual.setBounds(38, 95, 199, 32);
		contentPane.add(lblTemaVisual);

		labelConfiguracion = new JLabel("Configuraci\u00F3n");
		labelConfiguracion.setHorizontalAlignment(SwingConstants.CENTER);
		labelConfiguracion.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		labelConfiguracion.setBounds(83, 11, 380, 50);
		contentPane.add(labelConfiguracion);
	}

	public void cambiarTema(int eleccion){

		switch (eleccion){
		case 0:
			tema = "com.jtattoo.plaf.acryl.AcrylLookAndFeel";
			break;
		case 1:
			tema = "com.jtattoo.plaf.aero.AeroLookAndFeel";
			break;
		case 2:
			tema = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
			break;
		case 3:
			tema = "javax.swing.plaf.metal.MetalLookAndFeel";
			break;
		case 4:
			tema = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
			break;
		case 5:
			tema = "com.nilo.plaf.nimrod.NimRODLookAndFeel";
			break;
		case 6:
			tema = "com.jtattoo.plaf.texture.TextureLookAndFeel";
			break;
		}
		try {
			UIManager.setLookAndFeel(tema);
			SwingUtilities.updateComponentTreeUI(PantallaAjustes.this);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}

	}

	public void cambiarFuente(int eleccion){

		switch (eleccion){
		case 0:
			tamanoFuente = 11 ;
			break;
		case 1:
			tamanoFuente = 13;
			break;
		case 2:
			tamanoFuente = 16;
			break;
		}
		lblTemaVisual.setFont(new Font("Tahoma", Font.PLAIN, tamanoFuente));
		comBoxTemaVisual.setFont(new Font("Tahoma", Font.PLAIN, tamanoFuente));
		lblTamanoFuente.setFont(new Font("Tahoma", Font.PLAIN, tamanoFuente));
		comBoxTamanoFuente.setFont(new Font("Tahoma", Font.PLAIN, tamanoFuente));
	}

}
