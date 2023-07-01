package mapaSwing;

import java.awt.HeadlessException;
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
	private static String foto = "texturas/marcadorL.png";
	private static String fotoSelect = "texturas/marcadorSelectL.png";
	private static int tamano = 2;
	
	
	
	public LabelDeLugarS(Vertex vLugar) throws HeadlessException {
		
		this.vLugar = vLugar;
		
	//	setIcon(Convert.rezizarImagen(foto, tamano, tamano));				
		
	}
	
	
	public Vertex getVertice(){
		return vLugar;
	}
	
	public void seleccionar (){
		
		setIcon(Convert.rezizarImagen(foto, tamano, tamano));
		((mapPanelSwing)getParent()).agregarSeleccion(vLugar);
	}
	public void deseleccionar(){
		
		setIcon(Convert.rezizarImagen(fotoSelect, tamano, tamano));
		((mapPanelSwing)getParent()).removerSeleccion(vLugar);
	}
	
	
	public void ubicar(){
		
		setBounds(getXreal(), getYreal(), tamano/2 , tamano/2);
	}
	
	protected int getXreal(){

		return (int) Math.round(((Lugar)vLugar.getInfo()).getCoordenadas().getX() * getParent().getWidth() / 15);

	}
	protected int getYreal(){

		return (int) (getParent().getWidth() - Math.round(((Lugar)vLugar.getInfo()).getCoordenadas().getY() * getParent().getHeight() / 19));

	}
}
