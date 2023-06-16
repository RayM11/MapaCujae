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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistrarLugar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldID;
	private JTextField textFieldFoto;
	private JTextField textFieldFotoReversa;
	private JTextField textFieldDecano;
	private JTextField textFieldVicedecano;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel;
	private JCheckBox chckbxNewCheckBox;
	private JLabel lblID;
	private JPanel panelConfirmacion;
	private JButton buttonConfirmacion;
	private JButton buttonCancelar;
	private JPanel panelLugarInteres;
	private JTextArea textAreaDescripcion;
	private JTextArea textAreaAnotaciones;
	private JPanel panelCamposEspecificos;
	private JPanel panelComboBox;
	private JComboBox<Object> comboBox;

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
					textFieldDecano.setBorder(null);
					textFieldVicedecano.setBorder(null);
					textFieldNombre.setBorder(null);
					
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
		
		panelComboBox.revalidate();
		panelCamposEspecificos.revalidate();


	}

	public VentanaRegistrarLugar(final JFrame ventanaAnterior , final Configuracion configActual) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 698, 700);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Nuevo Lugar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 177, 38);
		contentPane.add(lblNewLabel);
		
		panelComboBox = new JPanel();
		panelComboBox.setBorder(null);
		panelComboBox.setBounds(20, 251, 275, 44);
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
		chckbxNewCheckBox.setBounds(165, 22, 97, 23);
		contentPane.add(chckbxNewCheckBox);

		lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(20, 78, 126, 23);
		contentPane.add(lblID);

		textFieldID = new JTextField();
		textFieldID.setBorder(null);
		textFieldID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldID.setOpaque(false);
		textFieldID.setBounds(30, 94, 232, 20);
		contentPane.add(textFieldID);
		textFieldID.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 112, 242, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 177, 242, 2);
		contentPane.add(separator_1);

		textFieldFoto = new JTextField();
		textFieldFoto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldFoto.setOpaque(false);
		textFieldFoto.setColumns(10);
		textFieldFoto.setBorder(null);
		textFieldFoto.setBounds(30, 159, 232, 20);
		contentPane.add(textFieldFoto);

		JLabel lblUrlFoto = new JLabel("URL Foto:");
		lblUrlFoto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFoto.setBounds(20, 143, 126, 23);
		contentPane.add(lblUrlFoto);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 242, 242, 2);
		contentPane.add(separator_2);

		textFieldFotoReversa = new JTextField();
		textFieldFotoReversa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldFotoReversa.setOpaque(false);
		textFieldFotoReversa.setColumns(10);
		textFieldFotoReversa.setBorder(null);
		textFieldFotoReversa.setBounds(30, 224, 232, 20);
		contentPane.add(textFieldFotoReversa);

		JLabel lblUrlFotoReversa = new JLabel("URL Foto Reversa:");
		lblUrlFotoReversa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFotoReversa.setBounds(20, 208, 126, 23);
		contentPane.add(lblUrlFotoReversa);
		
		panelLugarInteres = new JPanel();
		panelLugarInteres.setVisible(true);
		panelLugarInteres.setBorder(null);
		panelLugarInteres.setBounds(397, 53, 275, 553);
		contentPane.add(panelLugarInteres);
		panelLugarInteres.setLayout(null);

		panelCamposEspecificos = new JPanel();
		panelCamposEspecificos.setBounds(10, 306, 377, 300);
		panelCamposEspecificos.setLayout(null);
		contentPane.add(panelCamposEspecificos);

		panelConfirmacion = new JPanel();
		panelConfirmacion.setBounds(10, 617, 662, 33);
		contentPane.add(panelConfirmacion);
		panelConfirmacion.setLayout(new FlowLayout(FlowLayout.RIGHT));

		buttonConfirmacion = new JButton("Aceptar");
		buttonConfirmacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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

	}
}
