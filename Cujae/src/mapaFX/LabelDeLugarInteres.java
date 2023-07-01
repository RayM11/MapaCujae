package mapaFX;
import java.util.LinkedList;

import cu.edu.cujae.ceis.graph.vertex.Vertex;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import logica.Lugar;
import logica.Universidad;

public class LabelDeLugarInteres extends LabelDeLugar {

	private static ImageView iconoNormal = new ImagenResisableEstatic(new Image("texturas/marcador.png"), 5, 5);
	private static ImageView iconoSelec = new ImagenResisableEstatic(new Image ("texturas/marcadorSelect.png"), 5, 5);
	private static  double mitadDimension = iconoNormal.getImage().getHeight()/2;

	public LabelDeLugarInteres (final Vertex vLugar){

		super(vLugar);

		this.vLugar = vLugar;
		
		setGraphic(iconoNormal);

		Insets límites = new Insets(mitadDimension,mitadDimension,mitadDimension,mitadDimension);
		setPadding(límites);

		setOnMouseClicked(new EventHandler<MouseEvent>(){

			public void handle (MouseEvent event){

				// El mapa está en modo de Añadir nuevo punto (este lugar es una posible conexión)
				if(((MapPanelFX)getParent()).getModoNuevoPunto()){			

					// Este Lugar está lleno (tiene más de 3 conexiones)
					if (vLugar.getAdjacents().size() > 3){
						//Mensaje de error
						Alert alerta = new Alert(Alert.AlertType.ERROR);
						alerta.setTitle("Error");
						alerta.setHeaderText("Intento de cpnexión no válida");
						alerta.setContentText("Ha intentado conectar el lugar a un punto que ya tiene el máximo de enlaces posibles(4)\nPruebe otro punto");
						alerta.showAndWait();

						// Este lugar es una conexión válida pero ya estaba seleccionado    
					}else if (((MapPanelFX)getParent()).getSeleccion().contains(vLugar)){

						deseleccionar();

						// Este lugar es una conexión válida y no estaba seleccionado	
					}else if(((MapPanelFX)getParent()).puedeAgregarSeleccion()){

						seleccionar();
					}
					else{
						Alert alerta = new Alert(Alert.AlertType.ERROR);
						alerta.setTitle("Error");
						alerta.setHeaderText("Hay demasiadas conexiones");
						alerta.setContentText("No puede seleccionar más de 4 lugares a conectar con el nuevo\nDesmarque uno de los seleccionados si quiere cambiarlos");
						alerta.showAndWait();
					}
					event.consume();

					// El mapa está en modo Arista
				}else if (((MapPanelFX)getParent()).getModoArista()){

					// El Lugar ya está seleccionado
					if (((MapPanelFX)getParent()).getSeleccion().contains(vLugar)){

						deseleccionar();

						// El lugar se puede agregar
					}else if(((MapPanelFX)getParent()).puedeAgregarSeleccion()){

						// Si tiene que eliminar la arista primero comprueba que existe
						if (((MapPanelFX)getParent()).getModoEliminarArista()){
							if (((MapPanelFX)getParent()).esAdyacenteA(vLugar))
								seleccionar();
							else{
								Alert alerta = new Alert(Alert.AlertType.ERROR);
								alerta.setTitle("Error");
								alerta.setHeaderText("Arista inexistente");
								alerta.setContentText("Debe seleccionar 2 nodos unidos por una arista para poder eliminar dicha arista");
								alerta.showAndWait();
							}
						// Si tiene que agregar primero comprueba que no existe
						}else if (!((MapPanelFX)getParent()).esAdyacenteA(vLugar))		 
							seleccionar();
						else{
							Alert alerta = new Alert(Alert.AlertType.ERROR);
							alerta.setTitle("Error");
							alerta.setHeaderText("Arista ya existente");
							alerta.setContentText("Debe seleccionar 2 nodos que no estén unidos ya por una arista");
							alerta.showAndWait();
						}			

						// Ya no se puede agregar otro, así q deselecciona el anterior primero;	
					}else{

						((MapPanelFX)getParent()).getLabel(0).deseleccionar();						
						seleccionar();
					}

					// El mapa está en Modo Ruta	
				}else if (((MapPanelFX)getParent()).getModoRuta()){

					// El lugar ya está seleccionado
					if (((MapPanelFX)getParent()).getSeleccion().contains(vLugar)){

						deseleccionar();
						// Si todavía hay otra selección debe haber una ruta, así que actualiza el mapa
						if (((MapPanelFX)getParent()).getSeleccion().size() == 1){
							((MapPanelFX)getParent()).actualizarMapa();
							((MapPanelFX)getParent()).reseleccionarVertices();
						}

						// Hay espacio para seleccionar el lugar	
					}else if (((MapPanelFX)getParent()).puedeAgregarSeleccion()){

						// Si no hay ningún otro lugar seleccionado lo selecciona simplemente
						if (((MapPanelFX)getParent()).getSeleccion().isEmpty())
							seleccionar();

						// Si es el 2do y hay camino desde el primero
						else if (((MapPanelFX)getParent()).hayCaminoA(vLugar)){
							try {
								LinkedList<Vertex> list = Universidad.getCujae().buscarCaminoMasCorto(((MapPanelFX)getParent()).getSeleccion().get(0), vLugar);
								((MapPanelFX)getParent()).dibujarRuta(list);

								// Si Ya hay un 2do seleccionado primero lo deselecciona
								if (((MapPanelFX)getParent()).getSeleccion().size() == 1)
									((MapPanelFX)getParent()).getLabel(1).deseleccionar();

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
					}
				// Estado normal de seleccion única (eliminación, modificación, selección)
				}else{
					if (((MapPanelFX)getParent()).puedeAgregarSeleccion())
						seleccionar();
					else {
						((MapPanelFX)getParent()).getLabel(0).deseleccionar();
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
		});	
	}
	
	public void inicializar (){
		
		setLayoutX(getXreal(((Lugar) vLugar.getInfo()).getCoordenadas().getX()) - mitadDimension);
		setLayoutY(getYreal(((Lugar) vLugar.getInfo()).getCoordenadas().getY()) - mitadDimension);
		
	}

	public void seleccionar(){
		setGraphic(iconoSelec);
		((MapPanelFX)getParent()).agregarSeleccion(vLugar);

		//-->  llamar a la función del panel de información para que se rellene con la info del lugar seleccionado
	}
	public void deseleccionar(){
		setGraphic(iconoNormal);
		((MapPanelFX)getParent()).removerSeleccion(vLugar);
		//-->  llamar a la función del panel de información para que se limpie
	}

	public Vertex getVertice(){
		return vLugar;
	}

	private double getXreal(double x){

		return x * ((MapPanelFX)getParent()).getWidth() / 15;

	}
	private double getYreal(double y){

		return y * ((MapPanelFX)getParent()).getHeight() / 19;

	}

}
