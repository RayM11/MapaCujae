package logica;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import auxiliar.ConexionesVertex;
import auxiliar.Convert;
import auxiliar.Dijkstra;
import auxiliar.MarcadorDijkstra;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class Universidad {

	private static Universidad cujae = null;
	private File datGrafo;
	private ILinkedWeightedEdgeNotDirectedGraph mapa;
	private Visitante visitante;

	private Universidad(String rector){

		datGrafo = new File("Res/grafo.dat");
		mapa = new LinkedGraph();
	}

	public static Universidad getCujae(String rector){

		if(cujae == null)
			cujae = new Universidad(rector);
		return cujae;
	}

	public ArrayList<LugarDeInteres> busquedaLugares(ArrayList<LugarDeInteres> lugaresDI, String fragmento){

		ArrayList<LugarDeInteres> lugaresEncontrados = new ArrayList<LugarDeInteres>();

		for (LugarDeInteres lugarActual : lugaresDI)
			if (lugarActual.getNombre().contains(fragmento))
				lugaresEncontrados.add(lugarActual);

		return lugaresEncontrados;
	}

	public boolean guardarGrafo(){

		boolean ok = false;

		try {
			RandomAccessFile raf = new RandomAccessFile(datGrafo, "rw");
			raf.setLength(0);

			raf.writeInt(mapa.getVerticesList().size());
			if(!mapa.isEmpty()){

				Iterator<Vertex> iter = mapa.getVerticesList().iterator();

				while(iter.hasNext()){

					Vertex v = iter.next();
					int[] conexiones = devolverConexiones(v);
					ConexionesVertex aux = new ConexionesVertex(v.getInfo(), conexiones);

					byte[] arr = Convert.toBytes(aux);
					raf.writeInt(arr.length);
					raf.write(arr);

				}
			}

			ok = true;
			raf.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean cargarGrafo(){

		boolean ok = false;

		try {
			RandomAccessFile raf = new RandomAccessFile(datGrafo, "r");

			if(raf.length()>0){

				int total = raf.readInt();
				int cont = 0;

				while(cont < total){

					byte[] arrCV = new byte[raf.readInt()];
					raf.read(arrCV);
					ConexionesVertex cv = (ConexionesVertex) Convert.toObject(arrCV);
					mapa.insertVertex(cv.getInfo());
					cont++;
				}

				cont = 0;
				raf.seek(4);

				while(cont < total){

					byte[] arrCV = new byte[raf.readInt()];
					raf.read(arrCV);
					ConexionesVertex cv = (ConexionesVertex) Convert.toObject(arrCV);

					int[] conexiones = cv.getIndexConecciones();
					Lugar l1 = (Lugar) cv.getInfo();

					for(int i = 0; i < conexiones.length; i++){

						if(!contieneEdge(cont, mapa.getVerticesList().get(conexiones[i]))){
							Coordenadas l2 = ((Lugar) mapa.getVerticesList().get(conexiones[i]).getInfo()).getCoordenadas();
							mapa.insertWEdgeNDG(cont, conexiones[i], l1.calcularDistanciaA(l2.getX(), l2.getY()));
						}
					}
					cont++;
				}

				ok = true;
				raf.close();

			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}


		return ok;
	}

	private int[] devolverConexiones(Vertex vertex){


		LinkedList<Vertex> adyacentes = vertex.getAdjacents();
		int[] conexiones = new int[adyacentes.size()];

		if(adyacentes.size() > 0){

			Iterator<Vertex> iter = adyacentes.iterator();
			int cont = 0;

			while(iter.hasNext()){

				Vertex v = iter.next();
				conexiones[cont] = ((LinkedGraph) mapa).getVertexIndex(v);
				cont++;

			}
		}

		return conexiones;

	}

	private boolean contieneEdge(int posVertex, Object info){

		boolean contiene = false;

		if(!mapa.isEmpty()){
			LinkedList<Vertex> adyacentes = mapa.getVerticesList().get(posVertex).getAdjacents();
			Iterator<Vertex> iter = adyacentes.iterator();

			while(iter.hasNext() && !contiene){
				Object obj = iter.next().getInfo();
				if(obj.equals(info))
					contiene = true;
			}
		}

		return contiene;
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
