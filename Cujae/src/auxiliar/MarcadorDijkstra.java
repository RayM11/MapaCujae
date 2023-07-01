package auxiliar;

import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class MarcadorDijkstra implements Comparable<MarcadorDijkstra>{
	
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
	
	@Override
    public int compareTo(MarcadorDijkstra otro) {
        return Double.compare(this.distancia, otro.distancia);
    }
	
}
