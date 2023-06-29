package logica;

public class Facultad extends LugarDeInteres{
	
	private static final long serialVersionUID = 1L;
	
	private String decano;
	
	
	
	public Facultad(String id, double x, double y,String nombre, String descripcion, String anotaciones, String decano) {
		super(id, x, y, nombre, descripcion, anotaciones);
		
		this.decano = decano;
	}
	
	
	
	public String getDecano() {
		return decano;
	}
	public void setDecano(String decano) {
		this.decano = decano;
	}
	

}
