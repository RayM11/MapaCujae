package logica;

import java.util.ArrayList;

public class Cafeteria extends LugarDeInteres {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;;
	private ArrayList<String> productos;
	
	public Cafeteria(String id, double x, double y, String nombre, String descripcion,
			String anotaciones) {
		
		super(id, x, y, nombre, descripcion, anotaciones);
	}

	public ArrayList<String> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<String> ofertas) {
		this.productos = ofertas;
	}
	
	public void anadirProducto(String oferta){
		productos.add(oferta);
	}
	
	public void limpiarProductos(){
		productos.clear();
	}

}
