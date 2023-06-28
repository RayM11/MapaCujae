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
import auxiliar.Validacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistrarLugar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldFoto;
	private JTextField textFieldFotoReversa;
	private JTextField textFieldDecano;
	private JTextField textFieldVicedecano;
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
	private JTextField textField;
	private JTextField textField_1;



	public void configurarPanelLugarInteres(boolean check){

		panelLugarInteres.removeAll();
		panelComboBox.removeAll();

		if(check){



			comboBox = new JComboBox<Object>();
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"General", "Facultad", "Cafeter\u00EDa"}));
			comboBox.setSelectedIndex(0);
			comboBox.setBounds(0, 11, 126, 23);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String tipo = comboBox.getSelectedItem().toString();
					crearCamposEspecificos(tipo);
					SwingUtilities.updateComponentTreeUI(panelCamposEspecificos);

					if(tipo.equalsIgnoreCase("Facultad")){
						textFieldDecano.setBorder(null);
						textFieldVicedecano.setBorder(null);
						textFieldNombre.setBorder(null);
					}

				}
			});
			panelComboBox.add(comboBox);

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

			textAreaDescripcion = new JTextArea();
			textAreaDescripcion.setLineWrap(true);
			textAreaDescripcion.setBounds(10, 110, 255, 177);
			panelLugarInteres.add(textAreaDescripcion);

			JLabel labelDescripcion = new JLabel("Descripci\u00F3n:");
			labelDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelDescripcion.setBounds(10, 76, 126, 23);
			panelLugarInteres.add(labelDescripcion);

			textAreaAnotaciones = new JTextArea();
			textAreaAnotaciones.setLineWrap(true);
			textAreaAnotaciones.setBounds(10, 332, 255, 207);
			panelLugarInteres.add(textAreaAnotaciones);

			JLabel labelAnotaciones = new JLabel("Anotaciones:");
			labelAnotaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelAnotaciones.setBounds(10, 298, 126, 23);
			panelLugarInteres.add(labelAnotaciones);

		}
		else
			panelCamposEspecificos.removeAll();

		panelLugarInteres.revalidate();
		contentPane.revalidate();

	}

	private void crearCamposEspecificos(String tipo){


		panelCamposEspecificos.removeAll();

		if(tipo.equalsIgnoreCase("Facultad")){

			JLabel labelDecano = new JLabel("Decano:");
			labelDecano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelDecano.setBounds(10, 49, 126, 23);
			panelCamposEspecificos.add(labelDecano);

			JSeparator separator_4 = new JSeparator();
			separator_4.setBounds(10, 90, 242, 2);
			panelCamposEspecificos.add(separator_4);

			textFieldDecano = new JTextField();
			textFieldDecano.setOpaque(false);
			textFieldDecano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textFieldDecano.setColumns(10);
			textFieldDecano.setBorder(null);
			textFieldDecano.setBounds(20, 72, 232, 20);
			panelCamposEspecificos.add(textFieldDecano);

			JSeparator separator_5 = new JSeparator();
			separator_5.setBounds(10, 212, 242, 2);
			panelCamposEspecificos.add(separator_5);

			textFieldVicedecano = new JTextField();
			textFieldVicedecano.setOpaque(false);
			textFieldVicedecano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			textFieldVicedecano.setColumns(10);
			textFieldVicedecano.setBorder(null);
			textFieldVicedecano.setBounds(20, 194, 232, 20);
			panelCamposEspecificos.add(textFieldVicedecano);

			JLabel labelVicedecano = new JLabel("Vicedecano:");
			labelVicedecano.setFont(new Font("Tahoma", Font.PLAIN, 13));
			labelVicedecano.setBounds(10, 173, 126, 23);
			panelCamposEspecificos.add(labelVicedecano);
		}
		else if (tipo.equalsIgnoreCase("Cafeter\u00EDa")){

			JCheckBox chkPizza = new JCheckBox("Pizza");
			chkPizza.setBounds(6, 29, 109, 23);
			panelCamposEspecificos.add(chkPizza);
			chkPizza.setSelected(true); // Es buena practica inicializar alguno(s) seleccionado(s)

			JCheckBox chkHamburguesa = new JCheckBox("Hamburguesa");
			chkHamburguesa.setBounds(6, 67, 109, 23);
			panelCamposEspecificos.add(chkHamburguesa);

			JCheckBox chkPanconjamon = new JCheckBox("Pan con jam\u00F3n");
			chkPanconjamon.setBounds(6, 110, 117, 23);
			panelCamposEspecificos.add(chkPanconjamon);

			JCheckBox chkPanConQueso = new JCheckBox("Pan con queso");
			chkPanConQueso.setBounds(6, 162, 117, 23);
			panelCamposEspecificos.add(chkPanConQueso);

			JCheckBox chkPanConJamn = new JCheckBox("Pan con jam\u00F3n y queso");
			chkPanConJamn.setBounds(6, 216, 160, 23);
			panelCamposEspecificos.add(chkPanConJamn);

			JCheckBox chkHelado = new JCheckBox("Helado");
			chkHelado.setBounds(233, 29, 109, 23);
			panelCamposEspecificos.add(chkHelado);

			JCheckBox chkJugo = new JCheckBox("Jugo");
			chkJugo.setBounds(233, 67, 109, 23);
			panelCamposEspecificos.add(chkJugo);

			JCheckBox chkBatido = new JCheckBox("Batido");
			chkBatido.setBounds(233, 110, 109, 23);
			panelCamposEspecificos.add(chkBatido);

			JCheckBox chkRefresco = new JCheckBox("Refresco");
			chkRefresco.setBounds(233, 162, 109, 23);
			panelCamposEspecificos.add(chkRefresco);

			JCheckBox chkMalta = new JCheckBox("Malta");
			chkMalta.setBounds(233, 216, 109, 23);
			panelCamposEspecificos.add(chkMalta);

			JLabel lblProductos = new JLabel("Productos");
			lblProductos.setBounds(135, 11, 62, 14);
			panelCamposEspecificos.add(lblProductos);




		}

		panelCamposEspecificos.revalidate();


	}

	public VentanaRegistrarLugar(final JFrame ventanaAnterior , final Configuracion configActual) {
		
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
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean check = chckbxNewCheckBox.isSelected();
				configurarPanelLugarInteres(check);
				SwingUtilities.updateComponentTreeUI(panelLugarInteres);
				SwingUtilities.updateComponentTreeUI(panelCamposEspecificos);
				SwingUtilities.updateComponentTreeUI(panelComboBox);
				textFieldNombre.setBorder(null);

			}
		});
		chckbxNewCheckBox.setBounds(699, 22, 97, 23);
		contentPane.add(chckbxNewCheckBox);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 120, 242, 2);
		contentPane.add(separator_1);

		textFieldFoto = new JTextField();
		textFieldFoto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldFoto.setOpaque(false);
		textFieldFoto.setColumns(10);
		textFieldFoto.setBorder(null);
		textFieldFoto.setBounds(30, 102, 232, 20);
		contentPane.add(textFieldFoto);

		JLabel lblUrlFoto = new JLabel("URL Foto Norte:");
		lblUrlFoto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFoto.setBounds(20, 86, 126, 23);
		contentPane.add(lblUrlFoto);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 218, 242, 2);
		contentPane.add(separator_2);

		textFieldFotoReversa = new JTextField();
		textFieldFotoReversa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldFotoReversa.setOpaque(false);
		textFieldFotoReversa.setColumns(10);
		textFieldFotoReversa.setBorder(null);
		textFieldFotoReversa.setBounds(30, 200, 232, 20);
		contentPane.add(textFieldFotoReversa);

		JLabel lblUrlFotoReversa = new JLabel("URL Foto Sur:");
		lblUrlFotoReversa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFotoReversa.setBounds(20, 184, 126, 23);
		contentPane.add(lblUrlFotoReversa);

		panelLugarInteres = new JPanel();
		panelLugarInteres.setVisible(true);
		panelLugarInteres.setBorder(null);
		panelLugarInteres.setBounds(609, 63, 275, 553);
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
				if((!Validacion.cadenaNoVacia(textFieldFoto.getText()) ||! Validacion.cadenaNoVacia(textFieldFotoReversa.getText()) || !Validacion.cadenaNoVacia(textField.getText()) ||
						!Validacion.cadenaNoVacia(textField_1.getText())) ){
					
					JOptionPane.showMessageDialog(null, "LLene los campos vacíos");
					

				}
				
				else if(((chckbxNewCheckBox.isSelected() && !Validacion.cadenaNoVacia(textFieldNombre.getText()) )
						|| (chckbxNewCheckBox.isSelected() && !Validacion.cadenaNoVacia(textAreaDescripcion.getText()) )
						|| (chckbxNewCheckBox.isSelected() && !Validacion.cadenaNoVacia(textAreaAnotaciones.getText()) ))
						|| ((chckbxNewCheckBox.isSelected() && comboBox.getSelectedItem().toString().equalsIgnoreCase("Facultad") && !Validacion.cadenaNoVacia(textFieldDecano.getText())
						||chckbxNewCheckBox.isSelected() && comboBox.getSelectedItem().toString().equalsIgnoreCase("Facultad") && !Validacion.cadenaNoVacia(textFieldVicedecano.getText())))) {
					
					JOptionPane.showMessageDialog(null, "LLene los campos vacíos");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Campos llenos"); //Para probar
				}



			}
		});
		panelConfirmacion.add(buttonConfirmacion);

		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea regresar? Los datos no se guardarán", "Aviso",0);
				if(opcion == 0){
					ventanaAnterior.setEnabled(true);
					ventanaAnterior.setVisible(true);
					dispose();
				}

			}
		});
		panelConfirmacion.add(buttonCancelar);

		textField = new JTextField();
		textField.setOpaque(false);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBounds(330, 98, 232, 20);
		contentPane.add(textField);

		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(330, 196, 232, 20);
		contentPane.add(textField_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(320, 120, 242, 2);
		contentPane.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(320, 218, 242, 2);
		contentPane.add(separator_4);

		JLabel lblUrlFotoEste = new JLabel("URL Foto Este:");
		lblUrlFotoEste.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFotoEste.setBounds(320, 86, 126, 23);
		contentPane.add(lblUrlFotoEste);

		JLabel lblUrlFotoOeste = new JLabel("URL Foto Oeste:");
		lblUrlFotoOeste.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFotoOeste.setBounds(320, 184, 126, 23);
		contentPane.add(lblUrlFotoOeste);

	}
}
