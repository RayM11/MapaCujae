package logica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import auxiliar.Direccion;
import auxiliar.Movimiento;

public class Visitante {

	private Vertex verticeActual;
	private ArrayList<Movimiento> movimientos;
	private ILinkedWeightedEdgeNotDirectedGraph mapa;


	Visitante(Vertex verticeActual, ILinkedWeightedEdgeNotDirectedGraph mapa){

		this.verticeActual = verticeActual;
		this.mapa = mapa;
		movimientos = new ArrayList<Movimiento>();

		actualizarMovimientos();
	}

	public Vertex getVerticeActual() {
		return verticeActual;
	}
	public void setVerticeActual(Vertex verticeActual) {
		this.verticeActual = verticeActual;
	}
	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(ArrayList<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	public Lugar getLugarActual (){
		return (Lugar)verticeActual.getInfo();
	}


	public boolean moverse(Direccion direccion){

		boolean movidoConExito = false;

		for (int i = 0; i < movimientos.size() && !movidoConExito; i++)
			if (movimientos.get(i).getDireccion().equals(direccion)){
				verticeActual = movimientos.get(i).getVerticeApuntado();
				actualizarMovimientos();
				movidoConExito = true;
			}

		return movidoConExito;
	}

	public void invertirMovimientos(){

		for (Movimiento mov : movimientos){

			switch (mov.getDireccion().ordinal()){

			case 0:
				mov.setDireccion(Direccion.S);
				break;
			case 1:
				mov.setDireccion(Direccion.N);
				break;
			case 2:
				mov.setDireccion(Direccion.O);
				break;
			case 3:
				mov.setDireccion(Direccion.E);
				break;		
			}
		}
	}

	private void actualizarMovimientos (){

		movimientos.clear();

		LinkedList<Vertex> adyacentes = mapa.adjacentsG(((LinkedGraph) mapa).getVertexIndex(verticeActual));
		Iterator<Vertex> iter = adyacentes.iterator();	

		while (iter.hasNext()){

			Vertex vAnalizado = (Vertex) iter.next();
			List<Direccion> dirs = ((Lugar)verticeActual.getInfo()).getCoordenadas().direccionHacia(((Lugar)vAnalizado.getInfo()).getCoordenadas());

			int movAct = 0;
			while (hayMovConDir(dirs.get(movAct)))
				movAct++;

			movimientos.add(new Movimiento(dirs.get(movAct), vAnalizado));

		}
	}
	private boolean hayMovConDir(Direccion dir){
		boolean hay = false;

		for (int i = 0; i < movimientos.size() && !hay; i++){
			if (movimientos.get(i).getDireccion().equals(dir))
				hay = true;
		}
		return hay;
	}

}