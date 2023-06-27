package logica;

public class LugarDeInteres extends Lugar{

	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String descripcion;
	protected String anotaciones;
	
	public LugarDeInteres(String id, double x, double y, String nombre, String descripcion, String anotaciones) {
		super(id, x, y);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.anotaciones = anotaciones;
	}
	
	public String getAnotaciones() {
		return anotaciones;
	}
	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
