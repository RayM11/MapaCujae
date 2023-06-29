package logica;

import java.util.ArrayList;

public class Cafeteria extends Lugar {

	private static final long serialVersionUID = 4L;
	private ArrayList<String> productos;



	public Cafeteria(String id, double x, double y, String fotoNorte,
			String fotoSur, String fotoEste, String fotoOeste,
			ArrayList<String> productos) {
		super(id, x, y, fotoNorte, fotoSur, fotoEste, fotoOeste);
		this.productos = new ArrayList<String>() ;
	}

	public ArrayList<String> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<String> productos) {
		this.productos = productos;
	}





}