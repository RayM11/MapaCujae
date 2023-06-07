package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class VentanaRegistrarLugar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
	public VentanaRegistrarLugar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nuevo Lugar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 177, 38);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("De inter\u00E9s");
		chckbxNewCheckBox.setBounds(165, 22, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(20, 78, 126, 23);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setBounds(30, 94, 232, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 112, 242, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 177, 242, 2);
		contentPane.add(separator_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setOpaque(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBounds(30, 159, 232, 20);
		contentPane.add(textField_1);
		
		JLabel lblUrlFoto = new JLabel("URL Foto:");
		lblUrlFoto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFoto.setBounds(20, 143, 126, 23);
		contentPane.add(lblUrlFoto);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 242, 242, 2);
		contentPane.add(separator_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setOpaque(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBounds(30, 224, 232, 20);
		contentPane.add(textField_2);
		
		JLabel lblUrlFotoReversa = new JLabel("URL Foto Reversa:");
		lblUrlFotoReversa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUrlFotoReversa.setBounds(20, 208, 126, 23);
		contentPane.add(lblUrlFotoReversa);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(430, 78, 126, 23);
		contentPane.add(lblNombre);
		
		textField_3 = new JTextField();
		textField_3.setOpaque(false);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBounds(440, 94, 232, 20);
		contentPane.add(textField_3);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(430, 112, 242, 2);
		contentPane.add(separator_3);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcin.setBounds(430, 143, 126, 23);
		contentPane.add(lblDescripcin);
		
		JLabel lblAnotaciones = new JLabel("Anotaciones:");
		lblAnotaciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnotaciones.setBounds(430, 271, 126, 23);
		contentPane.add(lblAnotaciones);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Universidad", "Facultad"}));
		comboBox.setBounds(20, 272, 126, 23);
		contentPane.add(comboBox);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setBounds(430, 305, 242, 87);
		contentPane.add(textArea_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(20, 340, 242, 2);
		contentPane.add(separator_4);
		
		textField_4 = new JTextField();
		textField_4.setOpaque(false);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBorder(null);
		textField_4.setBounds(30, 322, 232, 20);
		contentPane.add(textField_4);
		
		JLabel lblDeca = new JLabel("Decano:");
		lblDeca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDeca.setBounds(20, 306, 126, 23);
		contentPane.add(lblDeca);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(20, 387, 242, 2);
		contentPane.add(separator_5);
		
		textField_5 = new JTextField();
		textField_5.setOpaque(false);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBorder(null);
		textField_5.setBounds(30, 369, 232, 20);
		contentPane.add(textField_5);
		
		JLabel lblVicedecano = new JLabel("Vicedecano:");
		lblVicedecano.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVicedecano.setBounds(20, 353, 126, 23);
		contentPane.add(lblVicedecano);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 417, 662, 33);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		JButton button = new JButton("OK");
		button.setActionCommand("OK");
		panel.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setActionCommand("Cancel");
		panel.add(button_1);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(430, 177, 242, 87);
		contentPane.add(textArea);
	}
}
