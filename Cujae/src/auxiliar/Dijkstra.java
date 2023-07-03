package auxiliar;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class Dijkstra {

	public static LinkedList<Vertex> sacarOrdenDeLugares(ILinkedWeightedEdgeNotDirectedGraph mapa, Vertex partida, Vertex objetivo){

		LinkedList<Vertex> caminoMasCorto = new LinkedList<Vertex>();
		
		if(!mapa.isEmpty()){
			Deque<Vertex> pila = new ArrayDeque<Vertex>();
			ArrayList<MarcadorDijkstra> dijkstraList = dijkstra(mapa, partida);

			Vertex vertexActual = objetivo;
			pila.push(vertexActual);
			while (!vertexActual.equals(partida)) {

				Vertex verticeAnterior = null;
				double menorDistancia = Double.MAX_VALUE;

				Iterator<Vertex> iter = vertexActual.getAdjacents().iterator();
				while(iter.hasNext()) {
					
					Vertex vertexAdy = iter.next();
					
					for (MarcadorDijkstra m : dijkstraList) {
						if (m.getVerticeAnterior().equals(vertexAdy) && m.getDistancia() < menorDistancia) {
							verticeAnterior = vertexAdy;
							menorDistancia = m.getDistancia();
						}
					}
				}

				pila.push(verticeAnterior);
				vertexActual = verticeAnterior;
			}

			
			while (!pila.isEmpty()) {
				caminoMasCorto.addLast(pila.pop());
			}
		}
		
		return caminoMasCorto;

	}

	public static ArrayList<MarcadorDijkstra> dijkstra(ILinkedWeightedEdgeNotDirectedGraph mapa, Vertex partida){

		ArrayList<MarcadorDijkstra> dijkstraList = new ArrayList<>();

		if(!mapa.isEmpty()){

			HashMap<Vertex, Double> distanciaHash = new HashMap<>();

			Iterator<Vertex> iter = mapa.getVerticesList().iterator();
			while(iter.hasNext()){

				Vertex v = iter.next();
				distanciaHash.put(v, Double.MAX_VALUE);

			}

			distanciaHash.put(partida, (double) 0);
			ArrayList<Vertex> noVisitados = new ArrayList<Vertex>(mapa.getVerticesList());

			while (!noVisitados.isEmpty()) {

				Vertex vertexActual = null;
				double distanciaMinima = Integer.MAX_VALUE;

				for (Vertex v : noVisitados) {
					double d = distanciaHash.get(v);
					if (d < distanciaMinima) {
						vertexActual = v;
						distanciaMinima = d;
					}
				}

				noVisitados.remove(vertexActual);

				Iterator<Edge> iterEdges = vertexActual.getEdgeList().iterator();
				while(iterEdges.hasNext()) {
					Edge e = iterEdges.next();
					Vertex verticeAdy = e.getVertex();
					if (noVisitados.contains(verticeAdy)) {
						double nuevaDist = distanciaHash.get(vertexActual) + (double)((WeightedEdge) e).getWeight();
						if (nuevaDist < distanciaHash.get(verticeAdy)) {
							distanciaHash.put(verticeAdy, nuevaDist);
						}
					}
				}

				dijkstraList.add(new MarcadorDijkstra(vertexActual, distanciaHash.get(vertexActual)));

			}
		}

		return dijkstraList;

	}


}
