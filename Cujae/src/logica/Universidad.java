package logica;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import auxiliar.ConexionesVertex;
import auxiliar.Convert;
import auxiliar.Dijkstra;
import auxiliar.MarcadorDijkstra;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

public class Universidad {

	private static Universidad cujae = null;
	private File datGrafo;
	private ILinkedWeightedEdgeNotDirectedGraph mapa;
	private Visitante visitante;
	private GeneralTree<Object> arbolDecision;

	private Universidad(String rector){
		datGrafo = new File("Res/grafo.dat");
		mapa = new LinkedGraph();
		arbolDecision = new GeneralTree<Object>();
	}

	public void inicializarArbol(Lugar lugar) {

		if(!(lugar instanceof Facultad) && !(lugar instanceof Cafeteria)) {

			((BinaryTreeNode<Object>) arbolDecision.getRoot()).setInfo(lugar);
			((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().setInfo("Facultad");
			((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight().setInfo("Cafeteria");;

			agregarFacultadesAlArbol(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft());
			agregarCafeteriasAlArbol(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight());

		}
		else {
			throw new IllegalArgumentException("El lugar no debe ser una facultad ni una cafeteria");
		}
	}

	@SuppressWarnings("null")
	public ArrayList<Facultad> listaFacultades(){
		ArrayList<Facultad> facultades = new ArrayList<Facultad>() ;

		Iterator<Vertex> iterador = mapa.getVerticesList().iterator();

		while(iterador.hasNext()) {
			if(iterador.next().getInfo() instanceof Facultad) {
				facultades.add((Facultad)iterador.next().getInfo());
			}
		}

		return facultades;
	}

	public ArrayList<Cafeteria> listaCafeterias(){
		ArrayList<Cafeteria> cafeterias = new ArrayList<Cafeteria>() ;

		Iterator<Vertex> iterador = mapa.getVerticesList().iterator();

		while(iterador.hasNext()) {
			if(iterador.next().getInfo() instanceof Cafeteria) {
				cafeterias.add((Cafeteria)iterador.next().getInfo());
			}
		}

		return cafeterias;
	}

	@SuppressWarnings({ "null", "unused" })
	private void agregarFacultadesAlArbol(BinaryTreeNode<Object> nodoPadre ) {
		ArrayList<Facultad> facultades = listaFacultades();
		if(!facultades.isEmpty()) {
			BinaryTreeNode<Object> nodoActual = null ;

			for(int i = 0; i < facultades.size(); i ++) {
				nodoActual.setInfo(facultades.get(i));
				arbolDecision.insertNode(nodoActual, nodoPadre);
			}
		}

	}


	@SuppressWarnings({ "unused", "null" })
	private void agregarCafeteriasAlArbol(BinaryTreeNode<Object> nodoPadre ) {
		ArrayList<Cafeteria> cafeterias = listaCafeterias();
		if(!cafeterias.isEmpty()) {
			BinaryTreeNode<Object> nodoActual = null ;

			for(int i = 0; i < cafeterias.size(); i ++) {
				nodoActual.setInfo(cafeterias.get(i));
				arbolDecision.insertNode(nodoActual, nodoPadre);
			}
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<Object> tomaDecision(String lugar) {
		ArrayList<Object> listaADevolver = new ArrayList<Object>();
		ArrayList<String> listaProductos = new ArrayList<String>();

		InBreadthIterator<Object> iterador = arbolDecision.inBreadthIterator();

		boolean encontrado = false;

		while(iterador.hasNext() && !encontrado ) {

			BinaryTreeNode<Object> nodoActual = (BinaryTreeNode<Object>) iterador.next();

			if(lugar.equalsIgnoreCase("Facultad")) {
				if(((String)nodoActual.getInfo()).equalsIgnoreCase(lugar)) {
					listaADevolver = (ArrayList<Object>)arbolDecision.getSonsInfo(nodoActual);
					encontrado = true;
				}
			}
			else if(lugar.equalsIgnoreCase("Cafeteria")) {
				if(((String)nodoActual.getInfo()).equalsIgnoreCase(lugar)) {
					listaProductos = listaProductosExistentes((ArrayList<Object>)(arbolDecision.getSonsInfo(nodoActual))) ;
					listaADevolver.addAll(listaProductos);
					encontrado = true;
				}	
				
			}

		}

		return  listaADevolver;

	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cafeteria> cafeteriasConProductoEspecificado(String producto){
		ArrayList<Cafeteria> listaCafeteriasADevolver = new ArrayList<Cafeteria>();
		
		ArrayList<Object> cafeteriasExistentes = 
				(ArrayList<Object>) arbolDecision.getSonsInfo(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight());
		
		for(int i = 0; i < cafeteriasExistentes.size(); i ++) {
			if(((Cafeteria) cafeteriasExistentes.get(i)).getProductos().contains(producto)) {
				listaCafeteriasADevolver.add((Cafeteria) cafeteriasExistentes.get(i));
			}
		}
		
		
		return listaCafeteriasADevolver;
	}
	
	public ArrayList<String> listaProductosExistentes(ArrayList<Object> cafeterias){
		ArrayList<String> listaProductos = new ArrayList<String>();
		
		for(int i = 0; i < cafeterias.size(); i ++) {
			transferirProductos(listaProductos, ((Cafeteria)cafeterias.get(i)).getProductos());
		}

		return listaProductos;
	}

//	public ArrayList<String> listaProductosExistentes(){    // esto era para pbtenerlo desde el grafo 
//		ArrayList<String> listaProductos = new ArrayList<String>();
//
//		Iterator<Vertex> iterador = mapa.getVerticesList().iterator();
//
//		while(iterador.hasNext()) {
//			if(iterador.next().getInfo() instanceof Cafeteria) {
//				transferirProductos(listaProductos,((Cafeteria)iterador.next().getInfo()).getProductos());		
//			}
//		}
//
//		return listaProductos;
//	}

	@SuppressWarnings("unused")
	private void transferirProductos(ArrayList<String> listaA, ArrayList<String> listaB) { // este metodo pasa para listaA 
		                                                                                  // lo que esta en listaB y no en listaA
		for(int i = 0; i < listaB.size(); i ++) {
			if(!listaA.contains(listaB.get(i))) {
				listaA.add(listaB.get(i));
			}
		}
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
