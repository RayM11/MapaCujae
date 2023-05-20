package logica;

public class LugarDeInteres extends Lugar{

	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private String anotaciones;
	
	public LugarDeInteres(String id, float x, float y, String foto, String nombre, String descripcion) {
		super(id, x, y, foto);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.anotaciones = "";
	}
/*	public LugarDeInteres(String id, float x, float y, String foto, String nombre, String descripcion, String anotaciones){
		super(id, x, y, foto);
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.anotaciones = anotaciones;
	}
	*/
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
	
	
	
}
