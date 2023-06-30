package mapaFX;
import java.util.LinkedList;

import cu.edu.cujae.ceis.graph.vertex.Vertex;
import javafx.scene.Node;
import javafx.scene.control.Label;
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

	public LabelDeLugarInteres (final Vertex vLugar){
		
		super(vLugar);
		
		double mitadDimension = iconoNormal.getImage().getHeight()/2;

		this.vLugar = vLugar;
		setLayoutX(getXreal(((Lugar) vLugar.getInfo()).getCoordenadas().getX()) - mitadDimension);
		setLayoutY(getYreal(((Lugar) vLugar.getInfo()).getCoordenadas().getY()) - mitadDimension);

		setGraphic(iconoNormal);

		Insets límites = new Insets(mitadDimension,mitadDimension,mitadDimension,mitadDimension);
		setPadding(límites);

		setOnMouseClicked(new EventHandler<MouseEvent>(){

			public void handle (MouseEvent event){

				if (((MapPanelFX) getParent()).esperandoNuevoPunto())
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
				}
			}
		});	
	}

	public void seleccionar(){
		setGraphic(iconoSelec);
		((MapPanelFX)getParent()).setVerticeSeleccionado(vLugar);
		//-->  llamar a la función del panel de información para que se rellene con la info del lugar seleccionado
	}
	public void deseleccionar(){
		setGraphic(iconoNormal);
	}
	
	private double getXreal(double x){

		return x * this.getParent().getLayoutX() / 12;

	}
	private double getYreal(double y){

		return y * this.getParent().getLayoutY() / 19;

	}

}
