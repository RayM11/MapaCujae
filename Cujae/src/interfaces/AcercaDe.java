package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JTextArea;

import auxiliar.Configuracion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public AcercaDe(final JFrame ventanaAnterior, Configuracion configActual) {
		setResizable(false);
		setTitle("Acerca de...");
		setBounds(100, 100, 561, 420);
		getContentPane().setLayout(new BorderLayout());
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
		contentPanel.setOpaque(false);
		contentPanel.setToolTipText("");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JTextArea txtrAcercaDeEsta = new JTextArea();
		txtrAcercaDeEsta.setText("MapaCujae es una aplicaci\u00F3n dise\u00F1ada para facilitar la orientaci\u00F3n de los estudiantes y visitantes en la CUJAE, en la que se tuvieron en cuenta todas las facultades, cafeter\u00EDas y centros de inter\u00E9s, de las cuales se muestra una breve informaci\u00F3n. Se brindan funcionalidades como la ruta m\u00E1s corta entre dos lugares y la asistencia para llegar a una facultad deseada o una cafeter\u00EDa con un producto que busque el usuario. Para el que introduzca los credenciales pertinentes se habilitaran opciones de a\u00F1adir, modificar o eliminar caminos y lugares a su gusto.\r\n\r\nAutores:\r\nJavier de Jes\u00FAs Castro Heredia\r\nRay Maestre Pe\u00F1a\r\nAlejandro Estrada Su\u00E1rez\r\nDavid Hechavarr\u00EDa P\u00E9rez\r\nRa\u00FAl Alejandro de Jes\u00FAs Le\u00F3n");
		txtrAcercaDeEsta.setEditable(false);
		txtrAcercaDeEsta.setOpaque(false);
		txtrAcercaDeEsta.setFont(new Font("Tahoma", Font.PLAIN, configActual.getTamanoFuente()));
		txtrAcercaDeEsta.setLineWrap(true);
		txtrAcercaDeEsta.setWrapStyleWord(true);
		txtrAcercaDeEsta.setBounds(10, 11, 535, 336);
		contentPanel.add(txtrAcercaDeEsta);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
