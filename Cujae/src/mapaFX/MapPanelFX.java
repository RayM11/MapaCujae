package mapaFX;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javax.swing.*;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import logica.Coordenadas;
import logica.Lugar;
import logica.LugarDeInteres;

public class MapPanelFX extends Pane {

	private Canvas canvas;
	private ArrayList<LabelDeLugar> puntos;
	private Vertex verticeSeleccionado;
	private boolean destinoDeRuta;
	private boolean nuevoPunto;
	private boolean nuevaArista;


	public MapPanelFX(ILinkedWeightedEdgeNotDirectedGraph grafoMapa, int x, int y) {

		destinoDeRuta = false;
		nuevoPunto = false;
		nuevaArista = false;
		verticeSeleccionado = null;
		setWidth(x);
		setHeight(y);

		// Crea un nuevo objeto Canvas, establece su tamaño y obtiene el contexto gráfico
		canvas = new Canvas(x, y);
		canvas.setStyle("-fx-background-color: green;");
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.GREEN); //para q haya un fondo provisional

		// "Carga el mapa"
		actualizarMapa(grafoMapa);

		setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {

				if (nuevoPunto){
					double x = event.getX() * 19 / getHeight();
					double y = event.getY() * 12 / getWidth(); 

					Coordenadas coord = new Coordenadas(x, y);
					//llamar a formulario pasandole las coordenadas
					desactivarNuevoPunto();

				}
			}
		});

	}

	public void setVerticeSeleccionado(Vertex vLugar){
		verticeSeleccionado = vLugar;
	}
	public Vertex getVerticeSeleccionado(){
		return verticeSeleccionado;
	}

	public void devolverVertexAlFormulario(Vertex verticeAUnir){

		// llamar a alguna función del vormulario pasandole el certice recibido
	}

	public void dibujarRuta(LinkedList<Vertex> vertices){

		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setLineWidth(2);
		gc.setStroke(Color.RED);

		Iterator<Vertex> iter = vertices.iterator();

		Coordenadas inicio = ((Lugar)iter.next().getInfo()).getCoordenadas();

		while (iter.hasNext()){

			Coordenadas fin = ((Lugar)iter.next().getInfo()).getCoordenadas();
			gc.strokeLine(inicio.getX(), inicio.getY(), fin.getX(), fin.getY());
			inicio = fin;

		}
	}
	public void actualizarMapa(ILinkedWeightedEdgeNotDirectedGraph mapa){
		
		LinkedList<Vertex> lugares = mapa.getVerticesList();
		Iterator<Vertex> iter = lugares.iterator();

		while (iter.hasNext()){

			Vertex verticeActual = (Vertex) iter.next();
			dibujarAristas(verticeActual);

			LabelDeLugar labelActual;
			
			if (verticeActual.getInfo() instanceof LugarDeInteres){
				labelActual = new LabelDeLugarInteres( verticeActual);
				// agrega el lugarDeInteres a la lista
				puntos.add(labelActual);
				
			}else{
				// agrega el lugar a la lista
				labelActual = new LabelDeLugar(verticeActual);
				puntos.add(labelActual);
			}
			// agrega el lugar (de interes o no) al canvas
			getChildren().addAll(canvas, labelActual);

		}
		
	}

	private void dibujarAristas(Vertex vertice) {
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setLineWidth(1);
		gc.setStroke(Color.WHITE);

		LinkedList<Edge> aristas = vertice.getEdgeList();
		Iterator<Edge> iter = aristas.iterator();

		while (iter.hasNext()){
			Edge aristaActual = iter.next();
			Coordenadas inicio = ((Lugar)vertice.getInfo()).getCoordenadas();
			Coordenadas fin = ((Lugar)aristaActual.getVertex().getInfo()).getCoordenadas();

			gc.strokeLine(inicio.getX(), inicio.getY(), fin.getX(), fin.getY());
		}   
	}
	
	

	public void activarSeleccionDestino(){
		destinoDeRuta = true;
	}
	public void desactivarSeleccionDestino(){
		destinoDeRuta = false;
	}
	public boolean esperandoDestino(){
		return destinoDeRuta;
	}
	public void activarNuevoPunto(){
		nuevoPunto = true;
	}
	public void desactivarNuevoPunto(){
		nuevoPunto = false;
	}
	public boolean esperandoNuevoPunto(){
		return nuevoPunto;
	}
	public void activarNuevaArista(){
		nuevaArista = true;
	}
	public void desactivarNuevaArista(){
		nuevaArista = false;
	}
	public boolean esperandoNuevaArista(){
		return nuevaArista;
	}


	// Método para obtener el componente compatible con swing
	public JComponent getComponenteDeSwing() {
		JFXPanel fxPanel = new JFXPanel();
		fxPanel.setScene(new javafx.scene.Scene(this));
		return fxPanel;
	}


	/*		COMO AÑADIR ESTE PANEL A UN PANEL DE SWING
	 * 
	 * 		JPanel panelMapa = new JPanel();
	 *		MapPanel mapPanel = new MapPanel(¨el grafo del mapa¨, tamaño x, tamaño y);
	 *		swingPanel.add(mapPanel.getComponenteDeSwing());
	 *		
	 * */
}
