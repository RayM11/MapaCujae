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

		this.pov = Direccion.E;
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
	/** Devuelve el lugar donde se encuentra el visitante actualmente :v */
	public Lugar getLugarActual (){
		return (Lugar)verticeActual.getInfo();
	}

	/**
	 *	Devuelve el nombre de la foto del lugar actual en la dirección del punto de vista del visitante
	 **/
	public String getFotoPOV(){

		return((Lugar) verticeActual.getInfo()).getFotoDir(pov);

	}

	/**
	 * Mueve el vertice actual en una de las direcciones, en caso de recibir una dirección para la que no tenga un movimiento devolverá false.
	 * 
	 * */
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

	/**
	 * Rota el punto de vista del visitante en sentido horario (en el orden de las manecillas del reloj). Actualiza las direcciones de los
	 * movimientos para adaptarse a la rotación.
	 * 
	 * */
	public void rotarPOVSentidoHorario(){

		for (Movimiento mov : movimientos){
			rotarMovSentidoAntiHorario(mov);		
		}

		rotarPOVSentidoHorario();
	}

	private void rotarMovSentidoHorario(Movimiento mov) {

		switch (mov.getDireccion().ordinal()){

		case 0:
			mov.setDireccion(Direccion.E);
			break;
		case 1:
			mov.setDireccion(Direccion.O);
			break;
		case 2:
			mov.setDireccion(Direccion.S);
			break;
		case 3:
			mov.setDireccion(Direccion.N);
			break;		
		}
	}

	/**
	 * Rota el punto de vista del visitante en sentido antihorario (en el orden opuesto a las manecillas del reloj). Actualiza las
	 * direcciones de los movimientos para adaptarse a la rotación.
	 * 
	 * */
	public void rotarPOVSentidoAntiHorario(){

		for (Movimiento mov : movimientos){
			rotarMovSentidoHorario(mov);		
		}

		rotarPOVSentidoAntiHorario();
	}

	private void rotarMovSentidoAntiHorario(Movimiento mov) {

		switch (mov.getDireccion().ordinal()){

		case 0:
			mov.setDireccion(Direccion.O);
			break;
		case 1:
			mov.setDireccion(Direccion.E);
			break;
		case 2:
			mov.setDireccion(Direccion.N);
			break;
		case 3:
			mov.setDireccion(Direccion.S);
			break;		
		}

	}

	/** Rota una dirección específica en sentido horario	*/
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

	/** Rota una dirección específica en sentido antihorario	*/
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

	/**
	 * Actualiza los movimientos disponibles del visitante según el vertice actual en que se encuentra. Se usa internamente en la función moverse. 
	 * */
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

	/** Comprueba si el visitante ya tiene un movimiento en la dirección especificada. Se usa para asegurse de que no hayan varios movimientos en
	 * la misma dirección al actualizar los movimientos disponibles*/
	private boolean hayMovConDir(Direccion dir){
		boolean hay = false;

		for (int i = 0; i < movimientos.size() && !hay; i++){
			if (movimientos.get(i).getDireccion().equals(dir))
				hay = true;
		}
		return hay;
	}

	/** Hace las rotaciones necesarias para que los movimientos actualizados estén en función del punto de vista actual del visitante */
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
					rotarMovSentidoAntiHorario(mov);
			}
		}
	}
}

