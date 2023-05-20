package auxiliar;

import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class Movimiento {

	Direccion direccion;
	Vertex verticeApuntado;
	
	public Movimiento(Direccion direccion, Vertex verticeApuntado ){
		
		this.direccion = direccion;
		this.verticeApuntado = verticeApuntado;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Vertex getVerticeApuntado() {
		return verticeApuntado;
	}

	public void setVerticeApuntado(Vertex verticeApuntado) {
		this.verticeApuntado = verticeApuntado;
	}
	
}
