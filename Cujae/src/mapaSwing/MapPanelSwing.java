package mapaSwing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import auxiliar.Convert;
import logica.Coordenadas;
import logica.Lugar;
import logica.LugarDeInteres;
import logica.Universidad;
import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class MapPanelSwing extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4582889386851627008L;

	private boolean modoRuta;
	private boolean modoArista;
	private boolean modoEliminarArista;
	private boolean modoNuevoPunto;
	private boolean modoEliminarPunto;
	private boolean seleccionLugaresNormales;
	int cantSeleccionesMax;

	private ArrayList<JLabel> puntos;
	ArrayList<Vertex> verticesSeleccionados;
	private LinkedList<Vertex> rutaADibujar;
	private Coordenadas coordNueva;



	public MapPanelSwing() {

		modoRuta = false;
		modoArista = false;
		modoEliminarArista = false;
		modoNuevoPunto = false;
		modoEliminarPunto = false;
		seleccionLugaresNormales = false;
		cantSeleccionesMax = 1;

		puntos = new ArrayList<JLabel>();
		verticesSeleccionados = new ArrayList<Vertex>();
		rutaADibujar = new LinkedList<Vertex>();
		coordNueva = null;

		setLayout(null);
		setBackground(Color.GREEN);

		actualizarLugares();
		repaint();

		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent event) {

				if (modoNuevoPunto){

					Point click = event.getPoint();

					coordNueva = new Coordenadas(getXcoord(click), getYcoord(click));

					repaint();
				}
			}
		});


		activarModoRuta();

	}
	//------------------------------ Métodos de selección -----------------------------------
	public ArrayList<Vertex> getSeleccion(){
		return verticesSeleccionados;
	}
	public void agregarSeleccion(Vertex vert){
		if (!verticesSeleccionados.contains(vert))
			verticesSeleccionados.add(vert);
	}
	public void removerSeleccion(Vertex vert){
		if (verticesSeleccionados.contains(vert))
			verticesSeleccionados.remove(vert);
	}

	//------------------------------- Métodos de control -------------------------------------

	public boolean puedeAgregarSeleccion(){
		return (verticesSeleccionados.size() < cantSeleccionesMax);
	}
	public boolean puedeSeleccionarNormales(){
		return seleccionLugaresNormales;
	}

	// Modo Nuevo Punto
	public void activarModoNuevoPunto(){
		modoNuevoPunto = true;
		seleccionLugaresNormales = true;
		cantSeleccionesMax = 4;	
	}
	public void desactivarModoNuevoPunto(){
		modoNuevoPunto = false;
		seleccionLugaresNormales = false;
		cantSeleccionesMax = 1;
		coordNueva = null;
		repaint();
	}
	public boolean getModoNuevoPunto(){
		return modoNuevoPunto;
	}
	public Coordenadas getCoordNueva(){
		return coordNueva;
	}

	// Modo Eliminar Punto
	public void activarModoEliminarPunto(){
		modoEliminarPunto = true;
		seleccionLugaresNormales = true;
	}
	public void desactivarModoEliminarPunto(){
		modoEliminarPunto = false;
		seleccionLugaresNormales = false;
		repaint();
	}
	public boolean getModoEliminarPunto(){
		return modoEliminarPunto;
	}


	// Modo Arista
	public void activarModoArista(){

		seleccionLugaresNormales = true;
		cantSeleccionesMax = 2;
	}
	public void desactivarModoArista(){

		seleccionLugaresNormales = false;
		cantSeleccionesMax = 1;
		repaint();						
	}
	public boolean getModoArista(){
		return modoArista;
	}
	// SubModo Eliminar Arista
	public void activarModoEliminarArista(){
		modoEliminarArista = true;
		activarModoArista();
	}
	public void desactivarModoEliminarArista(){
		modoEliminarArista = false;
		desactivarModoArista();
		repaint();
	}
	public boolean getModoEliminarArista(){
		return modoEliminarArista;
	}


	// Modo de Ruta 
	public void activarModoRuta(){	
		modoRuta = true;;
		cantSeleccionesMax = 2;
	}
	public void desactivarModoRuta(){
		modoRuta = false;
		cantSeleccionesMax = 1;
		repaint();
	}
	public boolean getModoRuta(){
		return modoRuta;
	}
	public void asignarRutaADibujar(LinkedList<Vertex> ruta){
		rutaADibujar = ruta;
	}
	public void removerRutaADibujar(){
		rutaADibujar = new LinkedList<Vertex>();
	}


	//------------------------------- Métodos de dibujo ---------------------------
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		dibujarTodasLasAristas(g2d);

		if (rutaADibujar.size() != 0)
			dibujarRuta(g2d);

		if (coordNueva != null)
			dibujarPuntoNuevo(g2d);
	}

	public void dibujarTodasLasAristas(Graphics g2d){

		LinkedList<Vertex> vertices = Universidad.getCujae().getMapa().getVerticesList();

		for (Vertex vert : vertices){
			dibujarAristas(vert, g2d);
		}
	}

	public void dibujarAristas(Vertex vert, Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.setStroke(new BasicStroke(2));

		LinkedList<Edge> aristas = vert.getEdgeList();
		Iterator<Edge> iter = aristas.iterator();

		while (iter.hasNext()){
			Edge aristaActual = iter.next();

			g2d.drawLine(getXreal(vert), getYreal(vert), getXreal(aristaActual.getVertex()), getYreal(aristaActual.getVertex()));
		}        
	}

	public void dibujarRuta(Graphics g){

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.setStroke(new BasicStroke(2));

		Iterator<Vertex> iter = rutaADibujar.iterator();

		Vertex vert = iter.next();

		int iniX = getXreal(vert);
		int iniY = getYreal(vert);

		while (iter.hasNext()){

			vert = iter.next();

			int finX = getXreal(vert);
			int finY = getYreal(vert);
			g2d.drawLine(iniX, iniY, finX, finY);
			iniX = finX;
			iniY = finY;

		}
	}

	public void dibujarPuntoNuevo(Graphics g){

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);

		int xPunto = getXreal(coordNueva) -15;
		int yPunto = getYreal(coordNueva) -15;
		
		g2d.drawImage(Convert.resizarURLImage(MapPanelSwing.class.getResource("/texturas/marcadorNuevo.png"), 30, 30), xPunto, yPunto, null);

		
		for (Vertex vert : verticesSeleccionados){
			
			g2d.drawLine(getXreal(coordNueva), getYreal(coordNueva), getXreal(vert), getYreal(vert));
					
		}

	}


	// ------------------------ Métodos de Actualización de componentes ----------------------

	public void actualizarLugares(){

		limpiarLugares();

		agregarLugares();

	//	reseleccionarVertices();
	}

	public void reseleccionarVertices(){

		if (!verticesSeleccionados.isEmpty()){
			int cant = puntos.size();
			int cantEncontrada = 0;

			for (int i = 0; i < cant; i ++){

				if(puntos.get(i) instanceof LabelDeLugarS)
					if (verticesSeleccionados.contains(((LabelDeLugarS)(puntos.get(i))).getVertice())){
						cantEncontrada ++;
						((LabelDeLugarS)(puntos.get(i))).seleccionar();

					}else if (verticesSeleccionados.contains(((LabelDeLugarInteresS)(puntos.get(i))).getVertice())){
						cantEncontrada ++;
						((LabelDeLugarInteresS)(puntos.get(i))).seleccionar();

					}if (cantEncontrada == verticesSeleccionados.size())
						i = cant; // salida del bucle
			}
		}
	}

	private void agregarLugares (){

		LinkedList<Vertex> lugares = Universidad.getCujae().getMapa().getVerticesList();
		Iterator<Vertex> iter = lugares.iterator();

		while(iter. hasNext()){

			Vertex vertAct = iter.next();

			if (vertAct.getInfo() instanceof LugarDeInteres){
				LabelDeLugarInteresS label = new LabelDeLugarInteresS(vertAct);
				ubicarLugar(label);
				add(label);
				puntos.add(label);
			}else{
				LabelDeLugarS label = new LabelDeLugarS(vertAct);
				ubicarLugar(label);
				add(label);
				puntos.add(label);
			}			
		}		
	}

	private void limpiarLugares(){
		Component[] componentes = getComponents();
		for (Component c : componentes) 
			if (c instanceof JLabel) {
				remove(c);
				puntos.remove(c);
			}
	}

	private void ubicarLugar(LabelDeLugarS label){

		label.setBounds(label.getXreal(), label.getYreal(), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());

	}
	private void ubicarLugar(LabelDeLugarInteresS label){

		label.setBounds(label.getXreal(), label.getYreal(), label.getIcon().getIconWidth(), label.getIcon().getIconHeight());

	}

	// --------------------------------- Métodos auxiliares ----------------------------------

	public boolean hayCaminoA(Vertex vert){

		boolean hayCamino = false;

		int cantVert = Universidad.getCujae().getMapa().getVerticesList().size();

		for(int i = 1; i < cantVert && !hayCamino; i++){

			if(Universidad.getCujae().getMapa().pathWithLength(((LinkedGraph)Universidad.getCujae().getMapa()).getVertexIndex(verticesSeleccionados.get(0)) ,
					((LinkedGraph)Universidad.getCujae().getMapa()).getVertexIndex(vert), i))
				hayCamino = true;
		}
		return hayCamino;
	}

	public void deseleccionarLabel(int pos){  ///Validaciones requeridas
		deseleccionarLabel(getSeleccion().get(pos));
	}

	public boolean esAdyacenteA(Vertex vert){

		return (Universidad.getCujae().getMapa().areAdjacents(((LinkedGraph)Universidad.getCujae().getMapa()).getVertexIndex(verticesSeleccionados.get(0)),
				((LinkedGraph)Universidad.getCujae().getMapa()).getVertexIndex(vert)));
	}


	public void deseleccionarLabel(Vertex vert){

		Component[] components = getComponents();
		int cant = components.length;

		for (int i = 0; i < cant; i++)
			if (components[i] instanceof LabelDeLugarS){
				if (((LabelDeLugarS)components[i]).getVertice().equals(vert)){
					((LabelDeLugarS)components[i]).deseleccionar();;
					i = cant;
				}
			}
			else if (components[i] instanceof LabelDeLugarInteresS){
				if (((LabelDeLugarInteresS)components[i]).getVertice().equals(vert)){
				    ((LabelDeLugarInteresS)components[i]).deseleccionar();;
					i = cant;
				}
			}
	}

	private int getXreal(Vertex vert){

		return (int) Math.round(((Lugar)vert.getInfo()).getCoordenadas().getX() / 13 * 660);

	}
	private int getXreal(Coordenadas coord){

		return (int) Math.round(coord.getX() / 13 * 660);

	}
	private int getYreal(Vertex vert){

		return (int) Math.round(1045 - ((Lugar)vert.getInfo()).getCoordenadas().getY() / 19 * 1045);

	}
	private int getYreal(Coordenadas coord){

		return (int) Math.round(1045 - coord.getY() / 19 * 1045);

	}
	private double getXcoord(Point punto){

		return  (double) 13 * (( 1.0 * punto.x)/ 660);
	}

	private double getYcoord(Point punto){

		return  (double) 19 * (( 1.0 * 1045 - punto.y)/ 1045);
	}

}
