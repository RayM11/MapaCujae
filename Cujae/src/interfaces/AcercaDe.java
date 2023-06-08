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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class AcercaDe extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public AcercaDe(final JFrame ventanaAnterior) {
		setResizable(false);
		setTitle("Acerca de...");
		setBounds(100, 100, 561, 420);
		getContentPane().setLayout(new BorderLayout());
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
						ventanaAnterior.setEnabled(true);
						ventanaAnterior.setVisible(true);
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
