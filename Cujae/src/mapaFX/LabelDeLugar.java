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
	
	public LabelDeLugar(Vertex vLugar){

		this.vLugar = vLugar;
		
		setShape(new Circle(1));
		setStyle("-fx-background-color: white;");
		setPrefSize(2, 2);
		
/*		setOnMouseClicked(new EventHandler<MouseEvent>(){

			public void handle (MouseEvent event){
				
				if (((MapPanelFX) getParent()).esperandoNuevaArista())
					((MapPanelFX) getParent()).devolverVertexAlFormulario(vLugar);
			
			}
		});*/
	}
	
	public void inicializar (){
		
		setLayoutX(getXreal(((Lugar) vLugar.getInfo()).getCoordenadas().getX()) - 1);
		setLayoutY(getYreal(((Lugar) vLugar.getInfo()).getCoordenadas().getY()) - 1);
		
	}

	public Vertex getVertice(){
		return vLugar;
	}
	
	public void seleccionar(){
		setStyle("-fx-background-color: red;");
	}
	public void deseleccionar(){
		setStyle("-fx-background-color: white;");
	}
	
	private double getXreal(double x){

		return x * ((MapPanelFX)getParent()).getWidth() / 15;

	}
	private double getYreal(double y){

		return y * ((MapPanelFX)getParent()).getHeight() / 19;

	}
	
}
