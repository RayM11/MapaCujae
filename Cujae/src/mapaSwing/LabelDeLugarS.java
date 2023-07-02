package mapaSwing;

import interfaces.PantallaVisita;

import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
	
	
	
	public LabelDeLugarS(Vertex vLugar) throws HeadlessException {
		
		this.vLugar = vLugar;
		
		setIcon(Convert.rezizarImagen(foto, tamano, tamano));				
		
	//	setIcon(new ImageIcon(mapPanelSwing.class.getResource(foto)));
		
		
		
		
	}
	
	
	public Vertex getVertice(){
		return vLugar;
	}
	
	public void seleccionar (){
		
		setIcon(Convert.rezizarImagen(fotoSelect, tamano, tamano));
		((mapPanelSwing)getParent()).agregarSeleccion(vLugar);
		getParent().repaint();
	}
	public void deseleccionar(){
		
		setIcon(Convert.rezizarImagen(foto, tamano, tamano));
		((mapPanelSwing)getParent()).removerSeleccion(vLugar);
		getParent().repaint();
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
