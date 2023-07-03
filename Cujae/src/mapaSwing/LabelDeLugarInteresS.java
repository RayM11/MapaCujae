package mapaSwing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logica.Lugar;
import logica.Universidad;
import auxiliar.Convert;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class LabelDeLugarInteresS extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 491602899465117228L;
	private static String fotoI = "src/texturas/marcadorLI.png";
	private static String fotoISelect = "src/texturas/marcadorSelectLI.png";
	private static int tamano = 30;

	private Vertex vLugar;

	public LabelDeLugarInteresS(final Vertex vLugar) throws HeadlessException {

		this.vLugar = vLugar; 

		setIcon(Convert.rezizarImagen(fotoI, tamano, tamano));				

		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(java.awt.event.MouseEvent event) {

				// El mapa está en modo de Añadir nuevo punto (este lugar es una posible conexión)
				if(((MapPanelSwing)getParent()).getModoNuevoPunto()){			

					// Este Lugar está lleno (tiene más de 3 conexiones)
					if (vLugar.getAdjacents().size() > 3){
						//Mensaje de error
						JOptionPane.showMessageDialog(null, "No es posible unir el punto con un lugar que ya tiene 4 caminos (el máximo). Pruebe otro punto");

						// Este lugar es una conexión válida pero ya estaba seleccionado    
					}else if (((MapPanelSwing)getParent()).getSeleccion().contains(vLugar)){

						deseleccionar();

						// Este lugar es una conexión válida y no estaba seleccionado	
					}else if(((MapPanelSwing)getParent()).puedeAgregarSeleccion()){

						seleccionar();
					}
					else{
						JOptionPane.showMessageDialog(null, "No es posible unir más de 4 lugares con el mismo punto. Desmarque alguno si desea cambiarlo");
					}
					event.consume();

					// El mapa está en modo Arista
				}else if (((MapPanelSwing)getParent()).getModoArista()){

					// El Lugar ya está seleccionado
					if (((MapPanelSwing)getParent()).getSeleccion().contains(vLugar)){

						deseleccionar();

						// El lugar se puede agregar
					}else if(((MapPanelSwing)getParent()).puedeAgregarSeleccion()){

						if (((MapPanelSwing)getParent()).getSeleccion().isEmpty())
							seleccionar();

						// Si tiene que eliminar la arista primero comprueba que existe
						else if (((MapPanelSwing)getParent()).getModoEliminarArista()){
							if (((MapPanelSwing)getParent()).esAdyacenteA(vLugar)){
								seleccionar();
								getParent().repaint();
							}else{
								JOptionPane.showMessageDialog(null, "Debe seleccionar 2 puntos que estén unidos por un camino para poder eliminarlo");
							}
							// Si tiene que agregar primero comprueba que no existe
						}else if (!((MapPanelSwing)getParent()).esAdyacenteA(vLugar)){
							// Este Lugar está lleno (tiene más de 3 conexiones)
							if (vLugar.getAdjacents().size() > 3){
								//Mensaje de error
								JOptionPane.showMessageDialog(null, "No es posible unir el punto con un lugar que ya tiene 4 caminos (el máximo). Pruebe otro punto");
							}else{
								seleccionar();
								getParent().repaint();	
							}
						}else{
							JOptionPane.showMessageDialog(null, "Debe seleccionar 2 puntos que no estén unidos por un camino para poder aagregarlo");
						}			

						// Ya no se puede agregar otro, así q devuelve un error;	
					}else{
						JOptionPane.showMessageDialog(null, "No puede seleccionar más de 2 puntos. Desmarque otro primero si desea cambiar la arista");
					}

					// El mapa está en Modo Ruta	
				}else if (((MapPanelSwing)getParent()).getModoRuta()){

					// El lugar ya está seleccionado
					if (((MapPanelSwing)getParent()).getSeleccion().contains(vLugar)){

						deseleccionar();

						// Si todavía hay otra selección debe haber una ruta, así que actualiza el mapa
						if (((MapPanelSwing)getParent()).getSeleccion().size() == 1){
							((MapPanelSwing)getParent()).removerRutaADibujar();
							getParent().repaint();
						}

						// Si no hay ningún otro lugar seleccionado lo selecciona simplemente
					}else if (((MapPanelSwing)getParent()).getSeleccion().isEmpty()){
						seleccionar();		

						// Si es el 2do y hay camino desde el primero
					}else if (((MapPanelSwing)getParent()).hayCaminoA(vLugar)){
						try {
							LinkedList<Vertex> ruta = Universidad.getCujae().buscarCaminoMasCorto(((MapPanelSwing)getParent()).getSeleccion().get(0), vLugar);
							((MapPanelSwing)getParent()).asignarRutaADibujar(ruta);
							getParent().repaint();

							// Si ya hay un 2do seleccionado lo deselecciona
							if (((MapPanelSwing)getParent()).getSeleccion().size() == 2)
								((MapPanelSwing)getParent()).deseleccionarLabel(1);

							seleccionar();
						} catch (Exception e) {
							e.printStackTrace();
						}

						// Si no hay un camino hacia este lugar desde el inicial	
					}else{
						JOptionPane.showMessageDialog(null, "No hay ningún posible camino entre esos 2 puntos");					
					}

					// Estado normal de seleccion única (eliminación, modificación, selección)
				}else{

					if (((MapPanelSwing)getParent()).getSeleccion().contains(vLugar))
						deseleccionar();

					else if (((MapPanelSwing)getParent()).puedeAgregarSeleccion())
						seleccionar();
					else {
						((MapPanelSwing)getParent()).deseleccionarLabel(0);
						seleccionar();
					}
				}
			}

			@Override
			public void mouseEntered(java.awt.event.MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseExited(java.awt.event.MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

			}

			@Override
			public void mousePressed(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(java.awt.event.MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});	

	}

	public Vertex getVertice(){
		return vLugar;
	}

	public void seleccionar (){

		setIcon(Convert.rezizarImagen(fotoISelect, tamano, tamano));
		((MapPanelSwing)getParent()).agregarSeleccion(vLugar);
		getParent().repaint();
		repaint();
		// Llamar al llenado de la info
	}
	public void deseleccionar(){

		setIcon(Convert.rezizarImagen(fotoI, tamano, tamano));
		((MapPanelSwing)getParent()).removerSeleccion(vLugar);
		getParent().repaint();
		repaint();
		//limpiar el panel de la info
	}

	public int getXreal(){

		return (int) Math.round((((Lugar)vLugar.getInfo()).getCoordenadas().getX() / 13 * 660)) - getIcon().getIconWidth()/2;
	}
	public int getYreal(){

		return (int) Math.round((1045 - ((Lugar)vLugar.getInfo()).getCoordenadas().getY() / 19 * 1045) - getIcon().getIconHeight()/2);

	}

}
