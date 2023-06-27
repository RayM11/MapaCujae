package logica;

public class Cafeteria extends LugarDeInteres {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ofertas;
	
	public Cafeteria(String id, double x, double y, String nombre, String descripcion,
			String anotaciones, String ofertas) {
		
		super(id, x, y, nombre, descripcion, anotaciones);
		this.ofertas = ofertas;
	}

	public String getOfertas() {
		return ofertas;
	}

	public void setOfertas(String ofertas) {
		this.ofertas = ofertas;
	}
	
	

}
