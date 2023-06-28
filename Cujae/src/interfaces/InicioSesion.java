package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import auxiliar.Configuracion;
import auxiliar.Usuario;
import auxiliar.Validacion;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;


	private boolean credencialesOK(){
		boolean ok = false;
		Usuario usuario = new Usuario();
		usuario.leerCredencialesEncriptados();

		try {
			String userNombre = usuario.getNombre();
			String userPass = usuario.getPass();

			String contraIntroducida = new String(passwordField.getPassword());

			if(textField.getText().equals(userNombre) && contraIntroducida.equals(userPass))
				ok = true;

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return ok;
	}

	public InicioSesion(final JFrame pantallaAnterior, final Configuracion configActual) {
		setType(Type.POPUP);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setTitle("Login");
		setBounds(100, 100, 371, 237);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
			textField.setBounds(136, 63, 166, 34);
			contentPanel.add(textField);
			textField.setColumns(10);
		}

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		passwordField.setBounds(136, 108, 166, 30);
		contentPanel.add(passwordField);

		JLabel lblNewLabel = new JLabel("Introduzca sus credenciales");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 335, 33);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(21, 66, 115, 27);
		contentPanel.add(lblNewLabel_1);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setBounds(21, 111, 115, 27);
		contentPanel.add(lblContrasea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent e) {

						if(!Validacion.cadenaNoVacia(textField.getText()) ||! Validacion.cadenaNoVacia(passwordField.getText())){
							JOptionPane.showMessageDialog(null, "LLene los campos vacíos");
						}

						else{

							boolean ok = credencialesOK();

							if(ok){
								configActual.setEsAdmin(true);
								PantallaMapa pM = new PantallaMapa(InicioSesion.this, configActual);
								pM.setVisible(true);
								pantallaAnterior.dispose();
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null, "Los credenciales no son correctos");

						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						pantallaAnterior.setEnabled(true);
						pantallaAnterior.setVisible(true);
						dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}


