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
		txtrAcercaDeEsta.setEditable(false);
		txtrAcercaDeEsta.setOpaque(false);
		txtrAcercaDeEsta.setFont(new Font("Arial Black", Font.PLAIN, 12));
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
