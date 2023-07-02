package mapaSwing;

import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import auxiliar.Convert;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import logica.Lugar;

public class LabelDeLugarS extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4357320233692323197L;

	protected Vertex vLugar;
	private static String foto = "src/texturas/marcadorL.png";
	private static String fotoSelect = "src/texturas/marcadorSelectL.png";
	private static int tamano = 30;



	public LabelDeLugarS(final Vertex vLugar) throws HeadlessException {

		this.vLugar = vLugar;

		setIcon(Convert.rezizarImagen(foto, tamano, tamano));				


		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent click) {

				if(((MapPanelSwing)getParent()).puedeSeleccionarNormales()){

					// El mapa está en modo de Añadir nuevo punto (este lugar es una posible conexión)
					if(((MapPanelSwing)getParent()).getModoNuevoPunto()){			

						// Este Lugar está lleno (tiene más de 3 conexiones)
						if (vLugar.getAdjacents().size() > 3){
							//Mensaje de error
							JOptionPane.showMessageDialog(null, "No es posible unir el punto con un lugar que ya tiene 4 caminos (el máximo). Pruebe otro punto");

							// Este lugar es una conexión válida pero ya estaba seleccionado    
						}else if (((MapPanelSwing)getParent()).getSeleccion().contains(vLugar)){

							deseleccionar();

							// Este lugar es una conexión válida y no estaba seleccionado	
						}else if(((MapPanelSwing)getParent()).puedeAgregarSeleccion()){

							seleccionar();
						}
						else{
							JOptionPane.showMessageDialog(null, "No es posible unir más de 4 lugares con el mismo punto. Desmarque alguno si desea cambiarlo");

						}
						click.consume();

						// El mapa está en modo Arista
					}else{

						if (((MapPanelSwing)getParent()).getSeleccion().contains(vLugar))
							deseleccionar();

						else if (((MapPanelSwing)getParent()).puedeAgregarSeleccion())
							seleccionar();
						else {
							((MapPanelSwing)getParent()).deseleccionarLabel(0);
							seleccionar();
						}
					}						
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(((MapPanelSwing)getParent()).puedeSeleccionarNormales())
					setCursor(new Cursor(Cursor.HAND_CURSOR));


			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(((MapPanelSwing)getParent()).puedeSeleccionarNormales())
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

		});	

	}


	public Vertex getVertice(){
		return vLugar;
	}

	public void seleccionar (){

		setIcon(Convert.rezizarImagen(fotoSelect, tamano, tamano));
		((MapPanelSwing)getParent()).agregarSeleccion(vLugar);
		getParent().repaint();
		repaint();
	}
	public void deseleccionar(){

		setIcon(Convert.rezizarImagen(foto, tamano, tamano));
		((MapPanelSwing)getParent()).removerSeleccion(vLugar);
		getParent().repaint();
		repaint();
	}


	/*	public void ubicar(){

		setBounds(getXreal() - getIcon().getIconWidth()/2, getYreal() - getIcon().getIconHeight()/2, tamano/2 , tamano/2);
	}
	 */	
	public int getXreal(){

		return (int) Math.round((((Lugar)vLugar.getInfo()).getCoordenadas().getX() / 13 * 660)) - getIcon().getIconWidth()/2;
	}
	public int getYreal(){

		return (int) Math.round((1045 - ((Lugar)vLugar.getInfo()).getCoordenadas().getY() / 19 * 1045) - getIcon().getIconHeight()/2);

	}
}
