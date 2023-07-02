package mapaSwing;

import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

import javax.swing.ImageIcon;

import logica.Universidad;
import mapaFX.MapPanelFX;
import auxiliar.Convert;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class LabelDeLugarInteresS extends LabelDeLugarS {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3412194173818906627L;

	private static String fotoI = "src/texturas/marcadorLI.png";
	private static String fotoISelect = "src/texturas/marcadorSelectLI.png";
	private static int tamano = 30;

	private Vertex vLugar;


	public LabelDeLugarInteresS(final Vertex vLugar) throws HeadlessException {

		super(vLugar); 

		setIcon(Convert.rezizarImagen(fotoI, tamano, tamano));				

	//	setIcon(new ImageIcon(mapPanelSwing.class.getResource(fotoI)));

		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(java.awt.event.MouseEvent event) {

				// El mapa está en modo de Añadir nuevo punto (este lugar es una posible conexión)
				if(((mapPanelSwing)getParent()).getModoNuevoPunto()){			

					// Este Lugar está lleno (tiene más de 3 conexiones)
					if (vLugar.getAdjacents().size() > 3){
						//Mensaje de error
						Alert alerta = new Alert(Alert.AlertType.ERROR);
						alerta.setTitle("Error");
						alerta.setHeaderText("Intento de cpnexión no válida");
						alerta.setContentText("Ha intentado conectar el lugar a un punto que ya tiene el máximo de enlaces posibles(4)\nPruebe otro punto");
						alerta.showAndWait();

						// Este lugar es una conexión válida pero ya estaba seleccionado    
					}else if (((mapPanelSwing)getParent()).getSeleccion().contains(vLugar)){

						deseleccionar();

						// Este lugar es una conexión válida y no estaba seleccionado	
					}else if(((mapPanelSwing)getParent()).puedeAgregarSeleccion()){

						seleccionar();
					}
					else{
						Alert alerta = new Alert(Alert.AlertType.ERROR);
						alerta.setTitle("Error");
						alerta.setHeaderText("Hay demasiadas conexiones");
						alerta.setContentText("No puede seleccionar más de 4 lugares a conectar con el nuevo punto\nDesmarque uno de los seleccionados si quiere cambiarlos");
						alerta.showAndWait();
					}
					event.consume();

					// El mapa está en modo Arista
				}else if (((mapPanelSwing)getParent()).getModoArista()){

					// El Lugar ya está seleccionado
					if (((mapPanelSwing)getParent()).getSeleccion().contains(vLugar)){

						deseleccionar();

						// El lugar se puede agregar
					}else if(((mapPanelSwing)getParent()).puedeAgregarSeleccion()){

						// Si tiene que eliminar la arista primero comprueba que existe
						if (((mapPanelSwing)getParent()).getModoEliminarArista()){
							if (((mapPanelSwing)getParent()).esAdyacenteA(vLugar))
								seleccionar();
							else{
								Alert alerta = new Alert(Alert.AlertType.ERROR);
								alerta.setTitle("Error");
								alerta.setHeaderText("Camino inexistente");
								alerta.setContentText("Debe seleccionar 2 lugares unidos por un camino para poder eliminar dicho camino");
								alerta.showAndWait();
							}
							// Si tiene que agregar primero comprueba que no existe
						}else if (!((mapPanelSwing)getParent()).esAdyacenteA(vLugar))		 
							seleccionar();
						else{
							Alert alerta = new Alert(Alert.AlertType.ERROR);
							alerta.setTitle("Error");
							alerta.setHeaderText("Camino ya existente");
							alerta.setContentText("Debe seleccionar 2 Lugares que no estén unidos ya por una camino para poder agregarlo");
							alerta.showAndWait();
						}			

						// Ya no se puede agregar otro, así q deselecciona el anterior primero;	
					}else{

						((mapPanelSwing)getParent()).getLabel(0).deseleccionar();						
						seleccionar();
					}

					// El mapa está en Modo Ruta	
				}else if (((mapPanelSwing)getParent()).getModoRuta()){

					// El lugar ya está seleccionado
					if (((mapPanelSwing)getParent()).getSeleccion().contains(vLugar)){

						deseleccionar();

						// Si todavía hay otra selección debe haber una ruta, así que actualiza el mapa
						if (((mapPanelSwing)getParent()).getSeleccion().size() == 1){
							((mapPanelSwing)getParent()).removerRutaADibujar();
							getParent().repaint();
							//-------------	((mapPanelSwing)getParent()).reseleccionarVertices();
						}
					
					// Si no hay ningún otro lugar seleccionado lo selecciona simplemente
					}else if (((mapPanelSwing)getParent()).getSeleccion().isEmpty()){
						seleccionar();		

					// Si es el 2do y hay camino desde el primero
					}else if (((mapPanelSwing)getParent()).hayCaminoA(vLugar)){
						try {
							LinkedList<Vertex> ruta = Universidad.getCujae().buscarCaminoMasCorto(((mapPanelSwing)getParent()).getSeleccion().get(0), vLugar);
							((mapPanelSwing)getParent()).asignarRutaADibujar(ruta);
							getParent().repaint();

							// Si ya hay un 2do seleccionado lo deselecciona
							if (((mapPanelSwing)getParent()).getSeleccion().size() == 2)
								((mapPanelSwing)getParent()).getLabel(1).deseleccionar();

							seleccionar();
						} catch (Exception e) {
							e.printStackTrace();
						}

					// Si no hay un camino hacia este lugar desde el inicial	
					}else{
						Alert alerta = new Alert(Alert.AlertType.ERROR);
						alerta.setTitle("Error");
						alerta.setHeaderText("No hay camino");
						alerta.setContentText("No hay forma de conectar ese nodo con el anterior. Esto se debe a una minipulación indebida\n del grafo");
						alerta.showAndWait();					
					}

				// Estado normal de seleccion única (eliminación, modificación, selección)
				}else{
					if (((mapPanelSwing)getParent()).puedeAgregarSeleccion())
						seleccionar();
					else {
						((mapPanelSwing)getParent()).getLabel(0).deseleccionar();
						seleccionar();
					}
				}


				/*			if (((MapPanelFX) getParent()).esperandoNuevoPunto())
				event.consume();

			else if (((MapPanelFX) getParent()).esperandoNuevaArista())
				((MapPanelFX) getParent()).devolverVertexAlFormulario(vLugar);

			else{ 
				if (!((MapPanelFX) getParent()).esperandoDestino())
					for (Node node : getParent().getChildrenUnmodifiable()){
						if (node instanceof LabelDeLugarInteres)
							((LabelDeLugarInteres)node).deseleccionar();
					}
				else{
					try {
						LinkedList<Vertex> camino = Universidad.getCujae().buscarCaminoMasCorto(((MapPanelFX) getParent()).getVerticeSeleccionado(), vLugar);
						((MapPanelFX) getParent()).dibujarRuta(camino);
						((MapPanelFX) getParent()).desactivarSeleccionDestino();

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				seleccionar();
			}*/
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	

	}

	public void seleccionar (){

		setIcon(Convert.rezizarImagen(fotoISelect, tamano, tamano));
		((mapPanelSwing)getParent()).agregarSeleccion(vLugar);
		getParent().repaint();
		// Llamar al llenado de la info
	}
	public void deseleccionar(){

		setIcon(Convert.rezizarImagen(fotoI, tamano, tamano));
		((mapPanelSwing)getParent()).removerSeleccion(vLugar);
		getParent().repaint();
		//limpiar el panel de la info
	}

}
