package logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;

public class Universidad {

	private static Universidad cujae = null;
	private File datGrafo;
	private ILinkedWeightedEdgeNotDirectedGraph mapa;
	private GeneralTree<Object> arbolDecision;

	private Universidad(){

		datGrafo = new File("data/grafo.dat");
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

	private ArrayList<Facultad> listaFacultades(){
		ArrayList<Facultad> facultades = new ArrayList<Facultad>() ;

		Iterator<Vertex> iterador = mapa.getVerticesList().iterator();

		while(iterador.hasNext()) {
			if(iterador.next().getInfo() instanceof Facultad) {
				facultades.add((Facultad)iterador.next().getInfo());
			}
		}

		return facultades;
	}


	private void agregarFacultadesAlArbol(BinaryTreeNode<Object> nodoPadre ) {
		ArrayList<Object> facultades = new ArrayList<Object>();

		facultades.addAll(listaFacultades());

		insertarHijosAUnNodo(nodoPadre, facultades);


	}



	private void agregarCafeteriasAlArbol(BinaryTreeNode<Object> nodoPadre ) {
		ArrayList<Object> productosExistentes =  new ArrayList<Object>();
		productosExistentes.addAll(listaProductosExistentes());

		if(!productosExistentes.isEmpty()) {

			insertarHijosAUnNodo(nodoPadre,productosExistentes); // Se le inserta al nodo "Cafeteria" como hijos los productos existentes

			ArrayList<BinaryTreeNode<Object>>  nodosProductos = (ArrayList<BinaryTreeNode<Object>>) arbolDecision.getSons(nodoPadre);

			for(int i = 0; i < nodosProductos.size(); i ++) {
				ArrayList<Object> cafeterias =  new ArrayList<Object>();
				cafeterias.addAll(cafeteriasConProductoEspecificado(((String)nodosProductos.get(i).getInfo())));
				insertarHijosAUnNodo(nodosProductos.get(i),cafeterias);  // A cada nodo de "Producto" se le inserta como hijos las cafeterias que lo tienen
			}
		}

	}

	public ArrayList<Object> tomaDecision(String lugar) {
		ArrayList<Object> listaADevolver = new ArrayList<Object>();


		InBreadthIterator<Object> iterador = arbolDecision.inBreadthIterator();

		boolean encontrado = false;

		while(iterador.hasNext() && !encontrado ) {

			BinaryTreeNode<Object> nodoActual = (BinaryTreeNode<Object>) iterador.nextNode();

			if(lugar.equalsIgnoreCase("Facultad")) {
				if(((String)nodoActual.getInfo()).equalsIgnoreCase(lugar)) {
					listaADevolver = (ArrayList<Object>)arbolDecision.getSonsInfo(nodoActual); // devuelve lista de facultades
					encontrado = true;
				}
			}
			else if(lugar.equalsIgnoreCase("Cafeteria")) {
				if(((String)nodoActual.getInfo()).equalsIgnoreCase(lugar)) {
					listaADevolver = (ArrayList<Object>) (arbolDecision.getSonsInfo(nodoActual)) ;  // devuelve lista de productos existentes
					encontrado = true;
				}	

			}

		}


		return  listaADevolver;

	}

	public ArrayList<Object> obtenerCafeteriasPorProductoDesdeElArbol(String producto){ // como el arbol es de objeto el getSonsInfo devuelve una lista de objeto, cuando se utilice el metodo se debe castear a Caferteria
		ArrayList<Object> cafeteriasADevolver = new ArrayList<Object>();


		GeneralTree<Object> arbolAuxiliar = new GeneralTree<Object>();

		arbolAuxiliar.setRoot(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight());

		boolean encontrado = false;

		InBreadthIterator<Object> iterador = arbolAuxiliar.inBreadthIterator();

		BinaryTreeNode<Object> nodoActual;

		while(iterador.hasNext() && ! encontrado) {
			nodoActual = iterador.nextNode();
			if(((String) nodoActual.getInfo()).equalsIgnoreCase(producto)) {
				encontrado = true;
				cafeteriasADevolver = (ArrayList<Object>) arbolAuxiliar.getSonsInfo(nodoActual);

			}

		}

		return cafeteriasADevolver;
	}

	private void insertarHijosAUnNodo(BinaryTreeNode<Object> nodo, ArrayList<Object> hijos) {

		for(int i = 0; i < hijos.size(); i ++) {
			BinaryTreeNode<Object> hijoActual = new BinaryTreeNode<Object>(hijos.get(i));
			arbolDecision.insertNode(hijoActual, nodo);
		}

	}

	@SuppressWarnings({ })
	private ArrayList<Cafeteria> cafeteriasConProductoEspecificado(String producto){
		ArrayList<Cafeteria> listaCafeteriasADevolver = new ArrayList<Cafeteria>();

		Iterator<Vertex> iterador = mapa.getVerticesList().iterator();
		Vertex verticeActual;

		while(iterador.hasNext()) {
			verticeActual = iterador.next();

			if(verticeActual.getInfo() instanceof Cafeteria) {

				if(((Cafeteria) verticeActual.getInfo()).getProductos().contains(producto)) {
					listaCafeteriasADevolver.add((Cafeteria) verticeActual.getInfo());
				}

			}

		}

		return listaCafeteriasADevolver;
	}

	private ArrayList<String> listaProductosExistentes(){    
		ArrayList<String> listaProductos = new ArrayList<String>();

		Iterator<Vertex> iterador = mapa.getVerticesList().iterator();

		while(iterador.hasNext()) {
			if(iterador.next().getInfo() instanceof Cafeteria) {
				transferirProductos(listaProductos,((Cafeteria)iterador.next().getInfo()).getProductos());		
			}
		}

		return listaProductos;
	}

	public void insertarFacultadEnArbol(Facultad facultad) {

		BinaryTreeNode<Object> nodo = new BinaryTreeNode<Object>(facultad);

		arbolDecision.insertNode(nodo, ((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft());

	}

	public void insertarCafeteriaEnElArbol(Cafeteria cafeteria) {
		agregarProductosNuevos(cafeteria,(ArrayList<Object>)arbolDecision.getSonsInfo(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight()));
		agregarCafeteriaNueva(cafeteria, (ArrayList<BinaryTreeNode<Object>>) arbolDecision.getSons(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight()));

	}

	private void agregarProductosNuevos(Cafeteria cafeteria,ArrayList<Object> productos){


		for(int i = 0; i < cafeteria.getProductos().size(); i ++) {
			if(!productos.contains(cafeteria.getProductos().get(i))) {
				BinaryTreeNode<Object> nuevoProducto = new BinaryTreeNode<Object>(cafeteria.getProductos().get(i));
				arbolDecision.insertNode(nuevoProducto,((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight() );
			}
		}


	}

	private void agregarCafeteriaNueva(Cafeteria cafeteria, ArrayList<BinaryTreeNode<Object>> productos) {


		for(int i = 0; i < productos.size(); i ++) {
			BinaryTreeNode<Object> nodoActual = productos.get(i);

			if(cafeteria.getProductos().contains(((String) nodoActual.getInfo()))) { // si la cafeteria contiene al producto actual, entonces se le agrega la cafeteria como nuevo hijo de ese producto
				BinaryTreeNode<Object> nuevaCafeteria = new BinaryTreeNode<Object>(cafeteria);
				arbolDecision.insertNode(nuevaCafeteria , nodoActual);
			}
		}

	}

	private void transferirProductos(ArrayList<String> listaA, ArrayList<String> listaB) { // este metodo pasa para listaA 
		// lo que esta en listaB y no en listaA
		for(int i = 0; i < listaB.size(); i ++) {
			if(!listaA.contains(listaB.get(i))) {
				listaA.add(listaB.get(i));
			}
		}
	}

	//	public ArrayList<Cafeteria> listaCafeterias(){
	//	ArrayList<Cafeteria> cafeterias = new ArrayList<Cafeteria>() ;
	//
	//	Iterator<Vertex> iterador = mapa.getVerticesList().iterator();
	//
	//	while(iterador.hasNext()) {
	//		if(iterador.next().getInfo() instanceof Cafeteria) {
	//			cafeterias.add((Cafeteria)iterador.next().getInfo());
	//		}
	//	}
	//
	//	return cafeterias;
	//}

	//	@SuppressWarnings({ "unused", "null" })
	//	private void agregarCafeteriasAlArbol(BinaryTreeNode<Object> nodoPadre ) {
	//		ArrayList<Cafeteria> cafeterias = listaCafeterias();
	//		if(!cafeterias.isEmpty()) {
	//			BinaryTreeNode<Object> nodoActual = null ;
	//
	//			for(int i = 0; i < cafeterias.size(); i ++) {
	//				nodoActual.setInfo(cafeterias.get(i));
	//				arbolDecision.insertNode(nodoActual, nodoPadre);
	//			}
	//		}
	//
	//	}

	//	@SuppressWarnings("unchecked")
	//	public ArrayList<Cafeteria> cafeteriasConProductoEspecificado(String producto){
	//		ArrayList<Cafeteria> listaCafeteriasADevolver = new ArrayList<Cafeteria>();
	//		
	//		ArrayList<Object> cafeteriasExistentes = 
	//				(ArrayList<Object>) arbolDecision.getSonsInfo(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight());
	//		
	//		for(int i = 0; i < cafeteriasExistentes.size(); i ++) {
	//			if(((Cafeteria) cafeteriasExistentes.get(i)).getProductos().contains(producto)) {
	//				listaCafeteriasADevolver.add((Cafeteria) cafeteriasExistentes.get(i));
	//			}
	//		}
	//		
	//		
	//		return listaCafeteriasADevolver;
	//	}

	//	public ArrayList<String> listaProductosExistentes(ArrayList<Object> cafeterias){
	//		ArrayList<String> listaProductos = new ArrayList<String>();
	//		
	//		for(int i = 0; i < cafeterias.size(); i ++) {
	//			transferirProductos(listaProductos, ((Cafeteria)cafeterias.get(i)).getProductos());
	//		}
	//
	//		return listaProductos;
	//	}

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

	public boolean guardarGrafo(){

		boolean ok = false;

		try {
			OutputStream out = new FileOutputStream(datGrafo);

			if(!mapa.isEmpty()){

				Iterator<Vertex> iter = mapa.getVerticesList().iterator();

				while(iter.hasNext()){

					Vertex v = iter.next();
					int[] conexiones = devolverConexiones(v);
					ConexionesVertex aux = new ConexionesVertex(v.getInfo(), conexiones);

					byte[] arr = Convert.toBytes(aux);
					out.write(Convert.intToBytes(arr.length));
					out.write(arr);

				}
			}

			ok = true;
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean cargarGrafo(){

		boolean ok = false;

		try {
			InputStream in = new FileInputStream(datGrafo);

			if(in.available() > 0){

				ArrayList<int[]> conexionesList = new ArrayList<int[]>();

				while(in.available() > 0){

					byte[] arrTam = new byte[4];
					int tam = Convert.toInt(arrTam);

					byte[] arrCV = new byte[tam];
					in.read(arrCV);
					ConexionesVertex cv = (ConexionesVertex) Convert.toObject(arrCV);
					mapa.insertVertex(cv.getInfo());
					conexionesList.add(cv.getIndexConecciones());
				}

				for(int i = 0; i < conexionesList.size(); i++){

					int[] conexiones = conexionesList.get(i);
					conectarVertice(i, conexiones);

				}

				ok = true;
			}
			in.close();


		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}


		return ok;
	}

	private void conectarVertice(int indexVertex, int[] conexiones){

		for(int i = 0; i < conexiones.length; i++){

			if(!contieneEdge(indexVertex, conexiones[i]))
				agregarCamino(indexVertex, conexiones[i], distanciaPorIndices(indexVertex, conexiones[i]));

		}

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

	private double distanciaPorIndices(int index1, int index2){

		Lugar l1 = (Lugar) mapa.getVerticesList().get(index1).getInfo();
		Lugar l2 = (Lugar) mapa.getVerticesList().get(index2).getInfo();

		return l1.calcularDistanciaA(l2);

	}

	private boolean contieneEdge(int posVertex, int posAdy){

		boolean contiene = false;

		if(!mapa.isEmpty()){
			LinkedList<Vertex> adyacentes = mapa.getVerticesList().get(posVertex).getAdjacents();
			Iterator<Vertex> iter = adyacentes.iterator();

			while(iter.hasNext() && !contiene){

				Vertex v = iter.next();
				int indexV = ((LinkedGraph)mapa).getVertexIndex(v);
				if(posAdy == indexV)
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

	public boolean agregarCamino(Lugar lu1, Lugar lu2){

		int indice1 = indiceDeLugar(lu1);
		int indice2 = indiceDeLugar(lu2);

		return agregarCamino(indice1, indice2, lu1.calcularDistanciaA(lu2));
	}

	public boolean agregarCamino(int indice1, int indice2, double distancia){

		boolean exito = false;

		if (indice1 != -1 && indice2 != -1){

			mapa.insertWEdgeNDG(indice1, indice2, distancia);
			exito = true;

		}

		return exito;

	}

	public int indiceDeLugar(Lugar lu){

		int index = -1;
		int cont = 0;
		Iterator<Vertex> iter = mapa.getVerticesList().iterator();

		while (iter.hasNext()){

			Lugar luActual = (Lugar) iter.next().getInfo();
			if (luActual.equals(lu))
				index = cont;
			else
				cont++;
		}

		return index;


	}





}
