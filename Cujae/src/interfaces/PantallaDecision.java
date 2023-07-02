package interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;

import logica.Universidad;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaDecision extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel labelInfo;
	private JScrollPane scrollPane;
	private JList<String> list;

	private int decision;
	private JButton okButton;
	private JButton cancelButton;



	public static void main(String[] args) {
		try {

			Universidad.getCujae();

			PantallaDecision dialog = new PantallaDecision(null, 0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void setDecision(int decision){

		this.decision = decision;

	}

	public void cargarLista(String producto){

		DefaultListModel<String> model = new DefaultListModel<String>();

		if(decision == 0){

			labelInfo.setText("Elija la facultad que desea visitar.");
			ArrayList<String> elementos = Universidad.getCujae().obtenerFacultadesDeArbol();

			for(String elemento:elementos)
				model.addElement(elemento);

			list = new JList<String>(model);
			scrollPane.setViewportView(list);

		}
		else if(decision == 1){

			labelInfo.setText("Elija el producto que desea consumir.");
			ArrayList<String> elementos = Universidad.getCujae().obtenerListaDeProductosDelArbol();

			for(String elemento:elementos)
				model.addElement(elemento);

			list = new JList<String>(model);
			scrollPane.setViewportView(list);

		}
		else if(decision == 2){

			labelInfo.setText("Elija la cafetería con el producto elegido que desea visitar");
			ArrayList<String> elementos = Universidad.getCujae().obtenerCafeteriasPorProductoDesdeElArbol(producto);

			for(String elemento:elementos)
				model.addElement(elemento);

			list = new JList<String>(model);
			scrollPane.setViewportView(list);
		}


	}

	public PantallaDecision(final PantallaMapa ventanaAnterior, int decision) {

		setDecision(decision);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		labelInfo = new JLabel("New label");
		labelInfo.setBounds(10, 11, 414, 37);
		labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(labelInfo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 46, 340, 171);
		contentPanel.add(scrollPane);
		cargarLista("");




		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				
				if(decision == 1)
					okButton.setText("Siguiente");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if(PantallaDecision.this.decision == 1){
							setDecision(2);
							cargarLista(list.getSelectedValue());
							okButton.setText("OK");
						}
						else{
							
						}
							

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
