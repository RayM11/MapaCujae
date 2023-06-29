package logica;

import java.util.ArrayList;

public class Cafeteria extends LugarDeInteres {

	private static final long serialVersionUID = 4L;
	private ArrayList<String> productos;
	
	public Cafeteria(String id, double x, double y, String nombre, String descripcion,
			String anotaciones, ArrayList<String> productos) {
		
		super(id, x, y, nombre, descripcion, anotaciones);
		this.productos = productos;
	}

	public ArrayList<String> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<String> productos) {
		this.productos = productos;
	}
	
	

}
