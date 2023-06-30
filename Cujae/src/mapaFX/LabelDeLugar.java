package mapaFX;

import cu.edu.cujae.ceis.graph.vertex.Vertex;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import logica.Lugar;

public class LabelDeLugar extends Label {

	protected Vertex vLugar;
	
	public LabelDeLugar(final Vertex vLugar){

		this.vLugar = vLugar;
		setLayoutX(getXreal(((Lugar) vLugar.getInfo()).getCoordenadas().getX()) - 1);
		setLayoutY(getYreal(((Lugar) vLugar.getInfo()).getCoordenadas().getY()) - 1);
		
		setShape(new Circle(1));
		setStyle("-fx-background-color: white;");
		setPrefSize(2, 2);
		
		setOnMouseClicked(new EventHandler<MouseEvent>(){

			public void handle (MouseEvent event){
				
				if (((MapPanelFX) getParent()).esperandoNuevaArista())
					((MapPanelFX) getParent()).devolverVertexAlFormulario(vLugar);
			
			}
		});
	}
	
	
	
	private double getXreal(double x){

		return x * this.getParent().getLayoutX() / 12;

	}
	private double getYreal(double y){

		return y * this.getParent().getLayoutY() / 19;

	}
	
}
