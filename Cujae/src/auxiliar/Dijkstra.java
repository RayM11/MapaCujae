package auxiliar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class Dijkstra {
	
	public static LinkedList<Vertex> sacarOrdenDeLugares(ILinkedWeightedEdgeNotDirectedGraph mapa, Vertex partida, Vertex objetivo){
		
		LinkedList<Vertex> orden = new LinkedList<Vertex>();
		LinkedList<MarcadorDijkstra> djkstr = dijkstra(mapa, partida);
		
		Vertex actual = objetivo;
		Iterator<MarcadorDijkstra> iter = djkstr.iterator();

		while(iter.hasNext()){
			MarcadorDijkstra marcador = iter.next();
			if(marcador.getMenorArco() != null){
				if(marcador.getMenorArco().getVertex().equals(actual)){
					orden.addFirst(marcador.getMenorArco().getVertex());
					actual = marcador.getVerticeAnterior();
				}
			}else
				orden.addFirst(partida);
		}
		
		return orden;
	}

	public static LinkedList<MarcadorDijkstra> dijkstra(ILinkedWeightedEdgeNotDirectedGraph mapa, Vertex partida){

		ArrayList<Vertex> verticesVisitados = new ArrayList<Vertex>();
		verticesVisitados.add(partida);

		PriorityQueue<MarcadorDijkstra> colaPrioridad = new PriorityQueue<MarcadorDijkstra>();
		colaPrioridad.offer(new MarcadorDijkstra(partida, null, 0));

		LinkedList<MarcadorDijkstra> secuenciaDijkstra = new LinkedList<MarcadorDijkstra>();
		secuenciaDijkstra.add(new MarcadorDijkstra(partida, null, 0));

		while (!colaPrioridad.isEmpty()) {
			MarcadorDijkstra marcador = colaPrioridad.poll();


			Iterator<Edge> iter = marcador.getVerticeAnterior().getEdgeList().iterator();
			while (iter.hasNext()) {
				Edge edge = iter.next();
				if (!verticesVisitados.contains(edge.getVertex())) {
					double distActual = marcador.getDistancia() + (double) ((WeightedEdge) edge).getWeight();
					colaPrioridad.offer(new MarcadorDijkstra(marcador.getVerticeAnterior(), edge, distActual));
					verticesVisitados.add(edge.getVertex());
					secuenciaDijkstra.addFirst(new MarcadorDijkstra(marcador.getVerticeAnterior(), edge, distActual));
				}
			}
			
		}

		return secuenciaDijkstra;
	}


}
