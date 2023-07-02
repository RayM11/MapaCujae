package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;

import javax.swing.JButton;

import auxiliar.Configuracion;
import auxiliar.Direccion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import logica.Cafeteria;
import logica.Facultad;
import logica.Lugar;
import logica.LugarDeInteres;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaRegistrarLugar extends JFrame {

	private static final long serialVersionUID = 1L;

	private Configuracion configActual;
	private JPanel contentPane;
	private JTextField textFieldFotoN;
	private JTextField textFieldFotoS;
	private JTextField textFieldDecano;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel;
	private JCheckBox chckbxNewCheckBox;
	private JPanel panelConfirmacion;
	private JButton buttonConfirmacion;
	private JButton buttonCancelar;
	private JPanel panelLugarInteres;
	private JTextArea textAreaDescripcion;
	private JTextArea textAreaAnotaciones;
	private JPanel panelCamposEspecificos;
	private JPanel panelComboBox;
	private JComboBox<Object> comboBox;
	private JTextField textFieldFotoE;
	private JTextField textFieldFotoO;
	private JTextField textFieldFotoPortada;
	private JTextArea textAreaProductos;
	private Lugar lugarOriginal;


	public Lugar getLugarOriginal() {
		return lugarOriginal;
	}

	public void setLugarOriginal(Lugar lugarOriginal) {
		this.lugarOriginal = lugarOriginal;
	}


	private void configurarPanelesParaModificar(){

		if(lugarOriginal.getId()!= null && lugarOriginal instanceof LugarDeInteres){

			chckbxNewCheckBox.setSelected(true);
			chckbxNewCheckBox.getItemListeners()[0].itemStateChanged(new ItemEvent(chckbxNewCheckBox, ItemEvent.ITEM_STATE_CHANGED, chckbxNewCheckBox, ItemEvent.SELECTED));

			if(lugarOriginal instanceof Facultad)
				comboBox.setSelectedItem("Facultad");

			else if(lugarOriginal instanceof Cafeteria)
				comboBox.setSelectedItem("Cafeter\u00EDa");

			comboBox.getItemListeners()[0].itemStateChanged(new ItemEvent(comboBox, ItemEvent.SELECTED, comboBox.getSelectedItem(), ItemEvent.SELECTED));

		}
		cargarCamposPorLugar();

	}


	private void cargarCamposPorLugar(){

		if(lugarOriginal.getId() != null){


			textFieldFotoN.setText(lugarOriginal.getFotoDir(Direccion.N));
			textFieldFotoS.setText(lugarOriginal.getFotoDir(Direccion.S));
			textFieldFotoE.setText(lugarOriginal.getFotoDir(Direccion.E));
			textFieldFotoO.setText(lugarOriginal.getFotoDir(Direccion.O));

			if(lugarOriginal instanceof LugarDeInteres){



				textAreaDescripcion.setText(((LugarDeInteres)lugarOriginal).getDescripcion());
				textAreaAnotaciones.setText(((LugarDeInteres)lugarOriginal).getAnotaciones());
				textFieldNombre.setText(((LugarDeInteres)lugarOriginal).getNombre());
				textFieldFotoPortada.setText(((LugarDeInteres)lugarOriginal).getFotoPortada() );

				if(!comboBox.getSelectedItem().toString().equals("General"))
					if( lugarOriginal instanceof Facultad)
						textFieldDecano.setText(((Facultad)lugarOriginal).getDecano());
					else  if( lugarOriginal instanceof Cafeteria)
						textAreaProductos.setText(String.join("\n", ((Cafeteria) lugarOriginal).getProductos()));


			}
		}


	}


	public void configurarPanelLugarInteres(){

		boolean check = chckbxNewCheckBox.isSelected();

		panelLugarInteres.removeAll();
		panelComboBox.removeAll();

		if(check){

			comboBox = new JComboBox<Object>();
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"General", "Facultad", "Cafeter\u00EDa"}));
			comboBox.setSelectedIndex(0);
			comboBox.setBounds(0, 11, 126, 23);
			comboBox.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {

					String tipo = comboBox.getSelectedItem().toString();
					crearCamposEspecificos(tipo, configActual);
					SwingUtilities.updateComponentTreeUI(panelCamposEspecificos);

					if(tipo.equalsIgnoreCase("Facultad")){
						textFieldDecano.setBorder(null);
						textFieldNombre.setBorder(null);
						textFieldFotoPortada.setBorder(null);
					}

				}
			});
			panelComboBox.add(comboBox);


			textAreaDescripcion = new JTextArea();
			textAreaDescripcion.setLineWrap(true);
			textAreaDescripcion.setBounds(10, 139, 255, 177);
			panelLugarInteres.add(textAreaDescripcion);

			JLabel labelDescripcion = new JLabel("Descripci\u00F3n:");
			labelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelDescripcion.setBounds(10, 105, 126, 23);
			panelLugarInteres.add(labelDescripcion);

			textAreaAnotaciones = new JTextArea();
			textAreaAnotaciones.setLineWrap(true);
			textAreaAnotaciones.setBounds(10, 361, 255, 207);
			panelLugarInteres.add(textAreaAnotaciones);

			JLabel labelAnotaciones = new JLabel("Anotaciones:");
			labelAnotaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelAnotaciones.setBounds(10, 327, 126, 23);
			panelLugarInteres.add(labelAnotaciones);




			JSeparator separator_3 = new JSeparator();
			separator_3.setBounds(10, 45, 242, 2);
			panelLugarInteres.add(separator_3);

			textFieldNombre = new JTextField();
			textFieldNombre.setOpaque(false);
			textFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textFieldNombre.setColumns(10);
			textFieldNombre.setBorder(null);
			textFieldNombre.setBounds(20, 27, 232, 20);
			panelLugarInteres.add(textFieldNombre);

			JLabel labelNombre = new JLabel("Nombre:");
			labelNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelNombre.setBounds(10, 11, 126, 23);
			panelLugarInteres.add(labelNombre);

			JLabel lblFotoDePortada = new JLabel("Foto de Portada:");
			lblFotoDePortada.setBounds(10, 58, 97, 14);
			panelLugarInteres.add(lblFotoDePortada);

			textFieldFotoPortada = new JTextField();
			textFieldFotoPortada.setOpaque(false);
			textFieldFotoPortada.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textFieldFotoPortada.setColumns(10);
			textFieldFotoPortada.setBorder(null);
			textFieldFotoPortada.setBounds(10, 71, 232, 20);
			panelLugarInteres.add(textFieldFotoPortada);

			JSeparator separator = new JSeparator();
			separator.setBounds(10, 89, 242, 2);
			panelLugarInteres.add(separator);

		}
		else
			panelCamposEspecificos.removeAll();

		panelLugarInteres.revalidate();
		contentPane.revalidate();

		SwingUtilities.updateComponentTreeUI(panelLugarInteres);
		SwingUtilities.updateComponentTreeUI(panelCamposEspecificos);
		SwingUtilities.updateComponentTreeUI(panelComboBox);

		if(check){
			textFieldNombre.setBorder(null);
			textFieldFotoPortada.setBorder(null);
		}
		cargarCamposPorLugar();

	}

	private void crearCamposEspecificos(String tipo, Configuracion configActual){


		panelCamposEspecificos.removeAll();

		if(tipo.equalsIgnoreCase("Facultad")){


			JLabel labelDecano = new JLabel("Decano:");
			labelDecano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelDecano.setBounds(70, 118, 126, 23);
			panelCamposEspecificos.add(labelDecano);

			JSeparator separator_41 = new JSeparator();
			separator_41.setBounds(70, 159, 242, 2);
			panelCamposEspecificos.add(separator_41);

			textFieldDecano = new JTextField();
			textFieldDecano.setOpaque(false);
			textFieldDecano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textFieldDecano.setColumns(10);
			textFieldDecano.setBorder(null);
			textFieldDecano.setBounds(80, 141, 232, 20);
			panelCamposEspecificos.add(textFieldDecano);


		}
		else if (tipo.equalsIgnoreCase("Cafeter\u00EDa")){

			JLabel lblProductos = new JLabel("Productos");
			lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
			lblProductos.setBounds(69, 11, 236, 33);
			lblProductos.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
			panelCamposEspecificos.add(lblProductos);

			textAreaProductos = new JTextArea();
			textAreaProductos.setWrapStyleWord(true);
			textAreaProductos.setLineWrap(true);
			textAreaProductos.setBounds(32, 53, 315, 236);
			panelCamposEspecificos.add(textAreaProductos);
		}

		panelCamposEspecificos.revalidate();
		cargarCamposPorLugar();



	}

	public VentanaRegistrarLugar(Lugar lugar, final JFrame ventanaAnterior , final Configuracion configActual) {

		setLugarOriginal(lugar);
		this.configActual = configActual;

		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 900, 700);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Nuevo Lugar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(264, 11, 177, 38);
		contentPane.add(lblNewLabel);

		panelComboBox = new JPanel();
		panelComboBox.setBorder(null);
		panelComboBox.setBounds(166, 251, 275, 44);
		contentPane.add(panelComboBox);
		panelComboBox.setLayout(null);

		chckbxNewCheckBox = new JCheckBox("De inter\u00E9s");
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				configurarPanelLugarInteres();

			}
		});
		chckbxNewCheckBox.setBounds(494, 22, 97, 23);
		contentPane.add(chckbxNewCheckBox);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 120, 242, 2);
		contentPane.add(separator_1);

		textFieldFotoN = new JTextField();
		textFieldFotoN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldFotoN.setOpaque(false);
		textFieldFotoN.setColumns(10);
		textFieldFotoN.setBorder(null);
		textFieldFotoN.setBounds(30, 102, 232, 20);
		contentPane.add(textFieldFotoN);

		JLabel lblUrlFoto = new JLabel("URL Foto Norte:");
		lblUrlFoto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFoto.setBounds(20, 75, 126, 23);
		contentPane.add(lblUrlFoto);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 218, 242, 2);
		contentPane.add(separator_2);

		textFieldFotoS = new JTextField();
		textFieldFotoS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldFotoS.setOpaque(false);
		textFieldFotoS.setColumns(10);
		textFieldFotoS.setBorder(null);
		textFieldFotoS.setBounds(30, 200, 232, 20);
		contentPane.add(textFieldFotoS);

		JLabel lblUrlFotoReversa = new JLabel("URL Foto Sur:");
		lblUrlFotoReversa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFotoReversa.setBounds(20, 173, 126, 23);
		contentPane.add(lblUrlFotoReversa);

		panelLugarInteres = new JPanel();
		panelLugarInteres.setVisible(true);
		panelLugarInteres.setBorder(null);
		panelLugarInteres.setBounds(609, 11, 275, 605);
		contentPane.add(panelLugarInteres);
		panelLugarInteres.setLayout(null);




		panelCamposEspecificos = new JPanel();
		panelCamposEspecificos.setBounds(111, 306, 377, 300);
		panelCamposEspecificos.setLayout(null);
		contentPane.add(panelCamposEspecificos);



		panelConfirmacion = new JPanel();
		panelConfirmacion.setBounds(10, 627, 874, 33);
		contentPane.add(panelConfirmacion);
		panelConfirmacion.setLayout(new FlowLayout(FlowLayout.RIGHT));

		buttonConfirmacion = new JButton("Aceptar");
		buttonConfirmacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		panelConfirmacion.add(buttonConfirmacion);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea regresar? Los datos no se guardarán", "Aviso",0);
				if(opcion == 0){
					dispose();
				}

			}
		});
		panelConfirmacion.add(buttonCancelar);

		textFieldFotoE = new JTextField();
		textFieldFotoE.setOpaque(false);
		textFieldFotoE.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldFotoE.setColumns(10);
		textFieldFotoE.setBorder(null);
		textFieldFotoE.setBounds(330, 98, 232, 20);
		contentPane.add(textFieldFotoE);

		textFieldFotoO = new JTextField();
		textFieldFotoO.setOpaque(false);
		textFieldFotoO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldFotoO.setColumns(10);
		textFieldFotoO.setBorder(null);
		textFieldFotoO.setBounds(330, 196, 232, 20);
		contentPane.add(textFieldFotoO);

		JSeparator separator_31 = new JSeparator();
		separator_31.setBounds(320, 120, 242, 2);
		contentPane.add(separator_31);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(320, 218, 242, 2);
		contentPane.add(separator_4);

		JLabel lblUrlFotoEste = new JLabel("URL Foto Este:");
		lblUrlFotoEste.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFotoEste.setBounds(320, 75, 126, 23);
		contentPane.add(lblUrlFotoEste);

		JLabel lblUrlFotoOeste = new JLabel("URL Foto Oeste:");
		lblUrlFotoOeste.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFotoOeste.setBounds(320, 173, 126, 23);
		contentPane.add(lblUrlFotoOeste);

		configurarPanelesParaModificar();

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
