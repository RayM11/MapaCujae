package logica;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import auxiliar.Dijkstra;
import auxiliar.MarcadorDijkstra;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class Universidad {

	private static Universidad cujae = null;
	private File datFile;
	private LinkedGraph mapa;
	private Visitante visitante;
	private String rector;

	private Universidad(){
		datFile = new File("grafo.dat");
	}

	public static Universidad getCujae(){

		if(cujae == null)
			cujae = new Universidad();
		return cujae;
	}

	public ArrayList<LugarDeInteres> busquedaLugares(ArrayList<LugarDeInteres> lugaresDI, String fragmento){

		ArrayList<LugarDeInteres> lugaresEncontrados = new ArrayList<LugarDeInteres>();

		for (LugarDeInteres lugarActual : lugaresDI)
			if (lugarActual.getNombre().contains(fragmento))
				lugaresEncontrados.add(lugarActual);

		return lugaresEncontrados;
	}

	public LinkedList<Vertex> rutaMasCorta(Vertex partida, Vertex objetivo){

		LinkedList<Vertex> ruta = new LinkedList<Vertex>();

		return ruta;
	}

	public LinkedList<Vertex> buscarCaminoMasCorto(Vertex partida, Vertex objetivo) throws Exception{

		LinkedList<Vertex> camino = new LinkedList<Vertex>();

		LinkedList<MarcadorDijkstra> dijkstra = Dijkstra.dijkstra(mapa, partida);

		Vertex actual = objetivo;
		Iterator<MarcadorDijkstra> iter = dijkstra.iterator();

		while(iter.hasNext()){
			MarcadorDijkstra marcador = iter.next();
			if(marcador.getMenorArco() != null){
				if(marcador.getMenorArco().getVertex().equals(actual)){
					camino.addFirst(marcador.getMenorArco().getVertex());
					actual = marcador.getVerticeAnterior();
				}
			}else
				camino.addFirst(partida);
		}


		return camino;
	}
}
