package auxiliar;

import java.util.Iterator;
import java.util.LinkedList;

import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class Dijkstra {

	public static LinkedList<MarcadorDijkstra> dijkstra(ILinkedWeightedEdgeNotDirectedGraph mapa, Vertex partida) throws Exception{

		LinkedList<Vertex> verticesVisitados = new LinkedList<Vertex>();
		LinkedList<Vertex> verticesNoVisitados = mapa.getVerticesList();

		LinkedList<MarcadorDijkstra> secuenciaDijkstra = new LinkedList<MarcadorDijkstra>();

		secuenciaDijkstra.addFirst(new MarcadorDijkstra(partida, null, 0));

		while(!verticesNoVisitados.isEmpty()){

			double menorDist = Double.MAX_VALUE;
			Vertex anterior = partida;
			Edge edgeActual = null;

			Iterator<MarcadorDijkstra> iterMarc = secuenciaDijkstra.iterator();

			while(iterMarc.hasNext()){

				MarcadorDijkstra marcador = iterMarc.next();
				LinkedList<Edge> edges = null;
				
				if(marcador.getMenorArco() != null)
					edges = marcador.getMenorArco().getVertex().getEdgeList();
					
				
				else
					edges = marcador.getVerticeAnterior().getEdgeList();
				
				Iterator<Edge> iterEdge = edges.iterator();
					
					while(iterEdge.hasNext()){

						Edge edge = iterEdge.next();
						double distActual = (double) ((WeightedEdge)edge).getWeight() + marcador.getDistancia();

						if(distActual < menorDist && !verticesVisitados.contains(edge.getVertex())){

							menorDist = distActual;
							anterior = marcador.getMenorArco().getVertex();
							edgeActual = edge;

						}
					}

			}
			
			if(menorDist == Double.MAX_VALUE)
				throw new Exception("No es posible acceder a todos los lugares del mapa.");
			
			verticesVisitados.addLast(anterior);
			verticesNoVisitados.remove(anterior);

			secuenciaDijkstra.addFirst(new MarcadorDijkstra(anterior, edgeActual, menorDist));

		}

		return secuenciaDijkstra;
	}

}
