package visual;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import logica.LugarDeInteres;

public class LabelDeLugar extends Label {

	private static ImageView iconoNormal = new ImageView( new Image("fotos/lugarG (1).png"));
	private static ImageView iconoSelec = new ImageView( new Image ("fotos/lugarRojo(1)"));
	private LugarDeInteres lugar;
	
	public LabelDeLugar(LugarDeInteres lugar){
		
		this.lugar = lugar;
		setLayoutX(lugar.getCoordenadas().getX());
		setLayoutY(lugar.getCoordenadas().getY());
		
		setGraphic(iconoNormal);
		
		setOnMouseClicked(new EventHandler<MouseEvent>(){
			
			public void handle (MouseEvent event){
				
				if (!((MapPanelFX) getParent()).esperandoDestino())
					for (Node node : getParent().getChildrenUnmodifiable()){
						if (node instanceof LabelDeLugar)
							((LabelDeLugar)node).deseleccionar();
					}
				else{
					//--> 	Llama a la función del distra con el ((MapPanelFX) getParent()).getLugarSeleccionado y el lugar de este label
					//--> 	Le pasa el resultado a ((MapPanelFX) getParent()).dibujarRuta(listaDeVerticesDelCaminoMasCorto)
					((MapPanelFX) getParent()).desactivarSeleccionDestino();
				}
				seleccionar();
			}
		});	
	}
	
	public void seleccionar(){
		setGraphic(iconoSelec);
		((MapPanelFX)getParent()).setLugarSeleccionado(lugar);
		//-->	 llamar a la función del panel de información para que se rellene con la info del lugar seleccionado
	}
	public void deseleccionar(){
		setGraphic(iconoNormal);
	}
	
	
	
}
