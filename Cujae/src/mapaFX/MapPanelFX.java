package mapaFX;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Node;
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
import logica.Universidad;

public class MapPanelFX extends Pane {

	private Canvas canvas;
	private ILinkedWeightedEdgeNotDirectedGraph grafoMapa;
	private ArrayList<LabelDeLugar> puntos;
	private boolean modoRuta;
	private boolean modoArista;
	private boolean modoEliminarArista;
	private boolean modoNuevoPunto;
	private boolean modoEliminarPunto;
	private boolean seleccionLugaresNormales;
	
    ArrayList<Vertex> verticesSeleccionados;
    LabelDeLugarInteres ultimoLabelSelec;
    private Coordenadas coordNueva;
    
    int cantSeleccionesMax;
    
	public MapPanelFX(ILinkedWeightedEdgeNotDirectedGraph grafoMapa, int x, int y) {

		modoRuta = false;
		modoNuevoPunto = false;
		modoArista = false;
		
		seleccionLugaresNormales = false;
		cantSeleccionesMax = 1;
		ultimoLabelSelec = null;
		
		this.grafoMapa = grafoMapa;
		
		setWidth(x);
		setHeight(y);

		// Crea un nuevo objeto Canvas, establece su tamaño y obtiene el contexto gráfico
		canvas = new Canvas(x, y);
		canvas.setStyle("-fx-background-color: green;");
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.GREEN); //para q haya un fondo provisional

		// "Carga el mapa"
		actualizarMapa();

		setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent event) {

				if (modoNuevoPunto){
					double x = event.getX() * 19 / getHeight();
					double y = event.getY() * 15 / getWidth(); 
					
					coordNueva = new Coordenadas(x, y);
					
					actualizarMapa();
					reseleccionarVertices();
					
					canvas.getGraphicsContext2D().setFill(Color.RED);
					canvas.getGraphicsContext2D().fillOval(event.getX()-2, event.getY()-2, 4, 4);
				}
			}
		});

	}

/*	public void setVerticeSeleccionado(Vertex vLugar){
		verticeSeleccionado = vLugar;
	}
	public Vertex getVerticeSeleccionado(){
		return verticeSeleccionado;
	}*/
	public ArrayList<Vertex> getSeleccion(){
		return verticesSeleccionados;
	}
	public boolean hayCaminoA(Vertex vert){
		
		boolean hayCamino = false;
		
		int cantVert = grafoMapa.getVerticesList().size();
		
		for(int i = 1; i < cantVert && !hayCamino; i++){
			
			if(grafoMapa.pathWithLength(((LinkedGraph)grafoMapa).getVertexIndex(verticesSeleccionados.get(0)) ,
					((LinkedGraph)grafoMapa).getVertexIndex(vert), i))
				hayCamino = true;
		}
		return hayCamino;
	}

	public LabelDeLugarInteres getLabel(int pos){
		return getLabel(verticesSeleccionados.get(pos));
	}
	
	public void agregarSeleccion(Vertex vert){
		if (!verticesSeleccionados.contains(vert))
			verticesSeleccionados.add(vert);
	}
	public void removerSeleccion(Vertex vert){
		if (verticesSeleccionados.contains(vert))
			verticesSeleccionados.remove(vert);
	}
	public boolean puedeAgregarSeleccion(){
		return (verticesSeleccionados.size() < cantSeleccionesMax);
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
	public void actualizarMapa(){
		
		vaciarPanel();
		
		LinkedList<Vertex> lugares = grafoMapa.getVerticesList();
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
	
	public LabelDeLugarInteres getLabel(Vertex vert){
		
		LabelDeLugarInteres label = null;
		int cant = getChildrenUnmodifiable().size();
		
		for (int i = 0; i < cant; i++){
			
			Node nodo = getChildrenUnmodifiable().get(i);
			
			if (nodo instanceof LabelDeLugarInteres)
				if (((LabelDeLugarInteres)nodo).getVertice().equals(vert)){
					label = ((LabelDeLugarInteres)nodo);
					i = cant;
				}
		}
		return label;
	}
	
	private void vaciarPanel(){
		
		getChildren().clear();
		canvas.getGraphicsContext2D().clearRect(0, 0, getWidth(), getHeight());
		
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
	
	public void reseleccionarVertices(){
		
		int cant = puntos.size();
		int cantEncontrada = 0;
		
		for (int i = 0; i < cant; i ++){
			
			if (verticesSeleccionados.contains(puntos.get(i).getVertice())){
				cantEncontrada ++;
				puntos.get(i).seleccionar();
				if (cantEncontrada == verticesSeleccionados.size())
					i = cant; // salida del bucle
			}
		}
			
	}
	
	
	// Modo Nuevo Punto
	public void activarModoNuevoPunto(){
		modoNuevoPunto = true;
		seleccionLugaresNormales = true;
		cantSeleccionesMax = 4;	
	}
	public void desactivarModoNuevoPunto(){
		modoNuevoPunto = false;
		seleccionLugaresNormales = false;
		cantSeleccionesMax = 1;
		coordNueva = null;
	}
	public boolean getModoNuevoPunto(){
		return modoNuevoPunto;
	}
	public Coordenadas getCoordNueva(){
		return coordNueva;
	}
	
	// Modo Eliminar Punto
	public void activarModoEliminarPunto(){
		modoEliminarPunto = true;
		seleccionLugaresNormales = true;
	}
	public void desactivarModoEliminarPunto(){
		modoEliminarPunto = true;
		seleccionLugaresNormales = true;
	}
	public boolean getModoEliminarPunto;
	
	
	
	// Modo Arista
	public void activarModoArista(){
		
		seleccionLugaresNormales = true;
		cantSeleccionesMax = 2;
	}
	public void desactivarModoArista(){
		
		seleccionLugaresNormales = false;
		cantSeleccionesMax = 1;
		actualizarMapa();
	}
	public boolean getModoArista(){
		return modoArista;
	}
	// SubModo Eliminar Arista
	public void activarModoEliminarArista(){
		modoEliminarArista = true;
		activarModoArista();
	}
	public void desactivarModoEliminarArista(){
		modoEliminarArista = false;
		desactivarModoArista();
	}
	public boolean getModoEliminarArista(){
		return modoEliminarArista;
	}
	public boolean esAdyacenteA(Vertex vert){
		
		return (grafoMapa.areAdjacents(((LinkedGraph)grafoMapa).getVertexIndex(verticesSeleccionados.get(0)),
				((LinkedGraph)grafoMapa).getVertexIndex(vert)));
	}
	
	
	
	// Modo Ruta
	public void activarModoRuta(){	
		
		modoRuta = true;;
		cantSeleccionesMax = 2;
	}
	public void desactivarModoRuta(){
		
		modoRuta = false;
		cantSeleccionesMax = 1;
		actualizarMapa();
	}
	public boolean getModoRuta(){
		return modoRuta;
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
