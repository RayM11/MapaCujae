package visual;
import javafx.embed.swing.JFXPanel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javax.swing.*;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
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
    private LugarDeInteres lugarSeleccionado;
    private boolean destinoDeRuta;

    public MapPanelFX(LinkedGraph mapa) {
    	
    	destinoDeRuta = false;
    	lugarSeleccionado = null;
    	
        // Crea un nuevo objeto Canvas, establece su tamaño y obtiene el ccontexto gráfico
        canvas = new Canvas(800, 600);
        canvas.setStyle("-fx-background-color: white;");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GREEN); //para q halla un fondo provisional
        
        // """""""Carga el mapa"""""""
        LinkedList<Vertex> lugares = mapa.getVerticesList();
        Iterator<Vertex> iter = lugares.iterator();
        
        while (iter.hasNext()){
        	
        	Vertex verticeActual = (Vertex) iter.next();
        	dibujarAristas(verticeActual);
        	
        	if (verticeActual.getInfo() instanceof LugarDeInteres){
        		
        		LabelDeLugar labelActual = new LabelDeLugar((LugarDeInteres) verticeActual.getInfo());
        		// agrega el lugar a la lista
        		puntos.add(labelActual);
        		// agrega el lugar al canvas
        		getChildren().addAll(canvas, labelActual);
        	}
        }              
    }
   
    public void setLugarSeleccionado(LugarDeInteres lugar){
    	lugarSeleccionado = lugar;
    }
    public LugarDeInteres getLugarSeleccionado(){
    	return lugarSeleccionado;
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
    
    public void dibujarAristas(Vertex vertice) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(2);
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

    // Método para obtener el componente compatible con swing
    public JComponent getComponenteDeSwing() {
        JFXPanel fxPanel = new JFXPanel();
        fxPanel.setScene(new javafx.scene.Scene(this));
        return fxPanel;
    }
    
    
    /*		COMO AÑADIR ESTE PANEL A UN PANEL DE SWING
     * 
     * 		JPanel panelMapa = new JPanel();
     *		MapPanel mapPanel = new MapPanel(¨el grafo del mapa¨);
	 *		swingPanel.add(mapPanel.getComponenteDeSwing());
	 *		
     * 		
     * 
     * 
     * */
}
