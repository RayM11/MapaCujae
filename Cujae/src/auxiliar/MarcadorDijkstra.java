package auxiliar;

import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class MarcadorDijkstra implements Comparable<MarcadorDijkstra>{
	
	private Vertex verticeAnterior;
	private double distancia;
	
	public Vertex getVerticeAnterior() {
		return verticeAnterior;
	}
	
	public double getDistancia() {
		return distancia;
	}
	public MarcadorDijkstra(Vertex verticeAnterior, double distancia) {
		this.verticeAnterior = verticeAnterior;
		this.distancia = distancia;
	}
	
	@Override
	public int compareTo(MarcadorDijkstra otro) {
		int comp = 0;
		if (this.distancia < otro.distancia) {
			comp = -1;
		} else if (this.distancia > otro.distancia) {
			comp = 1;
		}
		return comp;

	}
	
}
