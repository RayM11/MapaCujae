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
import auxiliar.InicializacionesGrafo;
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
	private GeneralTree<Object> arbolDecision;

	private Universidad(){
		datGrafo = new File("data/grafo.dat");
		//Esto va a ser lo que se ponga al final, pero por ahora se trabajara con las inicializaciones
		//cargarGrafo();

		mapa = InicializacionesGrafo.inicializarLugares();
		inicializarArbol();


	}


	public ILinkedWeightedEdgeNotDirectedGraph getMapa(){
		return mapa;
	}


	public void inicializarArbol() {

		arbolDecision = new GeneralTree<Object>(new BinaryTreeNode<Object>("Inicio"));
		((BinaryTreeNode<Object>)arbolDecision.getRoot()).setLeft(new BinaryTreeNode<Object>("Facultad"));
		((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().setRight(new BinaryTreeNode<Object>("Cafeteria"));

		agregarFacultadesAlArbol(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft());
		agregarCafeteriasAlArbol(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight());

	}


	private ArrayList<Object> listaFacultadesEnMapa(){

		ArrayList<Object> facultades = new ArrayList<Object>() ;

		if(!mapa.isEmpty()){

			Iterator<Vertex> iterador = mapa.getVerticesList().iterator();

			while(iterador.hasNext()) {

				Lugar lugar = (Lugar) iterador.next().getInfo(); 

				if(lugar instanceof Facultad) {
					facultades.add(lugar);
				}
			}
		}

		return facultades;
	}


	private ArrayList<String> listaProductosExistentesEnMapa(){    

		ArrayList<String> listaProductos = new ArrayList<String>();

		if(!mapa.isEmpty()){

			Iterator<Vertex> iterador = mapa.getVerticesList().iterator();

			while(iterador.hasNext()) {

				Lugar lugar = (Lugar) iterador.next().getInfo();

				if(lugar instanceof Cafeteria) {
					transferirProductos(listaProductos,((Cafeteria)lugar).getProductos());			
				}
			}
		}
		return listaProductos;
	}


	private ArrayList<Object> cafeteriasConProductoEspecificadoEnMapa(String producto){

		ArrayList<Object> listaCafeteriasADevolver = new ArrayList<Object>();

		if(!mapa.isEmpty()){

			Iterator<Vertex> iterador = mapa.getVerticesList().iterator();
			while(iterador.hasNext()) {
				Vertex verticeActual = iterador.next();

				if(verticeActual.getInfo() instanceof Cafeteria) {
					if(((Cafeteria) verticeActual.getInfo()).getProductos().contains(producto)) {
						listaCafeteriasADevolver.add(verticeActual.getInfo());
					}
				}
			}
		}
		return listaCafeteriasADevolver;
	}


	private void agregarFacultadesAlArbol(BinaryTreeNode<Object> nodoPadre ) {

		ArrayList<Object> facultades = listaFacultadesEnMapa();

		insertarHijosAUnNodo(nodoPadre, facultades);


	}


	private void agregarCafeteriasAlArbol(BinaryTreeNode<Object> nodoPadre ) {
		ArrayList<Object> productosExistentes =  new ArrayList<Object>();

		for(String string:listaProductosExistentesEnMapa())
			productosExistentes.add(string);

		if(!productosExistentes.isEmpty()) {

			insertarHijosAUnNodo(nodoPadre,productosExistentes); // Se le inserta al nodo "Cafeteria" como hijos los productos existentes

			ArrayList<BinaryTreeNode<Object>>  nodosProductos = (ArrayList<BinaryTreeNode<Object>>) arbolDecision.getSons(nodoPadre);

			for(int i = 0; i < nodosProductos.size(); i ++) {
				ArrayList<Object> cafeterias =  cafeteriasConProductoEspecificadoEnMapa((String)nodosProductos.get(i).getInfo());
				insertarHijosAUnNodo(nodosProductos.get(i),cafeterias);  // A cada nodo de "Producto" se le inserta como hijos las cafeterias que lo tienen
			}
		}

	}


	private void insertarHijosAUnNodo(BinaryTreeNode<Object> nodo, ArrayList<Object> hijos) {

		for(int i = 0; i < hijos.size(); i ++) {
			BinaryTreeNode<Object> hijoActual = new BinaryTreeNode<Object>(hijos.get(i));
			arbolDecision.insertNode(hijoActual, nodo);
		}

	}


	/** Este metodo pasa para listaA lo que esta en listaB y no en listaA **/
	private void transferirProductos(ArrayList<String> listaA, ArrayList<String> listaB) { 

		for(int i = 0; i < listaB.size(); i ++) {
			if(!listaA.contains(listaB.get(i))) {
				listaA.add(listaB.get(i));
			}
		}
	}


	public ArrayList<String> obtenerFacultadesDeArbol(){

		ArrayList<String> facultades = new ArrayList<String>();

		if(!arbolDecision.isEmpty()){

			BinaryTreeNode<Object> nodoActual = (BinaryTreeNode<Object>) arbolDecision.getRoot();
			if(nodoActual.getLeft()!= null){
				nodoActual = nodoActual.getLeft();
				if(nodoActual.getLeft() != null)
					for(Object facultad:arbolDecision.getSonsInfo(nodoActual))
						facultades.add(((Facultad) facultad).getNombre());
			}

		}

		return facultades;

	}


	public ArrayList<String> obtenerListaDeProductosDelArbol(){

		ArrayList<String> cafeterias = new ArrayList<String>() ;

		if(!arbolDecision.isEmpty()){

			BinaryTreeNode<Object> nodoActual = (BinaryTreeNode<Object>) arbolDecision.getRoot();
			if(nodoActual.getLeft() != null){
				nodoActual = nodoActual.getLeft();
				if(nodoActual.getRight() != null){
					nodoActual = nodoActual.getRight();
					for(Object producto: arbolDecision.getSonsInfo(nodoActual))
						cafeterias.add((String) producto);
				}

			}

		}
		return cafeterias;

	}


	/** Como el arbol es de objeto el getSonsInfo devuelve una lista de Object, cuando se utilice el metodo se debe castear a Caferteria **/
	public ArrayList<String> obtenerCafeteriasPorProductoDesdeElArbol(String producto){ 

		ArrayList<String> cafeteriasADevolver = new ArrayList<String>();

		GeneralTree<Object> arbolAuxiliar = new GeneralTree<Object>(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight());
		boolean encontrado = false;

		if(!arbolAuxiliar.isEmpty()){

			InBreadthIterator<Object> iterador = arbolAuxiliar.inBreadthIterator();
			boolean esCafeteria = false;
			while(iterador.hasNext() && !encontrado && !esCafeteria) {

				BinaryTreeNode<Object> nodoActual = iterador.nextNode();
				if(((String) nodoActual.getInfo()).equalsIgnoreCase(producto)) {
					encontrado = true;
					for(Object cafeteria:arbolAuxiliar.getSonsInfo(nodoActual))
						cafeteriasADevolver.add(((Cafeteria) cafeteria).getNombre());

				}

				if(nodoActual.getInfo() instanceof Cafeteria)
					esCafeteria = true;

			}
		}

		return cafeteriasADevolver;
	}


	public void insertarFacultadEnArbol(Facultad facultad) {

		if(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft()!= null){

			BinaryTreeNode<Object> nodo = new BinaryTreeNode<Object>(facultad);
			arbolDecision.insertNode(nodo, ((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft());
		}

	}


	private void agregarProductosNuevosAlArbol(Cafeteria cafeteria,ArrayList<String> productos){


		for(int i = 0; i < cafeteria.getProductos().size(); i ++) {
			if(!productos.contains(cafeteria.getProductos().get(i))) {
				BinaryTreeNode<Object> nuevoProducto = new BinaryTreeNode<Object>(cafeteria.getProductos().get(i));
				arbolDecision.insertNode(nuevoProducto,((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight() );
			}
		}


	}


	/** si la cafeteria contiene al producto actual, entonces se le agrega la cafeteria como nuevo hijo de ese producto**/
	private void agregarCafeteriaNueva(Cafeteria cafeteria, ArrayList<BinaryTreeNode<Object>> productos) {


		for(int i = 0; i < productos.size(); i ++) {

			BinaryTreeNode<Object> nodoActual = productos.get(i);

			if(cafeteria.getProductos().contains(((String) nodoActual.getInfo()))) { 
				BinaryTreeNode<Object> nuevaCafeteria = new BinaryTreeNode<Object>(cafeteria);
				arbolDecision.insertNode(nuevaCafeteria , nodoActual);
			}
		}

	}


	public void insertarCafeteriaEnElArbol(Cafeteria cafeteria) {
		agregarProductosNuevosAlArbol(cafeteria, obtenerListaDeProductosDelArbol());
		agregarCafeteriaNueva(cafeteria, (ArrayList<BinaryTreeNode<Object>>) arbolDecision.getSons(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight()));

	}




	public boolean eliminarFacultadEnElArbol(String idFacultad) {
		boolean eliminado = false;
		boolean detener = false;
		InDepthIterator<Object> iterador = arbolDecision.inDepthIterator();
		BinaryTreeNode<Object> actual = null;
		BinaryTreeNode<Object> anterior;
		while(iterador.hasNext() && !detener ) {
			anterior = actual;
			actual = iterador.nextNode();
			if(actual.getInfo() instanceof Facultad) {
				if(((Facultad) actual.getInfo()).getId().equalsIgnoreCase(idFacultad)) {
					if(((String)anterior.getInfo()).equalsIgnoreCase("Facultad")) {
						anterior.setLeft(actual.getRight());
					}
					else {
						anterior.setRight(actual.getRight());
					}
					eliminado = true;
					detener = true;
				}
			}
			if(((String)actual.getInfo()).equalsIgnoreCase("Cafeteria")) {
				detener = true;
			}
		}
		return eliminado;
	}
	public void eliminarCafeteriaEnElArbol(String idCafeteria) {
		// El primer parametro es el nodo con info String "Cafeteria"
		eliminaCafeteriaEnTodosNodosProducto(((BinaryTreeNode<Object>)arbolDecision.getRoot()).getLeft().getRight(), idCafeteria);
	}

	//El siguiente metodo va a recibir un nodo producto (que la info es el String nombre de un producto) 
	private void eliminaCafeteriaDadoNodoProducto(BinaryTreeNode<Object> nodoProducto, String idCafeteria) {
		if(nodoProducto.getInfo() instanceof String) {
			GeneralTree<Object> arbolAuxiliar = new GeneralTree<Object>();
			arbolAuxiliar.setRoot(nodoProducto);
			ArrayList<BinaryTreeNode<Object>> cafeterias = (ArrayList<BinaryTreeNode<Object>>) arbolAuxiliar.getSons(nodoProducto);
			boolean detener = false;
			for(int i = 0; i < cafeterias.size() && !detener; i ++) {
				if(cafeterias.get(i).getInfo() instanceof Cafeteria) { // Deberia ser instancia de cafeteria pero pregunto evitando explotes
					if(((Cafeteria)cafeterias.get(i).getInfo()).getId().equalsIgnoreCase(idCafeteria)) {
						if(i == 0) {
							nodoProducto.setLeft(cafeterias.get(i).getRight());
						}
						else {
							cafeterias.get( i - 1).setRight(cafeterias.get(i).getRight());
						}
						detener  = true;
					}
				}
			}
		}
	}


	//El siguiente metodo recibira el nodo Cafeteria (la info es el String Cafeteria) y el id de la cafeteria a eliminar
	//LLamara al metodo anterior en cada uno de los nodos productos (para eliminar en cada uno de ellos la cafeteria con dicho id)
	private void eliminaCafeteriaEnTodosNodosProducto(BinaryTreeNode<Object> nodoCafeteria, String idCafeteria) {
		if(((String)nodoCafeteria.getInfo()).equalsIgnoreCase("Cafeteria")) {
			GeneralTree<Object> arbolAuxiliar = new GeneralTree<Object>();
			arbolAuxiliar.setRoot(nodoCafeteria);
			LinkedList<BinaryTreeNode<Object>> productos = (LinkedList<BinaryTreeNode<Object>>) arbolAuxiliar.getSons(nodoCafeteria);
			Iterator<BinaryTreeNode<Object>> iterador = productos.iterator();
			while(iterador.hasNext()) {
				eliminaCafeteriaDadoNodoProducto(iterador.next(), idCafeteria);
			}
		}
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

	public boolean guardarGrafo(){

		boolean ok = false;

		try {
			File data = new File("data");
			data.mkdir();
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
		mapa = new LinkedGraph();
		File data = new File("data");
		data.mkdir();

		if(!datGrafo.exists())
			extraerDatGrafo();

		try {
			InputStream in = new FileInputStream(datGrafo);

			if(in.available() > 0){

				ArrayList<int[]> conexionesList = new ArrayList<int[]>();

				while(in.available() > 0){

					byte[] arrTam = new byte[4];
					in.read(arrTam);
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


	public void extraerDatGrafo(){

		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("grafo.dat");
			OutputStream outputStream = new FileOutputStream("data/grafo.dat");

			byte[] arr = new byte[1024];
			int bytesLeidos;

			while ((bytesLeidos = inputStream.read(arr)) != -1) {
				outputStream.write(arr, 0, bytesLeidos);
			}
			inputStream.close();
			outputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
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

		return Dijkstra.sacarOrdenDeLugares(mapa, partida, objetivo);
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
