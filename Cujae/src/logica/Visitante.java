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

	private Direccion pov;
	private Vertex verticeActual;
	private ArrayList<Movimiento> movimientos;
	private ILinkedWeightedEdgeNotDirectedGraph mapa;


	Visitante(Vertex verticeActual, ILinkedWeightedEdgeNotDirectedGraph mapa){

		this.pov = Direccion.N;
		this.verticeActual = verticeActual;
		this.mapa = mapa;
		movimientos = new ArrayList<Movimiento>();

		actualizarMovimientos();
	}

	public Direccion getPov() {
		return pov;
	}

	public void setPov(Direccion pov) {
		this.pov = pov;
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
	
	public String getFotoPOV(){
		
		return((Lugar) verticeActual.getInfo()).getId() + pov.toString().substring(0,1);
		
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

	public void rotarPOVSentidoHorario(){

		for (Movimiento mov : movimientos){

			rotarDirSentidoHorario(mov.getDireccion());		
		}

		rotarDirSentidoHorario(pov);
	}

	public void rotarPOVSentidoAntiHorario(){

		for (Movimiento mov : movimientos){

			rotarDirSentidoAntiHorario(mov.getDireccion());		
		}

		rotarDirSentidoAntiHorario(pov);
	}

	private void rotarDirSentidoHorario(Direccion dir){

		switch (dir.ordinal()){

		case 0:
			dir = Direccion.E;
			break;
		case 1:
			dir = Direccion.O;
			break;
		case 2:
			dir = Direccion.S;
			break;
		case 3:
			dir = Direccion.N;
			break;		
		}
	}

	private void rotarDirSentidoAntiHorario(Direccion dir){

		switch (dir.ordinal()){

		case 0:
			dir = Direccion.O;
			break;
		case 1:
			dir = Direccion.E;
			break;
		case 2:
			dir = Direccion.N;
			break;
		case 3:
			dir = Direccion.S;
			break;		
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
		
		adaptarAlPOV();
	}

	private boolean hayMovConDir(Direccion dir){
		boolean hay = false;

		for (int i = 0; i < movimientos.size() && !hay; i++){
			if (movimientos.get(i).getDireccion().equals(dir))
				hay = true;
		}
		return hay;
	}

	private void adaptarAlPOV(){

		if (pov != Direccion.N){

			int cantRotaciones = 0;

			switch (pov.ordinal()){
			case 1:
				cantRotaciones = 2;
				break;
			case 2:
				cantRotaciones = 1;
				break;
			case 3:
				cantRotaciones = 3;
			}
			for (Movimiento mov : movimientos){

				for (int i = 0; i < cantRotaciones; i++)
					rotarDirSentidoHorario(mov.getDireccion());
			}
		}
	}
	
}

