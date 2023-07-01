package mapaSwing;

import java.awt.HeadlessException;

import auxiliar.Convert;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class LabelDeLugarInteresS extends LabelDeLugarS {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3412194173818906627L;

	private static String foto = "texturas/marcadorLI.png";
	private static String fotoSelect = "texturas/marcadorSelectLI.png";
	private static int tamano = 6;


	public LabelDeLugarInteresS(Vertex vLugar) throws HeadlessException {
		
		super(vLugar);

	//	setIcon(Convert.rezizarImagen(foto, tamano, tamano));				

	}

	public void seleccionar (){

		setIcon(Convert.rezizarImagen(foto, tamano, tamano));
		((mapPanelSwing)getParent()).agregarSeleccion(vLugar);
		// Llamar al llenado de la info
	}
	public void deseleccionar(){

		setIcon(Convert.rezizarImagen(fotoSelect, tamano, tamano));
		((mapPanelSwing)getParent()).removerSeleccion(vLugar);
		//limpiar el panel de la info
	}

}
