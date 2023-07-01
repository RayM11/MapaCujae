package mapaSwing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Coordenadas;
import logica.Lugar;
import logica.LugarDeInteres;
import logica.Universidad;
import mapaFX.LabelDeLugar;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class mapPanelSwing extends JPanel {

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

	private ArrayList<LabelDeLugarS> puntos;
	ArrayList<Vertex> verticesSeleccionados;
	private LinkedList<Vertex> rutaADibujar;
	private Coordenadas coordNueva;



	public mapPanelSwing() {

		modoRuta = false;
		modoArista = false;
		modoEliminarArista = false;
		modoNuevoPunto = false;
		modoEliminarPunto = false;
		seleccionLugaresNormales = false;
		cantSeleccionesMax = 1;

		puntos = new ArrayList<LabelDeLugarS>();
		verticesSeleccionados = new ArrayList<Vertex>();
		rutaADibujar = new LinkedList<Vertex>();
		coordNueva = null;

		setLayout(null);
		setBackground(Color.GREEN);

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
	public boolean puedeAgregarSeleccion(){
		return (verticesSeleccionados.size() < cantSeleccionesMax);
	}

	//------------------------------- Métodos de control -------------------------------------

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
		//	repaint();						????????????????????????????
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

		agregarLugares();
		
		reseleccionarVertices();

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

	private void agregarLugares (){

		limpiarLugares();

		LinkedList<Vertex> lugares = Universidad.getCujae().getMapa().getVerticesList();
		Iterator<Vertex> iter = lugares.iterator();

		while(iter. hasNext()){

			Vertex vertAct = iter.next();

			if (vertAct.getInfo() instanceof LugarDeInteres){
				LabelDeLugarInteresS label = new LabelDeLugarInteresS(vertAct);
				add(label);
				puntos.add(label);
				label.ubicar();
			}else{
				LabelDeLugarS label = new LabelDeLugarS(vertAct);
				add(label);
				puntos.add(label);
				label.ubicar();
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

	// --------------------------------- Métodos auxiliares --------------------------------

	public void reseleccionarVertices(){

		if (!verticesSeleccionados.isEmpty()){
			int cant = puntos.size();
			int cantEncontrada = 0;

			for (int i = 0; i < cant; i ++){

				if (verticesSeleccionados.contains(puntos.get(i).getVertice())){
					cantEncontrada ++;
					puntos.get(i).seleccionar();
					if (cantEncontrada == verticesSeleccionados.size())
						i = cant; // salida del bucle
				}
			}
		}
	}

	private int getXreal(Vertex vert){

		return (int) Math.round(((Lugar)vert.getInfo()).getCoordenadas().getX() * getParent().getWidth() / 15);

	}
	private int getYreal(Vertex vert){

		return (int) (getParent().getWidth()/1.5 - Math.round(((Lugar)vert.getInfo()).getCoordenadas().getY() * getParent().getHeight() / 19));

	}

}
