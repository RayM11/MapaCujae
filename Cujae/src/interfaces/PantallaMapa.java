package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ImageIcon;

import auxiliar.Configuracion;
import auxiliar.Convert;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import logica.Cafeteria;
import logica.Facultad;
import logica.LugarDeInteres;
import mapaSwing.mapPanelSwing;

import javax.swing.JScrollBar;

public class PantallaMapa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelContenedorOpciones;
	private JTextArea txtAreaDescripcion;
	private JLabel lblFotoLugar;
	private JLabel labelNombreLugar;
	private mapPanelSwing panelMapa;
	private JMenuItem mntmAyuda;
	private JMenuItem mntmAjustes;
	private JMenu mnMisc;
	private JMenuItem mntmRutaMsCorta;
	private JMenuItem mntmVisitarLugar;
	private JMenuItem mntmCrearLugar;
	private JMenu mnAcciones;
	private JMenuItem mntmVolver;
	private JMenu mnMenu;
	private JMenuBar menuBar;
	private JTextArea textAreaAnotaciones;
	private JLabel labelEspecifico;
	private JLabel labelAnotaciones;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTextArea textAreaDecano;
	private JList<String> listCafeteria;
	private JPanel panelEspecifico;
	private JMenuItem mntmCrearCamino;
	private JMenuItem mntmEliminarCamino;
	private JMenuItem mntmEliminarLugar;
	private JMenuItem mntmModificarLugar;
	private JMenuItem mntmDecisionAsistida;
	private JScrollBar scrollBar;

	public void llenarPanelInfo(LugarDeInteres lugar){

		panelEspecifico.removeAll();

		if(lugar!=null){
			lblFotoLugar.setIcon(Convert.rezizarImagen(lugar.getFoto(), 207, 143));
			labelNombreLugar.setText(lugar.getNombre());
			txtAreaDescripcion.setText(lugar.getDescripcion());
			textAreaAnotaciones.setText(lugar.getAnotaciones());

			if(lugar instanceof Facultad){
				labelEspecifico = new JLabel("");
				labelEspecifico.setBounds(0, 0, 217, 23);
				panelEspecifico.add(labelEspecifico);
				labelEspecifico.setText("Decano/s");

				textAreaDecano = new JTextArea();
				textAreaDecano.setBounds(0, 25, 217, 70);
				textAreaDecano.setWrapStyleWord(true);
				textAreaDecano.setText("");
				textAreaDecano.setLineWrap(true);
				textAreaDecano.setFont(new Font("Tahoma", Font.PLAIN, 0));
				textAreaDecano.setEditable(false);
				textAreaDecano.setText(((Facultad) lugar).getDecano());
				panelEspecifico.add(textAreaDecano);

			}
			else if(lugar instanceof Cafeteria){
				labelEspecifico = new JLabel("");
				labelEspecifico.setBounds(0, 0, 217, 23);
				panelEspecifico.add(labelEspecifico);
				labelEspecifico.setText("Productos");

				DefaultListModel<String> model = new DefaultListModel<String>();
				for(String string:((Cafeteria) lugar).getProductos())
					model.addElement(string);
				listCafeteria = new JList<String>(model);
				listCafeteria.setBounds(0, 25, 217, 70);
				panelEspecifico.add(listCafeteria);
			}
		}else{
			lblFotoLugar.setIcon(Convert.rezizarImagen("", 207, 143));
			labelNombreLugar.setText("Nombre del lugar");
			txtAreaDescripcion.setText("");
			textAreaAnotaciones.setText("");


		}

		panelEspecifico.revalidate();
		SwingUtilities.updateComponentTreeUI(panelEspecifico);
	}


	public PantallaMapa(final JFrame ventanaAnterior, final Configuracion configActual) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 978, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelContenedorOpciones = new JPanel();
		panelContenedorOpciones.setBounds(10, 32, 237, 633);
		panelContenedorOpciones.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panelContenedorOpciones);
		panelContenedorOpciones.setLayout(null);

		txtAreaDescripcion = new JTextArea();
		txtAreaDescripcion.setWrapStyleWord(true);
		txtAreaDescripcion.setLineWrap(true);
		txtAreaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		txtAreaDescripcion.setEditable(false);
		txtAreaDescripcion.setBounds(10, 239, 217, 133);
		panelContenedorOpciones.add(txtAreaDescripcion);

		lblFotoLugar = new JLabel("");
		lblFotoLugar.setBounds(10, 21, 217, 164);
		panelContenedorOpciones.add(lblFotoLugar);

		labelNombreLugar = new JLabel("Nombre de lugar");
		labelNombreLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		labelNombreLugar.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreLugar.setBounds(10, 196, 217, 32);
		panelContenedorOpciones.add(labelNombreLugar);

		textAreaAnotaciones = new JTextArea();
		textAreaAnotaciones.setWrapStyleWord(true);
		textAreaAnotaciones.setText("Aqui va una breve descripci\u00F3n del lugar");
		textAreaAnotaciones.setLineWrap(true);
		textAreaAnotaciones.setFont(new Font("Tahoma", Font.PLAIN, 0));
		textAreaAnotaciones.setEditable(false);
		textAreaAnotaciones.setBounds(10, 405, 217, 66);
		panelContenedorOpciones.add(textAreaAnotaciones);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(10, 599, 89, 23);
		panelContenedorOpciones.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(138, 599, 89, 23);
		panelContenedorOpciones.add(btnEliminar);

		labelAnotaciones = new JLabel("Anotaciones");
		labelAnotaciones.setHorizontalAlignment(SwingConstants.CENTER);
		labelAnotaciones.setFont(new Font("Arial", Font.PLAIN, 14));
		labelAnotaciones.setBounds(10, 380, 217, 23);
		panelContenedorOpciones.add(labelAnotaciones);

		panelEspecifico = new JPanel();
		panelEspecifico.setBorder(null);
		panelEspecifico.setBounds(10, 482, 217, 106);
		panelContenedorOpciones.add(panelEspecifico);
		panelEspecifico.setLayout(null);




		JPanel panelContenedorMapa = new JPanel();
		panelContenedorMapa.setBounds(257, 32, 707, 631);
		panelContenedorMapa.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panelContenedorMapa);
		/*JScrollPane scrollMapa = new JScrollPane(panelMapa);
		scrollMapa.setSize(707, 631);
		scrollMapa.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panelContenedorMapa.add(scrollMapa, BorderLayout.CENTER);*/
		panelContenedorMapa.setLayout(null);
		
		panelMapa = new mapPanelSwing();
		panelMapa.setLocation(0, 7);
		panelMapa.setPreferredSize(new Dimension(680, 1045));
		panelMapa.setSize(680, 1045);
		panelContenedorMapa.add(panelMapa);
		panelMapa.repaint();
		panelMapa.revalidate();
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(682, 7, 17, 613);
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
		    public void adjustmentValueChanged(AdjustmentEvent e) {
		        panelMapa.setLocation(panelMapa.getX(), (int) (-e.getValue()*4.5));
		    }
		});
		panelContenedorMapa.add(scrollBar);
		panelContenedorMapa.addMouseWheelListener(new MouseWheelListener() {
		    public void mouseWheelMoved(MouseWheelEvent e) {
		        int scrollAmount = e.getScrollAmount();
		        int scrollType = e.getScrollType();
		        int currentValue;

		        if (scrollType == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
		            currentValue = scrollBar.getValue();
		            scrollBar.setValue(currentValue + (scrollAmount * e.getWheelRotation()*4));
		        }
		    }
		});
		
		
		/*Dimension preferredSize = new Dimension(450, 570);

		MapPanelFX mapPanel = new MapPanelFX(Universidad.getCujae().getMapa());
		panelContenedorMapa.add(mapPanel.getComponenteDeSwing(), BorderLayout.CENTER);
		mapPanel.inicializarGC();
*/		




		 menuBar = new JMenuBar();
		 menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		 menuBar.setBounds(0, 0, 964, 21);
		 contentPane.add(menuBar);

		 mnMenu = new JMenu("Men\u00FA");
		 mnMenu.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		 menuBar.add(mnMenu);

		 mntmVolver = new JMenuItem("Volver");
		 mntmVolver.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {

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

				 VentanaRegistrarLugar vRL = new VentanaRegistrarLugar(null ,PantallaMapa.this, configActual);
				 vRL.setVisible(true);
				 setEnabled(false);

			 }
		 });
		 if(!configActual.getEsAdmin()){
			 mntmCrearLugar.setEnabled(false);
		 }

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

		 mntmDecisionAsistida = new JMenuItem("Decisi\u00F3n Asistida");
		 mnAcciones.add(mntmDecisionAsistida);
		 mnAcciones.add(mntmCrearLugar);

		 mntmModificarLugar = new JMenuItem("Modificar Lugar");
		 mnAcciones.add(mntmModificarLugar);

		 mntmEliminarLugar = new JMenuItem("Eliminar Lugar");
		 mnAcciones.add(mntmEliminarLugar);

		 mntmCrearCamino = new JMenuItem("Crear Camino");
		 mnAcciones.add(mntmCrearCamino);

		 mntmEliminarCamino = new JMenuItem("Eliminar Camino");
		 mnAcciones.add(mntmEliminarCamino);

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
		 mntmAyuda.setIcon(new ImageIcon(PantallaMapa.class.getResource("/texturas/signo de pregunta")));
		 mntmAyuda.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {

				 AcercaDe iS = new AcercaDe(PantallaMapa.this, configActual);
				 iS.setVisible(true);
				 setEnabled(false);

			 }
		 });
		 mnMisc.add(mntmAyuda);
		 
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

	public void ajustarFuentes(Configuracion configActual){

		menuBar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mnMenu.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmVolver.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));

		mnAcciones.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmCrearLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmModificarLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmEliminarLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmVisitarLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmRutaMsCorta.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmCrearCamino.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmEliminarCamino.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmDecisionAsistida.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));

		mnMisc.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmAjustes.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		mntmAyuda.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));

		labelNombreLugar.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		txtAreaDescripcion.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		textAreaAnotaciones.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));


	}
}
