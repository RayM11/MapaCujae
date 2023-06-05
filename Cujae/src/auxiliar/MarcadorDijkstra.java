package auxiliar;

import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class MarcadorDijkstra {
	
	private Vertex verticeAnterior;
	private Edge menorArco;
	private double distancia;
	
	public Vertex getVerticeAnterior() {
		return verticeAnterior;
	}
	public Edge getMenorArco() {
		return menorArco;
	}
	public double getDistancia() {
		return distancia;
	}
	public MarcadorDijkstra(Vertex verticeAnterior, Edge menorArco, double distancia) {
		this.verticeAnterior = verticeAnterior;
		this.menorArco = menorArco;
		this.distancia = distancia;
	}
	
	
	
}
