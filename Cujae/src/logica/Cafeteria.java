package logica;

import java.util.ArrayList;

import auxiliar.OfertaCafeteria;

public class Cafeteria extends LugarDeInteres {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<OfertaCafeteria> ofertas;
	
	public Cafeteria(String id, double x, double y, String nombre, String descripcion,
			String anotaciones) {
		
		super(id, x, y, nombre, descripcion, anotaciones);
	}

	public ArrayList<OfertaCafeteria> getOfertas() {
		return ofertas;
	}

	public void setOfertas(ArrayList<OfertaCafeteria> ofertas) {
		this.ofertas = ofertas;
	}
	
	public void anadirOferta(OfertaCafeteria oferta){
		ofertas.add(oferta);
	}

}
